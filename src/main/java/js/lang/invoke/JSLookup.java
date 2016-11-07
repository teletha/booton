/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import booton.translator.JavaAPIProvider;

/**
 * @version 2016/11/07 12:43:04
 */
@JavaAPIProvider(Lookup.class)
class JSLookup {

    /**
     * Creates a lookup on the specified new lookup class. The resulting object will report the
     * specified class as its own {@link #lookupClass lookupClass}.
     * <p>
     * However, the resulting {@code Lookup} object is guaranteed to have no more access
     * capabilities than the original. In particular, access capabilities can be lost as follows:
     * <ul>
     * <li>If the new lookup class differs from the old one, protected members will not be
     * accessible by virtue of inheritance. (Protected members may continue to be accessible because
     * of package sharing.)
     * <li>If the new lookup class is in a different package than the old one, protected and default
     * (package) members will not be accessible.
     * <li>If the new lookup class is not within the same package member as the old one, private
     * members will not be accessible.
     * <li>If the new lookup class is not accessible to the old lookup class, then no members, not
     * even public members, will be accessible. (In all other cases, public members will continue to
     * be accessible.)
     * </ul>
     *
     * @param requestedLookupClass the desired lookup class for the new lookup object
     * @return a lookup object which reports the desired lookup class
     * @throws NullPointerException if the argument is null
     */
    public Lookup in(Class<?> requestedLookupClass) {
        return (Lookup) (Object) this;
    }

    /**
     * Makes a direct method handle to <i>m</i>, if the lookup class has permission. If <i>m</i> is
     * non-static, the receiver argument is treated as an initial argument. If <i>m</i> is virtual,
     * overriding is respected on every call. Unlike the Core Reflection API, exceptions are
     * <em>not</em> wrapped. The type of the method handle will be that of the method, with the
     * receiver type prepended (but only if it is non-static). If the method's {@code accessible}
     * flag is not set, access checking is performed immediately on behalf of the lookup class. If
     * <i>m</i> is not public, do not share the resulting handle with untrusted parties.
     * <p>
     * The returned method handle will have {@linkplain MethodHandle#asVarargsCollector variable
     * arity} if and only if the method's variable arity modifier bit ({@code 0x0080}) is set.
     * 
     * @param method the reflected method
     * @return a method handle which can invoke the reflected method
     * @throws IllegalAccessException if access checking fails or if the method's variable arity
     *             modifier bit is set and {@code asVarargsCollector} fails
     * @throws NullPointerException if the argument is null
     */
    public MethodHandle unreflect(Method method) throws IllegalAccessException {
        return (MethodHandle) (Object) new JSMethodHandle(method);
    }

    /**
     * Produces a method handle giving read access to a reflected field. The type of the method
     * handle will have a return type of the field's value type. If the field is static, the method
     * handle will take no arguments. Otherwise, its single argument will be the instance containing
     * the field. If the field's {@code accessible} flag is not set, access checking is performed
     * immediately on behalf of the lookup class.
     * 
     * @param field the reflected field
     * @return a method handle which can load values from the reflected field
     * @throws IllegalAccessException if access checking fails
     * @throws NullPointerException if the argument is null
     */
    public MethodHandle unreflectGetter(Field field) throws IllegalAccessException {
        return (MethodHandle) (Object) new JSMethodHandle(field, false);
    }

    /**
     * Produces a method handle giving write access to a reflected field. The type of the method
     * handle will have a void return type. If the field is static, the method handle will take a
     * single argument, of the field's value type, the value to be stored. Otherwise, the two
     * arguments will be the instance containing the field, and the value to be stored. If the
     * field's {@code accessible} flag is not set, access checking is performed immediately on
     * behalf of the lookup class.
     * 
     * @param field the reflected field
     * @return a method handle which can store values into the reflected field
     * @throws IllegalAccessException if access checking fails
     * @throws NullPointerException if the argument is null
     */
    public MethodHandle unreflectSetter(Field field) throws IllegalAccessException {
        return (MethodHandle) (Object) new JSMethodHandle(field, true);
    }

    /**
     * Produces a method handle for a reflected method. It will bypass checks for overriding methods
     * on the receiver, <a href="MethodHandles.Lookup.html#equiv">as if called</a> from an
     * {@code invokespecial} instruction from within the explicitly specified {@code specialCaller}.
     * The type of the method handle will be that of the method, with a suitably restricted receiver
     * type prepended. (The receiver type will be {@code specialCaller} or a subtype.) If the
     * method's {@code accessible} flag is not set, access checking is performed immediately on
     * behalf of the lookup class, as if {@code invokespecial} instruction were being linked.
     * <p>
     * Before method resolution, if the explicitly specified caller class is not identical with the
     * lookup class, or if this lookup object does not have
     * <a href="MethodHandles.Lookup.html#privacc">private access</a> privileges, the access fails.
     * <p>
     * The returned method handle will have {@linkplain MethodHandle#asVarargsCollector variable
     * arity} if and only if the method's variable arity modifier bit ({@code 0x0080}) is set.
     * 
     * @param method the reflected method
     * @param specialCaller the class nominally calling the method
     * @return a method handle which can invoke the reflected method
     * @throws IllegalAccessException if access checking fails or if the method's variable arity
     *             modifier bit is set and {@code asVarargsCollector} fails
     * @throws NullPointerException if any argument is null
     */
    public MethodHandle unreflectSpecial(Method method, Class<?> specialCaller) throws IllegalAccessException {
        return (MethodHandle) (Object) new JSMethodHandle(method, specialCaller);
    }
}
