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

import java.math.BigInteger;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/13 14:46:48
 */
@JavaAPIProvider(BigInteger.class)
class JSBigInteger {

    /**
     * The BigInteger constant zero.
     *
     * @since 1.2
     */
    public static final BigInteger ZERO = (BigInteger) (Object) new JSBigInteger(new int[0], 0);

    /**
     * The BigInteger constant one.
     *
     * @since 1.2
     */
    public static final BigInteger ONE = valueOf(1);

    /**
     * The BigInteger constant two. (Not exported.)
     */
    private static final BigInteger TWO = valueOf(2);

    /**
     * The BigInteger constant -1. (Not exported.)
     */
    private static final BigInteger NEGATIVE_ONE = valueOf(-1);

    /**
     * This mask is used to obtain the value of an int as if it were unsigned.
     */
    final static long LONG_MASK = 0xffffffffL;

    /**
     * This constant limits {@code mag.length} of BigIntegers to the supported range.
     */
    private static final int MAX_MAG_LENGTH = Integer.MAX_VALUE / Integer.SIZE + 1; // (1 << 26)

    /**
     * Bit lengths larger than this constant can cause overflow in searchLen calculation and in
     * BitSieve.singleSearch method.
     */
    private static final int PRIME_SEARCH_BIT_LENGTH_LIMIT = 500000000;

    /**
     * The threshold value for using Karatsuba multiplication. If the number of ints in both mag
     * arrays are greater than this number, then Karatsuba multiplication will be used. This value
     * is found experimentally to work well.
     */
    private static final int KARATSUBA_THRESHOLD = 80;

    /**
     * The threshold value for using 3-way Toom-Cook multiplication. If the number of ints in each
     * mag array is greater than the Karatsuba threshold, and the number of ints in at least one of
     * the mag arrays is greater than this threshold, then Toom-Cook multiplication will be used.
     */
    private static final int TOOM_COOK_THRESHOLD = 240;

    /**
     * The threshold value for using Karatsuba squaring. If the number of ints in the number are
     * larger than this value, Karatsuba squaring will be used. This value is found experimentally
     * to work well.
     */
    private static final int KARATSUBA_SQUARE_THRESHOLD = 128;

    /**
     * The threshold value for using Toom-Cook squaring. If the number of ints in the number are
     * larger than this value, Toom-Cook squaring will be used. This value is found experimentally
     * to work well.
     */
    private static final int TOOM_COOK_SQUARE_THRESHOLD = 216;

    /**
     * The threshold value for using Burnikel-Ziegler division. If the number of ints in the divisor
     * are larger than this value, Burnikel-Ziegler division may be used. This value is found
     * experimentally to work well.
     */
    static final int BURNIKEL_ZIEGLER_THRESHOLD = 80;

    /**
     * The offset value for using Burnikel-Ziegler division. If the number of ints in the divisor
     * exceeds the Burnikel-Ziegler threshold, and the number of ints in the dividend is greater
     * than the number of ints in the divisor plus this value, Burnikel-Ziegler division will be
     * used. This value is found experimentally to work well.
     */
    static final int BURNIKEL_ZIEGLER_OFFSET = 40;

    /**
     * The threshold value for using Schoenhage recursive base conversion. If the number of ints in
     * the number are larger than this value, the Schoenhage algorithm will be used. In practice, it
     * appears that the Schoenhage routine is faster for any threshold down to 2, and is relatively
     * flat for thresholds between 2-25, so this choice may be varied within this range for very
     * small effect.
     */
    private static final int SCHOENHAGE_BASE_CONVERSION_THRESHOLD = 20;

    /**
     * The signum of this BigInteger: -1 for negative, 0 for zero, or 1 for positive. Note that the
     * BigInteger zero <i>must</i> have a signum of 0. This is necessary to ensures that there is
     * exactly one representation for each BigInteger value.
     *
     * @serial
     */
    final int signum;

    /**
     * The magnitude of this BigInteger, in <i>big-endian</i> order: the zeroth element of this
     * array is the most-significant int of the magnitude. The magnitude must be "minimal" in that
     * the most-significant int ({@code mag[0]}) must be non-zero. This is necessary to ensure that
     * there is exactly one representation for each BigInteger value. Note that this implies that
     * the BigInteger zero has a zero-length mag array.
     */
    final int[] mag;

    // These "redundant fields" are initialized with recognizable nonsense
    // values, and cached the first time they are needed (or never, if they
    // aren't needed).

    /**
     * One plus the bitCount of this BigInteger. Zeros means unitialized.
     *
     * @serial
     * @see #bitCount
     * @deprecated Deprecated since logical value is offset from stored value and correction factor
     *             is applied in accessor method.
     */
    @Deprecated
    private int bitCount;

    /**
     * One plus the bitLength of this BigInteger. Zeros means unitialized. (either value is
     * acceptable).
     *
     * @serial
     * @see #bitLength()
     * @deprecated Deprecated since logical value is offset from stored value and correction factor
     *             is applied in accessor method.
     */
    @Deprecated
    private int bitLength;

    /**
     * Two plus the lowest set bit of this BigInteger, as returned by getLowestSetBit().
     *
     * @serial
     * @see #getLowestSetBit
     * @deprecated Deprecated since logical value is offset from stored value and correction factor
     *             is applied in accessor method.
     */
    @Deprecated
    private int lowestSetBit;

