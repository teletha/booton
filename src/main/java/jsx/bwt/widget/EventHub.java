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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import jsx.bwt.Subscribe;

/**
 * @version 2013/06/29 13:16:08
 */
public class EventHub implements Publishable {

    /** The actual listeners holder. */
    private Map<Class, List<Listener>> holder;

    /**
     * {@inheritDoc}
     */
    @Override
    public void subscribe(Publishable publishable) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTaminated() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void terminate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publish(Object event) {
        if (holder != null && event != null) {
            List<Listener> listeners = holder.get(event.getClass());

            if (listeners != null) {
                for (Listener listener : listeners) {
                    listener.fire(event);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
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

                    for (Class type : getTypes(eventType)) {
                        if (holder == null) {
                            holder = new HashMap();
                        }

                        List<Listener> listeners = holder.get(type);

                        if (listeners == null) {
                            listeners = new CopyOnWriteArrayList();
                            holder.put(type, listeners);
                        }

                        for (Listener in : listeners) {
                            if (in.instance == subscribable) {
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
     * {@inheritDoc}
     */
    @Override
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

                    for (Class type : getTypes(eventType)) {
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

        /**
         * <p>
         * Fire event.
         * </p>
         * 
         * @param event
         */
        private void fire(Object event) {
            try {
                if (hasParam) {
                    method.invoke(instance, event);
                } else {
                    method.invoke(instance);
                }
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }
}
