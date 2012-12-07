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

    public String length() {
        return that + ".length";
    }

    public String get(int param0) {
        return that + "[" + param(0) + "]";
    }

    public String iterator() {
        return that + ".it()";
    }

    public String push(Object param0) {
        return that + ".push(" + param(0) + ")";
    }

    public String indexOf(Object param0) {
        return that + ".indexOf(" + param(0) + ")";
    }

    public String remove(int param0, int param1) {
        return that + ".splice(" + param(0) + "," + param(1) + ")";
    }

    public String splice(int param0, int param1, JsArray param2) {
        return that + ".splice(" + param(0) + "," + param(1) + "," + param(2) + ")";
    }
}
