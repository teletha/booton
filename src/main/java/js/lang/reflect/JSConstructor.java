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
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.util.List;

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

    /** The method metadata. */
    private final NativeArray<?> metadata;

    /** The declared class definition in runtime. */
    private NativeObject clazz;

    /** The constructor function in runtime. */
    private final NativeFunction function;

    /** The cache for parameter {@link Class}. */
    private List<Class> parameters;

    /** The cache for parameter {@link Type}. */
    private List<Type> parameterTypes;

    /** The cache for exception {@link Class}. */
    private List<Class> exceptions;

    /** The cache for exception {@link Type}. */
    private List<Type> exceptionTypes;

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
    JSConstructor(String name, Class owner, NativeObject clazz, NativeFunction function, NativeArray metadata) {
        super(name, name, owner, metadata, 3);

        this.metadata = metadata;
        this.clazz = clazz;
        this.function = function;
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
     * Returns an array of {@code Class} objects that represent the formal parameter types, in
     * declaration order, of the constructor represented by this {@code Constructor} object. Returns
     * an array of length 0 if the underlying constructor takes no parameters.
     * 
     * @return the parameter types for the constructor this object represents
     */
    public Class<?>[] getParameterTypes() {
        if (parameters == null) {
            parameters = convert(getGenericParameterTypes());
        }
        return parameters.toArray(new Class[parameters.size()]);
    }

    /**
     * Returns an array of {@code Type} objects that represent the formal parameter types, in
     * declaration order, of the method represented by this {@code Constructor} object. Returns an
     * array of length 0 if the underlying method takes no parameters.
     * <p>
     * If a formal parameter type is a parameterized type, the {@code Type} object returned for it
     * must accurately reflect the actual type parameters used in the source code.
     * <p>
     * If a formal parameter type is a type variable or a parameterized type, it is created.
     * Otherwise, it is resolved.
     * 
     * @return an array of {@code Type}s that represent the formal parameter types of the underlying
     *         method, in declaration order
     * @throws GenericSignatureFormatError if the generic method signature does not conform to the
     *             format specified in <cite>The Java&trade; Virtual Machine Specification</cite>
     * @throws TypeNotPresentException if any of the parameter types of the underlying method refers
     *             to a non-existent type declaration
     * @throws MalformedParameterizedTypeException if any of the underlying method's parameter types
     *             refer to a parameterized type that cannot be instantiated for any reason
     * @since 1.5
     */
    public Type[] getGenericParameterTypes() {
        if (parameterTypes == null) {
            parameterTypes = new Signature((String) metadata.get(1), owner).types;
            metadata.deleteProperty(1);
        }
        return parameterTypes.toArray(new Type[parameterTypes.size()]);
    }

    /**
     * Returns an array of {@code Class} objects that represent the types of exceptions declared to
     * be thrown by the underlying constructor represented by this {@code Constructor} object.
     * Returns an array of length 0 if the constructor declares no exceptions in its {@code throws}
     * clause.
     * 
     * @return the exception types declared as being thrown by the constructor this object
     *         represents
     */
    public Class<?>[] getExceptionTypes() {
        if (exceptions == null) {
            exceptions = convert(getGenericExceptionTypes());
        }
        return exceptions.toArray(new Class[exceptions.size()]);
    }

    /**
     * Returns an array of {@code Type} objects that represent the exceptions declared to be thrown
     * by this {@code Constructor} object. Returns an array of length 0 if the underlying method
     * declares no exceptions in its {@code throws} clause.
     * <p>
     * If an exception type is a type variable or a parameterized type, it is created. Otherwise, it
     * is resolved.
     * 
     * @return an array of Types that represent the exception types thrown by the underlying method
     * @throws GenericSignatureFormatError if the generic method signature does not conform to the
     *             format specified in <cite>The Java&trade; Virtual Machine Specification</cite>
     * @throws TypeNotPresentException if the underlying method's {@code throws} clause refers to a
     *             non-existent type declaration
     * @throws MalformedParameterizedTypeException if the underlying method's {@code throws} clause
     *             refers to a parameterized type that cannot be instantiated for any reason
     * @since 1.5
     */
    public Type[] getGenericExceptionTypes() {
        if (exceptionTypes == null) {
            exceptionTypes = new Signature((String) metadata.get(2), owner).types;
            metadata.deleteProperty(2);
        }
        return exceptionTypes.toArray(new Type[exceptionTypes.size()]);
    }
}
