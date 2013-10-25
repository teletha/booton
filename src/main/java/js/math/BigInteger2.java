/*
 * Copyright (C) 2013 Nameless Production Committee
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
 * @version 2013/10/25 12:46:56
 */
// @JavaAPIProvider(BigInteger.class)
public class BigInteger2 {

    /**
     * The BigInteger constant zero.
     * 
     * @since 1.2
     */
    public static final BigInteger2 ZERO = new BigInteger2(new int[0], 0);

    // bitsPerDigit in the given radix times 1024
    // Rounded up to avoid underallocation.
    private static long[] bitsPerDigit = {0, 0, 1024, 1624, 2048, 2378, 2648, 2875, 3072, 3247, 3402, 3543, 3672, 3790,
            3899, 4001, 4096, 4186, 4271, 4350, 4426, 4498, 4567, 4633, 4696, 4756, 4814, 4870, 4923, 4975, 5025, 5074,
            5120, 5166, 5210, 5253, 5295};

    /*
     * These two arrays are the integer analogue of above.
     */
    private static int[] digitsPerInt = {0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};

    private static int[] intRadix = {0, 0, 0x40000000, 0x4546b3db, 0x40000000, 0x48c27395, 0x159fd800, 0x75db9c97,
            0x40000000, 0x17179149, 0x3b9aca00, 0xcc6db61, 0x19a10000, 0x309f1021, 0x57f6c100, 0xa2f1b6f, 0x10000000,
            0x18754571, 0x247dbc80, 0x3547667b, 0x4c4b4000, 0x6b5a6e1d, 0x6c20a40, 0x8d2d931, 0xb640000, 0xe8d4a51,
            0x1269ae40, 0x17179149, 0x1cb91000, 0x23744899, 0x2b73a840, 0x34e63b41, 0x40000000, 0x4cfa3cc1, 0x5c13d840,
            0x6d91b519, 0x39aa400};

    /**
     * This mask is used to obtain the value of an int as if it were unsigned.
     */
    private final static long LONG_MASK = 0xffffffffL;

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

    /**
     * Two plus the index of the lowest-order int in the magnitude of this BigInteger that contains
     * a nonzero int, or -2 (either value is acceptable). The least significant int has int-number
     * 0, the next int in order of increasing significance has int-number 1, and so forth.
     * 
     * @deprecated Deprecated since logical value is offset from stored value and correction factor
     *             is applied in accessor method.
     */
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
    public BigInteger2(String val) {
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
    public BigInteger2(String val, int radix) {
        int cursor = 0, numDigits;
        final int len = val.length();

        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Radix out of range");
        }

        if (len == 0) {
            throw new NumberFormatException("Zero length BigInteger");
        }

        // Check for at most one leading sign
        int sign = 1;
        int index1 = val.lastIndexOf('-');
        int index2 = val.lastIndexOf('+');
        if ((index1 + index2) <= -1) {
            // No leading sign character or at most one leading sign character
            if (index1 == 0 || index2 == 0) {
                cursor = 1;
                if (len == 1) {
                    throw new NumberFormatException("Zero length BigInteger");
                }
            }

            if (index1 == 0) {
                sign = -1;
            }
        } else {
            throw new NumberFormatException("Illegal embedded sign character");
        }

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
        int numBits = (int) (((numDigits * bitsPerDigit[radix]) >>> 10) + 1);
        int numWords = (numBits + 31) >>> 5;
        int[] magnitude = new int[numWords];

        // Process first (potentially short) digit group
        int firstGroupLen = numDigits % digitsPerInt[radix];
        if (firstGroupLen == 0) {
            firstGroupLen = digitsPerInt[radix];
        }

        String group = val.substring(cursor, cursor += firstGroupLen);
        magnitude[numWords - 1] = Integer.parseInt(group, radix);
        if (magnitude[numWords - 1] < 0) {
            throw new NumberFormatException("Illegal digit");
        }

        // Process remaining digit groups
        int superRadix = intRadix[radix];
        int groupVal = 0;
        while (cursor < len) {
            group = val.substring(cursor, cursor += digitsPerInt[radix]);
            groupVal = Integer.parseInt(group, radix);
            if (groupVal < 0) {
                throw new NumberFormatException("Illegal digit");
            }
            destructiveMulAdd(magnitude, superRadix, groupVal);
        }
        System.out.println(Arrays.toString(magnitude));
        // Required for cases where the array was overallocated.
        mag = trustedStripLeadingZeroInts(magnitude);
    }

