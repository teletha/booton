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

import static js.lang.JSStringHelper.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

import booton.translator.JavaAPIProvider;
import booton.translator.JavascriptAPIProvider;

/**
 * @version 2013/09/24 16:25:46
 */
@JavaAPIProvider(String.class)
@JavascriptAPIProvider("String")
class JSString implements Comparable<String>, CharSequence {

    /** The cache for hash. */
    private int hash = 0;

    /**
     * Returns the <code>char</code> value at the specified index. An index ranges from
     * <code>0</code> to <code>length() - 1</code>. The first <code>char</code> value of the
     * sequence is at index <code>0</code>, the next at index <code>1</code>, and so on, as for
     * array indexing.
     * <p>
     * If the <code>char</code> value specified by the index is a <a
     * href="Character.html#unicode">surrogate</a>, the surrogate value is returned.
     * 
     * @param index the index of the <code>char</code> value.
     * @return the <code>char</code> value at the specified index of this string. The first
     *         <code>char</code> value is at index <code>0</code>.
     * @exception IndexOutOfBoundsException if the <code>index</code> argument is negative or not
     *                less than the length of this string.
     */
    @Override
    public char charAt(int index) {
        if (index < 0 || length() <= index) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return that.charAt(index);
    }

    /**
     * Returns the character (Unicode code point) at the specified index. The index refers to
     * <code>char</code> values (Unicode code units) and ranges from <code>0</code> to
     * {@link #length()}<code> - 1</code>.
     * <p>
     * If the <code>char</code> value specified at the given index is in the high-surrogate range,
     * the following index is less than the length of this <code>String</code>, and the
     * <code>char</code> value at the following index is in the low-surrogate range, then the
     * supplementary code point corresponding to this surrogate pair is returned. Otherwise, the
     * <code>char</code> value at the given index is returned.
     * 
     * @param index the index to the <code>char</code> values
     * @return the code point value of the character at the <code>index</code>
     * @exception IndexOutOfBoundsException if the <code>index</code> argument is negative or not
     *                less than the length of this string.
     * @since 1.5
     */
    public int codePointAt(int index) {
        if (index < 0 || length() <= index) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return that.charCodeAt(index);
    }

