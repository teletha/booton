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
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/04 12:19:30
 */
@JavaAPIProvider(java.util.Collections.class)
class Collections {

    /**
     * The empty set (immutable). This set is serializable.
     * 
     * @see #emptySet()
     */
    public static final Set EMPTY_SET = new UnmodifiableSet(new HashSet());

    /**
     * The empty list (immutable). This list is serializable.
     * 
     * @see #emptyList()
     */
    public static final List EMPTY_LIST = new UnmodifiableList(new ArrayList());

    /**
     * The empty map (immutable). This map is serializable.
     * 
     * @see #emptyMap()
     * @since 1.3
     */
    public static final Map EMPTY_MAP = new UnmodifiableMap(new HashMap());

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

    /**
     * @version 2013/08/04 11:35:14
     */
    private static class UnmodifiableCollection<E> implements Collection<E> {

        /** The delegator. */
        protected final Collection<E> collection;

        /**
         * @param collection
         */
        private UnmodifiableCollection(Collection<E> collection) {
            if (collection == null) {
                throw new NullPointerException();
            }
            this.collection = collection;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return collection.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEmpty() {
            return collection.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean contains(Object o) {
            return collection.contains(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object[] toArray() {
            return collection.toArray();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> T[] toArray(T[] a) {
            return collection.toArray(a);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return collection.toString();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<E> iterator() {
            return new UnmodifiableIterator(collection.iterator());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(E item) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean containsAll(Collection<?> colletion) {
            return collection.containsAll(colletion);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean addAll(Collection<? extends E> colletion) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean removeAll(Collection<?> colletion) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * @version 2013/08/04 11:38:47
     */
    private static class UnmodifiableIterator<E> implements Iterator<E>, ListIterator<E> {

        /** The delegator. */
        protected final Iterator<E> iterator;

        /**
         * @param iterator
         */
        private UnmodifiableIterator(Iterator<E> iterator) {
            this.iterator = iterator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return iterator.next();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasPrevious() {
            return ((ListIterator<E>) iterator).hasPrevious();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E previous() {
            return ((ListIterator<E>) iterator).previous();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int nextIndex() {
            return ((ListIterator<E>) iterator).nextIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int previousIndex() {
            return ((ListIterator<E>) iterator).previousIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void set(E item) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(E item) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * @version 2013/08/04 11:41:29
     */
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {

        /**
         * @param set
         */
        private UnmodifiableSet(Set<E> set) {
            super(set);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object object) {
            return object == this || collection.equals(object);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return collection.hashCode();
        }
    }

    /**
     * @version 2013/08/04 11:34:48
     */
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {

        /** The delegator. */
        private final List<? extends E> list;

        /**
         * @param list
         */
        private UnmodifiableList(List<E> list) {
            super(list);

            this.list = list;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object object) {
            return object == this || list.equals(object);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return list.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E get(int index) {
            return list.get(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E remove(int index) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int indexOf(Object item) {
            return list.indexOf(item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int lastIndexOf(Object item) {
            return list.lastIndexOf(item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ListIterator<E> listIterator(int index) {
            return new UnmodifiableIterator(list.listIterator(index));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiableList(list.subList(fromIndex, toIndex));
        }
    }

    /**
     * @version 2013/08/04 16:38:01
     */
    private static class UnmodifiableEntry<K, V> implements Entry<K, V> {

        /** The delegator. */
        private Entry<? extends K, ? extends V> entry;

        /**
         * @param entry
         */
        private UnmodifiableEntry(Entry<? extends K, ? extends V> entry) {
            this.entry = entry;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public K getKey() {
            return entry.getKey();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V getValue() {
            return entry.getValue();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return entry.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }

            if (!(object instanceof Entry)) {
                return false;
            }
            Entry candidate = (Entry) object;
            return Objects.equals(entry.getKey(), candidate.getKey()) && Objects.equals(entry.getValue(), candidate.getValue());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return entry.toString();
        }
    }

    /**
     * We need this class in addition to UnmodifiableSet as Map.Entries themselves permit
     * modification of the backing Map via their setValue operation. This class is subtle: there are
     * many possible attacks that must be thwarted.
     * 
     * @serial include
     */
    private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Entry<K, V>> {

        /**
         * @param set
         */
        private UnmodifiableEntrySet(Set<? extends Entry<? extends K, ? extends V>> set) {
            super((Set) set);
        }

        /**
         * {@inheritDoc}
         */
        public Iterator<Entry<K, V>> iterator() {
            return new UnmodifiableIterator<Entry<K, V>>(collection.iterator()) {

                /**
                 * {@inheritDoc}
                 */
                @Override
                public Entry<K, V> next() {
                    return new UnmodifiableEntry(iterator.next());
                }
            };
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object[] toArray() {
            Object[] a = collection.toArray();

            for (int i = 0; i < a.length; i++) {
                a[i] = new UnmodifiableEntry((Entry<K, V>) a[i]);
            }
            return a;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> T[] toArray(T[] a) {
            // We don't pass a to c.toArray, to avoid window of
            // vulnerability wherein an unscrupulous multithreaded client
            // could get his hands on raw (unwrapped) Entries from c.
            Object[] arr = collection.toArray(a.length == 0 ? a : Arrays.copyOf(a, 0));

            for (int i = 0; i < arr.length; i++) {
                arr[i] = new UnmodifiableEntry<>((Entry<K, V>) arr[i]);
            }

            if (arr.length > a.length) {
                return (T[]) arr;
            }

            System.arraycopy(arr, 0, a, 0, arr.length);

            if (a.length > arr.length) {
                a[arr.length] = null;
            }
            return a;
        }

        /**
         * This method is overridden to protect the backing set against an object with a nefarious
         * equals function that senses that the equality-candidate is Entry and calls its setValue
         * method.
         */
        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            return collection.contains(new UnmodifiableEntry<>((Entry<?, ?>) o));
        }

        /**
         * The next two methods are overridden to protect against an unscrupulous List whose
         * contains(Object o) method senses when o is a Entry, and calls o.setValue.
         */
        public boolean containsAll(Collection<?> coll) {
            for (Object e : coll) {
                if (!contains(e)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;

            if (!(o instanceof Set)) {
                return false;
            }
            Set s = (Set) o;
            if (s.size() != collection.size()) {
                return false;
            }
            return containsAll(s); // Invokes safe containsAll() above
        }
    }

    /**
     * @version 2013/08/04 12:10:19
     */
    private static class UnmodifiableMap<K, V> implements Map<K, V> {

        /** The delegator. */
        private final Map<? extends K, ? extends V> map;

        /** cache. */
        private transient Set<K> keySet = null;

        /** cache. */
        private transient Set<Entry<K, V>> entrySet = null;

        /** cache. */
        private transient Collection<V> values = null;

        /**
         * @param map
         */
        private UnmodifiableMap(Map<? extends K, ? extends V> map) {
            if (map == null) {
                throw new NullPointerException();
            }
            this.map = map;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return map.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean containsValue(Object val) {
            return map.containsValue(val);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V get(Object key) {
            return map.get(key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Set<K> keySet() {
            if (keySet == null) {
                keySet = new UnmodifiableSet(map.keySet());
            }
            return keySet;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (entrySet == null) {
                entrySet = new UnmodifiableEntrySet(map.entrySet());
            }
            return entrySet;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Collection<V> values() {
            if (values == null) {
                values = new UnmodifiableCollection(map.values());
            }
            return values;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            return o == this || map.equals(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return map.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return map.toString();
        }
    }
}