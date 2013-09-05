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

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Constructor} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/01/17 20:45:34
 */
@JavaAPIProvider(Constructor.class)
class JSConstructor<T> extends JSAccessibleObject {

    /** The declared class definition in runtime. */
    private NativeObject clazz;

    /** The modifier value. */
    private final int modifiers;

    /** The constructor function in runtime. */
    private final NativeFunction function;

    /** The parameter type names. */
    private final String[] parameterTypeNames;

    /** The cache for parameter types. */
    private Class[] parameterTypes;

    /**
     * <p>
     * Create native constructor.
     * </p>
     * 
     * @param name
     * @param clazz
     * @param function
     * @param metadata
     */
    JSConstructor(String name, NativeObject clazz, NativeFunction function, NativeArray metadata) {
        super(name, name, (NativeObject) metadata.get(2));

        this.clazz = clazz;
        this.modifiers = metadata.getAsInt(0);
        this.function = function;
        this.parameterTypeNames = metadata.getPropertyAs(String[].class, "1");
    }

    /**
     * Returns the Java language modifiers for the constructor represented by this
     * {@code Constructor} object, as an integer. The {@code Modifier} class should be used to
     * decode the modifiers.
     * 
     * @see Modifier
     */
    public int getModifiers() {
        return modifiers;
    }

    /**
     * <p>
     * Uses the constructor represented by this Constructor object to create and initialize a new
     * instance of the constructor's declaring class, with the specified initialization parameters.
     * Individual parameters are automatically unwrapped to match primitive formal parameters, and
     * both primitive and reference parameters are subject to method invocation conversions as
     * necessary.
     * </p>
     * 
     * @param parameters Array of objects to be passed as arguments to the constructor call; values
     *            of primitive types are wrapped in a wrapper object of the appropriate type (e.g. a
     *            float in a Float).
     * @return A new object created by calling the constructor this object represents.
     */
    public T newInstance(Object... parameters) {
        // create new instance
        Object instance = clazz.create();

        // invoke function
        function.apply(instance, parameters);

        // API definition
        return (T) instance;
    }

    /**
     * Returns {@code true} if this constructor is a synthetic constructor; returns {@code false}
     * otherwise.
     * 
     * @return true if and only if this constructor is a synthetic constructor as defined by
     *         <cite>The Java&trade; Language Specification</cite>.
     * @since 1.5
     */
    public boolean isSynthetic() {
        return false;
    }

    /**
     * Returns an array of {@code Class} objects that represent the formal parameter types, in
     * declaration order, of the constructor represented by this {@code Constructor} object. Returns
     * an array of length 0 if the underlying constructor takes no parameters.
     * 
     * @return the parameter types for the constructor this object represents
     */
    public Class<?>[] getParameterTypes() {
        if (parameterTypes == null) {
            parameterTypes = new Class[parameterTypeNames.length];

            for (int i = 0; i < parameterTypeNames.length; i++) {
                try {
                    parameterTypes[i] = Class.forName(parameterTypeNames[i]);
                } catch (ClassNotFoundException e) {
                    // If this exception will be thrown, it is bug of this program. So we must
                    // rethrow the wrapped error in here.
                    throw new Error(e);
                }
            }
        }
        return parameterTypes;
    }

}
