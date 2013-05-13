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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Method} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/01/17 20:45:34
 */
@JavaAPIProvider(Method.class)
class JSMethod extends JSAccessibleObject {

    /** The declaring class definition in runtime. */
    private NativeObject clazz;

    /** The cache for return type. */
    private final Class returnType;

    /** The parameter types. */
    private final Class[] parameterTypes;

    /**
     * <p>
     * Create native method.
     * </p>
     * 
     * @param name
     * @param clazz
     * @param annotations
     */
    JSMethod(String name, NativeObject clazz, NativeArray<Annotation> annotations) {
        super(name, annotations.slice(3));

        try {
            this.clazz = clazz;
            this.returnType = Class.forName(annotations.getPropertyAs(String.class, "1"));
            this.parameterTypes = convert(annotations.getPropertyAs(String[].class, "2"));
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Returns the name of the method represented by this Method object, as a String.
     * </p>
     * 
     * @return The simple name of the underlying member.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a {@code Class} object that represents the formal return type of the method
     * represented by this {@code Method} object.
     * 
     * @return the return type for the method this object represents
     */
    public Class<?> getReturnType() {
        return returnType;
    }

    /**
     * Returns an array of {@code Class} objects that represent the formal parameter types, in
     * declaration order, of the method represented by this {@code Method} object. Returns an array
     * of length 0 if the underlying method takes no parameters.
     * 
     * @return the parameter types for the method this object represents
     */
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    /**
     * <p>
     * Invokes the underlying method represented by this Method object, on the specified object with
     * the specified parameters. Individual parameters are automatically unwrapped to match
     * primitive formal parameters, and both primitive and reference parameters are subject to
     * method invocation conversions as necessary.
     * </p>
     * <p>
     * If the underlying method is static, then the specified obj argument is ignored. It may be
     * null.
     * </p>
     * <p>
     * If the number of formal parameters required by the underlying method is 0, the supplied args
     * array may be of length 0 or null.
     * </p>
     * <p>
     * If the underlying method is an instance method, it is invoked using dynamic method lookup as
     * documented in The Java Language Specification, Second Edition, section 15.12.4.4; in
     * particular, overriding based on the runtime type of the target object will occur.
     * </p>
     * <p>
     * If the underlying method is static, the class that declared the method is initialized if it
     * has not already been initialized.
     * </p>
     * <p>
     * If the method completes normally, the value it returns is returned to the caller of invoke;
     * if the value has a primitive type, it is first appropriately wrapped in an object. However,
     * if the value has the type of an array of a primitive type, the elements of the array are not
     * wrapped in objects; in other words, an array of primitive type is returned. If the underlying
     * method return type is void, the invocation returns null.
     * </p>
     * 
     * @param context The object the underlying method is invoked from.
     * @param parameters The arguments used for the method call.
     * @return The result of dispatching the method represented by this object on obj with
     *         parameters args.
     */
    public Object invoke(Object context, Object... parameters) {
        return ((NativeObject) context).getPropertyAs(NativeFunction.class, name).apply(context, parameters);
    }
}
