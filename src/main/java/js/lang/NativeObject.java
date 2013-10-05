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
 * @version 2013/09/07 1:44:24
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
    public final Object getProperty(int key) {
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
    public final Object getProperty(Object key) {
        return container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by index key.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final <S> S getProperty(int key, S defaultValue) {
        Object value = container.get(literal(key));

        if (value == null) {
            return defaultValue;
        } else {
            return (S) value;
        }
    }

    /**
     * <p>
     * Retireve property by key.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final <S> S getProperty(Object key, S defaultValue) {
        Object value = container.get(literal(key));

        if (value == null) {
            return defaultValue;
        } else {
            return (S) value;
        }
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
    public final <A> A getPropertyAs(Class<A> type, Object key) {
        return (A) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the int type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final int getInt(Object key) {
        return (int) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the long type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final long getLong(Object key) {
        return (long) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the float type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final float getFloat(Object key) {
        return (float) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the double type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final double getDouble(Object key) {
        return (double) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the byte type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final byte getByte(Object key) {
        return (byte) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the short type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final short getShort(Object key) {
        return (short) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the boolean type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final boolean getBoolean(Object key) {
        return (boolean) container.get(literal(key));
    }

    /**
     * <p>
     * Retireve property by key as the char type.
     * </p>
     * 
     * @param key A property key.
     * @return An associated value.
     */
    public final char getChar(Object key) {
        return (char) container.get(literal(key));
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
    public final Object setProperty(int key, Object value) {
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
    public final Object setProperty(Object key, int value) {
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
    public final Object setProperty(Object key, Object value) {
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
    public final int setInt(Object key, int value) {
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
    public final long setLong(Object key, long value) {
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
    public final float setFloat(Object key, float value) {
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
    public final double setDouble(Object key, double value) {
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
    public final byte setByte(Object key, byte value) {
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
    public final short setShort(Object key, short value) {
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
    public final boolean setBoolean(Object key, boolean value) {
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
    public final char setChar(Object key, char value) {
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
    public final boolean hasProperty(int key) {
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
    public final boolean hasProperty(Object key) {
        return container.containsKey(literal(key));
    }

    /**
     * <p>
     * Check own property by key.
     * </p>
     * 
     * @param key A property key.
     * @return A property value.
     */
    public final boolean hasOwnProperty(Object key) {
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
    public final boolean deleteProperty(int key) {
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
    public final boolean deleteProperty(Object key) {
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * <p>
     * List up all property names.
     * </p>
     * 
     * @return A property name array.
     */
    public final String[] keys() {
        return new NativeArray<String>(container.keySet()).toArray(new String[container.size()]);
    }

    /**
     * <p>
     * Creates a new object with this object's prototype and properties.
     * </p>
     * 
     * @return A new object.
     */
    public final NativeObject create() {
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
    public final boolean isArray() {
        return this instanceof NativeArray;
    }

    /**
     * <p>
     * Helper method to cast to {@link NativeObject}.
     * </p>
     * 
     * @param object
     * @return
     */
    public static final NativeObject by(Object object) {
        throw new UnsupportedOperationException("This method is supported in " + JavaAPIProvider.class.getSimpleName() + " class only.");
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
     * <p>
     * Check property by key.
     * </p>
     * 
     * @param propertyName A property name.
     * @return A result.
     */
    public static boolean hasProperty(Object object, String propertyName) {
        if (object instanceof NativeObject) {
            return ((NativeObject) object).hasProperty(propertyName);
        }
        return false;
    }

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
     * @version 2013/09/07 1:44:20
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
         * Write property accessor.
         * </p>
         * 
         * @param position
         * @return
         */
        private String accessor(int position) {
            String param = param(position);

            if (type(position) != String.class) {
                return "[" + param + "]";
            }

            int length = param.length();

            if (param.charAt(0) != '"' || param.charAt(length - 1) != '"') {
                return "[" + param + "]";
            }

            param = param.substring(1, length - 1);

            if (Character.isDigit(param.charAt(0))) {
                return "[" + param + "]";
            }
            return "." + param;
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
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by index key.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getProperty(int key, Object defaultValue) {
            return getProperty(Integer.valueOf(key), defaultValue);
        }

        /**
         * <p>
         * Retireve property by key.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getProperty(Object key, Object defaultValue) {
            return "(" + that + accessor(0) + "||" + param(1) + ")";
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
            return that + accessor(1);
        }

        /**
         * <p>
         * Retireve property by key as the int type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getInt(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the long type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getLong(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the float type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getFloat(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the double type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getDouble(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the byte type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getByte(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the short type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getShort(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the boolean type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getBoolean(Object key) {
            return that + accessor(0);
        }

        /**
         * <p>
         * Retireve property by key as the char type.
         * </p>
         * 
         * @param key A property key.
         * @return An associated value.
         */
        public String getChar(Object key) {
            return that + accessor(0);
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
        public String setProperty(Object key, int value) {
            return that + accessor(0) + "=" + param(1);
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
            return that + accessor(0) + "=" + param(1);
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
        public String setInt(Object key, int value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setLong(Object key, long value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setFloat(Object key, float value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setDouble(Object key, double value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setByte(Object key, byte value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setShort(Object key, short value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setBoolean(Object key, boolean value) {
            return that + accessor(0) + "=" + param(1);
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
        public String setChar(Object key, char value) {
            return that + accessor(0) + "=" + param(1);
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
         * Check own property by key.
         * </p>
         * 
         * @param key A property key.
         * @return A property value.
         */
        public String hasOwnProperty(Object key) {
            return that + ".hasOwnProperty(" + param(0) + ")";
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
            return "delete " + that + accessor(0);
        }

        /**
         * {@inheritDoc}
         */
        public String toString() {
            return that + ".toString()";
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
         * Helper method to cast to {@link NativeObject}.
         * </p>
         * 
         * @param object
         * @return
         */
        public String by(Object object) {
            return param(0);
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

        /**
         * <p>
         * Check property by key.
         * </p>
         * 
         * @param propertyName A property name.
         * @return A result.
         */
        public String hasProperty(Object object, String propertyName) {
            return param(1) + " in " + param(0);
        }

    }
}
