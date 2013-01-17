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
import java.lang.reflect.Constructor;

/**
 * <p>
 * {@link Class} code in Javascript runtime. This class doesn't provide all functionalities.
 * </p>
 * 
 * @version 2013/01/17 15:58:55
 */
public class JSClass {

    /** The simple class name in runtime. */
    private final String name;

    /** The class definition in runtime. */
    private final NativeObject clazz;

    /** The annotation definition in runtime. */
    private final NativeObject annotations;

    /**
     * @param name
     * @param clazz
     * @param annotations
     */
    private JSClass(String name, NativeObject clazz, NativeObject annotations) {
        this.name = name;
        this.clazz = clazz;
        this.annotations = annotations;
    }

    public <A extends Annotation> boolean isAnnotationPresent(Class<A> annotationClass) {
        return false;
    }

    public String getName() {
        return "boot." + name;
    }

    public String getSimpleName() {
        return name;
    }

    public Object newInstance() {
        return null;
    }

    public Constructor getConstructor() {
        return null;
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
        NativeArray<NativeArray> annotations = this.annotations.getPropertyAs(NativeArray.class, "$");

        for (int i = 0; i < annotations.length(); i++) {
            NativeArray definition = annotations.get(i);

            if (definition.get(0).equals(annotationClass.getName())) {
                return (A) definition.get(1);
            }
        }
        return null;
    }
}