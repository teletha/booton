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

import java.util.regex.MatchResult;

import js.lang.NativeRegExp.Result;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/28 8:39:33
 */
@JavaAPIProvider(java.util.regex.Matcher.class)
class Matcher {

    /** The regular expression. */
    private Pattern pattern;

    /** The user input. */
    private String input;

    /** The matching result. */
    private Result result;

    /**
     * @param regex
     * @param input
     */
    Matcher(Pattern pattern, CharSequence input) {
        this.pattern = pattern;
        this.input = input.toString();
    }

    /**
     * Returns the pattern that is interpreted by this matcher.
     * 
     * @return The pattern for which this matcher was created
     */
    public java.util.regex.Pattern pattern() {
        return (java.util.regex.Pattern) (Object) pattern;
    }

    /**
     * Attempts to match the entire region against the pattern.
     * <p>
     * If the match succeeds then more information can be obtained via the <tt>start</tt>,
     * <tt>end</tt>, and <tt>group</tt> methods.
     * </p>
     * 
     * @return <tt>true</tt> if, and only if, the entire region sequence matches this matcher's
     *         pattern
     */
    public boolean matches() {
        result = pattern.head.exec(input);
        pattern.head.lastIndex(0);

        return result != null && result.group(0).length() == input.length();
    }

    /**
     * Attempts to match the input sequence, starting at the beginning of the region, against the
     * pattern.
     * <p>
     * Like the {@link #matches matches} method, this method always starts at the beginning of the
     * region; unlike that method, it does not require that the entire region be matched.
     * <p>
     * If the match succeeds then more information can be obtained via the <tt>start</tt>,
     * <tt>end</tt>, and <tt>group</tt> methods.
     * </p>
     * 
     * @return <tt>true</tt> if, and only if, a prefix of the input sequence matches this matcher's
     *         pattern
     */
    public boolean lookingAt() {
        result = pattern.head.exec(input);
        pattern.head.lastIndex(0);

        return result != null;
    }

    /**
     * Returns the input subsequence matched by the previous match.
     * <p>
     * For a matcher <i>m</i> with input sequence <i>s</i>, the expressions <i>m.</i>
     * <tt>group()</tt> and <i>s.</i><tt>substring(</tt><i>m.</i><tt>start(),</tt>&nbsp;<i>m.</i>
     * <tt>end())</tt> are equivalent.
     * </p>
     * <p>
     * Note that some patterns, for example <tt>a*</tt>, match the empty string. This method will
     * return the empty string when the pattern successfully matches the empty string in the input.
     * </p>
     * 
     * @return The (possibly empty) subsequence matched by the previous match, in string form
     * @throws IllegalStateException If no match has yet been attempted, or if the previous match
     *             operation failed
     */
    public String group() {
        return group(0);
    }

    /**
     * Returns the input subsequence captured by the given group during the previous match
     * operation.
     * <p>
     * For a matcher <i>m</i>, input sequence <i>s</i>, and group index <i>g</i>, the expressions
     * <i>m.</i><tt>group(</tt><i>g</i><tt>)</tt> and <i>s.</i><tt>substring(</tt><i>m.</i>
     * <tt>start(</tt><i>g</i><tt>),</tt>&nbsp;<i>m.</i><tt>end(</tt><i>g</i><tt>))</tt> are
     * equivalent.
     * </p>
     * <p>
     * <a href="Pattern.html#cg">Capturing groups</a> are indexed from left to right, starting at
     * one. Group zero denotes the entire pattern, so the expression <tt>m.group(0)</tt> is
     * equivalent to <tt>m.group()</tt>.
     * </p>
     * <p>
     * If the match was successful but the group specified failed to match any part of the input
     * sequence, then <tt>null</tt> is returned. Note that some groups, for example <tt>(a*)</tt>,
     * match the empty string. This method will return the empty string when such a group
     * successfully matches the empty string in the input.
     * </p>
     * 
     * @param group The index of a capturing group in this matcher's pattern
     * @return The (possibly empty) subsequence captured by the group during the previous match, or
     *         <tt>null</tt> if the group failed to match part of the input
     * @throws IllegalStateException If no match has yet been attempted, or if the previous match
     *             operation failed
     * @throws IndexOutOfBoundsException If there is no capturing group in the pattern with the
     *             given index
     */
    public String group(int group) {
        if (result == null) {
            throw new IllegalStateException("No match found");
        }

        if (group < 0 || result.length() < group) {
            throw new IndexOutOfBoundsException("No group " + group);
        }
        return result.group(group);
    }

