/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.lang.NativeArray;
import js.lang.builtin.Console;

/**
 * @version 2015/02/06 9:21:47
 */
public class WidgetLog {

    /** The records. */
    private static final NativeArray<Measurement> measurements = new NativeArray();

    /** The current record. */
    private static Measurement current;

    /**
     * <p>
     * Measure process time.
     * </p>
     * 
     * @param title
     */
    public static void start(String title) {
        measurements.push(current = new Measurement(title));

        current.time = System.currentTimeMillis();
    }

    /**
     * <p>
     * Stop measurement.
     * </p>
     */
    public static void end() {
        current.time = System.currentTimeMillis() - current.time;
    }

    public static void show() {
        Console.table(measurements.copy());

        measurements.clear();
    }

    /**
     * @version 2015/02/06 9:25:15
     */
    private static class Measurement {

        /** The name. */
        private final String name;

        /** The process time. */
        private double time;

        /**
         * @param name
         */
        private Measurement(String name) {
            this.name = name;
        }
    }
}
