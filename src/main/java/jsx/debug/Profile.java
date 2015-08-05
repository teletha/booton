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

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @version 2015/02/22 15:23:08
 */
public interface Profile<K, E, Y> {

    /**
     * <p>
     * A name of this phase.
     * </p>
     * 
     * @return A name of this phase.
     */
    public String name();

    /**
     * <p>
     * Start profiling.
     * </p>
     */
    public default void start() {
        start((K) null, (E) null, (Y) null);
    }

    /**
     * <p>
     * End profiling.
     * </p>
     */
    public default void end() {
        stop();
    }

    /**
     * <p>
     * Execute profiling.
     * </p>
     * 
     * @param action
     */
    public default void execute(Runnable action) {
        start();
        try {
            action.run();
        } finally {
            end();
        }
    }

    /**
     * <p>
     * Create the group name by keys.
     * </p>
     * 
     * @param key1
     * @param key2
     * @param key3
     * @return
     */
    public default String name(K key1, E key2, Y key3) {
        return name();
    }

    /**
     * <p>
     * Create the grouping key.
     * </p>
     * 
     * @param key1
     * @param key2
     * @param key3
     * @return
     */
    public default Object group(K key1, E key2, Y key3) {
        return Objects.hash(key1, key2, key3);
    }

    public default void show(String name, long elapsedMillSeconds, float occupancy, long count) {
        System.out.println(name + "  \t" + elapsedMillSeconds + "ms  \t" + occupancy + "%  \t" + count + "calls");
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    public static void show() {
        Profiler.show2();
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1) {
        start(key1, (E) null, (Y) null);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1, E key2) {
        start(key1, key2, (Y) null);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1, E key2, Y key3) {
        Profiler.start(this, key1, key2, key3);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1, Runnable process) {
        start(key1, null, null, process);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1, E key2, Runnable process) {
        start(key1, key2, null, process);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default void start(K key1, E key2, Y key3, Runnable process) {
        start(key1, key2, key3);
        try {
            process.run();
        } finally {
            stop();
        }
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default <T> T start(K key1, Supplier<T> process) {
        return start(key1, null, null, process);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default <T> T start(K key1, E key2, Supplier<T> process) {
        return start(key1, key2, null, process);
    }

    /**
     * <p>
     * Start profiling phase with the specified grouping key.
     * </p>
     * 
     * @param key1
     */
    public default <T> T start(K key1, E key2, Y key3, Supplier<T> process) {
        start(key1, key2, key3);
        try {
            return process.get();
        } finally {
            stop();
        }
    }

    /**
     * <p>
     * Stop profiling phase.
     * </p>
     */
    public default void stop() {
        Profiler.stop();
    }
}