    /**
     * This internal constructor differs from its public cousin with the arguments reversed in two
     * ways: it assumes that its arguments are correct, and it doesn't copy the magnitude array.
     */
    BigInteger2(int[] magnitude, int signum) {
        this.signum = (magnitude.length == 0 ? 0 : signum);
        this.mag = magnitude;
    }

    /**
     * Converts this BigInteger to a {@code long}. This conversion is analogous to a <i>narrowing
     * primitive conversion</i> from {@code long} to {@code int} as defined in section 5.1.3 of
     * <cite>The Java&trade; Language Specification</cite>: if this BigInteger is too big to fit in
     * a {@code long}, only the low-order 64 bits are returned. Note that this conversion can lose
     * information about the overall magnitude of the BigInteger value as well as return a result
     * with the opposite sign.
     * 
     * @return this BigInteger converted to a {@code long}.
     * @see #longValueExact()
     */
    public long longValue() {
        long result = 0;

        for (int i = 1; i >= 0; i--) {
            result = (result << 32) + (getInt(i) & LONG_MASK);
        }
        return result;
    }

    /* Returns an int of sign bits */
    private int signInt() {
        return signum < 0 ? -1 : 0;
    }

    /**
     * Returns the index of the int that contains the first nonzero int in the little-endian binary
     * representation of the magnitude (int 0 is the least significant). If the magnitude is zero,
     * return value is undefined.
     */
    private int firstNonzeroIntNum() {
        int fn = firstNonzeroIntNum - 2;
        if (fn == -2) { // firstNonzeroIntNum not initialized yet
            fn = 0;

            // Search for the first nonzero int
            int i;
            int mlen = mag.length;
            for (i = mlen - 1; i >= 0 && mag[i] == 0; i--);
            fn = mlen - i - 1;
            firstNonzeroIntNum = fn + 2; // offset by two to initialize
        }
        return fn;
    }

    /**
     * Returns the specified int of the little-endian two's complement representation (int 0 is the
     * least significant). The int number can be arbitrarily high (values are logically preceded by
     * infinitely many sign ints).
     */
    private int getInt(int n) {
        if (n < 0) {
            return 0;
        }

        if (n >= mag.length) {
            return signInt();
        }

        int magInt = mag[mag.length - n - 1];

        return (signum >= 0 ? magInt : (n <= firstNonzeroIntNum() ? -magInt : ~magInt));
    }

    // Multiply x array times word y in place, and add word z
    private static void destructiveMulAdd(int[] x, int y, int z) {
        // Perform the multiplication word by word
        long ylong = y & LONG_MASK;
        long zlong = z & LONG_MASK;
        int len = x.length;

        long product = 0;
        long carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            product = ylong * (x[i] & LONG_MASK) + carry;
            x[i] = (int) product;
            carry = product >>> 32;
            System.out.println(carry);
        }

        // Perform the addition
        long sum = (x[len - 1] & LONG_MASK) + zlong;
        x[len - 1] = (int) sum;
        carry = sum >>> 32;
        for (int i = len - 2; i >= 0; i--) {
            sum = (x[i] & LONG_MASK) + carry;
            x[i] = (int) sum;
            carry = sum >>> 32;
        }
    }

    /**
     * Returns the input array stripped of any leading zero bytes. Since the source is trusted the
     * copying may be skipped.
     */
    private static int[] trustedStripLeadingZeroInts(int[] val) {
        int vlen = val.length;
        int keep;

        // Find first nonzero byte
        for (keep = 0; keep < vlen && val[keep] == 0; keep++);
        return keep == 0 ? val : java.util.Arrays.copyOfRange(val, keep, vlen);
    }
}
