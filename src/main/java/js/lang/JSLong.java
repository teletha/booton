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
 * {@link Long} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Long.class)
class JSLong extends JSNumber {

    /** The primitive long class. */
    public static final Class TYPE = Primitive.class;

    /**
     * @param value
     */
    private JSLong(double value) {
        super(value);
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
