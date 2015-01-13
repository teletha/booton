/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentMap;

import js.util.HashMap;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/02 22:22:51
 */
@SuppressWarnings("serial")
@JavaAPIProvider(java.util.concurrent.ConcurrentHashMap.class)
class ConcurrentHashMap<K, V> extends HashMap<K, V> implements ConcurrentMap<K, V> {

    /**
     * {@inheritDoc}
     */
    @Override
    public V putIfAbsent(K key, V value) {
        if (containsKey(key)) {
            return get(key);
        }

        return put(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object key, Object value) {
        if (containsKey(key) && get(key).equals(value)) {
            remove(key);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (containsKey(key) && get(key).equals(oldValue)) {
            put(key, newValue);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V replace(K key, V value) {
        if (containsKey(key)) {
            return put(key, value);
        }
        return null;
    }

    /**
     * Returns an enumeration of the keys in this table.
     *
     * @return an enumeration of the keys in this table
     * @see #keySet()
     */
    public Enumeration<K> keys() {
        return Collections.enumeration(super.keySet());
    }

    /**
     * Returns a {@link Set} view of the keys contained in this map. The set is backed by the map,
     * so changes to the map are reflected in the set, and vice-versa. The set supports element
     * removal, which removes the corresponding mapping from this map, via the
     * {@code Iterator.remove}, {@code Set.remove}, {@code removeAll}, {@code retainAll}, and
     * {@code clear} operations. It does not support the {@code add} or {@code addAll} operations.
     * <p>
     * The view's iterators and spliterators are <a href="package-summary.html#Weakly"><i>weakly
     * consistent</i></a>.
     * <p>
     * The view's {@code spliterator} reports {@link Spliterator#CONCURRENT},
     * {@link Spliterator#DISTINCT}, and {@link Spliterator#NONNULL}.
     * 
     * @return the set view
     */
    @Override
    public java.util.concurrent.ConcurrentHashMap.KeySetView<K, V> keySet() {
        return (java.util.concurrent.ConcurrentHashMap.KeySetView<K, V>) super.keySet();
    }

    /**
     * @version 2013/10/26 12:27:31
     */
    @JavaAPIProvider(java.util.concurrent.ConcurrentHashMap.KeySetView.class)
    private static class KeySetView<K, V> extends AbstractSet<K> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<K> iterator() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return 0;
        }
    }
}
