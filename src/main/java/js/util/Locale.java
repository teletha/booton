/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Locale.Category;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:01:43
 */
@JavaAPIProvider(java.util.Locale.class)
class Locale {

    /** The base language. */
    private String language = "en";

    /**
     * Returns the language code of this Locale.
     * <p>
     * <b>Note:</b> ISO 639 is not a stable standard&mdash; some languages' codes have changed.
     * Locale's constructor recognizes both the new and the old codes for the languages whose codes
     * have changed, but this function always returns the old code. If you want to check for a
     * specific language whose code has changed, don't do
     * 
     * <pre>
     * if (locale.getLanguage().equals("he")) // BAD!
     *    ...
     * </pre>
     * Instead, do
     * 
     * <pre>
     * if (locale.getLanguage().equals(new Locale("he").getLanguage()))
     *    ...
     * </pre>
     * 
     * @return The language code, or the empty string if none is defined.
     * @see #getDisplayLanguage
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the current value of the default locale for this instance of the Java Virtual Machine.
     * <p>
     * The Java Virtual Machine sets the default locale during startup based on the host
     * environment. It is used by many locale-sensitive methods if no locale is explicitly
     * specified. It can be changed using the {@link #setDefault(java.util.Locale) setDefault}
     * method.
     * 
     * @return the default locale for this instance of the Java Virtual Machine
     */
    public static Locale getDefault() {
        return new Locale();
    }

    /**
     * Gets the current value of the default locale for the specified Category for this instance of
     * the Java Virtual Machine.
     * <p>
     * The Java Virtual Machine sets the default locale during startup based on the host
     * environment. It is used by many locale-sensitive methods if no locale is explicitly
     * specified. It can be changed using the setDefault(Locale.Category, Locale) method.
     * 
     * @param category - the specified category to get the default locale
     * @throws NullPointerException - if category is null
     * @return the default locale for the specified Category for this instance of the Java Virtual
     *         Machine
     * @see #setDefault(Locale.Category, Locale)
     * @since 1.7
     */
    public static Locale getDefault(Category category) {
        return getDefault();
    }
}
