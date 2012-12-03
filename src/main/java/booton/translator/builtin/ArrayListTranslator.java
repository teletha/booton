/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.util.ArrayList;

import booton.translator.Translator;

/**
 * @version 2012/12/03 19:11:57
 */
public class ArrayListTranslator extends Translator<ArrayList> {

    public String ArrayList() {
        return "[]";
    }

    public String add(Object value) {
        return that + ".push(" + param(0) + ")";
    }

    public String get(int index) {
        return that + "[" + param(0) + "]";
    }
}
