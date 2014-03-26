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
    private static final BigNumber ONE = new BigNumber(1);

    /** Whether BigNumber Errors are ever thrown. */
    private boolean ERRORS = true;

    private int sign;

    private int[] component;

    private int exponential;

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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        System.out.println("BigNumber [sign=" + sign + ", component=" + Arrays.toString(component) + ", exponential=" + exponential + "]");

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
}
