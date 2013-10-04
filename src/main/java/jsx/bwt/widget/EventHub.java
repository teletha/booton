/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.widget;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.model.ClassUtil;

/**
 * @version 2013/06/29 13:16:08
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
            System.out.println(event.getClass());
            List<Listener> listeners = holder.get(event.getClass());
            if (listeners != null) {
                System.out.println(listeners.size());
                for (Listener listener : listeners) {
                    try {
                        if (listener.hasParam) {
                            System.out.println("invoke " + listener.instance.getClass());
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
    public void register(Object subscribable) {
        if (subscribable != null) {
            for (Method method : subscribable.getClass().getDeclaredMethods()) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe != null) {
                    Class eventType;

                    if (method.getParameterTypes().length == 1) {
                        eventType = method.getParameterTypes()[0];
                    } else {
                        eventType = subscribe.value();
                    }

                    Listener listener = new Listener(subscribable, method);
                    System.out.println(ClassUtil.getTypes(eventType));
                    for (Class type : ClassUtil.getTypes(eventType)) {

                        if (holder == null) {
                            holder = new HashMap();
                        }

                        List<Listener> listeners = holder.get(type);

                        if (listeners == null) {
                            listeners = new CopyOnWriteArrayList();
                            holder.put(type, listeners);
                        }
                        System.out.println(type);
                        for (Listener in : listeners) {
                            if (in.instance == subscribable) {
                                return;
                            }
                        }
                        System.out.println(type);
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
    public void unregister(Object subscribable) {
        if (holder != null && subscribable != null) {
            for (Method method : subscribable.getClass().getDeclaredMethods()) {

                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe != null) {
                    Class eventType;

                    if (method.getParameterTypes().length == 1) {
                        eventType = method.getParameterTypes()[0];
                    } else {
                        eventType = subscribe.value();
                    }

                    for (Class type : ClassUtil.getTypes(eventType)) {
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
            this.instance = instance;
            this.method = method;
            this.hasParam = method.getParameterTypes().length == 1;
        }
    }
}
