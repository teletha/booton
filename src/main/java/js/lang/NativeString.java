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

import java.util.ArrayList;
import java.util.List;

import booton.translator.Translator;

/**
 * @version 2013/08/15 23:03:12
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
     * 
     */
    public NativeString(char c) {
        builder.append(c);
    }

    /**
     * 
     */
    public NativeString(char[] text) {
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
     * Returns the index within the calling String object of the first occurrence of the specified
     * value, starting the search at fromIndex, returns -1 if the value is not found.
     * </p>
     * 
     * @param text A string representing the value to search for.
     * @return
     */
    public int indexOf(String text) {
        return builder.indexOf(text);
    }

    /**
     * <p>
     * Returns the index within the calling String object of the first occurrence of the specified
     * value, starting the search at fromIndex, returns -1 if the value is not found.
     * </p>
     * 
     * @param text A string representing the value to search for.
     * @param fromIndex omIndex The location within the calling string to start the search from. It
     *            can be any integer between 0 and the length of the string. The default value is 0.
     * @return
     */
    public int indexOf(String text, int fromIndex) {
        return builder.indexOf(text, fromIndex);
    }

    /**
     * <p>
     * Returns the index within the calling String object of the last occurrence of the specified
     * value, or -1 if not found. The calling string is searched backward, starting at fromIndex.
     * </p>
     * 
     * @param text A string representing the value to search for.
     * @return
     */
    public int lastIndexOf(String text) {
        return builder.lastIndexOf(text);
    }

    /**
     * <p>
     * Returns the index within the calling String object of the last occurrence of the specified
     * value, or -1 if not found. The calling string is searched backward, starting at fromIndex.
     * </p>
     * 
     * @param text A string representing the value to search for.
     * @param from The location within the calling string to start the search from, indexed from
     *            left to right. It can be any integer between 0 and the length of the string. The
     *            default value is the length of the string.
     * @return
     */
    public int lastIndexOf(String text, int from) {
        return builder.lastIndexOf(text, from);
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
     * <p>
     * Returns a number indicating whether a reference string comes before or after or is the same
     * as the given string in sort order. The new locales and options arguments let applications
     * specify the language whose sort order should be used and customize the behavior of the
     * function. In older implementations, which ignore the locales and options arguments, the
     * locale and sort order used are entirely implementation dependent.
     * </p>
     * 
     * @param object The string against which the referring string is comparing.
     * @return A result.
     */
    public int localeCompare(String object) {
        return builder.toString().compareTo(object);
    }

    /**
     * <pReturns a new string with some or all matches of a pattern replaced by a replacement. The
     * pattern can be a string or a RegExp, and the replacement can be a string or a function to be
     * called for each match.
     * 
     * @param target A RegExp object. The match is replaced by the return value of parameter #2.
     * @param replacement The String that replaces the substring received from parameter #1. A
     *            number of special replacement patterns are supported; see the
     *            "Specifying a string as a parameter" section below.
     * @return
     */
    public NativeString replace(char target, char replacement) {
        return new NativeString(builder.toString().replace(target, replacement));
    }

    /**
     * <pReturns a new string with some or all matches of a pattern replaced by a replacement. The
     * pattern can be a string or a RegExp, and the replacement can be a string or a function to be
     * called for each match.
     * 
     * @param regex A RegExp object. The match is replaced by the return value of parameter #2.
     * @param replacement The String that replaces the substring received from parameter #1. A
     *            number of special replacement patterns are supported; see the
     *            "Specifying a string as a parameter" section below.
     * @return
     */
    public NativeString replace(CharSequence regex, CharSequence replacement) {
        return new NativeString(builder.toString().replace(regex, replacement));
    }

    /**
     * <pReturns a new string with some or all matches of a pattern replaced by a replacement. The
     * pattern can be a string or a RegExp, and the replacement can be a string or a function to be
     * called for each match.
     * 
     * @param regex A RegExp object. The match is replaced by the return value of parameter #2.
     * @param replacement The String that replaces the substring received from parameter #1. A
     *            number of special replacement patterns are supported; see the
     *            "Specifying a string as a parameter" section below.
     * @return
     */
    public NativeString replaceFirst(String regex, String replacement) {
        return new NativeString(builder.toString().replaceFirst(regex, replacement));
    }

    /**
     * <p>
     * Splits a String object into an array of strings by separating the string into substrings.
     * </p>
     * 
     * @param separator Specifies the character(s) to use for separating the string. The separator
     *            is treated as a string or a regular expression. If separator is omitted, the array
     *            returned contains one element consisting of the entire string.
     * @return
     */
    public NativeString[] split(String separator) {
        List<NativeString> list = new ArrayList();

        for (String text : builder.toString().split(separator)) {
            list.add(new NativeString(text));
        }
        return list.toArray(new NativeString[list.size()]);
    }

    /**
     * <p>
     * Splits a String object into an array of strings by separating the string into substrings.
     * </p>
     * 
     * @param separator Specifies the character(s) to use for separating the string. The separator
     *            is treated as a string or a regular expression. If separator is omitted, the array
     *            returned contains one element consisting of the entire string.
     * @return
     */
    public NativeString[] split(NativeRegExp separator) {
        List<NativeString> list = new ArrayList();

        for (String text : builder.toString().split(separator.source())) {
            list.add(new NativeString(text));
        }
        return list.toArray(new NativeString[list.size()]);
    }

    /**
     * <p>
     * Splits a String object into an array of strings by separating the string into substrings.
     * </p>
     * 
     * @param separator Specifies the character(s) to use for separating the string. The separator
     *            is treated as a string or a regular expression. If separator is omitted, the array
     *            returned contains one element consisting of the entire string.
     * @param limit Integer specifying a limit on the number of splits to be found. The split method
     *            still splits on every match of separator, but it truncates the returned array to
     *            at most limit elements.
     * @return
     */
    public NativeString[] split(String separator, int limit) {
        List<NativeString> list = new ArrayList();

        for (String text : builder.toString().split(separator, limit)) {
            list.add(new NativeString(text));
        }
        return list.toArray(new NativeString[list.size()]);
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
     * Returns the calling string value converted to uppercase.
     * </p>
     * 
     * @return
     */
    public NativeString toUpperCase() {
        return new NativeString(builder.toString().toUpperCase());
    }

    /**
     * <p>
     * Returns the calling string value converted to lowercase.
     * </p>
     * 
     * @return
     */
    public NativeString toLowerCase() {
        return new NativeString(builder.toString().toLowerCase());
    }

    /**
     * <p>
     * Removes whitespace from both ends of the string.
     * </p>
     * 
     * @return
     */
    public NativeString trim() {
        return new NativeString(builder.toString().trim());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }

    /**
     * <p>
     * Returns a string created by using the specified sequence of Unicode values.
     * </p>
     * 
     * @param codes A sequence of numbers that are Unicode values.
     * @return
     */
    public static NativeString fromCharCode(int... codes) {
        return new NativeString(String.valueOf(codes));
    }

    /**
     * @version 2013/08/15 20:15:40
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
         * 
         */
        public String NativeString(char c) {
            return param(0);
        }

        /**
         * 
         */
        public String NativeString(char[] text) {
            return param(0) + ".join(" + Q + Q + ")";
        }

        /**
         * 
         */
        public String NativeString(String text) {
            return param(0);
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
         * Returns the index within the calling String object of the first occurrence of the
         * specified value, starting the search at fromIndex, returns -1 if the value is not found.
         * </p>
         * 
         * @param text A string representing the value to search for.
         * @return
         */
        public String indexOf(String text) {
            return that + ".indexOf(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the index within the calling String object of the first occurrence of the
         * specified value, starting the search at fromIndex, returns -1 if the value is not found.
         * </p>
         * 
         * @param text A string representing the value to search for.
         * @param fromIndex omIndex The location within the calling string to start the search from.
         *            It can be any integer between 0 and the length of the string. The default
         *            value is 0.
         * @return
         */
        public String indexOf(String text, int fromIndex) {
            return that + ".indexOf(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Returns the index within the calling String object of the last occurrence of the
         * specified value, or -1 if not found. The calling string is searched backward, starting at
         * fromIndex.
         * </p>
         * 
         * @param text A string representing the value to search for.
         * @return
         */
        public String lastIndexOf(String text) {
            return that + ".lastIndexOf(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the index within the calling String object of the last occurrence of the
         * specified value, or -1 if not found. The calling string is searched backward, starting at
         * fromIndex.
         * </p>
         * 
         * @param text A string representing the value to search for.
         * @param from The location within the calling string to start the search from, indexed from
         *            left to right. It can be any integer between 0 and the length of the string.
         *            The default value is the length of the string.
         * @return
         */
        public String lastIndexOf(String text, int from) {
            return that + ".lastIndexOf(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Returns a number indicating whether a reference string comes before or after or is the
         * same as the given string in sort order. The new locales and options arguments let
         * applications specify the language whose sort order should be used and customize the
         * behavior of the function. In older implementations, which ignore the locales and options
         * arguments, the locale and sort order used are entirely implementation dependent.
         * </p>
         * 
         * @param object The string against which the referring string is comparing.
         * @return A result.
         */
        public String localeCompare(String object) {
            return that + ".localeCompare(" + param(0) + ")";
        }

        /**
         * <pReturns a new string with some or all matches of a pattern replaced by a replacement.
         * The pattern can be a string or a RegExp, and the replacement can be a string or a
         * function to be called for each match.
         * 
         * @param target A RegExp object. The match is replaced by the return value of parameter #2.
         * @param replacement The String that replaces the substring received from parameter #1. A
         *            number of special replacement patterns are supported; see the
         *            "Specifying a string as a parameter" section below.
         * @return
         */
        public String replace(char target, char replacement) {
            return that + ".replace(" + regex(0, "g") + "," + param(1) + ")";
        }

        /**
         * <pReturns a new string with some or all matches of a pattern replaced by a replacement.
         * The pattern can be a string or a RegExp, and the replacement can be a string or a
         * function to be called for each match.
         * 
         * @param regex A RegExp object. The match is replaced by the return value of parameter #2.
         * @param replacement The String that replaces the substring received from parameter #1. A
         *            number of special replacement patterns are supported; see the
         *            "Specifying a string as a parameter" section below.
         * @return
         */
        public String replace(CharSequence regex, CharSequence replacement) {
            return that + ".replace(" + regex(0, "g") + "," + param(1) + ")";
        }

        /**
         * <pReturns a new string with some or all matches of a pattern replaced by a replacement.
         * The pattern can be a string or a RegExp, and the replacement can be a string or a
         * function to be called for each match.
         * 
         * @param regex A RegExp object. The match is replaced by the return value of parameter #2.
         * @param replacement The String that replaces the substring received from parameter #1. A
         *            number of special replacement patterns are supported; see the
         *            "Specifying a string as a parameter" section below.
         * @return
         */
        public String replaceFirst(String regex, String replacement) {
            return that + ".replace(" + regex(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Splits a String object into an array of strings by separating the string into substrings.
         * </p>
         * 
         * @param separator Specifies the character(s) to use for separating the string. The
         *            separator is treated as a string or a regular expression. If separator is
         *            omitted, the array returned contains one element consisting of the entire
         *            string.
         * @return
         */
        public String split(String separator) {
            return that + ".split(" + param(0) + ")";
        }

        /**
         * <p>
         * Splits a String object into an array of strings by separating the string into substrings.
         * </p>
         * 
         * @param separator Specifies the character(s) to use for separating the string. The
         *            separator is treated as a string or a regular expression. If separator is
         *            omitted, the array returned contains one element consisting of the entire
         *            string.
         * @return
         */
        public String split(NativeRegExp separator) {
            return that + ".split(" + param(0) + ")";
        }

        /**
         * <p>
         * Splits a String object into an array of strings by separating the string into substrings.
         * </p>
         * 
         * @param separator Specifies the character(s) to use for separating the string. The
         *            separator is treated as a string or a regular expression. If separator is
         *            omitted, the array returned contains one element consisting of the entire
         *            string.
         * @param limit Integer specifying a limit on the number of splits to be found. The split
         *            method still splits on every match of separator, but it truncates the returned
         *            array to at most limit elements.
         * @return
         */
        public String split(String separator, int limit) {
            return that + ".split(" + param(0) + "," + param(1) + ")";
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
         * Returns the calling string value converted to uppercase.
         * </p>
         * 
         * @return
         */
        public String toUpperCase() {
            return that + ".toUpperCase()";
        }

        /**
         * <p>
         * Returns the calling string value converted to lowercase.
         * </p>
         * 
         * @return
         */
        public String toLowerCase() {
            return that + ".toLowerCase()";
        }

        /**
         * <p>
         * Removes whitespace from both ends of the string.
         * </p>
         * 
         * @return
         */
        public String trim() {
            return that + ".trim()";
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

        /**
         * <p>
         * Returns a string created by using the specified sequence of Unicode values.
         * </p>
         * 
         * @param codes A sequence of numbers that are Unicode values.
         * @return
         */
        public String fromCharCode(int... codes) {
            return "String.fromCharCode(" + param(0) + ")";
        }
    }
}
