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

import booton.translator.Translator;

/**
 * @version 2013/04/15 18:40:50
 */
class NativeString {

    /** The actual text holder. */
    private final StringBuilder builder = new StringBuilder();

    /**
     * 
     */
    public NativeString() {
    }

    /**
     * 
     */
    public NativeString(String text) {
        builder.append(text);
    }

    /**
     * <p>
     * Characters in a string are indexed from left to right. The index of the first character is 0,
     * and the index of the last character in a string called stringName is stringName.length - 1.
     * If the index you supply is out of range, JavaScript returns an empty string.
     * </p>
     * 
     * @param index An integer between 0 and 1 less than the length of the string.
     * @return A index character.
     */
    public char charAt(int index) {
        return builder.charAt(index);
    }

    /**
     * <p>
     * Returns the numeric Unicode value of the character at the given index (except for unicode
     * codepoints > 0x10000).
     * </p>
     * 
     * @param index An integer greater than or equal to 0 and less than the length of the string; if
     *            it is not a number, it defaults to 0.
     * @return Unicode code points range from 0 to 1,114,111. The first 128 Unicode code points are
     *         a direct match of the ASCII character encoding. For information on Unicode, see the
     *         JavaScript/ Guide.
     */
    public int charCodeAt(int index) {
        return builder.codePointAt(index);
    }

    /**
     * <p>
     * Append text.
     * </p>
     * 
     * @param value
     * @return
     */
    public NativeString concat(String value) {
        builder.append(value);

        return this;
    }

    /**
     * <p>
     * Append text.
     * </p>
     * 
     * @param value
     * @return
     */
    public NativeString concat(NativeString value) {
        builder.append(value);

        return this;
    }

    /**
     * <p>
     * Returns a subset of a string between one index and another, or through the end of the string.
     * </p>
     * 
     * @param start An integer between 0 and the length of the string.
     * @return
     */
    public NativeString substring(int start) {
        return new NativeString(builder.substring(start));
    }

    /**
     * <p>
     * Returns a subset of a string between one index and another, or through the end of the string.
     * </p>
     * 
     * @param start An integer between 0 and the length of the string.
     * @param end An integer between 0 and the length of the string.
     * @return
     */
    public NativeString substring(int start, int end) {
        return new NativeString(builder.substring(start, end));
    }

    /**
     * <p>
     * Count text length.
     * </p>
     * 
     * @return
     */
    public int length() {
        return builder.length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }

    /**
     * @version 2013/04/15 18:41:22
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeString> {

        /**
         * 
         */
        public String NativeString() {
            return Q + Q;
        }

        /**
         * <p>
         * Characters in a string are indexed from left to right. The index of the first character
         * is 0, and the index of the last character in a string called stringName is
         * stringName.length - 1. If the index you supply is out of range, JavaScript returns an
         * empty string.
         * </p>
         * 
         * @param index An integer between 0 and 1 less than the length of the string.
         * @return A index character.
         */
        public String charAt(int index) {
            return that + ".charAt(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the numeric Unicode value of the character at the given index (except for unicode
         * codepoints > 0x10000).
         * </p>
         * 
         * @param index An integer greater than or equal to 0 and less than the length of the
         *            string; if it is not a number, it defaults to 0.
         * @return Unicode code points range from 0 to 1,114,111. The first 128 Unicode code points
         *         are a direct match of the ASCII character encoding. For information on Unicode,
         *         see the JavaScript/ Guide.
         */
        public String charCodeAt(int index) {
            return that + ".charCodeAt(" + param(0) + ")";
        }

        /**
         * <p>
         * Append text.
         * </p>
         * 
         * @param value
         * @return
         */
        public String concat(String value) {
            return that + "+" + param(0);
        }

        /**
         * <p>
         * Append text.
         * </p>
         * 
         * @param value
         * @return
         */
        public String concat(NativeString value) {
            return that + "+" + param(0);
        }

        /**
         * <p>
         * Returns a subset of a string between one index and another, or through the end of the
         * string.
         * </p>
         * 
         * @param start An integer between 0 and the length of the string.
         * @return
         */
        public String substring(int start) {
            return that + ".substring(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns a subset of a string between one index and another, or through the end of the
         * string.
         * </p>
         * 
         * @param start An integer between 0 and the length of the string.
         * @param end An integer between 0 and the length of the string.
         * @return
         */
        public String substring(int start, int end) {
            return that + ".substring(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Count text length.
         * </p>
         * 
         * @return
         */
        public String length() {
            return that + ".length";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return that;
        }
    }
}
