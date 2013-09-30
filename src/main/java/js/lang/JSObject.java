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
import booton.translator.JavascriptAPIProvider;

/**
 * @version 2013/09/04 16:55:40
 */
@JavaAPIProvider(Object.class)
@JavascriptAPIProvider("Object")
class JSObject {

    /** The global counter for hash. */
    private static int counter = 0;

    /** The cached hash. */
    private int hash = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void finalize() throws Throwable {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = ++counter;
        }
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return NativeObject.by(this).toString();
    }

    /**
     * Returns the runtime class of this {@code Object}. The returned {@code Class} object is the
     * object that is locked by {@code static synchronized} methods of the represented class.
     * <p>
     * <b>The actual result type is {@code Class<? extends |X|>} where {@code |X|} is the erasure of
     * the static type of the expression on which {@code getClass} is called.</b> For example, no
     * cast is required in this code fragment:
     * </p>
     * <p>
     * {@code Number n = 0;                             }<br>
     * {@code Class<? extends Number> c = n.getClass(); }
     * </p>
     * 
     * @return The {@code Class} object that represents the runtime class of this object.
     * @see Class Literals, section 15.8.2 of <cite>The Java&trade; Language Specification</cite>.
     */
    public Class<?> $alias$getClass() {
        NativeObject definition = NativeObject.by(this).getPropertyAs(NativeObject.class, "$");

        if (definition == null) {
            return Object.class;
        }
        return definition.getPropertyAs(Class.class, "$");
    }

    /**
     * Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting
     * on this object, one of them is chosen to be awakened. The choice is arbitrary and occurs at
     * the discretion of the implementation. A thread waits on an object's monitor by calling one of
     * the {@code wait} methods.
     * <p>
     * The awakened thread will not be able to proceed until the current thread relinquishes the
     * lock on this object. The awakened thread will compete in the usual manner with any other
     * threads that might be actively competing to synchronize on this object; for example, the
     * awakened thread enjoys no reliable privilege or disadvantage in being the next thread to lock
     * this object.
     * <p>
     * This method should only be called by a thread that is the owner of this object's monitor. A
     * thread becomes the owner of the object's monitor in one of three ways:
     * <ul>
     * <li>By executing a synchronized instance method of that object.
     * <li>By executing the body of a {@code synchronized} statement that synchronizes on the
     * object.
     * <li>For objects of type {@code Class,} by executing a synchronized static method of that
     * class.
     * </ul>
     * <p>
     * Only one thread at a time can own an object's monitor.
     * 
     * @exception IllegalMonitorStateException if the current thread is not the owner of this
     *                object's monitor.
     * @see java.lang.Object#notifyAll()
     * @see java.lang.Object#wait()
     */
    public final void $alias$notify() {
        throw new UnsupportedOperationException();
    }

    /**
     * Wakes up all threads that are waiting on this object's monitor. A thread waits on an object's
     * monitor by calling one of the {@code wait} methods.
     * <p>
     * The awakened threads will not be able to proceed until the current thread relinquishes the
     * lock on this object. The awakened threads will compete in the usual manner with any other
     * threads that might be actively competing to synchronize on this object; for example, the
     * awakened threads enjoy no reliable privilege or disadvantage in being the next thread to lock
     * this object.
     * <p>
     * This method should only be called by a thread that is the owner of this object's monitor. See
     * the {@code notify} method for a description of the ways in which a thread can become the
     * owner of a monitor.
     * 
     * @exception IllegalMonitorStateException if the current thread is not the owner of this
     *                object's monitor.
     * @see java.lang.Object#notify()
     * @see java.lang.Object#wait()
     */
    public final void $alias$notifyAll() {
        throw new UnsupportedOperationException();
    }

    /**
     * Causes the current thread to wait until either another thread invokes the
     * {@link java.lang.Object#notify()} method or the {@link java.lang.Object#notifyAll()} method
     * for this object, or a specified amount of time has elapsed.
     * <p>
     * The current thread must own this object's monitor.
     * <p>
     * This method causes the current thread (call it <var>T</var>) to place itself in the wait set
     * for this object and then to relinquish any and all synchronization claims on this object.
     * Thread <var>T</var> becomes disabled for thread scheduling purposes and lies dormant until
     * one of four things happens:
     * <ul>
     * <li>Some other thread invokes the {@code notify} method for this object and thread
     * <var>T</var> happens to be arbitrarily chosen as the thread to be awakened.
     * <li>Some other thread invokes the {@code notifyAll} method for this object.
     * <li>Some other thread {@linkplain Thread#interrupt() interrupts} thread <var>T</var>.
     * <li>The specified amount of real time has elapsed, more or less. If {@code timeout} is zero,
     * however, then real time is not taken into consideration and the thread simply waits until
     * notified.
     * </ul>
     * The thread <var>T</var> is then removed from the wait set for this object and re-enabled for
     * thread scheduling. It then competes in the usual manner with other threads for the right to
     * synchronize on the object; once it has gained control of the object, all its synchronization
     * claims on the object are restored to the status quo ante - that is, to the situation as of
     * the time that the {@code wait} method was invoked. Thread <var>T</var> then returns from the
     * invocation of the {@code wait} method. Thus, on return from the {@code wait} method, the
     * synchronization state of the object and of thread {@code T} is exactly as it was when the
     * {@code wait} method was invoked.
     * <p>
     * A thread can also wake up without being notified, interrupted, or timing out, a so-called
     * <i>spurious wakeup</i>. While this will rarely occur in practice, applications must guard
     * against it by testing for the condition that should have caused the thread to be awakened,
     * and continuing to wait if the condition is not satisfied. In other words, waits should always
     * occur in loops, like this one:
     * 
     * <pre>
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait(timeout);
     *         ... // Perform action appropriate to condition
     *     }
     * </pre>
     * (For more information on this topic, see Section 3.2.3 in Doug Lea's
     * "Concurrent Programming in Java (Second Edition)" (Addison-Wesley, 2000), or Item 50 in
     * Joshua Bloch's "Effective Java Programming Language Guide" (Addison-Wesley, 2001).
     * <p>
     * If the current thread is {@linkplain java.lang.Thread#interrupt() interrupted} by any thread
     * before or while it is waiting, then an {@code InterruptedException} is thrown. This exception
     * is not thrown until the lock status of this object has been restored as described above.
     * <p>
     * Note that the {@code wait} method, as it places the current thread into the wait set for this
     * object, unlocks only this object; any other objects on which the current thread may be
     * synchronized remain locked while the thread waits.
     * <p>
     * This method should only be called by a thread that is the owner of this object's monitor. See
     * the {@code notify} method for a description of the ways in which a thread can become the
     * owner of a monitor.
     * 
     * @param timeout the maximum time to wait in milliseconds.
     * @exception IllegalArgumentException if the value of timeout is negative.
     * @exception IllegalMonitorStateException if the current thread is not the owner of the
     *                object's monitor.
     * @exception InterruptedException if any thread interrupted the current thread before or while
     *                the current thread was waiting for a notification. The <i>interrupted
     *                status</i> of the current thread is cleared when this exception is thrown.
     * @see java.lang.Object#notify()
     * @see java.lang.Object#notifyAll()
     */
    public final void $alias$wait(long timeout) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    /**
     * Causes the current thread to wait until another thread invokes the
     * {@link java.lang.Object#notify()} method or the {@link java.lang.Object#notifyAll()} method
     * for this object, or some other thread interrupts the current thread, or a certain amount of
     * real time has elapsed.
     * <p>
     * This method is similar to the {@code wait} method of one argument, but it allows finer
     * control over the amount of time to wait for a notification before giving up. The amount of
     * real time, measured in nanoseconds, is given by: <blockquote>
     * 
     * <pre>
     * 1000000*timeout+nanos</pre>
     * </blockquote>
     * <p>
     * In all other respects, this method does the same thing as the method {@link #wait(long)} of
     * one argument. In particular, {@code wait(0, 0)} means the same thing as {@code wait(0)}.
     * <p>
     * The current thread must own this object's monitor. The thread releases ownership of this
     * monitor and waits until either of the following two conditions has occurred:
     * <ul>
     * <li>Another thread notifies threads waiting on this object's monitor to wake up either
     * through a call to the {@code notify} method or the {@code notifyAll} method.
     * <li>The timeout period, specified by {@code timeout} milliseconds plus {@code nanos}
     * nanoseconds arguments, has elapsed.
     * </ul>
     * <p>
     * The thread then waits until it can re-obtain ownership of the monitor and resumes execution.
     * <p>
     * As in the one argument version, interrupts and spurious wakeups are possible, and this method
     * should always be used in a loop:
     * 
     * <pre>
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait(timeout, nanos);
     *         ... // Perform action appropriate to condition
     *     }
     * </pre>
     * This method should only be called by a thread that is the owner of this object's monitor. See
     * the {@code notify} method for a description of the ways in which a thread can become the
     * owner of a monitor.
     * 
     * @param timeout the maximum time to wait in milliseconds.
     * @param nanos additional time, in nanoseconds range 0-999999.
     * @exception IllegalArgumentException if the value of timeout is negative or the value of nanos
     *                is not in the range 0-999999.
     * @exception IllegalMonitorStateException if the current thread is not the owner of this
     *                object's monitor.
     * @exception InterruptedException if any thread interrupted the current thread before or while
     *                the current thread was waiting for a notification. The <i>interrupted
     *                status</i> of the current thread is cleared when this exception is thrown.
     */
    public final void $alias$wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException("nanosecond timeout value out of range");
        }

        if (nanos >= 500000 || (nanos != 0 && timeout == 0)) {
            timeout++;
        }

        wait(timeout);
    }

    /**
     * Causes the current thread to wait until another thread invokes the
     * {@link java.lang.Object#notify()} method or the {@link java.lang.Object#notifyAll()} method
     * for this object. In other words, this method behaves exactly as if it simply performs the
     * call {@code wait(0)}.
     * <p>
     * The current thread must own this object's monitor. The thread releases ownership of this
     * monitor and waits until another thread notifies threads waiting on this object's monitor to
     * wake up either through a call to the {@code notify} method or the {@code notifyAll} method.
     * The thread then waits until it can re-obtain ownership of the monitor and resumes execution.
     * <p>
     * As in the one argument version, interrupts and spurious wakeups are possible, and this method
     * should always be used in a loop:
     * 
     * <pre>
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait();
     *         ... // Perform action appropriate to condition
     *     }
     * </pre>
     * This method should only be called by a thread that is the owner of this object's monitor. See
     * the {@code notify} method for a description of the ways in which a thread can become the
     * owner of a monitor.
     * 
     * @exception IllegalMonitorStateException if the current thread is not the owner of the
     *                object's monitor.
     * @exception InterruptedException if any thread interrupted the current thread before or while
     *                the current thread was waiting for a notification. The <i>interrupted
     *                status</i> of the current thread is cleared when this exception is thrown.
     * @see java.lang.Object#notify()
     * @see java.lang.Object#notifyAll()
     */
    public final void $alias$wait() throws InterruptedException {
        wait(0);
    }
}
