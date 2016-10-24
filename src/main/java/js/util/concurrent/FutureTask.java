/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import booton.translator.JavaAPIProvider;
import kiss.I;

/**
 * @version 2014/01/06 14:52:28
 */
@JavaAPIProvider(java.util.concurrent.FutureTask.class)
class FutureTask<V> implements RunnableFuture<V> {

    /** The actual task. */
    private final Callable<V> callable;

    /** State */
    private boolean cancel;

    /** State */
    private boolean done;

    /** The actual task id. */
    private int id = -1;

    /** The task result. */
    private V result;

    /**
     * Creates a {@code FutureTask} that will, upon running, execute the given {@code Callable}.
     * 
     * @param callable the callable task
     * @throws NullPointerException if the callable is null
     */
    public FutureTask(Callable<V> callable) {
        Objects.nonNull(callable);

        this.callable = callable;
    }

    /**
     * Creates a {@code FutureTask} that will, upon running, execute the given {@code Runnable}, and
     * arrange that {@code get} will return the given result on successful completion.
     * 
     * @param runnable the runnable task
     * @param result the result to return on successful completion. If you don't need a particular
     *            result, consider using constructions of the form:
     *            {@code Future<?> f = new FutureTask<Void>(runnable, null)}
     * @throws NullPointerException if the runnable is null
     */
    public FutureTask(Runnable runnable, V result) {
        this.callable = Executors.callable(runnable, result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (done) {
            return false;
        }

        done();

        return cancel = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDone() {
        return done;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get() throws InterruptedException, ExecutionException {
        run();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        run();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        if (cancel) {
            throw new CancellationException();
        }

        if (!done) {
            try {
                result = callable.call();

                done = true;
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

    }

    /**
     * Protected method invoked when this task transitions to state {@code isDone} (whether normally
     * or via cancellation). The default implementation does nothing. Subclasses may override this
     * method to invoke completion callbacks or perform bookkeeping. Note that you can query status
     * inside the implementation of this method to determine whether this task has been cancelled.
     */
    protected void done() {
        done = true;
    }

    /**
     * Sets the result of this future to the given value unless this future has already been set or
     * has been cancelled.
     * <p>
     * This method is invoked internally by the {@link #run} method upon successful completion of
     * the computation.
     * 
     * @param value the value
     */
    protected void set(V value) {
        result = value;

        done();
    }

    /**
     * Causes this future to report an {@link ExecutionException} with the given throwable as its
     * cause, unless this future has already been set or has been cancelled.
     * <p>
     * This method is invoked internally by the {@link #run} method upon failure of the computation.
     * 
     * @param t the cause of failure
     */
    protected void setException(Throwable t) {
        throw new UnsupportedOperationException();
    }

    /**
     * Executes the computation without setting its result, and then resets this future to initial
     * state, failing to do so if the computation encounters an exception or is cancelled. This is
     * designed for use with tasks that intrinsically execute more than once.
     * 
     * @return {@code true} if successfully run and reset
     */
    protected boolean runAndReset() {
        throw new UnsupportedOperationException();
    }
}
