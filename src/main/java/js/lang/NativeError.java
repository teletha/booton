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
 * @version 2013/05/19 17:35:44
 */
public class NativeError extends NativeObject {

    /**
     * <p>
     * Retrieve current stack trace.
     * </p>
     * 
     * @return
     */
    public String getStackTrace() {
        return "";
    }

    /**
     * @version 2013/05/19 17:57:36
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeError> {

        /**
         * <p>
         * Retrieve current stack trace.
         * </p>
         * 
         * @return
         */
        public String getStackTrace() {
            return that + ".stack";
        }
    }
}
