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
 * @version 2013/07/25 19:21:47
 */
public class NativeError extends NativeObject {

    /**
     * <p>
     * Retrieve current error message.
     * </p>
     * 
     * @return
     */
    public String getMessage() {
        return "";
    }

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
     * @version 2013/07/25 19:21:51
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeError> {

        /**
         * <p>
         * Retrieve current error message.
         * </p>
         * 
         * @return
         */
        public String getMessage() {
            return that + ".message";
        }

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
