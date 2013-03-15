/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2012/12/09 0:23:19
 */
public class IntegerCoder extends Translator<Integer> {

    public String valueOf(int param0) {
        return param(0);
    }

    public String intValue() {
        return that;
    }

    /**
     * Parses the string argument as a signed decimal integer. The characters in the string must all
     * be decimal digits, except that the first character may be an ASCII minus sign {@code '-'} (
     * <code>'&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign {@code '+'} (
     * <code>'&#92;u002B'</code>) to indicate a positive value. The resulting integer value is
     * returned, exactly as if the argument and the radix 10 were given as arguments to the
     * {@link #parseInt(java.lang.String, int)} method.
     * 
     * @param s a {@code String} containing the {@code int} representation to be parsed
     * @return the integer value represented by the argument in decimal.
     * @exception NumberFormatException if the string does not contain a parsable integer.
     */
    public String parseInt(String param0) {
        return "parseInt(" + param(0) + ")";
    }

    /**
     * Parses the string argument as a signed integer in the radix specified by the second argument.
     * The characters in the string must all be digits of the specified radix (as determined by
     * whether {@link java.lang.Character#digit(char, int)} returns a nonnegative value), except
     * that the first character may be an ASCII minus sign {@code '-'} (<code>'&#92;u002D'</code>)
     * to indicate a negative value or an ASCII plus sign {@code '+'} (<code>'&#92;u002B'</code>) to
     * indicate a positive value. The resulting integer value is returned.
     * <p>
     * An exception of type {@code NumberFormatException} is thrown if any of the following
     * situations occurs:
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
     * Examples: <blockquote>
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
     * </blockquote>
     * 
     * @param s the {@code String} containing the integer representation to be parsed
     * @param radix the radix to be used while parsing {@code s}.
     * @return the integer represented by the string argument in the specified radix.
     * @exception NumberFormatException if the {@code String} does not contain a parsable
     *                {@code int}.
     */
    public String parseInt(String param0, int param1) {
        return "parseInt(" + param(0) + "," + param(1) + ")";
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
     * @param i an integer to be converted to a string.
     * @return the string representation of the unsigned integer value represented by the argument
     *         in hexadecimal (base&nbsp;16).
     */
    public String toHexString(int param0) {
        return param(0) + ".toString(16)";
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
     * @param i an integer to be converted to a string.
     * @return the string representation of the unsigned integer value represented by the argument
     *         in binary (base&nbsp;2).
     */
    public String toBinaryString(int param0) {
        return param(0) + ".toString(2)";
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
     * @param i an integer to be converted to a string.
     * @param radix the radix to use in the string representation.
     * @return a string representation of the argument in the specified radix.
     * @see java.lang.Character#MAX_RADIX
     * @see java.lang.Character#MIN_RADIX
     */
    public String toString(int param0, int param1) {
        return param(0) + ".toString(" + param(1) + ")";
    }

}
