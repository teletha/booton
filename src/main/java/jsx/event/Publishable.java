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

import kiss.Disposable;
import kiss.I;
import kiss.Observable;
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
    private Map<Object, List<Consumer>> holder;

    private Map<Object, Disposable> disposer;

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T> Observable<T> observe(Class<T> type) {
        return create(type);
    }

    /**
     * <p>
     * Observe this event sequence of this {@link Publishable}.
     * </p>
     * 
     * @param type An event type.
     * @return Chainable API.
     */
    public final <T extends EventType<E>, E extends Event<T>> Observable<E> observe(T... types) {
        if (types == null || types.length == 0) {
            return Observable.NEVER;
        }

        Observable<E> observable = null;

        for (T type : types) {
            Observable<E> current = create(type);

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
     * Register the specified event listener.
     * </p>
     * 
     * @param type An event type.
     * @param listener An event listener to add.
     * @return Chainable API.
     */
    public final <T> P on(Class<T> type, Consumer<T> listener) {
        observe(type).subscribe(listener);

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
    public final <T extends EventType<E>, E extends Event<T>> P on(T type, Consumer<E> listener) {
        if (disposer == null) {
            disposer = new HashMap();
        }
        disposer.put(listener, observe(type).subscribe(listener));

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
    public final <T extends EventType> P on(Object listeners) {
        if (listeners != null) {
            if (disposer == null) {
                disposer = new HashMap();
            }

            if (!disposer.containsKey(listeners)) {
                Agent agent = new Agent();
                disposer.put(listeners, agent);

                for (Entry<Method, List<Annotation>> entry : ClassUtil.getAnnotations(listeners.getClass()).entrySet()) {
                    for (Annotation annotation : entry.getValue()) {
                        Subscribable info = I.find(Subscribable.class, annotation.annotationType());

                        if (info != null) {
                            Method method = entry.getKey();
                            method.setAccessible(true);

                            Object type = info.detect(method, annotation);
                            boolean hasParam = method.getParameterTypes().length == 1;

                            agent.add(info.create(create(type), annotation).subscribe(value -> {
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
     * Create an event listener as {@link Observable}.
     * </p>
     * 
     * @param type A event type.
     * @return
     */
    private <V> Observable<V> create(Object type) {
        // wrap primitive type
        Object eventType = type instanceof Class ? ClassUtil.wrap((Class) type) : type;

        return new Observable<V>(observer -> {
            // create an actual event listener
            Consumer<V> consumer = value -> {
                observer.onNext(value);
            };

            // create event listener holder if it is not initialized
            if (holder == null) {
                holder = new ConcurrentHashMap();
                startListening(Object.class);
            }

            // create event listener list
            List<Consumer> listeners = holder.get(eventType);

            if (listeners == null) {
                listeners = new CopyOnWriteArrayList();
                holder.put(eventType, listeners);

                startListening(eventType);
            } else {
                // for (Consumer registered : listeners) {
                // if (registered.equals(observer)) {
                // return;
                // }
                // }
            }

            // register this event listener
            listeners.add(consumer);

            return () -> {
                List<Consumer> list = holder.get(eventType);

                if (list != null) {
                    for (int i = list.size() - 1; 0 <= i; i--) {
                        if (list.get(i).equals(consumer)) {
                            list.remove(i);

                            if (list.isEmpty()) {
                                remove(eventType);
                            }
                            break;
                        }
                    }
                }
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
                    List<Consumer> subscribers = holder.get(type);

                    if (subscribers != null) {
                        for (Consumer subscriber : subscribers) {
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
     * Unregister all event listeners.
     * </p>
     * 
     * @return Chainable API.
     */
    public final P off() {
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
     * Stop subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param listeners A target event subscriber.
     * @return Chainable API.
     */
    public final P off(Object listener) {
        if (listener instanceof Class || listener instanceof EventType) {
            remove(listener);
        } else if (disposer != null) {
            Disposable disposable = disposer.remove(listener);

            if (disposable != null) {
                disposable.dispose();
            }

            if (disposer.isEmpty()) {
                disposer = null;
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
}
