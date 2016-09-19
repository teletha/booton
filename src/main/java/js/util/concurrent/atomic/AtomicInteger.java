/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 0:44:28
 */
@JavaAPIProvider(java.util.concurrent.atomic.AtomicInteger.class)
class AtomicInteger extends Number {

    /** The value holder. */
    private volatile int value;

    /**
     * Creates a new AtomicInteger with initial value {@code 0}.
     */
    public AtomicInteger() {
    }

    /**
     * Creates a new AtomicInteger with the given initial value.
     * 
     * @param initialValue the initial value
     */
    public AtomicInteger(int initialValue) {
        value = initialValue;
    }

    /**
     * Gets the current value.
     * 
     * @return the current value
     */
    public final int get() {
        return value;
    }

    /**
     * Sets to the given value.
     * 
     * @param newValue the new value
     */
    public final void set(int newValue) {
        value = newValue;
    }

    /**
     * Eventually sets to the given value.
     * 
     * @param newValue the new value
     * @since 1.6
     */
    public final void lazySet(int newValue) {
        value = newValue;
    }

    /**
     * Atomically sets to the given value and returns the old value.
     * 
     * @param newValue the new value
     * @return the previous value
     */
    public final int getAndSet(int newValue) {
        int old = value;
        value = newValue;
        return old;
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
    public final boolean compareAndSet(int expect, int update) {
        if (expect == value) {
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
    public final boolean weakCompareAndSet(int expect, int update) {
        if (expect == value) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * Atomically increments by one the current value.
     * 
     * @return the previous value
     */
    public final int getAndIncrement() {
        return value++;
    }

    /**
     * Atomically decrements by one the current value.
     * 
     * @return the previous value
     */
    public final int getAndDecrement() {
        return value--;
    }

    /**
     * Atomically adds the given value to the current value.
     * 
     * @param delta the value to add
     * @return the previous value
     */
    public final int getAndAdd(int delta) {
        int old = value;
        value += delta;
        return old;
    }

    /**
     * Atomically increments by one the current value.
     * 
     * @return the updated value
     */
    public final int incrementAndGet() {
        return ++value;
    }

    /**
     * Atomically decrements by one the current value.
     * 
     * @return the updated value
     */
    public final int decrementAndGet() {
        return --value;
    }

    /**
     * Atomically adds the given value to the current value.
     * 
     * @param delta the value to add
     * @return the updated value
     */
    public final int addAndGet(int delta) {
        value += delta;
        return value;
    }

    /**
     * Atomically updates the current value with the results of applying the given function,
     * returning the previous value. The function should be side-effect-free, since it may be
     * re-applied when attempted updates fail due to contention among threads.
     * 
     * @param updateFunction a side-effect-free function
     * @return the previous value
     * @since 1.8
     */
    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));
        return prev;
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
    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));
        return next;
    }

    /**
     * Atomically updates the current value with the results of applying the given function to the
     * current and given values, returning the previous value. The function should be
     * side-effect-free, since it may be re-applied when attempted updates fail due to contention
     * among threads. The function is applied with the current value as its first argument, and the
     * given update as the second argument.
     * 
     * @param x the update value
     * @param accumulatorFunction a side-effect-free function of two arguments
     * @return the previous value
     * @since 1.8
     */
    public final int getAndAccumulate(int x, IntBinaryOperator accumulatorFunction) {
        int prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));
        return prev;
    }

    /**
     * Atomically updates the current value with the results of applying the given function to the
     * current and given values, returning the updated value. The function should be
     * side-effect-free, since it may be re-applied when attempted updates fail due to contention
     * among threads. The function is applied with the current value as its first argument, and the
     * given update as the second argument.
     * 
     * @param x the update value
     * @param accumulatorFunction a side-effect-free function of two arguments
     * @return the updated value
     * @since 1.8
     */
    public final int accumulateAndGet(int x, IntBinaryOperator accumulatorFunction) {
        int prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));
        return next;
    }

    /**
     * Returns the String representation of the current value.
     * 
     * @return the String representation of the current value
     */
    public String toString() {
        return Integer.toString(get());
    }

    /**
     * Returns the value of this {@code AtomicInteger} as an {@code int}.
     */
    public int intValue() {
        return value;
    }

    /**
     * Returns the value of this {@code AtomicInteger} as a {@code long} after a widening primitive
     * conversion.
     * 
     * @jls 5.1.2 Widening Primitive Conversions
     */
    public long longValue() {
        return (long) value;
    }

    /**
     * Returns the value of this {@code AtomicInteger} as a {@code float} after a widening primitive
     * conversion.
     * 
     * @jls 5.1.2 Widening Primitive Conversions
     */
    public float floatValue() {
        return (float) value;
    }

    /**
     * Returns the value of this {@code AtomicInteger} as a {@code double} after a widening
     * primitive conversion.
     * 
     * @jls 5.1.2 Widening Primitive Conversions
     */
    public double doubleValue() {
        return (double) value;
    }
}
