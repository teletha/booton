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

import static js.math.APIConveter.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/15 12:53:40
 */
@JavaAPIProvider(BigDecimal.class)
class JSBigDecimal {

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

    private static final long HALF_LONG_MAX_VALUE = Long.MAX_VALUE / 2;

    private static final long HALF_LONG_MIN_VALUE = Long.MIN_VALUE / 2;

    // All 18-digit base ten strings fit into a long; not all 19-digit
    // strings will
    private static final int MAX_COMPACT_DIGITS = 18;

    private static volatile BigInteger BIG_TEN_POWERS_TABLE[] = {BigInteger.ONE, BigInteger.valueOf(10),
            BigInteger.valueOf(100), BigInteger.valueOf(1000), BigInteger.valueOf(10000), BigInteger.valueOf(100000),
            BigInteger.valueOf(1000000), BigInteger.valueOf(10000000), BigInteger.valueOf(100000000),
            BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L),
            BigInteger.valueOf(1000000000000L), BigInteger.valueOf(10000000000000L),
            BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L),
            BigInteger.valueOf(10000000000000000L), BigInteger.valueOf(100000000000000000L),
            BigInteger.valueOf(1000000000000000000L)};

    private static final int BIG_TEN_POWERS_TABLE_INITLEN = BIG_TEN_POWERS_TABLE.length;

    private static final int BIG_TEN_POWERS_TABLE_MAX = 16 * BIG_TEN_POWERS_TABLE_INITLEN;

    private static final StringBuilderHelper threadLocalStringBuilderHelper = new StringBuilderHelper();

    // Cache of common small BigDecimal values.
    private static final JSBigDecimal zeroThroughTen[] = {new JSBigDecimal(BigInteger.ZERO, 0, 0, 1),
            new JSBigDecimal(BigInteger.ONE, 1, 0, 1), new JSBigDecimal(BigInteger.valueOf(2), 2, 0, 1),
            new JSBigDecimal(BigInteger.valueOf(3), 3, 0, 1), new JSBigDecimal(BigInteger.valueOf(4), 4, 0, 1),
            new JSBigDecimal(BigInteger.valueOf(5), 5, 0, 1), new JSBigDecimal(BigInteger.valueOf(6), 6, 0, 1),
            new JSBigDecimal(BigInteger.valueOf(7), 7, 0, 1), new JSBigDecimal(BigInteger.valueOf(8), 8, 0, 1),
            new JSBigDecimal(BigInteger.valueOf(9), 9, 0, 1), new JSBigDecimal(BigInteger.TEN, 10, 0, 2),};

    // Cache of zero scaled by 0 - 15
    private static final JSBigDecimal[] ZERO_SCALED_BY = {zeroThroughTen[0],
            new JSBigDecimal(BigInteger.ZERO, 0, 1, 1), new JSBigDecimal(BigInteger.ZERO, 0, 2, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 3, 1), new JSBigDecimal(BigInteger.ZERO, 0, 4, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 5, 1), new JSBigDecimal(BigInteger.ZERO, 0, 6, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 7, 1), new JSBigDecimal(BigInteger.ZERO, 0, 8, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 9, 1), new JSBigDecimal(BigInteger.ZERO, 0, 10, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 11, 1), new JSBigDecimal(BigInteger.ZERO, 0, 12, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 13, 1), new JSBigDecimal(BigInteger.ZERO, 0, 14, 1),
            new JSBigDecimal(BigInteger.ZERO, 0, 15, 1),};

    private static final long[] LONG_TEN_POWERS_TABLE = {1, // 0 / 10^0
            10, // 1 / 10^1
            100, // 2 / 10^2
            1000, // 3 / 10^3
            10000, // 4 / 10^4
            100000, // 5 / 10^5
            1000000, // 6 / 10^6
            10000000, // 7 / 10^7
            100000000, // 8 / 10^8
            1000000000, // 9 / 10^9
            10000000000L, // 10 / 10^10
            100000000000L, // 11 / 10^11
            1000000000000L, // 12 / 10^12
            10000000000000L, // 13 / 10^13
            100000000000000L, // 14 / 10^14
            1000000000000000L, // 15 / 10^15
            10000000000000000L, // 16 / 10^16
            100000000000000000L, // 17 / 10^17
            1000000000000000000L // 18 / 10^18
    };

    private static final long THRESHOLDS_TABLE[] = {Long.MAX_VALUE, // 0
            Long.MAX_VALUE / 10L, // 1
            Long.MAX_VALUE / 100L, // 2
            Long.MAX_VALUE / 1000L, // 3
            Long.MAX_VALUE / 10000L, // 4
            Long.MAX_VALUE / 100000L, // 5
            Long.MAX_VALUE / 1000000L, // 6
            Long.MAX_VALUE / 10000000L, // 7
            Long.MAX_VALUE / 100000000L, // 8
            Long.MAX_VALUE / 1000000000L, // 9
            Long.MAX_VALUE / 10000000000L, // 10
            Long.MAX_VALUE / 100000000000L, // 11
            Long.MAX_VALUE / 1000000000000L, // 12
            Long.MAX_VALUE / 10000000000000L, // 13
            Long.MAX_VALUE / 100000000000000L, // 14
            Long.MAX_VALUE / 1000000000000000L, // 15
            Long.MAX_VALUE / 10000000000000000L, // 16
            Long.MAX_VALUE / 100000000000000000L, // 17
            Long.MAX_VALUE / 1000000000000000000L // 18
    };

    /**
     * Sentinel value for {@link #intCompact} indicating the significand information is only
     * available from {@code intVal}.
     */
    static final long INFLATED = Long.MIN_VALUE;

    private static final BigInteger INFLATED_BIGINT = JSBigInteger.valueOf(INFLATED);

    private static final RoundingMode DOWN = null;

    /**
     * The unscaled value of this BigDecimal, as returned by {@link #unscaledValue}.
     *
     * @serial
     * @see #unscaledValue
     */
    private final BigInteger intVal;

    /**
     * The scale of this BigDecimal, as returned by {@link #scale}.
     *
     * @serial
     * @see #scale
     */
    private final int scale; // Note: this may have any value, so
                             // calculations must be done in longs

    /**
     * The number of decimal digits in this BigDecimal, or 0 if the number of digits are not known
     * (lookaside information). If nonzero, the value is guaranteed correct. Use the precision()
     * method to obtain and set the value if it might be 0. This field is mutable until set nonzero.
     *
     * @since 1.5
     */
    private transient int precision;

    /**
     * If the absolute value of the significand of this BigDecimal is less than or equal to
     * {@code Long.MAX_VALUE}, the value can be compactly stored in this field and used in
     * computations.
     */
    private final transient long intCompact;

    /**
     * Used to store the canonical string representation, if computed.
     */
    private transient String stringCache;

    /**
     * Translates the string representation of a {@code BigDecimal} into a {@code BigDecimal}. The
     * string representation consists of an optional sign, {@code '+'} (<tt> '&#92;u002B'</tt>) or
     * {@code '-'} (<tt>'&#92;u002D'</tt>), followed by a sequence of zero or more decimal digits
     * ("the integer"), optionally followed by a fraction, optionally followed by an exponent.
     * <p>
     * The fraction consists of a decimal point followed by zero or more decimal digits. The string
     * must contain at least one digit in either the integer or the fraction. The number formed by
     * the sign, the integer and the fraction is referred to as the <i>significand</i>.
     * <p>
     * The exponent consists of the character {@code 'e'} (<tt>'&#92;u0065'</tt>) or {@code 'E'} (
     * <tt>'&#92;u0045'</tt>) followed by one or more decimal digits. The value of the exponent must
     * lie between -{@link Integer#MAX_VALUE} ({@link Integer#MIN_VALUE}+1) and
     * {@link Integer#MAX_VALUE}, inclusive.
     * <p>
     * More formally, the strings this constructor accepts are described by the following grammar:
     * <blockquote>
     * <dl>
     * <dt><i>BigDecimalString:</i>
     * <dd><i>Sign<sub>opt</sub> Significand Exponent<sub>opt</sub></i>
     * <dt><i>Sign:</i>
     * <dd>{@code +}
     * <dd>{@code -}
     * <dt><i>Significand:</i>
     * <dd><i>IntegerPart</i> {@code .} <i>FractionPart<sub>opt</sub></i>
     * <dd>{@code .} <i>FractionPart</i>
     * <dd><i>IntegerPart</i>
     * <dt><i>IntegerPart:</i>
     * <dd><i>Digits</i>
     * <dt><i>FractionPart:</i>
     * <dd><i>Digits</i>
     * <dt><i>Exponent:</i>
     * <dd><i>ExponentIndicator SignedInteger</i>
     * <dt><i>ExponentIndicator:</i>
     * <dd>{@code e}
     * <dd>{@code E}
     * <dt><i>SignedInteger:</i>
     * <dd><i>Sign<sub>opt</sub> Digits</i>
     * <dt><i>Digits:</i>
     * <dd><i>Digit</i>
     * <dd><i>Digits Digit</i>
     * <dt><i>Digit:</i>
     * <dd>any character for which {@link Character#isDigit} returns {@code true}, including 0, 1, 2
     * ...
     * </dl>
     * </blockquote>
     * <p>
     * The scale of the returned {@code BigDecimal} will be the number of digits in the fraction, or
     * zero if the string contains no decimal point, subject to adjustment for any exponent; if the
     * string contains an exponent, the exponent is subtracted from the scale. The value of the
     * resulting scale must lie between {@code Integer.MIN_VALUE} and {@code Integer.MAX_VALUE},
     * inclusive.
     * <p>
     * The character-to-digit mapping is provided by {@link java.lang.Character#digit} set to
     * convert to radix 10. The String may not contain any extraneous characters (whitespace, for
     * example).
     * <p>
     * <b>Examples:</b><br>
     * The value of the returned {@code BigDecimal} is equal to <i>significand</i> &times;
     * 10<sup>&nbsp;<i>exponent</i></sup>. For each string on the left, the resulting representation
     * [{@code BigInteger}, {@code scale}] is shown on the right.
     * 
     * <pre>
     * "0"            [0,0]
     * "0.00"         [0,2]
     * "123"          [123,0]
     * "-123"         [-123,0]
     * "1.23E3"       [123,-1]
     * "1.23E+3"      [123,-1]
     * "12.3E+7"      [123,-6]
     * "12.0"         [120,1]
     * "12.3"         [123,1]
     * "0.00123"      [123,5]
     * "-1.23E-12"    [-123,14]
     * "1234.5E-4"    [12345,5]
     * "0E+7"         [0,-7]
     * "-0"           [0,0]
     * </pre>
     * <p>
     * Note: For values other than {@code float} and {@code double} NaN and &plusmn;Infinity, this
     * constructor is compatible with the values returned by {@link Float#toString} and
     * {@link Double#toString}. This is generally the preferred way to convert a {@code float} or
     * {@code double} into a BigDecimal, as it doesn't suffer from the unpredictability of the
     * {@link #BigDecimal(double)} constructor.
     *
     * @param val String representation of {@code BigDecimal}.
     * @throws NumberFormatException if {@code val} is not a valid representation of a
     *             {@code BigDecimal}.
     */
    public JSBigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
    }

    /**
     * Translates a character array representation of a {@code BigDecimal} into a {@code BigDecimal}
     * , accepting the same sequence of characters as the {@link #BigDecimal(String)} constructor,
     * while allowing a sub-array to be specified.
     * <p>
     * Note that if the sequence of characters is already available within a character array, using
     * this constructor is faster than converting the {@code char} array to string and using the
     * {@code BigDecimal(String)} constructor .
     *
     * @param in {@code char} array that is the source of characters.
     * @param offset first character in the array to inspect.
     * @param len number of characters to consider.
     * @throws NumberFormatException if {@code in} is not a valid representation of a
     *             {@code BigDecimal} or the defined subarray is not wholly within {@code in}.
     * @since 1.5
     */
    public JSBigDecimal(char[] in, int offset, int len) {
        this(in, offset, len, MathContext.UNLIMITED);
    }

    /**
     * Translates a character array representation of a {@code BigDecimal} into a {@code BigDecimal}
     * , accepting the same sequence of characters as the {@link #BigDecimal(String)} constructor,
     * while allowing a sub-array to be specified and with rounding according to the context
     * settings.
     * <p>
     * Note that if the sequence of characters is already available within a character array, using
     * this constructor is faster than converting the {@code char} array to string and using the
     * {@code BigDecimal(String)} constructor .
     *
     * @param in {@code char} array that is the source of characters.
     * @param offset first character in the array to inspect.
     * @param len number of characters to consider..
     * @param mc the context to use.
     * @throws ArithmeticException if the result is inexact but the rounding mode is
     *             {@code UNNECESSARY}.
     * @throws NumberFormatException if {@code in} is not a valid representation of a
     *             {@code BigDecimal} or the defined subarray is not wholly within {@code in}.
     * @since 1.5
     */
    public JSBigDecimal(char[] in, int offset, int len, MathContext mc) {
        // protect against huge length.
        if (offset + len > in.length || offset < 0) {
            throw new NumberFormatException("Bad offset or len arguments for char[] input.");
        }

        // This is the primary string to BigDecimal constructor; all
        // incoming strings end up here; it uses explicit (inline)
        // parsing for speed and generates at most one intermediate
        // (temporary) object (a char[] array) for non-compact case.

        // Use locals for all fields values until completion
        int prec = 0; // record precision value
        int scl = 0; // record scale value
        long rs = 0; // the compact value in long
        BigInteger rb = null; // the inflated value in BigInteger
        // use array bounds checking to handle too-long, len == 0,
        // bad offset, etc.
        try {
            // handle the sign
            boolean isneg = false; // assume positive
            if (in[offset] == '-') {
                isneg = true; // leading minus means negative
                offset++;
                len--;
            } else if (in[offset] == '+') { // leading + allowed
                offset++;
                len--;
            }

            // should now be at numeric part of the significand
            boolean dot = false; // true when there is a '.'
            long exp = 0; // exponent
            char c; // current character
            boolean isCompact = (len <= MAX_COMPACT_DIGITS);
            // integer significand array & idx is the index to it. The array
            // is ONLY used when we can't use a compact representation.
            int idx = 0;
            if (isCompact) {
                // First compact case, we need not to preserve the character
                // and we can just compute the value in place.
                for (; len > 0; offset++, len--) {
                    c = in[offset];
                    if ((c == '0')) { // have zero
                        if (prec == 0) {
                            prec = 1;
                        } else if (rs != 0) {
                            rs *= 10;
                            ++prec;
                        } // else digit is a redundant leading zero
                        if (dot) {
                            ++scl;
                        }
                    } else if ((c >= '1' && c <= '9')) { // have digit
                        int digit = c - '0';
                        if (prec != 1 || rs != 0) {
                            ++prec; // prec unchanged if preceded by 0s
                        }
                        rs = rs * 10 + digit;
                        if (dot) {
                            ++scl;
                        }
                    } else if (c == '.') { // have dot
                        // have dot
                        if (dot) {
                            // two dots
                            throw new NumberFormatException();
                        }
                        dot = true;
                    } else if (Character.isDigit(c)) { // slow path
                        int digit = Character.digit(c, 10);
                        if (digit == 0) {
                            if (prec == 0) {
                                prec = 1;
                            } else if (rs != 0) {
                                rs *= 10;
                                ++prec;
                            } // else digit is a redundant leading zero
                        } else {
                            if (prec != 1 || rs != 0) {
                                ++prec; // prec unchanged if preceded by 0s
                            }
                            rs = rs * 10 + digit;
                        }
                        if (dot) {
                            ++scl;
                        }
                    } else if ((c == 'e') || (c == 'E')) {
                        exp = parseExp(in, offset, len);
                        // Next test is required for backwards compatibility
                        if ((int) exp != exp) {
                            // overflow
                            throw new NumberFormatException();
                        }
                        break; // [saves a test]
                    } else {
                        throw new NumberFormatException();
                    }
                }
                if (prec == 0) {
                    // no digits found
                    throw new NumberFormatException();
                }
                // Adjust scale if exp is not zero.
                if (exp != 0) { // had significant exponent
                    scl = adjustScale(scl, exp);
                }
                rs = isneg ? -rs : rs;
                int mcp = mc.getPrecision();
                int drop = prec - mcp; // prec has range [1, MAX_INT], mcp has range [0, MAX_INT];
                                       // therefore, this subtract cannot overflow
                if (mcp > 0 && drop > 0) { // do rounding
                    while (drop > 0) {
                        scl = checkScaleNonZero((long) scl - drop);
                        rs = divideAndRound(rs, LONG_TEN_POWERS_TABLE[drop], mc.getRoundingMode());
                        prec = longDigitLength(rs);
                        drop = prec - mcp;
                    }
                }
            } else {
                char coeff[] = new char[len];
                for (; len > 0; offset++, len--) {
                    c = in[offset];
                    // have digit
                    if ((c >= '0' && c <= '9') || Character.isDigit(c)) {
                        // First compact case, we need not to preserve the character
                        // and we can just compute the value in place.
                        if (c == '0' || Character.digit(c, 10) == 0) {
                            if (prec == 0) {
                                coeff[idx] = c;
                                prec = 1;
                            } else if (idx != 0) {
                                coeff[idx++] = c;
                                ++prec;
                            } // else c must be a redundant leading zero
                        } else {
                            if (prec != 1 || idx != 0) ++prec; // prec unchanged if preceded by 0s
                            coeff[idx++] = c;
                        }
                        if (dot) {
                            ++scl;
                        }
                        continue;
                    }
                    // have dot
                    if (c == '.') {
                        // have dot
                        if (dot) {
                            throw new NumberFormatException();
                        }
                        dot = true;
                        continue;
                    }
                    // exponent expected
                    if ((c != 'e') && (c != 'E')) {
                        throw new NumberFormatException();
                    }
                    exp = parseExp(in, offset, len);
                    // Next test is required for backwards compatibility
                    if ((int) exp != exp) {
                        throw new NumberFormatException();
                    }
                    break; // [saves a test]
                }
                // here when no characters left
                if (prec == 0) {
                    throw new NumberFormatException();
                }
                // Adjust scale if exp is not zero.
                if (exp != 0) { // had significant exponent
                    scl = adjustScale(scl, exp);
                }
                // Remove leading zeros from precision (digits count)
                rb = $(new JSBigInteger(coeff, isneg ? -1 : 1, prec));
                rs = compactValFor(rb);
                int mcp = mc.getPrecision();
                if (mcp > 0 && (prec > mcp)) {
                    if (rs == INFLATED) {
                        int drop = prec - mcp;
                        while (drop > 0) {
                            scl = checkScaleNonZero((long) scl - drop);
                            rb = divideAndRoundByTenPow(rb, drop, mc.getRoundingMode());
                            rs = compactValFor(rb);
                            if (rs != INFLATED) {
                                prec = longDigitLength(rs);
                                break;
                            }
                            prec = bigDigitLength(rb);
                            drop = prec - mcp;
                        }
                    }
                    if (rs != INFLATED) {
                        int drop = prec - mcp;
                        while (drop > 0) {
                            scl = checkScaleNonZero((long) scl - drop);
                            rs = divideAndRound(rs, LONG_TEN_POWERS_TABLE[drop], mc.getRoundingMode());
                            prec = longDigitLength(rs);
                            drop = prec - mcp;
                        }
                        rb = null;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NumberFormatException();
        } catch (NegativeArraySizeException e) {
            throw new NumberFormatException();
        }

        this.scale = scl;
        this.precision = prec;
        this.intCompact = rs;
        this.intVal = rb;
        System.out.println(scale + "   " + precision + "    " + intCompact + "    " + intVal);
    }

    /**
     * Trusted package private constructor. Trusted simply means if val is INFLATED, intVal could
     * not be null and if intVal is null, val could not be INFLATED.
     */
    JSBigDecimal(BigInteger intVal, long val, int scale, int prec) {
        this.scale = scale;
        this.precision = prec;
        this.intCompact = val;
        this.intVal = intVal;
    }

    /**
     * Returns the string representation of this {@code BigDecimal}, using scientific notation if an
     * exponent is needed.
     * <p>
     * A standard canonical string form of the {@code BigDecimal} is created as though by the
     * following steps: first, the absolute value of the unscaled value of the {@code BigDecimal} is
     * converted to a string in base ten using the characters {@code '0'} through {@code '9'} with
     * no leading zeros (except if its value is zero, in which case a single {@code '0'} character
     * is used).
     * <p>
     * Next, an <i>adjusted exponent</i> is calculated; this is the negated scale, plus the number
     * of characters in the converted unscaled value, less one. That is, {@code -scale+(ulength-1)},
     * where {@code ulength} is the length of the absolute value of the unscaled value in decimal
     * digits (its <i>precision</i>).
     * <p>
     * If the scale is greater than or equal to zero and the adjusted exponent is greater than or
     * equal to {@code -6}, the number will be converted to a character form without using
     * exponential notation. In this case, if the scale is zero then no decimal point is added and
     * if the scale is positive a decimal point will be inserted with the scale specifying the
     * number of characters to the right of the decimal point. {@code '0'} characters are added to
     * the left of the converted unscaled value as necessary. If no character precedes the decimal
     * point after this insertion then a conventional {@code '0'} character is prefixed.
     * <p>
     * Otherwise (that is, if the scale is negative, or the adjusted exponent is less than
     * {@code -6}), the number will be converted to a character form using exponential notation. In
     * this case, if the converted {@code BigInteger} has more than one digit a decimal point is
     * inserted after the first digit. An exponent in character form is then suffixed to the
     * converted unscaled value (perhaps with inserted decimal point); this comprises the letter
     * {@code 'E'} followed immediately by the adjusted exponent converted to a character form. The
     * latter is in base ten, using the characters {@code '0'} through {@code '9'} with no leading
     * zeros, and is always prefixed by a sign character {@code '-'} (<tt>'&#92;u002D'</tt>) if the
     * adjusted exponent is negative, {@code '+'} (<tt>'&#92;u002B'</tt>) otherwise).
     * <p>
     * Finally, the entire string is prefixed by a minus sign character {@code '-'} (
     * <tt>'&#92;u002D'</tt>) if the unscaled value is less than zero. No sign character is prefixed
     * if the unscaled value is zero or positive.
     * <p>
     * <b>Examples:</b>
     * <p>
     * For each representation [<i>unscaled value</i>, <i>scale</i>] on the left, the resulting
     * string is shown on the right.
     * 
     * <pre>
     * [123,0]      "123"
     * [-123,0]     "-123"
     * [123,-1]     "1.23E+3"
     * [123,-3]     "1.23E+5"
     * [123,1]      "12.3"
     * [123,5]      "0.00123"
     * [123,10]     "1.23E-8"
     * [-123,12]    "-1.23E-10"
     * </pre>
     * <b>Notes:</b>
     * <ol>
     * <li>There is a one-to-one mapping between the distinguishable {@code BigDecimal} values and
     * the result of this conversion. That is, every distinguishable {@code BigDecimal} value
     * (unscaled value and scale) has a unique string representation as a result of using
     * {@code toString}. If that string representation is converted back to a {@code BigDecimal}
     * using the {@link #BigDecimal(String)} constructor, then the original value will be recovered.
     * <li>The string produced for a given number is always the same; it is not affected by locale.
     * This means that it can be used as a canonical string representation for exchanging decimal
     * data, or as a key for a Hashtable, etc. Locale-sensitive number formatting and parsing is
     * handled by the {@link java.text.NumberFormat} class and its subclasses.
     * <li>The {@link #toEngineeringString} method may be used for presenting numbers with exponents
     * in engineering notation, and the {@link #setScale(int,RoundingMode) setScale} method may be
     * used for rounding a {@code BigDecimal} so it has a known number of digits after the decimal
     * point.
     * <li>The digit-to-character mapping provided by {@code Character.forDigit} is used.
     * </ol>
     *
     * @return string representation of this {@code BigDecimal}.
     * @see Character#forDigit
     * @see #BigDecimal(java.lang.String)
     */
    @Override
    public String toString() {
        String sc = stringCache;
        if (sc == null) stringCache = sc = layoutChars(true);
        return sc;
    }

    /**
     * Lay out this {@code BigDecimal} into a {@code char[]} array. The Java 1.2 equivalent to this
     * was called {@code getValueString}.
     *
     * @param sci {@code true} for Scientific exponential notation; {@code false} for Engineering
     * @return string with canonical string representation of this {@code BigDecimal}
     */
    private String layoutChars(boolean sci) {
        if (scale == 0) {
            return (intCompact != INFLATED) ? Long.toString(intCompact) : intVal.toString();
        }
        if (scale == 2 && intCompact >= 0 && intCompact < Integer.MAX_VALUE) {
            // currency fast path
            int lowInt = (int) intCompact % 100;
            int highInt = (int) intCompact / 100;
            return (Integer.toString(highInt) + '.' + StringBuilderHelper.DIGIT_TENS[lowInt] + StringBuilderHelper.DIGIT_ONES[lowInt]);
        }

        StringBuilderHelper sbHelper = threadLocalStringBuilderHelper;
        char[] coeff;
        int offset; // offset is the starting index for coeff array
        // Get the significand as an absolute value
        if (intCompact != INFLATED) {
            offset = sbHelper.putIntCompact(Math.abs(intCompact));
            coeff = sbHelper.getCompactCharArray();
        } else {
            offset = 0;
            coeff = intVal.abs().toString().toCharArray();
        }

        // Construct a buffer, with sufficient capacity for all cases.
        // If E-notation is needed, length will be: +1 if negative, +1
        // if '.' needed, +2 for "E+", + up to 10 for adjusted exponent.
        // Otherwise it could have +1 if negative, plus leading "0.00000"
        StringBuilder buf = sbHelper.getStringBuilder();
        if (signum() < 0) {
            // prefix '-' if negative
            buf.append('-');
        }

        int coeffLen = coeff.length - offset;
        long adjusted = -(long) scale + (coeffLen - 1);
        if ((scale >= 0) && (adjusted >= -6)) { // plain number
            int pad = scale - coeffLen; // count of padding zeros
            if (pad >= 0) { // 0.xxx form
                buf.append('0');
                buf.append('.');
                for (; pad > 0; pad--) {
                    buf.append('0');
                }
                buf.append(coeff, offset, coeffLen);
            } else { // xx.xx form
                buf.append(coeff, offset, -pad);
                buf.append('.');
                buf.append(coeff, -pad + offset, scale);
            }
        } else { // E-notation is needed
            if (sci) { // Scientific notation
                buf.append(coeff[offset]); // first character
                if (coeffLen > 1) { // more to come
                    buf.append('.');
                    buf.append(coeff, offset + 1, coeffLen - 1);
                }
            } else { // Engineering notation
                int sig = (int) (adjusted % 3);
                if (sig < 0) {
                    sig += 3; // [adjusted was negative]
                }
                adjusted -= sig; // now a multiple of 3
                sig++;
                if (signum() == 0) {
                    switch (sig) {
                    case 1:
                        buf.append('0'); // exponent is a multiple of three
                        break;
                    case 2:
                        buf.append("0.00");
                        adjusted += 3;
                        break;
                    case 3:
                        buf.append("0.0");
                        adjusted += 3;
                        break;
                    default:
                        throw new AssertionError("Unexpected sig value " + sig);
                    }
                } else if (sig >= coeffLen) { // significand all in integer
                    buf.append(coeff, offset, coeffLen);
                    // may need some zeros, too
                    for (int i = sig - coeffLen; i > 0; i--) {
                        buf.append('0');
                    }
                } else { // xx.xxE form
                    buf.append(coeff, offset, sig);
                    buf.append('.');
                    buf.append(coeff, offset + sig, coeffLen - sig);
                }
            }
            if (adjusted != 0) { // [!sci could have made 0]
                buf.append('E');
                if (adjusted > 0) {
                    buf.append('+');
                }
                buf.append(adjusted);
            }
        }
        return buf.toString();
    }

    /**
     * Returns the <i>precision</i> of this {@code BigDecimal}. (The precision is the number of
     * digits in the unscaled value.)
     * <p>
     * The precision of a zero value is 1.
     *
     * @return the precision of this {@code BigDecimal}.
     * @since 1.5
     */
    public int precision() {
        int result = precision;
        if (result == 0) {
            long s = intCompact;
            if (s != INFLATED)
                result = longDigitLength(s);
            else
                result = bigDigitLength(intVal);
            precision = result;
        }
        return result;
    }

    /**
     * Returns the signum function of this {@code BigDecimal}.
     *
     * @return -1, 0, or 1 as the value of this {@code BigDecimal} is negative, zero, or positive.
     */
    public int signum() {
        return (intCompact != INFLATED) ? Long.signum(intCompact) : intVal.signum();
    }

    /**
     * Converts this {@code BigDecimal} to an {@code int}. This conversion is analogous to the
     * <i>narrowing primitive conversion</i> from {@code double} to {@code short} as defined in
     * section 5.1.3 of <cite>The Java&trade; Language Specification</cite>: any fractional part of
     * this {@code BigDecimal} will be discarded, and if the resulting "{@code BigInteger}" is too
     * big to fit in an {@code int}, only the low-order 32 bits are returned. Note that this
     * conversion can lose information about the overall magnitude and precision of this
     * {@code BigDecimal} value as well as return a result with the opposite sign.
     *
     * @return this {@code BigDecimal} converted to an {@code int}.
     */
    public int intValue() {
        return (intCompact != INFLATED && scale == 0) ? (int) intCompact : toBigInteger().intValue();
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
        // force to an integer, quietly
        return $(setScale(0, RoundingMode.DOWN)).inflated();
    }

    /**
     * Returns a {@code BigDecimal} whose scale is the specified value, and whose unscaled value is
     * determined by multiplying or dividing this {@code BigDecimal}'s unscaled value by the
     * appropriate power of ten to maintain its overall value. If the scale is reduced by the
     * operation, the unscaled value must be divided (rather than multiplied), and the value may be
     * changed; in this case, the specified rounding mode is applied to the division.
     * <p>
     * Note that since BigDecimal objects are immutable, calls of this method do <i>not</i> result
     * in the original object being modified, contrary to the usual convention of having methods
     * named <tt>set<i>X</i></tt> mutate field <i>{@code X}</i>. Instead, {@code setScale} returns
     * an object with the proper scale; the returned object may or may not be newly allocated.
     *
     * @param newScale scale of the {@code BigDecimal} value to be returned.
     * @param roundingMode The rounding mode to apply.
     * @return a {@code BigDecimal} whose scale is the specified value, and whose unscaled value is
     *         determined by multiplying or dividing this {@code BigDecimal}'s unscaled value by the
     *         appropriate power of ten to maintain its overall value.
     * @throws ArithmeticException if {@code roundingMode==UNNECESSARY} and the specified scaling
     *             operation would require rounding.
     * @see RoundingMode
     * @since 1.5
     */
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        if (roundingMode.ordinal() < RoundingMode.UP.ordinal() || roundingMode.ordinal() > RoundingMode.UNNECESSARY.ordinal()) {
            throw new IllegalArgumentException("Invalid rounding mode");
        }

        int oldScale = this.scale;
        if (newScale == oldScale) {
            return $(this);
        }
        if (this.signum() == 0) {
            return zeroValueOf(newScale);
        }
        if (this.intCompact != INFLATED) {
            long rs = this.intCompact;
            if (newScale > oldScale) {
                int raise = checkScale((long) newScale - oldScale);
                if ((rs = longMultiplyPowerTen(rs, raise)) != INFLATED) {
                    return valueOf(rs, newScale);
                }
                BigInteger rb = bigMultiplyPowerTen(raise);
                return $(new JSBigDecimal(rb, INFLATED, newScale, (precision > 0) ? precision + raise : 0));
            } else {
                // newScale < oldScale -- drop some digits
                // Can't predict the precision due to the effect of rounding.
                int drop = checkScale((long) oldScale - newScale);
                if (drop < LONG_TEN_POWERS_TABLE.length) {
                    return divideAndRound(rs, LONG_TEN_POWERS_TABLE[drop], newScale, roundingMode, newScale);
                } else {
                    return divideAndRound(inflated(), bigTenToThe(drop), newScale, roundingMode, newScale);
                }
            }
        } else {
            if (newScale > oldScale) {
                int raise = checkScale((long) newScale - oldScale);
                BigInteger rb = bigMultiplyPowerTen(this.intVal, raise);
                return $(new JSBigDecimal(rb, INFLATED, newScale, (precision > 0) ? precision + raise : 0));
            } else {
                // newScale < oldScale -- drop some digits
                // Can't predict the precision due to the effect of rounding.
                int drop = checkScale((long) oldScale - newScale);
                if (drop < LONG_TEN_POWERS_TABLE.length)
                    return divideAndRound(intVal, LONG_TEN_POWERS_TABLE[drop], newScale, roundingMode, newScale);
                else
                    return divideAndRound(intVal, bigTenToThe(drop), newScale, roundingMode, newScale);
            }
        }
    }

    /**
     * Returns a {@code BigDecimal} whose scale is the specified value, and whose value is
     * numerically equal to this {@code BigDecimal}'s. Throws an {@code ArithmeticException} if this
     * is not possible.
     * <p>
     * This call is typically used to increase the scale, in which case it is guaranteed that there
     * exists a {@code BigDecimal} of the specified scale and the correct value. The call can also
     * be used to reduce the scale if the caller knows that the {@code BigDecimal} has sufficiently
     * many zeros at the end of its fractional part (i.e., factors of ten in its integer value) to
     * allow for the rescaling without changing its value.
     * <p>
     * This method returns the same result as the two-argument versions of {@code setScale}, but
     * saves the caller the trouble of specifying a rounding mode in cases where it is irrelevant.
     * <p>
     * Note that since {@code BigDecimal} objects are immutable, calls of this method do <i>not</i>
     * result in the original object being modified, contrary to the usual convention of having
     * methods named <tt>set<i>X</i></tt> mutate field <i>{@code X}</i>. Instead, {@code setScale}
     * returns an object with the proper scale; the returned object may or may not be newly
     * allocated.
     *
     * @param newScale scale of the {@code BigDecimal} value to be returned.
     * @return a {@code BigDecimal} whose scale is the specified value, and whose unscaled value is
     *         determined by multiplying or dividing this {@code BigDecimal}'s unscaled value by the
     *         appropriate power of ten to maintain its overall value.
     * @throws ArithmeticException if the specified scaling operation would require rounding.
     * @see #setScale(int, int)
     * @see #setScale(int, RoundingMode)
     */
    public BigDecimal setScale(int newScale) {
        return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    /**
     * Converts this {@code BigDecimal} to an {@code int}, checking for lost information. If this
     * {@code BigDecimal} has a nonzero fractional part or is out of the possible range for an
     * {@code int} result then an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} converted to an {@code int}.
     * @throws ArithmeticException if {@code this} has a nonzero fractional part, or will not fit in
     *             an {@code int}.
     * @since 1.5
     */
    public int intValueExact() {
        long num;
        num = this.longValueExact(); // will check decimal part
        if ((int) num != num) {
            throw new java.lang.ArithmeticException("Overflow");
        }
        return (int) num;
    }

    /**
     * Converts this {@code BigDecimal} to a {@code long}. This conversion is analogous to the
     * <i>narrowing primitive conversion</i> from {@code double} to {@code short} as defined in
     * section 5.1.3 of <cite>The Java&trade; Language Specification</cite>: any fractional part of
     * this {@code BigDecimal} will be discarded, and if the resulting "{@code BigInteger}" is too
     * big to fit in a {@code long}, only the low-order 64 bits are returned. Note that this
     * conversion can lose information about the overall magnitude and precision of this
     * {@code BigDecimal} value as well as return a result with the opposite sign.
     *
     * @return this {@code BigDecimal} converted to a {@code long}.
     */
    public long longValue() {
        return (intCompact != INFLATED && scale == 0) ? intCompact : toBigInteger().longValue();
    }

    /**
     * Converts this {@code BigDecimal} to a {@code long}, checking for lost information. If this
     * {@code BigDecimal} has a nonzero fractional part or is out of the possible range for a
     * {@code long} result then an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} converted to a {@code long}.
     * @throws ArithmeticException if {@code this} has a nonzero fractional part, or will not fit in
     *             a {@code long}.
     * @since 1.5
     */
    public long longValueExact() {
        if (intCompact != INFLATED && scale == 0) {
            return intCompact;
        }
        // If more than 19 digits in integer part it cannot possibly fit
        if ((precision() - scale) > 19) {
            // [OK for negative scale too]
            throw new java.lang.ArithmeticException("Overflow");
        }
        // Fastpath zero and < 1.0 numbers (the latter can be very slow
        // to round if very small)
        if (this.signum() == 0) {
            return 0;
        }
        if ((this.precision() - this.scale) <= 0) {
            throw new ArithmeticException("Rounding necessary");
        }
        // round to an integer, with Exception if decimal part non-0
        BigDecimal num = setScale(0, RoundingMode.UNNECESSARY);
        if (num.precision() >= 19) {
            LongOverflow.check(num);
        }
        return $(num).inflated().longValue();
    }

    private int adjustScale(int scl, long exp) {
        long adjustedScale = scl - exp;
        if (adjustedScale > Integer.MAX_VALUE || adjustedScale < Integer.MIN_VALUE) {
            throw new NumberFormatException("Scale out of range.");
        }
        scl = (int) adjustedScale;
        return scl;
    }

    /**
     * Check a scale for Underflow or Overflow. If this BigDecimal is nonzero, throw an exception if
     * the scale is outof range. If this is zero, saturate the scale to the extreme value of the
     * right sign if the scale is out of range.
     *
     * @param val The new scale.
     * @throws ArithmeticException (overflow or underflow) if the new scale is out of range.
     * @return validated scale as an int.
     */
    private int checkScale(long val) {
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            BigInteger b;
            if (intCompact != 0 && ((b = intVal) == null || b.signum() != 0)) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    /**
     * Compute this * 10 ^ n. Needed mainly to allow special casing to trap zero value
     */
    private BigInteger bigMultiplyPowerTen(int n) {
        if (n <= 0) {
            return inflated();
        }

        if (intCompact != INFLATED) {
            return $(bigTenToThe(n)).multiply(intCompact);
        } else {
            return intVal.multiply(bigTenToThe(n));
        }
    }

    /**
     * Returns appropriate BigInteger from intVal field if intVal is null, i.e. the compact
     * representation is in use.
     */
    private BigInteger inflated() {
        if (intVal == null) {
            return BigInteger.valueOf(intCompact);
        }
        return intVal;
    }

    private static BigInteger bigMultiplyPowerTen(BigInteger value, int n) {
        if (n <= 0) return value;
        if (n < LONG_TEN_POWERS_TABLE.length) {
            return $(value).multiply(LONG_TEN_POWERS_TABLE[n]);
        }
        return value.multiply(bigTenToThe(n));
    }

    private static BigInteger bigMultiplyPowerTen(long value, int n) {
        if (n <= 0) {
            return BigInteger.valueOf(value);
        }
        return $(bigTenToThe(n)).multiply(value);
    }

    /**
     * Compute val * 10 ^ n; return this product if it is representable as a long, INFLATED
     * otherwise.
     */
    private static long longMultiplyPowerTen(long val, int n) {
        if (val == 0 || n <= 0) return val;
        long[] tab = LONG_TEN_POWERS_TABLE;
        long[] bounds = THRESHOLDS_TABLE;
        if (n < tab.length && n < bounds.length) {
            long tenpower = tab[n];
            if (val == 1) {
                return tenpower;
            }
            if (Math.abs(val) <= bounds[n]) {
                return val * tenpower;
            }
        }
        return INFLATED;
    }

    /**
     * Returns the length of the absolute value of a BigInteger, in decimal digits.
     *
     * @param b the BigInteger
     * @return the length of the unscaled value, in decimal digits
     */
    private static int bigDigitLength(BigInteger b) {
        /*
         * Same idea as the long version, but we need a better approximation of log10(2). Using
         * 646456993/2^31 is accurate up to max possible reported bitLength.
         */
        if ($(b).signum == 0) {
            return 1;
        }
        int r = (int) ((((long) b.bitLength() + 1) * 646456993) >>> 31);
        return $(b).compareMagnitude(bigTenToThe(r)) < 0 ? r : r + 1;
    }

    /*
     * parse exponent
     */
    private static long parseExp(char[] in, int offset, int len) {
        long exp = 0;
        offset++;
        char c = in[offset];
        len--;
        boolean negexp = (c == '-');
        // optional sign
        if (negexp || c == '+') {
            offset++;
            c = in[offset];
            len--;
        }
        if (len <= 0) {
            // no exponent digits
            throw new NumberFormatException();
        }

        // skip leading zeros in the exponent
        while (len > 10 && (c == '0' || (Character.digit(c, 10) == 0))) {
            offset++;
            c = in[offset];
            len--;
        }
        if (len > 10) {
            // too many nonzero exponent digits
            throw new NumberFormatException();
        }
        // c now holds first digit of exponent
        for (;; len--) {
            int v;
            if (c >= '0' && c <= '9') {
                v = c - '0';
            } else {
                v = Character.digit(c, 10);
                if (v < 0) {
                    // not a digit
                    throw new NumberFormatException();
                }
            }
            exp = exp * 10 + v;
            if (len == 1) {
                break; // that was final character
            }
            offset++;
            c = in[offset];
        }
        if (negexp) {
            // apply sign
            exp = -exp;
        }
        return exp;
    }

    private static int checkScaleNonZero(long val) {
        int asInt = (int) val;
        if (asInt != val) {
            throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
        }
        return asInt;
    }

    /**
     * Divides {@code long} by {@code long} and do rounding based on the passed in roundingMode.
     */
    private static long divideAndRound(long ldividend, long ldivisor, RoundingMode roundingMode) {
        int qsign; // quotient sign
        long q = ldividend / ldivisor; // store quotient in long
        if (roundingMode == RoundingMode.DOWN) {
            return q;
        }
        long r = ldividend % ldivisor; // store remainder in long
        qsign = ((ldividend < 0) == (ldivisor < 0)) ? 1 : -1;
        if (r != 0) {
            boolean increment = needIncrement(ldivisor, roundingMode, qsign, q, r);
            return increment ? q + qsign : q;
        } else {
            return q;
        }
    }

    /**
     * Tests if quotient has to be incremented according the roundingMode
     */
    private static boolean needIncrement(long ldivisor, RoundingMode roundingMode, int qsign, long q, long r) {
        int cmpFracHalf;
        if (r <= HALF_LONG_MIN_VALUE || r > HALF_LONG_MAX_VALUE) {
            cmpFracHalf = 1; // 2 * r can't fit into long
        } else {
            cmpFracHalf = longCompareMagnitude(2 * r, ldivisor);
        }

        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, (q & 1L) != 0L);
    }

    private static int longCompareMagnitude(long x, long y) {
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    /**
     * Shared logic of need increment computation.
     */
    private static boolean commonNeedIncrement(RoundingMode roundingMode, int qsign, int cmpFracHalf, boolean oddQuot) {
        switch (roundingMode) {
        case UNNECESSARY:
            throw new ArithmeticException("Rounding necessary");

        case UP: // Away from zero
            return true;

        case DOWN: // Towards zero
            return false;

        case CEILING: // Towards +infinity
            return qsign > 0;

        case FLOOR: // Towards -infinity
            return qsign < 0;

        default: // Some kind of half-way rounding

            if (cmpFracHalf < 0) {
                // We're closer to higher digit
                return false;
            } else if (cmpFracHalf > 0) {
                return true;
            } else { // half-way
                assert cmpFracHalf == 0;

                switch (roundingMode) {
                case HALF_DOWN:
                    return false;

                case HALF_UP:
                    return true;

                case HALF_EVEN:
                    return oddQuot;

                default:
                    throw new AssertionError("Unexpected rounding mode" + roundingMode);
                }
            }
        }
    }

    /**
     * Returns the compact value for given {@code BigInteger}, or INFLATED if too big. Relies on
     * internal representation of {@code BigInteger}.
     */
    private static long compactValFor(BigInteger b) {
        int[] m = $(b).mag;
        int len = m.length;
        if (len == 0) {
            return 0;
        }
        int d = m[0];
        if (len > 2 || (len == 2 && d < 0)) {
            return INFLATED;
        }

        long u = (len == 2) ? ((m[1] & JSBigInteger.LONG_MASK) + (((long) d) << 32)) : ((d) & JSBigInteger.LONG_MASK);
        return ($(b).signum < 0) ? -u : u;
    }

    /*
     * Divides {@code BigInteger} value by ten power.
     */
    private static BigInteger divideAndRoundByTenPow(BigInteger intVal, int tenPow, RoundingMode roundingMode) {
        if (tenPow < LONG_TEN_POWERS_TABLE.length) {
            intVal = divideAndRound(intVal, LONG_TEN_POWERS_TABLE[tenPow], roundingMode);
        } else {
            intVal = divideAndRound(intVal, bigTenToThe(tenPow), roundingMode);
        }
        return intVal;
    }

    /**
     * Divides {@code BigInteger} value by {@code BigInteger} value and do rounding based on the
     * passed in roundingMode.
     */
    private static BigInteger divideAndRound(BigInteger bdividend, BigInteger bdivisor, RoundingMode roundingMode) {
        boolean isRemainderZero; // record remainder is zero or not
        int qsign; // quotient sign
        // Descend into mutables for faster remainder checks
        MutableBigInteger mdividend = new MutableBigInteger($(bdividend).mag);
        MutableBigInteger mq = new MutableBigInteger();
        MutableBigInteger mdivisor = new MutableBigInteger($(bdivisor).mag);
        MutableBigInteger mr = mdividend.divide(mdivisor, mq);
        isRemainderZero = mr.isZero();
        qsign = ($(bdividend).signum != $(bdivisor).signum) ? -1 : 1;
        if (!isRemainderZero) {
            if (needIncrement(mdivisor, roundingMode, qsign, mq, mr)) {
                mq.add(MutableBigInteger.ONE);
            }
        }
        return mq.toBigInteger(qsign);
    }

    /**
     * Tests if quotient has to be incremented according the roundingMode
     */
    private static boolean needIncrement(MutableBigInteger mdivisor, RoundingMode roundingMode, int qsign, MutableBigInteger mq, MutableBigInteger mr) {
        int cmpFracHalf = mr.compareHalf(mdivisor);
        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, mq.isOdd());
    }

    /**
     * Return 10 to the power n, as a {@code BigInteger}.
     *
     * @param n the power of ten to be returned (>=0)
     * @return a {@code BigInteger} with the value (10<sup>n</sup>)
     */
    private static BigInteger bigTenToThe(int n) {
        if (n < 0) return BigInteger.ZERO;

        if (n < BIG_TEN_POWERS_TABLE_MAX) {
            BigInteger[] pows = BIG_TEN_POWERS_TABLE;
            if (n < pows.length) {
                return pows[n];
            } else {
                return expandBigIntegerTenPowers(n);
            }
        }

        return BigInteger.TEN.pow(n);
    }

    /**
     * Expand the BIG_TEN_POWERS_TABLE array to contain at least 10**n.
     *
     * @param n the power of ten to be returned (>=0)
     * @return a {@code BigDecimal} with the value (10<sup>n</sup>) and in the meantime, the
     *         BIG_TEN_POWERS_TABLE array gets expanded to the size greater than n.
     */
    private static BigInteger expandBigIntegerTenPowers(int n) {
        BigInteger[] pows = BIG_TEN_POWERS_TABLE;
        int curLen = pows.length;
        // The following comparison and the above synchronized statement is
        // to prevent multiple threads from expanding the same array.
        if (curLen <= n) {
            int newLen = curLen << 1;
            while (newLen <= n) {
                newLen <<= 1;
            }
            pows = Arrays.copyOf(pows, newLen);
            for (int i = curLen; i < newLen; i++) {
                pows[i] = pows[i - 1].multiply(BigInteger.TEN);
            }
            // Based on the following facts:
            // 1. pows is a private local varible;
            // 2. the following store is a volatile store.
            // the newly created array elements can be safely published.
            BIG_TEN_POWERS_TABLE = pows;
        }
        return pows[n];
    }

    /**
     * Internally used for division operation for division {@code BigInteger} by {@code long}. The
     * returned {@code BigDecimal} object is the quotient whose scale is set to the passed in scale.
     * If the remainder is not zero, it will be rounded based on the passed in roundingMode. Also,
     * if the remainder is zero and the last parameter, i.e. preferredScale is NOT equal to scale,
     * the trailing zeros of the result is stripped to match the preferredScale.
     */
    private static BigDecimal divideAndRound(BigInteger bdividend, long ldivisor, int scale, RoundingMode roundingMode, int preferredScale) {
        boolean isRemainderZero; // record remainder is zero or not
        int qsign; // quotient sign
        long r = 0; // store quotient & remainder in long
        MutableBigInteger mq = null; // store quotient
        // Descend into mutables for faster remainder checks
        MutableBigInteger mdividend = new MutableBigInteger($(bdividend).mag);
        mq = new MutableBigInteger();
        r = mdividend.divide(ldivisor, mq);
        isRemainderZero = (r == 0);
        qsign = (ldivisor < 0) ? -$(bdividend).signum : $(bdividend).signum;
        if (!isRemainderZero) {
            if (needIncrement(ldivisor, roundingMode, qsign, mq, r)) {
                mq.add(MutableBigInteger.ONE);
            }
            return mq.toBigDecimal(qsign, scale);
        } else {
            if (preferredScale != scale) {
                long compactVal = mq.toCompactValue(qsign);
                if (compactVal != INFLATED) {
                    return createAndStripZerosToMatchScale(compactVal, scale, preferredScale);
                }
                BigInteger intVal = mq.toBigInteger(qsign);
                return createAndStripZerosToMatchScale(intVal, scale, preferredScale);
            } else {
                return mq.toBigDecimal(qsign, scale);
            }
        }
    }

    /**
     * Internally used for division operation for division {@code BigInteger} by {@code BigInteger}.
     * The returned {@code BigDecimal} object is the quotient whose scale is set to the passed in
     * scale. If the remainder is not zero, it will be rounded based on the passed in roundingMode.
     * Also, if the remainder is zero and the last parameter, i.e. preferredScale is NOT equal to
     * scale, the trailing zeros of the result is stripped to match the preferredScale.
     */
    private static BigDecimal divideAndRound(BigInteger bdividend, BigInteger bdivisor, int scale, RoundingMode roundingMode, int preferredScale) {
        boolean isRemainderZero; // record remainder is zero or not
        int qsign; // quotient sign
        // Descend into mutables for faster remainder checks
        MutableBigInteger mdividend = new MutableBigInteger($(bdividend).mag);
        MutableBigInteger mq = new MutableBigInteger();
        MutableBigInteger mdivisor = new MutableBigInteger($(bdivisor).mag);
        MutableBigInteger mr = mdividend.divide(mdivisor, mq);
        isRemainderZero = mr.isZero();
        qsign = ($(bdividend).signum != $(bdivisor).signum) ? -1 : 1;
        if (!isRemainderZero) {
            if (needIncrement(mdivisor, roundingMode, qsign, mq, mr)) {
                mq.add(MutableBigInteger.ONE);
            }
            return mq.toBigDecimal(qsign, scale);
        } else {
            if (preferredScale != scale) {
                long compactVal = mq.toCompactValue(qsign);
                if (compactVal != INFLATED) {
                    return createAndStripZerosToMatchScale(compactVal, scale, preferredScale);
                }
                BigInteger intVal = mq.toBigInteger(qsign);
                return createAndStripZerosToMatchScale(intVal, scale, preferredScale);
            } else {
                return mq.toBigDecimal(qsign, scale);
            }
        }
    }

    /**
     * Divides {@code BigInteger} value by {@code long} value and do rounding based on the passed in
     * roundingMode.
     */
    private static BigInteger divideAndRound(BigInteger bdividend, long ldivisor, RoundingMode roundingMode) {
        boolean isRemainderZero; // record remainder is zero or not
        int qsign; // quotient sign
        long r = 0; // store quotient & remainder in long
        MutableBigInteger mq = null; // store quotient
        // Descend into mutables for faster remainder checks
        MutableBigInteger mdividend = new MutableBigInteger($(bdividend).mag);
        mq = new MutableBigInteger();
        r = mdividend.divide(ldivisor, mq);
        isRemainderZero = (r == 0);
        qsign = (ldivisor < 0) ? -$(bdividend).signum : $(bdividend).signum;
        if (!isRemainderZero) {
            if (needIncrement(ldivisor, roundingMode, qsign, mq, r)) {
                mq.add(MutableBigInteger.ONE);
            }
        }
        return mq.toBigInteger(qsign);
    }

    /**
     * Tests if quotient has to be incremented according the roundingMode
     */
    private static boolean needIncrement(long ldivisor, RoundingMode roundingMode, int qsign, MutableBigInteger mq, long r) {
        assert r != 0L;

        int cmpFracHalf;
        if (r <= HALF_LONG_MIN_VALUE || r > HALF_LONG_MAX_VALUE) {
            cmpFracHalf = 1; // 2 * r can't fit into long
        } else {
            cmpFracHalf = longCompareMagnitude(2 * r, ldivisor);
        }

        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, mq.isOdd());
    }

    /**
     * Internally used for division operation for division {@code long} by {@code long}. The
     * returned {@code BigDecimal} object is the quotient whose scale is set to the passed in scale.
     * If the remainder is not zero, it will be rounded based on the passed in roundingMode. Also,
     * if the remainder is zero and the last parameter, i.e. preferredScale is NOT equal to scale,
     * the trailing zeros of the result is stripped to match the preferredScale.
     */
    private static BigDecimal divideAndRound(long ldividend, long ldivisor, int scale, RoundingMode roundingMode, int preferredScale) {
        int qsign; // quotient sign
        long q = ldividend / ldivisor; // store quotient in long
        if (roundingMode == DOWN && scale == preferredScale) {
            return valueOf(q, scale);
        }
        long r = ldividend % ldivisor; // store remainder in long
        qsign = ((ldividend < 0) == (ldivisor < 0)) ? 1 : -1;
        if (r != 0) {
            boolean increment = needIncrement(ldivisor, roundingMode, qsign, q, r);
            return valueOf((increment ? q + qsign : q), scale);
        } else {
            if (preferredScale != scale) {
                return createAndStripZerosToMatchScale(q, scale, preferredScale);
            } else {
                return valueOf(q, scale);
            }
        }
    }

    /**
     * Remove insignificant trailing zeros from this {@code BigInteger} value until the preferred
     * scale is reached or no more zeros can be removed. If the preferred scale is less than
     * Integer.MIN_VALUE, all the trailing zeros will be removed.
     *
     * @return new {@code BigDecimal} with a scale possibly reduced to be closed to the preferred
     *         scale.
     */
    private static BigDecimal createAndStripZerosToMatchScale(BigInteger intVal, int scale, long preferredScale) {
        BigInteger qr[]; // quotient-remainder pair
        while ($(intVal).compareMagnitude(BigInteger.TEN) >= 0 && scale > preferredScale) {
            if (intVal.testBit(0)) {
                break; // odd number cannot end in 0
            }
            qr = intVal.divideAndRemainder(BigInteger.TEN);
            if (qr[1].signum() != 0) {
                break; // non-0 remainder
            }
            intVal = qr[0];
            scale = checkScale(intVal, (long) scale - 1); // could Overflow
        }
        return valueOf(intVal, scale, 0);
    }

    /**
     * Remove insignificant trailing zeros from this {@code long} value until the preferred scale is
     * reached or no more zeros can be removed. If the preferred scale is less than
     * Integer.MIN_VALUE, all the trailing zeros will be removed.
     *
     * @return new {@code BigDecimal} with a scale possibly reduced to be closed to the preferred
     *         scale.
     */
    private static BigDecimal createAndStripZerosToMatchScale(long compactVal, int scale, long preferredScale) {
        while (Math.abs(compactVal) >= 10L && scale > preferredScale) {
            if ((compactVal & 1L) != 0L) {
                break; // odd number cannot end in 0
            }
            long r = compactVal % 10L;
            if (r != 0L) {
                break; // non-0 remainder
            }
            compactVal /= 10;
            scale = checkScale(compactVal, (long) scale - 1); // could Overflow
        }
        return valueOf(compactVal, scale);
    }

    private static int checkScale(long intCompact, long val) {
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (intCompact != 0) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    private static int checkScale(BigInteger intVal, long val) {
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (intVal.signum() != 0) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    /**
     * Returns the length of the absolute value of a {@code long}, in decimal digits.
     *
     * @param x the {@code long}
     * @return the length of the unscaled value, in deciaml digits.
     */
    static int longDigitLength(long x) {
        if (x < 0) {
            x = -x;
        }
        if (x < 10) {
            // must screen for 0, might as well 10
            return 1;
        }
        int r = ((64 - Long.numberOfLeadingZeros(x) + 1) * 1233) >>> 12;
        long[] tab = LONG_TEN_POWERS_TABLE;
        // if r >= length, must have max possible digits for long
        return (r >= tab.length || x < tab[r]) ? r : r + 1;
    }

    static BigDecimal valueOf(BigInteger intVal, int scale, int prec) {
        long val = compactValFor(intVal);
        if (val == 0) {
            return zeroValueOf(scale);
        } else if (scale == 0 && val >= 0 && val < zeroThroughTen.length) {
            return $(zeroThroughTen[(int) val]);
        }
        return $(new JSBigDecimal(intVal, val, scale, prec));
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
        // Reminder: a zero double returns '0.0', so we cannot fastpath
        // to use the constant ZERO. This might be important enough to
        // justify a factory approach, a cache, or a few private
        // constants, later.
        return new BigDecimal(Double.toString(val));
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
        if (val >= 0 && val < zeroThroughTen.length) {
            return $(zeroThroughTen[(int) val]);
        } else if (val != INFLATED) {
            return $(new JSBigDecimal(null, val, 0, 0));
        }
        return $(new JSBigDecimal(INFLATED_BIGINT, val, 0, 0));
    }

    /**
     * @param unscaledVal
     * @param scale
     * @param prec
     * @return
     */
    static BigDecimal valueOf(long unscaledVal, int scale, int prec) {
        if (scale == 0 && unscaledVal >= 0 && unscaledVal < zeroThroughTen.length) {
            return $(zeroThroughTen[(int) unscaledVal]);
        } else if (unscaledVal == 0) {
            return zeroValueOf(scale);
        }
        return $(new JSBigDecimal(unscaledVal == INFLATED ? INFLATED_BIGINT : null, unscaledVal, scale, prec));
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
        if (scale == 0)
            return valueOf(unscaledVal);
        else if (unscaledVal == 0) {
            return zeroValueOf(scale);
        }
        return $(new JSBigDecimal(unscaledVal == INFLATED ? INFLATED_BIGINT : null, unscaledVal, scale, 0));
    }

    /**
     * Helper
     * 
     * @param scale
     * @return
     */
    static BigDecimal zeroValueOf(int scale) {
        if (scale >= 0 && scale < ZERO_SCALED_BY.length)
            return $(ZERO_SCALED_BY[scale]);
        else
            return $(new JSBigDecimal(BigInteger.ZERO, 0, scale, 1));
    }

    // Private class to build a string representation for BigDecimal object.
    // "StringBuilderHelper" is constructed as a thread local variable so it is
    // thread safe. The StringBuilder field acts as a buffer to hold the temporary
    // representation of BigDecimal. The cmpCharArray holds all the characters for
    // the compact representation of BigDecimal (except for '-' sign' if it is
    // negative) if its intCompact field is not INFLATED. It is shared by all
    // calls to toString() and its variants in that particular thread.
    static class StringBuilderHelper {

        final StringBuilder sb; // Placeholder for BigDecimal string

        final char[] cmpCharArray; // character array to place the intCompact

        StringBuilderHelper() {
            sb = new StringBuilder();
            // All non negative longs can be made to fit into 19 character array.
            cmpCharArray = new char[19];
        }

        // Accessors.
        StringBuilder getStringBuilder() {
            sb.setLength(0);
            return sb;
        }

        char[] getCompactCharArray() {
            return cmpCharArray;
        }

        /**
         * Places characters representing the intCompact in {@code long} into cmpCharArray and
         * returns the offset to the array where the representation starts.
         *
         * @param intCompact the number to put into the cmpCharArray.
         * @return offset to the array where the representation starts. Note: intCompact must be
         *         greater or equal to zero.
         */
        int putIntCompact(long intCompact) {
            assert intCompact >= 0;

            long q;
            int r;
            // since we start from the least significant digit, charPos points to
            // the last character in cmpCharArray.
            int charPos = cmpCharArray.length;

            // Get 2 digits/iteration using longs until quotient fits into an int
            while (intCompact > Integer.MAX_VALUE) {
                q = intCompact / 100;
                r = (int) (intCompact - q * 100);
                intCompact = q;
                cmpCharArray[--charPos] = DIGIT_ONES[r];
                cmpCharArray[--charPos] = DIGIT_TENS[r];
            }

            // Get 2 digits/iteration using ints when i2 >= 100
            int q2;
            int i2 = (int) intCompact;
            while (i2 >= 100) {
                q2 = i2 / 100;
                r = i2 - q2 * 100;
                i2 = q2;
                cmpCharArray[--charPos] = DIGIT_ONES[r];
                cmpCharArray[--charPos] = DIGIT_TENS[r];
            }

            cmpCharArray[--charPos] = DIGIT_ONES[i2];
            if (i2 >= 10) cmpCharArray[--charPos] = DIGIT_TENS[i2];

            return charPos;
        }

        final static char[] DIGIT_TENS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1',
                '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3',
                '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5',
                '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7',
                '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9',
                '9', '9', '9', '9', '9',};

        final static char[] DIGIT_ONES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',};
    }

    private static class LongOverflow {

        /** BigInteger equal to Long.MIN_VALUE. */
        private static final BigInteger LONGMIN = BigInteger.valueOf(Long.MIN_VALUE);

        /** BigInteger equal to Long.MAX_VALUE. */
        private static final BigInteger LONGMAX = BigInteger.valueOf(Long.MAX_VALUE);

        public static void check(BigDecimal num) {
            BigInteger intVal = $(num).inflated();
            if (intVal.compareTo(LONGMIN) < 0 || intVal.compareTo(LONGMAX) > 0) {
                throw new java.lang.ArithmeticException("Overflow");
            }
        }
    }
}
