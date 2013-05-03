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

    /**
     * Returns the length of the specified array object, as an {@code int}.
     * 
     * @param array the array
     * @return the length of the array
     * @exception IllegalArgumentException if the object argument is not an array
     */
    public static int getLength(Object array) throws IllegalArgumentException {
        return ((NativeArray) array).length();
    }

    /**
     * Returns the value of the indexed component in the specified array object. The value is
     * automatically wrapped in an object if it has a primitive type.
     * 
     * @param array the array
     * @param index the index
     * @return the (possibly wrapped) value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     */
    public static Object get(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return ((NativeArray) array).get(index);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified new
     * value. The new value is first automatically unwrapped if the array has a primitive component
     * type.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the array component type is primitive and an unwrapping conversion fails
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     */
    public static void set(Object array, int index, Object value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        ((NativeArray) array).set(index, value);
    }

}
