/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.math.BigInteger;

import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Long} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Long.class)
class JSLong extends JSNumber {

    /**
     * A constant holding the minimum value a {@code long} can have, -2<sup>63</sup>.
     */
    public static final long MIN_VALUE = 0x8000000000000000L;

    /**
     * A constant holding the maximum value a {@code long} can have, 2<sup>63</sup>-1.
     */
    public static final long MAX_VALUE = 0x7fffffffffffffffL;

    /** The primitive long class. */
    public static final Class TYPE = Primitive.class;

    /**
     * Constructs a newly allocated {@code Long} object that represents the specified {@code long}
     * argument.
     * 
     * @param value the value to be represented by the {@code Long} object.
     */
    public JSLong(long value) {
        super(value);
    }

    /**
     * Constructs a newly allocated {@code Long} object that represents the {@code long} value
     * indicated by the {@code String} parameter. The string is converted to a {@code long} value in
     * exactly the manner used by the {@code parseLong} method for radix 10.
     * 
     * @param value the {@code String} to be converted to a {@code Long}.
     * @throws NumberFormatException if the {@code String} does not contain a parsable {@code long}.
     * @see java.lang.Long#parseLong(java.lang.String, int)
     */
    public JSLong(String value) throws NumberFormatException {
        super(parseLong(value));
    }

    /**
     * Returns a hash code for this {@code Long}. The result is the exclusive OR of the two halves
     * of the primitive {@code long} value held by this {@code Long} object. That is, the hashcode
     * is the value of the expression: <blockquote>
     * {@code (int)(this.longValue()^(this.longValue()>>>32))} </blockquote>
     * 
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return hashCode(value.longValue());
    }

    /**
     * Compares two {@code Long} objects numerically.
     * 
     * @param anotherLong the {@code Long} to be compared.
     * @return the value {@code 0} if this {@code Long} is equal to the argument {@code Long}; a
     *         value less than {@code 0} if this {@code Long} is numerically less than the argument
     *         {@code Long}; and a value greater than {@code 0} if this {@code Long} is numerically
     *         greater than the argument {@code Long} (signed comparison).
     * @since 1.2
     */
    public int compareTo(Long anotherLong) {
        return compare(this.value.longValue(), ((JSLong) (Object) anotherLong).value.longValue());
    }

