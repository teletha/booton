/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/08 23:52:55
 */
@JavaAPIProvider(Thread.class)
class JSThread {

    /** The javascript main thread. */
    private static final Thread main = new Thread();

    /** The uncaught exceptions. */
    private static final List<Throwable> errors = new ArrayList();

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
     * Interrupts this thread.
     * <p>
     * Unless the current thread is interrupting itself, which is always permitted, the
     * {@link #checkAccess() checkAccess} method of this thread is invoked, which may cause a
     * {@link SecurityException} to be thrown.
     * <p>
     * If this thread is blocked in an invocation of the {@link Object#wait() wait()},
     * {@link Object#wait(long) wait(long)}, or {@link Object#wait(long, int) wait(long, int)}
     * methods of the {@link Object} class, or of the {@link #join()}, {@link #join(long)},
     * {@link #join(long, int)}, {@link #sleep(long)}, or {@link #sleep(long, int)}, methods of this
     * class, then its interrupt status will be cleared and it will receive an
     * {@link InterruptedException}.
     * <p>
     * If this thread is blocked in an I/O operation upon an
     * {@link java.nio.channels.InterruptibleChannel InterruptibleChannel} then the channel will be
     * closed, the thread's interrupt status will be set, and the thread will receive a
     * {@link java.nio.channels.ClosedByInterruptException}.
     * <p>
     * If this thread is blocked in a {@link java.nio.channels.Selector} then the thread's interrupt
     * status will be set and it will return immediately from the selection operation, possibly with
     * a non-zero value, just as if the selector's {@link java.nio.channels.Selector#wakeup wakeup}
     * method were invoked.
     * <p>
     * If none of the previous conditions hold then this thread's interrupt status will be set.
     * </p>
     * <p>
     * Interrupting a thread that is not alive need not have any effect.
     * 
     * @throws SecurityException if the current thread cannot modify this thread
     * @revised 6.0
     * @spec JSR-51
     */
    public void interrupt() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Tests whether this thread has been interrupted. The <i>interrupted status</i> of the thread
     * is unaffected by this method.
     * <p>
     * A thread interruption ignored because a thread was not alive at the time of the interrupt
     * will be reflected by this method returning false.
     * 
     * @return <code>true</code> if this thread has been interrupted; <code>false</code> otherwise.
     * @see #interrupted()
     * @revised 6.0
     */
    public boolean isInterrupted() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns this thread's name.
     * 
     * @return this thread's name.
     * @see #setName(String)
     */
    public final String getName() {
        return "main";
    }

    /**
     * Returns this thread's priority.
     *
     * @return this thread's priority.
     * @see #setPriority
     */
    public final int getPriority() {
        return 0; // no support
    }

    /**
     * Returns the thread group to which this thread belongs. This method returns null if this
     * thread has died (been stopped).
     * 
     * @return this thread's thread group.
     */
    public final ThreadGroup getThreadGroup() {
        return new ThreadGroup("main");
    }

    /**
     * Marks this thread as either a {@linkplain #isDaemon daemon} thread or a user thread. The Java
     * Virtual Machine exits when the only threads running are all daemon threads.
     * <p>
     * This method must be invoked before the thread is started.
     * 
     * @param on if {@code true}, marks this thread as a daemon thread
     * @throws IllegalThreadStateException if this thread is {@linkplain #isAlive alive}
     * @throws SecurityException if {@link #checkAccess} determines that the current thread cannot
     *             modify this thread
     */
    public final void setDaemon(boolean on) {
        // no support
    }

    /**
     * Changes the priority of this thread.
     * <p>
     * First the <code>checkAccess</code> method of this thread is called with no arguments. This
     * may result in throwing a <code>SecurityException</code>.
     * <p>
     * Otherwise, the priority of this thread is set to the smaller of the specified
     * <code>newPriority</code> and the maximum permitted priority of the thread's thread group.
     *
     * @param newPriority priority to set this thread to
     * @exception IllegalArgumentException If the priority is not in the range
     *                <code>MIN_PRIORITY</code> to <code>MAX_PRIORITY</code>.
     * @exception SecurityException if the current thread cannot modify this thread.
     * @see #getPriority
     * @see #checkAccess()
     * @see #getThreadGroup()
     * @see #MAX_PRIORITY
     * @see #MIN_PRIORITY
     * @see ThreadGroup#getMaxPriority()
     */
    public final void setPriority(int newPriority) {
        // no support
    }

    /**
     * Causes this thread to begin execution; the Java Virtual Machine calls the <code>run</code>
     * method of this thread.
     * <p>
     * The result is that two threads are running concurrently: the current thread (which returns
     * from the call to the <code>start</code> method) and the other thread (which executes its
     * <code>run</code> method).
     * <p>
     * It is never legal to start a thread more than once. In particular, a thread may not be
     * restarted once it has completed execution.
     *
     * @exception IllegalThreadStateException if the thread was already started.
     * @see #run()
     * @see #stop()
     */
    public synchronized void start() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Tests if this thread is a daemon thread.
     * 
     * @return <code>true</code> if this thread is a daemon thread; <code>false</code> otherwise.
     * @see #setDaemon(boolean)
     */
    public final boolean isDaemon() {
        return false;
    }

    /**
     * Returns the handler invoked when this thread abruptly terminates due to an uncaught
     * exception. If this thread has not had an uncaught exception handler explicitly set then this
     * thread's <tt>ThreadGroup</tt> object is returned, unless this thread has terminated, in which
     * case <tt>null</tt> is returned.
     * 
     * @since 1.5
     * @return the uncaught exception handler for this thread
     */
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return defaultUncaughtExceptionHandler;
    }

    /**
     * Set the handler invoked when this thread abruptly terminates due to an uncaught exception.
     * <p>
     * A thread can take full control of how it responds to uncaught exceptions by having its
     * uncaught exception handler explicitly set. If no such handler is set then the thread's
     * <tt>ThreadGroup</tt> object acts as its handler.
     * 
     * @param handler the object to use as this thread's uncaught exception handler. If
     *            <tt>null</tt> then this thread has no explicit handler.
     * @throws SecurityException if the current thread is not allowed to modify this thread.
     * @see #setDefaultUncaughtExceptionHandler
     * @see ThreadGroup#uncaughtException
     * @since 1.5
     */
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        defaultUncaughtExceptionHandler = handler;
    }

    /**
     * Returns a reference to the currently executing thread object.
     * 
     * @return the currently executing thread.
     */
    public static Thread currentThread() {
        return main;
    }

    /**
     * Tests whether the current thread has been interrupted. The <i>interrupted status</i> of the
     * thread is cleared by this method. In other words, if this method were to be called twice in
     * succession, the second call would return false (unless the current thread were interrupted
     * again, after the first call had cleared its interrupted status and before the second call had
     * examined it).
     * <p>
     * A thread interruption ignored because a thread was not alive at the time of the interrupt
     * will be reflected by this method returning false.
     * 
     * @return <code>true</code> if the current thread has been interrupted; <code>false</code>
     *         otherwise.
     * @see #isInterrupted()
     * @revised 6.0
     */
    public static boolean interrupted() {
        return currentThread().isInterrupted();
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
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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

        if (!errors.isEmpty()) {
            for (Throwable error : errors) {
                defaultUncaughtExceptionHandler.uncaughtException(null, error);
            }
            errors.clear();
        }
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
     * A hint to the scheduler that the current thread is willing to yield its current use of a
     * processor. The scheduler is free to ignore this hint.
     * <p>
     * Yield is a heuristic attempt to improve relative progression between threads that would
     * otherwise over-utilise a CPU. Its use should be combined with detailed profiling and
     * benchmarking to ensure that it actually has the desired effect.
     * <p>
     * It is rarely appropriate to use this method. It may be useful for debugging or testing
     * purposes, where it may help to reproduce bugs due to race conditions. It may also be useful
     * when designing concurrency control constructs such as the ones in the
     * {@link java.util.concurrent.locks} package.
     */
    public static void yield() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Handle uncaught error.
     * </p>
     * 
     * @param error
     */
    static void handleUncaughtException(Object error) {
        Throwable wrap = JSThrowable.wrap(error);

        if (defaultUncaughtExceptionHandler != null) {
            defaultUncaughtExceptionHandler.uncaughtException(null, wrap);
        } else {
            System.out.println(wrap.getMessage());
            wrap.printStackTrace();

            errors.add(wrap);
        }
    }

}
