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
import java.util.function.Function;

import jsx.rx.Observable;
import jsx.rx.Observer;
import kiss.Disposable;
import kiss.I;
import kiss.model.ClassUtil;

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

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T> Observable<T> observe(Class<T> type) {
        return new Observable<T>(observer -> {
            Consumer<T> consumer = event -> {
                observer.onNext(event);
            };

            register(type, consumer);

            return () -> {
                unregister(type, consumer);
            };
        });
    }

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T extends Enum & EventType<E>, E extends Event<T>> Observable<E> observe(T type) {
        return new Observable<E>(observer -> {
            Consumer<E> consumer = event -> {
                observer.onNext(event);
            };

            register(type, consumer);

            return () -> {
                unregister(type, consumer);
            };
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
    public final <T extends Enum & EventType> P register(Object listeners) {
        if (listeners != null) {
            int index = 0;

            for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass()).entrySet()) {
                for (Annotation annotation : entry.getValue()) {
                    Subscribable info = I.find(Subscribable.class, annotation.annotationType());

                    if (info != null) {
                        Method method = entry.getKey();
                        Object type = info.type(annotation, method);

                        // Check duplication at first time only.
                        // If the duplicated listener is found, all the other listeners are ignored.
                        ObservableInvoker listener = new ObservableInvoker(type, listeners, method, index++ == 0);

                        info.observe(new Observable(listener), annotation).subscribe((Observer) listener);

                        if (!listener.success) {
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
        if (holder != null) {
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
     * @version 2014/01/12 16:15:49
     */
    private static abstract class Listener<T> implements Consumer {

        /** The actual listener. */
        protected T listener;

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            return listener.equals(obj);
        }
    }

    /**
     * @version 2014/01/12 16:16:45
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
        public void accept(Object event) {
            listener.run();
        }
    }

    /**
     * @version 2014/01/12 16:16:50
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
        public void accept(Object event) {
            listener.accept(event);
        }
    }

    /**
     * @version 2014/01/12 16:16:54
     */
    private class ObservableInvoker<T> extends Listener implements Observer, Function<Observer, Disposable>, Disposable {

        /** The event type. */
        private final Object type;

        /** The listener method. */
        private final Method method;

        /** The parameter flag. */
        private final boolean hasParam;

        /** The flag. */
        private final boolean checkDuplication;

        /** The listener. */
        private Observer observer;

        /** The registration result. */
        private boolean success;

        /**
         * @param type
         * @param method
         * @param hasParam
         * @param abort
         */
        protected ObservableInvoker(Object type, Object instance, Method method, boolean checkDuplication) {
            method.setAccessible(true);

            this.type = type;
            this.listener = instance;
            this.method = method;
            this.hasParam = method.getParameterTypes().length == 1;
            this.checkDuplication = checkDuplication;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Object event) {
            observer.onNext(event);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNext(Object value) {
            try {
                if (hasParam) {
                    method.invoke(listener, value);
                } else {
                    method.invoke(listener);
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
        public void dispose() {
            remove(type, this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Disposable apply(Observer observer) {
            this.success = add(type, this, checkDuplication);
            this.observer = observer;

            return this;
        }
    }
}
