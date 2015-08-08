/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.text;

import java.util.Currency;
import java.util.Locale;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/07 0:33:08
 */
@JavaAPIProvider(java.text.DecimalFormatSymbols.class)
class DecimalFormatSymbols {

    /**
     * Character used for zero.
     *
     * @serial
     * @see #getZeroDigit
     */
    private char zeroDigit = '0';

    /**
     * Character used for thousands separator.
     *
     * @serial
     * @see #getGroupingSeparator
     */
    private char groupingSeparator = ',';

    /**
     * Character used for decimal sign.
     *
     * @serial
     * @see #getDecimalSeparator
     */
    private char decimalSeparator = '.';

    /**
     * Character used for per mille sign.
     *
     * @serial
     * @see #getPerMill
     */
    private char perMill = '‰';

    /**
     * Character used for percent sign.
     * 
     * @serial
     * @see #getPercent
     */
    private char percent = '%';

    /**
     * Character used for a digit in a pattern.
     *
     * @serial
     * @see #getDigit
     */
    private char digit = '#';

    /**
     * Character used to separate positive and negative subpatterns in a pattern.
     *
     * @serial
     * @see #getPatternSeparator
     */
    private char patternSeparator = ';';

    /**
     * String used to represent infinity.
     * 
     * @serial
     * @see #getInfinity
     */
    private String infinity = "∞";

    /**
     * String used to represent "not a number".
     * 
     * @serial
     * @see #getNaN
     */
    private String NaN = "�";

    /**
     * Character used to represent minus sign.
     * 
     * @serial
     * @see #getMinusSign
     */
    private char minusSign = '-';

    /**
     * String denoting the local currency, e.g. "$".
     * 
     * @serial
     * @see #getCurrencySymbol
     */
    private String currencySymbol = "$";

    /**
     * ISO 4217 currency code denoting the local currency, e.g. "USD".
     * 
     * @serial
     * @see #getInternationalCurrencySymbol
     */
    private String intlCurrencySymbol = "USD";

    /**
     * The decimal separator used when formatting currency values.
     * 
     * @serial
     * @since JDK 1.1.6
     * @see #getMonetaryDecimalSeparator
     */
    private char monetarySeparator = '.'; // Field new in JDK 1.1.6

    /**
     * The character used to distinguish the exponent in a number formatted in exponential notation,
     * e.g. 'E' for a number such as "1.23E45".
     * <p>
     * Note that the public API provides no way to set this field, even though it is supported by
     * the implementation and the stream format. The intent is that this will be added to the API in
     * the future.
     *
     * @serial
     * @since JDK 1.1.6
     */
    private char exponential; // Field new in JDK 1.1.6

    /**
     * The string used to separate the mantissa from the exponent. Examples: "x10^" for 1.23x10^4,
     * "E" for 1.23E4.
     * <p>
     * If both <code>exponential</code> and <code>exponentialSeparator</code> exist, this
     * <code>exponentialSeparator</code> has the precedence.
     *
     * @serial
     * @since 1.6
     */
    private String exponentialSeparator = "E"; // Field new in JDK 1.6

    /**
     * The locale of these currency format symbols.
     *
     * @serial
     * @since 1.4
     */
    private Locale locale;

    // currency; only the ISO code is serialized.
    private transient Currency currency;

    /**
     * Gets the character used for zero. Different for Arabic, etc.
     *
     * @return the character used for zero
     */
    public char getZeroDigit() {
        return zeroDigit;
    }

    /**
     * Sets the character used for zero. Different for Arabic, etc.
     *
     * @param zeroDigit the character used for zero
     */
    public void setZeroDigit(char zeroDigit) {
        this.zeroDigit = zeroDigit;
    }

    /**
     * Gets the character used for thousands separator. Different for French, etc.
     *
     * @return the grouping separator
     */
    public char getGroupingSeparator() {
        return groupingSeparator;
    }

    /**
     * Sets the character used for thousands separator. Different for French, etc.
     *
     * @param groupingSeparator the grouping separator
     */
    public void setGroupingSeparator(char groupingSeparator) {
        this.groupingSeparator = groupingSeparator;
    }

    /**
     * Gets the character used for decimal sign. Different for French, etc.
     *
     * @return the character used for decimal sign
     */
    public char getDecimalSeparator() {
        return decimalSeparator;
    }

