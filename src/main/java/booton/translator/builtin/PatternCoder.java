/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.util.regex.Pattern;

import booton.translator.Translator;

/**
 * @version 2013/01/10 23:13:41
 */
class PatternCoder extends Translator<Pattern> {

    public String compile(String pattern) {
        return regex(0);
    }

    public String pattern() {
        return that + ".source";
    }

    public String matcher(CharSequence test) {
        return that + ".exec(" + param(0) + ")";
    }
}
