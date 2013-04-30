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
     * @param seq the sequence to copy.
     * @throws NullPointerException if <code>seq</code> is <code>null</code>
     */
    public JSStringBuilder(CharSequence seq) {
        this();

        append(seq);
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

    // // Appends the specified string builder to this sequence.
    // private JSStringBuilder append(JSStringBuilder sb) {
    // if (sb == null) return append("null");
    // int len = sb.length();
    // int newcount = count + len;
    // if (newcount > value.length) expandCapacity(newcount);
    // sb.getChars(0, len, value, count);
    // count = newcount;
    // return this;
    // }
    //
    // /**
    // * Appends the specified <tt>StringBuffer</tt> to this sequence.
    // * <p>
    // * The characters of the <tt>StringBuffer</tt> argument are appended, in order, to this
    // * sequence, increasing the length of this sequence by the length of the argument. If
    // * <tt>sb</tt> is <tt>null</tt>, then the four characters <tt>"null"</tt> are appended to this
    // * sequence.
    // * <p>
    // * Let <i>n</i> be the length of this character sequence just prior to execution of the
    // * <tt>append</tt> method. Then the character at index <i>k</i> in the new character sequence
    // is
    // * equal to the character at index <i>k</i> in the old character sequence, if <i>k</i> is less
    // * than <i>n</i>; otherwise, it is equal to the character at index <i>k-n</i> in the argument
    // * <code>sb</code>.
    // *
    // * @param sb the <tt>StringBuffer</tt> to append.
    // * @return a reference to this object.
    // */
    // public JSStringBuilder append(StringBuffer sb) {
    // super.append(sb);
    // return this;
    // }
    //
    // /**
    // */
    // public JSStringBuilder append(CharSequence s) {
    // if (s == null) s = "null";
    // if (s instanceof String) return this.append((String) s);
    // if (s instanceof StringBuffer) return this.append((StringBuffer) s);
    // if (s instanceof JSStringBuilder) return this.append((JSStringBuilder) s);
    // return this.append(s, 0, s.length());
    // }
    //
    // /**
    // * @throws IndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder append(CharSequence s, int start, int end) {
    // super.append(s, start, end);
    // return this;
    // }
    //
    // public JSStringBuilder append(char[] str) {
    // super.append(str);
    // return this;
    // }
    //
    // /**
    // * @throws IndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder append(char[] str, int offset, int len) {
    // super.append(str, offset, len);
    // return this;
    // }
    //
    // public JSStringBuilder append(boolean b) {
    // super.append(b);
    // return this;
    // }
    //
    // public JSStringBuilder append(char c) {
    // super.append(c);
    // return this;
    // }
    //
    // public JSStringBuilder append(int i) {
    // super.append(i);
    // return this;
    // }
    //
    // public JSStringBuilder append(long lng) {
    // super.append(lng);
    // return this;
    // }
    //
    // public JSStringBuilder append(float f) {
    // super.append(f);
    // return this;
    // }
    //
    // public JSStringBuilder append(double d) {
    // super.append(d);
    // return this;
    // }
    //
    // /**
    // * @since 1.5
    // */
    // public JSStringBuilder appendCodePoint(int codePoint) {
    // super.appendCodePoint(codePoint);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder delete(int start, int end) {
    // super.delete(start, end);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder deleteCharAt(int index) {
    // super.deleteCharAt(index);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder replace(int start, int end, String str) {
    // super.replace(start, end, str);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int index, char[] str, int offset, int len) {
    // super.insert(index, str, offset, len);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, Object obj) {
    // return insert(offset, String.valueOf(obj));
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, String str) {
    // super.insert(offset, str);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, char[] str) {
    // super.insert(offset, str);
    // return this;
    // }
    //
    // /**
    // * @throws IndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int dstOffset, CharSequence s) {
    // if (s == null) s = "null";
    // if (s instanceof String) return this.insert(dstOffset, (String) s);
    // return this.insert(dstOffset, s, 0, s.length());
    // }
    //
    // /**
    // * @throws IndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
    // super.insert(dstOffset, s, start, end);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, boolean b) {
    // super.insert(offset, b);
    // return this;
    // }
    //
    // /**
    // * @throws IndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, char c) {
    // super.insert(offset, c);
    // return this;
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, int i) {
    // return insert(offset, String.valueOf(i));
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, long l) {
    // return insert(offset, String.valueOf(l));
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, float f) {
    // return insert(offset, String.valueOf(f));
    // }
    //
    // /**
    // * @throws StringIndexOutOfBoundsException {@inheritDoc}
    // */
    // public JSStringBuilder insert(int offset, double d) {
    // return insert(offset, String.valueOf(d));
    // }
    //
    // /**
    // * @throws NullPointerException {@inheritDoc}
    // */
    // public int indexOf(String str) {
    // return indexOf(str, 0);
    // }
    //
    // /**
    // * @throws NullPointerException {@inheritDoc}
    // */
    // public int indexOf(String str, int fromIndex) {
    // return String.indexOf(value, 0, count, str.toCharArray(), 0, str.length(), fromIndex);
    // }
    //
    // /**
    // * @throws NullPointerException {@inheritDoc}
    // */
    // public int lastIndexOf(String str) {
    // return lastIndexOf(str, count);
    // }
    //
    // /**
    // * @throws NullPointerException {@inheritDoc}
    // */
    // public int lastIndexOf(String str, int fromIndex) {
    // return String.lastIndexOf(value, 0, count, str.toCharArray(), 0, str.length(), fromIndex);
    // }
    //
    // public JSStringBuilder reverse() {
    // super.reverse();
    // return this;
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return text.toString();
    }
}
