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
 * @version 2012/12/05 13:05:38
 */
public class NativeObject {

    /** The java implementation. */
    private final Map<String, Object> container = new HashMap();

    /**
     * <p>
     * Retireve property by key.
     * </p>
     * 
     * @param key A property key.
     * @return A property value.
     */
    public Object getProperty(int key) {
        return container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key.
     * </p>
     * 
     * @param key A property key.
     * @return A property value.
     */
    public Object getProperty(Object key) {
        return container.get(literal(key));
    }

    /**
     * <p>
     * Set property value by key.
     * </p>
     * 
     * @param key A property key.
     * @param value A value to set.
     * @return A value to set.
     */
    public Object setProperty(int key, Object value) {
        container.put(literal(key), value);

        return value;
    }

    /**
     * <p>
     * Set property value by key.
     * </p>
     * 
     * @param key A property key.
     * @param value A value to set.
     * @return A value to set.
     */
    public Object setProperty(Object key, Object value) {
        container.put(literal(key), value);

        return value;
    }

    /**
     * <p>
     * Check property by key.
     * </p>
     * 
     * @param key A property key.
     * @return A property value.
     */
    public boolean hasProperty(int key) {
        return container.containsKey(literal(key));
    }

    /**
     * <p>
     * Check property by key.
     * </p>
     * 
     * @param key A property key.
     * @return A property value.
     */
    public boolean hasProperty(Object key) {
        return container.containsKey(literal(key));
    }

    /**
     * <p>
     * Remove property by key.
     * </p>
     * 
     * @param key A property key.
     */
    public Object removeProperty(int key) {
        return container.remove(literal(key));
    }

    /**
     * <p>
     * Remove property by key.
     * </p>
     * 
     * @param key A property key.
     */
    public Object removeProperty(Object key) {
        return container.remove(literal(key));
    }

    /**
     * <p>
     * Helper method to compute string expression.
     * </p>
     * 
     * @param key
     * @return
     */
    private String literal(Object key) {
        return key == null ? "null" : key.toString();
    }

    /**
     * <p>
     * List up all property names.
     * </p>
     * 
     * @return A property name array.
     */
    public NativeArray<String> keys() {
        return new NativeArray(container.keySet());
    }

    /**
     * @version 2012/12/08 9:51:23
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeObject> {

        /**
         * <p>
         * Create object.
         * </p>
         * 
         * @return
         */
        public String NativeObject() {
            return "{}";
        }

        /**
         * <p>
         * Retireve property by key.
         * </p>
         * 
         * @param key A property key.
         * @return A property value.
         */
        public String getProperty(int key) {
            return getProperty((Integer) key);
        }

        /**
         * <p>
         * Retireve property by key.
         * </p>
         * 
         * @param key A property key.
         * @return A property value.
         */
        public String getProperty(Object key) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Set property value by key.
         * </p>
         * 
         * @param key A property key.
         * @param value A value to set.
         * @return A value to set.
         */
        public String setProperty(int key, Object value) {
            return setProperty((Integer) key, value);
        }

        /**
         * <p>
         * Set property value by key.
         * </p>
         * 
         * @param key A property key.
         * @param value A value to set.
         * @return A value to set.
         */
        public String setProperty(Object key, Object value) {
            return that + "[" + param(0) + "]=" + param(1);
        }

        /**
         * <p>
         * Check property by key.
         * </p>
         * 
         * @param key A property key.
         * @return A property value.
         */
        public String hasProperty(int key) {
            return hasProperty((Integer) key);
        }

        /**
         * <p>
         * Check property by key.
         * </p>
         * 
         * @param key A property key.
         * @return A property value.
         */
        public String hasProperty(Object key) {
            return that + "[" + param(0) + "]!=undefined";
        }

        /**
         * <p>
         * Remove property by key.
         * </p>
         * 
         * @param key A property key.
         */
        public String removeProperty(int key) {
            return removeProperty((Integer) key);
        }

        /**
         * <p>
         * Remove property by key.
         * </p>
         * 
         * @param key A property key.
         */
        public String removeProperty(Object key) {
            return "delete " + that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * List up all property names.
         * </p>
         * 
         * @return A property name array.
         */
        public String keys() {
            return that + ".keys()";
        }
    }
}
