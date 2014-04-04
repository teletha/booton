/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Random;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/11 16:08:36
 */
@JavaAPIProvider(Math.class)
public class JSMath {

    /**
     * The {@code double} value that is closer than any other to <i>e</i>, the base of the natural
     * logarithms.
     */
    public static final double E = 2.7182818284590452354;

    /**
     * The {@code double} value that is closer than any other to <i>pi</i>, the ratio of the
     * circumference of a circle to its diameter.
     */
    public static final double PI = 3.14159265358979323846;

    /**
     * Don't let anyone instantiate this class.
     */
    private JSMath() {
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
        return NativeMath.sin(a); // default impl. delegates to StrictMath
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
        return NativeMath.cos(a); // default impl. delegates to StrictMath
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
        return NativeMath.tan(a); // default impl. delegates to StrictMath
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
        return NativeMath.asin(a); // default impl. delegates to StrictMath
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
        return NativeMath.acos(a); // default impl. delegates to StrictMath
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
        return NativeMath.atan(a); // default impl. delegates to StrictMath
    }

    /**
     * Converts an angle measured in degrees to an approximately equivalent angle measured in
     * radians. The conversion from degrees to radians is generally inexact.
     *
     * @param angdeg an angle, in degrees
     * @return the measurement of the angle {@code angdeg} in radians.
     * @since 1.2
     */
    public static double toRadians(double angdeg) {
        return angdeg / 180.0 * PI;
    }

    /**
     * Converts an angle measured in radians to an approximately equivalent angle measured in
     * degrees. The conversion from radians to degrees is generally inexact; users should <i>not</i>
     * expect {@code cos(toRadians(90.0))} to exactly equal {@code 0.0}.
     *
     * @param angrad an angle, in radians
     * @return the measurement of the angle {@code angrad} in degrees.
     * @since 1.2
     */
    public static double toDegrees(double angrad) {
        return angrad * 180.0 / PI;
    }

    /**
     * Returns Euler's number <i>e</i> raised to the power of a {@code double} value. Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is negative infinity, then the result is positive zero.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     *
     * @param a the exponent to raise <i>e</i> to.
     * @return the value <i>e</i><sup>{@code a}</sup>, where <i>e</i> is the base of the natural
     *         logarithms.
     */
    public static double exp(double a) {
        return NativeMath.exp(a); // default impl. delegates to StrictMath
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
        return NativeMath.log(a); // default impl. delegates to StrictMath
    }

    /**
     * Returns the base 10 logarithm of a {@code double} value. Special cases:
     * <ul>
     * <li>If the argument is NaN or less than zero, then the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is positive zero or negative zero, then the result is negative infinity.
     * <li>If the argument is equal to 10<sup><i>n</i></sup> for integer <i>n</i>, then the result
     * is <i>n</i>.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     *
     * @param a a value
     * @return the base 10 logarithm of {@code a}.
     * @since 1.5
     */
    public static double log10(double a) {
        return NativeMath.log10(a); // default impl. delegates to StrictMath
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
        return NativeMath.sqrt(a); // default impl. delegates to StrictMath
                                   // Note that hardware sqrt instructions
                                   // frequently can be directly used by JITs
                                   // and should be much faster than doing
                                   // Math.sqrt in software.
    }

    /**
     * Returns the cube root of a {@code double} value. For positive finite {@code x},
     * {@code cbrt(-x) ==
     * -cbrt(x)}; that is, the cube root of a negative value is the negative of the cube root of
     * that value's magnitude. Special cases:
     * <ul>
     * <li>If the argument is NaN, then the result is NaN.
     * <li>If the argument is infinite, then the result is an infinity with the same sign as the
     * argument.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result.
     *
     * @param a a value.
     * @return the cube root of {@code a}.
     * @since 1.5
     */
    public static double cbrt(double a) {
        return NativeMath.cbrt(a);
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
        return NativeMath.ceil(a); // default impl. delegates to StrictMath
    }

    /**
     * Returns the largest (closest to positive infinity) {@code double} value that is less than or
     * equal to the argument and is equal to a mathematical integer. Special cases:
     * <ul>
     * <li>If the argument value is already equal to a mathematical integer, then the result is the
     * same as the argument.
     * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result
     * is the same as the argument.
     * </ul>
     *
     * @param a a value.
     * @return the largest (closest to positive infinity) floating-point value that less than or
     *         equal to the argument and is equal to a mathematical integer.
     */
    public static double floor(double a) {
        return NativeMath.floor(a); // default impl. delegates to StrictMath
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
        return NativeMath.atan2(y, x); // default impl. delegates to StrictMath
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
        return NativeMath.pow(a, b); // default impl. delegates to StrictMath
    }

