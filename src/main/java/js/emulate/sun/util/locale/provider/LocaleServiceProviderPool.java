/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.emulate.sun.util.locale.provider;

import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/13 9:57:33
 */
@JavaAPIProvider(JDKEmulator.class)
class LocaleServiceProviderPool {

    /**
     * <p>
     * A factory method that returns a singleton instance.
     * </p>
     * 
     * @param spi
     * @return
     */
    public static LocaleServiceProvider getPool(Class<? extends LocaleServiceProvider> spi) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Returns an array of available locales for all the provider classes. This array is a merged
     * array of all the locales that are provided by each provider, including the JRE.
     * </p>
     * 
     * @return
     */
    public static Locale[] getAvailableLocales() {
        return new Locale[] {Locale.US};
    }

    /**
     * <p>
     * Returns an array of available locales for all the provider classes. This array is a merged
     * array of all the locales that are provided by each provider, including the JRE.
     * </p>
     * 
     * @return
     */
    public static Locale[] getAllAvailableLocales() {
        return new Locale[] {Locale.US};
    }
}
