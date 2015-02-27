/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.debug;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import js.lang.NativeArray;
import kiss.Interceptor;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2015/02/22 15:22:02
 */
class Profiler extends Interceptor<Profilable> {

    private static final Map<MethodHandle, Profile> phases = new HashMap();

    private static final Map<Profile, Measurement> measurements = new HashMap();

    /** The context manager. */
    private static final NativeArray<Measurement> stack = new NativeArray();

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        Profile phase = phases.computeIfAbsent(method, m -> () -> that.getClass().getSimpleName() + "#" + name);

        start(phase);
        Object value = super.invoke(params);
        end(phase);

        return value;
    }

    /**
     * <p>
     * Start profiling with the specified phase.
     * </p>
     * 
     * @param phase A profiling phase to start.
     */
    static final void start(Profile phase) {
        Measurement latest = stack.last();

        if (latest != null) {
            latest.stop();
        }

        Measurement measurement = measurements.get(phase);

        if (measurement == null) {
            measurement = new Measurement(phase);
            measurements.put(phase, measurement);
        }

        stack.push(latest = measurement);
        latest.start2();
        latest.count++;
    }

    /**
     * <p>
     * End profiling with the specified phase.
     * </p>
     * 
     * @param phase A profiling phase to end.
     */
    static final void end(Profile phase) {
        Measurement latest = stack.length() == 1 ? stack.get(0) : stack.pop();
        latest.stop();

        latest = stack.get(stack.length() - 1);

        if (latest != null) {
            latest.start2();
        }
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    static void show() {
        List<Measurement> list = new ArrayList(measurements.values());
        Collections.sort(list, Comparator.<Measurement> comparingDouble(item -> item.elapsed).reversed());

        double total = 0;

        for (Measurement context : list) {
            total += context.elapsed;
        }

        Measurement root = stack.get(0);

        System.out.println("Total Time: " + (root.end - root.start) + "ms");
        System.out.println("Total Profiled Time: " + total + "ms");

        for (Measurement context : list) {
            if (context.elapsed != 0) {
                System.out.println(context.phase.name() + " " + context.elapsed + "ms    " + context.elapsed / total * 100 + "%  " + context.count + "calls");
            }
        }

        // clean up
        measurements.clear();
        stack.clear();
    }

    /**
     * @version 2015/02/22 15:36:52
     */
    private static class Measurement implements JavascriptNative {

        /** The associated phase. */
        private final Profile phase;

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
         * @param phase
         */
        private Measurement(Profile phase) {
            this.phase = phase;
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
         * 
         */
        private void stop() {
            end = System.currentTimeMillis();
            elapsed += end - latest;
        }
    }
}
