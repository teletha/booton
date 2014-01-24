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
import java.lang.invoke.MethodHandles;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import js.lang.NativeFunction;
import js.lang.reflect.Reflections;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/02 23:00:25
 */
@JavaAPIProvider(MethodHandle.class)
class JSMethodHandle {

    /** The actual reflection target. */
    Member member;

    /** The actual function. */
    private NativeFunction function;

    /**
     * @param method
     */
    JSMethodHandle(Method method) {
        this.member = method;

        function = Reflections.getPrototype(method.getDeclaringClass())
                .getPropertyAs(NativeFunction.class, Reflections.getPropertyName(method));
    }

    /**
     * @param field
     * @param b
     */
    JSMethodHandle(Field field, boolean setter) {
        this.member = field;
    }

    /**
     * 
     */
    private JSMethodHandle(NativeFunction function) {
        this.function = function;
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
    public Object invoke(Object context) throws Throwable {
        return function.apply(context);
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
    public Object invoke(Object context, Object param1) throws Throwable {
        return function.apply(context, param1);
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
    public Object invoke(Object context, Object param1, Object param2) throws Throwable {
        return function.apply(context, param1, param2);
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
    public Object invoke(Object context, Object param1, Object param2, Object param3) throws Throwable {
        return function.apply(context, param1, param2, param3);
    }

    /**
     * Binds a value {@code x} to the first argument of a method handle, without invoking it. The
     * new method handle adapts, as its <i>target</i>, the current method handle by binding it to
     * the given argument. The type of the bound handle will be the same as the type of the target,
     * except that a single leading reference parameter will be omitted.
     * <p>
     * When called, the bound handle inserts the given value {@code x} as a new leading argument to
     * the target. The other arguments are also passed unchanged. What the target eventually returns
     * is returned unchanged by the bound handle.
     * <p>
     * The reference {@code x} must be convertible to the first parameter type of the target.
     * <p>
     * (<em>Note:</em> Because method handles are immutable, the target method handle retains its
     * original type and behavior.)
     * 
     * @param x the value to bind to the first argument of the target
     * @return a new method handle which prepends the given value to the incoming argument list,
     *         before calling the original method handle
     * @throws IllegalArgumentException if the target does not have a leading parameter type that is
     *             a reference type
     * @throws ClassCastException if {@code x} cannot be converted to the leading parameter type of
     *             the target
     * @see MethodHandles#insertArguments
     */
    public MethodHandle bindTo(Object x) {
        return (MethodHandle) (Object) new JSMethodHandle(function.bind(x));
    }

    /**
     * Performs a variable arity invocation, passing the arguments in the given array to the method
     * handle, as if via an inexact {@link #invoke invoke} from a call site which mentions only the
     * type {@code Object}, and whose arity is the length of the argument array.
     * <p>
     * Specifically, execution proceeds as if by the following steps, although the methods are not
     * guaranteed to be called if the JVM can predict their effects.
     * <ul>
     * <li>Determine the length of the argument array as {@code N}. For a null reference,
     * {@code N=0}.</li>
     * <li>Determine the general type {@code TN} of {@code N} arguments as as
     * {@code TN=MethodType.genericMethodType(N)}.</li>
     * <li>Force the original target method handle {@code MH0} to the required type, as
     * {@code MH1 = MH0.asType(TN)}.</li>
     * <li>Spread the array into {@code N} separate arguments {@code A0, ...}.</li>
     * <li>Invoke the type-adjusted method handle on the unpacked arguments: MH1.invokeExact(A0,
     * ...).</li>
     * <li>Take the return value as an {@code Object} reference.</li>
     * </ul>
     * <p>
     * Because of the action of the {@code asType} step, the following argument conversions are
     * applied as necessary:
     * <ul>
     * <li>reference casting
     * <li>unboxing
     * <li>widening primitive conversions
     * </ul>
     * <p>
     * The result returned by the call is boxed if it is a primitive, or forced to null if the
     * return type is void.
     * <p>
     * This call is equivalent to the following code:
     * <p>
     * <blockquote>
     * 
     * <pre>
     * MethodHandle invoker = MethodHandles.spreadInvoker(this.type(), 0);
     * Object result = invoker.invokeExact(this, arguments);
     * </pre>
     * </blockquote>
     * <p>
     * Unlike the signature polymorphic methods {@code invokeExact} and {@code invoke},
     * {@code invokeWithArguments} can be accessed normally via the Core Reflection API and JNI. It
     * can therefore be used as a bridge between native or reflective code and method handles.
     * 
     * @param arguments the arguments to pass to the target
     * @return the result returned by the target
     * @throws ClassCastException if an argument cannot be converted by reference casting
     * @throws WrongMethodTypeException if the target's type cannot be adjusted to take the given
     *             number of {@code Object} arguments
     * @throws Throwable anything thrown by the target method invocation
     * @see MethodHandles#spreadInvoker
     */
    public Object invokeWithArguments(Object... arguments) throws Throwable {
        return function.apply(null, arguments);
    }
}
