/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2015/02/13 16:10:25
 */
public enum BootonProfile {
    Others, ParseCode, Loading, Compile, BuildApplication, BuildLiveCoding, WriteHTML, WriteJS, WriteCSS, Construct, Annotation, ServerLaunch;

    private static final Path JDK = Paths.get("rt.jar");

    /** The configuration. */
    private static final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The context manager. */
    private static final Deque<Context> contexts = new ArrayDeque();

    /**
     * <p>
     * Start new phase.
     * </p>
     */
    public void start(Runnable execution) {
        start(Booton.class);
        execution.run();
        end();
    }

    /**
     * <p>
     * Start new phase.
     * </p>
     */
    public void start(Class source) {
        if (config.profile) {
            Context latest = contexts.peekLast();

            if (latest != null) {
                latest.stop();
            }

            contexts.addLast(latest = Context.get(this, source));
            latest.start();
        }
    }

    /**
     * <p>
     * End current phase.
     * </p>
     */
    public void end() {
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
    public static void show() {
        if (config.profile) {
            if (!Context.from.isEmpty()) {
                List<Context> list = new ArrayList(Context.from.values());
                Collections.sort(list, Comparator.<Context> comparingDouble(item -> item.elapsed).reversed());

                double total = 0;

                for (Context context : list) {
                    total += context.elapsed;
                }

                System.out.format("Total Profiled Time: %5.0fms%n", total);

                for (Context context : list) {
                    if (context.elapsed != 0) {
                        System.out.format("%-15s\t%5dms\t%2.0f%%\t%s(%d)%n", context.title, context.elapsed, context.elapsed / total * 100, context.path, context.classes.size());
                    }
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

        private final BootonProfile title;

        private long start;

        private long elapsed;

        private Set<Class> classes = new HashSet();

        /**
         * @param target
         */
        private Context(Path path, BootonProfile title) {
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
            elapsed += System.currentTimeMillis() - start;
        }

        /**
         * 
         */
        private void start() {
            start = System.currentTimeMillis();
        }

        private static Context get(BootonProfile title, Class target) {
            Path path = target == null ? JDK : ClassUtil.getArchive(target);

            Context context = from.get(path + title.toString());

            if (context == null) {
                context = new Context(path, title);
                from.put(path + title.toString(), context);
            }
            context.classes.add(target);

            return context;
        }
    }
}
