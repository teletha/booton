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

import java.util.Arrays;

import booton.translator.Translator;

/**
 * @version 2012/12/07 15:44:01
 */
class ArraysCoder extends Translator<Arrays> {

    public String copyOf(Object[] original, int newLength) {
        return param(0) + ".slice(" + param(1) + ")";
    }
}
