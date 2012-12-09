/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @version 2012/12/09 21:55:42
 */
public class HashMap<K, V> implements Map<K, V> {

    /** The item pool. */
    private final HashSet<Entry<K, V>> items = new HashSet();

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
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
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
