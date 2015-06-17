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

import booton.translator.Translator;

/**
 * @version 2013/09/24 12:41:00
 */
public class NativeBoolean extends NativeObject {

    /** The actual value. */
    private final Boolean value;

    /**
     * <p>
     * Create javascript native {@link Boolean} instance.
     * </p>
     * 
     * @param value
     */
    public NativeBoolean(boolean value) {
        this.value = value;
    }

    /**
     * <p>
     * Convert to primitive boolean type.
     * </p>
     * 
     * @return A int value.
     */
    public boolean booleanValue() {
        return value.booleanValue();
    }

    /**
     * <p>
     * Returns a string expression.
     * </p>
     * 
     * @return A string expression.
     */
    public String toString() {
        return value.toString();
    }

    /**
     * @version 2013/09/24 12:42:31
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeBoolean> {

        /**
         * <p>
         * Create javascript native {@link Boolean} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeBoolean(boolean value) {
            return param(0);
        }

        /**
         * <p>
         * Convert to primitive boolean type.
         * </p>
         * 
         * @return A int value.
         */
        public String booleanValue() {
            return that;
        }

        /**
         * <p>
         * Returns a string expression.
         * </p>
         * 
         * @return A string expression.
         */
        public String toString() {
            return that + ".toString()";
        }
    }
}
