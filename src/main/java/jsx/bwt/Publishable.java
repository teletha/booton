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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jsx.bwt.widget.Subscribe;

/**
 * @version 2013/06/17 14:09:34
 */
public class Publishable {

    /** The lazy initialized event listener holder. */
    private transient Map<Class, Subscribers> subscribers;

    /** The lazy initialized event listener holder. */
    private transient Map<Class, MethodSubscribers> methods;

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    public void bind(Object subscriber) {
        if (subscriber != null) {
            for (Class type : getTypes(subscriber.getClass())) {
                Class[] interfaces = type.getInterfaces();

                for (Class interfaceType : interfaces) {
                    if (interfaceType == EventListener.class) {
                        if (subscribers == null) {
                            subscribers = new HashMap();
                        }
                        Subscribers list = subscribers.get(type);

                        if (list == null) {
                            list = new Subscribers();
                            subscribers.put(type, list);
                        }

                        list.add(subscriber);
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
    public void unbind(Object subscriber) {
        if (subscriber != null && subscribers != null) {
            for (Class type : getTypes(subscriber.getClass())) {
                Class[] interfaces = type.getInterfaces();

                for (Class interfaceType : interfaces) {
                    if (interfaceType == EventListener.class) {
                        Subscribers list = subscribers.get(type);

                        if (list != null) {
                            list.remove(subscriber);

                            if (list.subscribers.isEmpty()) {
                                subscribers.remove(type);
                            }
                        }
                    }
                }
            }
        }
    }

    protected <T> T publish(Class<T> listenerType) {
        Subscribers subscriber;

        if (subscribers != null) {
            subscriber = subscribers.get(listenerType);

            if (subscriber == null) {
                subscriber = new Subscribers();
            }
        } else {
            subscriber = new Subscribers();
        }
        return (T) Proxy.newProxyInstance(null, new Class[] {listenerType}, subscriber);
    }

    public void register(Object subscriber) {
        System.out.println("register");
        if (subscriber != null) {

            for (Method method : subscriber.getClass().getDeclaredMethods()) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe != null) {

                    Class[] parameters = method.getParameterTypes();

                    if (parameters.length == 1) {
                        if (methods == null) {
                            methods = new HashMap();
                        }

                        MethodSubscribers subscribers = methods.get(parameters[0]);

                        if (subscribers == null) {
                            subscribers = new MethodSubscribers();
                            methods.put(parameters[0], subscribers);
                        }

                        subscribers.add(subscriber, method);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Publish the specified event which has type and context.
     * </p>
     * 
     * @param event
     */
    protected void publish(Object event) {
        if (event != null && methods != null) {
            MethodSubscribers subscribers = methods.get(event.getClass());

            if (subscribers != null) {
                subscribers.fire(event);
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
     * @version 2013/06/19 14:16:06
     */
    private static class MethodSubscribers {

        /** The listener instance. */
        private final List<Object> subscribers = new ArrayList();

        /** The listener instance. */
        private final List<Method> listeners = new ArrayList();

        /**
         * <p>
         * Register as listener.
         * </p>
         * 
         * @param subscriber A listener to add.
         */
        private void add(Object subscriber, Method listener) {
            if (subscriber != null && !subscribers.contains(subscriber)) {
                subscribers.add(subscriber);
                listeners.add(listener);
            }
        }

        /**
         * <p>
         * Fire event.
         * </p>
         * 
         * @param event
         */
        private void fire(Object event) {
            for (int i = 0; i < subscribers.size(); i++) {
                try {
                    listeners.get(i).invoke(subscribers.get(i), event);
                } catch (Exception e) {
                    // If this exception will be thrown, it is bug of this program. So we must
                    // rethrow the wrapped error in here.
                    throw new Error(e);
                }
            }
        }
    }

    /**
     * @version 2013/06/19 14:16:06
     */
    private static class MethodSubscriber {

        /** The listener instance. */
        private final Object instance;

        /** The listener method. */
        private final Method method;

        /**
         * @param instance
         * @param method
         */
        private MethodSubscriber(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }
    }

    /**
     * @version 2013/06/17 14:07:04
     */
    private static class Subscribers implements InvocationHandler {

        /** The listeners. */
        private List subscribers = new ArrayList();

        /**
         * <p>
         * Register as listener.
         * </p>
         * 
         * @param subscriber A listener to add.
         */
        private void add(Object subscriber) {
            if (subscriber != null && !subscribers.contains(subscriber)) {
                subscribers.add(subscriber);
            }
        }

        /**
         * <p>
         * Unregister from listeners.
         * </p>
         * 
         * @param subscriber A listener to remove.
         */
        private void remove(Object subscriber) {
            if (subscriber != null) {
                subscribers.remove(subscriber);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Object subscriber : subscribers) {
                method.invoke(subscriber, args);
            }
            return null;
        }
    }
}
