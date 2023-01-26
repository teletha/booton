/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.i18n;

import js.lang.NativeString;
import kiss.Managed;
import kiss.Singleton;

@Managed(Singleton.class)
public abstract class TextLocalizer {

    /**
     * <p>
     * Create text expression.
     * </p>
     * 
     * @param texts
     * @return
     */
    protected String $(Object... texts) {
        NativeString builder = new NativeString();

        for (Object text : texts) {
            builder = builder.concat(String.valueOf(text));
        }
        return builder.toString();
    }
}
