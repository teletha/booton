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

import java.lang.Thread.UncaughtExceptionHandler;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/07/25 19:21:41
 */
@JavaAPIProvider(Thread.class)
class JSThread {

    /** This filed is null unless explicitly set. */
    private static volatile UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    /**
     * Set the default handler invoked when a thread abruptly terminates due to an uncaught
     * exception, and no other handler has been defined for that thread.
     * <p>
     * Uncaught exception handling is controlled first by the thread, then by the thread's
     * {@link ThreadGroup} object and finally by the default uncaught exception handler. If the
     * thread does not have an explicit uncaught exception handler set, and the thread's thread
     * group (including parent thread groups) does not specialize its <tt>uncaughtException</tt>
     * method, then the default handler's <tt>uncaughtException</tt> method will be invoked.
     * <p>
     * By setting the default uncaught exception handler, an application can change the way in which
     * uncaught exceptions are handled (such as logging to a specific device, or file) for those
     * threads that would already accept whatever &quot;default&quot; behavior the system provided.
     * <p>
     * Note that the default uncaught exception handler should not usually defer to the thread's
     * <tt>ThreadGroup</tt> object, as that could cause infinite recursion.
     * 
     * @param handler the object to use as the default uncaught exception handler. If <tt>null</tt>
     *            then there is no default handler.
     * @throws SecurityException if a security manager is present and it denies <tt>
     *             {@link RuntimePermission} (&quot;setDefaultUncaughtExceptionHandler&quot;)</tt>
     * @see #setUncaughtExceptionHandler
     * @see #getUncaughtExceptionHandler
     * @see ThreadGroup#uncaughtException
     * @since 1.5
     */
    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        defaultUncaughtExceptionHandler = handler;
    }

    /**
     * Returns the default handler invoked when a thread abruptly terminates due to an uncaught
     * exception. If the returned value is <tt>null</tt>, there is no default.
     * 
     * @since 1.5
     * @see #setDefaultUncaughtExceptionHandler
     */
    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtExceptionHandler;
    }

    /**
     * <p>
     * Handle uncaught error.
     * </p>
     * 
     * @param error
     */
    static void handleUncaughtException(Object error) {
        if (defaultUncaughtExceptionHandler != null) {
            Throwable throwable;

            if (error instanceof Throwable) {
                throwable = (Throwable) error;
            } else {
                throwable = new Error(((NativeError) error).getMessage());
                throwable.setStackTrace(JSThrowable.createStackTrace((NativeError) error, false));
            }
            defaultUncaughtExceptionHandler.uncaughtException(null, throwable);
        }
    }
}
