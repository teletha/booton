/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import js.util.ArrayList;
import js.util.HashMap;
import js.util.HashSet;

/**
 * @version 2013/04/06 21:32:17
 */
public abstract class Publishable {

    /** The lazy initialized event listener holder. */
    private transient Map<Class, Subscribers> subscribers;

    /**
     * <p>
     * Register event listener.
     * </p>
     */
    public void bind(Object subscriber) {
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
     * @version 2013/04/06 19:48:48
     */
    private static class Subscribers implements InvocationHandler {

        /** The listeners. */
        private List subscribers = new ArrayList();

        /**
         * <p>
         * Register as listener.
         * </p>
         * 
         * @param subscriber
         */
        private void add(Object subscriber) {
            if (subscriber != null && !subscribers.contains(subscriber)) {
                subscribers.add(subscriber);
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
