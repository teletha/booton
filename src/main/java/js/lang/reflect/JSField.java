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
import java.lang.reflect.Field;

import js.lang.NativeArray;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Field} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/01/17 20:45:34
 */
@JavaAPIProvider(Field.class)
class JSField extends JSAnnotatedElement {

    /** The declaring class definition in runtime. */
    private NativeObject clazz;

    /**
     * <p>
     * Create native field.
     * </p>
     * 
     * @param name
     * @param clazz
     * @param annotations
     */
    JSField(String name, NativeObject clazz, NativeArray<Annotation> annotations) {
        super(name, annotations);

        this.clazz = clazz;
    }

    /**
     * Returns the name of the field represented by this {@code Field} object.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the {@code Class} object representing the class or interface that declares the field
     * represented by this {@code Field} object.
     */
    public Class<?> getDeclaringClass() {
        return (Class) (Object) clazz;
    }

    /**
     * Returns a {@code Class} object that identifies the declared type for the field represented by
     * this {@code Field} object.
     * 
     * @return a {@code Class} object identifying the declared type of the field represented by this
     *         object
     */
    public Class<?> getType() {
        return null;
    }
}
