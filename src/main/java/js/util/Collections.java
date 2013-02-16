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
import java.util.List;
import java.util.ListIterator;

import booton.translator.JavaNative;

/**
 * @version 2013/02/16 11:28:44
 */
@JavaNative(java.util.Collections.class)
class Collections {

    /**
     * Sorts the specified list according to the order induced by the specified comparator. All
     * elements in the list must be <i>mutually comparable</i> using the specified comparator (that
     * is, {@code c.compare(e1, e2)} must not throw a {@code ClassCastException} for any elements
     * {@code e1} and {@code e2} in the list).
     * <p>
     * This sort is guaranteed to be <i>stable</i>: equal elements will not be reordered as a result
     * of the sort.
     * <p>
     * The specified list must be modifiable, but need not be resizable.
     * <p>
     * Implementation note: This implementation is a stable, adaptive, iterative mergesort that
     * requires far fewer than n lg(n) comparisons when the input array is partially sorted, while
     * offering the performance of a traditional mergesort when the input array is randomly ordered.
     * If the input array is nearly sorted, the implementation requires approximately n comparisons.
     * Temporary storage requirements vary from a small constant for nearly sorted input arrays to
     * n/2 object references for randomly ordered input arrays.
     * <p>
     * The implementation takes equal advantage of ascending and descending order in its input
     * array, and can take advantage of ascending and descending order in different parts of the
     * same input array. It is well-suited to merging two or more sorted arrays: simply concatenate
     * the arrays and sort the resulting array.
     * <p>
     * The implementation was adapted from Tim Peters's list sort for Python (<a
     * href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt"> TimSort</a>). It
     * uses techiques from Peter McIlroy's "Optimistic Sorting and Information Theoretic
     * Complexity", in Proceedings of the Fourth Annual ACM-SIAM Symposium on Discrete Algorithms,
     * pp 467-474, January 1993.
     * <p>
     * This implementation dumps the specified list into an array, sorts the array, and iterates
     * over the list resetting each element from the corresponding position in the array. This
     * avoids the n<sup>2</sup> log(n) performance that would result from attempting to sort a
     * linked list in place.
     * 
     * @param list the list to be sorted.
     * @param comparator the comparator to determine the order of the list. A {@code null} value
     *            indicates that the elements' <i>natural ordering</i> should be used.
     * @throws ClassCastException if the list contains elements that are not <i>mutually
     *             comparable</i> using the specified comparator.
     * @throws UnsupportedOperationException if the specified list's list-iterator does not support
     *             the {@code set} operation.
     * @throws IllegalArgumentException (optional) if the comparator is found to violate the
     *             {@link Comparator} contract
     */
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Object[] values = list.toArray();
        Arrays.sort(values, (Comparator) comparator);

        ListIterator iterator = list.listIterator();

        for (int i = 0; i < values.length; i++) {
            iterator.next();
            iterator.set(values[i]);
        }
    }
}
