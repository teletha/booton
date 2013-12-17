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

import js.lang.Global;
import kiss.I;
import booton.translator.Translator;

/**
 * @version 2013/12/16 10:56:00
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
            Thread.sleep(millseconds);
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
        try {
            Class clazz = Class.forName(Global.class.getName() + "$TaskScheduler");
            Runnable tasks = I.make(clazz);
            tasks.run();
        } catch (Exception e) {
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
