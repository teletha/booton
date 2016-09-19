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
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Member;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/24 15:24:47
 */
@JavaAPIProvider(MethodHandles.class)
class JSMethodHandles {

    /**
     * Returns a {@link Lookup lookup object} on the caller, which has the capability to access any
     * method handle that the caller has access to, including direct method handles to private
     * fields and methods. This lookup object is a <em>capability</em> which may be delegated to
     * trusted agents. Do not store it in place where untrusted code can access it.
     */
    public static Lookup lookup() {
        return (Lookup) (Object) new JSLookup();
    }

    /**
     * Performs an unchecked "crack" of a <a href="MethodHandleInfo.html#directmh">direct method
     * handle</a>. The result is as if the user had obtained a lookup object capable enough to crack
     * the target method handle, called {@link java.lang.invoke.MethodHandles.Lookup#revealDirect
     * Lookup.revealDirect} on the target to obtain its symbolic reference, and then called
     * {@link java.lang.invoke.MethodHandleInfo#reflectAs MethodHandleInfo.reflectAs} to resolve the
     * symbolic reference to a member.
     * <p>
     * If there is a security manager, its {@code checkPermission} method is called with a
     * {@code ReflectPermission("suppressAccessChecks")} permission.
     * 
     * @param <T> the desired type of the result, either {@link Member} or a subtype
     * @param target a direct method handle to crack into symbolic reference components
     * @param expected a class object representing the desired result type {@code T}
     * @return a reference to the method, constructor, or field object
     * @exception SecurityException if the caller is not privileged to call {@code setAccessible}
     * @exception NullPointerException if either argument is {@code null}
     * @exception IllegalArgumentException if the target is not a direct method handle
     * @exception ClassCastException if the member is not of the expected type
     * @since 1.8
     */
    public static <T extends Member> T reflectAs(Class<T> expected, MethodHandle target) {
        return expected.cast(((JSMethodHandle) (Object) target).member);
    }
}
