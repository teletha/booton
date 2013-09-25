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
}
