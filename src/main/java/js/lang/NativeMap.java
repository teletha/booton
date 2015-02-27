/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.HashMap;
import java.util.Map;

import booton.translator.Translator;

/**
 * <p>
 * The Map object is a simple key/value map. Any value (both objects and primitive values) may be
 * used as either a key or a value.
 * </p>
 * <p>
 * Javascript native Map implementation in Java.
 * </p>
 * 
 * @version 2015/02/27 14:59:49
 */
public class NativeMap<K, V> {

    /** The java emulation. */
    private final Map<K, V> container = new HashMap();

    /**
     * <p>
     * Returns the value associated to the key, or undefined if there is none.
     * </p>
     * 
     * @param key The key of the element to return from the Map object.
     * @return Returns the element associated with the specified key or undefined if the key can't
     *         be found in the Map object.
     */
    public V get(K key) {
        return container.get(key);
    }

    /**
     * <p>
     * Returns a boolean asserting whether a value has been associated to the key in myMap or not
     * </p>
     * 
     * @param key The key of the element to test for presence in the Map object.
     * @return Returns true if an element with the specified key exists in the Map object; otherwise
     *         false.
     */
    public boolean has(K key) {
        return container.containsKey(key);
    }

    /**
     * <p>
     * Sets the value for the key in myMap. Returns undefined.
     * </p>
     * 
     * @param key The key of the element to add to the Map object.
     * @param value The value of the element to add to the Map object.
     * @return The Map object.
     */
    public NativeMap<K, V> set(K key, V value) {
        container.put(key, value);

        return this;
    }

    /**
     * <p>
     * Removes any value associated to the key. After such a call, myMap.has(key) will return false.
     * </p>
     * 
     * @param key The key of the element to remove from the Map object.
     * @return Returns true if an element in the Map object has been removed successfully.
     */
    public boolean delete(Object key) {
        return container.remove(key) != null;
    }

    /**
     * <p>
     * Returns the number of key/value pairs in {@link NativeMap}.
     * </p>
     * 
     * @return A size of items.
     */
    public int size() {
        return container.size();
    }

    /**
     * <p>
     * Removes all key/value pairs from the Map object.
     * </p>
     */
    public void clear() {
        container.clear();
    }

    /**
     * <p>
     * Returns a new Iterator object that contains the keys for each element in the Map object in
     * insertion order.
     * </p>
     */
    public NativeIterator<K> keys() {
        return new NativeIterator(container.keySet().iterator());
    }

    // /**
    // * <p>
    // * Executes a provided function once per each key/value pair in the Map object, in insertion
    // * order.
    // * </p>
    // *
    // * @param consumer A consumer to execute for each element.
    // */
    // public void forEach(BiConsumer<K, V> consumer) {
    // container.forEach(consumer);
    // }

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
            return that + ".size";
        }

        /**
         * <p>
         * Removes all key/value pairs from the Map object.
         * </p>
         */
        public String clear() {
            return that + ".clear()";
        }

        /**
         * <p>
         * Returns a new Iterator object that contains the keys for each element in the Map object
         * in insertion order.
         * </p>
         */
        public String keys() {
            return that + ".keys()";
        }
    }
}
