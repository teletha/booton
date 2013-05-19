/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import js.lang.NativeObject;
import booton.translator.Translator;

/**
 * @version 2013/05/18 21:11:02
 */
class Debugger {

    static native NativeObject stacktrace();

    /**
     * @version 2013/05/18 21:11:22
     */
    private static class Coder extends Translator<Debugger> {

        public String stacktrace() {
            return "boot.stacktrace()";
        }
    }
}