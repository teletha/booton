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

import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Integer} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/10/02 23:00:09
 */
@JavaAPIProvider(Integer.class)
class JSInteger extends JSNumber {

    /** The primitive int class. */
    public static final Class TYPE = Primitive.class;

    /**
     * Constructs a newly allocated {@code Integer} object that represents the specified {@code int}
     * value.
     * 
     * @param value the value to be represented by the {@code Integer} object.
     */
    public JSInteger(int value) {
        super(value);
    }

    /**
     * Constructs a newly allocated {@code Integer} object that represents the {@code int} value
     * indicated by the {@code String} parameter. The string is converted to an {@code int} value in
     * exactly the manner used by the {@code parseInt} method for radix 10.
     * 
     * @param value the {@code String} to be converted to an {@code Integer}.
     * @exception NumberFormatException if the {@code String} does not contain a parsable integer.
     * @see java.lang.Integer#parseInt(java.lang.String, int)
     */
    public JSInteger(String value) throws NumberFormatException {
        super(parseInt(value));
    }

    /**
     * Returns a hash code for this {@code Integer}.
     * 
     * @return a hash code value for this object, equal to the primitive {@code int} value
     *         represented by this {@code Integer} object.
     */
    @Override
    public int hashCode() {
        return value.intValue();
    }

    /**
     * Compares two {@code int} values numerically. The value returned is identical to what would be
     * returned by:
     * 
     * <pre>
     *    Integer.valueOf(x).compareTo(Integer.valueOf(y))
     * </pre>
     * 
     * @param x the first {@code int} to compare
     * @param y the second {@code int} to compare
     * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y};
     *         and a value greater than {@code 0} if {@code x > y}
     * @since 1.7
     */
    public static int compare(int x, int y) {
        return x < y ? -1 : x == y ? 0 : 1;
    }

    /**
     * Returns a hash code for a {@code int} value; compatible with {@code Integer.hashCode()}.
     * 
     * @param value the value to hash
     * @since 1.8
     * @return a hash code value for a {@code int} value.
     */
    public static int hashCode(int value) {
        return value;
    }

    /**
     * Returns the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's
     * complement binary representation of the specified {@code int} value. Returns 32 if the
     * specified value has no one-bits in its two's complement representation, in other words if it
     * is equal to zero.
     * <p>
     * Note that this method is closely related to the logarithm base 2. For all positive
     * {@code int} values x:
     * <ul>
     * <li>floor(log<sub>2</sub>(x)) = {@code 31 - numberOfLeadingZeros(x)}
     * <li>ceil(log<sub>2</sub>(x)) = {@code 32 - numberOfLeadingZeros(x - 1)}
     * </ul>
     * 
     * @param value the value whose number of leading zeros is to be computed
     * @return the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's
     *         complement binary representation of the specified {@code int} value, or 32 if the
     *         value is equal to zero.
     * @since 1.5
     */
    public static int numberOfLeadingZeros(int value) {
        if (value == 0) {
            return 32;
        }

        int n = 1;

        if (value >>> 16 == 0) {
            n += 16;
            value <<= 16;
        }

        if (value >>> 24 == 0) {
            n += 8;
            value <<= 8;
        }

        if (value >>> 28 == 0) {
            n += 4;
            value <<= 4;
        }

        if (value >>> 30 == 0) {
            n += 2;
            value <<= 2;
        }
        n -= value >>> 31;
        return n;
    }

    /**
     * <p>
     * Parses the string argument as a signed decimal integer. The characters in the string must all
     * be decimal digits, except that the first character may be an ASCII minus sign {@code '-'} (
     * <code>'&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign {@code '+'} (
     * <code>'&#92;u002B'</code>) to indicate a positive value. The resulting integer value is
     * returned, exactly as if the argument and the radix 10 were given as arguments to the
     * {@link #parseInt(java.lang.String, int)} method.
     * </p>
     * 
     * @param value a {@code String} containing the {@code int} representation to be parsed
     * @return the integer value represented by the argument in decimal.
     * @exception NumberFormatException if the string does not contain a parsable integer.
     */
    public static int parseInt(String value) throws NumberFormatException {
        return parseInt(value, 10);
    }

