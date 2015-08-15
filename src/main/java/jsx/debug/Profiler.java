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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import kiss.Interceptor;

/**
 * @version 2015/08/15 22:20:21
 */
class Profiler<K, E, Y> extends Interceptor<Profilable> {

    static boolean execute = true;

    /** The profiling manager. */
    private static final ConcurrentHashMap<String, Result> results = new ConcurrentHashMap();

    /** The latest profiling. */
    private static Result latest = new Result(null, null, null, null);

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        start(() -> that.getClass().getSimpleName() + "#" + name, null, null, null);
        Object value = super.invoke(params);
        stop();

        return value;
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    static final <K, E, Y> void start(Profile profile, K key1, E key2, Y key3) {
        if (execute) {
            latest.stop();

            String key = String.valueOf(profile).concat(String.valueOf(key1)).concat(String.valueOf(key2)).concat(String.valueOf(key3));
            Result now = results.computeIfAbsent(key, name -> new Result(profile, key1, key2, key3));
            now.previous = latest;
            now.count++;
            latest = now;
            now.start();
        }
    }

    /**
     * <p>
     * Stop profiling phase.
     * </p>
     */
    static final void stop() {
        if (execute) {
            latest.stop();
            latest = latest.previous;
            latest.start();
        }
    }

    /**
     * <p>
     * Show profiling result.
     * </p>
     * 
     * @param results
     */
    static final void show() {
        if (execute) {
            long total = 0;
            Map<Object, Result> grouped = new HashMap();

            for (Result result : results.values()) {
                Integer key = Objects.hash(result.profile, result.profile.group(result.key1, result.key2, result.key3));

                Result computed = grouped.computeIfAbsent(key, name -> new Result(result));
                computed.elapsed += result.elapsed;
                computed.count += result.count;

                total += result.elapsed;
            }

            List<Result> list = new ArrayList(grouped.values());
            Collections.sort(list, Comparator.<Result> comparingDouble(item -> item.elapsed).reversed());

            // size filter
            list = list.subList(0, Math.min(15, list.size()));

            System.out.println("Total Profiled Time: " + ms(total) + "ms");

            for (Result result : list) {
                if (result.elapsed != 0) {
                    result.profile.show(result.name, ms(result.elapsed), (result.elapsed / total) * 100, result.count);
                }
            }
            results.clear();
        }
    }

    /**
     * <p>
     * Convert nano second to mill second.
     * </p>
     * 
     * @param nano
     * @return
     */
    private static long ms(long nano) {
        return nano / 1000000;
    }

    /**
     * @version 2015/08/02 20:31:19
     */
    protected static class Result<K, E, Y> implements AutoCloseable {

        protected String name;

        /** The profile. */
        private Profile profile;

        /** The group key. */
        private K key1;

        /** The group key. */
        private E key2;

        /** The group key. */
        private Y key3;

        /** The previous profiling. */
        private Result previous;

        /** The latest recorded time. */
        private long latest;

        /** The elapsed time of the specified phase. */
        protected long elapsed;

        /** The start time of the specified phase. */
        private long start;

        /** The end time of the specified phase. */
        private long end;

        /** The call count. */
        protected long count;

        /**
         * @param name
         */
        private Result(Result result) {
            this.profile = result.profile;
            this.name = profile.name(result.key1, result.key2, result.key3);
        }

        /**
         * @param name
         * @param group
         */
        private Result(Profile profile, K key1, E key2, Y key3) {
            this.profile = profile;
            this.key1 = key1;
            this.key2 = key2;
            this.key3 = key3;
        }

        /**
         * 
         */
        private void start() {
            long now = System.nanoTime();

            if (start == 0) {
                start = now;
            }
            latest = now;
        }

        /**
         * 
         */
        private void stop() {
            end = System.nanoTime();
            elapsed += end - latest;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void close() throws Exception {
            Profiler.stop();
        }
    }
}
