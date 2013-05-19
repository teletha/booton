/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2013/04/15 16:19:02
 */
class StringCoder extends Translator<String> {

    /**
     * <p>
     * Initializes a newly created {@code String} object so that it represents an empty character
     * sequence. Note that use of this constructor is unnecessary since Strings are immutable.
     * </p>
     */
    public String String() {
        return Q + Q;
    }

    /**
     * <p>
     * Initializes a newly created {@code String} object so that it represents the same sequence of
     * characters as the argument; in other words, the newly created string is a copy of the
     * argument string. Unless an explicit copy of {@code original} is needed, use of this
     * constructor is unnecessary since Strings are immutable.
     * </p>
     * 
     * @param original A {@code String}
     */
    public String String(String value) {
        return param(0);
    }

    /**
     * <p>
     * Allocates a new {@code String} so that it represents the sequence of characters currently
     * contained in the character array argument. The contents of the character array are copied;
     * subsequent modification of the character array does not affect the newly created string.
     * </p>
     * 
     * @param value The initial value of the string
     */
    public String String(char[] value) {
        return param(0) + ".join(" + Q + Q + ")";
    }

    /**
     * <p>
     * Allocates a new {@code String} that contains characters from a subarray of the character
     * array argument. The {@code offset} argument is the index of the first character of the
     * subarray and the {@code count} argument specifies the length of the subarray. The contents of
     * the subarray are copied; subsequent modification of the character array does not affect the
     * newly created string.
     * </p>
     * 
     * @param value Array that is the source of characters
     * @param offset The initial offset
     * @param count The length
     * @throws IndexOutOfBoundsException If the {@code offset} and {@code count} arguments index
     *             characters outside the bounds of the {@code value} array
     */
    public String String(char[] value, int offset, int count) {
        return param(0) + ".slice(" + param(1) + "," + param(1) + "+" + param(2) + ").join(" + Q + Q + ")";
    }

    /**
     * Constructs a new {@code String} by decoding the specified subarray of bytes using the
     * platform's default charset. The length of the new {@code String} is a function of the
     * charset, and hence may not be equal to the length of the subarray.
     * <p>
     * The behavior of this constructor when the given bytes are not valid in the default charset is
     * unspecified. The {@link java.nio.charset.CharsetDecoder} class should be used when more
     * control over the decoding process is required.
     * 
     * @param bytes The bytes to be decoded into characters
     * @param offset The index of the first byte to decode
     * @param length The number of bytes to decode
     * @throws IndexOutOfBoundsException If the {@code offset} and the {@code length} arguments
     *             index characters outside the bounds of the {@code bytes} array
     * @since JDK1.1
     */
    public String String(byte bytes[], int offset, int length) {
        return param(0) + ".slice(" + param(1) + "," + param(1) + "+" + param(2) + ").join(" + Q + Q + ")";
    }

    /**
     * Javascript native String class have length property instead of length method. And Javascript
     * manages object as hash, so object can't have same name method or property. We must convert
     * invoking java.lang.String#length() method to the accessing length property.
     */
    public String length() {
        return that + ".length";
    }

    public String charAt(int index) throws Exception {
        Class type = Class.forName("js.lang.JSChar");
        Javascript.require(type);

        return "new " + Javascript.computeClassName(type) + "(" + that + ".charAt(" + param(0) + "), 0)";
    }

    public String contains(CharSequence param0) {
        return that + ".indexOf(" + param(0) + ") != -1";
    }

    public String indexOf(int value) {
        return that + ".indexOf(" + param(0) + ")";
    }

    public String indexOf(String value) {
        return that + ".indexOf(" + param(0) + ")";
    }

    public String lastIndexOf(String value) {
        return that + ".lastIndexOf(" + param(0) + ")";
    }

    public String lastIndexOf(int value) {
        return that + ".lastIndexOf(" + param(0) + ")";
    }