    /**
     * <p>
     * Parses the string argument as a signed integer in the radix specified by the second argument.
     * The characters in the string must all be digits of the specified radix (as determined by
     * whether {@link java.lang.Character#digit(char, int)} returns a nonnegative value), except
     * that the first character may be an ASCII minus sign {@code '-'} (<code>'&#92;u002D'</code>)
     * to indicate a negative value or an ASCII plus sign {@code '+'} (<code>'&#92;u002B'</code>) to
     * indicate a positive value. The resulting integer value is returned.
     * </p>
     * <p>
     * An exception of type {@code NumberFormatException} is thrown if any of the following
     * situations occurs:
     * </p>
     * <ul>
     * <li>The first argument is {@code null} or is a string of length zero.
     * <li>The radix is either smaller than {@link java.lang.Character#MIN_RADIX} or larger than
     * {@link java.lang.Character#MAX_RADIX}.
     * <li>Any character of the string is not a digit of the specified radix, except that the first
     * character may be a minus sign {@code '-'} (<code>'&#92;u002D'</code>) or plus sign
     * {@code '+'} (<code>'&#92;u002B'</code>) provided that the string is longer than length 1.
     * <li>The value represented by the string is not a value of type {@code int}.
     * </ul>
     * <p>
     * Examples:
     * </p>
     * 
     * <pre>
     * parseInt("0", 10) returns 0
     * parseInt("473", 10) returns 473
     * parseInt("+42", 10) returns 42
     * parseInt("-0", 10) returns 0
     * parseInt("-FF", 16) returns -255
     * parseInt("1100110", 2) returns 102
     * parseInt("2147483647", 10) returns 2147483647
     * parseInt("-2147483648", 10) returns -2147483648
     * parseInt("2147483648", 10) throws a NumberFormatException
     * parseInt("99", 8) throws a NumberFormatException
     * parseInt("Kona", 10) throws a NumberFormatException
     * parseInt("Kona", 27) returns 411787
     * </pre>
     * 
     * @param value the {@code String} containing the integer representation to be parsed
     * @param radix the radix to be used while parsing {@code s}.
     * @return the integer represented by the string argument in the specified radix.
     * @exception NumberFormatException if the {@code String} does not contain a parsable
     *                {@code int}.
     */
    public static int parseInt(String value, int radix) throws NumberFormatException {
        int parsed = Global.parseInt(value, radix);

        if (Global.isNaN(parsed)) {
            throw new NumberFormatException("The input value \"" + value + "\" is not a number.");
        }
        return parsed;
    }

    /**
     * <p>
     * Returns an {@code Integer} object holding the value of the specified {@code String}. The
     * argument is interpreted as representing a signed decimal integer, exactly as if the argument
     * were given to the {@link #parseInt(java.lang.String)} method. The result is an
     * {@code Integer} object that represents the integer value specified by the string.
     * </p>
     * <p>
     * In other words, this method returns an {@code Integer} object equal to the value of:
     * </p>
     * <blockquote> {@code new Integer(Integer.parseInt(s))} </blockquote>
     * 
     * @param value the string to be parsed.
     * @return an {@code Integer} object holding the value represented by the string argument.
     * @exception NumberFormatException if the string cannot be parsed as an integer.
     */
    public static Integer valueOf(String value) throws NumberFormatException {
        return valueOf(parseInt(value));
    }

    /**
     * <p>
     * Returns an {@code Integer} object holding the value extracted from the specified
     * {@code String} when parsed with the radix given by the second argument. The first argument is
     * interpreted as representing a signed integer in the radix specified by the second argument,
     * exactly as if the arguments were given to the {@link #parseInt(java.lang.String, int)}
     * method. The result is an {@code Integer} object that represents the integer value specified
     * by the string.
     * </p>
     * <p>
     * In other words, this method returns an {@code Integer} object equal to the value of:
     * </p>
     * <blockquote> {@code new Integer(Integer.parseInt(s, radix))} </blockquote>
     * 
     * @param value the string to be parsed.
     * @param radix the radix to be used in interpreting {@code s}
     * @return an {@code Integer} object holding the value represented by the string argument in the
     *         specified radix.
     * @exception NumberFormatException if the {@code String} does not contain a parsable
     *                {@code int}.
     */
    public static Integer valueOf(String value, int radix) throws NumberFormatException {
        return valueOf(parseInt(value, radix));
    }

    /**
     * <p>
     * Returns an {@code Integer} instance representing the specified {@code int} value. If a new
     * {@code Integer} instance is not required, this method should generally be used in preference
     * to the constructor {@link #Integer(int)}, as this method is likely to yield significantly
     * better space and time performance by caching frequently requested values. This method will
     * always cache values in the range -128 to 127, inclusive, and may cache other values outside
     * of this range.
     * </p>
     * 
     * @param value an {@code int} value.
     * @return an {@code Integer} instance representing {@code i}.
     * @since 1.5
     */
    public static Integer valueOf(int value) {
        return (Integer) (Object) new JSInteger(value);
    }

    /**
     * Returns the value obtained by reversing the order of the bytes in the two's complement
     * representation of the specified {@code int} value.
     * 
     * @return the value obtained by reversing the bytes in the specified {@code int} value.
     * @since 1.5
     */
    public static int reverseBytes(int value) {
        return ((value >>> 24)) | ((value >> 8) & 0xFF00) | ((value << 8) & 0xFF0000) | ((value << 24));
    }

