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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/20 14:47:05
 */
@JavaAPIProvider(Arrays.class)
class JSArrays {

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

            if (!eq) return false;
        }
        return true;
    }

    public static boolean deepEquals0(Object e1, Object e2) {
        // assert e1 != null;
        // boolean eq;
        // if (e1 instanceof Object[] && e2 instanceof Object[]) {
        // eq = deepEquals((Object[]) e1, (Object[]) e2);
        // } else if (e1 instanceof byte[] && e2 instanceof byte[]) {
        // eq = equals((byte[]) e1, (byte[]) e2);
        // } else if (e1 instanceof short[] && e2 instanceof short[]) {
        // eq = equals((short[]) e1, (short[]) e2);
        // } else if (e1 instanceof int[] && e2 instanceof int[]) {
        // eq = equals((int[]) e1, (int[]) e2);
        // } else if (e1 instanceof long[] && e2 instanceof long[]) {
        // eq = equals((long[]) e1, (long[]) e2);
        // } else if (e1 instanceof char[] && e2 instanceof char[]) {
        // eq = equals((char[]) e1, (char[]) e2);
        // } else if (e1 instanceof float[] && e2 instanceof float[]) {
        // eq = equals((float[]) e1, (float[]) e2);
        // } else if (e1 instanceof double[] && e2 instanceof double[]) {
        // eq = equals((double[]) e1, (double[]) e2);
        // } else if (e1 instanceof boolean[] && e2 instanceof boolean[]) {
        // eq = equals((boolean[]) e1, (boolean[]) e2);
        // } else {
        // eq = e1.equals(e2);
        // }
        // return eq;
        return true;
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
     * @param a the array whose content-based hash code to compute
     * @return a content-based hash code for <tt>a</tt>
     * @see #deepHashCode(Object[])
     * @since 1.5
     */
    public static int hashCode(Object a[]) {
        if (a == null) return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
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
     * @param a the array to be sorted
     * @param c the comparator to determine the order of the array. A {@code null} value indicates
     *            that the elements' {@linkplain Comparable natural ordering} should be used.
     * @throws ClassCastException if the array contains elements that are not <i>mutually
     *             comparable</i> using the specified comparator
     * @throws IllegalArgumentException (optional) if the comparator is found to violate the
     *             {@link Comparator} contract
     */
    public static <T> void sort(T[] a, Comparator<? super T> c) {
        NativeArray array = (NativeArray) (Object) a;
        array.sort(((NativeObject) c).getPropertyAs(NativeFunction.class, "compare").bind(c));
    }
}
