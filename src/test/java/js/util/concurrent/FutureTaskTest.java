/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.concurrent.Callable;
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
    public void get() throws Exception {
        FutureTask<String> task = new CompletedTask(() -> {
            return "Renchon";
        });
        assert task.get().equals("Renchon");
    }

    /**
     * @version 2014/01/06 15:30:23
     */
    private static class CompletedTask extends FutureTask<String> {

        /**
         * @param callable
         * @throws Exception
         */
        protected CompletedTask(Callable<String> callable) throws Exception {
            super(callable);

            set(callable.call());
        }

        /**
         * @param runnable
         * @param result
         */
        protected CompletedTask(Runnable runnable, String result) {
            super(runnable, result);

            set(result);
        }
    }
}
