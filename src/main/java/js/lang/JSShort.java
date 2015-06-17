/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * {@link Short} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Short.class)
class JSShort extends JSNumber {

    /** The primitive short class. */
    public static final Class TYPE = Primitive.class;

    /**
     * Constructs a newly allocated {@code Short} object that represents the specified {@code short}
     * value.
     * 
     * @param value the value to be represented by the {@code Short}.
     */
    public JSShort(short value) {
        super(value);
    }

    /**
     * Constructs a newly allocated {@code Short} object that represents the {@code short} value
     * indicated by the {@code String} parameter. The string is converted to a {@code short} value
     * in exactly the manner used by the {@code parseShort} method for radix 10.
     * 
     * @param value the {@code String} to be converted to a {@code Short}
     * @throws NumberFormatException If the {@code String} does not contain a parsable {@code short}
     *             .
     * @see java.lang.Short#parseShort(java.lang.String, int)
     */
    public JSShort(String value) throws NumberFormatException {
        super(parseShort(value));
    }

    /**
     * Parses the string argument as a signed decimal {@code short}. The characters in the string
     * must all be decimal digits, except that the first character may be an ASCII minus sign
     * {@code '-'} (<code>'&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign
     * {@code '+'} (<code>'&#92;u002B'</code>) to indicate a positive value. The resulting
     * {@code short} value is returned, exactly as if the argument and the radix 10 were given as
     * arguments to the {@link #parseShort(java.lang.String, int)} method.
     * 
     * @param value a {@code String} containing the {@code short} representation to be parsed
     * @return the {@code short} value represented by the argument in decimal.
     * @throws NumberFormatException If the string does not contain a parsable {@code short}.
     */
    public static short parseShort(String value) throws NumberFormatException {
        return parseShort(value, 10);
    }

    /**
     * Parses the string argument as a signed {@code short} in the radix specified by the second
     * argument. The characters in the string must all be digits, of the specified radix (as
     * determined by whether {@link java.lang.Character#digit(char, int)} returns a nonnegative
     * value) except that the first character may be an ASCII minus sign {@code '-'} (
     * <code>'&#92;u002D'</code>) to indicate a negative value or an ASCII plus sign {@code '+'} (
     * <code>'&#92;u002B'</code>) to indicate a positive value. The resulting {@code short} value is
     * returned.
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
     * <li>The value represented by the string is not a value of type {@code short}.
     * </ul>
     * 
     * @param value the {@code String} containing the {@code short} representation to be parsed
     * @param radix the radix to be used while parsing {@code s}
     * @return the {@code short} represented by the string argument in the specified radix.
     * @throws NumberFormatException If the {@code String} does not contain a parsable {@code short}
     *             .
     */
    public static short parseShort(String value, int radix) throws NumberFormatException {
        int parsed = Global.parseInt(value, radix);

        if (Global.isNaN(parsed)) {
            throw new NumberFormatException(value + " is not a number.");
        }
        return (short) parsed;
    }

    /**
     * Returns the value obtained by reversing the order of the bytes in the two's complement
     * representation of the specified {@code short} value.
     * 
     * @return the value obtained by reversing (or, equivalently, swapping) the bytes in the
     *         specified {@code short} value.
     * @since 1.5
     */
    public static short reverseBytes(short value) {
        return (short) (((value & 0xFF00) >> 8) | (value << 8));
    }

    /**
     * Returns a {@code Short} object holding the value given by the specified {@code String}. The
     * argument is interpreted as representing a signed decimal {@code short}, exactly as if the
     * argument were given to the {@link #parseShort(java.lang.String)} method. The result is a
     * {@code Short} object that represents the {@code short} value specified by the string.
     * <p>
     * In other words, this method returns a {@code Short} object equal to the value of:
     * <blockquote> {@code new Short(Short.parseShort(s))} </blockquote>
     * 
     * @param value the string to be parsed
     * @return a {@code Short} object holding the value represented by the string argument
     * @throws NumberFormatException If the {@code String} does not contain a parsable {@code short}
     *             .
     */
    public static Short valueOf(String value) throws NumberFormatException {
        return valueOf(value);
    }

    /**
     * Returns a {@code Short} object holding the value extracted from the specified {@code String}
     * when parsed with the radix given by the second argument. The first argument is interpreted as
     * representing a signed {@code short} in the radix specified by the second argument, exactly as
     * if the argument were given to the {@link #parseShort(java.lang.String, int)} method. The
     * result is a {@code Short} object that represents the {@code short} value specified by the
     * string.
     * <p>
     * In other words, this method returns a {@code Short} object equal to the value of:
     * <blockquote> {@code new Short(Short.parseShort(s, radix))} </blockquote>
     * 
     * @param value the string to be parsed
     * @param radix the radix to be used in interpreting {@code s}
     * @return a {@code Short} object holding the value represented by the string argument in the
     *         specified radix.
     * @throws NumberFormatException If the {@code String} does not contain a parsable {@code short}
     *             .
     */
    public static Short valueOf(String value, int radix) {
        return valueOf(parseShort(value, radix));
    }

    /**
     * Returns a {@code Short} instance representing the specified {@code short} value. If a new
     * {@code Short} instance is not required, this method should generally be used in preference to
     * the constructor {@link #Short(short)}, as this method is likely to yield significantly better
     * space and time performance by caching frequently requested values. This method will always
     * cache values in the range -128 to 127, inclusive, and may cache other values outside of this
     * range.
     * 
     * @param value a short value.
     * @return a {@code Short} instance representing {@code s}.
     * @since 1.5
     */
    public static Short valueOf(short value) {
        return (Short) (Object) new JSShort(value);
    }

    /**
     * @version 2013/04/16 23:01:24
     */
    @JavaAPIProvider(short.class)
    private static class Primitive {
    }
}
