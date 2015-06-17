/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.AnnotatedElement;

import js.lang.NativeObject;

/**
 * @version 2013/09/26 17:05:23
 */
public class Reflections {

    /**
     * <p>
     * Retrieve internal property name.
     * </p>
     * 
     * @param element A target property.
     * @return A property name.
     */
    public static String getPropertyName(AnnotatedElement element) {
        return ((JSAnnotatedElement) (Object) element).nameJS;
    }

    /**
     * <p>
     * Retrieve prptotype object in javascript runtime.
     * </p>
     * 
     * @param clazz A target {@link Class}.
     * @return A prototype object.
     */
    public static NativeObject getPrototype(Class clazz) {
        return ((JSClass) (Object) clazz).prototype;
    }
}
