/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import booton.translator.Translator;

/**
 * <p>
 * Javascript native Set implementation in Java.
 * </p>
 * 
 * @version 2015/02/28 14:19:26
 */
public class NativeSet<T> extends NativeObject {

    /** The java emulation. */
    private final Set<T> container = new HashSet();

    /**
     * <p>
     * The {@link NativeSet} lets you store unique values of any type, whether primitive values or
     * object references.
     * </p>
     */
    public NativeSet() {
    }

    /**
     * <p>
     * Adds the value to {@link NativeSet}.
     * </p>
     * 
     * @param value The value of the element to add to the {@link NativeSet}.
     */
    public NativeSet<T> add(T value) {
        container.add(value);

        return this;
    }

    /**
     * <p>
     * Sets the value for the key in {@link NativeSet}.
     * </p>
     * 
     * @param value
     */
    public boolean delete(T value) {
        return container.remove(value);
    }

    /**
     * <p>
     * Removes all elements from a {@link NativeSet} object.
     * </p>
     */
    public void clear() {
        container.clear();
    }

    /**
     * <p>
     * Returns a boolean asserting whether the value has been added to {@link NativeSet} or not.
     * </p>
     * 
     * @param value The value to test for presence in the {@link NativeSet}.
     * @return Returns true if an element with the specified value exists in the {@link NativeSet}
     *         otherwise false.
     */
    public boolean has(T value) {
        return container.contains(value);
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
     * <p>
     * Executes a provided function once per each value in the {@link NativeMap}.
     * </p>
     * 
     * @param consumer Function to execute for each element.
     */
    public void forEach(Consumer<? super T> consumer) {
        container.forEach(consumer);
    }

    /**
     * @version 2012/12/08 9:56:53
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeSet> {

        /**
         * <p>
         * The {@link NativeSet} lets you store unique values of any type, whether primitive values
         * or object references.
         * </p>
         */
        public String NativeSet() {
            return "new Set()";
        }

        /**
         * <p>
         * Adds the value to {@link NativeSet}.
         * </p>
         * 
         * @param value The value of the element to add to the {@link NativeSet}.
         */
        public String add(Object value) {
            return that + ".add(" + param(0) + ")";
        }

        /**
         * <p>
         * Sets the value for the key in {@link NativeSet}.
         * </p>
         * 
         * @param value
         */
        public String delete(Object value) {
            return that + ".delete(" + param(0) + ")";
        }

        /**
         * <p>
         * Removes all elements from a {@link NativeSet} object.
         * </p>
         */
        public String clear() {
            return that + ".clear()";
        }

        /**
         * <p>
         * Returns a boolean asserting whether the value has been added to {@link NativeSet} or not.
         * </p>
         * 
         * @param value The value to test for presence in the {@link NativeSet}.
         * @return Returns true if an element with the specified value exists in the
         *         {@link NativeSet} otherwise false.
         */
        public String has(Object value) {
            return that + ".has(" + param(0) + ")";
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
         * Executes a provided function once per each value in the {@link NativeMap}.
         * </p>
         * 
         * @param consumer Function to execute for each element.
         */
        public String forEach(Consumer consumer) {
            return that + ".forEach(" + function(0) + ")";
        }
    }
}
