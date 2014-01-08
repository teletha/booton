/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2014/01/05 15:54:01
 */
public class Async {

    /** The class name. */
    public static final String name = Async.class.getSimpleName();

    /**
     * <p>
     * Wait script execution.
     * </p>
     * 
     * @param millseconds
     */
    public static void wait(int millseconds) {
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(millseconds);
            long end = System.currentTimeMillis();

            if (end - start < millseconds) {
                Async.wait((int) (millseconds - end + start));
            }
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Await all background job's execution.
     * </p>
     * 
     * @param timeout
     */
    public static void awaitTasks() {
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);

        try {
            for (Thread thread : threads) {
                String name = thread.getName();

                if (name.startsWith("pool-")) {
                    thread.join(100);
                }
            }
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/12/17 12:55:09
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Async> {

        /**
         * <p>
         * Wait script execution.
         * </p>
         * 
         * @param millseconds
         */
        public String wait(int millseconds) {
            return name + ".wait(" + param(0) + ")";
        }

        /**
         * <p>
         * Await all background job's execution.
         * </p>
         * 
         * @param timeout
         */
        public String awaitTasks() {
            return name + ".awaitTasks()";
        }
    }
}
