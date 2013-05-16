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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/01/19 9:27:51
 */
@JavaAPIProvider(Throwable.class)
class JSThrowable {

    /** The error message. */
    private final String message;

    /** The cause error. */
    private Throwable cause;

    /**
     * 
     */
    public JSThrowable() {
        this("", null);
    }

    /**
     * @param message
     */
    public JSThrowable(String message) {
        this(message, null);
    }

    /**
     * @param cause
     */
    public JSThrowable(Throwable cause) {
        this("", cause);
    }

    /**
     * @param message
     * @param cause
     */
    public JSThrowable(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public JSThrowable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        this(message, cause);
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public String getLocalizedMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public void printStackTrace() {
        Debugger.printStackTrace();
    }
}