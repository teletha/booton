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
 * <p>
 * {@link Double} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Double.class)
class JSDouble extends JSNumber {

    /** The primitive double class. */
    public static final Class TYPE = Primitive.class;

    /**
     * @param value
     */
    private JSDouble(double value) {
        super(value);
    }

    /**
     * Returns a string representation of the {@code double} argument. All characters mentioned
     * below are ASCII characters.
     * <ul>
     * <li>If the argument is NaN, the result is the string "{@code NaN}".
     * <li>Otherwise, the result is a string that represents the sign and magnitude (absolute value)
     * of the argument. If the sign is negative, the first character of the result is '{@code -}' (
     * <code>'&#92;u002D'</code>); if the sign is positive, no sign character appears in the result.
     * As for the magnitude <i>m</i>:
     * <ul>
     * <li>If <i>m</i> is infinity, it is represented by the characters {@code "Infinity"}; thus,
     * positive infinity produces the result {@code "Infinity"} and negative infinity produces the
     * result {@code "-Infinity"}.
     * <li>If <i>m</i> is zero, it is represented by the characters {@code "0.0"}; thus, negative
     * zero produces the result {@code "-0.0"} and positive zero produces the result {@code "0.0"}.
     * <li>If <i>m</i> is greater than or equal to 10<sup>-3</sup> but less than 10<sup>7</sup>,
     * then it is represented as the integer part of <i>m</i>, in decimal form with no leading
     * zeroes, followed by '{@code .}' (<code>'&#92;u002E'</code>), followed by one or more decimal
     * digits representing the fractional part of <i>m</i>.
     * <li>If <i>m</i> is less than 10<sup>-3</sup> or greater than or equal to 10<sup>7</sup>, then
     * it is represented in so-called "computerized scientific notation." Let <i>n</i> be the unique
     * integer such that 10<sup><i>n</i></sup> &le; <i>m</i> {@literal <} 10<sup><i>n</i>+1</sup>;
     * then let <i>a</i> be the mathematically exact quotient of <i>m</i> and 10<sup><i>n</i></sup>
     * so that 1 &le; <i>a</i> {@literal <} 10. The magnitude is then represented as the integer
     * part of <i>a</i>, as a single decimal digit, followed by '{@code .}' (
     * <code>'&#92;u002E'</code>), followed by decimal digits representing the fractional part of
     * <i>a</i>, followed by the letter '{@code E}' (<code>'&#92;u0045'</code>), followed by a
     * representation of <i>n</i> as a decimal integer, as produced by the method
     * {@link Integer#toString(int)}.
     * </ul>
     * </ul>
     * How many digits must be printed for the fractional part of <i>m</i> or <i>a</i>? There must
     * be at least one digit to represent the fractional part, and beyond that as many, but only as
     * many, more digits as are needed to uniquely distinguish the argument value from adjacent
     * values of type {@code double}. That is, suppose that <i>x</i> is the exact mathematical value
     * represented by the decimal representation produced by this method for a finite nonzero
     * argument <i>d</i>. Then <i>d</i> must be the {@code double} value nearest to <i>x</i>; or if
     * two {@code double} values are equally close to <i>x</i>, then <i>d</i> must be one of them
     * and the least significant bit of the significand of <i>d</i> must be {@code 0}.
     * <p>
     * To create localized string representations of a floating-point value, use subclasses of
     * {@link java.text.NumberFormat}.
     * 
     * @param d the {@code double} to be converted.
     * @return a string representation of the argument.
     */
    public static String toString(double d) {
        return valueOf(d).toString();
    }

