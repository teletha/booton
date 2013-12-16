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

/**
 * @version 2013/12/16 10:56:00
 */
public class Unsupported {

    /**
     * <p>
     * {@link Thread#sleep(long)} is not supported in javascript runtime environment. Use this
     * method in test.
     * </p>
     * 
     * @param time
     */
    public static void async(long time, Runnable action) {
        try {
            Thread.sleep(time);

            action.run();
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }
}
