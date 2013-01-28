/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2013/01/22 14:59:48
 */
class MathCoder extends Translator<Math> {

    /**
     * <p>
     * Returns the absolute value of a {@code double} value. If the argument is not negative, the
     * argument is returned. If the argument is negative, the negation of the argument is returned.
     * Special cases:
     * </p>
     * <ul>
     * <li>If the argument is positive zero or negative zero, the result is positive zero.
     * <li>If the argument is infinite, the result is positive infinity.
     * <li>If the argument is NaN, the result is NaN.
     * </ul>
     * <p>
     * In other words, the result is the same as the value of the expression:
     * </p>
     * <p>
     * {@code Double.longBitsToDouble((Double.doubleToLongBits(a)<<1)>>>1)}
     * </p>
     * 
     * @param a the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public String abs(double a) {
        return "Math.abs(" + param(0) + ")";
    }

    /**
     * <p>
     * Returns the largest (closest to positive infinity) {@code double} value that is less than or
     * equal to the argument and is equal to a mathematical integer. Special cases:
     * </p>
     * <ul>
     * <li>If the argument value is already equal to a mathematical integer, then the result is the
     * same as the argument.</li>
     * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result
     * is the same as the argument.</li>
     * </ul>
     * 
     * @param a a value.
     * @return the largest (closest to positive infinity) floating-point value that less than or
     *         equal to the argument and is equal to a mathematical integer.
     */
    public String floor(double a) {
        return "Math.floor(" + param(0) + ")";
    }

    /**
     * <p>
     * Returns the greater of two {@code int} values. That is, the result is the argument closer to
     * the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the result is
     * that same value.
     * </p>
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public String max(int a, int b) {
        return "Math.max(" + param(0) + "," + param(1) + ")";
    }

    /**
     * <p>
     * Returns the smaller of two {@code int} values. That is, the result the argument closer to the
     * value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     * </p>
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public String min(int a, int b) {
        return "Math.min(" + param(0) + "," + param(1) + ")";
    }

    /**
     * <p>
     * Returns the closest {@code long} to the argument, with ties rounding up.
     * </p>
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.</li>
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Long.MIN_VALUE}, the result is equal to the value of {@code Long.MIN_VALUE}.</li>
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
     * </ul>
     * 
     * @param A a floating-point value to be rounded to an integer.
     * @return The value of the argument rounded to the nearest {@code int} value.
     * @see java.lang.Integer#MAX_VALUE
     * @see java.lang.Integer#MIN_VALUE
     */
    public String round(float param0) {
        return "Math.round(" + param(0) + ")";
    }

    /**
     * <p>
     * Returns the closest {@code long} to the argument, with ties rounding up.
     * </p>
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.</li>
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Long.MIN_VALUE}, the result is equal to the value of {@code Long.MIN_VALUE}.</li>
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
     * </ul>
     * 
     * @param A a floating-point value to be rounded to an integer.
     * @return The value of the argument rounded to the nearest {@code int} value.
     * @see java.lang.Integer#MAX_VALUE
     * @see java.lang.Integer#MIN_VALUE
     */
    public String round(double param0) {
        return "Math.round(" + param(0) + ")";
    }
}
