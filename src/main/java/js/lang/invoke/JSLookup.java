/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2013/09/24 23:06:20
 */
@JavaAPIProvider(Lookup.class)
class JSLookup {

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
}
