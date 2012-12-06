/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import booton.translator.Translator;

/**
 * @version 2012/12/06 18:50:39
 */
public class JsArrayTranslator extends Translator<JsArray> {

    public String JsArray() {
        return "[]";
    }

    public String iterator() {
        return that + ".it()";
    }

    public String push(Object param0) {
        return that + ".push(" + param(0) + ")";
    }
}
