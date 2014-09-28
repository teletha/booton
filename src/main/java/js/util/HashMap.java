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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/09 1:06:35
 */
@JavaAPIProvider(java.util.HashMap.class)
public class HashMap<K, V> extends AbstractMap<K, V> {

    /**
     * The number of times this HashMap has been structurally modified Structural modifications are
     * those that change the number of mappings in the HashMap or otherwise modify its internal
     * structure (e.g., rehash). This field is used to make iterators on Collection-views of the
     * HashMap fail-fast. (See ConcurrentModificationException).
     */
    transient int modCount;

    /**
     * Holds cached entrySet(). Note that AbstractMap fields are used for keySet() and values().
     */
    transient Set<Map.Entry<K, V>> entrySet;

    /** The item pool. */
    private final HashSet<Entry<K, V>> items = new HashSet();

    /**
     * <p>
     * Constructs an empty HashMap with the default initial capacity.
     * </p>
     */
    public HashMap() {
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial capacity and load factor.
     * 
     * @param initialCapacity the initial capacity
     * @param loadFactor the load factor
     * @throws IllegalArgumentException if the initial capacity is negative or the load factor is
     *             nonpositive
     */
    public HashMap(int initialCapacity, float loadFactor) {
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial capacity and the default load
     * factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public HashMap(int initialCapacity) {
    }

    /**
     * <p>
     * Constructs a new HashMap with the same mappings as the specified Map. the specified Map.
     * </p>
     * 
     * @param map A map whose mappings are to be placed in this map.
     */
    public HashMap(Map<? extends K, ? extends V> map) {
        if (map != null) {
            putAll(map);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return items.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object key) {
        return items.contains(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsValue(Object value) {
        for (V item : values()) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get(Object key) {
        Entry<K, V> entry = items.find(key);

        return entry == null ? null : entry.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        Entry<K, V> previous = items.push(new SimpleEntry(key, value));

        if (previous == null) {
            return null;
        } else {
            return previous.getValue();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(Object key) {
        Entry<K, V> removed = items.pull(key);

        if (removed == null) {
            return null;
        } else {
            return removed.getValue();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        items.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<K> keySet() {
        return new Keys();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<V> values() {
        return new Values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return items;
    }

    /**
     * 
     */
    void reinitialize() {
    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash to lower. Because the table
     * uses power-of-two masking, sets of hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys holding consecutive whole
     * numbers in small tables.) So we apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and quality of bit-spreading. Because
     * many common sets of hashes are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of collisions in bins, we just XOR
     * some shifted bits in the cheapest possible way to reduce systematic lossage, as well as to
     * incorporate impact of the highest bits that would otherwise never be used in index
     * calculations because of table bounds.
     */
    static final int hash(Object key) {
        return key == null ? -1 : key.hashCode();
    }

    /**
     * @version 2012/12/09 21:55:48
     */
    private static class SimpleEntry<K, V> implements Entry<K, V> {

        /** The key. */
        private K key;

        /** The value. */
        private V value;

        /**
         * @param key
         * @param value
         */
        private SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V setValue(V value) {
            // store previous
            V previous = this.value;

            // set newly
            this.value = value;

            // API definition
            return previous;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    /**
     * @version 2012/12/09 21:04:03
     */
    private class Keys extends AbstractSet<K> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return items.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean contains(Object item) {
            return items.contains(item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<K> iterator() {
            return new View(items.iterator(), true);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(K e) {
            return false; // Don't support add operation.
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object item) {
            return items.remove(item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            items.clear();
        }
    }

    /**
     * @version 2012/12/09 21:04:03
     */
    private class Values extends AbstractCollection<V> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return items.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean contains(Object item) {
            return containsValue(item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<V> iterator() {
            return new View(items.iterator(), false);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(V e) {
            return false; // Don't support add operation.
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object item) {
            Iterator<V> iterator = iterator();

            while (iterator.hasNext()) {
                V value = iterator.next();

                if (value == item) {
                    iterator.remove();

                    return true;
                }
            }
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            items.clear();
        }
    }

    /**
     * @version 2012/12/09 20:55:48
     */
    private class View implements Iterator {

        /** The actual view. */
        private final Iterator<Entry<K, V>> iterator;

        /** The view mode. */
        private final boolean useKey;

        /**
         * @param iterator
         */
        private View(Iterator<Entry<K, V>> iterator, boolean useKey) {
            this.iterator = iterator;
            this.useKey = useKey;
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
        public Object next() {
            Entry entry = iterator.next();

            if (useKey) {
                return entry.getKey();
            } else {
                return entry.getValue();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
