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
    private NativeString character;

    /**
     * Constructs a newly allocated {@code Character} object that represents the specified
     * {@code char} value.
     * 
     * @param value the value to be represented by the {@code Character} object.
     */
    public JSCharacter(char value) {
        this.character = new NativeString(value);

        if (!Global.isString(character)) {
            this.character = ((JSCharacter) (Object) character).character;
        }
    }

    /**
     * @param character
     */
    private JSCharacter(NativeString character) {
        this.character = character;
    }

    /**
     * Compares two {@code char} values numerically. The value returned is identical to what would
     * be returned by:
     * 
     * <pre>
     *    Character.valueOf(x).compareTo(Character.valueOf(y))
     * </pre>
     * 
     * @param x the first {@code char} to compare
     * @param y the second {@code char} to compare
     * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y};
     *         and a value greater than {@code 0} if {@code x > y}
     * @since 1.7
     */
    public static int compare(char x, char y) {
        return new NativeString(x).charCodeAt(0) - new NativeString(y).charAt(0);
    }

    /**
     * Returns the numeric value of the character {@code ch} in the specified radix.
     * <p>
     * If the radix is not in the range {@code MIN_RADIX} &le; {@code radix} &le; {@code MAX_RADIX}
     * or if the value of {@code ch} is not a valid digit in the specified radix, {@code -1} is
     * returned. A character is a valid digit if at least one of the following is true:
     * <ul>
     * <li>The method {@code isDigit} is {@code true} of the character and the Unicode decimal digit
     * value of the character (or its single-character decomposition) is less than the specified
     * radix. In this case the decimal digit value is returned.
     * <li>The character is one of the uppercase Latin letters {@code 'A'} through {@code 'Z'} and
     * its code is less than {@code radix + 'A' - 10}. In this case, {@code ch - 'A' + 10} is
     * returned.
     * <li>The character is one of the lowercase Latin letters {@code 'a'} through {@code 'z'} and
     * its code is less than {@code radix + 'a' - 10}. In this case, {@code ch - 'a' + 10} is
     * returned.
     * <li>The character is one of the fullwidth uppercase Latin letters A ({@code '\u005CuFF21'})
     * through Z ({@code '\u005CuFF3A'}) and its code is less than
     * {@code radix + '\u005CuFF21' - 10}. In this case, {@code ch - '\u005CuFF21' + 10} is
     * returned.
     * <li>The character is one of the fullwidth lowercase Latin letters a ({@code '\u005CuFF41'})
     * through z ({@code '\u005CuFF5A'}) and its code is less than
     * {@code radix + '\u005CuFF41' - 10}. In this case, {@code ch - '\u005CuFF41' + 10} is
     * returned.
     * </ul>
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #digit(int, int)} method.
     * 
     * @param ch the character to be converted.
     * @param radix the radix.
     * @return the numeric value represented by the character in the specified radix.
     * @see Character#forDigit(int, int)
     * @see Character#isDigit(char)
     */
    public static int digit(char ch, int radix) {
        return Global.parseInt(String.valueOf(ch), radix);
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
     * Determines if the given {@code char} value is a <a
     * href="http://www.unicode.org/glossary/#high_surrogate_code_unit"> Unicode high-surrogate code
     * unit</a> (also known as <i>leading-surrogate code unit</i>).
     * <p>
     * Such values do not represent characters by themselves, but are used in the representation of
     * <a href="#supplementary">supplementary characters</a> in the UTF-16 encoding.
     * 
     * @param ch the {@code char} value to be tested.
     * @return {@code true} if the {@code char} value is between {@link #MIN_HIGH_SURROGATE} and
     *         {@link #MAX_HIGH_SURROGATE} inclusive; {@code false} otherwise.
     * @see Character#isLowSurrogate(char)
     * @see Character.UnicodeBlock#of(int)
     * @since 1.5
     */
    public static boolean isHighSurrogate(char ch) {
        // Help VM constant-fold; MAX_HIGH_SURROGATE + 1 == MIN_LOW_SURROGATE
        // return ch >= MIN_HIGH_SURROGATE && ch < (MAX_HIGH_SURROGATE + 1);

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Determines if the given {@code char} value is a <a
     * href="http://www.unicode.org/glossary/#low_surrogate_code_unit"> Unicode low-surrogate code
     * unit</a> (also known as <i>trailing-surrogate code unit</i>).
     * <p>
     * Such values do not represent characters by themselves, but are used in the representation of
     * <a href="#supplementary">supplementary characters</a> in the UTF-16 encoding.
     * 
     * @param ch the {@code char} value to be tested.
     * @return {@code true} if the {@code char} value is between {@link #MIN_LOW_SURROGATE} and
     *         {@link #MAX_LOW_SURROGATE} inclusive; {@code false} otherwise.
     * @see Character#isHighSurrogate(char)
     * @since 1.5
     */
    public static boolean isLowSurrogate(char ch) {
        // return ch >= MIN_LOW_SURROGATE && ch < (MAX_LOW_SURROGATE + 1);

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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
     * Determines if the specified character is a lowercase character.
     * <p>
     * A character is lowercase if its general category type, provided by
     * {@code Character.getType(ch)}, is {@code LOWERCASE_LETTER}, or it has contributory property
     * Other_Lowercase as defined by the Unicode Standard.
     * <p>
     * The following are examples of lowercase characters:
     * <p>
     * <blockquote>
     * 
     * <pre>
     * a b c d e f g h i j k l m n o p q r s t u v w x y z
     * '&#92;u00DF' '&#92;u00E0' '&#92;u00E1' '&#92;u00E2' '&#92;u00E3' '&#92;u00E4' '&#92;u00E5' '&#92;u00E6'
     * '&#92;u00E7' '&#92;u00E8' '&#92;u00E9' '&#92;u00EA' '&#92;u00EB' '&#92;u00EC' '&#92;u00ED' '&#92;u00EE'
     * '&#92;u00EF' '&#92;u00F0' '&#92;u00F1' '&#92;u00F2' '&#92;u00F3' '&#92;u00F4' '&#92;u00F5' '&#92;u00F6'
     * '&#92;u00F8' '&#92;u00F9' '&#92;u00FA' '&#92;u00FB' '&#92;u00FC' '&#92;u00FD' '&#92;u00FE' '&#92;u00FF'
     * </pre>
     * </blockquote>
     * <p>
     * Many other Unicode characters are lowercase too.
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #isLowerCase(int)} method.
     * 
     * @param ch the character to be tested.
     * @return {@code true} if the character is lowercase; {@code false} otherwise.
     * @see Character#isLowerCase(char)
     * @see Character#isTitleCase(char)
     * @see Character#toLowerCase(char)
     * @see Character#getType(char)
     */
    public static boolean isLowerCase(char ch) {
        return ch == toLowerCase(ch);
    }

    /**
     * Determines if the specified character (Unicode code point) is a lowercase character.
     * <p>
     * A character is lowercase if its general category type, provided by {@link Character#getType
     * getType(codePoint)}, is {@code LOWERCASE_LETTER}, or it has contributory property
     * Other_Lowercase as defined by the Unicode Standard.
     * <p>
     * The following are examples of lowercase characters:
     * <p>
     * <blockquote>
     * 
     * <pre>
     * a b c d e f g h i j k l m n o p q r s t u v w x y z
     * '&#92;u00DF' '&#92;u00E0' '&#92;u00E1' '&#92;u00E2' '&#92;u00E3' '&#92;u00E4' '&#92;u00E5' '&#92;u00E6'
     * '&#92;u00E7' '&#92;u00E8' '&#92;u00E9' '&#92;u00EA' '&#92;u00EB' '&#92;u00EC' '&#92;u00ED' '&#92;u00EE'
     * '&#92;u00EF' '&#92;u00F0' '&#92;u00F1' '&#92;u00F2' '&#92;u00F3' '&#92;u00F4' '&#92;u00F5' '&#92;u00F6'
     * '&#92;u00F8' '&#92;u00F9' '&#92;u00FA' '&#92;u00FB' '&#92;u00FC' '&#92;u00FD' '&#92;u00FE' '&#92;u00FF'
     * </pre>
     * </blockquote>
     * <p>
     * Many other Unicode characters are lowercase too.
     * 
     * @param codePoint the character (Unicode code point) to be tested.
     * @return {@code true} if the character is lowercase; {@code false} otherwise.
     * @see Character#isLowerCase(int)
     * @see Character#isTitleCase(int)
     * @see Character#toLowerCase(int)
     * @see Character#getType(int)
     * @since 1.5
     */
    public static boolean isLowerCase(int codePoint) {
        return isLowerCase(NativeString.fromCharCode(codePoint).charAt(0));
    }

    /**
     * Determines if the specified character is an uppercase character.
     * <p>
     * A character is uppercase if its general category type, provided by
     * {@code Character.getType(ch)}, is {@code UPPERCASE_LETTER}. or it has contributory property
     * Other_Uppercase as defined by the Unicode Standard.
     * <p>
     * The following are examples of uppercase characters:
     * <p>
     * <blockquote>
     * 
     * <pre>
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
     * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
     * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
     * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
     * </pre>
     * </blockquote>
     * <p>
     * Many other Unicode characters are uppercase too.
     * <p>
     * <p>
     * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary
     * characters</a>. To support all Unicode characters, including supplementary characters, use
     * the {@link #isUpperCase(int)} method.
     * 
     * @param ch the character to be tested.
     * @return {@code true} if the character is uppercase; {@code false} otherwise.
     * @see Character#isLowerCase(char)
     * @see Character#isTitleCase(char)
     * @see Character#toUpperCase(char)
     * @see Character#getType(char)
     * @since 1.0
     */
    public static boolean isUpperCase(char ch) {
        return ch == toUpperCase(ch);
    }

    /**
     * Determines if the specified character (Unicode code point) is an uppercase character.
     * <p>
     * A character is uppercase if its general category type, provided by
     * {@link Character#getType(int) getType(codePoint)}, is {@code UPPERCASE_LETTER}, or it has
     * contributory property Other_Uppercase as defined by the Unicode Standard.
     * <p>
     * The following are examples of uppercase characters:
     * <p>
     * <blockquote>
     * 
     * <pre>
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
     * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
     * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
     * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
     * </pre>
     * </blockquote>
     * <p>
     * Many other Unicode characters are uppercase too.
     * <p>
     * 
     * @param codePoint the character (Unicode code point) to be tested.
     * @return {@code true} if the character is uppercase; {@code false} otherwise.
     * @see Character#isLowerCase(int)
     * @see Character#isTitleCase(int)
     * @see Character#toUpperCase(int)
     * @see Character#getType(int)
     * @since 1.5
     */
    public static boolean isUpperCase(int codePoint) {
        return isUpperCase(NativeString.fromCharCode(codePoint).charAt(0));
    }

    /**
     * Converts the specified surrogate pair to its supplementary code point value. This method does
     * not validate the specified surrogate pair. The caller must validate it using
     * {@link #isSurrogatePair(char, char) isSurrogatePair} if necessary.
     * 
     * @param high the high-surrogate code unit
     * @param low the low-surrogate code unit
     * @return the supplementary code point composed from the specified surrogate pair.
     * @since 1.5
     */
    public static int toCodePoint(char high, char low) {
        // return ((high << 10) + low) + (MIN_SUPPLEMENTARY_CODE_POINT - (MIN_HIGH_SURROGATE << 10)
        // - MIN_LOW_SURROGATE);

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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
     * Returns the value obtained by reversing the order of the bytes in the specified <tt>char</tt>
     * value.
     * 
     * @return the value obtained by reversing (or, equivalently, swapping) the bytes in the
     *         specified <tt>char</tt> value.
     * @since 1.5
     */
    public static char reverseBytes(char c) {
        return (char) (((c & 0xFF00) >> 8) | (c << 8));
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
    public NativeString valueOf() {
        return character;
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
