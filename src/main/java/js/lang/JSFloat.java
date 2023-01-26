/*
 * Copyright (C) 2016 Nameless Production Committee
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
 * {@link Float} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/07/30 19:34:24
 */
@JavaAPIProvider(Float.class)
class JSFloat extends JSNumber {

    /** The primitive float class. */
    public static final Class TYPE = Primitive.class;

    /**
     * Constructs a newly allocated {@code Float} object that represents the primitive {@code float}
     * argument.
     * 
     * @param value the value to be represented by the {@code Float}.
     */
    public JSFloat(float value) {
        super(value);
    }

    /**
     * Constructs a newly allocated {@code Float} object that represents the argument converted to
     * type {@code float}.
     * 
     * @param value the value to be represented by the {@code Float}.
     */
    public JSFloat(double value) {
        super(value);
    }

    /**
     * Constructs a newly allocated {@code Float} object that represents the floating-point value of
     * type {@code float} represented by the string. The string is converted to a {@code float}
     * value as if by the {@code valueOf} method.
     * 
     * @param value a string to be converted to a {@code Float}.
     * @throws NumberFormatException if the string does not contain a parsable number.
     * @see java.lang.Float#valueOf(java.lang.String)
     */
    public JSFloat(String value) throws NumberFormatException {
        super(valueOf(value).floatValue());
    }

    /**
     * Returns {@code true} if the specified number is infinitely large in magnitude, {@code false}
     * otherwise.
     * 
     * @param value the value to be tested.
     * @return {@code true} if the argument is positive infinity or negative infinity; {@code false}
     *         otherwise.
     */
    public static boolean isInfinite(float value) {
        return !Global.isFinite(value);
    }

    /**
     * Returns {@code true} if the specified number is infinitely large in magnitude, {@code false}
     * otherwise.
     * 
     * @param value the value to be tested.
     * @return {@code true} if the argument is positive infinity or negative infinity; {@code false}
     *         otherwise.
     */
    public static boolean isFinite(float value) {
        return Global.isFinite(value);
    }

    /**
     * Returns {@code true} if the specified number is a Not-a-Number (NaN) value, {@code false}
     * otherwise.
     * 
     * @param value the value to be tested.
     * @return {@code true} if the argument is NaN; {@code false} otherwise.
     */
    public static boolean isNaN(float value) {
        return Global.isNaN(value);
    }

    /**
     * Returns a representation of the specified floating-point value according to the IEEE 754
     * floating-point "single format" bit layout.
     * <p>
     * Bit 31 (the bit that is selected by the mask {@code 0x80000000}) represents the sign of the
     * floating-point number. Bits 30-23 (the bits that are selected by the mask {@code 0x7f800000})
     * represent the exponent. Bits 22-0 (the bits that are selected by the mask {@code 0x007fffff})
     * represent the significand (sometimes called the mantissa) of the floating-point number.
     * <p>
     * If the argument is positive infinity, the result is {@code 0x7f800000}.
     * <p>
     * If the argument is negative infinity, the result is {@code 0xff800000}.
     * <p>
     * If the argument is NaN, the result is {@code 0x7fc00000}.
     * <p>
     * In all cases, the result is an integer that, when given to the {@link #intBitsToFloat(int)}
     * method, will produce a floating-point value the same as the argument to
     * {@code floatToIntBits} (except all NaN values are collapsed to a single "canonical" NaN
     * value).
     * 
     * @param value a floating-point number.
     * @return the bits that represent the floating-point number.
     */
    public static int floatToIntBits(float value) {
        int result = floatToRawIntBits(value);
        // Check for NaN based on values of bit fields, maximum
        // exponent and nonzero significand.
        if (((result & 0x7F800000) == 0x7F800000) && (result & 0x007FFFFF) != 0) {
            result = 0x7fc00000;
        }
        return result;
    }

