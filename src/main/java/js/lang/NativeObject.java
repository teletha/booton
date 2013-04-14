/*
 * Copyright (C) 2013 Nameless Production Committee
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

import kiss.I;
import booton.translator.JavaAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.Translator;

/**
 * @version 2013/01/18 10:37:21
 */
@JavaAPIProvider(Object.class)
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
     * <p>
     * Confirm this object is native Array or not.
     * </p>
     * 
     * @return A result.
     */
    public boolean isArray() {
        return this instanceof NativeArray;
    }

    /**
     * <p>
     * Returns a property descriptor for an own property (that is, one directly present on an
     * object, not present by dint of being along an object's prototype chain) of a given object.
     * </p>
     * 
     * @param object The object in which to look for the property.
     * @param propertyName The name of the property whose description is to be retrieved.
     * @return
     */
    public static native NativeObject getOwnPropertyDescriptor(Object object, String propertyName);

    /**
     * <p>
     * Defines a new property directly on an object, or modifies an existing property on an object,
     * and returns the object. If you want to see how to use the Object.defineProperty method with a
     * binary-flags-like syntax.
     * </p>
     * 
     * @param object The object on which to define the property.
     * @param propertyName The name of the property to be defined or modified.
     * @param descriptor The descriptor for the property being defined or modified.
     */
    public static native void defineProperty(Object object, String propertyName, PropertyDescriptor descriptor);

    /**
     * @version 2013/04/09 2:35:51
     */
    public static interface PropertyDescriptor<T> extends JavascriptNative {

        /**
         * <p>
         * Binds an object property to a function that will be called when that property is looked
         * up.
         * </p>
         * 
         * @return
         */
        T get();

        /**
         * <p>
         * Binds an object property to a function to be called when there is an attempt to set that
         * property.
         * </p>
         * 
         * @param value
         */
        void set(T value);
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
            return getProperty((java.lang.Integer) key);
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
            return setProperty((java.lang.Integer) key, value);
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
            return hasProperty((java.lang.Integer) key);
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
            return deleteProperty((java.lang.Integer) key);
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

        /**
         * <p>
         * Confirm this object is native Array or not.
         * </p>
         * 
         * @return A result.
         */
        public String isArray() {
            return "Array.isArray(" + that + ")";
        }

        /**
         * <p>
         * Returns a property descriptor for an own property (that is, one directly present on an
         * object, not present by dint of being along an object's prototype chain) of a given
         * object.
         * </p>
         * 
         * @param object The object in which to look for the property.
         * @param propertyName The name of the property whose description is to be retrieved.
         * @return
         */
        public String getOwnPropertyDescriptor(Object object, String propertyName) {
            return "Object.getOwnPropertyDescriptor(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Defines a new property directly on an object, or modifies an existing property on an
         * object, and returns the object. If you want to see how to use the Object.defineProperty
         * method with a binary-flags-like syntax.
         * </p>
         * 
         * @param object The object on which to define the property.
         * @param propertyName The name of the property to be defined or modified.
         * @param descriptor The descriptor for the property being defined or modified.
         */
        public String defineProperty(Object object, String propertyName, PropertyDescriptor descriptor) {
            return "boot.defineProperty(" + param(0) + "," + param(1) + "," + param(2) + ")";
        }
    }
}
