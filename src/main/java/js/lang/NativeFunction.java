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

import booton.translator.Translator;

/**
 * @version 2013/05/20 14:59:09
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
     * @version 2013/05/20 14:59:20
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeFunction> {

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
    }
}
