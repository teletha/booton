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
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * <p>
 * {@link Character} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/09/24 13:09:55
 */
@JavaAPIProvider(Character.class)
class JSCharacter implements JavascriptNative {

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
        /**
         * The following code is ideal, but it is too slow because try-catch block in javascript
         * runtime (especially webkit). So we can't adopt it.
         * 
         * <pre>
         * try {
         *   Float.parseFloat(String.valueOf(ch));
         *
         *   return true;
         * } catch (NumberFormatException e) {
         *   return false;
         * }
         * </pre>
         */
        return Global.isNumeric(ch);
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
        // FIXME
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Determines if the specified character (Unicode code point) is an alphabet.
     * <p>
     * A character is considered to be alphabetic if its general category type, provided by
     * {@link Character#getType(int) getType(codePoint)}, is any of the following:
     * <ul>
     * <li> <code>UPPERCASE_LETTER</code>
     * <li> <code>LOWERCASE_LETTER</code>
     * <li> <code>TITLECASE_LETTER</code>
     * <li> <code>MODIFIER_LETTER</code>
     * <li> <code>OTHER_LETTER</code>
     * <li> <code>LETTER_NUMBER</code>
     * </ul>
     * or it has contributory property Other_Alphabetic as defined by the Unicode Standard.
     * 
     * @param codePoint the character (Unicode code point) to be tested.
     * @return <code>true</code> if the character is a Unicode alphabet character,
     *         <code>false</code> otherwise.
     * @since 1.7
     */
    public static boolean isAlphabetic(int codePoint) {
        return 'a' <= codePoint && codePoint <= 'z' || 'A' <= codePoint && codePoint <= 'Z';
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
     * Converts the character argument to lowercase using case mapping information from the
     * UnicodeData file.
     * <p>
     * Note that {@code Character.isLowerCase(Character.toLowerCase(ch))} does not always return
     * {@code true} for some ranges of characters, particularly those that are symbols or
     * ideographs.
     * <p>
     * In general, {@link String#toLowerCase()} should be used to map characters to lowercase.
     * {@code String} case mapping methods have several benefits over {@code Character} case mapping
     * methods. {@code String} case mapping methods can perform locale-sensitive mappings,
     * context-sensitive mappings, and 1:M character mappings, whereas the {@code Character} case
     * mapping methods cannot.
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #toLowerCase(int)} method.
     * 
     * @param ch the character to be converted.
     * @return the lowercase equivalent of the character, if any; otherwise, the character itself.
     * @see Character#isLowerCase(char)
     * @see String#toLowerCase()
     */
    public static char toLowerCase(char ch) {
        NativeString value = new NativeString(ch);
        return value.toLowerCase().charAt(0);
    }

    /**
     * Converts the character argument to uppercase using case mapping information from the
     * UnicodeData file.
     * <p>
     * Note that {@code Character.isUpperCase(Character.toUpperCase(ch))} does not always return
     * {@code true} for some ranges of characters, particularly those that are symbols or
     * ideographs.
     * <p>
     * In general, {@link String#toUpperCase()} should be used to map characters to uppercase.
     * {@code String} case mapping methods have several benefits over {@code Character} case mapping
     * methods. {@code String} case mapping methods can perform locale-sensitive mappings,
     * context-sensitive mappings, and 1:M character mappings, whereas the {@code Character} case
     * mapping methods cannot.
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #toUpperCase(int)} method.
     * 
     * @param ch the character to be converted.
     * @return the uppercase equivalent of the character, if any; otherwise, the character itself.
     * @see Character#isUpperCase(char)
     * @see String#toUpperCase()
     */
    public static char toUpperCase(char ch) {
        NativeString value = new NativeString(ch);
        return value.toUpperCase().charAt(0);
    }

    /**
     * Returns a <tt>Character</tt> instance representing the specified <tt>char</tt> value. If a
     * new <tt>Character</tt> instance is not required, this method should generally be used in
     * preference to the constructor {@link #Character(char)}, as this method is likely to yield
     * significantly better space and time performance by caching frequently requested values. This
     * method will always cache values in the range {@code '\u005Cu0000'} to {@code '\u005Cu007F'},
     * inclusive, and may cache other values outside of this range.
     * 
     * @param ch a char value.
     * @return a <tt>Character</tt> instance representing <tt>c</tt>.
     * @since 1.5
     */
    public static Character valueOf(char ch) {
        return (Character) (Object) new JSCharacter(new NativeString(ch));
    }

    /**
     * <p>
     * Returns the primitive value of this object.
     * </p>
     * <p>
     * JavaScript calls the valueOf method to convert an object to a primitive value. You rarely
     * need to invoke the valueOf method yourself; JavaScript automatically invokes it when
     * encountering an object where a primitive value is expected.
     * </p>
     * <p>
     * You can create a function to be called in place of the default valueOf method. Your function
     * must take no arguments.
     * </p>
     * 
     * @return A primitive value.
     */
    @JavascriptNativeProperty
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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JSCharacter) {
            return character.equals(((JSCharacter) obj).character);
        }
        return false;
    }

    /**
     * @version 2013/04/16 22:57:09
     */
    @JavaAPIProvider(char.class)
    private static class Primitive {
    }
}
