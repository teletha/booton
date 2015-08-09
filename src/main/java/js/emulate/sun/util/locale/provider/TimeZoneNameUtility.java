/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.emulate.sun.util.locale.provider;

import java.util.Locale;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 14:45:58
 */
@JavaAPIProvider(JDKEmulator.class)
class TimeZoneNameUtility {

    public static String retrieveDisplayName(String name, boolean b, int i, Locale locale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public static String[] retrieveDisplayNames(String name, Locale locale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public static String[][] getZoneStrings(Locale locale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public static String retrieveGenericDisplayName(String bane, int i, Locale locale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
