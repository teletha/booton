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

/**
 * @version 2015/02/22 15:23:08
 */
public interface Profile {

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
        Profiler.start(this);
    }

    /**
     * <p>
     * End profiling.
     * </p>
     */
    public default void end() {
        Profiler.end(this);
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
        action.run();
        end();
    }

    /**
     * <p>
     * Display result.
     * </p>
     */
    public static void show() {
        Profiler.show();
    }
}