    /**
     * Returns a representation of the specified floating-point value according to the IEEE 754
     * floating-point "single format" bit layout, preserving Not-a-Number (NaN) values.
     * <p>
     * Bit 31 (the bit that is selected by the mask {@code 0x80000000}) represents the sign of the
     * floating-point number. Bits 30-23 (the bits that are selected by the mask {@code 0x7f800000})
     * represent the exponent. Bits 22-0 (the bits that are selected by the mask {@code 0x007fffff})
     * represent the significand (sometimes called the mantissa) of the floating-point number.
     * <p>
     * If the argument is positive infinity, the result is {@code 0x7f800000}.
     * <p>
     * If the argument is negative infinity, the result is {@code 0xff800000}.
     * <p>
     * If the argument is NaN, the result is the integer representing the actual NaN value. Unlike
     * the {@code floatToIntBits} method, {@code floatToRawIntBits} does not collapse all the bit
     * patterns encoding a NaN to a single "canonical" NaN value.
     * <p>
     * In all cases, the result is an integer that, when given to the {@link #intBitsToFloat(int)}
     * method, will produce a floating-point value the same as the argument to
     * {@code floatToRawIntBits}.
     * 
     * @param value a floating-point number.
     * @return the bits that represent the floating-point number.
     * @since 1.3
     */
    public static native int floatToRawIntBits(float value);

    /**
     * Returns the {@code float} value corresponding to a given bit representation. The argument is
     * considered to be a representation of a floating-point value according to the IEEE 754
     * floating-point "single format" bit layout.
     * <p>
     * If the argument is {@code 0x7f800000}, the result is positive infinity.
     * <p>
     * If the argument is {@code 0xff800000}, the result is negative infinity.
     * <p>
     * If the argument is any value in the range {@code 0x7f800001} through {@code 0x7fffffff} or in
     * the range {@code 0xff800001} through {@code 0xffffffff}, the result is a NaN. No IEEE 754
     * floating-point operation provided by Java can distinguish between two NaN values of the same
     * type with different bit patterns. Distinct values of NaN are only distinguishable by use of
     * the {@code Float.floatToRawIntBits} method.
     * <p>
     * In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three values that can be computed
     * from the argument: <blockquote> <pre>{@code
     * int s = ((bits >> 31) == 0) ? 1 : -1;
     * int e = ((bits >> 23) & 0xff);
     * int m = (e == 0) ?
     *                 (bits & 0x7fffff) << 1 :
     *                 (bits & 0x7fffff) | 0x800000;
     * }</pre> </blockquote> Then the floating-point result equals the value of the mathematical
     * expression <i>s</i>&middot;<i>m</i>&middot;2<sup><i>e</i>-150</sup>.
     * <p>
     * Note that this method may not be able to return a {@code float} NaN with exactly same bit
     * pattern as the {@code int} argument. IEEE 754 distinguishes between two kinds of NaNs, quiet
     * NaNs and <i>signaling NaNs</i>. The differences between the two kinds of NaN are generally
     * not visible in Java. Arithmetic operations on signaling NaNs turn them into quiet NaNs with a
     * different, but often similar, bit pattern. However, on some processors merely copying a
     * signaling NaN also performs that conversion. In particular, copying a signaling NaN to return
     * it to the calling method may perform this conversion. So {@code intBitsToFloat} may not be
     * able to return a {@code float} with a signaling NaN bit pattern. Consequently, for some
     * {@code int} values, {@code floatToRawIntBits(intBitsToFloat(start))} may <i>not</i> equal
     * {@code start}. Moreover, which particular bit patterns represent signaling NaNs is platform
     * dependent; although all NaN bit patterns, quiet or signaling, must be in the NaN range
     * identified above.
     * 
     * @param bits an integer.
     * @return the {@code float} floating-point value with the same bit pattern.
     */
    public static native float intBitsToFloat(int bits);

    /**
     * Returns a new {@code float} initialized to the value represented by the specified
     * {@code String}, as performed by the {@code valueOf} method of class {@code Float}.
     * 
     * @param value the string to be parsed.
     * @return the {@code float} value represented by the string argument.
     * @throws NullPointerException if the string is null
     * @throws NumberFormatException if the string does not contain a parsable {@code float}.
     * @see java.lang.Float#valueOf(String)
     * @since 1.2
     */
    public static float parseFloat(String value) throws NumberFormatException {
        if (value == null) {
            throw new NullPointerException();
        }

        float parsed = Global.parseFloat(value);

        if (Global.isNaN(parsed)) {
            throw new NumberFormatException(value + " is not a number.");
        }
        return parsed;
    }

