/*
 * Copyright (C) 2016 Nameless Production Committee
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

    /** The name. */
    private String name;

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
     * <p>
     * The value for the method name property on the created Error object. Defaults to the name of
     * the file containing the code that called the Error() constructor.
     * </p>
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * The value for the fileName property on the created Error object. Defaults to the name of the
     * file containing the code that called the Error() constructor.
     * </p>
     * 
     * @return
     */
    public String getFileName() {
        return name;
    }

    /**
     * <p>
     * The value for the lineNumber property on the created Error object. Defaults to the line
     * number containing the Error() constructor invokation.
     * </p>
     * 
     * @return
     */
    public String getLineNumber() {
        return name;
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

        /**
         * <p>
         * The value for the method name property on the created Error object. Defaults to the name
         * of the file containing the code that called the Error() constructor.
         * </p>
         * 
         * @return
         */
        public String getName() {
            return that + ".name";
        }

        /**
         * <p>
         * The value for the fileName property on the created Error object. Defaults to the name of
         * the file containing the code that called the Error() constructor.
         * </p>
         * 
         * @return
         */
        public String getFileName() {
            return that + ".filename";
        }

        /**
         * <p>
         * The value for the lineNumber property on the created Error object. Defaults to the line
         * number containing the Error() constructor invokation.
         * </p>
         * 
         * @return
         */
        public String getLineNumber() {
            return that + ".lineNumber";
        }
    }
}
