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

import booton.translator.JavaAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2013/07/04 20:43:57
 */
@JavaAPIProvider(Number.class)
abstract class JSNumber implements JavascriptNative {

    /** The actual value. */
    protected final NativeNumber value;

    /**
     * 
     */
    protected JSNumber() {
        this.value = new NativeNumber(0);
    }

    /**
     * @param value
     */
    protected JSNumber(int value) {
        this.value = new NativeNumber(value);
    }

    /**
     * @param value
     */
    protected JSNumber(long value) {
        this.value = new NativeNumber(value);
    }

    /**
     * @param value
     */
    protected JSNumber(double value) {
        this.value = new NativeNumber(value);
    }

    /**
     * Returns the value of the specified number as an <code>int</code>. This may involve rounding
     * or truncation.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>int</code>.
     */
    public int intValue() {
        return value.intValue();
    }

    /**
     * Returns the value of the specified number as a <code>long</code>. This may involve rounding
     * or truncation.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>long</code>.
     */
    public long longValue() {
        return value.longValue();
    }

    /**
     * Returns the value of the specified number as a <code>float</code>. This may involve rounding.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>float</code>.
     */
    public float floatValue() {
        return value.floatValue();
    }

    /**
     * Returns the value of the specified number as a <code>double</code>. This may involve
     * rounding.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>double</code>.
     */
    public double doubleValue() {
        return value.doubleValue();
    }

    /**
     * Returns the value of the specified number as a <code>byte</code>. This may involve rounding
     * or truncation.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>byte</code>.
     * @since JDK1.1
     */
    public byte byteValue() {
        return (byte) intValue();
    }

    /**
     * Returns the value of the specified number as a <code>short</code>. This may involve rounding
     * or truncation.
     * 
     * @return the numeric value represented by this object after conversion to type
     *         <code>short</code>.
     * @since JDK1.1
     */
    public short shortValue() {
        return (short) intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return obj == value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return value.intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @JavascriptNativeProperty
    public String toString() {
        return value.toString();
    }

    /**
     * <p>
     * Returns the primitive value of this object.
     * </p>
     * <p>
     * JavaScript calls the valueOf method to convert an object to a primitive value. You rarely
     * need to invoke the valueOf method yourself; JavaScript automatically invokes it when
     * encountering an object where a primitive value is expected.
     * </p>
     * <p>
     * You can create a function to be called in place of the default valueOf method. Your function
     * must take no arguments.
     * </p>
     * 
     * @return A primitive value.
     */
    @JavascriptNativeProperty
    public NativeNumber valueOf() {
        return value;
    }
}
