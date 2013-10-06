/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.model.ClassUtil;
import booton.translator.Debuggable;

/**
 * @version 2013/10/05 11:45:30
 */
public class EventHub {

    /** The global event bus. */
    public static final EventHub Global = new EventHub();

    /** The actual listeners holder. */
    private Map<Class, List<Listener>> holder;

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event
     */
    public void publish(Object event) {
        if (holder != null && event != null) {
            List<Listener> listeners = holder.get(event.getClass());

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

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    @Debuggable
    public void register(Object subscribable) {
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

                        for (Class type : ClassUtil.getTypes(eventType)) {
                            if (type != Object.class) {
                                type = ClassUtil.wrap(type);

                                if (holder == null) {
                                    holder = new HashMap();
                                }

                                List<Listener> listeners = holder.get(type);

                                if (listeners == null) {
                                    listeners = new CopyOnWriteArrayList();
                                    holder.put(type, listeners);
                                } else {
                                    for (Listener registered : listeners) {
                                        if (registered.instance == subscribable) {
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
        }
    }

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    @Debuggable
    public void registerFail(Object subscribable) {
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

                        for (Class type : ClassUtil.getTypes(eventType)) {
                            if (type != Object.class) {
                                type = ClassUtil.wrap(type);

                                if (holder == null) {
                                    holder = new HashMap();
                                }

                                List<Listener> listeners = holder.get(type);

                                if (listeners == null) {
                                    listeners = new CopyOnWriteArrayList();
                                    holder.put(type, listeners);
                                } else {
                                    for (Listener registered : listeners) {
                                        if (registered.instance == subscribable) {
                                            return;
                                        }
                                    }
                                }
                                listeners.add(listener);
                                System.out.println(listener);
                            }
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
    public void unregister(Object subscribable) {
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

                        for (Class type : ClassUtil.getTypes(eventType)) {
                            if (type != Object.class) {
                                type = ClassUtil.wrap(type);

                                List<Listener> listeners = holder.get(type);

                                if (listeners != null) {
                                    for (int i = listeners.size() - 1; 0 <= i; i--) {
                                        Listener listener = listeners.get(i);

                                        if (listener.instance == subscribable) {
                                            listeners.remove(i);
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
    }

    /**
     * @version 2013/06/28 2:50:52
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
        private Listener(Object instance, Method method) {
            method.setAccessible(true);

            this.instance = instance;
            this.method = method;
            this.hasParam = method.getParameterTypes().length == 1;
        }
    }
}