    /**
     * Returns the number of one-bits in the two's complement binary representation of the specified
     * {@code long} value. This function is sometimes referred to as the <i>population count</i>.
     * 
     * @param i the value whose bits are to be counted
     * @return the number of one-bits in the two's complement binary representation of the specified
     *         {@code long} value.
     * @since 1.5
     */
    public static int bitCount(long i) {
        // HD, Figure 5-14
        i = i - ((i >>> 1) & 0x5555555555555555L);
        i = (i & 0x3333333333333333L) + ((i >>> 2) & 0x3333333333333333L);
        i = (i + (i >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        i = i + (i >>> 32);
        return (int) i & 0x7f;
    }

    /**
     * Compares two {@code long} values numerically. The value returned is identical to what would
     * be returned by:
     * 
     * <pre>
     *    Long.valueOf(x).compareTo(Long.valueOf(y))
     * </pre>
     * 
     * @param x the first {@code long} to compare
     * @param y the second {@code long} to compare
     * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y};
     *         and a value greater than {@code 0} if {@code x > y}
     * @since 1.7
     */
    public static int compare(long x, long y) {
        return x < y ? -1 : x == y ? 0 : 1;
    }

    /**
     * Compares two {@code long} values numerically treating the values as unsigned.
     * 
     * @param x the first {@code long} to compare
     * @param y the second {@code long} to compare
     * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y}
     *         as unsigned values; and a value greater than {@code 0} if {@code x > y} as unsigned
     *         values
     * @since 1.8
     */
    public static int compareUnsigned(long x, long y) {
        return compare(x + MIN_VALUE, y + MIN_VALUE);
    }

    /**
     * Returns the unsigned quotient of dividing the first argument by the second where each
     * argument and the result is interpreted as an unsigned value.
     * <p>
     * Note that in two's complement arithmetic, the three other basic arithmetic operations of add,
     * subtract, and multiply are bit-wise identical if the two operands are regarded as both being
     * signed or both being unsigned. Therefore separate {@code addUnsigned}, etc. methods are not
     * provided.
     * 
     * @param dividend the value to be divided
     * @param divisor the value doing the dividing
     * @return the unsigned quotient of the first argument divided by the second argument
     * @see #remainderUnsigned
     * @since 1.8
     */
    public static long divideUnsigned(long dividend, long divisor) {
        if (divisor < 0L) { // signed comparison
            // Answer must be 0 or 1 depending on relative magnitude
            // of dividend and divisor.
            return (compareUnsigned(dividend, divisor)) < 0 ? 0L : 1L;
        }

        if (dividend > 0) // Both inputs non-negative
            return dividend / divisor;
        else {
            /*
             * For simple code, leveraging BigInteger. Longer and faster code written directly in
             * terms of operations on longs is possible; see "Hacker's Delight" for divide and
             * remainder algorithms.
             */
            return toUnsignedBigInteger(dividend).divide(toUnsignedBigInteger(divisor)).longValue();
        }
    }

    /**
     * Returns a hash code for a {@code long} value; compatible with {@code Long.hashCode()}.
     * 
     * @param value the value to hash
     * @return a hash code value for a {@code long} value.
     * @since 1.8
     */
    public static int hashCode(long value) {
        return (int) (value ^ (value >>> 32));
    }

    /**
     * Returns the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's
     * complement binary representation of the specified {@code long} value. Returns 64 if the
     * specified value has no one-bits in its two's complement representation, in other words if it
     * is equal to zero.
     * <p>
     * Note that this method is closely related to the logarithm base 2. For all positive
     * {@code long} values x:
     * <ul>
     * <li>floor(log<sub>2</sub>(x)) = {@code 63 - numberOfLeadingZeros(x)}
     * <li>ceil(log<sub>2</sub>(x)) = {@code 64 - numberOfLeadingZeros(x - 1)}
     * </ul>
     * 
     * @param i the value whose number of leading zeros is to be computed
     * @return the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's
     *         complement binary representation of the specified {@code long} value, or 64 if the
     *         value is equal to zero.
     * @since 1.5
     */
    public static int numberOfLeadingZeros(long i) {
        // HD, Figure 5-6
        if (i == 0) {
            return 64;
        }

        int n = 1;
        int x = (int) (i >>> 32);

        if (x == 0) {
            n += 32;
            x = (int) i;
        }
        if (x >>> 16 == 0) {
            n += 16;
            x <<= 16;
        }
        if (x >>> 24 == 0) {
            n += 8;
            x <<= 8;
        }
        if (x >>> 28 == 0) {
            n += 4;
            x <<= 4;
        }
        if (x >>> 30 == 0) {
            n += 2;
            x <<= 2;
        }
        n -= x >>> 31;
        return n;
    }

    /**
     * Returns the number of zero bits following the lowest-order ("rightmost") one-bit in the two's
     * complement binary representation of the specified {@code long} value. Returns 64 if the
     * specified value has no one-bits in its two's complement representation, in other words if it
     * is equal to zero.
     * 
     * @param i the value whose number of trailing zeros is to be computed
     * @return the number of zero bits following the lowest-order ("rightmost") one-bit in the two's
     *         complement binary representation of the specified {@code long} value, or 64 if the
     *         value is equal to zero.
     * @since 1.5
     */
    public static int numberOfTrailingZeros(long i) {
        // HD, Figure 5-14
        int x, y;
        if (i == 0) {
            return 64;
        }

        int n = 63;
        y = (int) i;

        if (y != 0) {
            n = n - 32;
            x = y;
        } else {
            x = (int) (i >>> 32);
        }

        y = x << 16;

        if (y != 0) {
            n = n - 16;
            x = y;
        }

        y = x << 8;

        if (y != 0) {
            n = n - 8;
            x = y;
        }

        y = x << 4;

        if (y != 0) {
            n = n - 4;
            x = y;
        }

        y = x << 2;

        if (y != 0) {
            n = n - 2;
            x = y;
        }
        return n - ((x << 1) >>> 31);
    }

    /**
     * Parses the string argument as a signed decimal {@code long}. The characters in the string
     * must all be decimal digits, except that the first character may be an ASCII minus sign
     * {@code '-'} (<code>&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign
     * {@code '+'} (<code>'&#92;u002B'</code>) to indicate a positive value. The resulting
     * {@code long} value is returned, exactly as if the argument and the radix {@code 10} were
     * given as arguments to the {@link #parseLong(java.lang.String, int)} method.
     * <p>
     * Note that neither the character {@code L} (<code>'&#92;u004C'</code>) nor {@code l} (
     * <code>'&#92;u006C'</code>) is permitted to appear at the end of the string as a type
     * indicator, as would be permitted in Java programming language source code.
     * 
     * @param value a {@code String} containing the {@code long} representation to be parsed
     * @return the {@code long} represented by the argument in decimal.
     * @throws NumberFormatException if the string does not contain a parsable {@code long}.
     */
    public static long parseLong(String value) throws NumberFormatException {
        return parseLong(value, 10);
    }

    /**
     * Parses the string argument as a signed {@code long} in the radix specified by the second
     * argument. The characters in the string must all be digits of the specified radix (as
     * determined by whether {@link java.lang.Character#digit(char, int)} returns a nonnegative
     * value), except that the first character may be an ASCII minus sign {@code '-'} (
     * <code>'&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign {@code '+'} (
     * <code>'&#92;u002B'</code>) to indicate a positive value. The resulting {@code long} value is
     * returned.
     * <p>
     * Note that neither the character {@code L} (<code>'&#92;u004C'</code>) nor {@code l} (
     * <code>'&#92;u006C'</code>) is permitted to appear at the end of the string as a type
     * indicator, as would be permitted in Java programming language source code - except that
     * either {@code L} or {@code l} may appear as a digit for a radix greater than 22.
     * <p>
     * An exception of type {@code NumberFormatException} is thrown if any of the following
     * situations occurs:
     * <ul>
     * <li>The first argument is {@code null} or is a string of length zero.
     * <li>The {@code radix} is either smaller than {@link java.lang.Character#MIN_RADIX} or larger
     * than {@link java.lang.Character#MAX_RADIX}.
     * <li>Any character of the string is not a digit of the specified radix, except that the first
     * character may be a minus sign {@code '-'} (<code>'&#92;u002d'</code>) or plus sign
     * {@code '+'} (<code>'&#92;u002B'</code>) provided that the string is longer than length 1.
     * <li>The value represented by the string is not a value of type {@code long}.
     * </ul>
     * <p>
     * Examples: <blockquote>
     * 
     * <pre>
     * parseLong("0", 10) returns 0L
     * parseLong("473", 10) returns 473L
     * parseLong("+42", 10) returns 42L
     * parseLong("-0", 10) returns 0L
     * parseLong("-FF", 16) returns -255L
     * parseLong("1100110", 2) returns 102L
     * parseLong("99", 8) throws a NumberFormatException
     * parseLong("Hazelnut", 10) throws a NumberFormatException
     * parseLong("Hazelnut", 36) returns 1356099454469L
     * </pre>
     * </blockquote>
     * 
     * @param value the {@code String} containing the {@code long} representation to be parsed.
     * @param radix the radix to be used while parsing {@code s}.
     * @return the {@code long} represented by the string argument in the specified radix.
     * @throws NumberFormatException if the string does not contain a parsable {@code long}.
     */
    public static long parseLong(String value, int radix) throws NumberFormatException {
        long parsed = Global.parseInt(value, radix);

        if (Global.isNaN(parsed)) {
            throw new NumberFormatException(value + " is not a number.");
        }
        return parsed;
    }

    /**
     * Returns the value obtained by reversing the order of the bytes in the two's complement
     * representation of the specified {@code long} value.
     * 
     * @return the value obtained by reversing the bytes in the specified {@code long} value.
     * @since 1.5
     */
    public static long reverseBytes(long value) {
        value = (value & 0x00ff00ff00ff00ffL) << 8 | (value >>> 8) & 0x00ff00ff00ff00ffL;
        return (value << 48) | ((value & 0xffff0000L) << 16) | ((value >>> 16) & 0xffff0000L) | (value >>> 48);
    }

    /**
     * Returns the signum function of the specified {@code long} value. (The return value is -1 if
     * the specified value is negative; 0 if the specified value is zero; and 1 if the specified
     * value is positive.)
     *
     * @param i the value whose signum is to be computed
     * @return the signum function of the specified {@code long} value.
     * @since 1.5
     */
    public static int signum(long i) {
        // HD, Section 2-7
        return (int) ((i >> 63) | (-i >>> 63));
    }

    /**
     * Adds two {@code long} values together as per the + operator.
     * 
     * @param a the first operand
     * @param b the second operand
     * @return the sum of {@code a} and {@code b}
     * @see java.util.function.BinaryOperator
     * @since 1.8
     */
    public static long sum(long a, long b) {
        return a + b;
    }

    /**
     * Returns a string representation of the {@code long} argument as an unsigned integer in
     * base&nbsp;2.
     * <p>
     * The unsigned {@code long} value is the argument plus 2<sup>64</sup> if the argument is
     * negative; otherwise, it is equal to the argument. This value is converted to a string of
     * ASCII digits in binary (base&nbsp;2) with no extra leading {@code 0}s.
     * <p>
     * The value of the argument can be recovered from the returned string {@code s} by calling
     * {@link Long#parseUnsignedLong(String, int) Long.parseUnsignedLong(s, 2)}.
     * <p>
     * If the unsigned magnitude is zero, it is represented by a single zero character {@code '0'} (
     * {@code '\u005Cu0030'}); otherwise, the first character of the representation of the unsigned
     * magnitude will not be the zero character. The characters {@code '0'} ({@code '\u005Cu0030'})
     * and {@code '1'} ({@code '\u005Cu0031'}) are used as binary digits.
     * 
     * @param value a {@code long} to be converted to a string.
     * @return the string representation of the unsigned {@code long} value represented by the
     *         argument in binary (base&nbsp;2).
     * @see #parseUnsignedLong(String, int)
     * @see #toUnsignedString(long, int)
     * @since JDK 1.0.2
     */
    public static String toBinaryString(long value) {
        return new NativeNumber(value).toString(2);
    }

    /**
     * Returns a {@code String} object representing the specified {@code long}. The argument is
     * converted to signed decimal representation and returned as a string, exactly as if the
     * argument and the radix 10 were given as arguments to the {@link #toString(long, int)} method.
     * 
     * @param value a {@code long} to be converted.
     * @return a string representation of the argument in base&nbsp;10.
     */
    public static String toString(long value) {
        return valueOf(value).toString();
    }

    /**
     * Returns a string representation of the first argument in the radix specified by the second
     * argument.
     * <p>
     * If the radix is smaller than {@code Character.MIN_RADIX} or larger than
     * {@code Character.MAX_RADIX}, then the radix {@code 10} is used instead.
     * <p>
     * If the first argument is negative, the first element of the result is the ASCII minus sign
     * {@code '-'} ({@code '\u005Cu002d'}). If the first argument is not negative, no sign character
     * appears in the result.
     * <p>
     * The remaining characters of the result represent the magnitude of the first argument. If the
     * magnitude is zero, it is represented by a single zero character {@code '0'} (
     * {@code '\u005Cu0030'}); otherwise, the first character of the representation of the magnitude
     * will not be the zero character. The following ASCII characters are used as digits:
     * <blockquote> {@code 0123456789abcdefghijklmnopqrstuvwxyz} </blockquote> These are
     * {@code '\u005Cu0030'} through {@code '\u005Cu0039'} and {@code '\u005Cu0061'} through
     * {@code '\u005Cu007a'}. If {@code radix} is <var>N</var>, then the first <var>N</var> of these
     * characters are used as radix-<var>N</var> digits in the order shown. Thus, the digits for
     * hexadecimal (radix 16) are {@code 0123456789abcdef}. If uppercase letters are desired, the
     * {@link java.lang.String#toUpperCase()} method may be called on the result: <blockquote>
     * {@code Long.toString(n, 16).toUpperCase()} </blockquote>
     *
     * @param i a {@code long} to be converted to a string.
     * @param radix the radix to use in the string representation.
     * @return a string representation of the argument in the specified radix.
     * @see java.lang.Character#MAX_RADIX
     * @see java.lang.Character#MIN_RADIX
     */
    public static String toString(long i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            radix = 10;
        }

        if (radix == 10) {
            return toString(i);
        }

        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (i < 0);

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = JSInteger.digits[(int) (-(i % radix))];
            i = i / radix;
        }
        buf[charPos] = JSInteger.digits[(int) (-i)];

        if (negative) {
            buf[--charPos] = '-';
        }
        return new String(buf, charPos, (65 - charPos));
    }

