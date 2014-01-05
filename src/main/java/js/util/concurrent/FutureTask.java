/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/06 0:04:38
 */
@JavaAPIProvider(java.util.concurrent.FutureTask.class)
public class FutureTask<V> implements RunnableFuture<V> {

    /** The actual task. */
    private final Callable<V> callable;

    /**
     * Creates a {@code FutureTask} that will, upon running, execute the given {@code Callable}.
     * 
     * @param callable the callable task
     * @throws NullPointerException if the callable is null
     */
    public FutureTask(Callable<V> callable) {
        if (callable == null) throw new NullPointerException();
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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCancelled() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDone() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get() throws InterruptedException, ExecutionException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
    }

}
