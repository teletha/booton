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
import booton.translator.JavascriptNativeNumberPrimitive;

/**
 * @version 2013/04/13 18:56:37
 */
@JavaAPIProvider(Number.class)
abstract class JSNumber implements JavascriptNativeNumberPrimitive {

    /** The actual value. */
    protected final NativeNumber value;

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
    public String toString() {
        return value.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NativeNumber valueOf() {
        return value;
    }
}
