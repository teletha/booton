/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import booton.translator.Translator;

/**
 * @version 2012/12/08 2:37:09
 */
public class NativeMapTranslator extends Translator<NativeMap> {

    public String NativeMap() {
        return "Map()";
    }

    public String get(Object param0) {
        return that + ".get(" + param(0) + ")";
    }

    public String set(Object param0, Object param1) {
        return that + ".set(" + param(0) + "," + param(1) + ")";
    }
}
