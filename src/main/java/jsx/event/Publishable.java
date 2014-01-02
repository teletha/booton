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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import kiss.Disposable;
import kiss.I;
import kiss.model.ClassUtil;
import rx.Observable;
import rx.Observable.OnSubscribeFunc;
import rx.Observer;
import rx.Subscription;

/**
 * <p>
 * This is base class for Publish-Subscribe architecture.
 * </p>
 * 
 * @version 2013/12/29 0:27:42
 */
public class Publishable<P extends Publishable<P>> {

    /** The global event bus. */
    public static final Publishable Global = new Publishable();

    /** The cache for event types. */
    private static final Map<Class, Set<Class<?>>> cache = new HashMap();

    /** The actual listeners holder. */
    private Map<Object, List<Listener>> holder;

    public final <T> Observable<T> observe(Class<T> type) {
        return Observable.create(new OnSubscribeFunc<T>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public Subscription onSubscribe(Observer<? super T> observer) {
                Consumer<T> consumer = new Consumer<T>() {

                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    public void accept(T t) {
                        observer.onNext(t);
                    }
                };
                register(type, consumer);

                return new Subscription() {

                    @Override
                    public void unsubscribe() {
                        unregister(type, consumer);
                    }
                };
            }
        });
    }

    public final <T extends Enum & EventType<E>, E extends Event<T>> Observable<E> observe(T type) {
        return Observable.create(new OnSubscribeFunc<E>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public Subscription onSubscribe(Observer<? super E> observer) {
                System.out.println("on subscribe " + observer + "  " + type);
                Consumer<E> consumer = new Consumer<E>() {

                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    public void accept(E t) {
                        System.out.println("accept " + t);
                        observer.onNext(t);
                    }
                };
                register(type, consumer);

                return new Subscription() {

                    @Override
                    public void unsubscribe() {
                        unregister(type, consumer);
                    }
                };
            }
        });
    }

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event An event to submit.
     * @return Chainable API.
     */
    public final P publish(Object event) {
        if (holder != null && event != null) {
            Set types;

            if (event instanceof Event) {
                EventType type = ((Event) event).getEventType();

                if (!type.test(event)) {
                    return (P) this;
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

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Start subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param listeners A target event listeners.
     * @return Chainable API.
     */
    public final P register(Object listeners) {
        if (listeners != null) {
            int index = 0;

            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    Subscribable info = I.find(Subscribable.class, annotation.annotationType());

                    if (info != null) {
                        Method method = entry.getKey();
                        Listener listener = new MethodInvoker(listeners, method, info.abort(annotation));

                        // ===========================
                        // Execution Count Wrapper
                        // ===========================
                        int count = info.count(annotation);

                        if (0 < count) {
                            listener = new Count(count, this, listener.listener, listener);
                        }

                        // ===========================
                        // Timing Related Wrappers
                        // ===========================
                        long time = info.delay(annotation);

                        if (0 < time) {
                            listener = new Delay(time, listener);
                        }

                        time = info.throttle(annotation);

                        if (0 < time) {
                            listener = new Throttle(time, listener);
                        }

                        time = info.debounce(annotation);

                        if (0 < time) {
                            listener = new Debounce(time, listener);
                        }

                        // Check duplication at first time only.
                        // If the duplicated listener is found, all the other listeners are ignored.
                        if (!add(info.type(annotation, method), listener, index++ == 0)) {
                            return (P) this;
                        }
                    }
                }
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final P register(Class type, Runnable listener) {
        add(ClassUtil.wrap(type), new RunnableInvoker(listener), true);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T> P register(Class<T> type, Consumer<T> listener) {
        add(ClassUtil.wrap(type), new ConsumerInvoker(listener), true);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType> P register(T type, Runnable listener) {
        add(type, new RunnableInvoker(listener), true);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param types A list of event types.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType> P register(T[] types, Runnable listener) {
        if (types != null) {
            for (T type : types) {
                register(type, listener);
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType<E>, E extends Event<T>> P register(T type, Consumer<E> listener) {
        add(type, new ConsumerInvoker(listener), true);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register the specified event listener.
     * </p>
     * 
     * @param types A list of event types.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType<E>, E extends Event<T>> P register(T[] types, Consumer<E> listener) {
        if (types != null) {
            for (T type : types) {
                register(type, listener);
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Register an event listener.
     * </p>
     * 
     * @param type A event type.
     * @param listener An event listener.
     * @param checkDuplication A flag for duplication checking.
     * @return If the registration is success, this method returns true.
     */
    private boolean add(Object type, Listener listener, boolean checkDuplication) {
        if (holder == null) {
            holder = new ConcurrentHashMap();
            startListening(Object.class);
        }

        List<Listener> listeners = holder.get(type);

        if (listeners == null) {
            listeners = new CopyOnWriteArrayList();
            holder.put(type, listeners);

            startListening(type);
        } else if (checkDuplication) {
            for (Listener registered : listeners) {
                if (registered.equals(listener.listener)) {
                    return false;
                }
            }
        }

        // register a listener
        listeners.add(listener);

        // API definition
        return true;
    }

    /**
     * <p>
     * Unregister all event listeners.
     * </p>
     * 
     * @return Chainable API.
     */
    public final P unregister() {
        if (holder != null) {
            for (Object type : holder.keySet()) {
                remove(type);
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Stop subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param listeners A target event subscriber.
     * @return Chainable API.
     */
    public final P unregister(Object listeners) {
        if (holder != null && listeners != null) {
            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    Subscribable info = I.find(Subscribable.class, annotation.annotationType());

                    if (info != null) {
                        remove(info.type(annotation, entry.getKey()), listeners);
                    }
                }
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister all event listeners for the specified event type.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final P unregister(Class type) {
        remove(type);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final P unregister(Class type, Runnable listener) {
        remove(ClassUtil.wrap(type), listener);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final <T> P unregister(Class<T> type, Consumer<T> listener) {
        remove(ClassUtil.wrap(type), listener);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister all event listeners for the specified event type.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType> P unregister(T type) {
        remove(type);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType> P unregister(T type, Runnable listener) {
        remove(type, listener);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param types A list of event types.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType> P unregister(T[] types, Runnable listener) {
        if (types != null) {
            for (T type : types) {
                unregister(type, listener);
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType<E>, E extends Event<T>> P unregister(T type, Consumer<E> listener) {
        remove(type, listener);

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param types A list of event types.
     * @param listener An event listener to remove.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType<E>, E extends Event<T>> P unregister(T[] types, Consumer<E> listener) {
        if (types != null) {
            for (T type : types) {
                unregister(type, listener);
            }
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Unregister the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to remove.
     */
    private void remove(Object type, Object listener) {
        List<Listener> listeners = holder.get(type);

        if (listeners != null) {
            for (int i = listeners.size() - 1; 0 <= i; i--) {
                if (listeners.get(i).equals(listener)) {
                    listeners.remove(i);

                    if (listeners.isEmpty()) {
                        remove(type);
                    }
                    break;
                }
            }
        }
    }

    /**
     * <p>
     * Unregister all event listeners for the specified event type.
     * </p>
     * 
     * @param type An event type.
     */
    private void remove(Object type) {
        if (holder != null && holder.containsKey(type)) {
            holder.remove(type);
            stopListening(type);

            if (holder.isEmpty()) {
                holder = null;
                stopListening(Object.class);
            }
        }
    }

    /**
     * <p>
     * This method is called whenever this event target starts listening event.
     * </p>
     * 
     * @param An event type.
     */
    protected void startListening(Object type) {
    }

    /**
     * <p>
     * This method is called whenever this event target stops listening event.
     * </p>
     * 
     * @param An event type.
     */
    protected void stopListening(Object type) {
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
