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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import js.lang.NativeArray;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2015/02/06 9:21:47
 */
public enum WidgetLog implements JavascriptNative {
    Others, Virtualize, Hierarchy, New, Diff, Container, Process, SubWidget, Make, VirtualizeWidgetCollection;

    /** The context manager. */
    private static final NativeArray<WidgetLog> contexts = new NativeArray();

    /** The latest recorded time. */
    private long latest;

    /** The elapsed time of the specified phase. */
    @JavascriptNativeProperty
    private long elapsed;

    /** The start time of the specified phase. */
    private long start;

    /** The end time of the specified phase. */
    private long end;

    private int count;

    /**
     * <p>
     * Start new phase.
     * </p>
     */
    public void start(Runnable execution) {
        start();
        execution.run();
        end();
    }

    /**
     * <p>
     * Start new phase.
     * </p>
     */
    public void start() {
        WidgetLog latest = contexts.get(contexts.length() - 1);

        if (latest != null) {
            latest.stop();
        }

        contexts.push(latest = this);
        latest.start2();
        latest.count++;
    }

    /**
     * <p>
     * End current phase.
     * </p>
     */
    public void end() {
        WidgetLog latest = contexts.pop();
        latest.stop();

        latest = contexts.get(contexts.length() - 1);

        if (latest != null) {
            latest.start2();
        }
    }

    /**
     * 
     */
    private void stop() {
        end = System.currentTimeMillis();
        elapsed += end - latest;
    }

    /**
     * 
     */
    private void start2() {
        long now = System.currentTimeMillis();

        if (start == 0) {
            start = now;
        }
        latest = now;
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    public static void show() {
        List<WidgetLog> list = Arrays.asList(WidgetLog.values());
        Collections.sort(list, Comparator.<WidgetLog> comparingDouble(item -> item.elapsed).reversed());

        double total = 0;

        for (WidgetLog context : list) {
            total += context.elapsed;
        }

        WidgetLog root = Others;

        System.out.println("Total Time: " + (root.end - root.start) + "ms");
        System.out.println("Total Profiled Time: " + total + "ms");

        for (WidgetLog context : list) {
            if (context.elapsed != 0) {
                System.out.println(context.name() + " " + context.elapsed + "ms    " + context.elapsed / total * 100 + "%  " + context.count + "calls");
            }
            context.reset();
        }
    }

    /**
     * 
     */
    private void reset() {
        latest = elapsed = start = elapsed = count = 0;
    }
}
