/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.regex;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import js.lang.NativeRegExp;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/27 15:00:10
 */
@JavaAPIProvider(java.util.regex.Pattern.class)
class Pattern {

    /** The actual regular expression. */
    private final NativeRegExp regex;

    /** The pattern flag. */
    private final int flag;

    /**
     * @param pattern
     * @param flag
     */
    private Pattern(String pattern, int flag) {
        String flagText = "g";

        if ((java.util.regex.Pattern.CASE_INSENSITIVE & flag) != 0 || (java.util.regex.Pattern.UNICODE_CASE & flag) != 0) {
            flagText = flagText.concat("i");
        }

        if ((java.util.regex.Pattern.MULTILINE & flag) != 0) {
            flagText = flagText.concat("m");
        }

        this.regex = new NativeRegExp(pattern, flagText);
        this.flag = flag;
    }

    /**
     * Returns the regular expression from which this pattern was compiled. </p>
     * 
     * @return The source of this pattern
     */
    public String pattern() {
        return regex.source();
    }

    /**
     * Returns this pattern's match flags. </p>
     * 
     * @return The match flags specified when this pattern was compiled
     */
    public int flags() {
        return flag;
    }

    /**
     * Creates a matcher that will match the given input against this pattern. </p>
     * 
     * @param input The character sequence to be matched
     * @return A new matcher for this pattern
     */
    public Matcher matcher(CharSequence input) {
        return (Matcher) (Object) new js.util.regex.Matcher(regex, input);
    }

    /**
     * Compiles the given regular expression into a pattern. </p>
     * 
     * @param regex The expression to be compiled
     * @throws PatternSyntaxException If the expression's syntax is invalid
     */
    public static java.util.regex.Pattern compile(String regex) {
        return compile(regex, 0);
    }

    /**
     * Compiles the given regular expression into a pattern with the given flags. </p>
     * 
     * @param regex The expression to be compiled
     * @param flags Match flags, a bit mask that may include {@link #CASE_INSENSITIVE},
     *            {@link #MULTILINE}, {@link #DOTALL}, {@link #UNICODE_CASE}, {@link #CANON_EQ},
     *            {@link #UNIX_LINES}, {@link #LITERAL}, {@link #UNICODE_CHARACTER_CLASS} and
     *            {@link #COMMENTS}
     * @throws IllegalArgumentException If bit values other than those corresponding to the defined
     *             match flags are set in <tt>flags</tt>
     * @throws PatternSyntaxException If the expression's syntax is invalid
     */
    public static java.util.regex.Pattern compile(String regex, int flags) {
        return (java.util.regex.Pattern) (Object) new Pattern(regex, flags);
    }
}
