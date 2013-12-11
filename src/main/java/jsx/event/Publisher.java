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
                List<Listener> listeners = holder.get(type);

                if (listeners != null) {
                    for (Listener listener : listeners) {
                        try {
                            if (listener.hasParam) {
                                listener.method.invoke(listener.instance, event);
                            } else {
                                listener.method.invoke(listener.instance);
                            }
                        } catch (Exception e) {
                            throw new Error(e);
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
                    if (annotation.annotationType() == Subscribe.class) {
                        Class eventType;
                        Method method = entry.getKey();

                        if (method.getParameterTypes().length == 1) {
                            eventType = method.getParameterTypes()[0];
                        } else {
                            eventType = ((Subscribe) annotation).value();
                        }

                        Listener listener = new Listener(subscribable, method);

                        eventType = ClassUtil.wrap(eventType);

                        if (holder == null) {
                            holder = new HashMap();
                            publish(new Start(Object.class));
                        }

                        List<Listener> listeners = holder.get(eventType);

                        if (listeners == null) {
                            listeners = new CopyOnWriteArrayList();
                            holder.put(eventType, listeners);

                            publish(new Start(eventType));
                        } else {
                            for (Listener registered : listeners) {
                                if (registered.instance == subscribable && registered.method == method) {
                                    return;
                                }
                            }
                        }
                        listeners.add(listener);
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
                    if (annotation.annotationType() == Subscribe.class) {
                        Class eventType;
                        Method method = entry.getKey();

                        if (method.getParameterTypes().length == 1) {
                            eventType = method.getParameterTypes()[0];
                        } else {
                            eventType = ((Subscribe) annotation).value();
                        }

                        eventType = ClassUtil.wrap(eventType);

                        List<Listener> listeners = holder.get(eventType);

                        if (listeners != null) {
                            for (int i = listeners.size() - 1; 0 <= i; i--) {
                                Listener listener = listeners.get(i);

                                if (listener.instance == subscribable) {
                                    listeners.remove(i);

                                    if (listeners.isEmpty()) {
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

    /**
     * @version 2013/10/09 15:53:55
     */
    private static class Listener {

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
    }
}
