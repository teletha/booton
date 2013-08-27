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

import js.lang.NativeRegExp.Result;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/27 15:08:41
 */
@JavaAPIProvider(java.util.regex.Matcher.class)
class Matcher {

    /** The matching result. */
    private final Result result;

    /**
     * @param result
     */
    Matcher(Result result) {
        this.result = result;
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
}
