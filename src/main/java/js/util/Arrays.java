/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/09 15:52:21
 */
@JavaAPIProvider(java.util.Arrays.class)
class Arrays {

    /**
     * Returns a fixed-size list backed by the specified array. (Changes to the returned list
     * "write through" to the array.) This method acts as bridge between array-based and
     * collection-based APIs, in combination with {@link Collection#toArray}. The returned list is
     * serializable and implements {@link RandomAccess}.
     * <p>
     * This method also provides a convenient way to create a fixed-size list initialized to contain
     * several elements:
     * 
     * <pre>
     *     List&lt;String&gt; stooges = Arrays.asList("Larry", "Moe", "Curly");
     * </pre>
     * 
     * @param items the array by which the list will be backed
     * @return a list view of the specified array
     */
    @SafeVarargs
    public static <T> List<T> asList(T... items) {
        List<T> list = new ArrayList();

        for (T item : items) {
            list.add(item);
        }
        return list;
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>(byte)0</tt>. Such indices will exist if and only
     * if the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static byte[] copyOf(byte[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>(short)0</tt>. Such indices will exist if and
     * only if the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static short[] copyOf(short[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>0</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static int[] copyOf(int[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>0L</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static long[] copyOf(long[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with null characters (if necessary) so the
     * copy has the specified length. For all indices that are valid in both the original array and
     * the copy, the two arrays will contain identical values. For any indices that are valid in the
     * copy but not the original, the copy will contain <tt>'\\u000'</tt>. Such indices will exist
     * if and only if the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with null characters to obtain the
     *         specified length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static char[] copyOf(char[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>0f</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static float[] copyOf(float[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>0d</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with zeros to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static double[] copyOf(double[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with <tt>false</tt> (if necessary) so the
     * copy has the specified length. For all indices that are valid in both the original array and
     * the copy, the two arrays will contain identical values. For any indices that are valid in the
     * copy but not the original, the copy will contain <tt>false</tt>. Such indices will exist if
     * and only if the specified length is greater than that of the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with false elements to obtain the
     *         specified length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static boolean[] copyOf(boolean[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with nulls (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>null</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array. The resulting array is of
     * exactly the same class as the original array.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @return a copy of the original array, truncated or padded with nulls to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static <T> T[] copyOf(T[] original, int newLength) {
        return copyOfRange(original, 0, newLength);
    }

    /**
     * Copies the specified array, truncating or padding with nulls (if necessary) so the copy has
     * the specified length. For all indices that are valid in both the original array and the copy,
     * the two arrays will contain identical values. For any indices that are valid in the copy but
     * not the original, the copy will contain <tt>null</tt>. Such indices will exist if and only if
     * the specified length is greater than that of the original array. The resulting array is of
     * the class <tt>newType</tt>.
     * 
     * @param original the array to be copied
     * @param newLength the length of the copy to be returned
     * @param newType the class of the copy to be returned
     * @return a copy of the original array, truncated or padded with nulls to obtain the specified
     *         length
     * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
     * @throws NullPointerException if <tt>original</tt> is null
     * @throws ArrayStoreException if an element copied from <tt>original</tt> is not of a runtime
     *             type that can be stored in an array of class <tt>newType</tt>
     * @since 1.6
     */
    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        return copyOfRange(original, 0, newLength, newType);
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>(byte)0</tt> is placed in all elements of
     * the copy whose index is greater than or equal to <tt>original.length - from</tt>. The length
     * of the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static byte[] copyOfRange(byte[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>(short)0</tt> is placed in all elements of
     * the copy whose index is greater than or equal to <tt>original.length - from</tt>. The length
     * of the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static short[] copyOfRange(short[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>0</tt> is placed in all elements of the copy
     * whose index is greater than or equal to <tt>original.length - from</tt>. The length of the
     * returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static int[] copyOfRange(int[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>0L</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static long[] copyOfRange(long[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>'\\u000'</tt> is placed in all elements of
     * the copy whose index is greater than or equal to <tt>original.length - from</tt>. The length
     * of the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with null characters to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static char[] copyOfRange(char[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>0f</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static float[] copyOfRange(float[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>0d</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with zeros to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static double[] copyOfRange(double[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>false</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with false elements to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static boolean[] copyOfRange(boolean[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>null</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>.
     * <p>
     * The resulting array is of exactly the same class as the original array.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with nulls to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @since 1.6
     */
    public static <T> T[] copyOfRange(T[] original, int from, int to) {
        return copy(original, from, to, original.getClass());
    }

    /**
     * Copies the specified range of the specified array into a new array. The initial index of the
     * range (<tt>from</tt>) must lie between zero and <tt>original.length</tt>, inclusive. The
     * value at <tt>original[from]</tt> is placed into the initial element of the copy (unless
     * <tt>from == original.length</tt> or <tt>from == to</tt>). Values from subsequent elements in
     * the original array are placed into subsequent elements in the copy. The final index of the
     * range (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>, may be greater
     * than <tt>original.length</tt>, in which case <tt>null</tt> is placed in all elements of the
     * copy whose index is greater than or equal to <tt>original.length - from</tt>. The length of
     * the returned array will be <tt>to - from</tt>. The resulting array is of the class
     * <tt>newType</tt>.
     * 
     * @param original the array from which a range is to be copied
     * @param from the initial index of the range to be copied, inclusive
     * @param to the final index of the range to be copied, exclusive. (This index may lie outside
     *            the array.)
     * @param newType the class of the copy to be returned
     * @return a new array containing the specified range from the original array, truncated or
     *         padded with nulls to obtain the required length
     * @throws ArrayIndexOutOfBoundsException if {@code from < 0} or {@code from > original.length}
     * @throws IllegalArgumentException if <tt>from &gt; to</tt>
     * @throws NullPointerException if <tt>original</tt> is null
     * @throws ArrayStoreException if an element copied from <tt>original</tt> is not of a runtime
     *             type that can be stored in an array of class <tt>newType</tt>.
     * @since 1.6
     */
    public static <T, U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
        return (T[]) copy(original, from, to, newType);
    }

    /**
     * <p>
     * Generic copy methods.
     * </p>
     * 
     * @param original
     * @param from
     * @param to
     * @param copy
     * @return
     */
    private static <T> T copy(T original, int from, int to, Class type) {
        int length = to - from;

        if (length < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }

        // create new array
        T dest = (T) Array.newInstance(type.getComponentType(), length);

        // copy
        System.arraycopy(original, from, dest, 0, Math.min(Array.getLength(original) - from, length));

        // API definition
        return dest;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of longs are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(long[] a, long[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of ints are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(int[] a, int[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of shorts are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(short[] a, short a2[]) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of chars are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(char[] a, char[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of bytes are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(byte[] a, byte[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of booleans are <i>equal</i> to one
     * another. Two arrays are considered equal if both arrays contain the same number of elements,
     * and all corresponding pairs of elements in the two arrays are equal. In other words, two
     * arrays are equal if they contain the same elements in the same order. Also, two array
     * references are considered equal if both are <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(boolean[] a, boolean[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of doubles are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * Two doubles <tt>d1</tt> and <tt>d2</tt> are considered equal if:
     * 
     * <pre>    <tt>new Double(d1).equals(new Double(d2))</tt></pre>
     * (Unlike the <tt>==</tt> operator, this method considers <tt>NaN</tt> equals to itself, and
     * 0.0d unequal to -0.0d.)
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     * @see Double#equals(Object)
     */
    public static boolean equals(double[] a, double[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of floats are <i>equal</i> to one another.
     * Two arrays are considered equal if both arrays contain the same number of elements, and all
     * corresponding pairs of elements in the two arrays are equal. In other words, two arrays are
     * equal if they contain the same elements in the same order. Also, two array references are
     * considered equal if both are <tt>null</tt>.
     * <p>
     * Two floats <tt>f1</tt> and <tt>f2</tt> are considered equal if:
     * 
     * <pre>    <tt>new Float(f1).equals(new Float(f2))</tt></pre>
     * (Unlike the <tt>==</tt> operator, this method considers <tt>NaN</tt> equals to itself, and
     * 0.0f unequal to -0.0f.)
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     * @see Float#equals(Object)
     */
    public static boolean equals(float[] a, float[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays of Objects are <i>equal</i> to one another.
     * The two arrays are considered equal if both arrays contain the same number of elements, and
     * all corresponding pairs of elements in the two arrays are equal. Two objects <tt>e1</tt> and
     * <tt>e2</tt> are considered <i>equal</i> if <tt>(e1==null ? e2==null
     * : e1.equals(e2))</tt>. In other words, the two arrays are equal if they contain the same
     * elements in the same order. Also, two array references are considered equal if both are
     * <tt>null</tt>.
     * <p>
     * 
     * @param a one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     */
    public static boolean equals(Object[] a, Object[] a2) {
        if (a == a2) {
            return true;
        }

        if (a == null || a2 == null) {
            return false;
        }

        int length = a.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            Object o1 = a[i];
            Object o2 = a2[i];

            if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Assigns the specified int value to each element of the specified array of ints.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(int[] array, int value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified int value to each element of the specified range of the specified array
     * of ints. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to index
     * <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(int[] array, int fromIndex, int toIndex, int value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(long[] array, long value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(long[] array, int fromIndex, int toIndex, long value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(float[] array, float value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(float[] array, int fromIndex, int toIndex, float value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(double[] array, double value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(double[] array, int fromIndex, int toIndex, double value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(short[] array, short value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(short[] array, int fromIndex, int toIndex, short value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(byte[] array, byte value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(byte[] array, int fromIndex, int toIndex, byte value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(char[] array, char value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(char[] array, int fromIndex, int toIndex, char value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified long value to each element of the specified array of longs.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(boolean[] array, boolean value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified long value to each element of the specified range of the specified
     * array of longs. The range to be filled extends from index <tt>fromIndex</tt>, inclusive, to
     * index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range to be filled is
     * empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     */
    public static void fill(boolean[] array, int fromIndex, int toIndex, boolean value) {
        fill((Object[]) (Object) array, fromIndex, toIndex, value);
    }

    /**
     * Assigns the specified Object reference to each element of the specified array of Objects.
     * 
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     * @throws ArrayStoreException if the specified value is not of a runtime type that can be
     *             stored in the specified array
     */
    public static void fill(Object[] array, Object value) {
        fill(array, 0, array.length, value);
    }

    /**
     * Assigns the specified Object reference to each element of the specified range of the
     * specified array of Objects. The range to be filled extends from index <tt>fromIndex</tt>,
     * inclusive, to index <tt>toIndex</tt>, exclusive. (If <tt>fromIndex==toIndex</tt>, the range
     * to be filled is empty.)
     * 
     * @param array the array to be filled
     * @param fromIndex the index of the first element (inclusive) to be filled with the specified
     *            value
     * @param toIndex the index of the last element (exclusive) to be filled with the specified
     *            value
     * @param value the value to be stored in all elements of the array
     * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
     * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
     *             <tt>toIndex &gt; a.length</tt>
     * @throws ArrayStoreException if the specified value is not of a runtime type that can be
     *             stored in the specified array
     */
    public static void fill(Object[] array, int fromIndex, int toIndex, Object value) {
        if (toIndex < fromIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }

        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }

        if (array.length < toIndex) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }

        for (int i = fromIndex; i < toIndex; i++) {
            array[i] = value;
        }
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays are <i>deeply equal</i> to one another.
     * Unlike the {@link #equals(Object[],Object[])} method, this method is appropriate for use with
     * nested arrays of arbitrary depth.
     * <p>
     * Two array references are considered deeply equal if both are <tt>null</tt>, or if they refer
     * to arrays that contain the same number of elements and all corresponding pairs of elements in
     * the two arrays are deeply equal.
     * <p>
     * Two possibly <tt>null</tt> elements <tt>e1</tt> and <tt>e2</tt> are deeply equal if any of
     * the following conditions hold:
     * <ul>
     * <li> <tt>e1</tt> and <tt>e2</tt> are both arrays of object reference types, and
     * <tt>Arrays.deepEquals(e1, e2) would return true</tt>
     * <li> <tt>e1</tt> and <tt>e2</tt> are arrays of the same primitive type, and the appropriate
     * overloading of <tt>Arrays.equals(e1, e2)</tt> would return true.
     * <li> <tt>e1 == e2</tt>
     * <li> <tt>e1.equals(e2)</tt> would return true.
     * </ul>
     * Note that this definition permits <tt>null</tt> elements at any depth.
     * <p>
     * If either of the specified arrays contain themselves as elements either directly or
     * indirectly through one or more levels of arrays, the behavior of this method is undefined.
     * 
     * @param a1 one array to be tested for equality
     * @param a2 the other array to be tested for equality
     * @return <tt>true</tt> if the two arrays are equal
     * @see #equals(Object[],Object[])
     * @see Objects#deepEquals(Object, Object)
     * @since 1.5
     */
    public static boolean deepEquals(Object[] a1, Object[] a2) {
        if (a1 == a2) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;

        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            Object e1 = a1[i];
            Object e2 = a2[i];

            if (e1 == e2) {
                continue;
            }

            if (e1 == null) {
                return false;
            }

            // Figure out whether the two elements are equal
            boolean eq = deepEquals0(e1, e2);

            if (!eq) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Helper method to chech equality of array's elements.
     * </p>
     * 
     * @param e1
     * @param e2
     * @return
     */
    static boolean deepEquals0(Object e1, Object e2) {
        boolean eq;

        if (e1 instanceof Object[] && e2 instanceof Object[]) {
            eq = deepEquals((Object[]) e1, (Object[]) e2);
        } else if (e1 instanceof byte[] && e2 instanceof byte[]) {
            eq = equals((byte[]) e1, (byte[]) e2);
        } else if (e1 instanceof short[] && e2 instanceof short[]) {
            eq = equals((short[]) e1, (short[]) e2);
        } else if (e1 instanceof int[] && e2 instanceof int[]) {
            eq = equals((int[]) e1, (int[]) e2);
        } else if (e1 instanceof long[] && e2 instanceof long[]) {
            eq = equals((long[]) e1, (long[]) e2);
        } else if (e1 instanceof char[] && e2 instanceof char[]) {
            eq = equals((char[]) e1, (char[]) e2);
        } else if (e1 instanceof float[] && e2 instanceof float[]) {
            eq = equals((float[]) e1, (float[]) e2);
        } else if (e1 instanceof double[] && e2 instanceof double[]) {
            eq = equals((double[]) e1, (double[]) e2);
        } else if (e1 instanceof boolean[] && e2 instanceof boolean[]) {
            eq = equals((boolean[]) e1, (boolean[]) e2);
        } else {
            eq = e1.equals(e2);
        }
        return eq;
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(long)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(long[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(int)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(int[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(short)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(short[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(char)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(char[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(byte)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(byte[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by
     * <tt>String.valueOf(boolean)</tt>. Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(boolean[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(float)</tt>.
     * Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(float[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. The string
     * representation consists of a list of the array's elements, enclosed in square brackets (
     * <tt>"[]"</tt>). Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space). Elements are converted to strings as by <tt>String.valueOf(double)</tt>
     * . Returns <tt>"null"</tt> if <tt>a</tt> is <tt>null</tt>.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @since 1.5
     */
    public static String toString(double[] array) {
        return write(array);
    }

    /**
     * Returns a string representation of the contents of the specified array. If the array contains
     * other arrays as elements, they are converted to strings by the {@link Object#toString} method
     * inherited from <tt>Object</tt>, which describes their <i>identities</i> rather than their
     * contents.
     * <p>
     * The value returned by this method is equal to the value that would be returned by
     * <tt>Arrays.asList(a).toString()</tt>, unless <tt>a</tt> is <tt>null</tt>, in which case
     * <tt>"null"</tt> is returned.
     * 
     * @param array the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     * @see #deepToString(Object[])
     * @since 1.5
     */
    public static String toString(Object[] array) {
        return write(array);
    }

    /**
     * <p>
     * Helper method to write out items.
     * </p>
     * 
     * @param array
     * @return
     */
    private static String write(Object array) {
        if (array == null) {
            return "null";
        }

        int length = Array.getLength(array);

        if (length == -1) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < length; i++) {
            builder.append(String.valueOf(Array.get(array, i)));

            if (i + 1 != length) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    /**
     * Returns a hash code based on the contents of the specified array. If the array contains other
     * arrays as elements, the hash code is based on their identities rather than their contents. It
     * is therefore acceptable to invoke this method on an array that contains itself as an element,
     * either directly or indirectly through one or more levels of arrays.
     * <p>
     * For any two arrays <tt>a</tt> and <tt>b</tt> such that <tt>Arrays.equals(a, b)</tt>, it is
     * also the case that <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p>
     * The value returned by this method is equal to the value that would be returned by
     * <tt>Arrays.asList(a).hashCode()</tt>, unless <tt>a</tt> is <tt>null</tt>, in which case
     * <tt>0</tt> is returned.
     * 
     * @param items the array whose content-based hash code to compute
     * @return a content-based hash code for <tt>a</tt>
     * @see #deepHashCode(Object[])
     * @since 1.5
     */
    public static int hashCode(Object[] items) {
        if (items == null) {
            return 0;
        }

        int result = 1;

        for (Object item : items) {
            result = 31 * result + (item == null ? 0 : item.hashCode());
        }

        return result;
    }

    /**
     * Sorts the specified array of objects into ascending order, according to the
     * {@linkplain Comparable natural ordering} of its elements. All elements in the array must
     * implement the {@link Comparable} interface. Furthermore, all elements in the array must be
     * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
     * {@code ClassCastException} for any elements {@code e1} and {@code e2} in the array).
     * <p>
     * This sort is guaranteed to be <i>stable</i>: equal elements will not be reordered as a result
     * of the sort.
     * <p>
     * Implementation note: This implementation is a stable, adaptive, iterative mergesort that
     * requires far fewer than n lg(n) comparisons when the input array is partially sorted, while
     * offering the performance of a traditional mergesort when the input array is randomly ordered.
     * If the input array is nearly sorted, the implementation requires approximately n comparisons.
     * Temporary storage requirements vary from a small constant for nearly sorted input arrays to
     * n/2 object references for randomly ordered input arrays.
     * <p>
     * The implementation takes equal advantage of ascending and descending order in its input
     * array, and can take advantage of ascending and descending order in different parts of the the
     * same input array. It is well-suited to merging two or more sorted arrays: simply concatenate
     * the arrays and sort the resulting array.
     * <p>
     * The implementation was adapted from Tim Peters's list sort for Python (<a
     * href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt"> TimSort</a>). It
     * uses techiques from Peter McIlroy's "Optimistic Sorting and Information Theoretic
     * Complexity", in Proceedings of the Fourth Annual ACM-SIAM Symposium on Discrete Algorithms,
     * pp 467-474, January 1993.
     * 
     * @param array the array to be sorted
     * @throws ClassCastException if the array contains elements that are not <i>mutually
     *             comparable</i> (for example, strings and integers)
     * @throws IllegalArgumentException (optional) if the natural ordering of the array elements is
     *             found to violate the {@link Comparable} contract
     */
    public static void sort(Object[] array) {
        sort(array, new ComparableSorter());
    }

    /**
     * Sorts the specified array of objects according to the order induced by the specified
     * comparator. All elements in the array must be <i>mutually comparable</i> by the specified
     * comparator (that is, {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
     * for any elements {@code e1} and {@code e2} in the array).
     * <p>
     * This sort is guaranteed to be <i>stable</i>: equal elements will not be reordered as a result
     * of the sort.
     * <p>
     * Implementation note: This implementation is a stable, adaptive, iterative mergesort that
     * requires far fewer than n lg(n) comparisons when the input array is partially sorted, while
     * offering the performance of a traditional mergesort when the input array is randomly ordered.
     * If the input array is nearly sorted, the implementation requires approximately n comparisons.
     * Temporary storage requirements vary from a small constant for nearly sorted input arrays to
     * n/2 object references for randomly ordered input arrays.
     * <p>
     * The implementation takes equal advantage of ascending and descending order in its input
     * array, and can take advantage of ascending and descending order in different parts of the the
     * same input array. It is well-suited to merging two or more sorted arrays: simply concatenate
     * the arrays and sort the resulting array.
     * <p>
     * The implementation was adapted from Tim Peters's list sort for Python (<a
     * href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt"> TimSort</a>). It
     * uses techiques from Peter McIlroy's "Optimistic Sorting and Information Theoretic
     * Complexity", in Proceedings of the Fourth Annual ACM-SIAM Symposium on Discrete Algorithms,
     * pp 467-474, January 1993.
     * 
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array. A {@code null} value
     *            indicates that the elements' {@linkplain Comparable natural ordering} should be
     *            used.
     * @throws ClassCastException if the array contains elements that are not <i>mutually
     *             comparable</i> using the specified comparator
     * @throws IllegalArgumentException (optional) if the comparator is found to violate the
     *             {@link Comparator} contract
     */
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        new NativeArray(array).sort(new NativeFunction(comparator).bind(comparator));
    }

    /**
     * @version 2013/09/24 14:20:27
     */
    private static class ComparableSorter<T> implements Comparator<Comparable<T>> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Returns a {@link Spliterator} covering all of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param <T> type of elements
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static <T> Spliterator<T> spliterator(T[] array) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator} covering the specified range of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param <T> type of elements
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfInt} covering all of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfInt spliterator(int[] array) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfInt} covering the specified range of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfLong} covering all of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return the spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfLong spliterator(long[] array) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfLong} covering the specified range of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfDouble} covering all of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfDouble spliterator(double[] array) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@link Spliterator.OfDouble} covering the specified range of the specified array.
     * <p>
     * The spliterator reports {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED},
     * {@link Spliterator#ORDERED}, and {@link Spliterator#IMMUTABLE}.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a sequential {@link Stream} with the specified array as its source.
     * 
     * @param <T> The type of the array elements
     * @param array The array, assumed to be unmodified during use
     * @return a {@code Stream} for the array
     * @since 1.8
     */
    public static <T> Stream<T> stream(T[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link Stream} with the specified range of the specified array as its
     * source.
     * 
     * @param <T> the type of the array elements
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code Stream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link IntStream} with the specified array as its source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return an {@code IntStream} for the array
     * @since 1.8
     */
    public static IntStream stream(int[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link IntStream} with the specified range of the specified array as its
     * source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return an {@code IntStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link LongStream} with the specified array as its source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return a {@code LongStream} for the array
     * @since 1.8
     */
    public static LongStream stream(long[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link LongStream} with the specified range of the specified array as
     * its source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code LongStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return StreamSupport.longStream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link DoubleStream} with the specified array as its source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @return a {@code DoubleStream} for the array
     * @since 1.8
     */
    public static DoubleStream stream(double[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link DoubleStream} with the specified range of the specified array as
     * its source.
     * 
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code DoubleStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is negative,
     *             {@code endExclusive} is less than {@code startInclusive}, or {@code endExclusive}
     *             is greater than the array size
     * @since 1.8
     */
    public static DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return StreamSupport.doubleStream(spliterator(array, startInclusive, endExclusive), false);
    }
}
