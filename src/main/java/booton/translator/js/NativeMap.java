/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;


/**
 * @version 2012/12/08 2:25:12
 */
public class NativeMap<K, V> {

    public native V set(K key, V value);

    public native V get(Object key);
}
