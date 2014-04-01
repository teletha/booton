/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import java.util.Arrays;
import java.util.Objects;

import js.lang.Global;
import js.lang.NativeIntArray;

/**
 * @version 2014/03/26 13:21:00
 */
class BigNumber {

    /**
     * The limit on the value of DECIMAL_PLACES, TO_EXP_NEG, TO_EXP_POS, MIN_EXP, MAX_EXP, and the
     * argument to toFixed, toPrecision and toExponential, beyond which an exception is thrown (if
     * ERRORS is true).
     */
    private static final int MAX = 1000000000;

    /** Limit of magnitude of exponent argument to toPower. */
    private static final int MAX_POWER = 1000000;

    /**
     * The rounding mode used when rounding to the above decimal places, and when using toFixed,
     * toPrecision and toExponential, and round (default value). UP 0 Away from zero. DOWN 1 Towards
     * zero. CEIL 2 Towards +Infinity. FLOOR 3 Towards -Infinity. HALF_UP 4 Towards nearest
     * neighbour. If equidistant, up. HALF_DOWN 5 Towards nearest neighbour. If equidistant, down.
     * HALF_EVEN 6 Towards nearest neighbour. If equidistant, towards even neighbour. HALF_CEIL 7
     * Towards nearest neighbour. If equidistant, towards +Infinity. HALF_FLOOR 8 Towards nearest
     * neighbour. If equidistant, towards -Infinity.
     */
    private static final int ROUNDING_MODE = 4;

    /** The exponent value at and beneath which toString returns exponential notation. */
    private static final int TO_EXP_NEG = -7;

    /** The exponent value at and above which toString returns exponential notation. */
    private static final int TOP_EXP_POS = 21;

    /** The minimum exponent value, beneath which underflow to zero occurs. */
    private static final int MIN_EXP = -MAX;

    /** The maximum exponent value, above which overflow to Infinity occurs. */
    private static final int MAX_EXP = MAX;

    /** The diget character. */
    private static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ$_";

    /** The reusable cache. */
    private static final BigNumber ZERO = new BigNumber(0);

    /** The reusable cache. */
    private static final BigNumber ONE = new BigNumber(1);

    /** Whether BigNumber Errors are ever thrown. */
    private boolean ERRORS = true;

    private final int sign;

    private final NativeIntArray component;

    private final int exponential;

    /**
     * 
     */
    public BigNumber(int value) {
        this(String.valueOf(value));
    }

    /**
     * 
     */
    public BigNumber(String value) {
        String ori = value;
        // Determine sign.
        if (value.charAt(0) == '-') {
            sign = -1;
            value = value.substring(1);
        } else {
            sign = 1;
        }

        // Decimal point?
        int e = value.indexOf(".");

        if (e != -1) {
            value = value.replace(".", "");
        }

        // Exponential form?
        int i = value.indexOf("e");

        if (i != -1) {
            if (e == -1) {
                e = i;
            }
            e += Integer.parseInt(value.substring(i + 1));
            value = value.substring(0, i);
        } else if (e == -1) {
            e = value.length();
        }

        // Determine leading zeros.
        for (i = 0; i < value.length() && value.charAt(i) == '0'; i++) {
        }

        int b = value.length();

        // Overflow?
        if (MAX_EXP < (e -= i + 1)) {
            // Initinity
            component = null;
            exponential = 0;
        } else if (i == b || e < MIN_EXP) {
            // zero or underflow
            component = new NativeIntArray(new int[] {0});
            exponential = 0;
        } else {
            // Determine trailing zeros.
            while (0 <= --b && value.charAt(b) == '0') {
            }
            exponential = e;
            component = new NativeIntArray(b - i + 1);

            // Convert string to array of digits (without leading and trailing zeros).
            int p = 0;

            while (i <= b) {
                component.set(p++, Integer.parseInt(value.substring(i, ++i)));
            }
        }

        System.out.println(ori + "   sign : " + sign + "  exponent : " + exponential + "   component : " + Arrays.toString(component.toArray()));
    }

    /**
     * <p>
     * Internal copy constructor.
     * </p>
     * 
     * @param sign
     * @param component
     * @param exponential
     */
    private BigNumber(int sign, NativeIntArray component, int exponential, boolean copy) {
        this.sign = sign;
        this.component = copy ? component.copy() : component;
        this.exponential = exponential;
    }

    /**
     * <p>
     * Return a new {@link BigNumber} whose value is the value of this {@link BigNumber} neegated.
     * </p>
     * 
     * @return
     */
    public BigNumber negate() {
        return new BigNumber(-sign, component, exponential, true);
    }

    /**
     * <p>
     * Returns a {@link BigNumber} whose value is (this + augend), and whose scale is
     * max(this.scale(), augend.scale()).
     * </p>
     * 
     * @param augend A value to be added to this {@link BigNumber}.
     * @return this + augend
     */
    public BigNumber add(BigNumber augend) {
        Objects.nonNull(augend);

        // equalize each sign
        if (sign != augend.sign) {
            return subtract(augend.negate());
        }

        // zero pattern
        if (isZero()) {
            return augend;
        }

        if (augend.isZero()) {
            return this;
        }

        // copy each components
        NativeIntArray large = component.copy();
        NativeIntArray small = augend.component.copy();

        // equalize each exponent
        // candidate value for max exponent
        int exponent = exponential;
        int exponent = equalize(large, exponential, small, augend.exponential);

        // "large" compoent must be larger than "small" component
        if (large.length() < small.length()) {
            NativeIntArray swap = large;

            large = small;
            small = swap;
        }

        // calculate each component values
        int index = small.length();
        int carry = 0;

        while (index-- != 0) {
            int value = large.get(index) + small.get(index) + carry;
            carry = Global.toSignedInteger(value / 10);
            large.set(index, value % 10);
        }

        if (carry != 0) {
            large.unshift(carry);
            exponent++;
        }

        // remove tailing zeros
        removeTailingZeros(large);

        // API definition
        return new BigNumber(sign, large, exponent, false);
    }

