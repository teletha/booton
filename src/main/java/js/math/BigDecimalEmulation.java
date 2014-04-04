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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/15 12:53:40
 */
@JavaAPIProvider(BigDecimal.class)
class BigDecimalEmulation {

    /**
     * Rounding mode to round away from zero. Always increments the digit prior to a nonzero
     * discarded fraction. Note that this rounding mode never decreases the magnitude of the
     * calculated value.
     */
    public final static int ROUND_UP = 0;

    /**
     * Rounding mode to round towards zero. Never increments the digit prior to a discarded fraction
     * (i.e., truncates). Note that this rounding mode never increases the magnitude of the
     * calculated value.
     */
    public final static int ROUND_DOWN = 1;

    /**
     * Rounding mode to round towards positive infinity. If the {@code BigDecimal} is positive,
     * behaves as for {@code ROUND_UP}; if negative, behaves as for {@code ROUND_DOWN}. Note that
     * this rounding mode never decreases the calculated value.
     */
    public final static int ROUND_CEILING = 2;

    /**
     * Rounding mode to round towards negative infinity. If the {@code BigDecimal} is positive,
     * behave as for {@code ROUND_DOWN}; if negative, behave as for {@code ROUND_UP}. Note that this
     * rounding mode never increases the calculated value.
     */
    public final static int ROUND_FLOOR = 3;

    /**
     * Rounding mode to round towards {@literal "nearest neighbor"} unless both neighbors are
     * equidistant, in which case round up. Behaves as for {@code ROUND_UP} if the discarded
     * fraction is &ge; 0.5; otherwise, behaves as for {@code ROUND_DOWN}. Note that this is the
     * rounding mode that most of us were taught in grade school.
     */
    public final static int ROUND_HALF_UP = 4;

    /**
     * Rounding mode to round towards {@literal "nearest neighbor"} unless both neighbors are
     * equidistant, in which case round down. Behaves as for {@code ROUND_UP} if the discarded
     * fraction is {@literal >} 0.5; otherwise, behaves as for {@code ROUND_DOWN}.
     */
    public final static int ROUND_HALF_DOWN = 5;

    /**
     * Rounding mode to round towards the {@literal "nearest neighbor"} unless both neighbors are
     * equidistant, in which case, round towards the even neighbor. Behaves as for
     * {@code ROUND_HALF_UP} if the digit to the left of the discarded fraction is odd; behaves as
     * for {@code ROUND_HALF_DOWN} if it's even. Note that this is the rounding mode that minimizes
     * cumulative error when applied repeatedly over a sequence of calculations.
     */
    public final static int ROUND_HALF_EVEN = 6;

    /**
     * Rounding mode to assert that the requested operation has an exact result, hence no rounding
     * is necessary. If this rounding mode is specified on an operation that yields an inexact
     * result, an {@code ArithmeticException} is thrown.
     */
    public final static int ROUND_UNNECESSARY = 7;

