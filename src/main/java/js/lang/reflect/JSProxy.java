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

import js.lang.Function;
import js.lang.NativeGlobal;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/19 13:58:34
 */
@JavaAPIProvider(Proxy.class)
class JSProxy {

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
        final NativeObject proxy = new NativeObject();

        for (Class<?> interfaceType : interfaces) {
            for (final Method method : interfaceType.getMethods()) {
                proxy.setProperty(method.getName(), new Function() {

                    @SuppressWarnings("unused")
                    public Object evaluate() throws Throwable {
                        return handler.invoke(proxy, method, NativeGlobal.getArgumentArray());
                    }
                });
            }
        }
        return proxy;
    }
}
