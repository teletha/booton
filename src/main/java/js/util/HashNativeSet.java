/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

import js.lang.NativeArray;
import js.lang.NativeSet;

/**
 * @version 2015/02/28 15:03:04
 */
class HashNativeSet<E> extends AbstractSet<E> {

    /** The item pool. */
    private NativeSet set = new NativeSet();

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has default initial
     * capacity (16) and load factor (0.75).
     */
    public HashNativeSet() {
    }

    /**
     * Constructs a new set containing the elements in the specified collection. The
     * <tt>HashMap</tt> is created with default load factor (0.75) and an initial capacity
     * sufficient to contain the elements in the specified collection.
     * 
     * @param collection the collection whose elements are to be placed into this set
     * @throws NullPointerException if the specified collection is null
     */
    public HashNativeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has the specified initial
     * capacity and the specified load factor.
     * 
     * @param initialCapacity the initial capacity of the hash map
     * @param loadFactor the load factor of the hash map
     * @throws IllegalArgumentException if the initial capacity is less than zero, or if the load
     *             factor is nonpositive
     */
    public HashNativeSet(int initialCapacity, float loadFactor) {
        this();
    }

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has the specified initial
     * capacity and default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the initial capacity is less than zero
     */
    public HashNativeSet(int initialCapacity) {
        this();
    }

    /**
     * Constructs a new, empty linked hash set. (This package private constructor is only used by
     * LinkedHashSet.) The backing HashMap instance is a LinkedHashMap with the specified initial
     * capacity and the specified load factor.
     * 
     * @param initialCapacity the initial capacity of the hash map
     * @param loadFactor the load factor of the hash map
     * @param dummy ignored (distinguishes this constructor from other int, float constructor.)
     * @throws IllegalArgumentException if the initial capacity is less than zero, or if the load
     *             factor is nonpositive
     */
    HashNativeSet(int initialCapacity, float loadFactor, boolean dummy) {
        this();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return set.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object item) {
        return set.has(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        if (set.has(item)) {
            return false;
        } else {
            set.add(item);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object item) {
        return set.delete(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        set.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View();
    }

    /**
     * Returns a shallow copy of this <tt>HashSet</tt> instance: the elements themselves are not
     * cloned.
     *
     * @return a shallow copy of this set
     */
    @Override
    public Object clone() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2015/02/28 15:36:17
     */
    class View implements Iterator<E>, Consumer<E> {

        /** The actual view. */
        private final NativeArray<E> items = new NativeArray();

        /** The curren position. */
        private int index = 0;

        /** The current selected item. */
        private E current;

        /**
         * 
         */
        private View() {
            set.forEach(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return index < items.length();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return current = items.get(index++);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (0 < index) {
                HashNativeSet.this.remove(current);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(E item) {
            items.push(item);
        }
    }
}
