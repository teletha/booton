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

import js.lang.NativeArray;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/01/18 1:15:38
 */
@JavaAPIProvider(AnnotatedElement.class)
abstract class JSAnnotatedElement {

    /** The function name in runtime. */
    protected final String name;

    /** The annotation definition in runtime. */
    protected final NativeArray<Annotation> annotations;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name
     * @param annotations
     */
    protected JSAnnotatedElement(String name, NativeArray<Annotation> annotations) {
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
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        if (annotations != null) {
            for (int i = 0; i < annotations.length(); i++) {
                Annotation annotation = annotations.get(i);

                if (annotation.annotationType() == annotationClass) {
                    return (A) annotation;
                }
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
    protected static NativeArray findAnnotations(NativeObject metadata, String key, int index, String name) {
        NativeArray js = metadata.getPropertyAs(NativeArray.class, key);

        if (js == null) {
            js = new NativeArray();
        }

        System.out.println("@@  " + name);
        System.out.println(metadata);
        System.out.println("@@");
        System.out.println(js + " @  " + js.getProperty("slice") + "  " + key);
        return js.slice(index);
    }
}
