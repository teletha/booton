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

import jsx.jQuery;
import booton.translator.JavaAPIProvider;
import booton.translator.JavascriptNativePrimitiveNumber;

/**
 * <p>
 * {@link Character} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Character.class)
class JSCharacter implements JavascriptNativePrimitiveNumber {

    /** The primitive char class. */
    public static final Class TYPE = Primitive.class;

    /** The actual character. */
    private final NativeString character;

    /**
     * @param character
     */
    private JSCharacter(NativeString character) {
        this.character = character;
    }

    /**
     * Determines if the specified character is a digit.
     * <p>
     * A character is a digit if its general category type, provided by
     * {@code Character.getType(ch)}, is {@code DECIMAL_DIGIT_NUMBER}.
     * <p>
     * Some Unicode character ranges that contain digits:
     * <ul>
     * <li>{@code '\u005Cu0030'} through {@code '\u005Cu0039'}, ISO-LATIN-1 digits ({@code '0'}
     * through {@code '9'})
     * <li>{@code '\u005Cu0660'} through {@code '\u005Cu0669'}, Arabic-Indic digits
     * <li>{@code '\u005Cu06F0'} through {@code '\u005Cu06F9'}, Extended Arabic-Indic digits
     * <li>{@code '\u005Cu0966'} through {@code '\u005Cu096F'}, Devanagari digits
     * <li>{@code '\u005CuFF10'} through {@code '\u005CuFF19'}, Fullwidth digits
     * </ul>
     * Many other character ranges contain digits as well.
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #isDigit(int)} method.
     * 
     * @param ch the character to be tested.
     * @return {@code true} if the character is a digit; {@code false} otherwise.
     * @see Character#digit(char, int)
     * @see Character#forDigit(int, int)
     * @see Character#getType(char)
     */
    public static boolean isDigit(char ch) {
        return jQuery.isNumeric(ch);
    }

    /**
     * Determines if the specified character (Unicode code point) is a digit.
     * <p>
     * A character is a digit if its general category type, provided by
     * {@link Character#getType(int) getType(codePoint)}, is {@code DECIMAL_DIGIT_NUMBER}.
     * <p>
     * Some Unicode character ranges that contain digits:
     * <ul>
     * <li>{@code '\u005Cu0030'} through {@code '\u005Cu0039'}, ISO-LATIN-1 digits ({@code '0'}
     * through {@code '9'})
     * <li>{@code '\u005Cu0660'} through {@code '\u005Cu0669'}, Arabic-Indic digits
     * <li>{@code '\u005Cu06F0'} through {@code '\u005Cu06F9'}, Extended Arabic-Indic digits
     * <li>{@code '\u005Cu0966'} through {@code '\u005Cu096F'}, Devanagari digits
     * <li>{@code '\u005CuFF10'} through {@code '\u005CuFF19'}, Fullwidth digits
     * </ul>
     * Many other character ranges contain digits as well.
     * 
     * @param codePoint the character (Unicode code point) to be tested.
     * @return {@code true} if the character is a digit; {@code false} otherwise.
     * @see Character#forDigit(int, int)
     * @see Character#getType(int)
     * @since 1.5
     */
    public static boolean isDigit(int codePoint) {
        return jQuery.isNumeric(codePoint);
    }

    /**
     * Determines if the specified character is white space according to Java. A character is a Java
     * whitespace character if and only if it satisfies one of the following criteria:
     * <ul>
     * <li>It is a Unicode space character ({@code SPACE_SEPARATOR}, {@code LINE_SEPARATOR}, or
     * {@code PARAGRAPH_SEPARATOR}) but is not also a non-breaking space ({@code '\u005Cu00A0'},
     * {@code '\u005Cu2007'}, {@code '\u005Cu202F'}).
     * <li>It is {@code '\u005Ct'}, U+0009 HORIZONTAL TABULATION.
     * <li>It is {@code '\u005Cn'}, U+000A LINE FEED.
     * <li>It is {@code '\u005Cu000B'}, U+000B VERTICAL TABULATION.
     * <li>It is {@code '\u005Cf'}, U+000C FORM FEED.
     * <li>It is {@code '\u005Cr'}, U+000D CARRIAGE RETURN.
     * <li>It is {@code '\u005Cu001C'}, U+001C FILE SEPARATOR.
     * <li>It is {@code '\u005Cu001D'}, U+001D GROUP SEPARATOR.
     * <li>It is {@code '\u005Cu001E'}, U+001E RECORD SEPARATOR.
     * <li>It is {@code '\u005Cu001F'}, U+001F UNIT SEPARATOR.
     * </ul>
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #isWhitespace(int)} method.
     * 
     * @param ch the character to be tested.
     * @return {@code true} if the character is a Java whitespace character; {@code false}
     *         otherwise.
     * @see Character#isSpaceChar(char)
     * @since 1.1
     */
    public static boolean isWhitespace(char ch) {
        return isWhitespace((int) ch);
    }

    /**
     * Determines if the specified character (Unicode code point) is white space according to Java.
     * A character is a Java whitespace character if and only if it satisfies one of the following
     * criteria:
     * <ul>
     * <li>It is a Unicode space character ({@link #SPACE_SEPARATOR}, {@link #LINE_SEPARATOR}, or
     * {@link #PARAGRAPH_SEPARATOR}) but is not also a non-breaking space ({@code '\u005Cu00A0'},
     * {@code '\u005Cu2007'}, {@code '\u005Cu202F'}).
     * <li>It is {@code '\u005Ct'}, U+0009 HORIZONTAL TABULATION.
     * <li>It is {@code '\u005Cn'}, U+000A LINE FEED.
     * <li>It is {@code '\u005Cu000B'}, U+000B VERTICAL TABULATION.
     * <li>It is {@code '\u005Cf'}, U+000C FORM FEED.
     * <li>It is {@code '\u005Cr'}, U+000D CARRIAGE RETURN.
     * <li>It is {@code '\u005Cu001C'}, U+001C FILE SEPARATOR.
     * <li>It is {@code '\u005Cu001D'}, U+001D GROUP SEPARATOR.
     * <li>It is {@code '\u005Cu001E'}, U+001E RECORD SEPARATOR.
     * <li>It is {@code '\u005Cu001F'}, U+001F UNIT SEPARATOR.
     * </ul>
     * <p>
     * 
     * @param codePoint the character (Unicode code point) to be tested.
     * @return {@code true} if the character is a Java whitespace character; {@code false}
     *         otherwise.
     * @see Character#isSpaceChar(int)
     * @since 1.5
     */
    public static boolean isWhitespace(int codePoint) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NativeNumber valueOf() {
        return new NativeNumber(character.charCodeAt(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return character.toString();
    }

    /**
     * @version 2013/04/16 22:57:09
     */
    @JavaAPIProvider(char.class)
    private static class Primitive {
    }
}
