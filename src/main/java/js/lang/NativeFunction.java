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
import java.util.Arrays;
import java.util.List;

import kiss.I;
import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2013/08/19 16:39:08
 */
public class NativeFunction<T> extends NativeObject {

    /** The empty flag. */
    private static final Object EMPTY = new Object();

    /** The single abstract method type. */
    final T type;

    /** The actual method. */
    final Method method;

    /** The binded context. */
    private T context;

    /** The binded parameters. */
    private final List parameters = new ArrayList();

    /**
     * <p>
     * Create function statement form the specified object which has only one method.
     * </p>
     * 
     * @param functional
     */
    public NativeFunction(T functional) {
        this(functional, findSAM(functional.getClass()), null, null);
    }

    /**
     * <p>
     * Create function statement form the specified object which has only one method.
     * </p>
     * 
     * @param functional
     */
    public NativeFunction(T functional, Method method) {
        this(functional, method, null, null);
    }

    /**
     * <p>
     * Create function statement form the specified object which has only one method.
     * </p>
     * 
     * @param functional
     */
    private NativeFunction(T functional, Method method, T context, List parameters) {
        method.setAccessible(true);

        this.type = functional;
        this.method = method;

        setContext(context);

        if (parameters != null) {
            this.parameters.addAll(parameters);
        }
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
    public Object apply(T context, Object... parameters) {
        try {
            return method.invoke(this.context == EMPTY ? context : this.context, parameter(parameters));
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Create valid parameter list.
     * </p>
     * 
     * @param parameters
     * @return
     */
    private Object[] parameter(Object[] parameters) {
        List list = new ArrayList(this.parameters);
        list.addAll(Arrays.asList(parameters));

        int size = method.getParameterTypes().length;

        if (size < list.size()) {
            list = list.subList(0, size);
        }

        if (list.size() < size) {
            for (int i = list.size(); i < size; i++) {
                list.add(null);
            }
        }

        return list.toArray();
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
    public NativeFunction<T> bind(T context) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4, Object p5) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);
        function.parameters.add(p5);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);
        function.parameters.add(p5);
        function.parameters.add(p6);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);
        function.parameters.add(p5);
        function.parameters.add(p6);
        function.parameters.add(p7);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);
        function.parameters.add(p5);
        function.parameters.add(p6);
        function.parameters.add(p7);
        function.parameters.add(p8);

        return function;
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
     * @param parameter Arguments to prepend to arguments provided to the bound function when
     *            invoking the target function.
     * @return A new function.
     */
    public NativeFunction<T> bind(T context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        NativeFunction<T> function = new NativeFunction(type, method, context, this.parameters);
        function.setContext(context);
        function.parameters.add(p1);
        function.parameters.add(p2);
        function.parameters.add(p3);
        function.parameters.add(p4);
        function.parameters.add(p5);
        function.parameters.add(p6);
        function.parameters.add(p7);
        function.parameters.add(p8);
        function.parameters.add(p9);

        return function;
    }

    /**
     * <p>
     * Helper method to set context object.
     * </p>
     * 
     * @param context
     */
    private void setContext(T context) {
        this.context = context == null ? (T) EMPTY : context;
    }

    /**
     * <p>
     * Find functional method from the specified {@link Class}.
     * </p>
     * 
     * @param type
     * @return
     */
    public static Method findSAM(Class type) {
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
     * @version 2013/08/19 12:57:55
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
            return param(0) + "." + Javascript.computeMethodName(findSAM(type(0)));
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
         * Creates a new function that, when called, has its this keyword set to the provided value,
         * with a given sequence of arguments preceding any provided when the new function is
         * called.
         * </p>
         * 
         * @param context The value to be passed as the this parameter to the target function when
         *            the bound function is called. The value is ignored if the bound function is
         *            constructed using the new operator.
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1) {
            return that + ".bind(" + param(0) + "," + param(1) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4, Object p5) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + "," + param(5) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + "," + param(5) + "," + param(6) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + "," + param(5) + "," + param(6) + "," + param(7) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + "," + param(5) + "," + param(6) + "," + param(7) + "," + param(8) + ")";
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
         * @param parameter Arguments to prepend to arguments provided to the bound function when
         *            invoking the target function.
         * @return A new function.
         */
        public String bind(Object context, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
            return that + ".bind(" + param(0) + "," + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + "," + param(5) + "," + param(6) + "," + param(7) + "," + param(8) + "," + param(9) + ")";
        }
    }
}
