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

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/02 15:53:23
 */
@JavaAPIProvider(java.util.Collections.class)
class Collections {

    /**
     * The empty set (immutable). This set is serializable.
     * 
     * @see #emptySet()
     */
    public static final Set EMPTY_SET = new EmptySet();

    /**
     * The empty list (immutable). This list is serializable.
     * 
     * @see #emptyList()
     */
    public static final List EMPTY_LIST = new EmptyList();

    /**
     * The empty map (immutable). This map is serializable.
     * 
     * @see #emptyMap()
     * @since 1.3
     */
    public static final Map EMPTY_MAP = new EmptyMap();

    /**
     * Returns an iterator that has no elements. More precisely,
     * <ul compact>
     * <li>{@link Iterator#hasNext hasNext} always returns {@code false}.
     * <li>{@link Iterator#next next} always throws {@link NoSuchElementException}.
     * <li>{@link Iterator#remove remove} always throws {@link IllegalStateException}.
     * </ul>
     * <p>
     * Implementations of this method are permitted, but not required, to return the same object
     * from multiple invocations.
     * 
     * @return an empty iterator
     * @since 1.7
     */
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EmptyIterator.EMPTY_ITERATOR;
    }

    /**
     * Returns a list iterator that has no elements. More precisely,
     * <ul compact>
     * <li>{@link Iterator#hasNext hasNext} and {@link ListIterator#hasPrevious hasPrevious} always
     * return {@code false}.
     * <li>{@link Iterator#next next} and {@link ListIterator#previous previous} always throw
     * {@link NoSuchElementException}.
     * <li>{@link Iterator#remove remove} and {@link ListIterator#set set} always throw
     * {@link IllegalStateException}.
     * <li>{@link ListIterator#add add} always throws {@link UnsupportedOperationException}.
     * <li>{@link ListIterator#nextIndex nextIndex} always returns {@code 0} .
     * <li>{@link ListIterator#previousIndex previousIndex} always returns {@code -1}.
     * </ul>
     * <p>
     * Implementations of this method are permitted, but not required, to return the same object
     * from multiple invocations.
     * 
     * @return an empty list iterator
     * @since 1.7
     */
    public static <T> ListIterator<T> emptyListIterator() {
        return (ListIterator<T>) EmptyListIterator.EMPTY_ITERATOR;
    }

    /**
     * Returns the empty list (immutable). This list is serializable.
     * <p>
     * This example illustrates the type-safe way to obtain an empty list:
     * 
     * <pre>
     *     List&lt;String&gt; s = Collections.emptyList();
     * </pre>
     * Implementation note: Implementations of this method need not create a separate <tt>List</tt>
     * object for each call. Using this method is likely to have comparable cost to using the
     * like-named field. (Unlike this method, the field does not provide type safety.)
     * 
     * @see #EMPTY_LIST
     * @since 1.5
     */
    public static <T> List<T> emptyList() {
        return (List<T>) EMPTY_LIST;
    }

    /**
     * Returns the empty set (immutable). This set is serializable. Unlike the like-named field,
     * this method is parameterized.
     * <p>
     * This example illustrates the type-safe way to obtain an empty set:
     * 
     * <pre>
     *     Set&lt;String&gt; s = Collections.emptySet();
     * </pre>
     * Implementation note: Implementations of this method need not create a separate <tt>Set</tt>
     * object for each call. Using this method is likely to have comparable cost to using the
     * like-named field. (Unlike this method, the field does not provide type safety.)
     * 
     * @see #EMPTY_SET
     * @since 1.5
     */
    public static <T> Set<T> emptySet() {
        return (Set<T>) EMPTY_SET;
    }

    /**
     * Returns the empty map (immutable). This map is serializable.
     * <p>
     * This example illustrates the type-safe way to obtain an empty set:
     * 
     * <pre>
     *     Map&lt;String, Date&gt; s = Collections.emptyMap();
     * </pre>
     * Implementation note: Implementations of this method need not create a separate <tt>Map</tt>
     * object for each call. Using this method is likely to have comparable cost to using the
     * like-named field. (Unlike this method, the field does not provide type safety.)
     * 
     * @see #EMPTY_MAP
     * @since 1.5
     */
    public static <K, V> Map<K, V> emptyMap() {
        return (Map<K, V>) EMPTY_MAP;
    }

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
        T[] values = (T[]) list.toArray();
        Arrays.sort(values, comparator);

        ListIterator iterator = list.listIterator();

        for (int i = 0; i < values.length; i++) {
            iterator.next();
            iterator.set(values[i]);
        }
    }

    /**
     * @version 2013/08/02 15:52:29
     */
    private static class EmptyMap<K, V> extends AbstractMap<K, V> {

        /**
         * {@inheritDoc}
         */
        public int size() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isEmpty() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        public boolean containsKey(Object key) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public boolean containsValue(Object value) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public V get(Object key) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public Set<K> keySet() {
            return emptySet();
        }

        /**
         * {@inheritDoc}
         */
        public Collection<V> values() {
            return emptySet();
        }

        /**
         * {@inheritDoc}
         */
        public Set<Map.Entry<K, V>> entrySet() {
            return emptySet();
        }

        /**
         * {@inheritDoc}
         */
        public boolean equals(Object o) {
            if (o instanceof Map) {
                return ((Map) o).isEmpty();
            }
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public int hashCode() {
            return 0;
        }
    }

    /**
     * @version 2013/08/02 15:51:09
     */
    private static class EmptySet<E> extends AbstractSet<E> {

        /**
         * {@inheritDoc}
         */
        public Iterator<E> iterator() {
            return emptyIterator();
        }

        /**
         * {@inheritDoc}
         */
        public int size() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isEmpty() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        public boolean contains(Object item) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        public Object[] toArray() {
            return new Object[0];
        }

        /**
         * {@inheritDoc}
         */
        public <T> T[] toArray(T[] array) {
            if (array.length > 0) {
                array[0] = null;
            }
            return array;
        }
    }

    /**
     * @version 2013/08/02 15:48:37
     */
    private static class EmptyList<E> extends AbstractList<E> implements RandomAccess {

        /**
         * {@inheritDoc}
         */
        public Iterator<E> iterator() {
            return emptyIterator();
        }

        /**
         * {@inheritDoc}
         */
        public ListIterator<E> listIterator() {
            return emptyListIterator();
        }

        /**
         * {@inheritDoc}
         */
        public int size() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isEmpty() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        public boolean contains(Object obj) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        public Object[] toArray() {
            return new Object[0];
        }

        /**
         * {@inheritDoc}
         */
        public <T> T[] toArray(T[] array) {
            if (array.length > 0) {
                array[0] = null;
            }
            return array;
        }

        /**
         * {@inheritDoc}
         */
        public E get(int index) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    /**
     * @version 2013/08/02 15:45:44
     */
    private static class EmptyIterator<E> implements Iterator<E> {

        /** The singleton. */
        private static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public E next() {
            throw new NoSuchElementException();
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /**
     * @version 2013/08/02 15:46:25
     */
    private static class EmptyListIterator<E> extends EmptyIterator<E> implements ListIterator<E> {

        /** The singleton. */
        private static final EmptyListIterator EMPTY_ITERATOR = new EmptyListIterator();

        /**
         * {@inheritDoc}
         */
        public boolean hasPrevious() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public E previous() {
            throw new NoSuchElementException();
        }

        /**
         * {@inheritDoc}
         */
        public int nextIndex() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        public int previousIndex() {
            return -1;
        }

        /**
         * {@inheritDoc}
         */
        public void set(E e) {
            throw new IllegalStateException();
        }

        /**
         * {@inheritDoc}
         */
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}