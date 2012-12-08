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

import java.util.HashSet;
import java.util.Set;

import booton.translator.Translator;

/**
 * <p>
 * Javascript native Set implementation in Java.
 * </p>
 * 
 * @version 2012/12/08 9:52:59
 */
public class NativeSet<T> extends NativeObject {

    /** The java emulation. */
    private final Set<T> container = new HashSet();

    /**
     * <p>
     * Adds the value to {@link NativeSet}.
     * </p>
     * 
     * @param value
     */
    public void add(T value) {
        container.add(value);
    }

    /**
     * <p>
     * Sets the value for the key in {@link NativeSet}.
     * </p>
     * 
     * @param value
     */
    public void delete(T value) {
        container.remove(value);
    }

    /**
     * <p>
     * Returns a boolean asserting whether the value has been added to {@link NativeSet} or not.
     * </p>
     * 
     * @param value
     * @return
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
     * @version 2012/12/08 9:56:53
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeSet> {

        /**
         * <p>
         * Adds the value to {@link NativeSet}.
         * </p>
         * 
         * @param value
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
         * Returns a boolean asserting whether the value has been added to {@link NativeSet} or not.
         * </p>
         * 
         * @param value
         * @return
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
            return that + ".size()";
        }
    }
}
