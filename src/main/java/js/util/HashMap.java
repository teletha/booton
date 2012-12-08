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

import booton.translator.js.NativeObject;

/**
 * @version 2012/12/08 11:36:50
 */
public class HashMap<K, V> implements Map<K, V> {

    /** The actual container. */
    private NativeObject container = new NativeObject();

    /** The current size. */
    private int size;

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
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object key) {
        return container.hasProperty(hash(key));
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
        return (V) container.getProperty(hash(key));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        int hash = hash(key);

        V previous = null;

        if (container.hasProperty(hash)) {
            previous = (V) container.getProperty(hash);
        } else {
            size++;
        }

        // register value
        container.setProperty(hash, value);

        // API definition
        return previous;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(Object key) {
        int hash = hash(key);

        V previous = null;

        if (container.hasProperty(hash)) {
            previous = (V) container.getProperty(hash);

            container.removeProperty(hash);

            size--;
        }

        // API definition
        return previous;
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
        container = new NativeObject();
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<K> keySet() {
        return container.keys().;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<V> values() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * <p>
     * Compute hash.
     * </p>
     * 
     * @param key
     * @return
     */
    private int hash(Object key) {
        return key == null ? -1 : key.hashCode();
    }

    /**
     * @version 2012/12/08 21:58:10
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
            V previous = this.value;

            this.value = value;

            return previous;
        }
    }

    /**
     * @version 2012/12/08 22:24:29
     */
    private class KeySet extends AbstractSet<K> {

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
        public Iterator<K> iterator() {
            return (Iterator<K>) container.keys().iterator();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(K e) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object o) {
            return HashMap.this.remove(o) != null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            HashMap.this.clear();
        }
    }
}
