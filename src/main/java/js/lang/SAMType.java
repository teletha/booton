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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/08/19 0:21:37
 */
public class SAMType<T> {

    /** The single abstract method. */
    private final Method method;

    /**
     * <p>
     * Create function like type.
     * </p>
     * 
     * @param functional
     */
    public SAMType(T functional) {
        this((Class<T>) functional.getClass());
    }

    /**
     * <p>
     * Create function like type.
     * </p>
     * 
     * @param functional
     */
    public SAMType(Class<T> functional) {
        this.method = findSAM(functional);
    }

    /**
     * <p>
     * Find functional method from the specified {@link Class}.
     * </p>
     * 
     * @param type
     * @return
     */
    private static Method findSAM(Class type) {
        List<Method> methods = new ArrayList();

        for (Method method : type.getDeclaredMethods()) {
            if (method.isBridge() || method.isSynthetic()) {
                continue;
            }

            if (isObjectMethod(method)) {
                continue;
            }
            methods.add(method);
        }

        if (methods.size() != 1) {
            throw new IllegalArgumentException(type + " is not functional type.");
        }
        return methods.get(0);
    }

    /**
     * <p>
     * Check method signature.
     * </p>
     * 
     * @param method
     * @return
     */
    private static boolean isObjectMethod(Method method) {
        try {
            Object.class.getMethod(method.getName(), method.getParameterTypes());
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
