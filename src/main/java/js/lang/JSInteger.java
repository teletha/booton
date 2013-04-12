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

import booton.translator.JavaNative;

/**
 * <p>
 * {@link ClasIntegers} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaNative(Integer.class)
class JSInteger {

    /** The actual value. */
    private final NativeNumber value;

    /**
     * @param value
     */
    private JSInteger(int value) {
        this.value = new NativeNumber(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return value.toString();
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

        if (parsed == Double.NaN) {
            throw new NumberFormatException(value + " is not a number.");
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
        return valueOf(parseInt(value, 10));
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
        return new Integer(value);
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
}
