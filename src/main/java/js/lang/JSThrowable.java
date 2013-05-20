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

    /** The stacktrace info. */
    private StackTraceElement[] stacktrace;

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

        String[][] stacktrace = Debugger.createStackTrace();
        this.stacktrace = new StackTraceElement[stacktrace.length];

        for (int i = 0; i < stacktrace.length; i++) {
            this.stacktrace[i] = new StackTraceElement("", stacktrace[i][0], stacktrace[i][1], Integer.parseInt(stacktrace[i][2]));
        }
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
     * Provides programmatic access to the stack trace information printed by
     * {@link #printStackTrace()}. Returns an array of stack trace elements, each representing one
     * stack frame. The zeroth element of the array (assuming the array's length is non-zero)
     * represents the top of the stack, which is the last method invocation in the sequence.
     * Typically, this is the point at which this throwable was created and thrown. The last element
     * of the array (assuming the array's length is non-zero) represents the bottom of the stack,
     * which is the first method invocation in the sequence.
     * <p>
     * Some virtual machines may, under some circumstances, omit one or more stack frames from the
     * stack trace. In the extreme case, a virtual machine that has no stack trace information
     * concerning this throwable is permitted to return a zero-length array from this method.
     * Generally speaking, the array returned by this method will contain one element for every
     * frame that would be printed by {@code printStackTrace}. Writes to the returned array do not
     * affect future calls to this method.
     * 
     * @return an array of stack trace elements representing the stack trace pertaining to this
     *         throwable.
     * @since 1.4
     */
    public StackTraceElement[] getStackTrace() {
        return stacktrace;
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

    }
}