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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/04/15 21:24:44
 */
@JavaAPIProvider(StringBuilder.class)
class JSStringBuilder {

    /** The native strint expression. */
    private NativeString text;

    private NativeArray values;

    /**
     * Constructs a string builder with no characters in it and an initial capacity of 16
     * characters.
     */
    public JSStringBuilder() {
        text = new NativeString();
    }

    /**
     * Constructs a string builder with no characters in it and an initial capacity specified by the
     * <code>capacity</code> argument.
     * 
     * @param capacity the initial capacity.
     * @throws NegativeArraySizeException if the <code>capacity</code> argument is less than
     *             <code>0</code>.
     */
    public JSStringBuilder(int capacity) {
        this();
    }

    /**
     * Constructs a string builder initialized to the contents of the specified string. The initial
     * capacity of the string builder is <code>16</code> plus the length of the string argument.
     * 
     * @param value the initial contents of the buffer.
     * @throws NullPointerException if <code>value</code> is <code>null</code>
     */
    public JSStringBuilder(String value) {
        this();

        append(value);
    }

    /**
     * Constructs a string builder that contains the same characters as the specified
     * <code>CharSequence</code>. The initial capacity of the string builder is <code>16</code> plus
     * the length of the <code>CharSequence</code> argument.
     * 
     * @param sequence the sequence to copy.
     * @throws NullPointerException if <code>seq</code> is <code>null</code>
     */
    public JSStringBuilder(CharSequence sequence) {
        this();

        append((String) sequence);
    }

    /**
     * <p>
     * Appends the specified string to this character sequence.
     * </p>
     * <p>
     * The characters of the String argument are appended, in order, increasing the length of this
     * sequence by the length of the argument. If str is null, then the four characters "null" are
     * appended.
     * </p>
     * <p>
     * Let n be the length of this character sequence just prior to execution of the append method.
     * Then the character at index k in the new character sequence is equal to the character at
     * index k in the old character sequence, if k is less than n; otherwise, it is equal to the
     * character at index k-n in the argument value.
     * </p>
     * 
     * @param value
     * @return Chainable API.
     */
    public StringBuilder append(String value) {
        text = text.concat(value);

        return (StringBuilder) (Object) this;
    }

    /**
     * Appends the specified <code>CharSequence</code> to this sequence.
     * <p>
     * The characters of the <code>CharSequence</code> argument are appended, in order, increasing
     * the length of this sequence by the length of the argument.
     * <p>
     * The result of this method is exactly the same as if it were an invocation of this.append(s,
     * 0, s.length());
     * <p>
     * This method synchronizes on this (the destination) object but does not synchronize on the
     * source (<code>s</code>).
     * <p>
     * If <code>s</code> is <code>null</code>, then the four characters <code>"null"</code> are
     * appended.
     * 
     * @param value the <code>CharSequence</code> to append.
     * @return a reference to this object.
     * @since 1.5
     */
    public StringBuilder append(CharSequence value) {
        return append(String.valueOf(value));
    }

    /**
     * Appends a subsequence of the specified {@code CharSequence} to this sequence.
     * <p>
     * Characters of the argument {@code s}, starting at index {@code start}, are appended, in
     * order, to the contents of this sequence up to the (exclusive) index {@code end}. The length
     * of this sequence is increased by the value of {@code end - start}.
     * <p>
     * Let <i>n</i> be the length of this character sequence just prior to execution of the
     * {@code append} method. Then the character at index <i>k</i> in this character sequence
     * becomes equal to the character at index <i>k</i> in this sequence, if <i>k</i> is less than
     * <i>n</i>; otherwise, it is equal to the character at index <i>k+start-n</i> in the argument
     * {@code s}.
     * <p>
     * If {@code s} is {@code null}, then this method appends characters as if the s parameter was a
     * sequence containing the four characters {@code "null"}.
     * 
     * @param sequence the sequence to append.
     * @param start the starting index of the subsequence to be appended.
     * @param end the end index of the subsequence to be appended.
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if {@code start} is negative, or {@code start} is greater
     *             than {@code end} or {@code end} is greater than {@code s.length()}
     */
    public StringBuilder append(CharSequence sequence, int start, int end) {
        if (sequence == null) {
            sequence = "null";
        }
        return append((Object) sequence.subSequence(start, end));
    }

    /**
     * <p>
     * Appends the string representation of the Object argument.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(Object), and the characters of that string were then appended to this
     * character sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(Object value) {
        return append(String.valueOf(value));
    }

    /**
     * Appends the string representation of the {@code char} array argument to this sequence.
     * <p>
     * The characters of the array argument are appended, in order, to the contents of this
     * sequence. The length of this sequence increases by the length of the argument.
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * {@link String#valueOf(char[])}, and the characters of that string were then
     * {@link #append(String) appended} to this character sequence.
     * 
     * @param value the characters to be appended.
     * @return a reference to this object.
     */
    public StringBuilder append(char[] value) {
        return append(String.valueOf(value));
    }

