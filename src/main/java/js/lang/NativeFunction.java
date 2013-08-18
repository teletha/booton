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

import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2013/08/18 13:06:42
 */
public class NativeFunction extends NativeObject {

    /** The actual method. */
    private final Method method;

    /**
     * @param method
     */
    public NativeFunction(Method method) {
        this.method = method;
    }

    /**
     * <p>
     * Create function statement form the specified object which has only one method.
     * </p>
     * 
     * @param functional
     */
    public NativeFunction(Object functional) {
        this.method = findFunction(functional.getClass());
    }

    /**
     * <p>
     * Calls a function with a given this value and arguments provided as an array (or an array like
     * object).
     * </p>
     * 
     * @param context The value of this provided for the call to fun. Note that this may not be the
     *            actual value seen by the method: if the method is a function in non-strict mode
     *            code, null and undefined will be replaced with the global object, and primitive
     *            values will be boxed.
     * @param parameters An array like object, specifying the arguments with which fun should be
     *            called, or null or undefined if no arguments should be provided to the function.
     * @return A invocation result of this function.
     */
    public Object apply(Object context, Object[] parameters) {
        return null;
    }

    /**
     * <p>
     * Creates a new function that, when called, has its this keyword set to the provided value,
     * with a given sequence of arguments preceding any provided when the new function is called.
     * </p>
     * 
     * @param context The value to be passed as the this parameter to the target function when the
     *            bound function is called. The value is ignored if the bound function is
     *            constructed using the new operator.
     * @return A new function.
     */
    public NativeFunction bind(Object context) {
        return null;
    }

    /**
     * <p>
     * Create the binded function form the specified object which has only one method.
     * </p>
     * 
     * @param functional
     * @return
     */
    public static NativeFunction by(Object functional) {
        return new NativeFunction(functional).bind(functional);
    }

    /**
     * <p>
     * Find functional method from the specified {@link Class}.
     * </p>
     * 
     * @param type
     * @return
     */
    private static Method findFunction(Class type) {
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

    /**
     * @version 2013/08/18 13:06:39
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeFunction> {

        /**
         * <p>
         * Create function statement form the specified object which has only one method.
         * </p>
         * 
         * @param functional
         */
        public String NativeFunction(Object functional) {
            return param(0) + "." + Javascript.computeMethodName(findFunction(type(0)));
        }

        /**
         * <p>
         * Calls a function with a given this value and arguments provided as an array (or an array
         * like object).
         * </p>
         * 
         * @param context The value of this provided for the call to fun. Note that this may not be
         *            the actual value seen by the method: if the method is a function in non-strict
         *            mode code, null and undefined will be replaced with the global object, and
         *            primitive values will be boxed.
         * @param parameters An array like object, specifying the arguments with which fun should be
         *            called, or null or undefined if no arguments should be provided to the
         *            function.
         * @return A invocation result of this function.
         */
        public String apply(Object context, Object[] parameters) {
            return that + ".apply(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Creates a new function that, when called, has its this keyword set to the provided value,
         * with a given sequence of arguments preceding any provided when the new function is
         * called.
         * </p>
         * 
         * @param context The value to be passed as the this parameter to the target function when
         *            the bound function is called. The value is ignored if the bound function is
         *            constructed using the new operator.
         * @return A new function.
         */
        public String bind(Object context) {
            return that + ".bind(" + param(0) + ")";
        }

        /**
         * <p>
         * Create the binded function form the specified object which has only one method.
         * </p>
         * 
         * @param functional
         * @return
         */
        public String by(Object functional) {
            return NativeFunction(functional) + ".bind(" + param(0) + ")";
        }
    }
}
