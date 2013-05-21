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
 * @version 2013/05/16 9:54:51
 */
class Debugger {

    /**
     * <p>
     * Throw native error to build stack trace.
     * </p>
     * 
     * @return
     */
    static native NativeError error();

    /**
     * @version 2013/05/16 9:55:25
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Debugger> {

        /**
         * <p>
         * Throw native error to build stack trace.
         * </p>
         * 
         * @return
         */
        public String error() {
            return "boot.error()";
        }
    }
}
