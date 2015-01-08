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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private static Deque<Context> contexts = new ArrayDeque();

    /**
     * <p>
     * Start new phase.
     * </p>
     * 
     * @param title A title of new phase.
     */
    public static void start(String title, Class target) {
        if (config.profile) {
            Context latest = contexts.peekLast();

            if (latest != null) {
                latest.stop();
            }

            latest = Context.get(title, target);
            contexts.addLast(latest);
            latest.start();
        }
    }

    /**
     * <p>
     * Start new phase.
     * </p>
     * 
     * @param title A title of new phase.
     */
    public static void end(String title, Class target) {
        if (config.profile) {
            Context latest = contexts.pollLast();
            latest.stop();

            latest = contexts.peekLast();

            if (latest != null) {
                latest.start();
            }
        }
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    public static void showResult() {
        if (config.profile) {
            if (!Context.from.isEmpty()) {
                List<Context> list = new ArrayList(Context.from.values());
                Collections.sort(list, Comparator.<Context> comparingDouble(item -> item.elapsed).reversed());

                double total = 0;

                for (Context context : list) {
                    total += context.elapsed;
                }

                for (Context context : list) {
                    System.out.println(context + "   " + formatter.format(context.elapsed / total * 100) + "%");
                }
            }
        }
    }

    /**
     * @version 2015/01/08 15:06:53
     */
    private static class Context {

        private static final Map<String, Context> from = new HashMap();

        private final Path path;

        private final String title;

        private long start;

        private double elapsed;

        private Set<Class> classes = new HashSet();

        /**
         * @param target
         */
        private Context(Path path, String title) {
            if (path == null) {
                path = JDK;
            }
            this.path = path;
            this.title = title;
        }

        /**
         * 
         */
        private void stop() {
            elapsed += (System.nanoTime() - start) / 1000000;
        }

        /**
         * 
         */
        private void start() {
            start = System.nanoTime();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return title + "  " + path + ": " + formatter.format(elapsed) + "ms (" + classes.size() + ")";
        }

        private static Context get(String title, Class target) {
            Path path = ClassUtil.getArchive(target);

            Context context = from.get(path + title);

            if (context == null) {
                context = new Context(path, title);
                from.put(path + title, context);
            }
            context.classes.add(target);

            return context;
        }
    }
}
