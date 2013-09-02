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
import java.util.HashMap;
import java.util.Map;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.Debuggable;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/01/18 1:15:38
 */
@JavaAPIProvider(AnnotatedElement.class)
abstract class JSAnnotatedElement {

    /** The function name in runtime. */
    protected final String name;

    /** The annotation definition in runtime. */
    protected final NativeObject annotations;

    private Map<Class, Annotation> ann;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name
     * @param annotations
     */
    protected JSAnnotatedElement(String name, NativeObject annotations) {
        this.name = name;
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
        return getAnnotation(annotationClass) != null;
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
    @Debuggable
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        if (annotations != null) {
            if (ann == null) {
                ann = new HashMap();
            }

            Annotation annotation = ann.get(annotationClass);
            System.out.println(annotations);
            System.out.println(annotationClass.getSimpleName());
            System.out.println(annotations.hasProperty(annotationClass.getSimpleName()));
            if (annotation == null && annotations.hasProperty(annotationClass.getSimpleName())) {
                annotation = (Annotation) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[] {annotationClass}, new AnnotationProxy(annotations.getPropertyAs(NativeObject.class, annotationClass.getSimpleName())));
                ann.put(annotationClass, annotation);
            }
            return (A) annotation;
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

        /** The properties. */
        private final NativeObject object;

        /**
         * @param object
         */
        private AnnotationProxy(NativeObject object) {
            this.object = object;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return object.getPropertyAs(NativeFunction.class, method.getName()).apply(null);
        }
    }
}
