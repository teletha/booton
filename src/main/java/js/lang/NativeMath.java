/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Random;

import booton.translator.Translator;

/**
 * @version 2014/03/11 16:08:45
 */
public class NativeMath {

    /** Thhe natural logarithm of 2, approximately 0.693. */
    public static final double LN2 = Math.log(2);

    /**
     * Returns the absolute value of an {@code int} value. If the argument is not negative, the
     * argument is returned. If the argument is negative, the negation of the argument is returned.
     * <p>
     * Note that if the argument is equal to the value of {@link Integer#MIN_VALUE}, the most
     * negative representable {@code int} value, the result is that same value, which is negative.
     * 
     * @param a the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public static int abs(int a) {
        return Math.abs(a);
    }

    /**
     * Returns the absolute value of a {@code long} value. If the argument is not negative, the
     * argument is returned. If the argument is negative, the negation of the argument is returned.
     * <p>
     * Note that if the argument is equal to the value of {@link Long#MIN_VALUE}, the most negative
     * representable {@code long} value, the result is that same value, which is negative.
     *
     * @param a the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public static long abs(long a) {
        return Math.abs(a);
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
    public static float abs(float a) {
        return Math.abs(a);
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
    public static double abs(double a) {
        return Math.abs(a);
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
    public static double ceil(double a) {
        return Math.ceil(a);
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
    public static double floor(double a) {
        return Math.floor(a);
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
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Returns the greater of two {@code long} values. That is, the result is the argument closer to
     * the value of {@link Long#MAX_VALUE}. If the arguments have the same value, the result is that
     * same value.
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    /**
     * Returns the greater of two {@code float} values. That is, the result is the argument closer
     * to positive infinity. If the arguments have the same value, the result is that same value. If
     * either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this
     * method considers negative zero to be strictly smaller than positive zero. If one argument is
     * positive zero and the other negative zero, the result is positive zero.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public static float max(float a, float b) {
        return Math.max(a, b);
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
    public static double max(double a, double b) {
        return Math.max(a, b);
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
    public static int min(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Returns the smaller of two {@code long} values. That is, the result is the argument closer to
     * the value of {@link Long#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     * 
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public static long min(long a, long b) {
        return Math.max(a, b);
    }

    /**
     * Returns the smaller of two {@code float} values. That is, the result is the value closer to
     * negative infinity. If the arguments have the same value, the result is that same value. If
     * either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this
     * method considers negative zero to be strictly smaller than positive zero. If one argument is
     * positive zero and the other is negative zero, the result is negative zero.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public static float min(float a, float b) {
        return Math.max(a, b);
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
    public static double min(double a, double b) {
        return Math.max(a, b);
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
    public static int round(float a) {
        return Math.round(a);
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
    public static long round(double a) {
        return Math.round(a);
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
    public static double pow(double a, double b) {
        return Math.pow(a, b);
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
    public static double sqrt(double a) {
        return Math.sqrt(a);
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
    public static double sin(double a) {
        return Math.sin(a);
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
    public static double cos(double a) {
        return Math.cos(a);
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
    public static double tan(double a) {
        return Math.tan(a);
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
    public static double asin(double a) {
        return Math.asin(a);
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
    public static double acos(double a) {
        return Math.acos(a);
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
    public static double atan(double a) {
        return Math.atan(a);
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
    public static double atan2(double y, double x) {
        return Math.atan2(y, x);
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
    public static double random() {
        return Math.random();
    }

    /**
     * Returns the natural logarithm (base <i>e</i>) of a {@code double} value. Special cases:
     * <ul>
     * <li>If the argument is NaN or less than zero, then the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is positive zero or negative zero, then the result is negative infinity.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * 
     * @param a a value
     * @return the value ln&nbsp;{@code a}, the natural logarithm of {@code a}.
     */
    public static double log(double a) {
        return Math.log(a);
    }

    /**
     * Returns the base 10 logarithm of a number
     * 
     * @param a
     * @return
     */
    public static double log10(double a) {
        return Math.log10(a);
    }