    /** The current context. */
    private MathContext context = MathContext.DECIMAL32;

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this +
     * augend)}, and whose scale is {@code max(this.scale(),
     * augend.scale())}.
     *
     * @param augend value to be added to this {@code BigDecimal}.
     * @return {@code this + augend}
     */
    public BigDecimal add(BigDecimal augend) {
        return add(augend, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this + augend)}, with rounding according
     * to the context settings. If either number is zero and the precision setting is nonzero then
     * the other number, rounded if necessary, is used as the result.
     *
     * @param augend value to be added to this {@code BigDecimal}.
     * @param mc the context to use.
     * @return {@code this + augend}, rounded as necessary.
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}.
     * @since 1.5
     */
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this -
     * subtrahend)}, and whose scale is {@code max(this.scale(),
     * subtrahend.scale())}.
     *
     * @param subtrahend value to be subtracted from this {@code BigDecimal}.
     * @return {@code this - subtrahend}
     */
    public BigDecimal subtract(BigDecimal subtrahend) {
        return subtract(subtrahend, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this - subtrahend)}, with rounding
     * according to the context settings. If {@code subtrahend} is zero then this, rounded if
     * necessary, is used as the result. If this is zero then the result is
     * {@code subtrahend.negate(mc)}.
     *
     * @param subtrahend value to be subtracted from this {@code BigDecimal}.
     * @param mc the context to use.
     * @return {@code this - subtrahend}, rounded as necessary.
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}.
     * @since 1.5
     */
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@code BigDecimal} whose value is <tt>(this &times;
     * multiplicand)</tt>, and whose scale is {@code (this.scale() +
     * multiplicand.scale())}.
     *
     * @param multiplicand value to be multiplied by this {@code BigDecimal}.
     * @return {@code this * multiplicand}
     */
    public BigDecimal multiply(BigDecimal multiplicand) {
        return multiply(multiplicand, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is <tt>(this &times;
     * multiplicand)</tt>, with rounding according to the context settings.
     *
     * @param multiplicand value to be multiplied by this {@code BigDecimal}.
     * @param mc the context to use.
     * @return {@code this * multiplicand}, rounded as necessary.
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}.
     * @since 1.5
     */
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this /
     * divisor)}, and whose preferred scale is {@code (this.scale() -
     * divisor.scale())}; if the exact quotient cannot be represented (because it has a
     * non-terminating decimal expansion) an {@code ArithmeticException} is thrown.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @throws ArithmeticException if the exact quotient does not have a terminating decimal
     *             expansion
     * @return {@code this / divisor}
     * @since 1.5
     * @author Joseph D. Darcy
     */
    public BigDecimal divide(BigDecimal divisor) {
        return divide(divisor, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this /
     * divisor)}, and whose scale is {@code this.scale()}. If rounding must be performed to generate
     * a result with the given scale, the specified rounding mode is applied.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @param roundingMode rounding mode to apply.
     * @return {@code this / divisor}
     * @throws ArithmeticException if {@code divisor==0}, or
     *             {@code roundingMode==RoundingMode.UNNECESSARY} and {@code this.scale()} is
     *             insufficient to represent the result of the division exactly.
     * @since 1.5
     */
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        return divide(divisor, new MathContext(context.getPrecision(), roundingMode));
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this /
     * divisor)}, with rounding according to the context settings.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @param mc the context to use.
     * @return {@code this / divisor}, rounded as necessary.
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY} or {@code mc.precision == 0} and the quotient has a
     *             non-terminating decimal expansion.
     * @since 1.5
     */
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@code BigDecimal} whose value is the integer part of the quotient
     * {@code (this / divisor)} rounded down. The preferred scale of the result is
     * {@code (this.scale() -
     * divisor.scale())}.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @return The integer part of {@code this / divisor}.
     * @throws ArithmeticException if {@code divisor==0}
     * @since 1.5
     */
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        return divideToIntegralValue(divisor, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is the integer part of {@code (this / divisor)}.
     * Since the integer part of the exact quotient does not depend on the rounding mode, the
     * rounding mode does not affect the values returned by this method. The preferred scale of the
     * result is {@code (this.scale() - divisor.scale())}. An {@code ArithmeticException} is thrown
     * if the integer part of the exact quotient needs more than {@code mc.precision} digits.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @param mc the context to use.
     * @return The integer part of {@code this / divisor}.
     * @throws ArithmeticException if {@code divisor==0}
     * @throws ArithmeticException if {@code mc.precision} {@literal >} 0 and the result requires a
     *             precision of more than {@code mc.precision} digits.
     * @since 1.5
     * @author Joseph D. Darcy
     */
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a two-element {@code BigDecimal} array containing the result of
     * {@code divideToIntegralValue} followed by the result of {@code remainder} on the two
     * operands.
     * <p>
     * Note that if both the integer quotient and remainder are needed, this method is faster than
     * using the {@code divideToIntegralValue} and {@code remainder} methods separately because the
     * division need only be carried out once.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided, and the remainder
     *            computed.
     * @return a two element {@code BigDecimal} array: the quotient (the result of
     *         {@code divideToIntegralValue}) is the initial element and the remainder is the final
     *         element.
     * @throws ArithmeticException if {@code divisor==0}
     * @see #divideToIntegralValue(java.math.BigDecimal, java.math.MathContext)
     * @see #remainder(java.math.BigDecimal, java.math.MathContext)
     * @since 1.5
     */
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        return divideAndRemainder(divisor, context);
    }

    /**
     * Returns a two-element {@code BigDecimal} array containing the result of
     * {@code divideToIntegralValue} followed by the result of {@code remainder} on the two operands
     * calculated with rounding according to the context settings.
     * <p>
     * Note that if both the integer quotient and remainder are needed, this method is faster than
     * using the {@code divideToIntegralValue} and {@code remainder} methods separately because the
     * division need only be carried out once.
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided, and the remainder
     *            computed.
     * @param mc the context to use.
     * @return a two element {@code BigDecimal} array: the quotient (the result of
     *         {@code divideToIntegralValue}) is the initial element and the remainder is the final
     *         element.
     * @throws ArithmeticException if {@code divisor==0}
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}, or {@code mc.precision} {@literal >} 0 and the result of
     *             {@code this.divideToIntgralValue(divisor)} would require a precision of more than
     *             {@code mc.precision} digits.
     * @see #divideToIntegralValue(java.math.BigDecimal, java.math.MathContext)
     * @see #remainder(java.math.BigDecimal, java.math.MathContext)
     * @since 1.5
     */
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        BigDecimal[] result = new BigDecimal[2];
    
        result[0] = divideToIntegralValue(divisor, mc);
        result[1] = subtract(result[0].multiply(divisor, mc));
        return result;
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this % divisor)}.
     * <p>
     * The remainder is given by
     * {@code this.subtract(this.divideToIntegralValue(divisor).multiply(divisor))}. Note that this
     * is not the modulo operation (the result can be negative).
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @return {@code this % divisor}.
     * @throws ArithmeticException if {@code divisor==0}
     * @since 1.5
     */
    public BigDecimal remainder(BigDecimal divisor) {
        return remainder(divisor, context);
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this %
     * divisor)}, with rounding according to the context settings. The {@code MathContext} settings
     * affect the implicit divide used to compute the remainder. The remainder computation itself is
     * by definition exact. Therefore, the remainder may contain more than {@code mc.getPrecision()}
     * digits.
     * <p>
     * The remainder is given by {@code this.subtract(this.divideToIntegralValue(divisor,
     * mc).multiply(divisor))}. Note that this is not the modulo operation (the result can be
     * negative).
     *
     * @param divisor value by which this {@code BigDecimal} is to be divided.
     * @param mc the context to use.
     * @return {@code this % divisor}, rounded as necessary.
     * @throws ArithmeticException if {@code divisor==0}
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}, or {@code mc.precision} {@literal >} 0 and the result of
     *             {@code this.divideToIntgralValue(divisor)} would require a precision of more than
     *             {@code mc.precision} digits.
     * @see #divideToIntegralValue(java.math.BigDecimal, java.math.MathContext)
     * @since 1.5
     */
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        return divideAndRemainder(divisor, mc)[1];
    }

    /**
     * Returns a {@code BigDecimal} which is equivalent to this one with the decimal point moved
     * {@code n} places to the left. If {@code n} is non-negative, the call merely adds {@code n} to
     * the scale. If {@code n} is negative, the call is equivalent to {@code movePointRight(-n)}.
     * The {@code BigDecimal} returned by this call has value <tt>(this &times;
     * 10<sup>-n</sup>)</tt> and scale {@code max(this.scale()+n,
     * 0)}.
     *
     * @param n number of places to move the decimal point to the left.
     * @return a {@code BigDecimal} which is equivalent to this one with the decimal point moved
     *         {@code n} places to the left.
     * @throws ArithmeticException if scale overflows.
     */
    public BigDecimal movePointLeft(int n) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a {@code BigDecimal} which is equivalent to this one with the decimal point moved
     * {@code n} places to the right. If {@code n} is non-negative, the call merely subtracts
     * {@code n} from the scale. If {@code n} is negative, the call is equivalent to
     * {@code movePointLeft(-n)}. The {@code BigDecimal} returned by this call has value <tt>(this
     * &times; 10<sup>n</sup>)</tt> and scale {@code max(this.scale()-n,
     * 0)}.
     *
     * @param n number of places to move the decimal point to the right.
     * @return a {@code BigDecimal} which is equivalent to this one with the decimal point moved
     *         {@code n} places to the right.
     * @throws ArithmeticException if scale overflows.
     */
    public BigDecimal movePointRight(int n) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Converts this {@code BigDecimal} to a {@code BigInteger}. This conversion is analogous to the
     * <i>narrowing primitive conversion</i> from {@code double} to {@code long} as defined in
     * section 5.1.3 of <cite>The Java&trade; Language Specification</cite>: any fractional part of
     * this {@code BigDecimal} will be discarded. Note that this conversion can lose information
     * about the precision of the {@code BigDecimal} value.
     * <p>
     * To have an exception thrown if the conversion is inexact (in other words if a nonzero
     * fractional part is discarded), use the {@link #toBigIntegerExact()} method.
     *
     * @return this {@code BigDecimal} converted to a {@code BigInteger}.
     */
    public BigInteger toBigInteger() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Converts this {@code BigDecimal} to a {@code BigInteger}, checking for lost information. An
     * exception is thrown if this {@code BigDecimal} has a nonzero fractional part.
     *
     * @return this {@code BigDecimal} converted to a {@code BigInteger}.
     * @throws ArithmeticException if {@code this} has a nonzero fractional part.
     * @since 1.5
     */
    public BigInteger toBigIntegerExact() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Translates a {@code long} unscaled value and an {@code int} scale into a {@code BigDecimal}.
     * This {@literal "static factory method"} is provided in preference to a ({@code long},
     * {@code int}) constructor because it allows for reuse of frequently used {@code BigDecimal}
     * values..
     *
     * @param unscaledVal unscaled value of the {@code BigDecimal}.
     * @param scale scale of the {@code BigDecimal}.
     * @return a {@code BigDecimal} whose value is
     *         <tt>(unscaledVal &times; 10<sup>-scale</sup>)</tt>.
     */
    public static BigDecimal valueOf(long unscaledVal, int scale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Translates a {@code long} value into a {@code BigDecimal} with a scale of zero. This
     * {@literal "static factory method"} is provided in preference to a ({@code long}) constructor
     * because it allows for reuse of frequently used {@code BigDecimal} values.
     *
     * @param val value of the {@code BigDecimal}.
     * @return a {@code BigDecimal} whose value is {@code val}.
     */
    public static BigDecimal valueOf(long val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();

    }

    /**
     * Translates a {@code double} into a {@code BigDecimal}, using the {@code double}'s canonical
     * string representation provided by the {@link Double#toString(double)} method.
     * <p>
     * <b>Note:</b> This is generally the preferred way to convert a {@code double} (or
     * {@code float}) into a {@code BigDecimal}, as the value returned is equal to that resulting
     * from constructing a {@code BigDecimal} from the result of using
     * {@link Double#toString(double)}.
     *
     * @param val {@code double} to convert to a {@code BigDecimal}.
     * @return a {@code BigDecimal} whose value is equal to or approximately equal to the value of
     *         {@code val}.
     * @throws NumberFormatException if {@code val} is infinite or NaN.
     * @since 1.5
     */
    public static BigDecimal valueOf(double val) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
