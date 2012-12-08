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
    private final Map container = new HashMap();

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
    public Object setProperty(Object key, Object value) {
        container.put(literal(key), value);

        return value;
    }

    private String literal(Object key) {
        return key == null ? "null" : key.toString();
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
        public String setProperty(Object key, Object value) {
            return that + "[" + param(0) + "]=" + param(1);
        }
    }
}
