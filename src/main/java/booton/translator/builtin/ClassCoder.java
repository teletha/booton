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
 * @version 2012/12/10 17:06:22
 */
class ClassCoder extends Translator<Class> {

    public String getName() {
        return "\"boot.\"+" + that + ".className";
    }

    public String getSimpleName() {
        return that + ".className";
    }

    public String newInstance() {
        return that + ".newInstance()";
    }

    public String getMethods() {
        return that + ".getMethods()";
    }
}
