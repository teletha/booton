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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import kiss.Disposable;
import kiss.model.ClassUtil;

/**
 * @version 2013/10/09 15:53:49
 */
public class Publishable {

    /** The global event bus. */
    public static final Publishable Global = new Publishable();

    /** The cache for event types. */
    private static final Map<Class, Set<Class<?>>> cache = new HashMap();

    /** The actual listeners holder. */
    private Map<Object, List<Listener>> holder;

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event
     */
    public final void publish(Object event) {
        if (holder != null && event != null) {
            Set types;

            if (event instanceof Event) {
                EventType type = ((Event<?>) event).getEventType();

                if (!type.test(event)) {
                    return;
                }
                types = Collections.singleton(type);
            } else {
                types = cache.computeIfAbsent(event.getClass(), type -> ClassUtil.getTypes(type));
            }

            for (Object type : types) {
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
     * Start subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param listeners A target event listeners.
     */
    public final void register(Object listeners) {
        if (listeners != null) {
            int index = 0;

            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    for (Info info : collect(annotation, entry.getKey())) {
                        // Check duplication at first time only.
                        // If the duplicated listener is found, all the other listeners are ignored.
                        if (!register(listeners, info, new MethodInvoker(listeners, entry.getKey(), info.abort), index++ == 0)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     */
    public final void register(Class type, Runnable listener) {
        register(listener, new Info(type), new RunnableInvoker(listener), true);
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     */
    public final <T> void register(Class<T> type, Consumer<T> listener) {
        register(listener, new Info(type), new ConsumerInvoker(listener), true);
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     */
    public final <E extends Enum & EventType> void register(E type, Runnable listener) {
        register(listener, new Info(type), new RunnableInvoker(listener), true);
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     */
    public final <E extends Enum & EventType<T>, T extends Event> void register(E type, Consumer<T> listener) {
        register(listener, new Info(type), new ConsumerInvoker(listener), true);
    }

    /**
     * <p>
     * Register an event listener.
     * </p>
     * 
     * @param subscribable
     * @param info A event type infomation.
     * @param listener An event listener.
     * @param checkDuplication A flag for duplication checking.
     * @return If the registration is success, this method returns true.
     */
    private boolean register(Object subscribable, Info info, Listener listener, boolean checkDuplication) {
        if (holder == null) {
            holder = new HashMap();
            startListening(Object.class);
        }

        List<Listener> listeners = holder.get(info.type);

        if (listeners == null) {
            listeners = new CopyOnWriteArrayList();
            holder.put(info.type, listeners);

            startListening(info.type);
        } else if (checkDuplication) {
            for (Listener registered : listeners) {
                if (registered.equals(subscribable)) {
                    return false;
                }
            }
        }

        // ===========================
        // Execution Count Wrapper
        // ===========================
        int count = info.count;

        if (0 < count) {
            listener = new Count(count, this, subscribable, listener);
        }

        // ===========================
        // Timing Related Wrappers
        // ===========================
        long time = info.delay;

        if (0 < time) {
            listener = new Delay(time, listener);
        }

        time = info.throttle;

        if (0 < time) {
            listener = new Throttle(time, listener);
        }

        time = info.debounce;

        if (0 < time) {
            listener = new Debounce(time, listener);
        }

        // register a listener
        listeners.add(listener);

        // API definition
        return true;
    }

    /**
     * <p>
     * Stop subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param subscribable A target event subscriber.
     */
    public final void unregister(Object subscribable) {
        if (holder != null && subscribable != null) {
            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(subscribable.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    for (Info info : collect(annotation, entry.getKey())) {
                        List<Listener> subscribers = holder.get(info.type);

                        if (subscribers != null) {
                            for (int i = subscribers.size() - 1; 0 <= i; i--) {
                                Listener listener = subscribers.get(i);

                                if (listener.equals(subscribable)) {
                                    subscribers.remove(i);

                                    if (subscribers.isEmpty()) {
                                        holder.remove(info.type);
                                        stopListening(info.type);

                                        if (holder.isEmpty()) {
                                            holder = null;
                                            stopListening(Object.class);
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

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     */
    public void unregister(Class type, Runnable listener) {
        unregister(new Info(type), listener);
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     */
    public <T> void unregister(Class<T> type, Consumer<T> listener) {
        unregister(new Info(type), listener);
    }

    private void unregister(Info info, Object listener) {
        List<Listener> listeners = holder.get(info.type);

        if (listeners != null) {
            for (int i = listeners.size() - 1; 0 <= i; i--) {
                if (listeners.get(i).equals(listener)) {
                    listeners.remove(i);

                    if (listeners.isEmpty()) {
                        holder.remove(info.type);
                        stopListening(info.type);

                        if (holder.isEmpty()) {
                            holder = null;
                            stopListening(Object.class);
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * <p>
     * This method is called whenever this event target starts listening event.
     * </p>
     */
    protected void startListening(Object type) {
    }

    /**
     * <p>
     * This method is called whenever this event target stops listening event.
     * </p>
     */
    protected void stopListening(Object type) {
    }

    /**
     * <p>
     * Helper method to collect all lisnteners.
     * </p>
     * 
     * @param annotation
     * @return
     */
    private List<Info> collect(Annotation annotation, Method method) {
        Class type = annotation.annotationType();
        List<Info> infos = new ArrayList();

        if (type == Subscribe.class) {
            infos.add(new Info((Subscribe) annotation, method));
        } else if (type == Subscribes.class) {
            for (Subscribe subscribe : ((Subscribes) annotation).value()) {
                infos.add(new Info(subscribe, method));
            }
        } else if (type == SubscribeUI.class) {
            infos.add(new Info((SubscribeUI) annotation));
        } else if (type == SubscribeUIs.class) {
            for (SubscribeUI subscribe : ((SubscribeUIs) annotation).value()) {
                infos.add(new Info(subscribe));
            }
        }
        return infos;
    }

    /**
     * @version 2013/12/18 15:26:58
     */
    private static class Info {

        /** The event type. */
        private Object type;

        /**
         * <p>
         * Set the execution debounce time (ms).
         * </p>
         * 
         * @return A time (ms);
         */
        private long debounce;

        /**
         * <p>
         * Set the execution throttle time (ms).
         * </p>
         * 
         * @return A time (ms);
         */
        private long throttle;

        /**
         * <p>
         * Set the execution delay time (ms).
         * </p>
         * 
         * @return A time (ms);
         */
        private long delay;

        /**
         * <p>
         * Set a number of execution.
         * </p>
         * 
         * @return
         */
        private int count;

        /**
         * <p>
         * Stop event propagation and default behavior.
         * </p>
         * 
         * @return The <code>true</code> will stop the current processing event.
         */
        private boolean abort;

        /**
         * @param subscribe
         */
        private Info(Subscribe subscribe, Method method) {
            Class type;

            if (method.getParameterTypes().length == 1) {
                type = ClassUtil.wrap(method.getParameterTypes()[0]);
            } else {
                type = subscribe.value();
            }

            this.type = ClassUtil.wrap(type);
            this.debounce = subscribe.debounce();
            this.throttle = subscribe.throttle();
            this.delay = subscribe.delay();
            this.count = subscribe.count();
            this.abort = subscribe.abort();
        }

        /**
         * @param subscribe
         */
        private Info(SubscribeUI subscribe) {
            this.type = subscribe.type();
            this.debounce = subscribe.debounce();
            this.throttle = subscribe.throttle();
            this.delay = subscribe.delay();
            this.count = subscribe.count();
            this.abort = subscribe.abort();
        }

        private Info(Class type) {
            this.type = ClassUtil.wrap(type);
        }

        private Info(Enum type) {
            this.type = type;
        }
    }

    /**
     * @version 2013/12/18 9:29:13
     */
    private static abstract class Listener<T> {

        /** The actual event listener. */
        protected T listener;

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
         * @return A result.
         */
        @Override
        public boolean equals(Object instance) {
            return listener.equals(instance);
        }
    }

    /**
     * @version 2013/12/20 9:48:58
     */
    private static class RunnableInvoker extends Listener<Runnable> {

        /**
         * @param runnable
         */
        private RunnableInvoker(Runnable runnable) {
            this.listener = runnable;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void accept(Object event) {
            listener.run();
        }
    }

    /**
     * @version 2013/12/20 9:48:58
     */
    private static class ConsumerInvoker extends Listener<Consumer> {

        /**
         * @param consumer
         */
        private ConsumerInvoker(Consumer consumer) {
            this.listener = consumer;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void accept(Object event) {
            listener.accept(event);
        }
    }

    /**
     * @version 2013/12/18 9:30:25
     */
    private static class MethodInvoker extends Listener {

        /** The listener method. */
        private final Method method;

        /** The parameter flag. */
        private final boolean hasParam;

        /** The event termination flag. */
        private final boolean abort;

        /**
         * @param instance A {@link Subscribe} listener.
         * @param method A subscribe method.
         * @param abort The event is stoppable.
         */
        private MethodInvoker(Object instance, Method method, boolean abort) {
            method.setAccessible(true);

            this.listener = instance;
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
                    method.invoke(listener, event);
                } else {
                    method.invoke(listener);
                }
            } catch (Exception e) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(e);
            }
        }
    }

    /**
     * @version 2013/12/18 9:31:12
     */
    private static class Count extends Listener<Listener> {

        /** The delegator. */
        private final Publishable publishable;

        /** The delegator. */
        private final Object subscribable;

        /** The execution limit. */
        private final int limit;

        /** The current number of execution. */
        private int current = 0;

        /**
         * @param limit
         * @param publishable
         * @param subscribable
         * @param listener
         */
        private Count(int limit, Publishable publishable, Object subscribable, Listener listener) {
            this.limit = limit;
            this.publishable = publishable;
            this.subscribable = subscribable;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            listener.accept(event);

            if (++current == limit) {
                publishable.unregister(subscribable);
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
    private static class Throttle extends Listener<Listener> {

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
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            long now = System.currentTimeMillis();

            if (latest + delay < now) {
                latest = now;

                listener.accept(event);
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
    private static class Debounce extends Listener<Listener> {

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
            this.listener = listener;
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
                listener.accept(event);
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
    private static class Delay extends Listener<Listener> {

        /** The delay time. */
        private final long delay;

        /**
         * @param delay
         * @param listener
         */
        private Delay(long delay, Listener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            setTimeout(() -> {
                listener.accept(event);
            }, delay);
        }
    }
}
