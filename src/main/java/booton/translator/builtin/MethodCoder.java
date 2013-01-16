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

import java.lang.reflect.Method;

import booton.translator.Translator;

/**
 * @version 2013/01/16 15:40:32
 */
class MethodCoder extends Translator<Method> {

    public String getName() {
        return that + ".$Name";
    }

    public String isAnnotationPresent(Class param0) {
        return that + ".isAnnotationPresent(" + param(0) + ")";
    }
}
