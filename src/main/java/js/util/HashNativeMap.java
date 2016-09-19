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

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import js.lang.NativeArray;
import js.lang.NativeMap;

/**
 * @version 2015/02/28 15:56:27
 */
public class HashNativeMap<K, V> extends AbstractMap<K, V> {

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
    private final NativeMap<K, V> items = new NativeMap();

    /**
     * <p>
     * Constructs an empty HashMap with the default initial capacity.
     * </p>
     */
    public HashNativeMap() {
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial capacity and load factor.
     * 
     * @param initialCapacity the initial capacity
     * @param loadFactor the load factor
     * @throws IllegalArgumentException if the initial capacity is negative or the load factor is
     *             nonpositive
     */
    public HashNativeMap(int initialCapacity, float loadFactor) {
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial capacity and the default load
     * factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public HashNativeMap(int initialCapacity) {
    }

    /**
     * <p>
     * Constructs a new HashMap with the same mappings as the specified Map. the specified Map.
     * </p>
     * 
     * @param map A map whose mappings are to be placed in this map.
     */
    public HashNativeMap(Map<? extends K, ? extends V> map) {
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
        return items.size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object key) {
        return items.has((K) key);
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
        return items.get((K) key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        V previous = items.get(key);

        items.set(key, value);

        return previous;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(Object key) {
        V previous = items.get((K) key);

        items.delete(key);

        return previous;
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
        return new Entries();
    }

    /**
     * 
     */
    void reinitialize() {
    }

    /**
     * @version 2012/12/09 21:55:48
     */
    private class SimpleEntry implements Entry<K, V> {

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
            items.set(key, this.value = value);

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
     * @version 2015/02/28 22:51:25
     */
    private class Entries extends AbstractSet<Entry<K, V>> {

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
            return items.has(((Entry<K, V>) item).getKey());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new View<Entry<K, V>>((key, value) -> new SimpleEntry(key, value), this::remove);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(Entry<K, V> e) {
            return false; // Don't support add operation.
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object item) {
            return items.delete(((Entry<K, V>) item).getKey());
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
            return items.has((K) item);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<K> iterator() {
            return new View<K>((key, value) -> key, this::remove);
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
            return items.delete(item);
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
            return new View<V>((key, value) -> value, this::remove);
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
     * @version 2015/02/28 23:23:27
     */
    private class View<E> implements Iterator<E> {

        /** The item holder. */
        private final NativeArray<E> entries = new NativeArray();

        /** The remove operation. */
        private final Consumer<E> remover;

        /** The curren position. */
        private int index = 0;

        /** The current selected item. */
        private E current;

        /**
         * @param extractor
         * @param remover
         */
        private View(BiFunction<K, V, E> extractor, Consumer<E> remover) {
            this.remover = remover;

            items.forEach((value, key) -> entries.push(extractor.apply(key, value)));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return index < entries.length();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return current = entries.get(index++);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (0 < index && remover != null) {
                remover.accept(current);
            }
        }
    }
}
