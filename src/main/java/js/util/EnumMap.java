/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/03 14:07:17
 */
@JavaAPIProvider(java.util.EnumMap.class)
class EnumMap<K extends Enum<K>, V> extends HashMap<K, V> {

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }
}
