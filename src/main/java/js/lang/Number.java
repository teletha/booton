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

/**
 * @version 2013/04/13 18:56:37
 */
public abstract class Number extends java.lang.Number {

    /** The actual value. */
    protected final NativeNumber value;

    /**
     * @param value
     */
    protected Number(double value) {
        this.value = new NativeNumber(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return value.intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return value.longValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float floatValue() {
        return value.floatValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return value.doubleValue();
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
}