    /**
     * Returns a string representation of the integer argument as an unsigned integer in
     * base&nbsp;2.
     * <p>
     * The unsigned integer value is the argument plus 2<sup>32</sup> if the argument is negative;
     * otherwise it is equal to the argument. This value is converted to a string of ASCII digits in
     * binary (base&nbsp;2) with no extra leading {@code 0}s. If the unsigned magnitude is zero, it
     * is represented by a single zero character {@code '0'} (<code>'&#92;u0030'</code>); otherwise,
     * the first character of the representation of the unsigned magnitude will not be the zero
     * character. The characters {@code '0'} (<code>'&#92;u0030'</code>) and {@code '1'} (
     * <code>'&#92;u0031'</code>) are used as binary digits.
     * 
     * @param value an integer to be converted to a string.
     * @return the string representation of the unsigned integer value represented by the argument
     *         in binary (base&nbsp;2).
     */
    public static String toBinaryString(int value) {
        return toString(value, 2);
    }

    /**
     * Returns a string representation of the integer argument as an unsigned integer in
     * base&nbsp;16.
     * <p>
     * The unsigned integer value is the argument plus 2<sup>32</sup> if the argument is negative;
     * otherwise, it is equal to the argument. This value is converted to a string of ASCII digits
     * in hexadecimal (base&nbsp;16) with no extra leading {@code 0}s. If the unsigned magnitude is
     * zero, it is represented by a single zero character {@code '0'} (<code>'&#92;u0030'</code>);
     * otherwise, the first character of the representation of the unsigned magnitude will not be
     * the zero character. The following characters are used as hexadecimal digits: <blockquote>
     * {@code 0123456789abcdef} </blockquote> These are the characters <code>'&#92;u0030'</code>
     * through <code>'&#92;u0039'</code> and <code>'&#92;u0061'</code> through
     * <code>'&#92;u0066'</code>. If uppercase letters are desired, the
     * {@link java.lang.String#toUpperCase()} method may be called on the result: <blockquote>
     * {@code Integer.toHexString(n).toUpperCase()} </blockquote>
     * 
     * @param value an integer to be converted to a string.
     * @return the string representation of the unsigned integer value represented by the argument
     *         in hexadecimal (base&nbsp;16).
     */
    public static String toHexString(int value) {
        return toString(value, 16);
    }

    /**
     * Returns a {@code String} object representing the specified integer. The argument is converted
     * to signed decimal representation and returned as a string, exactly as if the argument and
     * radix 10 were given as arguments to the {@link #toString(int, int)} method.
     * 
     * @param value an integer to be converted.
     * @return a string representation of the argument in base&nbsp;10.
     */
    public static String toString(int value) {
        return valueOf(value).toString();
    }

    /**
     * Returns a string representation of the first argument in the radix specified by the second
     * argument.
     * <p>
     * If the radix is smaller than {@code Character.MIN_RADIX} or larger than
     * {@code Character.MAX_RADIX}, then the radix {@code 10} is used instead.
     * <p>
     * If the first argument is negative, the first element of the result is the ASCII minus
     * character {@code '-'} (<code>'&#92;u002D'</code>). If the first argument is not negative, no
     * sign character appears in the result.
     * <p>
     * The remaining characters of the result represent the magnitude of the first argument. If the
     * magnitude is zero, it is represented by a single zero character {@code '0'} (
     * <code>'&#92;u0030'</code>); otherwise, the first character of the representation of the
     * magnitude will not be the zero character. The following ASCII characters are used as digits:
     * <blockquote> {@code 0123456789abcdefghijklmnopqrstuvwxyz} </blockquote> These are
     * <code>'&#92;u0030'</code> through <code>'&#92;u0039'</code> and <code>'&#92;u0061'</code>
     * through <code>'&#92;u007A'</code>. If {@code radix} is <var>N</var>, then the first
     * <var>N</var> of these characters are used as radix-<var>N</var> digits in the order shown.
     * Thus, the digits for hexadecimal (radix 16) are {@code 0123456789abcdef}. If uppercase
     * letters are desired, the {@link java.lang.String#toUpperCase()} method may be called on the
     * result: <blockquote> {@code Integer.toString(n, 16).toUpperCase()} </blockquote>
     * 
     * @param value an integer to be converted to a string.
     * @param radix the radix to use in the string representation.
     * @return a string representation of the argument in the specified radix.
     * @see java.lang.Character#MAX_RADIX
     * @see java.lang.Character#MIN_RADIX
     */
    public static String toString(int value, int radix) {
        return new NativeNumber(value).toString(radix);
    }

    /**
     * Converts the argument to a {@code long} by an unsigned conversion. In an unsigned conversion
     * to a {@code long}, the high-order 32 bits of the {@code long} are zero and the low-order 32
     * bits are equal to the bits of the integer argument. Consequently, zero and positive
     * {@code int} values are mapped to a numerically equal {@code long} value and negative
     * {@code int} values are mapped to a {@code long} value equal to the input plus 2<sup>32</sup>.
     * 
     * @param x the value to convert to an unsigned {@code long}
     * @return the argument converted to {@code long} by an unsigned conversion
     * @since 1.8
     */
    public static long toUnsignedLong(int x) {
        return ((long) x) & 0xffffffffL;
    }

    /**
     * @version 2013/04/16 22:57:09
     */
    @JavaAPIProvider(int.class)
    private static class Primitive {
    }
}
