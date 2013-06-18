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

import java.util.regex.Matcher;

import booton.translator.Translator;

/**
 * @version 2013/01/10 23:18:33
 */
class MatcherCoder extends Translator<Matcher> {

    public String matches() {
        return that + "!=null";
    }

    public String group() {
        return that + "[0]";
    }

    public String group(int index) {
        return that + "[" + param(0) + "]";
    }

    public String groupCount() {
        return that + ".length-1";
    }
}
