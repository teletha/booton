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

import static java.util.concurrent.TimeUnit.*;

import java.util.concurrent.CancellationException;
import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/01/06 14:47:07
 */
@RunWith(ScriptRunner.class)
public class FutureTaskTest {

    @Test
    public void task() throws Exception {
        Task<String> task = new Task("Renchon");

        assert task.isDone() == false;
        assert task.isCancelled() == false;

        task.complete();
        assert task.isDone() == true;
        assert task.isCancelled() == false;
        assert task.get().equals("Renchon");
    }

    @Test(expected = CancellationException.class)
    public void cancel() throws Exception {
        Task<String> task = new Task("Renchon");

        assert task.isDone() == false;
        assert task.isCancelled() == false;

        assert task.cancel(true);
        assert task.isDone() == true;
        assert task.isCancelled() == true;

        assert !task.cancel(false);

        // cancelled task will throw exception immediately
        task.get();
    }

    @Test
    public void run() throws Exception {
        Task<String> task = new Task("Renchon");

        assert task.isDone() == false;
        assert task.isCancelled() == false;

        task.run();

        assert task.isDone() == true;
        assert task.isCancelled() == false;
        assert task.get(0, MILLISECONDS).equals("Renchon");
    }

    /**
     * @version 2014/01/06 15:30:23
     */
    private static class Task<V> extends FutureTask<V> {

        private V value;

        /**
         * @param callable
         * @throws Exception
         */
        protected Task(V value) throws Exception {
            super(() -> {
                return value;
            });

            this.value = value;
        }

        /**
         * Helper to complete task.
         */
        protected final void complete() {
            set(value);
        }
    }
}
