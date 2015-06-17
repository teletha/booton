/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 20:55:31
 */
@JavaAPIProvider(java.util.concurrent.locks.ReentrantLock.class)
class ReentrantLock implements Lock {

    /**
     * {@inheritDoc}
     */
    @Override
    public void lock() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean tryLock() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unlock() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * Queries whether any threads are waiting on the given condition associated with this lock.
     * Note that because timeouts and interrupts may occur at any time, a {@code true} return does
     * not guarantee that a future {@code signal} will awaken any threads. This method is designed
     * primarily for use in monitoring of the system state.
     * 
     * @param condition the condition
     * @return {@code true} if there are any waiting threads
     * @throws IllegalMonitorStateException if this lock is not held
     * @throws IllegalArgumentException if the given condition is not associated with this lock
     * @throws NullPointerException if the condition is null
     */
    public boolean hasWaiters(Condition condition) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
