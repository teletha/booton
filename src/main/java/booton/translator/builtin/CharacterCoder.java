/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2013/04/13 9:35:11
 */
class CharacterCoder extends Translator<Character> {

    public String isDigit(char param0) {
        return "jQuery.isNumeric(" + param(0) + ")";
    }

    public String valueOf(char param0) {
        return param(0);
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
    public String digit(char ch, int radix) {
        return "parseInt(" + param(0) + "," + param(1) + ")";
    }

    /**
     * Returns the numeric value of the specified character (Unicode code point) in the specified
     * radix.
     * <p>
     * If the radix is not in the range {@code MIN_RADIX} &le; {@code radix} &le; {@code MAX_RADIX}
     * or if the character is not a valid digit in the specified radix, {@code -1} is returned. A
     * character is a valid digit if at least one of the following is true:
     * <ul>
     * <li>The method {@link #isDigit(int) isDigit(codePoint)} is {@code true} of the character and
     * the Unicode decimal digit value of the character (or its single-character decomposition) is
     * less than the specified radix. In this case the decimal digit value is returned.
     * <li>The character is one of the uppercase Latin letters {@code 'A'} through {@code 'Z'} and
     * its code is less than {@code radix + 'A' - 10}. In this case, {@code codePoint - 'A' + 10} is
     * returned.
     * <li>The character is one of the lowercase Latin letters {@code 'a'} through {@code 'z'} and
     * its code is less than {@code radix + 'a' - 10}. In this case, {@code codePoint - 'a' + 10} is
     * returned.
     * <li>The character is one of the fullwidth uppercase Latin letters A ({@code '\u005CuFF21'})
     * through Z ({@code '\u005CuFF3A'}) and its code is less than
     * {@code radix + '\u005CuFF21' - 10}. In this case, {@code codePoint - '\u005CuFF21' + 10} is
     * returned.
     * <li>The character is one of the fullwidth lowercase Latin letters a ({@code '\u005CuFF41'})
     * through z ({@code '\u005CuFF5A'}) and its code is less than {@code radix + '\u005CuFF41'- 10}
     * . In this case, {@code codePoint - '\u005CuFF41' + 10} is returned.
     * </ul>
     * 
     * @param codePoint the character (Unicode code point) to be converted.
     * @param radix the radix.
     * @return the numeric value represented by the character in the specified radix.
     * @see Character#forDigit(int, int)
     * @see Character#isDigit(int)
     * @since 1.5
     */
    public String digit(int codePoint, int radix) {
        return "parseInt(" + param(0) + "," + param(1) + ")";
    }
}