    /**
     * Returns the closest {@code int} to the argument, with ties rounding to positive infinity.
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Integer.MIN_VALUE}, the result is equal to the value of {@code Integer.MIN_VALUE}.
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Integer.MAX_VALUE}, the result is equal to the value of {@code Integer.MAX_VALUE}.
     * </ul>
     *
     * @param a a floating-point value to be rounded to an integer.
     * @return the value of the argument rounded to the nearest {@code int} value.
     * @see java.lang.Integer#MAX_VALUE
     * @see java.lang.Integer#MIN_VALUE
     */
    public static int round(float a) {
        return NativeMath.round(a);
    }

    /**
     * Returns the closest {@code long} to the argument, with ties rounding to positive infinity.
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Long.MIN_VALUE}, the result is equal to the value of {@code Long.MIN_VALUE}.
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.
     * </ul>
     *
     * @param a a floating-point value to be rounded to a {@code long}.
     * @return the value of the argument rounded to the nearest {@code long} value.
     * @see java.lang.Long#MAX_VALUE
     * @see java.lang.Long#MIN_VALUE
     */
    public static long round(double a) {
        return NativeMath.round(a);
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
        return NativeMath.random();
    }

    /**
     * Returns the sum of its arguments, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int addExact(int x, int y) {
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    /**
     * Returns the sum of its arguments, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long addExact(long x, long y) {
        long r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("long overflow");
        }
        return r;
    }

    /**
     * Returns the difference of the arguments, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int subtractExact(int x, int y) {
        int r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    /**
     * Returns the difference of the arguments, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long subtractExact(long x, long y) {
        long r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("long overflow");
        }
        return r;
    }

    /**
     * Returns the product of the arguments, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int multiplyExact(int x, int y) {
        long r = (long) x * (long) y;
        if ((int) r != r) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) r;
    }

    /**
     * Returns the product of the arguments, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long multiplyExact(long x, long y) {
        long r = x * y;
        long ax = Math.abs(x);
        long ay = Math.abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Long.MIN_VALUE * -1
            if (((y != 0) && (r / y != x)) || (x == Long.MIN_VALUE && y == -1)) {
                throw new ArithmeticException("long overflow");
            }
        }
        return r;
    }

    /**
     * Returns the argument incremented by one, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param a the value to increment
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int incrementExact(int a) {
        if (a == Integer.MAX_VALUE) {
            throw new ArithmeticException("integer overflow");
        }

        return a + 1;
    }

    /**
     * Returns the argument incremented by one, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param a the value to increment
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long incrementExact(long a) {
        if (a == Long.MAX_VALUE) {
            throw new ArithmeticException("long overflow");
        }

        return a + 1L;
    }

    /**
     * Returns the argument decremented by one, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param a the value to decrement
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int decrementExact(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }

        return a - 1;
    }

    /**
     * Returns the argument decremented by one, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param a the value to decrement
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long decrementExact(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }

        return a - 1L;
    }

    /**
     * Returns the negation of the argument, throwing an exception if the result overflows an
     * {@code int}.
     *
     * @param a the value to negate
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    public static int negateExact(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }

        return -a;
    }

    /**
     * Returns the negation of the argument, throwing an exception if the result overflows a
     * {@code long}.
     *
     * @param a the value to negate
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     * @since 1.8
     */
    public static long negateExact(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }

