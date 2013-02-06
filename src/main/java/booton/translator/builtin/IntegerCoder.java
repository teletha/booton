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
 * @version 2012/12/09 0:23:19
 */
public class IntegerCoder extends Translator<Integer> {

    public String valueOf(int param0) {
        return param(0);
    }

    public String intValue() {
        return that;
    }

    public String parseInt(String param0) {
        return "parseInt(" + param(0) + ")";
    }
}
