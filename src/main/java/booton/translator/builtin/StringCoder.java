/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2013/08/17 18:55:24
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
        return Javascript.writeMethodCode(String.class, "valueOf", char[].class, param(0));
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
        return Javascript.writeMethodCode(String.class, "valueOf", char[].class, param(0), int.class, param(1), int.class, param(2));
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
     * Returns a canonical representation for the string object.
     * <p>
     * A pool of strings, initially empty, is maintained privately by the class <code>String</code>.
     * <p>
     * When the intern method is invoked, if the pool already contains a string equal to this
     * <code>String</code> object as determined by the {@link #equals(Object)} method, then the
     * string from the pool is returned. Otherwise, this <code>String</code> object is added to the
     * pool and a reference to this <code>String</code> object is returned.
     * <p>
     * It follows that for any two strings <code>s</code> and <code>t</code>,
     * <code>s.intern()&nbsp;==&nbsp;t.intern()</code> is <code>true</code> if and only if
     * <code>s.equals(t)</code> is <code>true</code>.
     * <p>
     * All literal strings and string-valued constant expressions are interned. String literals are
     * defined in section 3.10.5 of the <cite>The Java&trade; Language Specification</cite>.
     * 
     * @return a string that has the same contents as this string, but is guaranteed to be from a
     *         pool of unique strings.
     */
    public String intern() {
        return that;
    }

    /**
     * Javascript native String class have length property instead of length method. And Javascript
     * manages object as hash, so object can't have same name method or property. We must convert
     * invoking java.lang.String#length() method to the accessing length property.
     */
    public String length() {
        return that + ".length";
    }
}
