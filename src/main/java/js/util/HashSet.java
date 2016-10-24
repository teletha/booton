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

import booton.translator.JavaAPIProvider;
import js.lang.NativeObject;

/**
 * @version 2013/05/30 20:38:55
 */
@JavaAPIProvider(java.util.HashSet.class)
class HashSet<E> extends AbstractSet<E> {

    /** The item count. */
    private int size = 0;

    /** The item pool. */
    private NativeObject items = new NativeObject();

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has default initial
     * capacity (16) and load factor (0.75).
     */
    public HashSet() {
    }

    /**
     * Constructs a new set containing the elements in the specified collection. The
     * <tt>HashMap</tt> is created with default load factor (0.75) and an initial capacity
     * sufficient to contain the elements in the specified collection.
     * 
     * @param collection the collection whose elements are to be placed into this set
     * @throws NullPointerException if the specified collection is null
     */
    public HashSet(Collection<? extends E> collection) {
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
    public HashSet(int initialCapacity, float loadFactor) {
        this();
    }

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has the specified initial
     * capacity and default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the initial capacity is less than zero
     */
    public HashSet(int initialCapacity) {
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
    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        this();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object item) {
        return items.hasProperty(hash(item));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            return false;
        } else {
            size++;
            items.setProperty(hash, item);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object item) {
        int hash = hash(item);

        if (!items.hasProperty(hash)) {
            return false;
        } else {
            size--;
            items.deleteProperty(hash);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        items = new NativeObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View(items.keys());
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
     * <p>
     * Compute hash.
     * </p>
     * 
     * @param key
     * @return
     */
    int hash(Object key) {
        return key == null ? -1 : key.hashCode();
    }

    /**
     * <p>
     * Find the item which is equals to the specified item.
     * </p>
     * 
     * @param item A item to find.
     * @return A found item in this set.
     */
    E find(Object item) {
        return (E) items.getProperty(hash(item));
    }

    /**
     * <p>
     * Add the item overwritely and return the previous item.
     * </p>
     * 
     * @param item A item to add.
     * @return A previous item or null.
     */
    E push(Object item) {
        E previous = null;
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            previous = (E) items.getProperty(hash);
        } else {
            size++;
        }

        // assign property
        items.setProperty(hash, item);

        // API definition
        return previous;
    }

    /**
     * <p>
     * Remove the item and return it.
     * </p>
     * 
     * @param item A item to remove.
     * @return A removed item or null.
     */
    E pull(Object item) {
        E previous = null;
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            previous = (E) items.getProperty(hash);

            size--;
            items.deleteProperty(hash);
        }

        // API definition
        return previous;
    }

    /**
     * @version 2012/12/09 19:25:43
     */
    class View implements Iterator<E> {

        /** The actual view. */
        private final String[] keys;

        /** The curren position. */
        private int index = 0;

        /** The current selected item. */
        private E current;

        /**
         * @param keys
         */
        private View(String[] keys) {
            this.keys = keys;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return index < keys.length;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            current = (E) items.getProperty(keys[index++]);

            return current;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (0 < index) {
                HashSet.this.remove(current);
            }
        }
    }
}
