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
 * @version 2013/01/16 11:54:29
 */
class DoubleCoder extends Translator<Double> {

    public String valueOf(double param0) {
        return param(0);
    }

    public String doubleValue() {
        return that;
    }
}