    /**
     * <p>
     * Returns the natural logarithm (base e) of 1 + a number
     * </p>
     * 
     * @param a
     * @return
     */
    public static double log1p(double a) {
        return Math.log1p(a);
    }

    /**
     * <p>
     * Returns ex, where x is the argument, and e is Euler's constant, the base of the natural
     * logarithms.
     * </p>
     * 
     * @param a
     * @return
     */
    public static double exp(double a) {
        return Math.exp(a);
    }

    /**
     * <p>
     * Returns ex - 1, where x is the argument, and e is Euler's constant, the base of the natural
     * logarithms.
     * </p>
     * 
     * @param a
     * @return
     */
    public static double expm1(double a) {
        return Math.expm1(a);
    }

    /**
     * <p>
     * Returns the square root of the sum of squares of its arguments
     * </p>
     * 
     * @param x
     * @param y
     * @return
     */
    public static double hypot(double x, double y) {
        return Math.hypot(x, y);
    }

    /**
     * Returns the cube root of a number
     * 
     * @param a
     * @return
     */
    public static double cbrt(double a) {
        return Math.cbrt(a);
    }

    /**
     * @version 2014/03/11 16:16:31
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeMath> {

        /** Thhe natural logarithm of 2, approximately 0.693. */
        public String LN2 = "Math.LN2";

        /**
         * Returns the absolute value of an {@code int} value. If the argument is not negative, the
         * argument is returned. If the argument is negative, the negation of the argument is
         * returned.
         * <p>
         * Note that if the argument is equal to the value of {@link Integer#MIN_VALUE}, the most
         * negative representable {@code int} value, the result is that same value, which is
         * negative.
         * 
         * @param a the argument whose absolute value is to be determined
         * @return the absolute value of the argument.
         */
        public String abs(int a) {
            return "Math.abs(" + param(0) + ")";
        }

        /**
         * Returns the absolute value of a {@code long} value. If the argument is not negative, the
         * argument is returned. If the argument is negative, the negation of the argument is
         * returned.
         * <p>
         * Note that if the argument is equal to the value of {@link Long#MIN_VALUE}, the most
         * negative representable {@code long} value, the result is that same value, which is
         * negative.
         *
         * @param a the argument whose absolute value is to be determined
         * @return the absolute value of the argument.
         */
        public String abs(long a) {
            return long64("Math.abs(" + param(0) + ")");
        }

