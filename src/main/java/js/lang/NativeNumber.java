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

import booton.translator.Translator;

/**
 * @version 2013/04/12 14:13:25
 */
public class NativeNumber extends NativeObject {

    /** The actual value. */
    private final Number value;

    /**
     * <p>
     * Create javascript native {@link Number} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(int value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link Number} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(long value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link Number} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(float value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link Number} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(double value) {
        this.value = value;
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
     * <p>
     * Returns a string representation.
     * </p>
     * 
     * @param radix An integer between 2 and 36 specifying the base to use for representing numeric
     *            values.
     * @return A string expression.
     */
    public String toString(int radix) {
        return value.toString();
    }

    /**
     * @version 2013/04/12 14:21:16
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeNumber> {

        /**
         * <p>
         * Create javascript native {@link Number} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(int value) {
            return param(0);
        }

        /**
         * <p>
         * Create javascript native {@link Number} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(long value) {
            return param(0);
        }

        /**
         * <p>
         * Create javascript native {@link Number} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(float value) {
            return param(0);
        }

        /**
         * <p>
         * Create javascript native {@link Number} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(double value) {
            return param(0);
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

        /**
         * <p>
         * Returns a string representation.
         * </p>
         * 
         * @param radix An integer between 2 and 36 specifying the base to use for representing
         *            numeric values.
         * @return A string expression.
         */
        public String toString(int radix) {
            return that + ".toString(" + param(0) + ")";
        }
    }
}