    public String startsWith(String value) {
        return that + ".startsWith(" + param(0) + ")";
    }

    public String endsWith(String value) {
        return that + ".endsWith(" + param(0) + ")";
    }

    public String concat(String value) {
        return that + ".concat(" + param(0) + ")";
    }

    /**
     * Compares this {@code String} to another {@code String}, ignoring case considerations. Two
     * strings are considered equal ignoring case if they are of the same length and corresponding
     * characters in the two strings are equal ignoring case.
     * <p>
     * Two characters {@code c1} and {@code c2} are considered the same ignoring case if at least
     * one of the following is true:
     * <ul>
     * <li>The two characters are the same (as compared by the {@code ==} operator)
     * <li>Applying the method {@link java.lang.Character#toUpperCase(char)} to each character
     * produces the same result
     * <li>Applying the method {@link java.lang.Character#toLowerCase(char)} to each character
     * produces the same result
     * </ul>
     * 
     * @param anotherString The {@code String} to compare this {@code String} against
     * @return {@code true} if the argument is not {@code null} and it represents an equivalent
     *         {@code String} ignoring case; {@code false} otherwise
     * @see #equals(Object)
     */
    public String equalsIgnoreCase(String anotherString) {
        return that + ".toLowerCase().equals(" + param(0) + ".toLowerCase())";
    }

    /**
     * <p>
     * Converts this string to a new character array.
     * </p>
     * 
     * @return a newly allocated character array whose length is the length of this string and whose
     *         contents are initialized to contain the character sequence represented by this
     *         string.
     */
    public String toCharArray() {
        return that + ".split(+Q + Q+)";
    }

    public String toLowerCase() {
        return that + ".toLowerCase()";
    }

    public String toUpperCase() {
        return that + ".toUpperCase()";
    }

    public String intern() {
        return that;
    }

    public String isEmpty() {
        return that + ".length==0";
    }

    public String trim() {
        return that + ".trim()";
    }

    public String replace(char oldChar, char newChar) {
        return that + ".replace(" + regex(0, "g") + "," + param(1) + ")";
    }

    public String replace(CharSequence regex, CharSequence replace) {
        return that + ".replace(" + regex(0, "g") + "," + param(1) + ")";
    }

    public String replaceAll(String regex, String replacement) {
        return that + ".replace(" + regex(0, "g") + "," + param(1) + ")";
    }

    public String replaceFirst(String regex, String replacement) {
        return that + ".replace(" + regex(0) + "," + param(1) + ")";
    }

    public String codePointAt(int index) {
        return that + ".charCodeAt(" + param(0) + ")";
    }

    public String codePointBefore(int index) {
        return that + ".charCodeAt(" + param(0) + "-1)";
    }

    public String split(String param0) {
        return that + ".split(" + regex(0) + ")";
    }

    public String substring(int start) {
        return that + ".substring(" + param(0) + ")";
    }

    public String substring(int start, int end) {
        return that + ".substring(" + param(0) + "," + param(1) + ")";
    }

    /**
     * <p>
     * Returns the string representation of the <code>Object</code> argument.
     * </p>
     * 
     * @param obj an <code>Object</code>.
     * @return if the argument is <code>null</code>, then a string equal to <code>"null"</code>;
     *         otherwise, the value of <code>obj.toString()</code> is returned.
     * @see java.lang.Object#toString()
     */
    public String valueOf(Object value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the int argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(int value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the long argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(long value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the float argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(float value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the double argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(double value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the boolean argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(boolean value) {
        return Q + Q + "+" + param(0);
    }

    /**
     * <p>
     * Returns the string representation of the char argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(char value) {
        return param(0);
    }

    /**
     * <p>
     * Returns the string representation of the char array argument.
     * </p>
     * 
     * @param value A value to parse.
     * @return A compiled expression.
     */
    public String valueOf(char[] value) {
        return param(0) + ".join()";
    }
}
