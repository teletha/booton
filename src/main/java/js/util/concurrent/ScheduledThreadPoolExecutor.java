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

import static js.lang.Global.*;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/05 23:04:19
 */
@JavaAPIProvider(java.util.concurrent.ScheduledThreadPoolExecutor.class)
public class ScheduledThreadPoolExecutor implements ScheduledExecutorService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void shutdown() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isShutdown() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTerminated() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Runnable command) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return schedule((Callable) () -> {
            command.run();

            return null;
        }, delay, unit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return new ScheduledFutureTask(callable, unit.toMillis(delay));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return null;
    }

    /**
     * @version 2014/01/05 23:15:01
     */
    private static class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {

        private long id;

        /**
         * @param callable
         */
        private ScheduledFutureTask(Callable<V> callable, long delay) {
            super(callable);

            id = setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            clearTimeout(id);

            return super.cancel(mayInterruptIfRunning);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isPeriodic() {
            return false;
        }
    }
}