    /**
     * Return a BigInteger equal to the unsigned value of the argument.
     */
    private static BigInteger toUnsignedBigInteger(long i) {
        if (i >= 0L) {
            return BigInteger.valueOf(i);
        } else {
            int upper = (int) (i >>> 32);
            int lower = (int) i;

            // return (upper << 32) + lower
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32)
                    .add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
        }
    }

    /**
     * Returns a {@code Long} object holding the value of the specified {@code String}. The argument
     * is interpreted as representing a signed decimal {@code long}, exactly as if the argument were
     * given to the {@link #parseLong(java.lang.String)} method. The result is a {@code Long} object
     * that represents the integer value specified by the string.
     * <p>
     * In other words, this method returns a {@code Long} object equal to the value of: <blockquote>
     * {@code new Long(Long.parseLong(s))} </blockquote>
     * 
     * @param value the string to be parsed.
     * @return a {@code Long} object holding the value represented by the string argument.
     * @throws NumberFormatException If the string cannot be parsed as a {@code long}.
     */
    public static Long valueOf(String value) throws NumberFormatException {
        return valueOf(parseLong(value));
    }

    /**
     * Returns a {@code Long} object holding the value extracted from the specified {@code String}
     * when parsed with the radix given by the second argument. The first argument is interpreted as
     * representing a signed {@code long} in the radix specified by the second argument, exactly as
     * if the arguments were given to the {@link #parseLong(java.lang.String, int)} method. The
     * result is a {@code Long} object that represents the {@code long} value specified by the
     * string.
     * <p>
     * In other words, this method returns a {@code Long} object equal to the value of: <blockquote>
     * {@code new Long(Long.parseLong(s, radix))} </blockquote>
     * 
     * @param value the string to be parsed
     * @param radix the radix to be used in interpreting {@code s}
     * @return a {@code Long} object holding the value represented by the string argument in the
     *         specified radix.
     * @throws NumberFormatException If the {@code String} does not contain a parsable {@code long}.
     */
    public static Long valueOf(String value, int radix) throws NumberFormatException {
        return valueOf(parseLong(value, radix));
    }

    /**
     * Returns a {@code Long} instance representing the specified {@code long} value. If a new
     * {@code Long} instance is not required, this method should generally be used in preference to
     * the constructor {@link #Long(long)}, as this method is likely to yield significantly better
     * space and time performance by caching frequently requested values. Note that unlike the
     * {@linkplain Integer#valueOf(int) corresponding method} in the {@code Integer} class, this
     * method is <em>not</em> required to cache values within a particular range.
     * 
     * @param value a long value.
     * @return a {@code Long} instance representing {@code l}.
     * @since 1.5
     */
    public static Long valueOf(long value) {
        return (Long) (Object) new JSLong(value);
    }

    /**
     * @version 2013/04/16 23:01:24
     */
    @JavaAPIProvider(long.class)
    private static class Primitive {
    }
}
