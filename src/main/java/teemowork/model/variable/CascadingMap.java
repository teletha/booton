/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import java.util.Map;

import js.util.HashMap;

/**
 * @version 2013/03/05 14:50:40
 */
class CascadingMap<K, V> {

    /** The parent map. */
    private CascadingMap<K, V> parent;

    /** The key-value store. */
    private Map<K, V> map;

    /**
     * <p>
     * Create map without parent.
     * </p>
     */
    CascadingMap() {
        this(null);
    }

    /**
     * <p>
     * Create map with parent.
     * </p>
     * 
     * @param parent A parent map to cascade.
     */
    CascadingMap(CascadingMap<K, V> parent) {
        this.parent = parent;
    }

    /**
     * <p>
     * Retrieve the value which is associated with the specified key.
     * </p>
     * 
     * @param key A key.
     * @return A value.
     */
    V get(K key) {
        if (map == null) {
            return parent.get(key);
        } else {
            return map.get(key);
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @param key
     * @param value
     */
    void put(K key, V value) {
        if (map == null) {
            // create new map to disconnect reference from parent
            map = new HashMap();

            if (parent != null) {
                // copy all key-values
                map.putAll(parent.map);
            }
        }
        map.put(key, value);
    }
}
