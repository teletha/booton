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

import booton.translator.Translator;

/**
 * @version 2012/12/03 19:23:51
 */
public class HashMapTranslator extends Translator<HashMapTranslator> {

    public String HashMap() {
        return "{}";
    }

    public String put(Object param0, Object param1) {
        return that + "[" + param(0) + "]=" + param(1);
    }

    public String get(Object param0) {
        return that + "[" + param(0) + "]";
    }
}
