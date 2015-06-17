/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/30 13:20:00
 */
@JavaAPIProvider(java.util.concurrent.atomic.AtomicBoolean.class)
class AtomicBoolean {

    /** The value holder. */
    private volatile boolean value;

    /**
     * Creates a new {@code AtomicBoolean} with initial value {@code false}.
     */
    public AtomicBoolean() {
    }

    /**
     * Creates a new {@code AtomicBoolean} with the given initial value.
     * 
     * @param initialValue the initial value
     */
    public AtomicBoolean(boolean initialValue) {
        value = initialValue;
    }

    /**
     * Returns the current value.
     * 
     * @return the current value
     */
    public final boolean get() {
        return value;
    }

    /**
     * Unconditionally sets to the given value.
     * 
     * @param newValue the new value
     */
    public final void set(boolean newValue) {
        value = newValue;
    }

    /**
     * Atomically sets the value to the given updated value if the current value {@code ==} the
     * expected value.
     * 
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that the actual value was not
     *         equal to the expected value.
     */
    public final boolean compareAndSet(boolean expect, boolean update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * Atomically sets the value to the given updated value if the current value {@code ==} the
     * expected value.
     * <p>
     * <a href="package-summary.html#weakCompareAndSet">May fail spuriously and does not provide
     * ordering guarantees</a>, so is only rarely an appropriate alternative to
     * {@code compareAndSet}.
     * 
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful
     */
    public final boolean weakCompareAndSet(boolean expect, boolean update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * Eventually sets to the given value.
     * 
     * @param newValue the new value
     * @since 1.6
     */
    public final void lazySet(boolean newValue) {
        value = newValue;
    }

    /**
     * Atomically sets to the given value and returns the previous value.
     * 
     * @param newValue the new value
     * @return the previous value
     */
    public final boolean getAndSet(boolean newValue) {
        boolean prev;
        do {
            prev = get();
        } while (!compareAndSet(prev, newValue));
        return prev;
    }

}
