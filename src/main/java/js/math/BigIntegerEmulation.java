/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import java.math.BigInteger;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/13 14:46:48
 */
@JavaAPIProvider(BigInteger.class)
class BigIntegerEmulation extends Number implements Comparable<BigInteger> {

    /**
     * The BigInteger constant zero.
     *
     * @since 1.2
     */
    public static final BigInteger ZERO = valueOf(0);

    /**
     * The BigInteger constant ten.
     *
     * @since 1.5
     */
    public static final BigInteger TEN = valueOf(10);

    /**
     * Returns a BigInteger whose value is {@code (this + val)}.
     *
     * @param val value to be added to this BigInteger.
     * @return {@code this + val}
     */
    public BigInteger add(BigInteger val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this BigInteger.
     * @return {@code this * val}
     */
    public BigInteger multiply(BigInteger val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is {@code (this / val)}.
     *
     * @param val value by which this BigInteger is to be divided.
     * @return {@code this / val}
     * @throws ArithmeticException if {@code val} is zero.
     */
    public BigInteger divide(BigInteger val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns an array of two BigIntegers containing {@code (this / val)} followed by
     * {@code (this % val)}.
     *
     * @param val value by which this BigInteger is to be divided, and the remainder computed.
     * @return an array of two BigIntegers: the quotient {@code (this / val)} is the initial
     *         element, and the remainder {@code (this % val)} is the final element.
     * @throws ArithmeticException if {@code val} is zero.
     */
    public BigInteger[] divideAndRemainder(BigInteger val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is {@code (this << n)}. The shift distance, {@code n}, may
     * be negative, in which case this method performs a right shift. (Computes
     * <tt>floor(this * 2<sup>n</sup>)</tt>.)
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     * @see #shiftRight
     */
    public BigInteger shiftLeft(int n) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is {@code (-this)}.
     *
     * @return {@code -this}
     */
    public BigInteger negate() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the number of bits in the minimal two's-complement representation of this BigInteger,
     * <i>excluding</i> a sign bit. For positive BigIntegers, this is equivalent to the number of
     * bits in the ordinary binary representation. (Computes
     * {@code (ceil(log2(this < 0 ? -this : this+1)))}.)
     *
     * @return number of bits in the minimal two's-complement representation of this BigInteger,
     *         <i>excluding</i> a sign bit.
     */
    public int bitLength() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(BigInteger o) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float floatValue() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is the absolute value of this BigInteger.
     *
     * @return {@code abs(this)}
     */
    public BigInteger abs() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the signum function of this BigInteger.
     *
     * @return -1, 0 or 1 as the value of this BigInteger is negative, zero or positive.
     */
    public int signum() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the String representation of this BigInteger in the given radix. If the radix is
     * outside the range from {@link Character#MIN_RADIX} to {@link Character#MAX_RADIX} inclusive,
     * it will default to 10 (as is the case for {@code Integer.toString}). The digit-to-character
     * mapping provided by {@code Character.forDigit} is used, and a minus sign is prepended if
     * appropriate. (This representation is compatible with the {@link #BigInteger(String, int)
     * (String, int)} constructor.)
     *
     * @param radix radix of the String representation.
     * @return String representation of this BigInteger in the given radix.
     * @see Integer#toString
     * @see Character#forDigit
     * @see #BigInteger(java.lang.String, int)
     */
    public String toString(int radix) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a BigInteger whose value is equal to that of the specified {@code long}. This
     * "static factory method" is provided in preference to a ({@code long}) constructor because it
     * allows for reuse of frequently used BigIntegers.
     *
     * @param val value of the BigInteger to return.
     * @return a BigInteger with the specified value.
     */
    public static BigInteger valueOf(long val) {
        return null;
    }
}
