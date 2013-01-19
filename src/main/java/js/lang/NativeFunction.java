/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.Translator;

/**
 * @version 2013/01/18 2:13:18
 */
public class NativeFunction extends NativeObject {

    public Object apply(Object context, Object[] parameters) {
        return null;
    }

    /**
     * @version 2013/01/18 2:14:52
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeFunction> {

        public String apply(Object param0, Object[] param1) {
            return that + ".apply(" + param(0) + "," + param(1) + ")";
        }
    }
}
