/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Locale;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 9:58:40
 */
@JavaAPIProvider(java.util.Currency.class)
class Currency {

    /** The currency code. */
    private final String code;

    /**
     * 
     */
    private Currency(String code) {
        this.code = code;
    }

    /**
     * Returns the <code>Currency</code> instance for the given currency code.
     *
     * @param currencyCode the ISO 4217 code of the currency
     * @return the <code>Currency</code> instance for the given currency code
     * @exception NullPointerException if <code>currencyCode</code> is null
     * @exception IllegalArgumentException if <code>currencyCode</code> is not a supported ISO 4217
     *                code.
     */
    public static Currency getInstance(String currencyCode) {
        return new Currency(currencyCode);
    }

    /**
     * Gets the symbol of this currency for the default {@link Locale.Category#DISPLAY DISPLAY}
     * locale. For example, for the US Dollar, the symbol is "$" if the default locale is the US,
     * while for other locales it may be "US$". If no symbol can be determined, the ISO 4217
     * currency code is returned.
     * <p>
     * This is equivalent to calling {@link #getSymbol(Locale)
     * getSymbol(Locale.getDefault(Locale.Category.DISPLAY))}.
     *
     * @return the symbol of this currency for the default {@link Locale.Category#DISPLAY DISPLAY}
     *         locale
     */
    public String getSymbol() {
        return getSymbol(Locale.getDefault());
    }

    /**
     * Gets the symbol of this currency for the specified locale. For example, for the US Dollar,
     * the symbol is "$" if the specified locale is the US, while for other locales it may be "US$".
     * If no symbol can be determined, the ISO 4217 currency code is returned.
     *
     * @param locale the locale for which a display name for this currency is needed
     * @return the symbol of this currency for the specified locale
     * @exception NullPointerException if <code>locale</code> is null
     */
    public String getSymbol(Locale locale) {
        return code;
    }

    /**
     * Gets the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency.
     */
    public String getCurrencyCode() {
        return code;
    }
}
