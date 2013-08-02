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

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

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
}
