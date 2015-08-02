/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package antibug.profiler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import booton.BootonProfile;
import kiss.I;

/**
 * @version 2015/08/01 17:37:50
 */
public final class Profile {

    /** The configuration for profiler execution. */
    public static boolean execute = true;

    /** The resusable nop-profiler. */
    private static final AutoCloseable NOP = () -> {
    };

    /** Java Runtime. */
    private static final Path JRE;

    /** The profiling manager. */
    private static final ConcurrentHashMap<String, Profiling> profilings = new ConcurrentHashMap();

    /** The latest profiling. */
    private static Profiling latest = new Profiling("ROOT", null);

    // initialization
    static {
        Path java = null;

        // Search Java SDK from path. Don't use java.home system property to avoid JRE.
        root: for (Entry<String, String> entry : System.getenv().entrySet()) {
            // On UNIX systems the alphabetic case of name is typically significant, while on
            // Microsoft Windows systems it is typically not.
            if (entry.getKey().equalsIgnoreCase("path")) {
                // Search classpath for Bee.
                for (String value : entry.getValue().split(File.pathSeparator)) {
                    Path directory = I.locate(value);
                    Path linux = directory.resolve("javac");
                    Path windows = directory.resolve("javac.exe");

                    if (Files.exists(linux)) {
                        java = linux;

                        break root;
                    } else if (Files.exists(windows)) {
                        java = windows;

                        break root;
                    }
                }
            }
        }

        if (java == null) {
            throw new Error("Java SDK is not found in your environment path.");
        }

        JRE = java.getParent().getParent().resolve("jre/lib/rt.jar");

        if (Files.notExists(JRE)) {
            throw new Error("Java Runtime Environment is not found in your environment. path");
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (execute) {
                // display profiling result
                BootonProfile.show();
                System.out.println("");
                show();
            }
        }));
    }

    /**
     * <p>
     * Hide Constructor.
     * </p>
     */
    private Profile() {
    }

    /**
     * <p>
     * Create of retrieve the named phase profiler.
     * </p>
     * 
     * @param phase A name of this phase.
     * @return A profiler.
     */
    public static AutoCloseable of(String phase) {
        return of(phase, null);
    }

    /**
     * <p>
     * Create of retrieve the named phase profiler.
     * </p>
     * 
     * @param phase A name of this phase.
     * @return A profiler.
     */
    public static AutoCloseable of(String phase, Object group) {
        if (execute == false) {
            return NOP;
        }

        latest.stop();

        String key = String.valueOf(phase).concat("@").concat(String.valueOf(group));
        Profiling now = profilings.computeIfAbsent(key, name -> new Profiling(phase, group));
        now.previous = latest;
        now.start();

        return latest = now;
    }

    /**
     * <p>
     * Create of retrieve the named phase profiler.
     * </p>
     * 
     * @param phase A name of this phase.
     * @return A profiler.
     */
    public static void of(String phase, Object group, ProfilingProcess operation) {
        if (execute == false) {
            try {
                operation.run();
            } catch (Throwable e) {
                throw I.quiet(e);
            }
            return;
        }

        latest.stop();

        String key = String.valueOf(phase).concat("@").concat(String.valueOf(group));
        Profiling now = profilings.computeIfAbsent(key, name -> new Profiling(phase, group));
        now.previous = latest;
        now.start();

        try {
            operation.run();
        } catch (Throwable e) {
            throw I.quiet(e);
        }

        now.stop();
        now.previous.start();
        latest = now.previous;
    }

    public static void show() {
        if (execute) {
            List<Profiling> list = new ArrayList(profilings.values());
            Collections.sort(list, Comparator.<Profiling> comparingDouble(item -> item.elapsed).reversed());

            double total = 0;

            for (Profiling profiling : list) {
                total += profiling.elapsed;
            }

            System.out.format("Total Profiled Time: %5.0fms%n", total);

            for (int i = 0, size = Math.min(100000, list.size()); i < size; i++) {
                Profiling context = list.get(i);

                if (context.elapsed != 0) {
                    System.out
                            .format("%-15s\t%6dms\t%2.0f%%\t%6d\t%s(%d)%n", context.name, context.elapsed, context.elapsed / total * 100, context.count, context.group, 10);
                }
            }
        }
    }

    /**
     * @version 2015/08/01 22:52:10
     */
    public static interface ProfilingProcess {

        public void run() throws Throwable;
    }

    /**
     * @version 2015/08/01 17:44:39
     */
    private static class Profiling implements AutoCloseable {

        /** The group name. */
        private final String name;

        /** The group key. */
        private final Object group;

        /** The previous profiling. */
        private Profiling previous;

        /** The latest recorded time. */
        private long latest;

        /** The elapsed time of the specified phase. */
        private long elapsed;

        /** The start time of the specified phase. */
        private long start;

        /** The end time of the specified phase. */
        private long end;

        /** The call count. */
        private long count;

        /**
         * @param name
         * @param group
         */
        private Profiling(String name, Object group) {
            this.name = name;
            this.group = group;
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
        private void start() {
            count++;
            long now = System.currentTimeMillis();

            if (start == 0) {
                start = now;
            }
            latest = now;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void close() throws Exception {
            stop();
            previous.start();

            Profile.latest = previous;
        }
    }
}
