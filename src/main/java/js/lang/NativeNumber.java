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

import booton.translator.Translator;

/**
 * @version 2013/04/12 14:13:25
 */
public class NativeNumber extends NativeObject {

    /** The actual value. */
    private final Number value;

    /**
     * <p>
     * Create javascript native {@link JSNumber} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(int value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link JSNumber} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(long value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link JSNumber} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(float value) {
        this.value = value;
    }

    /**
     * <p>
     * Create javascript native {@link JSNumber} instance.
     * </p>
     * 
     * @param value
     */
    public NativeNumber(double value) {
        this.value = value;
    }

    /**
     * <p>
     * Convert to primitive int type.
     * </p>
     * 
     * @return A int value.
     */
    public int intValue() {
        return value.intValue();
    }

    /**
     * <p>
     * Convert to primitive long type.
     * </p>
     * 
     * @return A long value.
     */
    public long longValue() {
        return value.longValue();
    }

    /**
     * <p>
     * Convert to primitive float type.
     * </p>
     * 
     * @return A float value.
     */
    public float floatValue() {
        return value.floatValue();
    }

    /**
     * <p>
     * Convert to primitive double type.
     * </p>
     * 
     * @return A double value.
     */
    public double doubleValue() {
        return value.doubleValue();
    }

    /**
     * <p>
     * Convert to primitive short type.
     * </p>
     * 
     * @return A short value.
     */
    public short shortValue() {
        return value.shortValue();
    }

    /**
     * <p>
     * Convert to primitive byte type.
     * </p>
     * 
     * @return A byte value.
     */
    public byte byteValue() {
        return value.byteValue();
    }

    /**
     * <p>
     * Returns a string expression.
     * </p>
     * 
     * @return A string expression.
     */
    @Override
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
        return Integer.toString(value.intValue(), radix);
    }

    /**
     * @version 2013/04/12 14:21:16
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeNumber> {

        /**
         * <p>
         * Create javascript native {@link JSNumber} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(int value) {
            return "(+" + param(0) + ")";
        }

        /**
         * <p>
         * Create javascript native {@link JSNumber} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(long value) {
            return param(0);
        }

        /**
         * <p>
         * Create javascript native {@link JSNumber} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(float value) {
            return "(+" + param(0) + ")";
        }

        /**
         * <p>
         * Create javascript native {@link JSNumber} instance.
         * </p>
         * 
         * @param value
         */
        public String NativeNumber(double value) {
            return "(+" + param(0) + ")";
        }

        /**
         * <p>
         * Convert to primitive int type.
         * </p>
         * 
         * @return A int value.
         */
        public String intValue() {
            return that;
        }

        /**
         * <p>
         * Convert to primitive long type.
         * </p>
         * 
         * @return A long value.
         */
        public String longValue() {
            return that;
        }

        /**
         * <p>
         * Convert to primitive float type.
         * </p>
         * 
         * @return A float value.
         */
        public String floatValue() {
            return that;
        }

        /**
         * <p>
         * Convert to primitive double type.
         * </p>
         * 
         * @return A double value.
         */
        public String doubleValue() {
            return that;
        }

        /**
         * <p>
         * Convert to primitive short type.
         * </p>
         * 
         * @return A short value.
         */
        public String shortValue() {
            return that;
        }

        /**
         * <p>
         * Convert to primitive byte type.
         * </p>
         * 
         * @return A byte value.
         */
        public String byteValue() {
            return that;
        }

        /**
         * <p>
         * Returns a string expression.
         * </p>
         * 
         * @return A string expression.
         */
        @Override
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
