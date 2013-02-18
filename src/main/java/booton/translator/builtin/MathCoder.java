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

import java.util.Random;

import booton.translator.Translator;

/**
 * @version 2013/02/13 17:54:28
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
    public String abs(float a) {
        return "Math.abs(" + param(0) + ")";
    }

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
     * Returns the smallest (closest to negative infinity) {@code double} value that is greater than
     * or equal to the argument and is equal to a mathematical integer. Special cases:
     * <ul>
     * <li>If the argument value is already equal to a mathematical integer, then the result is the
     * same as the argument.
     * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result
     * is the same as the argument.
     * <li>If the argument value is less than zero but greater than -1.0, then the result is
     * negative zero.
     * </ul>
     * Note that the value of {@code Math.ceil(x)} is exactly the value of {@code -Math.floor(-x)}.
     * 
     * @param a a value.
     * @return the smallest (closest to negative infinity) floating-point value that is greater than
     *         or equal to the argument and is equal to a mathematical integer.
     */
    public String ceil(double a) {
        return "Math.ceil(" + param(0) + ")";
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
     * Returns the greater of two {@code int} values. That is, the result is the argument closer to
     * the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the result is
     * that same value.
     * </p>
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public String max(double a, double b) {
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
     * Returns the smaller of two {@code int} values. That is, the result the argument closer to the
     * value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     * </p>
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public String min(double a, double b) {
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

    /**
     * Returns the value of the first argument raised to the power of the second argument. Special
     * cases:
     * <ul>
     * <li>If the second argument is positive or negative zero, then the result is 1.0.
     * <li>If the second argument is 1.0, then the result is the same as the first argument.
     * <li>If the second argument is NaN, then the result is NaN.
     * <li>If the first argument is NaN and the second argument is nonzero, then the result is NaN.
     * <li>If
     * <ul>
     * <li>the absolute value of the first argument is greater than 1 and the second argument is
     * positive infinity, or
     * <li>the absolute value of the first argument is less than 1 and the second argument is
     * negative infinity,
     * </ul>
     * then the result is positive infinity.
     * <li>If
     * <ul>
     * <li>the absolute value of the first argument is greater than 1 and the second argument is
     * negative infinity, or
     * <li>the absolute value of the first argument is less than 1 and the second argument is
     * positive infinity,
     * </ul>
     * then the result is positive zero.
     * <li>If the absolute value of the first argument equals 1 and the second argument is infinite,
     * then the result is NaN.
     * <li>If
     * <ul>
     * <li>the first argument is positive zero and the second argument is greater than zero, or
     * <li>the first argument is positive infinity and the second argument is less than zero,
     * </ul>
     * then the result is positive zero.
     * <li>If
     * <ul>
     * <li>the first argument is positive zero and the second argument is less than zero, or
     * <li>the first argument is positive infinity and the second argument is greater than zero,
     * </ul>
     * then the result is positive infinity.
     * <li>If
     * <ul>
     * <li>the first argument is negative zero and the second argument is greater than zero but not
     * a finite odd integer, or
     * <li>the first argument is negative infinity and the second argument is less than zero but not
     * a finite odd integer,
     * </ul>
     * then the result is positive zero.
     * <li>If
     * <ul>
     * <li>the first argument is negative zero and the second argument is a positive finite odd
     * integer, or
     * <li>the first argument is negative infinity and the second argument is a negative finite odd
     * integer,
     * </ul>
     * then the result is negative zero.
     * <li>If
     * <ul>
     * <li>the first argument is negative zero and the second argument is less than zero but not a
     * finite odd integer, or
     * <li>the first argument is negative infinity and the second argument is greater than zero but
     * not a finite odd integer,
     * </ul>
     * then the result is positive infinity.
     * <li>If
     * <ul>
     * <li>the first argument is negative zero and the second argument is a negative finite odd
     * integer, or
     * <li>the first argument is negative infinity and the second argument is a positive finite odd
     * integer,
     * </ul>
     * then the result is negative infinity.
     * <li>If the first argument is finite and less than zero
     * <ul>
     * <li>if the second argument is a finite even integer, the result is equal to the result of
     * raising the absolute value of the first argument to the power of the second argument
     * <li>if the second argument is a finite odd integer, the result is equal to the negative of
     * the result of raising the absolute value of the first argument to the power of the second
     * argument
     * <li>if the second argument is finite and not an integer, then the result is NaN.
     * </ul>
     * <li>If both arguments are integers, then the result is exactly equal to the mathematical
     * result of raising the first argument to the power of the second argument if that result can
     * in fact be represented exactly as a {@code double} value.
     * </ul>
     * <p>
     * (In the foregoing descriptions, a floating-point value is considered to be an integer if and
     * only if it is finite and a fixed point of the method {@link #ceil ceil} or, equivalently, a
     * fixed point of the method {@link #floor floor}. A value is a fixed point of a one-argument
     * method if and only if the result of applying the method to the value is equal to the value.)
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a the base.
     * @param b the exponent.
     * @return the value {@code a}<sup>{@code b}</sup>.
     */
    public String pow(double a, double b) {
        return "Math.pow(" + param(0) + "," + param(1) + ")";
    }

    /**
     * Returns the correctly rounded positive square root of a {@code double} value. Special cases:
     * <ul>
     * <li>If the argument is NaN or less than zero, then the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is positive zero or negative zero, then the result is the same as the
     * argument.
     * </ul>
     * Otherwise, the result is the {@code double} value closest to the true mathematical square
     * root of the argument value.
     * 
     * @param a a value.
     * @return the positive square root of {@code a}. If the argument is NaN or less than zero, the
     *         result is NaN.
     */
    public String sqrt(double a) {
        return "Math.sqrt(" + param(0) + ")";
    }

    /**
     * Returns the trigonometric sine of an angle. Special cases:
     * <ul>
     * <li>If the argument is NaN or an infinity, then the result is NaN.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a an angle, in radians.
     * @return the sine of the argument.
     */
    public String sin(double a) {
        return "Math.sin(" + param(0) + ")";
    }

    /**
     * Returns the trigonometric cosine of an angle. Special cases:
     * <ul>
     * <li>If the argument is NaN or an infinity, then the result is NaN.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a an angle, in radians.
     * @return the cosine of the argument.
     */
    public String cos(double a) {
        return "Math.cos(" + param(0) + ")";
    }

    /**
     * Returns the trigonometric tangent of an angle. Special cases:
     * <ul>
     * <li>If the argument is NaN or an infinity, then the result is NaN.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a an angle, in radians.
     * @return the tangent of the argument.
     */
    public String tan(double a) {
        return "Math.tan(" + param(0) + ")";
    }

    /**
     * Returns the arc sine of a value; the returned angle is in the range -<i>pi</i>/2 through
     * <i>pi</i>/2. Special cases:
     * <ul>
     * <li>If the argument is NaN or its absolute value is greater than 1, then the result is NaN.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a the value whose arc sine is to be returned.
     * @return the arc sine of the argument.
     */
    public String asin(double a) {
        return "Math.asin(" + param(0) + ")";
    }

    /**
     * Returns the arc cosine of a value; the returned angle is in the range 0.0 through <i>pi</i>.
     * Special case:
     * <ul>
     * <li>If the argument is NaN or its absolute value is greater than 1, then the result is NaN.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a the value whose arc cosine is to be returned.
     * @return the arc cosine of the argument.
     */
    public String acos(double a) {
        return "Math.acos(" + param(0) + ")";
    }

    /**
     * Returns the arc tangent of a value; the returned angle is in the range -<i>pi</i>/2 through
     * <i>pi</i>/2. Special cases:
     * <ul>
     * <li>If the argument is NaN, then the result is NaN.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a the value whose arc tangent is to be returned.
     * @return the arc tangent of the argument.
     */
    public String atan(double a) {
        return "Math.atan(" + param(0) + ")";
    }

    /**
     * Returns the angle <i>theta</i> from the conversion of rectangular coordinates ({@code x}
     * ,&nbsp;{@code y}) to polar coordinates (r,&nbsp;<i>theta</i>). This method computes the phase
     * <i>theta</i> by computing an arc tangent of {@code y/x} in the range of -<i>pi</i> to
     * <i>pi</i>. Special cases:
     * <ul>
     * <li>If either argument is NaN, then the result is NaN.
     * <li>If the first argument is positive zero and the second argument is positive, or the first
     * argument is positive and finite and the second argument is positive infinity, then the result
     * is positive zero.
     * <li>If the first argument is negative zero and the second argument is positive, or the first
     * argument is negative and finite and the second argument is positive infinity, then the result
     * is negative zero.
     * <li>If the first argument is positive zero and the second argument is negative, or the first
     * argument is positive and finite and the second argument is negative infinity, then the result
     * is the {@code double} value closest to <i>pi</i>.
     * <li>If the first argument is negative zero and the second argument is negative, or the first
     * argument is negative and finite and the second argument is negative infinity, then the result
     * is the {@code double} value closest to -<i>pi</i>.
     * <li>If the first argument is positive and the second argument is positive zero or negative
     * zero, or the first argument is positive infinity and the second argument is finite, then the
     * result is the {@code double} value closest to <i>pi</i>/2.
     * <li>If the first argument is negative and the second argument is positive zero or negative
     * zero, or the first argument is negative infinity and the second argument is finite, then the
     * result is the {@code double} value closest to -<i>pi</i>/2.
     * <li>If both arguments are positive infinity, then the result is the {@code double} value
     * closest to <i>pi</i>/4.
     * <li>If the first argument is positive infinity and the second argument is negative infinity,
     * then the result is the {@code double} value closest to 3*<i>pi</i>/4.
     * <li>If the first argument is negative infinity and the second argument is positive infinity,
     * then the result is the {@code double} value closest to -<i>pi</i>/4.
     * <li>If both arguments are negative infinity, then the result is the {@code double} value
     * closest to -3*<i>pi</i>/4.
     * </ul>
     * <p>
     * The computed result must be within 2 ulps of the exact result. Results must be
     * semi-monotonic.
     * 
     * @param y the ordinate coordinate
     * @param x the abscissa coordinate
     * @return the <i>theta</i> component of the point (<i>r</i>,&nbsp;<i>theta</i>) in polar
     *         coordinates that corresponds to the point (<i>x</i>,&nbsp;<i>y</i>) in Cartesian
     *         coordinates.
     */
    public String atan2(double y, double x) {
        return "Math.atan2(" + param(0) + ")";
    }

    /**
     * Returns a {@code double} value with a positive sign, greater than or equal to {@code 0.0} and
     * less than {@code 1.0}. Returned values are chosen pseudorandomly with (approximately) uniform
     * distribution from that range.
     * <p>
     * When this method is first called, it creates a single new pseudorandom-number generator,
     * exactly as if by the expression <blockquote>{@code new java.util.Random()}</blockquote> This
     * new pseudorandom-number generator is used thereafter for all calls to this method and is used
     * nowhere else.
     * <p>
     * This method is properly synchronized to allow correct use by more than one thread. However,
     * if many threads need to generate pseudorandom numbers at a great rate, it may reduce
     * contention for each thread to have its own pseudorandom-number generator.
     * 
     * @return a pseudorandom {@code double} greater than or equal to {@code 0.0} and less than
     *         {@code 1.0}.
     * @see Random#nextDouble()
     */
    public String random() {
        return "Math.random()";
    }
}
