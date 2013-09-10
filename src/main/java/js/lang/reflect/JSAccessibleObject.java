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

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;

import js.lang.NativeArray;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/11 0:19:34
 */
@JavaAPIProvider(AccessibleObject.class)
abstract class JSAccessibleObject extends JSAnnotatedElement implements Member {

    /** The declaring class. */
    protected final Class owner;

    /**
     * @param name The property name at Java definition.
     * @param nameJS The property name at JavaScript runtime.
     * @param metadata
     */
    protected JSAccessibleObject(String name, String nameJS, Class owner, NativeArray metadata, int indexForAnnotation) {
        super(name, nameJS, metadata, (NativeObject) metadata.get(indexForAnnotation));

        this.owner = owner;
    }

    /**
     * Set the {@code accessible} flag for this object to the indicated boolean value. A value of
     * {@code true} indicates that the reflected object should suppress Java language access
     * checking when it is used. A value of {@code false} indicates that the reflected object should
     * enforce Java language access checks.
     * <p>
     * First, if there is a security manager, its {@code checkPermission} method is called with a
     * {@code ReflectPermission("suppressAccessChecks")} permission.
     * <p>
     * A {@code SecurityException} is raised if {@code flag} is {@code true} but accessibility of
     * this object may not be changed (for example, if this element object is a {@link Constructor}
     * object for the class {@link java.lang.Class}).
     * <p>
     * A {@code SecurityException} is raised if this object is a
     * {@link java.lang.reflect.Constructor} object for the class {@code java.lang.Class}, and
     * {@code flag} is true.
     * 
     * @param flag the new value for the {@code accessible} flag
     * @throws SecurityException if the request is denied.
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     */
    public void setAccessible(boolean flag) throws SecurityException {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class<?> getDeclaringClass() {
        return owner;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isSynthetic() {
        return (modifiers & JSModifier.SYNTHETIC) != 0;
    }
}
