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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import booton.translator.Translator;

/**
 * @version 2013/08/27 14:51:37
 */
public class NativeRegExp extends NativeObject {

    /** The actual pattern. */
    private final Pattern pattern;

    /**
     * <p>
     * Creates a regular expression object for matching text with a pattern.
     * </p>
     * 
     * @param pattern The text of the regular expression.
     */
    public NativeRegExp(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     * <p>
     * Creates a regular expression object for matching text with a pattern.
     * </p>
     * 
     * @param pattern The text of the regular expression.
     * @param flags If specified, flags can have any combination of the "g", "i" or "m".
     */
    public NativeRegExp(String pattern, String flags) {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     * <p>
     * Executes a search for a match in its string parameter.
     * </p>
     * 
     * @param text The string against which to match the regular expression.
     * @return
     */
    public Result exec(CharSequence text) {
        return null;
    }

    /**
     * <p>
     * A read-only property that contains the text of the pattern, excluding the forward slashes.
     * </p>
     */
    public String source() {
        return pattern.pattern();
    }

    /**
     * @version 2013/08/27 14:58:58
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeRegExp> {
    
        /**
         * <p>
         * Creates a regular expression object for matching text with a pattern.
         * </p>
         * 
         * @param pattern The text of the regular expression.
         */
        public String NativeRegExp(String pattern) {
            return "new RegExp(" + param(0) + ")";
        }
    
        /**
         * <p>
         * Creates a regular expression object for matching text with a pattern.
         * </p>
         * 
         * @param pattern The text of the regular expression.
         * @param flags If specified, flags can have any combination of the "g", "i" or "m".
         */
        public String NativeRegExp(String pattern, String flags) {
            return "new RegExp(" + param(0) + "," + param(1) + ")";
        }
    
        /**
         * <p>
         * A read-only property that contains the text of the pattern, excluding the forward
         * slashes.
         * </p>
         */
        public String source() {
            return that + ".source";
        }
    
        /**
         * <p>
         * Executes a search for a match in its string parameter.
         * </p>
         * 
         * @param text The string against which to match the regular expression.
         * @return
         */
        public String exec(CharSequence text) {
            return that + ".exec(" + param(0) + ")";
        }
    }

    /**
     * @version 2013/08/27 14:56:12
     */
    public static class Result extends NativeObject {

        /** The actual {@link Matcher}. */
        private final Matcher matcher;

        /**
         * @param matcher
         */
        private Result(Matcher matcher) {
            this.matcher = matcher;
        }

        /**
         * <p>
         * The length of parenthesized substring matches.
         * </p>
         * 
         * @return
         */
        public int length() {
            return matcher.groupCount();
        }

        /**
         * <p>
         * The parenthesized substring matches, if any. The number of possible parenthesized
         * substrings is unlimited.
         * </p>
         * 
         * @param index
         * @return
         */
        public String group(int index) {
            return matcher.group(index);
        }

        /**
         * @version 2013/08/27 16:01:38
         */
        @SuppressWarnings("unused")
        private static class Coder extends Translator<Result> {

            /**
             * <p>
             * The length of parenthesized substring matches.
             * </p>
             * 
             * @return
             */
            public String length() {
                return that + ".length";
            }

            /**
             * <p>
             * The parenthesized substring matches, if any. The number of possible parenthesized
             * substrings is unlimited.
             * </p>
             * 
             * @param index
             * @return
             */
            public String group(int index) {
                return that + "[" + param(0) + "]";
            }
        }
    }
}
