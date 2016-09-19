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

import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 1:23:07
 */
@JavaAPIProvider(java.util.concurrent.atomic.AtomicLong.class)
class AtomicLong extends Number {

    /** The value holder. */
    private volatile long value;

    /**
     * <p>
     * Creates a new AtomicLong with initial value {@code 0}.
     * </p>
     */
    public AtomicLong() {
    }

    /**
     * <p>
     * Creates a new AtomicLong with the given initial value.
     * </p>
     * 
     * @param initialValue the initial value
     */
    public AtomicLong(long initialValue) {
        value = initialValue;
    }

    /**
     * <p>
     * Gets the current value.
     * </p>
     * 
     * @return the current value
     */
    public final long get() {
        return value;
    }

    /**
     * <p>
     * Sets to the given value.
     * </p>
     * 
     * @param newValue the new value
     */
    public final void set(long newValue) {
        value = newValue;
    }

    /**
     * <p>
     * Eventually sets to the given value.
     * </p>
     * 
     * @param newValue the new value
     * @since 1.6
     */
    public final void lazySet(long newValue) {
        value = newValue;
    }

    /**
     * <p>
     * Atomically sets to the given value and returns the old value.
     * </p>
     * 
     * @param newValue the new value
     * @return the previous value
     */
    public final long getAndSet(long newValue) {
        long old = value;
        value = newValue;
        return old;
    }

    /**
     * <p>
     * Atomically sets the value to the given updated value if the current value {@code ==} the
     * expected value.
     * </p>
     * 
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that the actual value was not
     *         equal to the expected value.
     */
    public final boolean compareAndSet(long expect, long update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Atomically sets the value to the given updated value if the current value {@code ==} the
     * expected value.
     * </p>
     * <p>
     * <a href="package-summary.html#weakCompareAndSet">May fail spuriously and does not provide
     * ordering guarantees</a>, so is only rarely an appropriate alternative to
     * {@code compareAndSet}.
     * 
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful
     */
    public final boolean weakCompareAndSet(long expect, long update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Atomically increments by one the current value.
     * </p>
     * 
     * @return the previous value
     */
    public final long getAndIncrement() {
        return value++;
    }

    /**
     * <p>
     * Atomically adds the given value to the current value.
     * </p>
     * 
     * @return the previous value
     */
    public final long getAndDecrement() {
        return value--;
    }

    /**
     * <p>
     * Atomically adds the given value to the current value.
     * </p>
     * 
     * @param delta the value to add
     * @return the previous value
     */
    public final long getAndAdd(long delta) {
        long old = value;
        value += delta;
        return old;
    }

    /**
     * <p>
     * Atomically increments by one the current value.
     * </p>
     * 
     * @return the updated value
     */
    public final long incrementAndGet() {
        return ++value;
    }

    /**
     * <p>
     * Atomically decrements by one the current value.
     * </p>
     * 
     * @return the updated value
     */
    public final long decrementAndGet() {
        return --value;
    }

    /**
     * <p>
     * Atomically adds the given value to the current value.
     * </p>
     * 
     * @param delta the value to add
     * @return the updated value
     */
    public final long addAndGet(long delta) {
        value += delta;
        return value;
    }

    /**
     * <p>
     * Atomically updates the current value with the results of applying the given function,
     * returning the previous value. The function should be side-effect-free, since it may be
     * re-applied when attempted updates fail due to contention among threads.
     * </p>
     * 
     * @param updateFunction a side-effect-free function
     * @return the previous value
     * @since 1.8
     */
    public final long getAndUpdate(LongUnaryOperator updateFunction) {
        long prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsLong(prev);
        } while (!compareAndSet(prev, next));
        return prev;
    }

    /**
     * <p>
     * Atomically updates the current value with the results of applying the given function,
     * returning the updated value. The function should be side-effect-free, since it may be
     * re-applied when attempted updates fail due to contention among threads.
     * </p>
     * 
     * @param updateFunction a side-effect-free function
     * @return the updated value
     * @since 1.8
     */
    public final long updateAndGet(LongUnaryOperator updateFunction) {
        long prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsLong(prev);
        } while (!compareAndSet(prev, next));
        return next;
    }

    /**
     * <p>
     * Atomically updates the current value with the results of applying the given function to the
     * current and given values, returning the previous value. The function should be
     * side-effect-free, since it may be re-applied when attempted updates fail due to contention
     * among threads. The function is applied with the current value as its first argument, and the
     * given update as the second argument.
     * </p>
     * 
     * @param x the update value
     * @param accumulatorFunction a side-effect-free function of two arguments
     * @return the previous value
     * @since 1.8
     */
    public final long getAndAccumulate(long x, LongBinaryOperator accumulatorFunction) {
        long prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsLong(prev, x);
        } while (!compareAndSet(prev, next));
        return prev;
    }

    /**
     * <p>
     * Atomically updates the current value with the results of applying the given function to the
     * current and given values, returning the updated value. The function should be
     * side-effect-free, since it may be re-applied when attempted updates fail due to contention
     * among threads. The function is applied with the current value as its first argument, and the
     * given update as the second argument.
     * </p>
     * 
     * @param x the update value
     * @param accumulatorFunction a side-effect-free function of two arguments
     * @return the updated value
     * @since 1.8
     */
    public final long accumulateAndGet(long x, LongBinaryOperator accumulatorFunction) {
        long prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsLong(prev, x);
        } while (!compareAndSet(prev, next));
        return next;
    }

    /**
     * <p>
     * Returns the String representation of the current value.
     * </p>
     * 
     * @return the String representation of the current value
     */
    public String toString() {
        return Long.toString(get());
    }

    /**
     * <p>
     * Returns the value of this {@code AtomicLong} as an {@code int} after a narrowing primitive
     * conversion.
     * </p>
     * 
     * @jls 5.1.3 Narrowing Primitive Conversions
     */
    public int intValue() {
        return (int) value;
    }

    /**
     * <p>
     * Returns the value of this {@code AtomicLong} as a {@code long}.
     * </p>
     */
    public long longValue() {
        return value;
    }

    /**
     * <p>
     * Returns the value of this {@code AtomicLong} as a {@code float} after a widening primitive
     * conversion.
     * </p>
     * 
     * @jls 5.1.2 Widening Primitive Conversions
     */
    public float floatValue() {
        return (float) value;
    }

    /**
     * <p>
     * Returns the value of this {@code AtomicLong} as a {@code double} after a widening primitive
     * conversion.
     * </p>
     * 
     * @jls 5.1.2 Widening Primitive Conversions
     */
    public double doubleValue() {
        return (double) value;
    }
}
