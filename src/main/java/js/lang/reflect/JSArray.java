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

import java.lang.reflect.Array;

import js.lang.NativeArray;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/01 19:14:49
 */
@JavaAPIProvider(Array.class)
class JSArray {

    /**
     * Creates a new array with the specified component type and length. Invoking this method is
     * equivalent to creating an array as follows: <blockquote>
     * 
     * <pre>
     * int[] x = {length};
     * Array.newInstance(componentType, x);
     * </pre>
     * 
     * </blockquote>
     * 
     * @param componentType the {@code Class} object representing the component type of the new
     *            array
     * @param length the length of the new array
     * @return the new array
     * @exception NullPointerException if the specified {@code componentType} parameter is null
     * @exception IllegalArgumentException if componentType is {@link Void#TYPE}
     * @exception NegativeArraySizeException if the specified {@code length} is negative
     */
    public static Object newInstance(Class<?> componentType, int length) throws NegativeArraySizeException {
        NativeArray array = new NativeArray();
        array.setProperty("$", componentType.getSimpleName());

        return array;
    }
}
