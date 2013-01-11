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

import java.lang.reflect.Array;

import booton.translator.Translator;

/**
 * @version 2013/01/11 15:37:22
 */
class ArrayCoder extends Translator<Array> {

    public String newInstance(Class param0, int param1) {
        return "[]";
    }
}
