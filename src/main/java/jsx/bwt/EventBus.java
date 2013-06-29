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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 2013/06/28 2:45:21
 */
public class EventBus {

    /** The global event bus. */
    public static final EventBus Global = new EventBus();

    /** The actual listeners holder. */
    private Map<Class, List<Listener>> holder;

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    public void register(Object subscriber) {
        if (subscriber != null) {
            for (Method method : subscriber.getClass().getDeclaredMethods()) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe != null) {
                    Listener listener = new Listener(subscriber, method);

                    for (Class type : getTypes(subscribe.value())) {
                        if (holder == null) {
                            holder = new HashMap();
                        }

                        List<Listener> listeners = holder.get(type);

                        if (listeners == null) {
                            listeners = new CopyOnWriteArrayList();
                            holder.put(type, listeners);
                        }

                        for (Listener in : listeners) {
                            if (in.instance == subscriber) {
                                return;
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
    public void unregister(Object subscriber) {
        if (holder != null && subscriber != null) {
            for (Method method : subscriber.getClass().getDeclaredMethods()) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe != null) {
                    for (Class type : getTypes(subscribe.value())) {
                        List<Listener> listeners = holder.get(type);

                        if (listeners != null) {
                            for (int i = listeners.size() - 1; 0 <= i; i--) {
                                Listener listener = listeners.get(i);

                                if (listener.instance == subscriber) {
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
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param type
     */
    public void publish(Object event) {
        if (holder != null && event != null) {
            List<Listener> listeners = holder.get(event.getClass());

            if (listeners != null) {
                for (Listener listener : listeners) {
                    try {
                        listener.method.invoke(listener.instance);
                    } catch (Exception e) {
                        // If this exception will be thrown, it is bug of this program. So we must
                        // rethrow the wrapped error in here.
                        throw new Error(e);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Helper method to collect all classes which are extended or implemented by the target class.
     * </p>
     * 
     * @param clazz A target class. <code>null</code> will be return the empty set.
     * @return A set of classes, with predictable bottom-up iteration order.
     */
    private static Set<Class> getTypes(Class clazz) {
        // check null
        if (clazz == null) {
            return new HashSet();
        }

        // container
        Set<Class> set = new HashSet();

        // add current class
        set.add(clazz);

        // add super class
        set.addAll(getTypes(clazz.getSuperclass()));

        // add interface classes
        for (Class c : clazz.getInterfaces()) {
            set.addAll(getTypes(c));
        }

        // API definition
        return set;
    }

    /**
     * @version 2013/06/28 2:50:52
     */
    private static class Listener {

        /** The listener instance. */
        private final Object instance;

        /** The listener method. */
        private final Method method;

        /**
         * @param instance
         * @param method
         */
        private Listener(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }
    }
}
