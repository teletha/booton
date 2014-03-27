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

    private final int[] component;

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
            component = new int[] {0};
            exponential = 0;
        } else {
            // Determine trailing zeros.
            while (0 <= --b && value.charAt(b) == '0') {
            }
            exponential = e;
            component = new int[b - i + 1];

            // Convert string to array of digits (without leading and trailing zeros).
            int p = 0;

            while (i <= b) {
                component[p++] = Integer.parseInt(value.substring(i, ++i));
            }
        }
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
    private BigNumber(int sign, int[] component, int exponential) {
        this.sign = sign;
        this.component = component;
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
        return new BigNumber(-sign, component, exponential);
    }

    public BigNumber add(BigNumber other) {
        // signs differ
        if (sign != other.sign) {
            return subtract(other.negate());
        }

        int xe = exponential;
        int ye = other.exponential;
        int[] xc = component;
        int[] yc = other.component;

        if (xe == 0 || ye == 0) {
            // Either Infinity
            if (xc == null || yc == null) {
                // +-Infinity
                return new BigNumber(sign / 0);
            }

            // Either zero
            if (xc[0] == 0 || yc[0] == 0) {
                return yc[0] != 0 ? other : xc[0] != 0 ? this : ZERO;
            }
        }

        // Determine which is the bigger number.
        // Prepend zeros to equalise exponents.
        int ze = 0;
        int[] zc = null;
        int diff = xe - ye;

        if (0 < diff) {
            // x is larger than y
            ze = xe;
            zc = new int[yc.length + diff];
            System.arraycopy(yc, 0, zc, diff, yc.length);
        } else if (diff <= 0) {
            // y is larger than x
            ze = ye;
            zc = new int[xc.length - diff];
            System.arraycopy(xc, 0, zc, -diff, xc.length);
        }

        // Point xc to the longer array.
        if (xc.length < yc.length) {
            int[] temp = xc;
            xc = yc;
            yc = temp;
        }

        int i = yc.length;
        int j = 0;

        while (i != 0) {
            zc[--i] = xc[i] + yc[i] + j;
            j = zc[i] / 10 ^ 0;
            zc[i] %= 10;
        }

        // No need to check for zero, as +x + +y != 0 && -x + -y != 0
        if (j != 0) {
            System.out.println("unshift");

            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }

        // Remove trailing zeros.

        return new BigNumber(ze, zc, ze);
    }

    public BigNumber subtract(BigNumber other) {
        return other;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        int exponential = this.exponential;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < component.length; i++) {
            builder.append(component[i]);
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
            if (1 < builder.length()) {
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

    private void debug() {
        System.out.println("BigNumber [sign=" + sign + ", component=" + Arrays.toString(component) + ", exponential=" + exponential + "]");
    }
}
