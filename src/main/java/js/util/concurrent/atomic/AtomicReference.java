/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import java.util.function.UnaryOperator;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/30 13:06:00
 */
@JavaAPIProvider(java.util.concurrent.atomic.AtomicReference.class)
class AtomicReference<V> {

    /** The value holder. */
    private volatile V value;

    /**
     * Creates a new AtomicReference with null initial value.
     */
    public AtomicReference() {
    }

    /**
     * Creates a new AtomicReference with the given initial value.
     * 
     * @param initialValue the initial value
     */
    public AtomicReference(V initialValue) {
        value = initialValue;
    }

    /**
     * Gets the current value.
     * 
     * @return the current value
     */
    public final V get() {
        return value;
    }

    /**
     * Sets to the given value.
     * 
     * @param newValue the new value
     */
    public final void set(V newValue) {
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
    public final boolean compareAndSet(V expect, V update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * Atomically updates the current value with the results of applying the given function,
     * returning the updated value. The function should be side-effect-free, since it may be
     * re-applied when attempted updates fail due to contention among threads.
     *
     * @param updateFunction a side-effect-free function
     * @return the updated value
     * @since 1.8
     */
    public final V updateAndGet(UnaryOperator<V> updateFunction) {
        V value = updateFunction.apply(get());
        set(value);
        return value;
    }

    /**
     * Atomically sets to the given value and returns the old value.
     * 
     * @param newValue the new value
     * @return the previous value
     */
    public final V getAndSet(V newValue) {
        V old = value;

        value = newValue;

        return old;
    }
}
