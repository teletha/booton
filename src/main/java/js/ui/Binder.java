/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import booton.translator.JavascriptNative;
import booton.translator.Translator;

/**
 * @version 2013/04/09 2:10:07
 */
class Binder implements JavascriptNative {

    static native void bind(Object model, String propertyName);

    /**
     * @version 2013/04/09 2:11:08
     */
    private static class Coder extends Translator<Binder> {

        public String bind(Object param0, String param1) {
            return "boot.bindable(" + param(0) + "," + param(1) + ")";
        }
    }
}