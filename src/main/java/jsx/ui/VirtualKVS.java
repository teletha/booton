/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.lang.NativeArray;

/**
 * <p>
 * Optimized map for key-value store.
 * </p>
 * 
 * @version 2014/09/09 12:22:54
 */
class VirtualKVS<K, V> {

    /** The attribute name list. */
    final NativeArray<K> names = new NativeArray();

    /** The attribute value list. */
    final NativeArray<V> values = new NativeArray();

    /**
     * <p>
     * Set key-value pair.
     * </p>
     * 
     * @param name
     * @param value
     */
    void set(K name, V value) {
        int index = names.indexOf(name);

        if (index == -1) {
            names.push(name);
            values.push(value);
        } else {
            values.set(index, value);
        }
    }

    /**
     * <p>
     * Get value by the specified key.
     * </p>
     * 
     * @param name
     * @return
     */
    V get(K name) {
        int index = names.indexOf(name);

        if (index == -1) {
            return null;
        } else {
            return values.get(index);
        }
    }
}