    /**
     * Returns the number of capturing groups in this matcher's pattern.
     * <p>
     * Group zero denotes the entire pattern by convention. It is not included in this count.
     * <p>
     * Any non-negative integer smaller than or equal to the value returned by this method is
     * guaranteed to be a valid group index for this matcher.
     * </p>
     * 
     * @return The number of capturing groups in this matcher's pattern
     */
    public int groupCount() {
        return result.length() - 1;
    }

    /**
     * Attempts to find the next subsequence of the input sequence that matches the pattern.
     * <p>
     * This method starts at the beginning of this matcher's region, or, if a previous invocation of
     * the method was successful and the matcher has not since been reset, at the first character
     * not matched by the previous match.
     * <p>
     * If the match succeeds then more information can be obtained via the <tt>start</tt>,
     * <tt>end</tt>, and <tt>group</tt> methods.
     * </p>
     * 
     * @return <tt>true</tt> if, and only if, a subsequence of the input sequence matches this
     *         matcher's pattern
     */
    public boolean find() {
        result = pattern.regex.exec(input);

        return result != null;
    }

    /**
     * Resets this matcher and then attempts to find the next subsequence of the input sequence that
     * matches the pattern, starting at the specified index.
     * <p>
     * If the match succeeds then more information can be obtained via the <tt>start</tt>,
     * <tt>end</tt>, and <tt>group</tt> methods, and subsequent invocations of the {@link #find()}
     * method will start at the first character not matched by this match.
     * </p>
     * 
     * @throws IndexOutOfBoundsException If start is less than zero or if start is greater than the
     *             length of the input sequence.
     * @return <tt>true</tt> if, and only if, a subsequence of the input sequence starting at the
     *         given index matches this matcher's pattern
     */
    public boolean find(int start) {
        if (start < 0 || input.length() < start) {
            throw new IndexOutOfBoundsException("Illegal start index");
        }

        // update context infomation
        pattern.regex.lastIndex(start);

        return find();
    }

    /**
     * Resets this matcher.
     * <p>
     * Resetting a matcher discards all of its explicit state information and sets its append
     * position to zero. The matcher's region is set to the default region, which is its entire
     * character sequence. The anchoring and transparency of this matcher's region boundaries are
     * unaffected.
     * 
     * @return This matcher
     */
    public java.util.regex.Matcher reset() {
        pattern.regex.lastIndex(0);

        return (java.util.regex.Matcher) (Object) this;
    }

    /**
     * Resets this matcher with a new input sequence.
     * <p>
     * Resetting a matcher discards all of its explicit state information and sets its append
     * position to zero. The matcher's region is set to the default region, which is its entire
     * character sequence. The anchoring and transparency of this matcher's region boundaries are
     * unaffected.
     * 
     * @param input The new input character sequence
     * @return This matcher
     */
    public java.util.regex.Matcher reset(CharSequence input) {
        this.input = input.toString();

        return reset();
    }

    /**
     * Changes the <tt>Pattern</tt> that this <tt>Matcher</tt> uses to find matches with.
     * <p>
     * This method causes this matcher to lose information about the groups of the last match that
     * occurred. The matcher's position in the input is maintained and its last append position is
     * unaffected.
     * </p>
     * 
     * @param pattern The new pattern used by this matcher
     * @return This matcher
     * @throws IllegalArgumentException If newPattern is <tt>null</tt>
     * @since 1.5
     */
    public java.util.regex.Matcher usePattern(java.util.regex.Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern cannot be null");
        }

        Pattern old = this.pattern;
        this.pattern = (Pattern) (Object) pattern;
        this.pattern.regex.lastIndex(old.regex.lastIndex());

        return (java.util.regex.Matcher) (Object) this;
    }

    /**
     * Returns the match state of this matcher as a {@link MatchResult}. The result is unaffected by
     * subsequent operations performed upon this matcher.
     * 
     * @return a <code>MatchResult</code> with the state of this matcher
     * @since 1.5
     */
    public MatchResult toMatchResult() {
        return null;
    }
}
