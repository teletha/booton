/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import kiss.I;
import kiss.model.ClassUtil;

/**
 * @version 2015/01/07 12:13:34
 */
public final class BuildProcessProfiler {

    /** The time format. */
    private static final NumberFormat formatter = NumberFormat.getNumberInstance();

    private static final Path JDK = Paths.get("rt.jar");

    static {
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
    }

    /** The configuration. */
    private static final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The phase container. */
    private static final Deque<Phase> phases = new ArrayDeque();

    /**
     * <p>
     * Start new phase.
     * </p>
     * 
     * @param title A title of new phase.
     */
    public static void start(String title) {
        if (config.profile) {
            finish();

            phases.addLast(new Phase(title));
        }
    }

    /**
     * @param source
     */
    public static void compileStart(Class source) {
        phases.peekLast().compileStart(source);
    }

    /**
     * @param source
     */
    public static void compileEnd() {
        phases.peekLast().compileEnd();
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    public static void showResult() {
        if (config.profile) {
            finish();

            if (!phases.isEmpty()) {
                double total = 0;

                for (Phase phase : phases) {
                    total += phase.time;
                }

                for (Phase phase : phases) {
                    System.out.println(phase.title + ": " + phase.time() + " (" + formatter.format((phase.time / total) * 100) + "%)");

                    for (Group group : phase.compiles.values()) {
                        System.out.println("\t" + group.path + ": " + group.time() + " (" + group.count + " sources)");
                    }
                }
            }
        }
    }

    /**
     * <p>
     * End the current processing phase.
     * </p>
     */
    private static void finish() {
        long now = System.nanoTime();

        Phase latest = phases.peekLast();

        if (latest != null) {
            latest.time = now - latest.time;
        }
    }

    /**
     * @version 2015/01/07 12:17:42
     */
    private static class Phase {

        private final String title;

        /** The process time. */
        private double time;

        /** The latest compiled owner. */
        private Path latest;

        /** The compiling group. */
        private Map<Path, Group> compiles = new HashMap();

        /**
         * @param title
         */
        private Phase(String title) {
            this.title = title;
            this.time = System.nanoTime();
        }

        /**
         * @param source
         */
        private void compileStart(Class source) {
            latest = ClassUtil.getArchive(source);

            if (latest == null) {
                latest = JDK;
            }

            Group group = compiles.computeIfAbsent(latest, s -> new Group(s));
            group.count++;
            group.time = System.nanoTime();
        }

        /**
         * @param source
         */
        private void compileEnd() {
            Group group = compiles.get(latest);
            group.time = System.nanoTime() - group.time;
        }

        /**
         * <p>
         * Print processing time as text.
         * </p>
         * 
         * @return
         */
        private String time() {
            return formatter.format(time / 1000000) + "ms";
        }
    }

    /**
     * @version 2015/01/07 14:01:04
     */
    private static class Group {

        /** The source path. */
        private Path path;

        /** The compiling process time. */
        private double time;

        /** The compiled source size. */
        private int count;

        /**
         * @param s
         */
        private Group(Path path) {
            this.path = path;
        }

        /**
         * <p>
         * Print processing time as text.
         * </p>
         * 
         * @return
         */
        private String time() {
            return formatter.format(time / 1000000) + "ms";
        }
    }
}
