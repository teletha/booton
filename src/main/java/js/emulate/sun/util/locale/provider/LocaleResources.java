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

import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 9:38:54
 */
@JavaAPIProvider(sun.util.locale.provider.LocaleResources.class)
class LocaleResources {

    public ResourceBundle getJavaTimeFormatData() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String getJavaTimeDateTimePattern(int a, int b, String c) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public Object[] getDecimalFormatSymbolsData() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String getDateTimePattern(int a, int b, Calendar calendar) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String[] getJavaTimeNames(String name) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String[] getCalendarNames(String name) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public Set getZoneIDs() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String getTimeZoneNames(String name, int a) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String[][] getZoneStrings() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