    /**
     * Returns the character (Unicode code point) before the specified index. The index refers to
     * <code>char</code> values (Unicode code units) and ranges from <code>1</code> to
     * {@link CharSequence#length() length}.
     * <p>
     * If the <code>char</code> value at <code>(index - 1)</code> is in the low-surrogate range,
     * <code>(index - 2)</code> is not negative, and the <code>char</code> value at <code>(index -
     * 2)</code> is in the high-surrogate range, then the supplementary code point value of the
     * surrogate pair is returned. If the <code>char</code> value at <code>index -
     * 1</code> is an unpaired low-surrogate or a high-surrogate, the surrogate value is returned.
     * 
     * @param index the index following the code point that should be returned
     * @return the Unicode code point value before the given index.
     * @exception IndexOutOfBoundsException if the <code>index</code> argument is less than 1 or
     *                greater than the length of this string.
     * @since 1.5
     */
    public int codePointBefore(int index) {
        index--;

        if (index < 0 || length() <= index) {
            throw new IndexOutOfBoundsException(String.valueOf(index + 1));
        }
        return that.charCodeAt(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(String object) {
        return that.localeCompare(object);
    }

    /**
     * Concatenates the specified string to the end of this string.
     * <p>
     * If the length of the argument string is <code>0</code>, then this <code>String</code> object
     * is returned. Otherwise, a new <code>String</code> object is created, representing a character
     * sequence that is the concatenation of the character sequence represented by this
     * <code>String</code> object and the character sequence represented by the argument string.
     * <p>
     * Examples: <blockquote>
     * 
     * <pre>
     * "cares".concat("s") returns "caress"
     * "to".concat("get").concat("her") returns "together"
     * </pre>
     * </blockquote>
     * 
     * @param value the <code>String</code> that is concatenated to the end of this
     *            <code>String</code>.
     * @return a string that represents the concatenation of this object's characters followed by
     *         the string argument's characters.
     */
    public String concat(String value) {
        Objects.requireNonNull(value);
        return (String) (Object) that.concat(value);
    }

    /**
     * Returns true if and only if this string contains the specified sequence of char values.
     * 
     * @param text the sequence to search for
     * @return true if this string contains <code>text</code>, false otherwise
     * @throws NullPointerException if <code>text</code> is <code>null</code>
     * @since 1.5
     */
    public boolean contains(CharSequence text) {
        Objects.requireNonNull(text);
        return that.indexOf(text.toString()) != -1;
    }

    /**
     * Tests if this string ends with the specified suffix.
     * 
     * @param suffix the suffix.
     * @return <code>true</code> if the character sequence represented by the argument is a suffix
     *         of the character sequence represented by this object; <code>false</code> otherwise.
     *         Note that the result will be <code>true</code> if the argument is the empty string or
     *         is equal to this <code>String</code> object as determined by the
     *         {@link #equals(Object)} method.
     */
    public boolean endsWith(String suffix) {
        Objects.requireNonNull(suffix);
        return indexOf(suffix, length() - suffix.length()) != -1;
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
    public boolean equalsIgnoreCase(String anotherString) {
        if (anotherString == null) {
            return false;
        }

        if (that == (Object) anotherString) {
            return true;
        }

        if (that.length() != anotherString.length()) {
            return false;
        }
        return that.toLowerCase().equals(anotherString.toLowerCase());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int h = hash;

        if (h == 0 && 0 < length()) {
            for (int i = 0; i < length(); i++) {
                h = 31 * h + codePointAt(i);
            }
            hash = h;
        }
        return h;
    }

    /**
     * Returns the index within this string of the first occurrence of the specified character. If a
     * character with value <code>ch</code> occurs in the character sequence represented by this
     * <code>String</code> object, then the index (in Unicode code units) of the first such
     * occurrence is returned. For values of <code>ch</code> in the range from 0 to 0xFFFF
     * (inclusive), this is the smallest value <i>k</i> such that: <blockquote>
     * 
     * <pre>
     * this.charAt(<i>k</i>) == ch
     * </pre>
     * 
     * </blockquote> is true. For other values of <code>ch</code>, it is the smallest value <i>k</i>
     * such that: <blockquote>
     * 
     * <pre>
     * this.codePointAt(<i>k</i>) == ch
     * </pre>
     * 
     * </blockquote> is true. In either case, if no such character occurs in this string, then
     * <code>-1</code> is returned.
     * 
     * @param ch a character (Unicode code point).
     * @return the index of the first occurrence of the character in the character sequence
     *         represented by this object, or <code>-1</code> if the character does not occur.
     */
    public int indexOf(int ch) {
        return indexOf(ch, 0);
    }

    /**
     * Returns the index within this string of the first occurrence of the specified character,
     * starting the search at the specified index.
     * <p>
     * If a character with value <code>ch</code> occurs in the character sequence represented by
     * this <code>String</code> object at an index no smaller than <code>fromIndex</code>, then the
     * index of the first such occurrence is returned. For values of <code>ch</code> in the range
     * from 0 to 0xFFFF (inclusive), this is the smallest value <i>k</i> such that: <blockquote>
     * 
     * <pre>
     * (this.charAt(<i>k</i>) == ch) && (<i>k</i> &gt;= fromIndex)
     * </pre>
     * </blockquote> is true. For other values of <code>ch</code>, it is the smallest value <i>k</i>
     * such that: <blockquote>
     * 
     * <pre>
     * (this.codePointAt(<i>k</i>) == ch) && (<i>k</i> &gt;= fromIndex)
     * </pre>
     * </blockquote> is true. In either case, if no such character occurs in this string at or after
     * position <code>fromIndex</code>, then <code>-1</code> is returned.
     * <p>
     * There is no restriction on the value of <code>fromIndex</code>. If it is negative, it has the
     * same effect as if it were zero: this entire string may be searched. If it is greater than the
     * length of this string, it has the same effect as if it were equal to the length of this
     * string: <code>-1</code> is returned.
     * <p>
     * All indices are specified in <code>char</code> values (Unicode code units).
     * 
     * @param ch a character (Unicode code point).
     * @param fromIndex the index to start the search from.
     * @return the index of the first occurrence of the character in the character sequence
     *         represented by this object that is greater than or equal to <code>fromIndex</code>,
     *         or <code>-1</code> if the character does not occur.
     */
    public int indexOf(int ch, int fromIndex) {
        return indexOf((String) (Object) NativeString.fromCharCode(ch), fromIndex);
    }

    /**
     * Returns the index within this string of the first occurrence of the specified substring.
     * <p>
     * The returned index is the smallest value <i>k</i> for which: <blockquote>
     * 
     * <pre>
     * this.startsWith(str, <i>k</i>)
     * </pre>
     * </blockquote> If no such value of <i>k</i> exists, then {@code -1} is returned.
     * 
     * @param text the substring to search for.
     * @return the index of the first occurrence of the specified substring, or {@code -1} if there
     *         is no such occurrence.
     */
    public int indexOf(String text) {
        return that.indexOf(text);
    }

    /**
     * Returns the index within this string of the first occurrence of the specified substring,
     * starting at the specified index.
     * <p>
     * The returned index is the smallest value <i>k</i> for which: <blockquote>
     * 
     * <pre>
     * <i>k</i> &gt;= fromIndex && this.startsWith(str, <i>k</i>)
     * </pre>
     * </blockquote> If no such value of <i>k</i> exists, then {@code -1} is returned.
     * 
     * @param text the substring to search for.
     * @param fromIndex the index from which to start the search.
     * @return the index of the first occurrence of the specified substring, starting at the
     *         specified index, or {@code -1} if there is no such occurrence.
     */
    public int indexOf(String text, int fromIndex) {
        return that.indexOf(text, fromIndex);
    }

    /**
     * Returns <tt>true</tt> if, and only if, {@link #length()} is <tt>0</tt>.
     * 
     * @return <tt>true</tt> if {@link #length()} is <tt>0</tt>, otherwise <tt>false</tt>
     * @since 1.6
     */
    public boolean isEmpty() {
        return that.length() == 0;
    }

    /**
     * Returns the index within this string of the last occurrence of the specified character. For
     * values of <code>ch</code> in the range from 0 to 0xFFFF (inclusive), the index (in Unicode
     * code units) returned is the largest value <i>k</i> such that: <blockquote>
     * 
     * <pre>
     * this.charAt(<i>k</i>) == ch
     * </pre>
     * 
     * </blockquote> is true. For other values of <code>ch</code>, it is the largest value <i>k</i>
     * such that: <blockquote>
     * 
     * <pre>
     * this.codePointAt(<i>k</i>) == ch
     * </pre>
     * 
     * </blockquote> is true. In either case, if no such character occurs in this string, then
     * <code>-1</code> is returned. The <code>String</code> is searched backwards starting at the
     * last character.
     * 
     * @param ch a character (Unicode code point).
     * @return the index of the last occurrence of the character in the character sequence
     *         represented by this object, or <code>-1</code> if the character does not occur.
     */
    public int lastIndexOf(int ch) {
        return lastIndexOf(ch, length() - 1);
    }

    /**
     * Returns the index within this string of the last occurrence of the specified character,
     * searching backward starting at the specified index. For values of <code>ch</code> in the
     * range from 0 to 0xFFFF (inclusive), the index returned is the largest value <i>k</i> such
     * that: <blockquote>
     * 
     * <pre>
     * (this.charAt(<i>k</i>) == ch) && (<i>k</i> &lt;= fromIndex)
     * </pre>
     * 
     * </blockquote> is true. For other values of <code>ch</code>, it is the largest value <i>k</i>
     * such that: <blockquote>
     * 
     * <pre>
     * (this.codePointAt(<i>k</i>) == ch) && (<i>k</i> &lt;= fromIndex)
     * </pre>
     * 
     * </blockquote> is true. In either case, if no such character occurs in this string at or
     * before position <code>fromIndex</code>, then <code>-1</code> is returned.
     * <p>
     * All indices are specified in <code>char</code> values (Unicode code units).
     * 
     * @param ch a character (Unicode code point).
     * @param fromIndex the index to start the search from. There is no restriction on the value of
     *            <code>fromIndex</code>. If it is greater than or equal to the length of this
     *            string, it has the same effect as if it were equal to one less than the length of
     *            this string: this entire string may be searched. If it is negative, it has the
     *            same effect as if it were -1: -1 is returned.
     * @return the index of the last occurrence of the character in the character sequence
     *         represented by this object that is less than or equal to <code>fromIndex</code>, or
     *         <code>-1</code> if the character does not occur before that point.
     */
    public int lastIndexOf(int ch, int fromIndex) {
        return lastIndexOf((String) (Object) NativeString.fromCharCode(ch), fromIndex);
    }

    /**
     * Returns the index within this string of the last occurrence of the specified substring. The
     * last occurrence of the empty string "" is considered to occur at the index value
     * {@code this.length()}.
     * <p>
     * The returned index is the largest value <i>k</i> for which: <blockquote>
     * 
     * <pre>
     * this.startsWith(str, <i>k</i>)
     * </pre>
     * </blockquote> If no such value of <i>k</i> exists, then {@code -1} is returned.
     * 
     * @param text the substring to search for.
     * @return the index of the last occurrence of the specified substring, or {@code -1} if there
     *         is no such occurrence.
     */
    public int lastIndexOf(String text) {
        return that.lastIndexOf(text);
    }

    /**
     * Returns the index within this string of the last occurrence of the specified substring,
     * searching backward starting at the specified index.
     * <p>
     * The returned index is the largest value <i>k</i> for which: <blockquote>
     * 
     * <pre>
     * <i>k</i> &lt;= fromIndex && this.startsWith(str, <i>k</i>)
     * </pre>
     * </blockquote> If no such value of <i>k</i> exists, then {@code -1} is returned.
     * 
     * @param text the substring to search for.
     * @param from the index to start the search from.
     * @return the index of the last occurrence of the specified substring, searching backward from
     *         the specified index, or {@code -1} if there is no such occurrence.
     */
    public int lastIndexOf(String text, int from) {
        return that.lastIndexOf(text, from);
    }

    /**
     * Returns the length of this string. The length is equal to the number of <a
     * href="Character.html#unicode">Unicode code units</a> in the string.
     * 
     * @return the length of the sequence of characters represented by this object.
     */
    @Override
    public int length() {
        return that.length();
    }

    /**
     * Returns a new string resulting from replacing all occurrences of <code>oldChar</code> in this
     * string with <code>newChar</code>.
     * <p>
     * If the character <code>oldChar</code> does not occur in the character sequence represented by
     * this <code>String</code> object, then a reference to this <code>String</code> object is
     * returned. Otherwise, a new <code>String</code> object is created that represents a character
     * sequence identical to the character sequence represented by this <code>String</code> object,
     * except that every occurrence of <code>oldChar</code> is replaced by an occurrence of
     * <code>newChar</code>.
     * <p>
     * Examples: <blockquote>
     * 
     * <pre>
     * "mesquite in your cellar".replace('e', 'o')
     *         returns "mosquito in your collar"
     * "the war of baronets".replace('r', 'y')
     *         returns "the way of bayonets"
     * "sparring with a purple porpoise".replace('p', 't')
     *         returns "starring with a turtle tortoise"
     * "JonL".replace('q', 'x') returns "JonL" (no change)
     * </pre>
     * </blockquote>
     * 
     * @param oldChar the old character.
     * @param newChar the new character.
     * @return a string derived from this string by replacing every occurrence of
     *         <code>oldChar</code> with <code>newChar</code>.
     */
    public String replace(char oldChar, char newChar) {
        return (String) (Object) that.replace(oldChar, newChar);
    }

    /**
     * Replaces each substring of this string that matches the literal target sequence with the
     * specified literal replacement sequence. The replacement proceeds from the beginning of the
     * string to the end, for example, replacing "aa" with "b" in the string "aaa" will result in
     * "ba" rather than "ab".
     * 
     * @param target The sequence of char values to be replaced
     * @param replacement The replacement sequence of char values
     * @return The resulting string
     * @throws NullPointerException if <code>target</code> or <code>replacement</code> is
     *             <code>null</code>.
     * @since 1.5
     */
    public String replace(CharSequence target, CharSequence replacement) {
        Objects.requireNonNull(target);
        Objects.requireNonNull(replacement);

        return (String) (Object) that.replace(target, replacement);
    }

    /**
     * Replaces each substring of this string that matches the given <a
     * href="../util/regex/Pattern.html#sum">regular expression</a> with the given replacement.
     * <p>
     * An invocation of this method of the form <i>str</i><tt>.replaceAll(</tt><i>regex</i>
     * <tt>,</tt> <i>repl</i><tt>)</tt> yields exactly the same result as the expression
     * <blockquote><tt>
     * {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#compile
     * compile}(</tt><i>regex</i><tt>).{@link
     * java.util.regex.Pattern#matcher(java.lang.CharSequence)
     * matcher}(</tt><i>str</i><tt>).{@link java.util.regex.Matcher#replaceAll
     * replaceAll}(</tt><i>repl</i><tt>)</tt></blockquote>
     * <p>
     * Note that backslashes (<tt>\</tt>) and dollar signs (<tt>$</tt>) in the replacement string
     * may cause the results to be different than if it were being treated as a literal replacement
     * string; see {@link java.util.regex.Matcher#replaceAll Matcher.replaceAll}. Use
     * {@link java.util.regex.Matcher#quoteReplacement} to suppress the special meaning of these
     * characters, if desired.
     * 
     * @param regex the regular expression to which this string is to be matched
     * @param replacement the string to be substituted for each match
     * @return The resulting <tt>String</tt>
     * @throws PatternSyntaxException if the regular expression's syntax is invalid
     * @see java.util.regex.Pattern
     * @since 1.4
     * @spec JSR-51
     */
    public String replaceAll(String regex, String replacement) {
        return (String) (Object) that.replace(regex, replacement);
    }

    /**
     * Replaces the first substring of this string that matches the given <a
     * href="../util/regex/Pattern.html#sum">regular expression</a> with the given replacement.
     * <p>
     * An invocation of this method of the form <i>str</i><tt>.replaceFirst(</tt><i>regex</i>
     * <tt>,</tt> <i>repl</i><tt>)</tt> yields exactly the same result as the expression
     * <blockquote><tt>
     * {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#compile
     * compile}(</tt><i>regex</i><tt>).{@link
     * java.util.regex.Pattern#matcher(java.lang.CharSequence)
     * matcher}(</tt><i>str</i><tt>).{@link java.util.regex.Matcher#replaceFirst
     * replaceFirst}(</tt><i>repl</i><tt>)</tt></blockquote>
     * <p>
     * Note that backslashes (<tt>\</tt>) and dollar signs (<tt>$</tt>) in the replacement string
     * may cause the results to be different than if it were being treated as a literal replacement
     * string; see {@link java.util.regex.Matcher#replaceFirst}. Use
     * {@link java.util.regex.Matcher#quoteReplacement} to suppress the special meaning of these
     * characters, if desired.
     * 
     * @param regex the regular expression to which this string is to be matched
     * @param replacement the string to be substituted for the first match
     * @return The resulting <tt>String</tt>
     * @throws PatternSyntaxException if the regular expression's syntax is invalid
     * @see java.util.regex.Pattern
     * @since 1.4
     * @spec JSR-51
     */
    public String replaceFirst(String regex, String replacement) {
        return (String) (Object) that.replaceFirst(regex, replacement);
    }

    /**
     * Tests if two string regions are equal.
     * <p>
     * A substring of this <tt>String</tt> object is compared to a substring of the argument other.
     * The result is true if these substrings represent identical character sequences. The substring
     * of this <tt>String</tt> object to be compared begins at index <tt>toffset</tt> and has length
     * <tt>len</tt>. The substring of other to be compared begins at index <tt>ooffset</tt> and has
     * length <tt>len</tt>. The result is <tt>false</tt> if and only if at least one of the
     * following is true:
     * <ul>
     * <li><tt>toffset</tt> is negative.
     * <li><tt>ooffset</tt> is negative.
     * <li><tt>toffset+len</tt> is greater than the length of this <tt>String</tt> object.
     * <li><tt>ooffset+len</tt> is greater than the length of the other argument.
     * <li>There is some nonnegative integer <i>k</i> less than <tt>len</tt> such that:
     * <tt>this.charAt(toffset+<i>k</i>)&nbsp;!=&nbsp;other.charAt(ooffset+<i>k</i>)</tt>
     * </ul>
     * 
     * @param offset the starting offset of the subregion in this string.
     * @param other the string argument.
     * @param otherOffset the starting offset of the subregion in the string argument.
     * @param length the number of characters to compare.
     * @return <code>true</code> if the specified subregion of this string exactly matches the
     *         specified subregion of the string argument; <code>false</code> otherwise.
     */
    public boolean regionMatches(int offset, String other, int otherOffset, int length) {
        return regionMatches(false, offset, other, otherOffset, length);
    }

    /**
     * Tests if two string regions are equal.
     * <p>
     * A substring of this <tt>String</tt> object is compared to a substring of the argument
     * <tt>other</tt>. The result is <tt>true</tt> if these substrings represent character sequences
     * that are the same, ignoring case if and only if <tt>ignoreCase</tt> is true. The substring of
     * this <tt>String</tt> object to be compared begins at index <tt>toffset</tt> and has length
     * <tt>len</tt>. The substring of <tt>other</tt> to be compared begins at index <tt>ooffset</tt>
     * and has length <tt>len</tt>. The result is <tt>false</tt> if and only if at least one of the
     * following is true:
     * <ul>
     * <li><tt>toffset</tt> is negative.
     * <li><tt>ooffset</tt> is negative.
     * <li><tt>toffset+len</tt> is greater than the length of this <tt>String</tt> object.
     * <li><tt>ooffset+len</tt> is greater than the length of the other argument.
     * <li><tt>ignoreCase</tt> is <tt>false</tt> and there is some nonnegative integer <i>k</i> less
     * than <tt>len</tt> such that: <blockquote>
     * 
     * <pre>
     * this.charAt(toffset+k) != other.charAt(ooffset+k)
     * </pre>
     * </blockquote>
     * <li><tt>ignoreCase</tt> is <tt>true</tt> and there is some nonnegative integer <i>k</i> less
     * than <tt>len</tt> such that: <blockquote>
     * 
     * <pre>
     * Character.toLowerCase(this.charAt(toffset+k)) !=
     Character.toLowerCase(other.charAt(ooffset+k))
     * </pre>
     * </blockquote> and: <blockquote>
     * 
     * <pre>
     * Character.toUpperCase(this.charAt(toffset+k)) !=
     *         Character.toUpperCase(other.charAt(ooffset+k))
     * </pre>
     * </blockquote>
     * </ul>
     * 
     * @param ignoreCase if <code>true</code>, ignore case when comparing characters.
     * @param offset the starting offset of the subregion in this string.
     * @param other the string argument.
     * @param otherOffset the starting offset of the subregion in the string argument.
     * @param length the number of characters to compare.
     * @return <code>true</code> if the specified subregion of this string matches the specified
     *         subregion of the string argument; <code>false</code> otherwise. Whether the matching
     *         is exact or case insensitive depends on the <code>ignoreCase</code> argument.
     */
    public boolean regionMatches(boolean ignoreCase, int offset, String other, int otherOffset, int length) {
        char chars1[] = toCharArray();
        char chars2[] = other.toCharArray();

        if (otherOffset < 0 || offset < 0 || offset > length() - length || otherOffset > other.length() - length) {
            return false;
        }

        while (0 < length--) {
            char c1 = chars1[offset++];
            char c2 = chars2[otherOffset++];

            if (c1 == c2) {
                continue;
            }

            if (ignoreCase) {
                // If characters don't match but case may be ignored,
                // try converting both characters to uppercase.
                // If the results match, then the comparison scan should
                // continue.
                if (Character.toUpperCase(c1) == Character.toUpperCase(c2)) {
                    continue;
                }

                // Unfortunately, conversion to uppercase does not work properly
                // for the Georgian alphabet, which has strange rules about case
                // conversion. So we need to make one last check before
                // exiting.
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * Splits this string around matches of the given <a
     * href="../util/regex/Pattern.html#sum">regular expression</a>.
     * <p>
     * The array returned by this method contains each substring of this string that is terminated
     * by another substring that matches the given expression or is terminated by the end of the
     * string. The substrings in the array are in the order in which they occur in this string. If
     * the expression does not match any part of the input then the resulting array has just one
     * element, namely this string.
     * <p>
     * The <tt>limit</tt> parameter controls the number of times the pattern is applied and
     * therefore affects the length of the resulting array. If the limit <i>n</i> is greater than
     * zero then the pattern will be applied at most <i>n</i>&nbsp;-&nbsp;1 times, the array's
     * length will be no greater than <i>n</i>, and the array's last entry will contain all input
     * beyond the last matched delimiter. If <i>n</i> is non-positive then the pattern will be
     * applied as many times as possible and the array can have any length. If <i>n</i> is zero then
     * the pattern will be applied as many times as possible, the array can have any length, and
     * trailing empty strings will be discarded.
     * <p>
     * The string <tt>"boo:and:foo"</tt>, for example, yields the following results with these
     * parameters: <blockquote>
     * <table cellpadding=1 cellspacing=0 summary="Split example showing regex, limit, and result">
     * <tr>
     * <th>Regex</th>
     * <th>Limit</th>
     * <th>Result</th>
     * </tr>
     * <tr>
     * <td align=center>:</td>
     * <td align=center>2</td>
     * <td><tt>{ "boo", "and:foo" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>:</td>
     * <td align=center>5</td>
     * <td><tt>{ "boo", "and", "foo" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>:</td>
     * <td align=center>-2</td>
     * <td><tt>{ "boo", "and", "foo" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>o</td>
     * <td align=center>5</td>
     * <td><tt>{ "b", "", ":and:f", "", "" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>o</td>
     * <td align=center>-2</td>
     * <td><tt>{ "b", "", ":and:f", "", "" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>o</td>
     * <td align=center>0</td>
     * <td><tt>{ "b", "", ":and:f" }</tt></td>
     * </tr>
     * </table>
     * </blockquote>
     * <p>
     * An invocation of this method of the form <i>str.</i><tt>split(</tt><i>regex</i><tt>,</tt>
     * &nbsp;<i>n</i><tt>)</tt> yields the same result as the expression <blockquote>
     * {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#compile compile}<tt>(</tt>
     * <i>regex</i><tt>)</tt>.{@link java.util.regex.Pattern#split(java.lang.CharSequence,int)
     * split}<tt>(</tt><i>str</i><tt>,</tt>&nbsp;<i>n</i><tt>)</tt> </blockquote>
     * 
     * @param regex the delimiting regular expression
     * @param limit the result threshold, as described above
     * @return the array of strings computed by splitting this string around matches of the given
     *         regular expression
     * @throws PatternSyntaxException if the regular expression's syntax is invalid
     * @see java.util.regex.Pattern
     * @since 1.4
     * @spec JSR-51
     */
    public String[] split(String regex, int limit) {
        return (String[]) (Object) that.split(regex, limit);
    }

    /**
     * Splits this string around matches of the given <a
     * href="../util/regex/Pattern.html#sum">regular expression</a>.
     * <p>
     * This method works as if by invoking the two-argument {@link #split(String, int) split} method
     * with the given expression and a limit argument of zero. Trailing empty strings are therefore
     * not included in the resulting array.
     * <p>
     * The string <tt>"boo:and:foo"</tt>, for example, yields the following results with these
     * expressions: <blockquote>
     * <table cellpadding=1 cellspacing=0 summary="Split examples showing regex and result">
     * <tr>
     * <th>Regex</th>
     * <th>Result</th>
     * </tr>
     * <tr>
     * <td align=center>:</td>
     * <td><tt>{ "boo", "and", "foo" }</tt></td>
     * </tr>
     * <tr>
     * <td align=center>o</td>
     * <td><tt>{ "b", "", ":and:f" }</tt></td>
     * </tr>
     * </table>
     * </blockquote>
     * 
     * @param regex the delimiting regular expression
     * @return the array of strings computed by splitting this string around matches of the given
     *         regular expression
     * @throws PatternSyntaxException if the regular expression's syntax is invalid
     * @see java.util.regex.Pattern
     * @since 1.4
     * @spec JSR-51
     */
    public String[] split(String regex) {
        Objects.requireNonNull(regex);
        return (String[]) (Object) that.split(new NativeRegExp(regex));
    }

    /**
     * Tests if this string starts with the specified prefix.
     * 
     * @param prefix the prefix.
     * @return <code>true</code> if the character sequence represented by the argument is a prefix
     *         of the character sequence represented by this string; <code>false</code> otherwise.
     *         Note also that <code>true</code> will be returned if the argument is an empty string
     *         or is equal to this <code>String</code> object as determined by the
     *         {@link #equals(Object)} method.
     * @since 1. 0
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    /**
     * Tests if the substring of this string beginning at the specified index starts with the
     * specified prefix.
     * 
     * @param prefix the prefix.
     * @param toffset where to begin looking in this string.
     * @return <code>true</code> if the character sequence represented by the argument is a prefix
     *         of the substring of this object starting at index <code>toffset</code>;
     *         <code>false</code> otherwise. The result is <code>false</code> if
     *         <code>toffset</code> is negative or greater than the length of this
     *         <code>String</code> object; otherwise the result is the same as the result of the
     *         expression
     * 
     * <pre>
     *          this.substring(toffset).startsWith(prefix)
     *          </pre>
     */
    public boolean startsWith(String prefix, int toffset) {
        Objects.requireNonNull(prefix);
        return that.indexOf(prefix, toffset) == toffset;
    }

    /**
     * Returns a new character sequence that is a subsequence of this sequence.
     * <p>
     * An invocation of this method of the form <blockquote>
     * 
     * <pre>
     * str.subSequence(begin,&nbsp;end)</pre>
     * </blockquote> behaves in exactly the same way as the invocation <blockquote>
     * 
     * <pre>
     * str.substring(begin,&nbsp;end)</pre>
     * </blockquote> This method is defined so that the <tt>String</tt> class can implement the
     * {@link CharSequence} interface.
     * </p>
     * 
     * @param beginIndex the begin index, inclusive.
     * @param endIndex the end index, exclusive.
     * @return the specified subsequence.
     * @throws IndexOutOfBoundsException if <tt>beginIndex</tt> or <tt>endIndex</tt> are negative,
     *             if <tt>endIndex</tt> is greater than <tt>length()</tt>, or if <tt>beginIndex</tt>
     *             is greater than <tt>startIndex</tt>
     * @since 1.4
     * @spec JSR-51
     */
    @Override
    public CharSequence subSequence(int beginIndex, int endIndex) {
        return substring(beginIndex, endIndex);
    }

    /**
     * Returns a new string that is a substring of this string. The substring begins with the
     * character at the specified index and extends to the end of this string.
     * <p>
     * Examples: <blockquote>
     * 
     * <pre>
     * "unhappy".substring(2) returns "happy"
     * "Harbison".substring(3) returns "bison"
     * "emptiness".substring(9) returns "" (an empty string)
     * </pre>
     * </blockquote>
     * 
     * @param beginIndex the beginning index, inclusive.
     * @return the specified substring.
     * @exception IndexOutOfBoundsException if <code>beginIndex</code> is negative or larger than
     *                the length of this <code>String</code> object.
     */
    public String substring(int beginIndex) {
        return substring(beginIndex, length());
    }

    /**
     * Returns a new string that is a substring of this string. The substring begins at the
     * specified <code>beginIndex</code> and extends to the character at index
     * <code>endIndex - 1</code>. Thus the length of the substring is
     * <code>endIndex-beginIndex</code>.
     * <p>
     * Examples: <blockquote>
     * 
     * <pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * </pre>
     * </blockquote>
     * 
     * @param beginIndex the beginning index, inclusive.
     * @param endIndex the ending index, exclusive.
     * @return the specified substring.
     * @exception IndexOutOfBoundsException if the <code>beginIndex</code> is negative, or
     *                <code>endIndex</code> is larger than the length of this <code>String</code>
     *                object, or <code>beginIndex</code> is larger than <code>endIndex</code>.
     */
    public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }

        if (length() < endIndex) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }

        if (endIndex < beginIndex) {
            throw new StringIndexOutOfBoundsException("The start index[" + beginIndex + "] is bigger than the end index[" + endIndex + "].");
        }
        return (String) (Object) that.substring(beginIndex, endIndex);
    }

    /**
     * Converts this string to a new character array.
     * 
     * @return a newly allocated character array whose length is the length of this string and whose
     *         contents are initialized to contain the character sequence represented by this
     *         string.
     */
    public char[] toCharArray() {
        char[] result = new char[length()];

        for (int i = 0; i < result.length; i++) {
            result[i] = charAt(i);
        }
        return result;
    }

    /**
     * Converts all of the characters in this <code>String</code> to lower case using the rules of
     * the default locale. This is equivalent to calling
     * <code>toLowerCase(Locale.getDefault())</code>.
     * <p>
     * <b>Note:</b> This method is locale sensitive, and may produce unexpected results if used for
     * strings that are intended to be interpreted locale independently. Examples are programming
     * language identifiers, protocol keys, and HTML tags. For instance,
     * <code>"TITLE".toLowerCase()</code> in a Turkish locale returns <code>"t\u005Cu0131tle"</code>
     * , where '\u005Cu0131' is the LATIN SMALL LETTER DOTLESS I character. To obtain correct
     * results for locale insensitive strings, use <code>toLowerCase(Locale.ENGLISH)</code>.
     * <p>
     * 
     * @return the <code>String</code>, converted to lowercase.
     * @see java.lang.String#toLowerCase(Locale)
     */
    public String toLowerCase() {
        return (String) (Object) that.toLowerCase();
    }

    /**
     * Converts all of the characters in this <code>String</code> to upper case using the rules of
     * the default locale. This method is equivalent to
     * <code>toUpperCase(Locale.getDefault())</code>.
     * <p>
     * <b>Note:</b> This method is locale sensitive, and may produce unexpected results if used for
     * strings that are intended to be interpreted locale independently. Examples are programming
     * language identifiers, protocol keys, and HTML tags. For instance,
     * <code>"title".toUpperCase()</code> in a Turkish locale returns <code>"T\u005Cu0130TLE"</code>
     * , where '\u005Cu0130' is the LATIN CAPITAL LETTER I WITH DOT ABOVE character. To obtain
     * correct results for locale insensitive strings, use <code>toUpperCase(Locale.ENGLISH)</code>.
     * <p>
     * 
     * @return the <code>String</code>, converted to uppercase.
     * @see java.lang.String#toUpperCase(Locale)
     */
    public String toUpperCase() {
        return (String) (Object) that.toUpperCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return that.toString();
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace omitted.
     * <p>
     * If this <code>String</code> object represents an empty character sequence, or the first and
     * last characters of character sequence represented by this <code>String</code> object both
     * have codes greater than <code>'&#92;u0020'</code> (the space character), then a reference to
     * this <code>String</code> object is returned.
     * <p>
     * Otherwise, if there is no character with a code greater than <code>'&#92;u0020'</code> in the
     * string, then a new <code>String</code> object representing an empty string is created and
     * returned.
     * <p>
     * Otherwise, let <i>k</i> be the index of the first character in the string whose code is
     * greater than <code>'&#92;u0020'</code>, and let <i>m</i> be the index of the last character
     * in the string whose code is greater than <code>'&#92;u0020'</code>. A new <code>String</code>
     * object is created, representing the substring of this string that begins with the character
     * at index <i>k</i> and ends with the character at index <i>m</i>-that is, the result of
     * <code>this.substring(<i>k</i>,&nbsp;<i>m</i>+1)</code>.
     * <p>
     * This method may be used to trim whitespace (as defined above) from the beginning and end of a
     * string.
     * 
     * @return A copy of this string with leading and trailing white space removed, or this string
     *         if it has no leading or trailing white space.
     */
    public String trim() {
        return (String) (Object) that.trim();
    }

    /**
     * Returns the runtime class of this {@code Object}. The returned {@code Class} object is the
     * object that is locked by {@code static synchronized} methods of the represented class.
     * <p>
     * <b>The actual result type is {@code Class<? extends |X|>} where {@code |X|} is the erasure of
     * the static type of the expression on which {@code getClass} is called.</b> For example, no
     * cast is required in this code fragment:
     * </p>
     * <p>
     * {@code Number n = 0;                             }<br>
     * {@code Class<? extends Number> c = n.getClass(); }
     * </p>
     * 
     * @return The {@code Class} object that represents the runtime class of this object.
     * @see Class Literals, section 15.8.2 of <cite>The Java&trade; Language Specification</cite>.
     */
    public Class<?> $alias$getClass() {
        return String.class;
    }

    /**
     * Returns a formatted string using the specified format string and arguments.
     * <p>
     * The locale always used is the one returned by {@link java.util.Locale#getDefault()
     * Locale.getDefault()}.
     * 
     * @param format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args Arguments referenced by the format specifiers in the format string. If there are
     *            more arguments than format specifiers, the extra arguments are ignored. The number
     *            of arguments is variable and may be zero. The maximum number of arguments is
     *            limited by the maximum dimension of a Java array as defined by <cite>The
     *            Java&trade; Virtual Machine Specification</cite>. The behaviour on a {@code null}
     *            argument depends on the <a href="../util/Formatter.html#syntax">conversion</a>.
     * @throws java.util.IllegalFormatException If a format string contains an illegal syntax, a
     *             format specifier that is incompatible with the given arguments, insufficient
     *             arguments given the format string, or other illegal conditions. For specification
     *             of all possible formatting errors, see the <a
     *             href="../util/Formatter.html#detail">Details</a> section of the formatter class
     *             specification.
     * @return A formatted string
     * @see java.util.Formatter
     * @since 1.5
     */
    public static String format(String format, Object... args) {
        return format;
    }

    /**
     * Returns the string representation of the <code>Object</code> argument.
     * 
     * @param obj an <code>Object</code>.
     * @return if the argument is <code>null</code>, then a string equal to <code>"null"</code>;
     *         otherwise, the value of <code>obj.toString()</code> is returned.
     * @see java.lang.Object#toString()
     */
    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }

    /**
     * Returns the string representation of the <code>boolean</code> argument.
     * 
     * @param value a <code>boolean</code>.
     * @return if the argument is <code>true</code>, a string equal to <code>"true"</code> is
     *         returned; otherwise, a string equal to <code>"false"</code> is returned.
     */
    public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    /**
     * Returns the string representation of the <code>char</code> argument.
     * 
     * @param c a <code>char</code>.
     * @return a string of length <code>1</code> containing as its single character the argument
     *         <code>c</code>.
     */
    public static String valueOf(char c) {
        return (String) (Object) new NativeString(c);
    }

    /**
     * Returns the string representation of the <code>char</code> array argument. The contents of
     * the character array are copied; subsequent modification of the character array does not
     * affect the newly created string.
     * 
     * @param values a <code>char</code> array.
     * @return a newly allocated string representing the same sequence of characters contained in
     *         the character array argument.
     */
    public static String valueOf(char[] values) {
        Objects.requireNonNull(values);

        return valueOf(values, 0, values.length);
    }

    /**
     * Returns a String that represents the character sequence in the array specified.
     * 
     * @param values the character array.
     * @param offset initial offset of the subarray.
     * @param count length of the subarray.
     * @return a <code>String</code> that contains the characters of the specified subarray of the
     *         character array.
     */
    public static String valueOf(char[] values, int offset, int count) {
        Objects.requireNonNull(values);

        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }

        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }

        int end = offset + count;

        if (values.length < end) {
            throw new StringIndexOutOfBoundsException(end);
        }
        return (String) (Object) new NativeString(Arrays.copyOfRange(values, offset, end));
    }

    /**
     * Returns the string representation of the <code>int</code> argument.
     * <p>
     * The representation is exactly the one returned by the <code>Integer.toString</code> method of
     * one argument.
     * 
     * @param value an <code>int</code>.
     * @return a string representation of the <code>int</code> argument.
     * @see java.lang.Integer#toString(int, int)
     */
    public static String valueOf(int value) {
        return Integer.toString(value);
    }

    /**
     * Returns the string representation of the <code>long</code> argument.
     * <p>
     * The representation is exactly the one returned by the <code>Long.toString</code> method of
     * one argument.
     * 
     * @param value a <code>long</code>.
     * @return a string representation of the <code>long</code> argument.
     * @see java.lang.Long#toString(long)
     */
    public static String valueOf(long value) {
        return Long.toString(value);
    }

    /**
     * Returns the string representation of the <code>float</code> argument.
     * <p>
     * The representation is exactly the one returned by the <code>Float.toString</code> method of
     * one argument.
     * 
     * @param f a <code>float</code>.
     * @return a string representation of the <code>float</code> argument.
     * @see java.lang.Float#toString(float)
     */
    public static String valueOf(float f) {
        return Float.toString(f);
    }

    /**
     * Returns the string representation of the <code>double</code> argument.
     * <p>
     * The representation is exactly the one returned by the <code>Double.toString</code> method of
     * one argument.
     * 
     * @param d a <code>double</code>.
     * @return a string representation of the <code>double</code> argument.
     * @see java.lang.Double#toString(double)
     */
    public static String valueOf(double d) {
        return Double.toString(d);
    }
}
