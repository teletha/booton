/*
 * Copyright (C) 2013 Nameless Production Committee
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

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2013/01/18 10:37:21
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
     * @return An associated value.
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
     * @return An associated value.
     */
    public Object getProperty(Object key) {
        return container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the specified type.
     * </p>
     * 
     * @param type A property type.
     * @param key A property key.
     * @return An associated value.
     */
    public <A> A getPropertyAs(Class<A> type, Object key) {
        return (A) container.get(literal(key));
    }

    /**
     * <p>
     * Set property value by key.
     * </p>
     * 
     * @param key A property key.
     * @param value A value to set.
     * @return A newly associated value.
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
     * @return A newly associated value.
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
     * Remove property by key from an object. Returns false only if the property exists on the
     * object itself, regardless of its prototypes, and cannot be deleted. It returns true in all
     * other cases.
     * </p>
     * 
     * @param key A property key.
     * @return A result.
     */
    public boolean deleteProperty(int key) {
        container.remove(literal(key));

        return true;
    }

    /**
     * <p>
     * Remove property by key from an object. Returns false only if the property exists on the
     * object itself, regardless of its prototypes, and cannot be deleted. It returns true in all
     * other cases.
     * </p>
     * 
     * @param key A property key.
     * @return A result.
     */
    public boolean deleteProperty(Object key) {
        container.remove(literal(key));

        return true;
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
    public String[] keys() {
        return new NativeArray<String>(container.keySet()).toArray(new String[container.size()]);
    }

    /**
     * <p>
     * Creates a new object with this object's prototype and properties.
     * </p>
     * 
     * @return A new object.
     */
    public NativeObject create() {
        NativeObject instance = I.make(getClass());
        instance.container.putAll(container);

        return instance;
    }

    /**
     * @version 2013/01/18 10:37:14
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
         * Retireve property by key as the specified type.
         * </p>
         * 
         * @param type A property type.
         * @param key A property key.
         * @return An associated value.
         */
        public String getPropertyAs(Class type, Object key) {
            return that + "[" + param(1) + "]";
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
            return param(0) + " in " + that;
        }

        /**
         * <p>
         * Remove property by key from an object. Returns false only if the property exists on the
         * object itself, regardless of its prototypes, and cannot be deleted. It returns true in
         * all other cases.
         * </p>
         * 
         * @param key A property key.
         * @return A result.
         */
        public String deleteProperty(int key) {
            return deleteProperty((Integer) key);
        }

        /**
         * <p>
         * Remove property by key from an object. Returns false only if the property exists on the
         * object itself, regardless of its prototypes, and cannot be deleted. It returns true in
         * all other cases.
         * </p>
         * 
         * @param key A property key.
         * @return A result.
         */
        public String deleteProperty(Object key) {
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
            return "Object.keys(" + that + ")";
        }

        /**
         * <p>
         * Creates a new object with this object's prototype and properties.
         * </p>
         * 
         * @return A new object.
         */
        public String create() {
            return "Object.create(" + that + ")";
        }
    }
}