    /**
     * Sets the character used for decimal sign. Different for French, etc.
     *
     * @param decimalSeparator the character used for decimal sign
     */
    public void setDecimalSeparator(char decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    /**
     * Gets the character used for per mille sign. Different for Arabic, etc.
     *
     * @return the character used for per mille sign
     */
    public char getPerMill() {
        return perMill;
    }

    /**
     * Sets the character used for per mille sign. Different for Arabic, etc.
     *
     * @param perMill the character used for per mille sign
     */
    public void setPerMill(char perMill) {
        this.perMill = perMill;
    }

    /**
     * Gets the character used for percent sign. Different for Arabic, etc.
     *
     * @return the character used for percent sign
     */
    public char getPercent() {
        return percent;
    }

    /**
     * Sets the character used for percent sign. Different for Arabic, etc.
     *
     * @param percent the character used for percent sign
     */
    public void setPercent(char percent) {
        this.percent = percent;
    }

    /**
     * Gets the character used for a digit in a pattern.
     *
     * @return the character used for a digit in a pattern
     */
    public char getDigit() {
        return digit;
    }

    /**
     * Sets the character used for a digit in a pattern.
     *
     * @param digit the character used for a digit in a pattern
     */
    public void setDigit(char digit) {
        this.digit = digit;
    }

    /**
     * Gets the character used to separate positive and negative subpatterns in a pattern.
     *
     * @return the pattern separator
     */
    public char getPatternSeparator() {
        return patternSeparator;
    }

    /**
     * Sets the character used to separate positive and negative subpatterns in a pattern.
     *
     * @param patternSeparator the pattern separator
     */
    public void setPatternSeparator(char patternSeparator) {
        this.patternSeparator = patternSeparator;
    }

    /**
     * Gets the string used to represent infinity. Almost always left unchanged.
     *
     * @return the string representing infinity
     */
    public String getInfinity() {
        return infinity;
    }

    /**
     * Sets the string used to represent infinity. Almost always left unchanged.
     *
     * @param infinity the string representing infinity
     */
    public void setInfinity(String infinity) {
        this.infinity = infinity;
    }

    /**
     * Gets the string used to represent "not a number". Almost always left unchanged.
     *
     * @return the string representing "not a number"
     */
    public String getNaN() {
        return NaN;
    }

    /**
     * Sets the string used to represent "not a number". Almost always left unchanged.
     *
     * @param NaN the string representing "not a number"
     */
    public void setNaN(String NaN) {
        this.NaN = NaN;
    }

    /**
     * Gets the character used to represent minus sign. If no explicit negative format is specified,
     * one is formed by prefixing minusSign to the positive format.
     *
     * @return the character representing minus sign
     */
    public char getMinusSign() {
        return minusSign;
    }

    /**
     * Sets the character used to represent minus sign. If no explicit negative format is specified,
     * one is formed by prefixing minusSign to the positive format.
     *
     * @param minusSign the character representing minus sign
     */
    public void setMinusSign(char minusSign) {
        this.minusSign = minusSign;
    }

    /**
     * Returns the currency symbol for the currency of these DecimalFormatSymbols in their locale.
     *
     * @return the currency symbol
     * @since 1.2
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * Sets the currency symbol for the currency of these DecimalFormatSymbols in their locale.
     *
     * @param currency the currency symbol
     * @since 1.2
     */
    public void setCurrencySymbol(String currency) {
        currencySymbol = currency;
    }

    /**
     * Returns the ISO 4217 currency code of the currency of these DecimalFormatSymbols.
     *
     * @return the currency code
     * @since 1.2
     */
    public String getInternationalCurrencySymbol() {
        return intlCurrencySymbol;
    }

    /**
     * Sets the ISO 4217 currency code of the currency of these DecimalFormatSymbols. If the
     * currency code is valid (as defined by {@link java.util.Currency#getInstance(java.lang.String)
     * Currency.getInstance}), this also sets the currency attribute to the corresponding Currency
     * instance and the currency symbol attribute to the currency's symbol in the
     * DecimalFormatSymbols' locale. If the currency code is not valid, then the currency attribute
     * is set to null and the currency symbol attribute is not modified.
     *
     * @param currencyCode the currency code
     * @see #setCurrency
     * @see #setCurrencySymbol
     * @since 1.2
     */
    public void setInternationalCurrencySymbol(String currencyCode) {
        intlCurrencySymbol = currencyCode;
        currency = null;
        if (currencyCode != null) {
            try {
                currency = Currency.getInstance(currencyCode);
                currencySymbol = currency.getSymbol();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /**
     * Gets the currency of these DecimalFormatSymbols. May be null if the currency symbol attribute
     * was previously set to a value that's not a valid ISO 4217 currency code.
     *
     * @return the currency used, or null
     * @since 1.4
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets the currency of these DecimalFormatSymbols. This also sets the currency symbol attribute
     * to the currency's symbol in the DecimalFormatSymbols' locale, and the international currency
     * symbol attribute to the currency's ISO 4217 currency code.
     *
     * @param currency the new currency to be used
     * @exception NullPointerException if <code>currency</code> is null
     * @since 1.4
     * @see #setCurrencySymbol
     * @see #setInternationalCurrencySymbol
     */
    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException();
        }
        this.currency = currency;
        intlCurrencySymbol = currency.getCurrencyCode();
        currencySymbol = currency.getSymbol(locale);
    }

    /**
     * Returns the monetary decimal separator.
     *
     * @return the monetary decimal separator
     * @since 1.2
     */
    public char getMonetaryDecimalSeparator() {
        return monetarySeparator;
    }

    /**
     * Sets the monetary decimal separator.
     *
     * @param sep the monetary decimal separator
     * @since 1.2
     */
    public void setMonetaryDecimalSeparator(char sep) {
        monetarySeparator = sep;
    }

    // ------------------------------------------------------------
    // BEGIN Package Private methods ... to be made public later
    // ------------------------------------------------------------

    /**
     * Returns the character used to separate the mantissa from the exponent.
     */
    char getExponentialSymbol() {
        return exponential;
    }

    /**
     * Returns the string used to separate the mantissa from the exponent. Examples: "x10^" for
     * 1.23x10^4, "E" for 1.23E4.
     *
     * @return the exponent separator string
     * @see #setExponentSeparator(java.lang.String)
     * @since 1.6
     */
    public String getExponentSeparator() {
        return exponentialSeparator;
    }

    /**
     * Sets the character used to separate the mantissa from the exponent.
     */
    void setExponentialSymbol(char exp) {
        exponential = exp;
    }

    /**
     * Sets the string used to separate the mantissa from the exponent. Examples: "x10^" for
     * 1.23x10^4, "E" for 1.23E4.
     *
     * @param exp the exponent separator string
     * @exception NullPointerException if <code>exp</code> is null
     * @see #getExponentSeparator()
     * @since 1.6
     */
    public void setExponentSeparator(String exp) {
        if (exp == null) {
            throw new NullPointerException();
        }
        exponentialSeparator = exp;
    }

    /**
     * Gets the <code>DecimalFormatSymbols</code> instance for the default locale. This method
     * provides access to <code>DecimalFormatSymbols</code> instances for locales supported by the
     * Java runtime itself as well as for those supported by installed
     * {@link java.text.spi.DecimalFormatSymbolsProvider DecimalFormatSymbolsProvider}
     * implementations.
     * <p>
     * This is equivalent to calling {@link #getInstance(Locale)
     * getInstance(Locale.getDefault(Locale.Category.FORMAT))}.
     * 
     * @see java.util.Locale#getDefault(java.util.Locale.Category)
     * @see java.util.Locale.Category#FORMAT
     * @return a <code>DecimalFormatSymbols</code> instance.
     * @since 1.6
     */
    public static final DecimalFormatSymbols getInstance() {
        return new DecimalFormatSymbols();
    }

    /**
     * Gets the <code>DecimalFormatSymbols</code> instance for the specified locale. This method
     * provides access to <code>DecimalFormatSymbols</code> instances for locales supported by the
     * Java runtime itself as well as for those supported by installed
     * {@link java.text.spi.DecimalFormatSymbolsProvider DecimalFormatSymbolsProvider}
     * implementations. If the specified locale contains the
     * {@link java.util.Locale#UNICODE_LOCALE_EXTENSION} for the numbering system, the instance is
     * initialized with the specified numbering system if the JRE implementation supports it. For
     * example, <pre>
     * NumberFormat.getNumberInstance(Locale.forLanguageTag("th-TH-u-nu-thai"))
     * </pre> This may return a {@code NumberFormat} instance with the Thai numbering system,
     * instead of the Latin numbering system.
     *
     * @param locale the desired locale.
     * @return a <code>DecimalFormatSymbols</code> instance.
     * @exception NullPointerException if <code>locale</code> is null
     * @since 1.6
     */
    public static final DecimalFormatSymbols getInstance(Locale locale) {
        return getInstance();
    }

    /**
     * Returns an array of all locales for which the <code>getInstance</code> methods of this class
     * can return localized instances. The returned array represents the union of locales supported
     * by the Java runtime and by installed {@link java.text.spi.DecimalFormatSymbolsProvider
     * DecimalFormatSymbolsProvider} implementations. It must contain at least a <code>Locale</code>
     * instance equal to {@link java.util.Locale#US Locale.US}.
     *
     * @return an array of locales for which localized <code>DecimalFormatSymbols</code> instances
     *         are available.
     * @since 1.6
     */
    public static Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }
}
