/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.Array;
import java.util.Objects;

import booton.translator.JavaAPIProvider;
import js.lang.NativeArray;

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
        array.setProperty("$", ((JSClass) (Object) componentType).getArrayClass().getName());

        for (int i = 0; i < length; i++) {
            if (componentType.isPrimitive()) {
                if (componentType == long.class) {
                    array.set(i, 0L);
                } else {
                    array.set(i, 0);
                }
            } else {
                array.set(i, null);
            }
        }
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
        return cast(array).length();
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
        return cast(array, index).get(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a
     * {@code boolean}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static boolean getBoolean(Object array, int index) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsBoolean(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code byte}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static byte getByte(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsByte(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code char}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static char getChar(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsChar(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code short}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static short getShort(Object array, int index) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsShort(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as an {@code int}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static int getInt(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsInt(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code long}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static long getLong(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsLong(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code float}.
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static float getFloat(Object array, int index) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsFloat(index);
    }

    /**
     * Returns the value of the indexed component in the specified array object, as a {@code double}
     * .
     * 
     * @param array the array
     * @param index the index
     * @return the value of the indexed component in the specified array
     * @exception NullPointerException If the specified object is null
     * @exception IllegalArgumentException If the specified object is not an array, or if the
     *                indexed element cannot be converted to the return type by an identity or
     *                widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#get
     */
    public static double getDouble(Object array, int index) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        return cast(array, index).getAsDouble(index);
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
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code boolean} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setBoolean(Object array, int index, boolean value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code byte} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setByte(Object array, int index, byte value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code char} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setChar(Object array, int index, char value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code short} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setShort(Object array, int index, short value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code int} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setInt(Object array, int index, int value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code long} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setLong(Object array, int index, long value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code float} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setFloat(Object array, int index, float value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * Sets the value of the indexed component of the specified array object to the specified
     * {@code double} value.
     * 
     * @param array the array
     * @param index the index into the array
     * @param value the new value of the indexed component
     * @exception NullPointerException If the specified object argument is null
     * @exception IllegalArgumentException If the specified object argument is not an array, or if
     *                the specified value cannot be converted to the underlying array's component
     *                type by an identity or a primitive widening conversion
     * @exception ArrayIndexOutOfBoundsException If the specified {@code index} argument is
     *                negative, or if it is greater than or equal to the length of the specified
     *                array
     * @see Array#set
     */
    public static void setDouble(Object array, int index, double value) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {
        cast(array, index).set(index, value);
    }

    /**
     * <p>
     * Cast to {@link NativeArray}.
     * </p>
     * 
     * @param object
     * @return
     */
    private static NativeArray cast(Object object) {
        Objects.requireNonNull(object);

        if (!object.getClass().isArray()) {
            throw new IllegalArgumentException();
        }
        return (NativeArray) object;
    }

    /**
     * <p>
     * Cast to {@link NativeArray} and validate range.
     * </p>
     * 
     * @param object
     * @return
     */
    private static NativeArray cast(Object object, int index) {
        Objects.requireNonNull(object);

        if (!object.getClass().isArray()) {
            throw new IllegalArgumentException();
        }

        NativeArray array = (NativeArray) object;

        if (index < 0 || array.length() <= index) {
            throw new ArrayIndexOutOfBoundsException("Array length is " + array.length() + " but requested index is " + index + ".");
        }
        return array;
    }
}
