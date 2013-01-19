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

import booton.translator.JavaNative;

/**
 * @version 2013/01/18 1:15:38
 */
@JavaNative(AnnotatedElement.class)
abstract class JSAnnotatedElement extends NativeObject {

    /** The function name in runtime. */
    protected final String name;

    /** The annotation definition in runtime. */
    private final NativeArray<NativeArray> annotations;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name
     * @param annotations
     */
    protected JSAnnotatedElement(String name, NativeArray<NativeArray> annotations) {
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
                NativeArray definition = annotations.get(i);

                if (definition.get(0).equals(annotationClass.getSimpleName())) {
                    return (A) definition.get(1);
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
}
