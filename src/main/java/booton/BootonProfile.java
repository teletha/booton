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
    Others, ParseCode, Loading, Compile, BuildApplication, BuildLiveCoding, WriteHTML, WriteJS, WriteCSS, Construct, Annotation, ServerLaunch, RunTest, ParseTest, RunTestMethod, RunTestAsJava, AnalyzeTestResult, AnalyzeTestError, AnalyzeTestError2;

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

                Context root = Context.get(Others, Booton.class);

                System.out.format("Total Time: %5dms%n", root.end - root.start);
                System.out.format("Total Profiled Time: %5.0fms%n", total);

                for (int i = 0, size = Math.min(10, list.size()); i < size; i++) {
                    Context context = list.get(i);

                    if (context.elapsed != 0) {
                        System.out
                                .format("%-15s\t%6dms\t%2.0f%%\t%6d\t%s(%d)%n", context.profile, context.elapsed, context.elapsed / total * 100, context.count, context.path, context.sources
                                        .size());
                    }
                }
            }
        }
    }

    /**
     * @version 2015/01/08 15:06:53
     */
    private static class Context {

        /** The context manager. */
        private static final Map<String, Context> from = new HashMap();

        /** The source path. */
        private final Path path;

        /** The sources. */
        private Set<Class> sources = new HashSet();

        /** The profile phase. */
        private final BootonProfile profile;

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
         * @param target
         */
        private Context(Path path, BootonProfile title) {
            if (path == null) {
                path = JDK;
            }
            this.path = path;
            this.profile = title;
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

        private static Context get(BootonProfile title, Class target) {
            Path path = target == null ? JDK : ClassUtil.getArchive(target);

            Context context = from.get(path + title.toString());

            if (context == null) {
                context = new Context(path, title);
                from.put(path + title.toString(), context);
            }
            context.sources.add(target);

            return context;
        }
    }
}
