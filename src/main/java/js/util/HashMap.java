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
import java.util.Map;
import java.util.Set;

import booton.translator.js.NativeMap;

/**
 * @version 2012/12/08 11:36:50
 */
public class HashMap<K, V> implements Map<K, V> {

    /** The actual container. */
    private final NativeMap<K, V> map = new NativeMap();

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
        return map.size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object key) {
        return map.has(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsValue(Object value) {
        return false;
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
        return map.set(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(Object key) {
        return map.delete(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<K> keySet() {
        return null;
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
}
