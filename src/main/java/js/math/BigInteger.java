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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:43:40
 */
@JavaAPIProvider(java.math.BigInteger.class)
public class BigInteger extends Number {

    /**
     * The {@code BigInteger} constant 1.
     */
    public static final BigInteger ONE = new BigInteger(1, 1);

    /* Fields used for the internal representation. */

    /**
     * The {@code BigInteger} constant 10.
     */
    public static final BigInteger TEN = new BigInteger(1, 10);

    /**
     * The {@code BigInteger} constant 0.
     */
    public static final BigInteger ZERO = new BigInteger(0, 0);

    /**
     * The {@code BigInteger} constant 0 used for comparison.
     */
    static final int EQUALS = 0;

    /**
     * The {@code BigInteger} constant 1 used for comparison.
     */
    static final int GREATER = 1;

    /**
     * The {@code BigInteger} constant -1 used for comparison.
     */
    static final int LESS = -1;

    /**
     * The {@code BigInteger} constant -1.
     */
    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);

    /**
     * All the {@code BigInteger} numbers in the range [0,10] are cached.
     */
    static final BigInteger[] SMALL_VALUES = {ZERO, ONE, new BigInteger(1, 2), new BigInteger(1, 3),
            new BigInteger(1, 4), new BigInteger(1, 5), new BigInteger(1, 6), new BigInteger(1, 7),
            new BigInteger(1, 8), new BigInteger(1, 9), TEN};

    static final BigInteger[] TWO_POWS;

    static {
        TWO_POWS = new BigInteger[32];
        for (int i = 0; i < TWO_POWS.length; i++) {
            TWO_POWS[i] = BigInteger.valueOf(1L << i);
        }
    }

    /**
     * The magnitude of this big integer. This array holds unsigned little endian digits. For
     * example: {@code 13} is represented as [ 13 ] {@code -13} is represented as [ 13 ]
     * {@code 2^32 + 13} is represented as [ 13, 1 ] {@code 2^64 + 13} is represented as [ 13, 0, 1
     * ] {@code 2^31} is represented as [ Integer.MIN_VALUE ] The magnitude array may be longer than
     * strictly necessary, which results in additional trailing zeros.
     */
    transient int[] digits;

    /**
     * The length of this in measured in ints. Can be less than digits.length().
     */
    transient int numberLength;

    /**
     * The sign of this.
     */
    transient int sign;

    private transient int firstNonzeroDigit = -2;

    /**
     * Cache for the hash code.
     */
    private transient int hashCode = 0;

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
    public BigInteger(String val) {
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
    public BigInteger(String val, int radix) {
        if (val == null) {
            throw new NullPointerException();
        }

        if ((radix < Character.MIN_RADIX) || (radix > Character.MAX_RADIX)) {
            // math.11=Radix out of range
            throw new NumberFormatException("Radix out of range");
        }
        if (val.length() == 0) {
            // math.12=Zero length BigInteger
            throw new NumberFormatException("Zero length BigInteger");
        }
        setFromString(this, val, radix);
    }

    /**
     * Constructs a number which array is of size 1.
     * 
     * @param sign the sign of the number
     * @param value the only one digit of array
     */
    BigInteger(int sign, int value) {
        this.sign = sign;
        numberLength = 1;
        digits = new int[] {value};
    }

    /**
     * Creates a new {@code BigInteger} whose value is equal to the specified {@code long}.
     * 
     * @param sign the sign of the number
     * @param val the value of the new {@code BigInteger}.
     */
    BigInteger(int sign, long val) {
        // PRE: (val >= 0) && (sign >= -1) && (sign <= 1)
        this.sign = sign;
        if ((val & 0xFFFFFFFF00000000L) == 0) {
            // It fits in one 'int'
            numberLength = 1;
            digits = new int[] {(int) val};
        } else {
            numberLength = 2;
            digits = new int[] {(int) val, (int) (val >> 32)};
        }
    }

    /**
     * Returns this {@code BigInteger} as an long value. If {@code this} is too big to be
     * represented as an long, then {@code this} % 2^64 is returned.
     * 
     * @return this {@code BigInteger} as a long value.
     */
    @Override
    public long longValue() {
        System.out.println(numberLength + "  @@@  " + Arrays.toString(digits) + "   " + (digits[0] & 0xFFFFFFFFL));
        long value = (numberLength > 1) ? (((long) digits[1]) << 32) | (digits[0] & 0xFFFFFFFFL)
                : (digits[0] & 0xFFFFFFFFL);
        System.out.println(value);
        return (sign * value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return (sign * digits[0]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float floatValue() {
        return Float.parseFloat(this.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return Double.parseDouble(this.toString());
    }

    /**
     * Decreases {@code numberLength} if there are zero high elements.
     */
    final void cutOffLeadingZeroes() {
        while ((numberLength > 0) && (digits[--numberLength] == 0)) {
            // Empty
        }
        if (digits[numberLength++] == 0) {
            sign = 0;
        }
    }

    /**
     * @see BigInteger#BigInteger(String, int)
     */
    private static void setFromString(BigInteger big, String value, int radix) {
        int sign;
        int[] digits;
        int numberLength;
        int length = value.length();
        int startChar;
        int endChar = length;

        if (value.charAt(0) == '-') {
            sign = -1;
            startChar = 1;
            length--;
        } else {
            sign = 1;
            startChar = 0;
        }

        /*
         * We use the following algorithm: split a string into portions of n characters and convert
         * each portion to an integer according to the radix. Then convert an exp(radix, n) based
         * number to binary using the multiplication method. See D. Knuth, The Art of Computer
         * Programming, vol. 2.
         */

        int charsPerInt = Conversion.digitFitInInt[radix];
        int bigRadixDigitsLength = (int) Math.floor(length / charsPerInt);
        int topChars = length % charsPerInt;

        if (topChars != 0) {
            bigRadixDigitsLength++;
        }
        digits = new int[bigRadixDigitsLength];
        // Get the maximal power of radix that fits in int
        int bigRadix = Conversion.bigRadices[radix - 2];
        // Parse an input string and accumulate the BigInteger's magnitude
        int digitIndex = 0; // index of digits array
        int substrEnd = startChar + ((topChars == 0) ? charsPerInt : topChars);
        int newDigit;
        int substrStart = startChar;

        while (substrStart < endChar) {
            int bigRadixDigit = Integer.parseInt(value.substring(substrStart, substrEnd), radix);
            // System.out.println(bigRadixDigit);
            newDigit = Multiplication.multiplyByInt(digits, digitIndex, bigRadix);
            newDigit += Elementary.inplaceAdd(digits, digitIndex, bigRadixDigit);
            digits[digitIndex++] = newDigit;
            substrStart = substrEnd;
            substrEnd = substrStart + charsPerInt;
        }

        numberLength = digitIndex;
        big.sign = sign;
        big.numberLength = numberLength;
        big.digits = digits;
        big.cutOffLeadingZeroes();
    }

    public static BigInteger valueOf(long val) {
        if (val < 0) {
            if (val != -1) {
                return new BigInteger(-1, -val);
            }
            return MINUS_ONE;
        } else if (val <= 10) {
            return SMALL_VALUES[(int) val];
        } else {
            // (val > 10)
            return new BigInteger(1, val);
        }
    }

}
