/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import java.lang.reflect.Method;

import kiss.Disposable;

/**
 * @version 2013/08/02 10:12:53
 */
public class Binder {

    /**
     * <p>
     * Bind properties.
     * </p>
     * 
     * @param context
     * @param source
     * @return
     */
    public static Disposable bind(Object context, Object source) {
        for (Method method : context.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Bind.class)) {
                Class[] params = method.getParameterTypes();

                if (params.length != 1) {
                    throw new IllegalArgumentException("Bind method must have only one parameter.");
                }

                // compute parameter
                Object param = search(params[0], source);

                // initial binding
                try {
                    method.setAccessible(true);
                    method.invoke(context, param);
                } catch (Exception e) {
                    // If this exception will be thrown, it is bug of this program. So we must
                    // rethrow the wrapped error in here.
                    throw new Error(e);
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Search valid parameter.
     * </p>
     * 
     * @param sources
     * @return
     */
    private static Object search(Class type, Object... sources) {
        for (Object source : sources) {
            if (source != null && source.getClass() == type) {
                return source;
            }
        }
        throw new IllegalArgumentException("There is no binding method which has " + type.getName() + " parameter.");
    }
}