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
import booton.translator.JavaNative;

/**
 * <p>
 * {@link Method} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/01/17 20:45:34
 */
@JavaNative(Method.class)
class JSMethod extends JSAnnotatedElement {

    /** The declared class definition in runtime. */
    private NativeObject clazz;

    /** The method function in runtime. */
    private final NativeFunction function;

    /**
     * <p>
     * Create native method.
     * </p>
     * 
     * @param name
     * @param clazz
     * @param function
     * @param annotations
     */
    JSMethod(String name, NativeObject clazz, NativeFunction function, NativeArray<Annotation> annotations) {
        super(name, annotations);

        this.clazz = clazz;
        this.function = function;
    }
}