        /**
         * <p>
         * Returns the absolute value of a {@code double} value. If the argument is not negative,
         * the argument is returned. If the argument is negative, the negation of the argument is
         * returned. Special cases:
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
         * Returns the absolute value of a {@code double} value. If the argument is not negative,
         * the argument is returned. If the argument is negative, the negation of the argument is
         * returned. Special cases:
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
         * Returns the smallest (closest to negative infinity) {@code double} value that is greater
         * than or equal to the argument and is equal to a mathematical integer. Special cases:
         * <ul>
         * <li>If the argument value is already equal to a mathematical integer, then the result is
         * the same as the argument.
         * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the
         * result is the same as the argument.
         * <li>If the argument value is less than zero but greater than -1.0, then the result is
         * negative zero.
         * </ul>
         * Note that the value of {@code Math.ceil(x)} is exactly the value of
         * {@code -Math.floor(-x)}.
         * 
         * @param a a value.
         * @return the smallest (closest to negative infinity) floating-point value that is greater
         *         than or equal to the argument and is equal to a mathematical integer.
         */
        public String ceil(double a) {
            return "Math.ceil(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the largest (closest to positive infinity) {@code double} value that is less than
         * or equal to the argument and is equal to a mathematical integer. Special cases:
         * </p>
         * <ul>
         * <li>If the argument value is already equal to a mathematical integer, then the result is
         * the same as the argument.</li>
         * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the
         * result is the same as the argument.</li>
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
         * Returns the greater of two {@code int} values. That is, the result is the argument closer
         * to the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the
         * result is that same value.
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
         * Returns the greater of two {@code long} values. That is, the result is the argument
         * closer to the value of {@link Long#MAX_VALUE}. If the arguments have the same value, the
         * result is that same value.
         * 
         * @param a an argument.
         * @param b another argument.
         * @return the larger of {@code a} and {@code b}.
         */
        public String max(long a, long b) {
            return long64("Math.max(" + param(0) + "," + param(1) + ")");
        }

        /**
         * Returns the greater of two {@code float} values. That is, the result is the argument
         * closer to positive infinity. If the arguments have the same value, the result is that
         * same value. If either value is NaN, then the result is NaN. Unlike the numerical
         * comparison operators, this method considers negative zero to be strictly smaller than
         * positive zero. If one argument is positive zero and the other negative zero, the result
         * is positive zero.
         *
         * @param a an argument.
         * @param b another argument.
         * @return the larger of {@code a} and {@code b}.
         */
        public String max(float a, float b) {
            return "Math.max(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Returns the greater of two {@code int} values. That is, the result is the argument closer
         * to the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the
         * result is that same value.
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
         * Returns the smaller of two {@code int} values. That is, the result the argument closer to
         * the value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result
         * is that same value.
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
         * Returns the smaller of two {@code long} values. That is, the result is the argument
         * closer to the value of {@link Long#MIN_VALUE}. If the arguments have the same value, the
         * result is that same value.
         * 
         * @param a an argument.
         * @param b another argument.
         * @return the smaller of {@code a} and {@code b}.
         */
        public String min(long a, long b) {
            return long64("Math.min(" + param(0) + "," + param(1) + ")");
        }

        /**
         * Returns the smaller of two {@code float} values. That is, the result is the value closer
         * to negative infinity. If the arguments have the same value, the result is that same
         * value. If either value is NaN, then the result is NaN. Unlike the numerical comparison
         * operators, this method considers negative zero to be strictly smaller than positive zero.
         * If one argument is positive zero and the other is negative zero, the result is negative
         * zero.
         *
         * @param a an argument.
         * @param b another argument.
         * @return the smaller of {@code a} and {@code b}.
         */
        public String min(float a, float b) {
            return "Math.min(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Returns the smaller of two {@code int} values. That is, the result the argument closer to
         * the value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result
         * is that same value.
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
         * <li>If the argument is positive infinity or any value greater than or equal to the value
         * of {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
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
         * <li>If the argument is positive infinity or any value greater than or equal to the value
         * of {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
         * </ul>
         * 
         * @param A a floating-point value to be rounded to an integer.
         * @return The value of the argument rounded to the nearest {@code int} value.
         * @see java.lang.Integer#MAX_VALUE
         * @see java.lang.Integer#MIN_VALUE
         */
        public String round(double param0) {
            return long64("Math.round(" + param(0) + ")");
        }

        /**
         * Returns the value of the first argument raised to the power of the second argument.
         * Special cases:
         * <ul>
         * <li>If the second argument is positive or negative zero, then the result is 1.0.
         * <li>If the second argument is 1.0, then the result is the same as the first argument.
         * <li>If the second argument is NaN, then the result is NaN.
         * <li>If the first argument is NaN and the second argument is nonzero, then the result is
         * NaN.
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
         * <li>If the absolute value of the first argument equals 1 and the second argument is
         * infinite, then the result is NaN.
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
         * <li>the first argument is negative zero and the second argument is greater than zero but
         * not a finite odd integer, or
         * <li>the first argument is negative infinity and the second argument is less than zero but
         * not a finite odd integer,
         * </ul>
         * then the result is positive zero.
         * <li>If
         * <ul>
         * <li>the first argument is negative zero and the second argument is a positive finite odd
         * integer, or
         * <li>the first argument is negative infinity and the second argument is a negative finite
         * odd integer,
         * </ul>
         * then the result is negative zero.
         * <li>If
         * <ul>
         * <li>the first argument is negative zero and the second argument is less than zero but not
         * a finite odd integer, or
         * <li>the first argument is negative infinity and the second argument is greater than zero
         * but not a finite odd integer,
         * </ul>
         * then the result is positive infinity.
         * <li>If
         * <ul>
         * <li>the first argument is negative zero and the second argument is a negative finite odd
         * integer, or
         * <li>the first argument is negative infinity and the second argument is a positive finite
         * odd integer,
         * </ul>
         * then the result is negative infinity.
         * <li>If the first argument is finite and less than zero
         * <ul>
         * <li>if the second argument is a finite even integer, the result is equal to the result of
         * raising the absolute value of the first argument to the power of the second argument
         * <li>if the second argument is a finite odd integer, the result is equal to the negative
         * of the result of raising the absolute value of the first argument to the power of the
         * second argument
         * <li>if the second argument is finite and not an integer, then the result is NaN.
         * </ul>
         * <li>If both arguments are integers, then the result is exactly equal to the mathematical
         * result of raising the first argument to the power of the second argument if that result
         * can in fact be represented exactly as a {@code double} value.
         * </ul>
         * <p>
         * (In the foregoing descriptions, a floating-point value is considered to be an integer if
         * and only if it is finite and a fixed point of the method {@link #ceil ceil} or,
         * equivalently, a fixed point of the method {@link #floor floor}. A value is a fixed point
         * of a one-argument method if and only if the result of applying the method to the value is
         * equal to the value.)
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
         * 
         * @param a the base.
         * @param b the exponent.
         * @return the value {@code a}<sup>{@code b}</sup>.
         */
        public String pow(double a, double b) {
            return "Math.pow(" + param(0) + "," + param(1) + ")";
        }

        /**
         * Returns the correctly rounded positive square root of a {@code double} value. Special
         * cases:
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
         * @return the positive square root of {@code a}. If the argument is NaN or less than zero,
         *         the result is NaN.
         */
        public String sqrt(double a) {
            return "Math.sqrt(" + param(0) + ")";
        }

        /**
         * Returns the trigonometric sine of an angle. Special cases:
         * <ul>
         * <li>If the argument is NaN or an infinity, then the result is NaN.
         * <li>If the argument is zero, then the result is a zero with the same sign as the
         * argument.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
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
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
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
         * <li>If the argument is zero, then the result is a zero with the same sign as the
         * argument.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
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
         * <li>If the argument is NaN or its absolute value is greater than 1, then the result is
         * NaN.
         * <li>If the argument is zero, then the result is a zero with the same sign as the
         * argument.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
         * 
         * @param a the value whose arc sine is to be returned.
         * @return the arc sine of the argument.
         */
        public String asin(double a) {
            return "Math.asin(" + param(0) + ")";
        }

        /**
         * Returns the arc cosine of a value; the returned angle is in the range 0.0 through
         * <i>pi</i>. Special case:
         * <ul>
         * <li>If the argument is NaN or its absolute value is greater than 1, then the result is
         * NaN.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
         * 
         * @param a the value whose arc cosine is to be returned.
         * @return the arc cosine of the argument.
         */
        public String acos(double a) {
            return "Math.acos(" + param(0) + ")";
        }

        /**
         * Returns the arc tangent of a value; the returned angle is in the range -<i>pi</i>/2
         * through <i>pi</i>/2. Special cases:
         * <ul>
         * <li>If the argument is NaN, then the result is NaN.
         * <li>If the argument is zero, then the result is a zero with the same sign as the
         * argument.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
         * 
         * @param a the value whose arc tangent is to be returned.
         * @return the arc tangent of the argument.
         */
        public String atan(double a) {
            return "Math.atan(" + param(0) + ")";
        }

        /**
         * Returns the angle <i>theta</i> from the conversion of rectangular coordinates ({@code x}
         * ,&nbsp;{@code y}) to polar coordinates (r,&nbsp;<i>theta</i>). This method computes the
         * phase <i>theta</i> by computing an arc tangent of {@code y/x} in the range of -<i>pi</i>
         * to <i>pi</i>. Special cases:
         * <ul>
         * <li>If either argument is NaN, then the result is NaN.
         * <li>If the first argument is positive zero and the second argument is positive, or the
         * first argument is positive and finite and the second argument is positive infinity, then
         * the result is positive zero.
         * <li>If the first argument is negative zero and the second argument is positive, or the
         * first argument is negative and finite and the second argument is positive infinity, then
         * the result is negative zero.
         * <li>If the first argument is positive zero and the second argument is negative, or the
         * first argument is positive and finite and the second argument is negative infinity, then
         * the result is the {@code double} value closest to <i>pi</i>.
         * <li>If the first argument is negative zero and the second argument is negative, or the
         * first argument is negative and finite and the second argument is negative infinity, then
         * the result is the {@code double} value closest to -<i>pi</i>.
         * <li>If the first argument is positive and the second argument is positive zero or
         * negative zero, or the first argument is positive infinity and the second argument is
         * finite, then the result is the {@code double} value closest to <i>pi</i>/2.
         * <li>If the first argument is negative and the second argument is positive zero or
         * negative zero, or the first argument is negative infinity and the second argument is
         * finite, then the result is the {@code double} value closest to -<i>pi</i>/2.
         * <li>If both arguments are positive infinity, then the result is the {@code double} value
         * closest to <i>pi</i>/4.
         * <li>If the first argument is positive infinity and the second argument is negative
         * infinity, then the result is the {@code double} value closest to 3*<i>pi</i>/4.
         * <li>If the first argument is negative infinity and the second argument is positive
         * infinity, then the result is the {@code double} value closest to -<i>pi</i>/4.
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
         * Returns a {@code double} value with a positive sign, greater than or equal to {@code 0.0}
         * and less than {@code 1.0}. Returned values are chosen pseudorandomly with (approximately)
         * uniform distribution from that range.
         * <p>
         * When this method is first called, it creates a single new pseudorandom-number generator,
         * exactly as if by the expression <blockquote>{@code new java.util.Random()}</blockquote>
         * This new pseudorandom-number generator is used thereafter for all calls to this method
         * and is used nowhere else.
         * <p>
         * This method is properly synchronized to allow correct use by more than one thread.
         * However, if many threads need to generate pseudorandom numbers at a great rate, it may
         * reduce contention for each thread to have its own pseudorandom-number generator.
         * 
         * @return a pseudorandom {@code double} greater than or equal to {@code 0.0} and less than
         *         {@code 1.0}.
         * @see Random#nextDouble()
         */
        public String random() {
            return "Math.random()";
        }

        /**
         * Returns the natural logarithm (base <i>e</i>) of a {@code double} value. Special cases:
         * <ul>
         * <li>If the argument is NaN or less than zero, then the result is NaN.
         * <li>If the argument is positive infinity, then the result is positive infinity.
         * <li>If the argument is positive zero or negative zero, then the result is negative
         * infinity.
         * </ul>
         * <p>
         * The computed result must be within 1 ulp of the exact result. Results must be
         * semi-monotonic.
         * 
         * @param a a value
         * @return the value ln&nbsp;{@code a}, the natural logarithm of {@code a}.
         */
        public String log(double param0) {
            return "Math.log(" + param(0) + ")";
        }

        /**
         * Returns the base 10 logarithm of a number
         * 
         * @param a
         * @return
         */
        public String log10(double a) {
            return "Math.log10(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the natural logarithm (base e) of 1 + a number
         * </p>
         * 
         * @param a
         * @return
         */
        public String log1p(double a) {
            return "Math.log1p(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns ex, where x is the argument, and e is Euler's constant, the base of the natural
         * logarithms.
         * </p>
         * 
         * @param a
         * @return
         */
        public String exp(double a) {
            return "Math.exp(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns ex - 1, where x is the argument, and e is Euler's constant, the base of the
         * natural logarithms.
         * </p>
         * 
         * @param a
         * @return
         */
        public String expm1(double a) {
            return "Math.expm1(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the square root of the sum of squares of its arguments
         * </p>
         * 
         * @param x
         * @param y
         * @return
         */
        public String hypot(double x, double y) {
            return "Math.hypot(" + param(0) + "," + param(1) + ")";
        }

        /**
         * Returns the cube root of a number
         * 
         * @param a
         * @return
         */
        public String cbrt(double a) {
            return "Math.cbrt(" + param(0) + ")";
        }
    }
}
