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

import booton.translator.Translator;

/**
 * @version 2013/02/12 13:38:36
 */
class CharacterCoder extends Translator<Character> {

    public String isDigit(char param0) {
        return "jQuery.isNumeric(" + param(0) + ")";
    }

    public String valueOf(char param0) {
        return param(0);
    }
}
