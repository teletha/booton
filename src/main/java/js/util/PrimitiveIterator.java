/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/07 1:55:37
 */
@JavaAPIProvider(java.util.PrimitiveIterator.class)
public interface PrimitiveIterator<T, T_CONS> extends Iterator<T> {

    /**
     * Performs the given action for each remaining element, in the order elements occur when
     * iterating, until all elements have been processed or the action throws an exception. Errors
     * or runtime exceptions thrown by the action are relayed to the caller.
     * 
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     */
    void forEachRemaining(T_CONS action);

    /**
     * An Iterator specialized for {@code int} values.
     * 
     * @since 1.8
     */
    @JavaAPIProvider(java.util.PrimitiveIterator.OfInt.class)
    public static interface OfInt extends PrimitiveIterator<Integer, IntConsumer> {

        /**
         * Returns the next {@code int} element in the iteration.
         * 
         * @return the next {@code int} element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        int nextInt();

        /**
         * Performs the given action for each remaining element, in the order elements occur when
         * iterating, until all elements have been processed or the action throws an exception.
         * Errors or runtime exceptions thrown by the action are relayed to the caller.
         * 
         * @implSpec <p>
         *           The default implementation behaves as if:
         * 
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(nextInt());
         * }</pre>
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         */
        default void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            while (hasNext())
                action.accept(nextInt());
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec The default implementation boxes the result of calling {@link #nextInt()}, and
         *           returns that boxed result.
         */
        @Override
        default Integer next() {
            return nextInt();
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec If the action is an instance of {@code IntConsumer} then it is cast to
         *           {@code IntConsumer} and passed to {@link #forEachRemaining}; otherwise the
         *           action is adapted to an instance of {@code IntConsumer}, by boxing the argument
         *           of {@code IntConsumer}, and then passed to {@link #forEachRemaining}.
         */
        @Override
        default void forEachRemaining(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                forEachRemaining((IntConsumer) action);
            } else {
                // The method reference action::accept is never null
                Objects.requireNonNull(action);
                forEachRemaining((IntConsumer) action::accept);
            }
        }

    }

    /**
     * An Iterator specialized for {@code long} values.
     * 
     * @since 1.8
     */
    @JavaAPIProvider(java.util.PrimitiveIterator.OfLong.class)
    public static interface OfLong extends PrimitiveIterator<Long, LongConsumer> {

        /**
         * Returns the next {@code long} element in the iteration.
         * 
         * @return the next {@code long} element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        long nextLong();

        /**
         * Performs the given action for each remaining element, in the order elements occur when
         * iterating, until all elements have been processed or the action throws an exception.
         * Errors or runtime exceptions thrown by the action are relayed to the caller.
         * 
         * @implSpec <p>
         *           The default implementation behaves as if:
         * 
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(nextLong());
         * }</pre>
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         */
        default void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            while (hasNext())
                action.accept(nextLong());
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec The default implementation boxes the result of calling {@link #nextLong()}, and
         *           returns that boxed result.
         */
        @Override
        default Long next() {
            return nextLong();
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec If the action is an instance of {@code LongConsumer} then it is cast to
         *           {@code LongConsumer} and passed to {@link #forEachRemaining}; otherwise the
         *           action is adapted to an instance of {@code LongConsumer}, by boxing the
         *           argument of {@code LongConsumer}, and then passed to {@link #forEachRemaining}.
         */
        @Override
        default void forEachRemaining(Consumer<? super Long> action) {
            if (action instanceof LongConsumer) {
                forEachRemaining((LongConsumer) action);
            } else {
                // The method reference action::accept is never null
                Objects.requireNonNull(action);
                forEachRemaining((LongConsumer) action::accept);
            }
        }
    }

    /**
     * An Iterator specialized for {@code double} values.
     * 
     * @since 1.8
     */
    @JavaAPIProvider(java.util.PrimitiveIterator.OfDouble.class)
    public static interface OfDouble extends PrimitiveIterator<Double, DoubleConsumer> {

        /**
         * Returns the next {@code double} element in the iteration.
         * 
         * @return the next {@code double} element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        double nextDouble();

        /**
         * Performs the given action for each remaining element, in the order elements occur when
         * iterating, until all elements have been processed or the action throws an exception.
         * Errors or runtime exceptions thrown by the action are relayed to the caller.
         * 
         * @implSpec <p>
         *           The default implementation behaves as if:
         * 
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(nextDouble());
         * }</pre>
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         */
        default void forEachRemaining(DoubleConsumer action) {
            Objects.requireNonNull(action);
            while (hasNext())
                action.accept(nextDouble());
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec The default implementation boxes the result of calling {@link #nextDouble()},
         *           and returns that boxed result.
         */
        @Override
        default Double next() {
            return nextDouble();
        }

        /**
         * {@inheritDoc}
         * 
         * @implSpec If the action is an instance of {@code DoubleConsumer} then it is cast to
         *           {@code DoubleConsumer} and passed to {@link #forEachRemaining}; otherwise the
         *           action is adapted to an instance of {@code DoubleConsumer}, by boxing the
         *           argument of {@code DoubleConsumer}, and then passed to
         *           {@link #forEachRemaining}.
         */
        @Override
        default void forEachRemaining(Consumer<? super Double> action) {
            if (action instanceof DoubleConsumer) {
                forEachRemaining((DoubleConsumer) action);
            } else {
                // The method reference action::accept is never null
                Objects.requireNonNull(action);
                forEachRemaining((DoubleConsumer) action::accept);
            }
        }
    }
}