        return -a;
    }

    /**
     * Returns the value of the {@code long} argument; throwing an exception if the value overflows
     * an {@code int}.
     *
     * @param value the long value
     * @return the argument as an int
     * @throws ArithmeticException if the {@code argument} overflows an int
     * @since 1.8
     */
    public static int toIntExact(long value) {
        if ((int) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) value;
    }

    /**
     * Returns the largest (closest to positive infinity) {@code int} value that is less than or
     * equal to the algebraic quotient. There is one special case, if the dividend is the
     * {@linkplain Integer#MIN_VALUE Integer.MIN_VALUE} and the divisor is {@code -1}, then integer
     * overflow occurs and the result is equal to the {@code Integer.MIN_VALUE}.
     * <p>
     * Normal integer division operates under the round to zero rounding mode (truncation). This
     * operation instead acts under the round toward negative infinity (floor) rounding mode. The
     * floor rounding mode gives different results than truncation when the exact result is
     * negative.
     * <ul>
     * <li>If the signs of the arguments are the same, the results of {@code floorDiv} and the
     * {@code /} operator are the same. <br>
     * For example, {@code floorDiv(4, 3) == 1} and {@code (4 / 3) == 1}.</li>
     * <li>If the signs of the arguments are different, the quotient is negative and
     * {@code floorDiv} returns the integer less than or equal to the quotient and the {@code /}
     * operator returns the integer closest to zero.<br>
     * For example, {@code floorDiv(-4, 3) == -2}, whereas {@code (-4 / 3) == -1}.</li>
     * </ul>
     * <p>
     *
     * @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity) {@code int} value that is less than or
     *         equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     * @see #floorMod(int, int)
     * @see #floor(double)
     * @since 1.8
     */
    public static int floorDiv(int x, int y) {
        int r = x / y;
        // if the signs are different and modulo not zero, round down
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }

    /**
     * Returns the largest (closest to positive infinity) {@code long} value that is less than or
     * equal to the algebraic quotient. There is one special case, if the dividend is the
     * {@linkplain Long#MIN_VALUE Long.MIN_VALUE} and the divisor is {@code -1}, then integer
     * overflow occurs and the result is equal to the {@code Long.MIN_VALUE}.
     * <p>
     * Normal integer division operates under the round to zero rounding mode (truncation). This
     * operation instead acts under the round toward negative infinity (floor) rounding mode. The
     * floor rounding mode gives different results than truncation when the exact result is
     * negative.
     * <p>
     * For examples, see {@link #floorDiv(int, int)}.
     *
     * @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity) {@code long} value that is less than or
     *         equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     * @see #floorMod(long, long)
     * @see #floor(double)
     * @since 1.8
     */
    public static long floorDiv(long x, long y) {
        long r = x / y;
        // if the signs are different and modulo not zero, round down
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }

    /**
     * Returns the floor modulus of the {@code int} arguments.
     * <p>
     * The floor modulus is {@code x - (floorDiv(x, y) * y)}, has the same sign as the divisor
     * {@code y}, and is in the range of {@code -abs(y) < r < +abs(y)}.
     * <p>
     * The relationship between {@code floorDiv} and {@code floorMod} is such that:
     * <ul>
     * <li>{@code floorDiv(x, y) * y + floorMod(x, y) == x}
     * </ul>
     * <p>
     * The difference in values between {@code floorMod} and the {@code %} operator is due to the
     * difference between {@code floorDiv} that returns the integer less than or equal to the
     * quotient and the {@code /} operator that returns the integer closest to zero.
     * <p>
     * Examples:
     * <ul>
     * <li>If the signs of the arguments are the same, the results of {@code floorMod} and the
     * {@code %} operator are the same. <br>
     * <ul>
     * <li>{@code floorMod(4, 3) == 1}; &nbsp; and {@code (4 % 3) == 1}</li>
     * </ul>
     * <li>If the signs of the arguments are different, the results differ from the {@code %}
     * operator.<br>
     * <ul>
     * <li>{@code floorMod(+4, -3) == -2}; &nbsp; and {@code (+4 % -3) == +1}</li>
     * <li>{@code floorMod(-4, +3) == +2}; &nbsp; and {@code (-4 % +3) == -1}</li>
     * <li>{@code floorMod(-4, -3) == -1}; &nbsp; and {@code (-4 % -3) == -1 }</li>
     * </ul>
     * </li>
     * </ul>
     * <p>
     * If the signs of arguments are unknown and a positive modulus is needed it can be computed as
     * {@code (floorMod(x, y) + abs(y)) % abs(y)}.
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     * @see #floorDiv(int, int)
     * @since 1.8
     */
    public static int floorMod(int x, int y) {
        int r = x - floorDiv(x, y) * y;
        return r;
    }

    /**
     * Returns the floor modulus of the {@code long} arguments.
     * <p>
     * The floor modulus is {@code x - (floorDiv(x, y) * y)}, has the same sign as the divisor
     * {@code y}, and is in the range of {@code -abs(y) < r < +abs(y)}.
     * <p>
     * The relationship between {@code floorDiv} and {@code floorMod} is such that:
     * <ul>
     * <li>{@code floorDiv(x, y) * y + floorMod(x, y) == x}
     * </ul>
     * <p>
     * For examples, see {@link #floorMod(int, int)}.
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     * @see #floorDiv(long, long)
     * @since 1.8
     */
    public static long floorMod(long x, long y) {
        return x - floorDiv(x, y) * y;
    }

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
        return (a < 0) ? -a : a;
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
        return (a < 0) ? -a : a;
    }

    /**
     * Returns the absolute value of a {@code float} value. If the argument is not negative, the
     * argument is returned. If the argument is negative, the negation of the argument is returned.
     * Special cases:
     * <ul>
     * <li>If the argument is positive zero or negative zero, the result is positive zero.
     * <li>If the argument is infinite, the result is positive infinity.
     * <li>If the argument is NaN, the result is NaN.
     * </ul>
     * In other words, the result is the same as the value of the expression:
     * <p>
     * {@code Float.intBitsToFloat(0x7fffffff & Float.floatToIntBits(a))}
     *
     * @param a the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public static float abs(float a) {
        return (a <= 0.0F) ? 0.0F - a : a;
    }

    /**
     * Returns the absolute value of a {@code double} value. If the argument is not negative, the
     * argument is returned. If the argument is negative, the negation of the argument is returned.
     * Special cases:
     * <ul>
     * <li>If the argument is positive zero or negative zero, the result is positive zero.
     * <li>If the argument is infinite, the result is positive infinity.
     * <li>If the argument is NaN, the result is NaN.
     * </ul>
     * In other words, the result is the same as the value of the expression:
     * <p>
     * {@code Double.longBitsToDouble((Double.doubleToLongBits(a)<<1)>>>1)}
     *
     * @param a the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public static double abs(double a) {
        return (a <= 0.0D) ? 0.0D - a : a;
    }

    /**
     * Returns the greater of two {@code int} values. That is, the result is the argument closer to
     * the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the result is
     * that same value.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public static int max(int a, int b) {
        return NativeMath.max(a, b);
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
        return NativeMath.max(a, b);
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
        return NativeMath.max(a, b);
    }

    /**
     * Returns the greater of two {@code double} values. That is, the result is the argument closer
     * to positive infinity. If the arguments have the same value, the result is that same value. If
     * either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this
     * method considers negative zero to be strictly smaller than positive zero. If one argument is
     * positive zero and the other negative zero, the result is positive zero.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public static double max(double a, double b) {
        return NativeMath.max(a, b);
    }

    /**
     * Returns the smaller of two {@code int} values. That is, the result the argument closer to the
     * value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public static int min(int a, int b) {
        return NativeMath.min(a, b);
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
        return NativeMath.min(a, b);
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
        return NativeMath.min(a, b);
    }

    /**
     * Returns the smaller of two {@code double} values. That is, the result is the value closer to
     * negative infinity. If the arguments have the same value, the result is that same value. If
     * either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this
     * method considers negative zero to be strictly smaller than positive zero. If one argument is
     * positive zero and the other is negative zero, the result is negative zero.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public static double min(double a, double b) {
        return NativeMath.max(a, b);
    }

    /**
     * Returns sqrt(<i>x</i><sup>2</sup>&nbsp;+<i>y</i><sup>2</sup>) without intermediate overflow
     * or underflow.
     * <p>
     * Special cases:
     * <ul>
     * <li>If either argument is infinite, then the result is positive infinity.
     * <li>If either argument is NaN and neither argument is infinite, then the result is NaN.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. If one parameter is held
     * constant, the results must be semi-monotonic in the other parameter.
     *
     * @param x a value
     * @param y a value
     * @return sqrt(<i>x</i><sup>2</sup>&nbsp;+<i>y</i><sup>2</sup>) without intermediate overflow
     *         or underflow
     * @since 1.5
     */
    public static double hypot(double x, double y) {
        return NativeMath.hypot(x, y);
    }

    /**
     * Returns <i>e</i><sup>x</sup>&nbsp;-1. Note that for values of <i>x</i> near 0, the exact sum
     * of {@code expm1(x)}&nbsp;+&nbsp;1 is much closer to the true result of <i>e</i><sup>x</sup>
     * than {@code exp(x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is negative infinity, then the result is -1.0.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     * The result of {@code expm1} for any finite input must be greater than or equal to
     * {@code -1.0}. Note that once the exact result of <i>e</i><sup>{@code x}</sup>&nbsp;-&nbsp;1
     * is within 1/2 ulp of the limit value -1, {@code -1.0} should be returned.
     *
     * @param x the exponent to raise <i>e</i> to in the computation of <i>e</i><sup>{@code x}
     *            </sup>&nbsp;-1.
     * @return the value <i>e</i><sup>{@code x}</sup>&nbsp;-&nbsp;1.
     * @since 1.5
     */
    public static double expm1(double x) {
        return NativeMath.expm1(x);
    }

    /**
     * Returns the natural logarithm of the sum of the argument and 1. Note that for small values
     * {@code x}, the result of {@code log1p(x)} is much closer to the true result of ln(1 +
     * {@code x}) than the floating-point evaluation of {@code log(1.0+x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN or less than -1, then the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive infinity.
     * <li>If the argument is negative one, then the result is negative infinity.
     * <li>If the argument is zero, then the result is a zero with the same sign as the argument.
     * </ul>
     * <p>
     * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
     *
     * @param x a value
     * @return the value ln({@code x}&nbsp;+&nbsp;1), the natural log of {@code x}&nbsp;+&nbsp;1
     * @since 1.5
     */
    public static double log1p(double x) {
        return NativeMath.log1p(x);
    }
}
