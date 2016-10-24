/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.emulate.sun.util.locale.provider;

import java.text.spi.BreakIteratorProvider;
import java.text.spi.CollatorProvider;
import java.text.spi.DateFormatProvider;
import java.text.spi.DateFormatSymbolsProvider;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.text.spi.NumberFormatProvider;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.spi.CalendarDataProvider;
import java.util.spi.CalendarNameProvider;
import java.util.spi.CurrencyNameProvider;
import java.util.spi.LocaleNameProvider;
import java.util.spi.LocaleServiceProvider;
import java.util.spi.TimeZoneNameProvider;

import sun.util.locale.provider.LocaleProviderAdapter.Type;
import sun.util.locale.provider.LocaleResources;
import sun.util.spi.CalendarProvider;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2014/03/12 2:53:27
 */
@JavaAPIProvider(JDKEmulator.class)
@Manageable(lifestyle = Singleton.class)
class LocaleProviderAdapter {

    static Type defaultLocaleProviderAdapter;

    /**
     * Returns the singleton instance for each adapter type
     */
    public static LocaleProviderAdapter forType(Type type) {
        throw new UnsupportedOperationException();
    }

    public static LocaleProviderAdapter forJRE() {
        throw new UnsupportedOperationException();
    }

    public static LocaleProviderAdapter getResourceBundleBased() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the preference order of LocaleProviderAdapter.Type
     */
    public static List<Type> getAdapterPreference() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a LocaleProviderAdapter for the given locale service provider that best matches the
     * given locale. This method returns the LocaleProviderAdapter for JRE if none is found for the
     * given locale.
     *
     * @param providerClass the class for the locale service provider
     * @param locale the desired locale.
     * @return a LocaleProviderAdapter
     */
    public static LocaleProviderAdapter getAdapter(Class<? extends LocaleServiceProvider> providerClass, Locale locale) {
        throw new UnsupportedOperationException();
    }

    /**
     * A utility method for implementing the default LocaleServiceProvider.isSupportedLocale for the
     * JRE, CLDR, and FALLBACK adapters.
     */
    static boolean isSupportedLocale(Locale locale, Type type, Set<String> langtags) {
        throw new UnsupportedOperationException();
    }

    public static Locale[] toLocaleArray(Set<String> tags) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the type of this LocaleProviderAdapter
     */
    public Type getAdapterType() {
        throw new UnsupportedOperationException();
    }

    /**
     * Getter method for Locale Service Providers.
     */
    public <P extends LocaleServiceProvider> P getLocaleServiceProvider(Class<P> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a BreakIteratorProvider for this LocaleProviderAdapter, or null if no
     * BreakIteratorProvider is available.
     *
     * @return a BreakIteratorProvider
     */
    public BreakIteratorProvider getBreakIteratorProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a ollatorProvider for this LocaleProviderAdapter, or null if no ollatorProvider is
     * available.
     *
     * @return a ollatorProvider
     */
    public CollatorProvider getCollatorProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a DateFormatProvider for this LocaleProviderAdapter, or null if no DateFormatProvider
     * is available.
     *
     * @return a DateFormatProvider
     */
    public DateFormatProvider getDateFormatProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a DateFormatSymbolsProvider for this LocaleProviderAdapter, or null if no
     * DateFormatSymbolsProvider is available.
     *
     * @return a DateFormatSymbolsProvider
     */
    public DateFormatSymbolsProvider getDateFormatSymbolsProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a DecimalFormatSymbolsProvider for this LocaleProviderAdapter, or null if no
     * DecimalFormatSymbolsProvider is available.
     *
     * @return a DecimalFormatSymbolsProvider
     */
    public DecimalFormatSymbolsProvider getDecimalFormatSymbolsProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a NumberFormatProvider for this LocaleProviderAdapter, or null if no
     * NumberFormatProvider is available.
     *
     * @return a NumberFormatProvider
     */
    public NumberFormatProvider getNumberFormatProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a CurrencyNameProvider for this LocaleProviderAdapter, or null if no
     * CurrencyNameProvider is available.
     *
     * @return a CurrencyNameProvider
     */
    public CurrencyNameProvider getCurrencyNameProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a LocaleNameProvider for this LocaleProviderAdapter, or null if no LocaleNameProvider
     * is available.
     *
     * @return a LocaleNameProvider
     */
    public LocaleNameProvider getLocaleNameProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a TimeZoneNameProvider for this LocaleProviderAdapter, or null if no
     * TimeZoneNameProvider is available.
     *
     * @return a TimeZoneNameProvider
     */
    public TimeZoneNameProvider getTimeZoneNameProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a CalendarDataProvider for this LocaleProviderAdapter, or null if no
     * CalendarDataProvider is available.
     *
     * @return a CalendarDataProvider
     */
    public CalendarDataProvider getCalendarDataProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a CalendarNameProvider for this LocaleProviderAdapter, or null if no
     * CalendarNameProvider is available.
     *
     * @return a CalendarNameProvider
     */
    public CalendarNameProvider getCalendarNameProvider() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a CalendarProvider for this LocaleProviderAdapter, or null if no CalendarProvider is
     * available.
     *
     * @return a CalendarNameProvider
     */
    public CalendarProvider getCalendarProvider() {
        throw new UnsupportedOperationException();
    }

    public LocaleResources getLocaleResources(Locale locale) {
        throw new UnsupportedOperationException();
    }

    public Locale[] getAvailableLocales() {
        throw new UnsupportedOperationException();
    }
}