    /**
     * <p>
     * Returns a {@link BigNumber} whose value is (this - subtrahend), and whose scale is
     * max(this.scale(), subtrahend.scale()).
     * </p>
     * 
     * @param subtrahend A value to be subtracted from this {@link BigNumber}.
     * @return
     */
    public BigNumber subtract(BigNumber subtrahend) {
        Objects.nonNull(subtrahend);

        // equalize each sign
        if (sign != subtrahend.sign) {
            return add(subtrahend.negate());
        }

        // zero pattern
        if (isZero()) {
            return subtrahend.negate();
        }

        if (subtrahend.isZero()) {
            return this;
        }

        // copy each components
        int sign = this.sign;
        NativeIntArray large = component.copy();
        NativeIntArray small = subtrahend.component.copy();

        // equalize each exponent
        int largeExponent = exponential;
        int smallExponent = subtrahend.exponential;
        int diff = largeExponent - smallExponent;

        if (0 < diff) {

        }

        int exponent = equalize(large, exponential, small, subtrahend.exponential);

        // "large" compoent must be larger than "small" component
        if (exponent < subtrahend.exponential) {
            NativeIntArray swap = large;

            large = small;
            small = swap;
            sign = -sign;
        }

        if (large.length() < small.length()) {
            for (int i = large.length(); i < small.length(); i++) {
                large.push(0);
            }
        }

        // calculate each component values
        int index = small.length();

        while (index-- != 0) {
            int largeValue = large.get(index);
            int smallValue = small.get(index);

            if (largeValue < smallValue) {
                int nextIndex = index;

                while (0 < nextIndex && large.get(--nextIndex) == 0) {
                    large.set(nextIndex, 9);
                }
                large.decrement(nextIndex);

                largeValue += 10;
            }
            large.set(index, largeValue - smallValue);
        }

        // Remove trailing zeros.
        index = large.length();

        while (0 < large.length() && large.get(--index) == 0) {
            large.pop();
        }

        // Remove leading zeros and adjust exponent accordingly.
        while (0 < large.length() && large.get(0) == 0) {
            large.shift();
            exponent--;
        }
        System.out.println(Arrays.toString(large.toArray()) + "  e : " + exponent + "   sign : " + sign);

        // API definition
        return new BigNumber(sign, large, exponent, false);
    }

    /**
     * <p>
     * Helper method to equalize each component size.
     * </p>
     * 
     * @param one
     * @param oneExponent
     * @param other
     * @param otherExponent
     * @return
     */
    private int equalize(NativeIntArray one, NativeIntArray other, int diff) {
        NativeIntArray small;

        if (0 < diff) {
            small = other;
        } else {
            small = one;
            max = otherExponent;

            // absolutize exponent diff size
            diff = -diff;
        }

        // prepend zero to equalize exponent
        for (int i = diff; 0 < i; --i) {
            small.unshift(0);
        }
        return max;
    }

    /**
     * <p>
     * Helper method to prepend zeros.
     * </p>
     * 
     * @param ints
     * @param size
     */
    private void prependZero(NativeIntArray ints, int size) {
        for (int i = ints.length(); 0 < i; --i) {
            ints.unshift(0);
        }
    }

    /**
     * <p>
     * Helper method to remove tailing zeros.
     * </p>
     * 
     * @param ints
     */
    private void removeHeadingZeros(NativeIntArray ints) {
        int index = 0;

        while (index < ints.length() && ints.get(index++) == 0) {
            ints.pop();
        }
    }

    /**
     * <p>
     * Helper method to remove tailing zeros.
     * </p>
     * 
     * @param ints
     */
    private void removeTailingZeros(NativeIntArray ints) {
        int index = ints.length();

        while (1 < index && ints.get(--index) == 0) {
            ints.pop();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        int exponential = this.exponential;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < component.length(); i++) {
            builder.append(component.get(i));
        }

        if (exponential < 0) {
            // Negative exponent?

            // Prepend zeros.
            for (; ++exponential < 1;) {
                builder.insert(0, "0");
            }
            builder.insert(0, "0.");
        } else if (0 < exponential) {
            // Positive exponent?
            if (builder.length() < ++exponential) {
                for (exponential -= builder.length(); 0 < exponential--;) {
                    builder.append("0");
                }
            } else if (exponential < builder.length()) {
                builder.insert(exponential, ".");
            }
        } else {
            // Exponent zero.
            if (builder.length() == 0) {
                return "0";
            } else if (1 < builder.length()) {
                builder.insert(1, ".");
            } else if (builder.charAt(0) == '0') {
                return builder.toString();
            }
        }

        if (sign < 0) {
            builder.insert(0, "-");
        }
        return builder.toString();
    }

    /**
     * <p>
     * Helper method to chech whether this value is zero or not.
     * </p>
     * 
     * @return A result.
     */
    private boolean isZero() {
        return exponential == 0 && component.get(0) == 0;
    }

    private void debug() {
        System.out.println("BigNumber [sign=" + sign + ", component=" + Arrays.toString(component.toArray()) + ", exponential=" + exponential + "]");
    }
}
