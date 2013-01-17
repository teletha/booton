/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @version 2013/01/17 21:43:30
 */
public abstract class JSAnnotatedElement {

    /** The function name in runtime. */
    protected final String name;

    /** The annotation definition in runtime. */
    protected final NativeObject annotations;

    private final String category;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name
     * @param annotations
     */
    protected JSAnnotatedElement(String name, NativeObject annotations, String category) {
        this.name = name;
        this.annotations = annotations;
        this.category = category;
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
            NativeArray<NativeArray> annotations = this.annotations.getPropertyAs(NativeArray.class, category);

            if (annotations != null) {
                for (int i = 0; i < annotations.length(); i++) {
                    NativeArray definition = annotations.get(i);

                    if (definition.get(0).equals(annotationClass.getSimpleName())) {
                        return (A) definition.get(1);
                    }
                }
            }
        }
        return null;
    }
}
