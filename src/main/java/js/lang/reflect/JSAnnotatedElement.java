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
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/10 23:43:34
 */
@JavaAPIProvider(AnnotatedElement.class)
abstract class JSAnnotatedElement {

    /** The property name at Java definition. */
    protected final String name;

    /** The property name at JavaScript runtime. */
    protected final String nameJS;

    /** The modifier value. */
    protected final int modifiers;

    /** The metadata definition in runtime. */
    protected final NativeArray<?> metadata;

    /** The annotation definition in runtime. */
    protected final NativeObject annotations;

    /** The cache for declaration {@link TypeVariable}. */
    private List<Type> types;

    private Map<Class, Annotation> annotationList;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name The property name at Java definition.
     * @param nameJS The property name at JavaScript runtime.
     * @param metadata A metadata difinition.
     * @param annotations
     */
    protected JSAnnotatedElement(String name, String nameJS, NativeArray metadata, NativeObject annotations) {
        this.name = name;
        this.nameJS = nameJS;
        this.metadata = metadata;
        this.annotations = annotations.getProperty("$", new NativeObject());
        this.modifiers = metadata.getAsInt(0);
    }

    /**
     * Returns the Java language modifiers for this class or interface, encoded in an integer. The
     * modifiers consist of the Java Virtual Machine's constants for {@code public},
     * {@code protected}, {@code private}, {@code final}, {@code static}, {@code abstract} and
     * {@code interface}; they should be decoded using the methods of class {@code Modifier}.
     * <p>
     * If the underlying class is an array class, then its {@code public}, {@code private} and
     * {@code protected} modifiers are the same as those of its component type. If this
     * {@code Class} represents a primitive type or void, its {@code public} modifier is always
     * {@code true}, and its {@code protected} and {@code private} modifiers are always
     * {@code false}. If this object represents an array class, a primitive type or void, then its
     * {@code final} modifier is always {@code true} and its interface modifier is always
     * {@code false}. The values of its other modifiers are not determined by this specification.
     * <p>
     * The modifier encodings are defined in <em>The Java Virtual Machine
     * Specification</em>, table 4.1.
     * 
     * @return the {@code int} representing the modifiers for this class
     * @see java.lang.reflect.Modifier
     * @since JDK1.1
     */
    public final int getModifiers() {
        return modifiers;
    }

    /**
     * Returns an array of {@code TypeVariable} objects that represent the type variables declared
     * by the generic declaration represented by this {@code GenericDeclaration} object, in
     * declaration order. Returns an array of length 0 if the underlying generic declaration
     * declares no type variables.
     * 
     * @return an array of {@code TypeVariable} objects that represent the type variables declared
     *         by this generic declaration
     * @throws java.lang.reflect.GenericSignatureFormatError if the generic signature of this
     *             generic declaration does not conform to the format specified in <cite>The
     *             Java&trade; Virtual Machine Specification</cite>
     * @since 1.5
     */
    public final TypeVariable<Class>[] getTypeParameters() {
        if (types == null) {
            types = new Signature((String) metadata.get(1), (GenericDeclaration) this).types;
            metadata.deleteProperty(1);
        }
        return types.toArray(new TypeVariable[types.size()]);
    }

    /**
     * <p>
     * Returns true if an annotation for the specified type is present on this element, else false.
     * This method is designed primarily for convenient access to marker annotations.
     * </p>
     * 
     * @param annotationClass The Class object corresponding to the annotation type.
     * @return True if an annotation for the specified annotation type is present on this element, .
     *         else false.
     */
    public final <A extends Annotation> boolean isAnnotationPresent(Class<A> annotationClass) {
        return annotations.hasOwnProperty(annotationClass.getSimpleName());
    }

    /**
     * <p>
     * Returns this element's annotation for the specified type if such an annotation is present,
     * else null.
     * </p>
     * 
     * @param annotationClass The Class object corresponding to the annotation type.
     * @return This element's annotation for the specified annotation type if present on this
     *         element, else null.
     */
    public final <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        // if (annotationList == null) {
        // getAnnotations();
        // }
        // return annotationList.get(annotationClass);

        if (annotations != null) {
            String name = annotationClass.getSimpleName();

            if (annotations.hasOwnProperty(name)) {
                Object value = annotations.getProperty(name);
                System.out.println("@ " + name);
                if (!(value instanceof Annotation)) {
                    value = Proxy.newProxyInstance(null, new Class[] {annotationClass}, new AnnotationProxy(annotationClass, value));

                    // update as annotation instance
                    annotations.setProperty(name, value);
                }
                return (A) value;
            }
        }
        return null;
    }

    /**
     * <p>
     * Returns all annotations present on this element. (Returns an array of length zero if this
     * element has no annotations.) The caller of this method is free to modify the returned array;
     * it will have no effect on the arrays returned to other callers.
     * </p>
     * 
     * @return All annotations present on this element.
     */
    public final Annotation[] getAnnotations() {
        if (annotationList == null) {
            annotationList = new HashMap();

            for (String name : annotations.keys()) {
                Class type = JSClass.forName(name);
                System.out.println(name);
                annotationList.put(type, (Annotation) Proxy.newProxyInstance(null, new Class[] {type}, new AnnotationProxy(type, annotations.getProperty(name))));
            }
        }
        return annotationList.values().toArray(new Annotation[annotationList.size()]);
    }

    /**
     * <p>
     * Returns all annotations that are directly present on this element. Unlike the other methods
     * in this interface, this method ignores inherited annotations. (Returns an array of length
     * zero if no annotations are directly present on this element.) The caller of this method is
     * free to modify the returned array; it will have no effect on the arrays returned to other
     * callers.
     * </p>
     * 
     * @return All annotations directly present on this element.
     */
    public final Annotation[] getDeclaredAnnotations() {
        return getAnnotations();
    }

    /**
     * <p>
     * Helper method to conver {@link Type} to {@link Class}.
     * </p>
     * 
     * @param types
     * @return
     */
    protected List<Class> convert(Type[] types) {
        List<Class> classes = new ArrayList();

        for (Type type : types) {
            classes.add(Signature.convert(type));
        }
        return classes;
    }

    /**
     * @version 2013/09/03 1:42:36
     */
    private static class AnnotationProxy implements InvocationHandler {

        /** The annotation class. */
        private final Class<? extends Annotation> type;

        /** The properties. */
        private final NativeObject object;

        /**
         * @param type
         * @param object
         */
        private AnnotationProxy(Class type, Object object) {
            this.type = type;
            this.object = (NativeObject) object;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            NativeFunction function = object.getPropertyAs(NativeFunction.class, ((JSMethod) (Object) method).nameJS);

            if (function == null) {
                return type;
            } else {
                return function.apply(null);
            }
        }
    }
}
