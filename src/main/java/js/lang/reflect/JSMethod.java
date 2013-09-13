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
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

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
 * @version 2013/09/10 23:45:07
 */
@JavaAPIProvider(Method.class)
class JSMethod extends Parameterizable {

    /** The cache for return {@link Class}. */
    private Class returns;

    /** The cache for return {@link Type}. */
    private Type returnType;

    /**
     * <p>
     * Create native method.
     * </p>
     * 
     * @param nameJS
     * @param metadata
     */
    JSMethod(String nameJS, Class owner, NativeArray metadata) {
        super((String) metadata.get(5), nameJS, owner, metadata, 6);
    }

    /**
     * Returns {@code true} if this method was declared to take a variable number of arguments;
     * returns {@code false} otherwise.
     * 
     * @return {@code true} if an only if this method was declared to take a variable number of
     *         arguments.
     * @since 1.5
     */
    public boolean isVarArgs() {
        return (modifiers & JSModifier.VARARGS) != 0;
    }

    /**
     * Returns the default value for the annotation member represented by this {@code Method}
     * instance. If the member is of a primitive type, an instance of the corresponding wrapper type
     * is returned. Returns null if no default is associated with the member, or if the method
     * instance does not represent a declared member of an annotation type.
     * 
     * @return the default value for the annotation member represented by this {@code Method}
     *         instance.
     * @throws TypeNotPresentException if the annotation is of type {@link Class} and no definition
     *             can be found for the default class value.
     * @since 1.5
     */
    public Object getDefaultValue() {
        return null;
    }

    /**
     * Returns a {@code Class} object that represents the formal return type of the method
     * represented by this {@code Method} object.
     * 
     * @return the return type for the method this object represents
     */
    public Class<?> getReturnType() {
        if (returns == null) {
            returns = Signature.convert(getGenericReturnType());
        }
        return returns;
    }

    /**
     * Returns a {@code Type} object that represents the formal return type of the method
     * represented by this {@code Method} object.
     * <p>
     * If the return type is a parameterized type, the {@code Type} object returned must accurately
     * reflect the actual type parameters used in the source code.
     * <p>
     * If the return type is a type variable or a parameterized type, it is created. Otherwise, it
     * is resolved.
     * 
     * @return a {@code Type} object that represents the formal return type of the underlying method
     * @throws GenericSignatureFormatError if the generic method signature does not conform to the
     *             format specified in <cite>The Java&trade; Virtual Machine Specification</cite>
     * @throws TypeNotPresentException if the underlying method's return type refers to a
     *             non-existent type declaration
     * @throws MalformedParameterizedTypeException if the underlying method's return typed refers to
     *             a parameterized type that cannot be instantiated for any reason
     * @since 1.5
     */
    public Type getGenericReturnType() {
        if (returnType == null) {
            returnType = (Type) new Signature((String) metadata.get(4), owner).types.get(0);
            metadata.deleteProperty(4);
        }
        return returnType;
    }

    /**
     * Returns an array of arrays that represent the annotations on the formal parameters, in
     * declaration order, of the method represented by this {@code Method} object. (Returns an array
     * of length zero if the underlying method is parameterless. If the method has one or more
     * parameters, a nested array of length zero is returned for each parameter with no
     * annotations.) The annotation objects contained in the returned arrays are serializable. The
     * caller of this method is free to modify the returned arrays; it will have no effect on the
     * arrays returned to other callers.
     * 
     * @return an array of arrays that represent the annotations on the formal parameters, in
     *         declaration order, of the method represented by this Method object
     * @since 1.5
     */
    public Annotation[][] getParameterAnnotations() {
        int size = getParameterTypes().length;

        return null;
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
        return ((NativeObject) context).getPropertyAs(NativeFunction.class, nameJS).apply(context, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int mod = getModifiers() & Modifier.methodModifiers();

        if (mod != 0) {
            builder.append(Modifier.toString(mod)).append(' ');
        }
        builder.append(getTypeName(getReturnType())).append(' ');
        builder.append(getTypeName(getDeclaringClass())).append('.');
        builder.append(getName()).append('(');
        Class<?>[] params = getParameterTypes(); // avoid clone
        for (int j = 0; j < params.length; j++) {
            builder.append(getTypeName(params[j]));
            if (j < (params.length - 1)) {
                builder.append(',');
            }
        }
        builder.append(')');
        return builder.toString();
    }

    /*
     * Utility routine to paper over array type names
     */
    static String getTypeName(Class<?> type) {
        if (type.isArray()) {
            Class<?> cl = type;
            int dimensions = 0;
            while (cl.isArray()) {
                dimensions++;
                cl = cl.getComponentType();
            }
            StringBuffer sb = new StringBuffer();
            sb.append(cl.getName());
            for (int i = 0; i < dimensions; i++) {
                sb.append("[]");
            }
            return sb.toString();
        }
        return type.getName();
    }
}
