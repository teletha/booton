/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2014/09/05 15:15:25
 */
public class Updater {

    /** The operation list. */
    private static List<Runnable> operations = new ArrayList();

    public static void update(VirtualNode node) {
        // requestAnimationFrame
        Runnable callback = () -> {

        };
    }

    /**
     * <p>
     * Actual callback function.
     * </p>
     */
    private static void update() {
        if (operations.size() != 0) {
            // swap tasks
            List<Runnable> tasks = operations;
            operations = new ArrayList();

            for (Runnable task : tasks) {
                task.run();
            }
        }
    }
}
