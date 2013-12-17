/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.util;

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2013/12/16 10:56:00
 */
public class Asynchronous {

    /** The class name. */
    public static final String name = Asynchronous.class.getSimpleName();

    /**
     * <p>
     * {@link Thread#sleep(long)} is not supported in javascript runtime environment. Use this
     * method in test.
     * </p>
     * 
     * @param time
     */
    public static void await(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/12/17 12:55:09
     */
    private static class Coder extends Translator<Asynchronous> {

        /**
         * <p>
         * {@link Thread#sleep(long)} is not supported in javascript runtime environment. Use this
         * method in test.
         * </p>
         * 
         * @param time
         */
        public String await(long time) {
            return name + ".await(" + param(0) + ")";
        }
    }
}
