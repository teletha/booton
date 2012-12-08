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

import java.util.HashMap;
import java.util.Map;

import booton.translator.Translator;

/**
 * <p>
 * Javascript native Map implementation in Java.
 * </p>
 * 
 * @version 2012/12/08 9:52:59
 */
public class NativeMap<K, V> extends NativeObject {

    /** The java emulation. */
    private final Map<K, V> container = new HashMap();

    /**
     * <p>
     * Returns the value associated to the key, or undefined if there is none.
     * </p>
     * 
     * @param key
     * @return
     */
    public V get(Object key) {
        return container.get(key);
    }

    /**
     * <p>
     * Sets the value for the key in myMap. Returns undefined.
     * </p>
     * 
     * @param key
     * @param value
     * @return
     */
    public V set(K key, V value) {
        return container.put(key, value);
    }

    /**
     * <p>
     * Returns a boolean asserting whether a value has been associated to the key in myMap or not
     * </p>
     * 
     * @param key
     * @return
     */
    public boolean has(Object key) {
        return container.containsKey(key);
    }

    /**
     * <p>
     * Removes any value associated to the key. After such a call, myMap.has(key) will return false.
     * </p>
     * 
     * @param key
     * @return
     */
    public V delete(Object key) {
        return container.remove(key);
    }

    /**
     * <p>
     * Returns the number of key/value pairs in {@link NativeMap}.
     * </p>
     * 
     * @return
     */
    public int size() {
        return container.size();
    }

    /**
     * @version 2012/12/08 9:56:53
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeMap> {

        /**
         * <p>
         * Create Map.
         * </p>
         * 
         * @return
         */
        public String NativeMap() {
            return "new Map()";
        }

        /**
         * <p>
         * Returns the value associated to the key, or undefined if there is none.
         * </p>
         * 
         * @param key
         * @return
         */
        public String get(Object key) {
            return that + ".get(" + param(0) + ")";
        }

        /**
         * <p>
         * Sets the value for the key in myMap. Returns undefined.
         * </p>
         * 
         * @param key
         * @param value
         * @return
         */
        public String set(Object key, Object value) {
            return that + ".set(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Returns a boolean asserting whether a value has been associated to the key in myMap or
         * not
         * </p>
         * 
         * @param key
         * @return
         */
        public String has(Object key) {
            return that + ".has(" + param(0) + ")";
        }

        /**
         * <p>
         * Removes any value associated to the key. After such a call, myMap.has(key) will return
         * false.
         * </p>
         * 
         * @param key
         * @return
         */
        public String delete(Object key) {
            return that + ".delete(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the number of key/value pairs in {@link NativeMap}.
         * </p>
         * 
         * @return
         */
        public String size() {
            return that + ".size()";
        }
    }
}
