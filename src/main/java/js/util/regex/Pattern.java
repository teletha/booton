/*
 * Copyright (C) 2016 Nameless Production Committee
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

import booton.translator.JavaAPIProvider;
import js.lang.NativeRegExp;
import js.lang.NativeString;

/**
 * @version 2013/08/28 8:38:31
 */
@JavaAPIProvider(java.util.regex.Pattern.class)
class Pattern {

    /** The actual regular expression. */
    final NativeRegExp regex;

    /** The special regular expression. */
    final NativeRegExp head;

    /** The pattern flag. */
    private final int flag;

    /**
     * @param pattern
     * @param flag
     */
    private Pattern(String pattern, int flag) {
        String flagText = "";

        if ((java.util.regex.Pattern.CASE_INSENSITIVE & flag) != 0 || (java.util.regex.Pattern.UNICODE_CASE & flag) != 0) {
            flagText = flagText.concat("i");
        }

        if ((java.util.regex.Pattern.MULTILINE & flag) != 0) {
            flagText = flagText.concat("m");
        }

        this.regex = new NativeRegExp(pattern, flagText.concat("g"));
        this.head = new NativeRegExp("^" + pattern, flagText);
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
        return (Matcher) (Object) new js.util.regex.Matcher(this, input);
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

    /**
     * Compiles the given regular expression and attempts to match the given input against it.
     * <p>
     * An invocation of this convenience method of the form <blockquote>
     * 
     * <pre>
     * Pattern.matches(regex, input);</pre>
     * </blockquote> behaves in exactly the same way as the expression <blockquote>
     * 
     * <pre>
     * Pattern.compile(regex).matcher(input).matches()</pre>
     * </blockquote>
     * <p>
     * If a pattern is to be used multiple times, compiling it once and reusing it will be more
     * efficient than invoking this method each time.
     * </p>
     * 
     * @param regex The expression to be compiled
     * @param input The character sequence to be matched
     * @throws PatternSyntaxException If the expression's syntax is invalid
     */
    public static boolean matches(String regex, CharSequence input) {
        return ((Pattern) (Object) Pattern.compile(regex)).matcher(input).matches();
    }

    /**
     * Returns a literal pattern <code>String</code> for the specified <code>String</code>.
     * <p>
     * This method produces a <code>String</code> that can be used to create a <code>Pattern</code>
     * that would match the string <code>s</code> as if it were a literal pattern.
     * </p>
     * Metacharacters or escape sequences in the input sequence will be given no special meaning.
     *
     * @param value The string to be literalized
     * @return A literal string replacement
     * @since 1.5
     */
    public static String quote(String value) {
        return (String) (Object) new NativeString(value).replace("[-[\\]{}()*+?.,\\\\^$|#\\s]", "\\$&");
    }
}
