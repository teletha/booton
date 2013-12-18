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
import kiss.Disposable;
import kiss.model.ClassUtil;

/**
 * @version 2013/12/18 9:24:52
 */
class Publisher {

    /** The cache for event types. */
    private static final Map<Class, Set<Class<?>>> cache = new HashMap();

    /** The actual listeners holder. */
    private Map<Class, List<Listener>> holder;

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
                    List<Listener> subscribers = holder.get(type);

                    if (subscribers != null) {
                        for (Listener subscriber : subscribers) {
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

                            Listener listener = new Invoker(subscribable, method, subscribe.abort());

                            eventType = ClassUtil.wrap(eventType);

                            if (holder == null) {
                                holder = new HashMap();
                                publish(new Start(Object.class));
                            }

                            List<Listener> subscribers = holder.get(eventType);

                            if (subscribers == null) {
                                subscribers = new CopyOnWriteArrayList();
                                holder.put(eventType, subscribers);

                                publish(new Start(eventType));
                            } else {
                                for (Listener registered : subscribers) {
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
                                listener = new Delay(time, listener);
                            }

                            time = subscribe.throttle();

                            if (0 < time) {
                                listener = new Throttle(time, listener);
                            }

                            time = subscribe.debounce();

                            if (0 < time) {
                                listener = new Debounce(time, listener);
                            }

                            // ===========================
                            // KeyCode Wrapper
                            // ===========================
                            Key key = subscribe.key();

                            if (key != Key.None) {
                                listener = new KeyBind(key, listener);
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

                            List<Listener> subscribers = holder.get(eventType);

                            if (subscribers != null) {
                                for (int i = subscribers.size() - 1; 0 <= i; i--) {
                                    Listener subscliber = subscribers.get(i);

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
     * @version 2013/12/18 9:29:13
     */
    private static abstract class Listener {

        /** The delegator. */
        protected Listener delegator;

        /**
         * <p>
         * Receieve message.
         * </p>
         * 
         * @param event A message object.
         */
        protected abstract void accept(Object event);

        /**
         * <p>
         * Test whether the specified event listener is my consumer or not.
         * </p>
         * 
         * @param instance A target listener.
         * @param method A target listener method.
         * @return A result.
         */
        protected boolean equals(Object instance, Method method) {
            return delegator.equals(instance, method);
        }
    }

    /**
     * @version 2013/12/18 9:30:25
     */
    private static class Invoker extends Listener {

        /** The listener instance. */
        private final Object instance;

        /** The listener method. */
        private final Method method;

        /** The parameter flag. */
        private final boolean hasParam;

        /** The event termination flag. */
        private final boolean abort;

        /**
         * @param instance A {@link Subscribable} listener.
         * @param method A subscribe method.
         * @param abort The event is stoppable.
         */
        private Invoker(Subscribable instance, Method method, boolean abort) {
            method.setAccessible(true);

            this.instance = instance;
            this.method = method;
            this.hasParam = method.getParameterTypes().length == 1;
            this.abort = abort;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            if (abort) {
                if (event instanceof Disposable) {
                    ((Disposable) event).dispose();
                }
            }

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
     * @version 2013/12/18 9:31:12
     */
    private static class Count extends Listener {

        /** The delegator. */
        private final Publisher publisher;

        /** The delegator. */
        private final Subscribable subscribable;

        /** The execution limit. */
        private final int limit;

        /** The current number of execution. */
        private int current = 0;

        /**
         * @param limit
         * @param publisher
         * @param subscribable
         * @param listener
         */
        private Count(int limit, Publisher publisher, Subscribable subscribable, Listener listener) {
            this.limit = limit;
            this.publisher = publisher;
            this.subscribable = subscribable;
            this.delegator = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            delegator.accept(event);

            if (++current == limit) {
                publisher.unregister(subscribable);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/12/18 9:22:56
     */
    private static class Throttle extends Listener {

        /** The delay time. */
        private final long delay;

        /** The latest execution time. */
        private long latest;

        /**
         * @param delay
         * @param listener
         */
        private Throttle(long delay, Listener listener) {
            this.delay = delay;
            this.delegator = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            long now = System.currentTimeMillis();

            if (latest + delay < now) {
                latest = now;

                delegator.accept(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/12/18 9:19:21
     */
    private static class Debounce extends Listener {

        /** The delay time. */
        private final long delay;

        /** The time out id. */
        private long id = -1;

        /**
         * @param delay
         * @param listener
         */
        private Debounce(long delay, Listener listener) {
            this.delay = delay;
            this.delegator = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            if (id != -1) {
                clearTimeout(id);
            }

            this.id = setTimeout(() -> {
                id = -1;
                delegator.accept(event);
            }, delay);
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/12/18 9:18:45
     */
    private static class Delay extends Listener {

        /** The delay time. */
        private final long delay;

        /**
         * @param delay
         * @param listener
         */
        public Delay(long delay, Listener listener) {
            this.delay = delay;
            this.delegator = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            setTimeout(() -> {
                delegator.accept(event);
            }, delay);
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 10:11:19
     */
    private static class KeyBind extends Listener {

        /** The target key. */
        private final Key key;

        /**
         * @param key
         * @param listener
         */
        private KeyBind(Key key, Listener listener) {
            this.key = key;
            this.delegator = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void accept(Object event) {
            if (event instanceof KeyDetectable) {
                if (((KeyDetectable) event).getKey() == key) {
                    delegator.accept(event);
                }
            } else {
                throw new IllegalArgumentException(event + " is not " + KeyDetectable.class.getSimpleName() + ".");
            }
        }
    }
}