    /**
     * Returns a {@code Double} object holding the {@code double} value represented by the argument
     * string {@code s}.
     * <p>
     * If {@code s} is {@code null}, then a {@code NullPointerException} is thrown.
     * <p>
     * Leading and trailing whitespace characters in {@code s} are ignored. Whitespace is removed as
     * if by the {@link String#trim} method; that is, both ASCII space and control characters are
     * removed. The rest of {@code s} should constitute a <i>FloatValue</i> as described by the
     * lexical syntax rules: <blockquote>
     * <dl>
     * <dt><i>FloatValue:</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code NaN}
     * <dd><i>Sign<sub>opt</sub></i> {@code Infinity}
     * <dd><i>Sign<sub>opt</sub> FloatingPointLiteral</i>
     * <dd><i>Sign<sub>opt</sub> HexFloatingPointLiteral</i>
     * <dd><i>SignedInteger</i>
     * </dl>
     * <p>
     * <dl>
     * <dt><i>HexFloatingPointLiteral</i>:
     * <dd><i>HexSignificand BinaryExponent FloatTypeSuffix<sub>opt</sub></i>
     * </dl>
     * <p>
     * <dl>
     * <dt><i>HexSignificand:</i>
     * <dd><i>HexNumeral</i>
     * <dd><i>HexNumeral</i> {@code .}
     * <dd>{@code 0x} <i>HexDigits<sub>opt</sub> </i>{@code .}<i> HexDigits</i>
     * <dd>{@code 0X}<i> HexDigits<sub>opt</sub> </i>{@code .} <i>HexDigits</i>
     * </dl>
     * <p>
     * <dl>
     * <dt><i>BinaryExponent:</i>
     * <dd><i>BinaryExponentIndicator SignedInteger</i>
     * </dl>
     * <p>
     * <dl>
     * <dt><i>BinaryExponentIndicator:</i>
     * <dd>{@code p}
     * <dd>{@code P}
     * </dl>
     * </blockquote> where <i>Sign</i>, <i>FloatingPointLiteral</i>, <i>HexNumeral</i>,
     * <i>HexDigits</i>, <i>SignedInteger</i> and <i>FloatTypeSuffix</i> are as defined in the
     * lexical structure sections of <cite>The Java&trade; Language Specification</cite>, except
     * that underscores are not accepted between digits. If {@code s} does not have the form of a
     * <i>FloatValue</i>, then a {@code NumberFormatException} is thrown. Otherwise, {@code s} is
     * regarded as representing an exact decimal value in the usual
     * "computerized scientific notation" or as an exact hexadecimal value; this exact numerical
     * value is then conceptually converted to an "infinitely precise" binary value that is then
     * rounded to type {@code double} by the usual round-to-nearest rule of IEEE 754 floating-point
     * arithmetic, which includes preserving the sign of a zero value. Note that the
     * round-to-nearest rule also implies overflow and underflow behaviour; if the exact value of
     * {@code s} is large enough in magnitude (greater than or equal to ({@link #MAX_VALUE} +
     * {@link Math#ulp(double) ulp(MAX_VALUE)}/2), rounding to {@code double} will result in an
     * infinity and if the exact value of {@code s} is small enough in magnitude (less than or equal
     * to {@link #MIN_VALUE}/2), rounding to float will result in a zero. Finally, after rounding a
     * {@code Double} object representing this {@code double} value is returned.
     * <p>
     * To interpret localized string representations of a floating-point value, use subclasses of
     * {@link java.text.NumberFormat}.
     * <p>
     * Note that trailing format specifiers, specifiers that determine the type of a floating-point
     * literal ({@code 1.0f} is a {@code float} value; {@code 1.0d} is a {@code double} value), do
     * <em>not</em> influence the results of this method. In other words, the numerical value of the
     * input string is converted directly to the target floating-point type. The two-step sequence
     * of conversions, string to {@code float} followed by {@code float} to {@code double}, is
     * <em>not</em> equivalent to converting a string directly to {@code double}. For example, the
     * {@code float} literal {@code 0.1f} is equal to the {@code double} value
     * {@code 0.10000000149011612}; the {@code float} literal {@code 0.1f} represents a different
     * numerical value than the {@code double} literal {@code 0.1}. (The numerical value 0.1 cannot
     * be exactly represented in a binary floating-point number.)
     * <p>
     * To avoid calling this method on an invalid string and having a {@code NumberFormatException}
     * be thrown, the regular expression below can be used to screen the input string: <code>
     * <pre>
     *  final String Digits     = "(\\p{Digit}+)";
     *  final String HexDigits  = "(\\p{XDigit}+)";
     *  // an exponent is 'e' or 'E' followed by an optionally
     *  // signed decimal integer.
     *  final String Exp        = "[eE][+-]?"+Digits;
     *  final String fpRegex    =
     *      ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
     *       "[+-]?(" + // Optional sign character
     *       "NaN|" +           // "NaN" string
     *       "Infinity|" +      // "Infinity" string
     * 
     *       // A decimal floating-point string representing a finite positive
     *       // number without a leading sign has at most five basic pieces:
     *       // Digits . Digits ExponentPart FloatTypeSuffix
     *       //
     *       // Since this method allows integer-only strings as input
     *       // in addition to strings of floating-point literals, the
     *       // two sub-patterns below are simplifications of the grammar
     *       // productions from section 3.10.2 of
     *       // <cite>The Java&trade; Language Specification</cite>.
     * 
     *       // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
     *       "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+
     * 
     *       // . Digits ExponentPart_opt FloatTypeSuffix_opt
     *       "(\\.("+Digits+")("+Exp+")?)|"+
     * 
     *       // Hexadecimal strings
     *       "((" +
     *        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
     *        "(0[xX]" + HexDigits + "(\\.)?)|" +
     * 
     *        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
     *        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
     * 
     *        ")[pP][+-]?" + Digits + "))" +
     *       "[fFdD]?))" +
     *       "[\\x00-\\x20]*");// Optional trailing "whitespace"
     * 
     *  if (Pattern.matches(fpRegex, myString))
     *      Double.valueOf(myString); // Will not throw NumberFormatException
     *  else {
     *      // Perform suitable alternative action
     *  }
     * </pre>
     * </code>
     * 
     * @param value the string to be parsed.
     * @return a {@code Double} object holding the value represented by the {@code String} argument.
     * @throws NumberFormatException if the string does not contain a parsable number.
     */
    public static Double valueOf(String value) throws NumberFormatException {
        return valueOf(NativeGlobal.parseFloat(value));
    }

    /**
     * Returns a {@code Double} instance representing the specified {@code double} value. If a new
     * {@code Double} instance is not required, this method should generally be used in preference
     * to the constructor {@link #Double(double)}, as this method is likely to yield significantly
     * better space and time performance by caching frequently requested values.
     * 
     * @param value a double value.
     * @return a {@code Double} instance representing {@code d}.
     * @since 1.5
     */
    public static Double valueOf(double value) {
        return (Double) (Object) new JSDouble(value);
    }

    /**
     * @version 2013/04/16 23:01:24
     */
    @JavaAPIProvider(double.class)
    private static class Primitive {
    }
}
