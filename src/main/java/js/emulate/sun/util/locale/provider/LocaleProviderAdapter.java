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

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

import sun.util.locale.provider.LocaleResources;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/12 2:53:27
 */
@JavaAPIProvider(JDKEmulator.class)
@Manageable(lifestyle = Singleton.class)
class LocaleProviderAdapter {

    public static LocaleProviderAdapter forJRE() {
        return I.make(LocaleProviderAdapter.class);
    }

    public LocaleResources getLocalResources(Locale locale) {
        return null;
    }
}
