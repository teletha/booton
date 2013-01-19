/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import static js.lang.Global.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/01/18 21:54:32
 */
public class Classes {

    /**
     * <p>
     * Find all sub class of the specified class.
     * </p>
     * 
     * @param type A type to search.
     * @return A list of found classes.
     */
    public static <T> List<Class<? extends T>> find(Class<T> type) {
        List<Class<? extends T>> matched = new ArrayList();

        for (String name : boot.keys()) {
            Class clazz = boot.getPropertyAs(NativeObject.class, name).getPropertyAs(Class.class, "$");

            if (type != clazz && type.isAssignableFrom(clazz)) {
                matched.add(clazz);
            }
        }
        return matched;
    }

    /**
     * <p>
     * Create new proxy instance.
     * </p>
     * 
     * @param interfaceType
     * @param handler
     * @return
     */
    public static <T> T createProxy(Class<T> interfaceType, final InvocationHandler handler) {
        final NativeObject proxy = new NativeObject();

        for (final Method method : interfaceType.getMethods()) {
            proxy.setProperty(method.getName(), new Function() {

                @SuppressWarnings("unused")
                public Object evaluate() throws Throwable {
                    return handler.invoke(proxy, method, new Object[0]);
                }
            });
        }
        return (T) proxy;
    }
}
