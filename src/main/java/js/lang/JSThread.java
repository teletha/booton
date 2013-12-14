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
 * @version 2013/08/08 23:52:55
 */
@JavaAPIProvider(Thread.class)
class JSThread {

    /** This filed is null unless explicitly set. */
    private static volatile UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    /**
     * Tests if this thread is alive. A thread is alive if it has been started and has not yet died.
     * 
     * @return <code>true</code> if this thread is alive; <code>false</code> otherwise.
     */
    public final boolean isAlive() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Waits at most {@code millis} milliseconds for this thread to die. A timeout of {@code 0}
     * means to wait forever.
     * <p>
     * This implementation uses a loop of {@code this.wait} calls conditioned on
     * {@code this.isAlive}. As a thread terminates the {@code this.notifyAll} method is invoked. It
     * is recommended that applications not use {@code wait}, {@code notify}, or {@code notifyAll}
     * on {@code Thread} instances.
     * 
     * @param millis the time to wait in milliseconds
     * @throws IllegalArgumentException if the value of {@code millis} is negative
     * @throws InterruptedException if any thread has interrupted the current thread. The
     *             <i>interrupted status</i> of the current thread is cleared when this exception is
     *             thrown.
     */
    public final synchronized void join(long millis) throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;

        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (millis == 0) {
            while (isAlive()) {
                wait(0);
            }
        } else {
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }

    /**
     * Waits at most {@code millis} milliseconds plus {@code nanos} nanoseconds for this thread to
     * die.
     * <p>
     * This implementation uses a loop of {@code this.wait} calls conditioned on
     * {@code this.isAlive}. As a thread terminates the {@code this.notifyAll} method is invoked. It
     * is recommended that applications not use {@code wait}, {@code notify}, or {@code notifyAll}
     * on {@code Thread} instances.
     * 
     * @param millis the time to wait in milliseconds
     * @param nanos {@code 0-999999} additional nanoseconds to wait
     * @throws IllegalArgumentException if the value of {@code millis} is negative, or the value of
     *             {@code nanos} is not in the range {@code 0-999999}
     * @throws InterruptedException if any thread has interrupted the current thread. The
     *             <i>interrupted status</i> of the current thread is cleared when this exception is
     *             thrown.
     */
    public final synchronized void join(long millis, int nanos) throws InterruptedException {

        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException("nanosecond timeout value out of range");
        }

        if (nanos >= 500000 || (nanos != 0 && millis == 0)) {
            millis++;
        }
        join(millis);
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution) for the
     * specified number of milliseconds, subject to the precision and accuracy of system timers and
     * schedulers. The thread does not lose ownership of any monitors.
     * 
     * @param millis the length of time to sleep in milliseconds
     * @throws IllegalArgumentException if the value of {@code millis} is negative
     * @throws InterruptedException if any thread has interrupted the current thread. The
     *             <i>interrupted status</i> of the current thread is cleared when this exception is
     *             thrown.
     */
    public static void sleep(long millis) throws InterruptedException {
        // FIXME busy loop
        long start = System.currentTimeMillis();
        long now = start;

        while (now < start + millis) {
            now = System.currentTimeMillis();
        }
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution) for the
     * specified number of milliseconds plus the specified number of nanoseconds, subject to the
     * precision and accuracy of system timers and schedulers. The thread does not lose ownership of
     * any monitors.
     * 
     * @param millis the length of time to sleep in milliseconds
     * @param nanos {@code 0-999999} additional nanoseconds to sleep
     * @throws IllegalArgumentException if the value of {@code millis} is negative, or the value of
     *             {@code nanos} is not in the range {@code 0-999999}
     * @throws InterruptedException if any thread has interrupted the current thread. The
     *             <i>interrupted status</i> of the current thread is cleared when this exception is
     *             thrown.
     */
    public static void sleep(long millis, int nanos) throws InterruptedException {
        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException("nanosecond timeout value out of range");
        }

        if (nanos >= 500000 || (nanos != 0 && millis == 0)) {
            millis++;
        }
        sleep(millis);
    }

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
            defaultUncaughtExceptionHandler.uncaughtException(null, JSThrowable.wrap(error));
        }
    }
}
