/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import static js.lang.Global.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import jsx.event.Publishable.Start;
import jsx.event.Publishable.Stop;
import kiss.model.ClassUtil;

/**
 * @version 2013/12/11 9:59:17
 */
class Publisher {

    /** The cache for event types. */
    private static final Map<Class, Set<Class<?>>> cache = new HashMap();

    /** The actual listeners holder. */
    private Map<Class, List<Subscriber>> holder;

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event
     */
    void publish(Object event) {
        if (holder != null && event != null) {
            Set<Class<?>> types = cache.computeIfAbsent(event.getClass(), type -> ClassUtil.getTypes(type));

            for (Class type : types) {
                if (holder != null) {
                    List<Subscriber> subscribers = holder.get(type);

                    if (subscribers != null) {
                        for (Subscriber subscriber : subscribers) {
                            subscriber.accept(event);
                        }
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    void register(Subscribable subscribable) {
        if (subscribable != null) {
            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(subscribable.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    Class annotationType = annotation.annotationType();
                    Subscribe[] subscribes = null;

                    if (annotationType == Subscribe.class) {
                        subscribes = new Subscribe[] {(Subscribe) annotation};
                    } else if (annotationType == Subscribes.class) {
                        subscribes = ((Subscribes) annotation).value();
                    }

                    if (subscribes != null) {
                        for (Subscribe subscribe : subscribes) {
                            Class eventType;
                            Method method = entry.getKey();

                            if (method.getParameterTypes().length == 1) {
                                eventType = method.getParameterTypes()[0];
                            } else {
                                eventType = subscribe.value();
                            }

                            Subscriber listener = new Listener(subscribable, method);

                            eventType = ClassUtil.wrap(eventType);

                            if (holder == null) {
                                holder = new HashMap();
                                publish(new Start(Object.class));
                            }

                            List<Subscriber> subscribers = holder.get(eventType);

                            if (subscribers == null) {
                                subscribers = new CopyOnWriteArrayList();
                                holder.put(eventType, subscribers);

                                publish(new Start(eventType));
                            } else {
                                for (Subscriber registered : subscribers) {
                                    if (registered.equals(subscribable, method)) {
                                        return;
                                    }
                                }
                            }

                            // ===========================
                            // Execution Count Wrapper
                            // ===========================
                            int count = subscribe.count();

                            if (0 < count) {
                                listener = new Count(count, this, subscribable, listener);
                            }

                            // ===========================
                            // Timing Related Wrappers
                            // ===========================
                            long time = subscribe.delay();

                            if (0 < time) {
                                // listener = new Delay(time, listener);
                            }

                            time = subscribe.throttle();

                            if (0 < time) {
                                listener = new Throttle(time, listener);
                            }

                            time = subscribe.debounce();

                            if (0 < time) {
                                listener = new Debounce(time, listener);
                            }

                            subscribers.add(listener);
                        }
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Unregister event listener.
     * </p>
     */
    void unregister(Subscribable subscribable) {
        if (holder != null && subscribable != null) {
            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(subscribable.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    Class annotationType = annotation.annotationType();
                    Subscribe[] subscribes = null;

                    if (annotationType == Subscribe.class) {
                        subscribes = new Subscribe[] {(Subscribe) annotation};
                    } else if (annotationType == Subscribes.class) {
                        subscribes = ((Subscribes) annotation).value();
                    }

                    if (subscribes != null) {
                        for (Subscribe subscribe : subscribes) {
                            Class eventType;
                            Method method = entry.getKey();

                            if (method.getParameterTypes().length == 1) {
                                eventType = method.getParameterTypes()[0];
                            } else {
                                eventType = subscribe.value();
                            }

                            eventType = ClassUtil.wrap(eventType);

                            List<Subscriber> subscribers = holder.get(eventType);

                            if (subscribers != null) {
                                for (int i = subscribers.size() - 1; 0 <= i; i--) {
                                    Subscriber subscliber = subscribers.get(i);

                                    if (subscliber.equals(subscribable, null)) {
                                        subscribers.remove(i);

                                        if (subscribers.isEmpty()) {
                                            holder.remove(eventType);
                                            publish(new Stop(eventType));

                                            if (holder.isEmpty()) {
                                                holder = null;
                                                publish(new Stop(Object.class));
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @version 2013/12/12 14:58:28
     */
    private static interface Subscriber<E> {

        /**
         * <p>
         * Receieve event.
         * </p>
         * 
         * @param event
         */
        void accept(E event);

        boolean equals(Object instance, Method method);
    }

    /**
     * @version 2013/10/09 15:53:55
     */
    private static class Listener implements Subscriber {

        /** The listener instance. */
        private final Object instance;

        /** The listener method. */
        private final Method method;

        /** The parameter flag. */
        private final boolean hasParam;

        /**
         * @param instance
         * @param method
         */
        private Listener(Subscribable instance, Method method) {
            method.setAccessible(true);

            this.instance = instance;
            this.method = method;
            this.hasParam = method.getParameterTypes().length == 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            try {
                if (hasParam) {
                    method.invoke(instance, event);
                } else {
                    method.invoke(instance);
                }
            } catch (Exception e) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(e);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object instance, Method method) {
            return this.instance == instance && (method == null || this.method == method);
        }
    }

    /**
     * @version 2013/12/12 14:55:38
     */
    private static class Count implements Subscriber {

        /** The delegator. */
        private final Publisher publisher;

        /** The delegator. */
        private final Subscribable subscribable;

        /** The delegator. */
        private final Subscriber subscriber;

        /** The execution limit. */
        private final int limit;

        /** The current number of execution. */
        private int current = 0;

        /**
         * @param limit
         * @param publisher
         * @param subscriber
         */
        private Count(int limit, Publisher publisher, Subscribable subscribable, Subscriber subscriber) {
            this.limit = limit;
            this.publisher = publisher;
            this.subscribable = subscribable;
            this.subscriber = subscriber;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            subscriber.accept(event);

            if (++current == limit) {
                publisher.unregister(subscribable);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object instance, Method method) {
            return subscriber.equals(instance, method);
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:37:30
     */
    private static class Throttle implements Subscriber {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final Subscriber subscriber;

        /** The latest execution time. */
        private long latest;

        /**
         * @param subscriber
         */
        private Throttle(long delay, Subscriber subscriber) {
            this.delay = delay;
            this.subscriber = subscriber;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            if (event instanceof TimeAware) {
                long now = ((TimeAware) event).time();

                if (latest + delay < now) {
                    latest = now;

                    subscriber.accept(event);
                }
            } else {
                throw new IllegalArgumentException(event + " is not " + TimeAware.class.getName() + ".");
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object instance, Method method) {
            return subscriber.equals(instance, method);
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:58:44
     */
    private static class Debounce implements Subscriber, Runnable {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final Subscriber subscriber;

        /** The lastest event. */
        private Object event;

        /** The time out id. */
        private long id = -1;

        /**
         * @param subscriber
         */
        private Debounce(long delay, Subscriber subscriber) {
            this.delay = delay;
            this.subscriber = subscriber;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object instance, Method method) {
            return subscriber.equals(instance, method);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            if (id != -1) {
                clearTimeout(id);
            }
            this.event = event;
            this.id = setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            id = -1;
            subscriber.accept(event);
            event = null;
        }
    }
}