    /**
     * Returns a string representation of the {@code float} argument. All characters mentioned below
     * are ASCII characters.
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
     * integer such that 10<sup><i>n</i> </sup>&le; <i>m</i> {@literal <} 10<sup><i>n</i>+1</sup>;
     * then let <i>a</i> be the mathematically exact quotient of <i>m</i> and 10<sup><i>n</i></sup>
     * so that 1 &le; <i>a</i> {@literal <} 10. The magnitude is then represented as the integer
     * part of <i>a</i>, as a single decimal digit, followed by '{@code .}' (
     * <code>'&#92;u002E'</code>), followed by decimal digits representing the fractional part of
     * <i>a</i>, followed by the letter '{@code E}' (<code>'&#92;u0045'</code>), followed by a
     * representation of <i>n</i> as a decimal integer, as produced by the method
     * {@link java.lang.Integer#toString(int)}.
     * </ul>
     * </ul>
     * How many digits must be printed for the fractional part of <i>m</i> or <i>a</i>? There must
     * be at least one digit to represent the fractional part, and beyond that as many, but only as
     * many, more digits as are needed to uniquely distinguish the argument value from adjacent
     * values of type {@code float}. That is, suppose that <i>x</i> is the exact mathematical value
     * represented by the decimal representation produced by this method for a finite nonzero
     * argument <i>f</i>. Then <i>f</i> must be the {@code float} value nearest to <i>x</i>; or, if
     * two {@code float} values are equally close to <i>x</i>, then <i>f</i> must be one of them and
     * the least significant bit of the significand of <i>f</i> must be {@code 0}.
     * <p>
     * To create localized string representations of a floating-point value, use subclasses of
     * {@link java.text.NumberFormat}.
     * 
     * @param f the float to be converted.
     * @return a string representation of the argument.
     */
    public static String toString(float f) {
        return valueOf(f).toString();
    }

    /**
     * Returns a {@code Float} object holding the {@code float} value represented by the argument
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
     * regarded as representing an exact decimal value in the usual "computerized scientific
     * notation" or as an exact hexadecimal value; this exact numerical value is then conceptually
     * converted to an "infinitely precise" binary value that is then rounded to type {@code float}
     * by the usual round-to-nearest rule of IEEE 754 floating-point arithmetic, which includes
     * preserving the sign of a zero value. Note that the round-to-nearest rule also implies
     * overflow and underflow behaviour; if the exact value of {@code s} is large enough in
     * magnitude (greater than or equal to ({@link #MAX_VALUE} + {@link Math#ulp(float)
     * ulp(MAX_VALUE)}/2), rounding to {@code float} will result in an infinity and if the exact
     * value of {@code s} is small enough in magnitude (less than or equal to {@link #MIN_VALUE}/2),
     * rounding to float will result in a zero. Finally, after rounding a {@code Float} object
     * representing this {@code float} value is returned.
     * <p>
     * To interpret localized string representations of a floating-point value, use subclasses of
     * {@link java.text.NumberFormat}.
     * <p>
     * Note that trailing format specifiers, specifiers that determine the type of a floating-point
     * literal ({@code 1.0f} is a {@code float} value; {@code 1.0d} is a {@code double} value), do
     * <em>not</em> influence the results of this method. In other words, the numerical value of the
     * input string is converted directly to the target floating-point type. In general, the
     * two-step sequence of conversions, string to {@code double} followed by {@code double} to
     * {@code float}, is <em>not</em> equivalent to converting a string directly to {@code float}.
     * For example, if first converted to an intermediate {@code double} and then to {@code float},
     * the string<br>
     * {@code "1.00000017881393421514957253748434595763683319091796875001d"}<br>
     * results in the {@code float} value {@code 1.0000002f}; if the string is converted directly to
     * {@code float}, <code>1.000000<b>1</b>f</code> results.
     * <p>
     * To avoid calling this method on an invalid string and having a {@code NumberFormatException}
     * be thrown, the documentation for {@link Double#valueOf Double.valueOf} lists a regular
     * expression which can be used to screen the input.
     * 
     * @param value the string to be parsed.
     * @return a {@code Float} object holding the value represented by the {@code String} argument.
     * @throws NumberFormatException if the string does not contain a parsable number.
     */
    public static Float valueOf(String value) throws NumberFormatException {
        return valueOf(parseFloat(value));
    }

    /**
     * Returns a {@code Float} instance representing the specified {@code float} value. If a new
     * {@code Float} instance is not required, this method should generally be used in preference to
     * the constructor {@link #Float(float)}, as this method is likely to yield significantly better
     * space and time performance by caching frequently requested values.
     * 
     * @param value a float value.
     * @return a {@code Float} instance representing {@code f}.
     * @since 1.5
     */
    public static Float valueOf(float value) {
        return (Float) (Object) new JSFloat(value);
    }

    /**
     * @version 2013/04/16 23:01:24
     */
    @JavaAPIProvider(float.class)
    private static class Primitive {
    }
}