    /**
     * Appends the string representation of a subarray of the {@code char} array argument to this
     * sequence.
     * <p>
     * Characters of the {@code char} array {@code str}, starting at index {@code offset}, are
     * appended, in order, to the contents of this sequence. The length of this sequence increases
     * by the value of {@code len}.
     * <p>
     * The overall effect is exactly as if the arguments were converted to a string by the method
     * {@link String#valueOf(char[],int,int)}, and the characters of that string were then
     * {@link #append(String) appended} to this character sequence.
     * 
     * @param value the characters to be appended.
     * @param offset the index of the first {@code char} to append.
     * @param length the number of {@code char}s to append.
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if {@code offset < 0} or {@code len < 0} or
     *             {@code offset+len > str.length}
     */
    public StringBuilder append(char[] value, int offset, int length) {
        return append(String.valueOf(value, offset, length));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(int value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(long value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(float value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(double value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(boolean value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(byte value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the number argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(short value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Appends the string representation of the char argument to this sequence.
     * </p>
     * <p>
     * The overall effect is exactly as if the argument were converted to a string by the method
     * String.valueOf(value), and the characters of that string were then appended to this character
     * sequence.
     * </p>
     * 
     * @param value A value to append.
     * @return Chainable API.
     */
    public StringBuilder append(char value) {
        return append(String.valueOf(value));
    }

    /**
     * <p>
     * Returns the char value in this sequence at the specified index. The first char value is at
     * index 0, the next at index 1, and so on, as in array indexing.
     * </p>
     * <p>
     * The index argument must be greater than or equal to 0, and less than the length of this
     * sequence.
     * </p>
     * <p>
     * If the char value specified by the index is a surrogate, the surrogate value is returned.
     * </p>
     * 
     * @param index The index of the desired char value.
     * @return The char value at the specified index.
     */
    public char charAt(int index) {
        return text.charAt(index);
    }

    /**
     * <p>
     * Returns the character (Unicode code point) at the specified index. The index refers to char
     * values (Unicode code units) and ranges from 0 to length() - 1.
     * </p>
     * <p>
     * If the char value specified at the given index is in the high-surrogate range, the following
     * index is less than the length of this sequence, and the char value at the following index is
     * in the low-surrogate range, then the supplementary code point corresponding to this surrogate
     * pair is returned. Otherwise, the char value at the given index is returned.
     * </p>
     * 
     * @param index The index to the char values.
     * @return The code point value of the character at the index.
     */
    public int codePointAt(int index) {
        return text.charCodeAt(index);
    }

    /**
     * <p>
     * Removes the characters in a substring of this sequence. The substring begins at the specified
     * start and extends to the character at index end - 1 or to the end of the sequence if no such
     * character exists. If start is equal to end, no changes are made.
     * </p>
     * 
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @return Chainable API.
     */
    public StringBuilder delete(int start, int end) {
        text = text.substring(0, start - 1).concat(text.substring(end));

        return (StringBuilder) (Object) this;
    }

    /**
     * <p>
     * Removes the char at the specified position in this sequence. This sequence is shortened by
     * one char.
     * </p>
     * <p>
     * Note: If the character at the given index is a supplementary character, this method does not
     * remove the entire character. If correct handling of supplementary characters is required,
     * determine the number of chars to remove by calling
     * Character.charCount(thisSequence.codePointAt(index)), where thisSequence is this sequence.
     * </p>
     * 
     * @param index Index of char to remove.
     * @return Chainable API.
     */
    public StringBuilder deleteCharAt(int index) {
        return delete(index + 1, index + 1);
    }

    /**
     * Returns the length (character count).
     * 
     * @return the length of the sequence of characters currently represented by this object
     */
    public int length() {
        return text.length();
    }

    /**
     * Inserts the string into this character sequence.
     * <p>
     * The characters of the {@code String} argument are inserted, in order, into this sequence at
     * the indicated offset, moving up any characters originally above that position and increasing
     * the length of this sequence by the length of the argument. If {@code str} is {@code null},
     * then the four characters {@code "null"} are inserted into this sequence.
     * <p>
     * The character at index <i>k</i> in the new character sequence is equal to:
     * <ul>
     * <li>the character at index <i>k</i> in the old character sequence, if <i>k</i> is less than
     * {@code offset}
     * <li>the character at index <i>k</i>{@code -offset} in the argument {@code str}, if <i>k</i>
     * is not less than {@code offset} but is less than {@code offset+str.length()}
     * <li>the character at index <i>k</i>{@code -str.length()} in the old character sequence, if
     * <i>k</i> is not less than {@code offset+str.length()}
     * </ul>
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a string.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, String value) {
        if (offset < 0 || length() < offset) {
            throw new StringIndexOutOfBoundsException(offset);
        }

        // normalize value
        value = String.valueOf(value);

        text = text.substring(0, offset).concat(value).concat(text.substring(offset));

        // API definiton
        return (StringBuilder) (Object) this;
    }

    /**
     * Inserts the specified {@code CharSequence} into this sequence.
     * <p>
     * The characters of the {@code CharSequence} argument are inserted, in order, into this
     * sequence at the indicated offset, moving up any characters originally above that position and
     * increasing the length of this sequence by the length of the argument s.
     * <p>
     * The result of this method is exactly the same as if it were an invocation of this object's
     * {@link #insert(int,CharSequence,int,int) insert}(dstOffset, s, 0, s.length()) method.
     * <p>
     * If {@code s} is {@code null}, then the four characters {@code "null"} are inserted into this
     * sequence.
     * 
     * @param offset the offset.
     * @param value the sequence to be inserted
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, CharSequence value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts a subsequence of the specified {@code CharSequence} into this sequence.
     * <p>
     * The subsequence of the argument {@code s} specified by {@code start} and {@code end} are
     * inserted, in order, into this sequence at the specified destination offset, moving up any
     * characters originally above that position. The length of this sequence is increased by
     * {@code end - start}.
     * <p>
     * The character at index <i>k</i> in this sequence becomes equal to:
     * <ul>
     * <li>the character at index <i>k</i> in this sequence, if <i>k</i> is less than
     * {@code dstOffset}
     * <li>the character at index <i>k</i>{@code +start-dstOffset} in the argument {@code s}, if
     * <i>k</i> is greater than or equal to {@code dstOffset} but is less than
     * {@code dstOffset+end-start}
     * <li>the character at index <i>k</i>{@code -(end-start)} in this sequence, if <i>k</i> is
     * greater than or equal to {@code dstOffset+end-start}
     * </ul>
     * <p>
     * The {@code dstOffset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * <p>
     * The start argument must be nonnegative, and not greater than {@code end}.
     * <p>
     * The end argument must be greater than or equal to {@code start}, and less than or equal to
     * the length of s.
     * <p>
     * If {@code s} is {@code null}, then this method inserts characters as if the s parameter was a
     * sequence containing the four characters {@code "null"}.
     * 
     * @param offset the offset in this sequence.
     * @param sequence the sequence to be inserted.
     * @param start the starting index of the subsequence to be inserted.
     * @param end the end index of the subsequence to be inserted.
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if {@code dstOffset} is negative or greater than
     *             {@code this.length()}, or {@code start} or {@code end} are negative, or
     *             {@code start} is greater than {@code end} or {@code end} is greater than
     *             {@code s.length()}
     */
    public StringBuilder insert(int offset, CharSequence sequence, int start, int end) {
        if (sequence == null) {
            sequence = "null";
        }
        return insert(offset, (Object) sequence.subSequence(start, end));
    }

    /**
     * Inserts the string representation of the {@code Object} argument into this character
     * sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(Object)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value an {@code Object}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, Object value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the {@code char} array argument into this sequence.
     * <p>
     * The characters of the array argument are inserted into the contents of this sequence at the
     * position indicated by {@code offset}. The length of this sequence increases by the length of
     * the argument.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(char[])}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a character array.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, char[] value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of a subarray of the {@code str} array argument into this
     * sequence. The subarray begins at the specified {@code offset} and extends {@code len}
     * {@code char}s. The characters of the subarray are inserted into this sequence at the position
     * indicated by {@code index}. The length of this sequence increases by {@code len} {@code char}
     * s.
     * 
     * @param index position at which to insert subarray.
     * @param values A {@code char} array.
     * @param offset the index of the first {@code char} in subarray to be inserted.
     * @param length the number of {@code char}s in the subarray to be inserted.
     * @return This object
     * @throws StringIndexOutOfBoundsException if {@code index} is negative or greater than
     *             {@code length()}, or {@code offset} or {@code len} are negative, or
     *             {@code (offset+len)} is greater than {@code str.length}.
     */
    public StringBuilder insert(int index, char[] values, int offset, int length) {
        return insert(index, String.valueOf(values, offset, length));
    }

    /**
     * Inserts the string representation of the {@code boolean} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(boolean)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a {@code boolean}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, boolean value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the {@code char} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(char)}, and the character in that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a {@code char}.
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, char value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the second {@code int} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(int)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value an {@code int}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, int value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the {@code long} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(long)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a {@code long}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, long value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the {@code float} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(float)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a {@code float}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, float value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * Inserts the string representation of the {@code double} argument into this sequence.
     * <p>
     * The overall effect is exactly as if the second argument were converted to a string by the
     * method {@link String#valueOf(double)}, and the characters of that string were then
     * {@link #insert(int,String) inserted} into this character sequence at the indicated offset.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0}, and less than or
     * equal to the {@linkplain #length() length} of this sequence.
     * 
     * @param offset the offset.
     * @param value a {@code double}.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    public StringBuilder insert(int offset, double value) {
        return insert(offset, String.valueOf(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return text.toString();
    }
}
