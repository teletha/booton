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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/07/27 10:48:12
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
        this.stacktrace = createStackTrace(Global.error(), true);
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
     * Sets the stack trace elements that will be returned by {@link #getStackTrace()} and printed
     * by {@link #printStackTrace()} and related methods. This method, which is designed for use by
     * RPC frameworks and other advanced systems, allows the client to override the default stack
     * trace that is either generated by {@link #fillInStackTrace()} when a throwable is constructed
     * or deserialized when a throwable is read from a serialization stream.
     * <p>
     * If the stack trace of this {@code Throwable}
     * {@linkplain Throwable#Throwable(String, Throwable, boolean, boolean) is not writable},
     * calling this method has no effect other than validating its argument.
     * 
     * @param stackTrace the stack trace elements to be associated with this {@code Throwable}. The
     *            specified array is copied by this call; changes in the specified array after the
     *            method invocation returns will have no affect on this {@code Throwable}'s stack
     *            trace.
     * @throws NullPointerException if {@code stackTrace} is {@code null} or if any of the elements
     *             of {@code stackTrace} are {@code null}
     * @since 1.4
     */
    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stacktrace = stackTrace;
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

    /**
     * <p>
     * Create stack trace ement from the specified {@link NativeError}.
     * </p>
     * 
     * @param error A native error.
     * @param user A flag for user constructed error.
     * @return
     */
    static StackTraceElement[] createStackTrace(NativeError error, boolean user) {
        Pattern pattern = null;
        String[] lines;
        String stack = error.getStackTrace();

        if (stack != null) {
            lines = stack.split("\n");
        } else {
            lines = new String[] {error.getName() + "@" + error.getFileName() + ":" + error.getLineNumber(), "", ""};
        }

        int start = 0;
        int end = lines.length - 1;

        if (error.hasProperty("columnNumber")) {
            // firefox
            pattern = Pattern.compile("\\.?(.+)?@(.+):(.+)");
            end--;
        } else if (error.hasProperty("sourceURL")) {
            // webkit
        } else if (error.hasProperty("number")) {
            // ie
            pattern = Pattern.compile("\\s*at\\s*(.+)\\s\\((.+):(.+):(.+)\\)");
            start++;
        } else if (error.getStackTrace().contains("@")) {
            // html unit
            pattern = Pattern.compile("(.+)?@(.+):(.+)");
            start = start + 5;
            end--;
        } else {
            // blink
            pattern = Pattern.compile("\\s*at\\s*([^\\s]+).+\\((.+):(.+):(.+)\\)");
            start++;
        }

        List<StackTraceElement> elements = new ArrayList();

        for (int i = start; i < end; i++) {
            Matcher matcher = pattern.matcher(lines[i].trim());

            if (matcher.matches()) {
                String method = matcher.group(1);

                if (method == null) {
                    method = "";
                }

                int index = method.lastIndexOf(".");
                method = index == -1 ? method : method.substring(index + 1);

                elements.add(new StackTraceElement("", method, matcher.group(2), Integer.parseInt(matcher.group(3))));
            }
        }

        if (user) {
            // remove the sequence of Throwable construction
            int index = -1;

            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getMethodName().equals("Class") && elements.get(i)
                        .getFileName()
                        .contains("boot.js")) {
                    index = i;
                    break;
                }
            }
            elements = elements.subList(index + 1, elements.size());
        }
        return elements.toArray(new StackTraceElement[elements.size()]);
    }

    /**
     * <p>
     * Convert to {@link Throwable} object if the specified error is native.
     * </p>
     * 
     * @param error A native error object or not.
     * @return A wrapped {@link Throwable} object.
     */
    static Throwable wrap(Object error) {
        Throwable throwable;

        if (error instanceof Throwable) {
            throwable = (Throwable) error;
        } else {
            NativeError nativeError = (NativeError) error;
            throwable = new Error(nativeError.getMessage());
            throwable.setStackTrace(createStackTrace(nativeError, false));
        }
        return throwable;
    }
}