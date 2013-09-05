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
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/06 7:50:18
 */
@JavaAPIProvider(AnnotatedElement.class)
abstract class JSAnnotatedElement {

    /** The property name at Java definition. */
    protected final String name;

    /** The property name at JavaScript runtime. */
    protected final String nameJS;

    /** The annotation definition in runtime. */
    protected final NativeObject annotations;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name The property name at Java definition.
     * @param nameJS The property name at JavaScript runtime.
     * @param annotations
     */
    protected JSAnnotatedElement(String name, String nameJS, NativeObject annotations) {
        this.name = name;
        this.nameJS = nameJS;
        this.annotations = annotations;
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
    public <A extends Annotation> boolean isAnnotationPresent(Class<A> annotationClass) {
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
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        if (annotations != null) {
            String name = annotationClass.getSimpleName();

            if (annotations.hasOwnProperty(name)) {
                Object value = annotations.getProperty(name);

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
    public Annotation[] getAnnotations() {
        return null;
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
    public Annotation[] getDeclaredAnnotations() {
        return getAnnotations();
    }

    /**
     * <p>
     * Search annotation descriptor.
     * </p>
     * 
     * @param metadata
     * @return
     */
    protected static NativeObject findAnnotations(NativeObject metadata, String key, int index, String name) {
        NativeArray js = metadata.getPropertyAs(NativeArray.class, key);

        if (js == null) {
            return new NativeObject();
        }
        return (NativeObject) js.get(1);
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
