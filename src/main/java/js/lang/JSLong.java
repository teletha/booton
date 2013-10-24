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