    /**
     * Two plus the index of the lowest-order int in the magnitude of this BigInteger that contains
     * a nonzero int, or -2 (either value is acceptable). The least significant int has int-number
     * 0, the next int in order of increasing significance has int-number 1, and so forth.
     * 
     * @deprecated Deprecated since logical value is offset from stored value and correction factor
     *             is applied in accessor method.
     */
    @Deprecated
    private int firstNonzeroIntNum;

    /**
     * Translates the decimal String representation of a BigInteger into a BigInteger. The String
     * representation consists of an optional minus sign followed by a sequence of one or more
     * decimal digits. The character-to-digit mapping is provided by {@code Character.digit}. The
     * String may not contain any extraneous characters (whitespace, for example).
     *
     * @param val decimal String representation of BigInteger.
     * @throws NumberFormatException {@code val} is not a valid representation of a BigInteger.
     * @see Character#digit
     */
    public JSBigInteger(String val) {
        this(val, 10);
    }

    /**
     * Translates the String representation of a BigInteger in the specified radix into a
     * BigInteger. The String representation consists of an optional minus or plus sign followed by
     * a sequence of one or more digits in the specified radix. The character-to-digit mapping is
     * provided by {@code Character.digit}. The String may not contain any extraneous characters
     * (whitespace, for example).
     *
     * @param val String representation of BigInteger.
     * @param radix radix to be used in interpreting {@code val}.
     * @throws NumberFormatException {@code val} is not a valid representation of a BigInteger in
     *             the specified radix, or {@code radix} is outside the range from
     *             {@link Character#MIN_RADIX} to {@link Character#MAX_RADIX}, inclusive.
     * @see Character#digit
     */
    public JSBigInteger(String val, int radix) {
        int cursor = 0, numDigits;
        final int len = val.length();

        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            throw new NumberFormatException("Radix out of range");
        if (len == 0) throw new NumberFormatException("Zero length BigInteger");

        // Check for at most one leading sign
        int sign = 1;
        int index1 = val.lastIndexOf('-');
        int index2 = val.lastIndexOf('+');
        if (index1 >= 0) {
            if (index1 != 0 || index2 >= 0) {
                throw new NumberFormatException("Illegal embedded sign character");
            }
            sign = -1;
            cursor = 1;
        } else if (index2 >= 0) {
            if (index2 != 0) {
                throw new NumberFormatException("Illegal embedded sign character");
            }
            cursor = 1;
        }
        if (cursor == len) throw new NumberFormatException("Zero length BigInteger");

        // Skip leading zeros and compute number of digits in magnitude
        while (cursor < len && Character.digit(val.charAt(cursor), radix) == 0) {
            cursor++;
        }

        if (cursor == len) {
            signum = 0;
            mag = ZERO.mag;
            return;
        }

        numDigits = len - cursor;
        signum = sign;

        // Pre-allocate array of expected size. May be too large but can
        // never be too small. Typically exact.
        long numBits = ((numDigits * bitsPerDigit[radix]) >>> 10) + 1;
        if (numBits + 31 >= (1L << 32)) {
            reportOverflow();
        }
        int numWords = (int) (numBits + 31) >>> 5;
        int[] magnitude = new int[numWords];

        // Process first (potentially short) digit group
        int firstGroupLen = numDigits % digitsPerInt[radix];
        if (firstGroupLen == 0) firstGroupLen = digitsPerInt[radix];
        String group = val.substring(cursor, cursor += firstGroupLen);
        magnitude[numWords - 1] = Integer.parseInt(group, radix);
        if (magnitude[numWords - 1] < 0) throw new NumberFormatException("Illegal digit");

        // Process remaining digit groups
        int superRadix = intRadix[radix];
        int groupVal = 0;
        while (cursor < len) {
            group = val.substring(cursor, cursor += digitsPerInt[radix]);
            groupVal = Integer.parseInt(group, radix);
            if (groupVal < 0) throw new NumberFormatException("Illegal digit");
            destructiveMulAdd(magnitude, superRadix, groupVal);
        }
        // Required for cases where the array was overallocated.
        mag = trustedStripLeadingZeroInts(magnitude);
        if (mag.length >= MAX_MAG_LENGTH) {
            checkRange();
        }
    }

    /**
     * This internal constructor differs from its public cousin with the arguments reversed in two
     * ways: it assumes that its arguments are correct, and it doesn't copy the magnitude array.
     */
    JSBigInteger(int[] magnitude, int signum) {
        this.signum = (magnitude.length == 0 ? 0 : signum);
        this.mag = magnitude;
        if (mag.length >= MAX_MAG_LENGTH) {
            checkRange();
        }
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
        // If -MAX_CONSTANT < val < MAX_CONSTANT, return stashed constant
        if (val == 0) {
            return ZERO;
        }

        if (val > 0 && val <= MAX_CONSTANT) {
            return posConst[(int) val];
        } else if (val < 0 && val >= -MAX_CONSTANT) {
            return negConst[(int) -val];
        }

        return (BigInteger) (Object) new JSBigInteger(val);
    }
}
