/*
 * Copyright (C) 2015 Nameless Production Committee
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
import java.util.function.Predicate;
import java.util.function.Supplier;

import kiss.Disposable;
import kiss.Events;
import kiss.I;
import kiss.Observer;
import kiss.Table;
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
    private Table<Object, Observer> holder;

    private Map<Object, Disposable> disposer;

    public void delegateTo(Publishable<?> publishable) {
        if (publishable != null && publishable.holder != null) {

            for (Entry<Object, List<Observer>> entry : publishable.holder.entrySet()) {
                for (Observer observer : entry.getValue()) {
                    add(entry.getKey()).to(observer);
                }
            }
        }
    }

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T> Events<T> observe(Class<T> type) {
        if (type == null) {
            return Events.NEVER;
        }
        return add(ClassUtil.wrap(type));
    }

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param types A list of event types.
     * @return Chainable API.
     */
    public final <T extends Enum & Predicate<E>, E extends Supplier<T>> Events<E> observe(T... types) {
        if (types == null || types.length == 0) {
            return Events.NEVER;
        }

        Events<E> observable = null;

        for (T type : types) {
            Events<E> current = add(type);

            if (observable == null) {
                observable = current;
            } else {
                observable = observable.merge(current);
            }
        }
        return observable;
    }

    /**
     * <p>
     * Register the specified event subscriber to this {@link Publishable}.
     * </p>
     * 
     * @param type An event type to register.
     * @param subscriber An event subscriber to register.
     * @return Chainable API.
     */
    public final <T> P subscribe(Class<T> type, Observer<T> subscriber) {
        observe(type).to(subscriber);

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
    public final <T extends Enum & Predicate<E>, E extends Supplier<T>> P subscribe(T type, Observer<E> listener) {
        observe(type).to(listener);

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
    public final P subscribe(Object listeners) {
        if (listeners != null) {
            if (disposer == null) {
                disposer = new ConcurrentHashMap();
            }

            if (!disposer.containsKey(listeners)) {
                Agent agent = new Agent();
                disposer.put(listeners, agent);

                for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass())
                        .entrySet()) {
                    for (Annotation annotation : entry.getValue()) {
                        Subscribable info = I.find(Subscribable.class, annotation.annotationType());

                        if (info != null) {
                            Method method = entry.getKey();
                            method.setAccessible(true);

                            Object type = info.detect(method, annotation);
                            boolean hasParam = method.getParameterTypes().length == 1;

                            agent.add(info.create(add(type), annotation).to(value -> {
                                try {
                                    if (hasParam) {
                                        method.invoke(listeners, value);
                                    } else {
                                        method.invoke(listeners);
                                    }
                                } catch (Exception e) {
                                    // If this exception will be thrown, it is bug of this program.
                                    // So we must rethrow the wrapped error in here.
                                    throw new Error(e);
                                }
                            }));
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
     * Create an event listener as {@link Events}.
     * </p>
     * 
     * @param type A event type.
     * @return
     */
    private <V> Events<V> add(Object type) {
        return new Events<V>(observer -> {
            // create event listener holder if it is not initialized
            if (holder == null) {
                holder = new Table();
                startListening(Object.class);
            }

            // register this event listener
            if (holder.push(type, observer)) {
                startListening(type);
            }

            return () -> {
                if (holder.pull(type, observer)) {
                    remove(type);
                }
            };
        });
    }

    /**
     * <p>
     * Stop subscribing all events from which this {@link Publishable} emits.
     * </p>
     * 
     * @return Chainable API.
     */
    public final P unsubscribe() {
        if (disposer != null) {
            for (Object listener : disposer.keySet()) {
                disposer.remove(listener);
            }
            disposer = null;
        }

        if (holder != null) {
            for (Object type : holder.keySet()) {
                remove(type);
            }
            holder = null;
        }

        // API definition
        return (P) this;
    }

    /**
     * <p>
     * Stop subscribing the specified event from which this {@link Publishable} emits.
     * </p>
     * <p>
     * The specified subscriber unsubscribes from this {@link Publishable}.
     * </p>
     * 
     * @param subscriberOrType A target subscriber to unsubscribe or a target event type to stop
     *            emitting.
     * @return Chainable API.
     */
    public final P unsubscribe(Object subscriberOrType) {
        if (disposer != null && disposer.containsKey(subscriberOrType)) {
            // as subscriber
            Disposable unsubscriber = disposer.remove(subscriberOrType);

            if (unsubscriber != null) {
                unsubscriber.dispose();

                if (disposer.isEmpty()) {
                    disposer = null;
                }
            }
        } else if (subscriberOrType instanceof Class) {
            // as event type
            remove(ClassUtil.wrap((Class) subscriberOrType));
        } else {
            // as event type
            remove(subscriberOrType);
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
     */
    private void remove(Object type) {
        if (holder != null) {
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
     * Publish the specified event.
     * </p>
     * 
     * @param event An event to submit.
     * @return Chainable API.
     */
    public final P publish(Object event) {
        if (holder != null && event != null) {
            Set types;

            if (event instanceof Supplier) {
                Object type = ((Supplier) event).get();

                if (!(type instanceof Enum) || !(type instanceof Predicate) || !((Predicate) type).test(event)) {
                    return (P) this;
                }
                types = Collections.singleton(type);
            } else {
                types = cache.computeIfAbsent(event.getClass(), type -> ClassUtil.getTypes(type));
            }

            for (Object type : types) {
                if (holder != null) {
                    List<Observer> subscribers = holder.get(type);

                    if (subscribers != null) {
                        for (Observer subscriber : subscribers) {
                            try {
                                subscriber.accept(event);
                            } catch (Throwable e) {
                                subscriber.error(e);
                            }
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
}
