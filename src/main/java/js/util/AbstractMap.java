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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/02 17:00:22
 */
@JavaAPIProvider(java.util.AbstractMap.class)
abstract class AbstractMap<K, V> implements Map<K, V> {

    /** The cache for key view. */
    transient volatile Set<K> keySet = null;

    /** The cache for value view. */
    transient volatile Collection<V> values = null;

    /**
     * <p>
     * This implementation iterates over the specified map's <tt>entrySet()</tt> collection, and
     * calls this map's <tt>put</tt> operation once for each entry returned by the iteration.
     * <p>
     * Note that this implementation throws an <tt>UnsupportedOperationException</tt> if this map
     * does not support the <tt>put</tt> operation and the specified map is nonempty.
     * 
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }
}
