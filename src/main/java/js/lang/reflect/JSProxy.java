/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import js.lang.Function;
import js.lang.Global;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/19 15:23:57
 */
@JavaAPIProvider(Proxy.class)
class JSProxy {

    /** The class manager. */
    private static final Map<Integer, Class> classes = new HashMap();

    /**
     * Returns the invocation handler for the specified proxy instance.
     * 
     * @param proxy the proxy instance to return the invocation handler for
     * @return the invocation handler for the proxy instance
     * @throws IllegalArgumentException if the argument is not a proxy instance
     */
    public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException {
        if (!isProxyClass(proxy.getClass())) {
            throw new IllegalArgumentException("not a proxy instance");
        }
        return ((ProxyBase) proxy).handler;
    }

    /**
     * Returns true if and only if the specified class was dynamically generated to be a proxy class
     * using the {@code getProxyClass} method or the {@code newProxyInstance} method.
     * <p>
     * The reliability of this method is important for the ability to use it to make security
     * decisions, so its implementation should not just test if the class in question extends
     * {@code Proxy}.
     * 
     * @param clazz the class to test
     * @return {@code true} if the class is a proxy class and {@code false} otherwise
     * @throws NullPointerException if {@code cl} is {@code null}
     */
    public static boolean isProxyClass(Class<?> clazz) {
        Objects.requireNonNull(clazz);

        return ProxyBase.class.isAssignableFrom(clazz);
    }

    /**
     * <p>
     * Returns an instance of a proxy class for the specified interfaces that dispatches method
     * invocations to the specified invocation handler.
     * </p>
     * 
     * @param loader The class loader to define the proxy class.
     * @param interfaces The list of interfaces for the proxy class to implement.
     * @param handler The invocation handler to dispatch method invocations to.
     * @return A proxy instance with the specified invocation handler of a proxy class that is
     *         defined by the specified class loader and that implements the specified interfaces.
     */
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, final InvocationHandler handler) {
        // create interfaces list
        String[] names = new String[interfaces.length];

        for (int i = 0; i < names.length; i++) {
            names[i] = interfaces[i].getSimpleName();
        }

        // find proxy class
        Integer hash = Math.abs(Arrays.hashCode(names));
        Class clazz = classes.get(hash);

        if (clazz == null) {
            clazz = (Class) (Object) new ProxyClass(hash, names);
            classes.put(hash, clazz);
        }

        final NativeObject proxy = (NativeObject) (Object) new ProxyBase(clazz, handler);

        for (Class<?> interfaceType : interfaces) {
            for (final Method method : interfaceType.getMethods()) {
                proxy.setProperty(method.getName(), new Function() {

                    @SuppressWarnings("unused")
                    public Object evaluate() throws Throwable {
                        return handler.invoke(proxy, method, Global.getArgumentArray());
                    }
                });
            }
        }

        // NativeObject dummy = new NativeObject();
        // dummy.setProperty("$", clazz);
        // proxy.setProperty("$", dummy);

        // API definition
        return proxy;
    }

    /**
     * @version 2013/08/19 14:25:00
     */
    private static class ProxyBase {

        /** The type of this proxy. */
        private final Class type;

        /** The delegator. */
        private final InvocationHandler handler;

        /**
         * @param handler
         */
        private ProxyBase(Class type, InvocationHandler handler) {
            this.type = type;
            this.handler = handler;
        }

        @SuppressWarnings("unused")
        public Class $getClass() {
            return type;
        }
    }

    /**
     * @version 2013/08/19 14:33:20
     */
    private static class ProxyClass extends JSClass {

        /**
         * @param id
         * @param interfaces
         */
        private ProxyClass(int id, String[] interfaces) {
            super("Proxy" + id, new NativeObject(), new NativeObject(), ProxyBase.class, interfaces);
        }
    }
}
