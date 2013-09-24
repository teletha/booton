/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 23:07:23
 */
@JavaAPIProvider(MethodHandle.class)
class JSMethodHandle {

    /**
     * @param method
     */
    JSMethodHandle(Method method) {
    }

    /**
     * @param field
     * @param b
     */
    JSMethodHandle(Field field, boolean setter) {
    }

    /**
     * Invokes the method handle, allowing any caller type descriptor, and optionally performing
     * conversions on arguments and return values.
     * <p>
     * If the call site's symbolic type descriptor exactly matches this method handle's
     * {@link #type type}, the call proceeds as if by {@link #invokeExact invokeExact}.
     * <p>
     * Otherwise, the call proceeds as if this method handle were first adjusted by calling
     * {@link #asType asType} to adjust this method handle to the required type, and then the call
     * proceeds as if by {@link #invokeExact invokeExact} on the adjusted method handle.
     * <p>
     * There is no guarantee that the {@code asType} call is actually made. If the JVM can predict
     * the results of making the call, it may perform adaptations directly on the caller's
     * arguments, and call the target method handle according to its own exact type.
     * <p>
     * The resolved type descriptor at the call site of {@code invoke} must be a valid argument to
     * the receivers {@code asType} method. In particular, the caller must specify the same argument
     * arity as the callee's type, if the callee is not a {@linkplain #asVarargsCollector variable
     * arity collector}.
     * <p>
     * When this method is observed via the Core Reflection API, it will appear as a single native
     * method, taking an object array and returning an object. If this native method is invoked
     * directly via {@link java.lang.reflect.Method#invoke java.lang.reflect.Method.invoke}, via
     * JNI, or indirectly via {@link java.lang.invoke.MethodHandles.Lookup#unreflect
     * Lookup.unreflect}, it will throw an {@code UnsupportedOperationException}.
     * 
     * @throws WrongMethodTypeException if the target's type cannot be adjusted to the caller's
     *             symbolic type descriptor
     * @throws ClassCastException if the target's type can be adjusted to the caller, but a
     *             reference cast fails
     * @throws Throwable anything thrown by the underlying method propagates unchanged through the
     *             method handle call
     */
    public Object invoke(Object o1) throws Throwable {
        return null;
    }

    /**
     * Invokes the method handle, allowing any caller type descriptor, and optionally performing
     * conversions on arguments and return values.
     * <p>
     * If the call site's symbolic type descriptor exactly matches this method handle's
     * {@link #type type}, the call proceeds as if by {@link #invokeExact invokeExact}.
     * <p>
     * Otherwise, the call proceeds as if this method handle were first adjusted by calling
     * {@link #asType asType} to adjust this method handle to the required type, and then the call
     * proceeds as if by {@link #invokeExact invokeExact} on the adjusted method handle.
     * <p>
     * There is no guarantee that the {@code asType} call is actually made. If the JVM can predict
     * the results of making the call, it may perform adaptations directly on the caller's
     * arguments, and call the target method handle according to its own exact type.
     * <p>
     * The resolved type descriptor at the call site of {@code invoke} must be a valid argument to
     * the receivers {@code asType} method. In particular, the caller must specify the same argument
     * arity as the callee's type, if the callee is not a {@linkplain #asVarargsCollector variable
     * arity collector}.
     * <p>
     * When this method is observed via the Core Reflection API, it will appear as a single native
     * method, taking an object array and returning an object. If this native method is invoked
     * directly via {@link java.lang.reflect.Method#invoke java.lang.reflect.Method.invoke}, via
     * JNI, or indirectly via {@link java.lang.invoke.MethodHandles.Lookup#unreflect
     * Lookup.unreflect}, it will throw an {@code UnsupportedOperationException}.
     * 
     * @throws WrongMethodTypeException if the target's type cannot be adjusted to the caller's
     *             symbolic type descriptor
     * @throws ClassCastException if the target's type can be adjusted to the caller, but a
     *             reference cast fails
     * @throws Throwable anything thrown by the underlying method propagates unchanged through the
     *             method handle call
     */
    public Object invoke(Object o1, Object o2) throws Throwable {
        return null;
    }
}
