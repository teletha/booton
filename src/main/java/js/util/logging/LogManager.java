/*
 * Copyright (C) 2017 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.logging;

import booton.translator.JavaAPIProvider;

/**
 * @version 2017/04/21 19:25:35
 */
@JavaAPIProvider(java.util.logging.LogManager.class)
class LogManager {

    /** The singleton manager. */
    private static LogManager manager;

    /**
     * Returns the global LogManager object.
     * 
     * @return the global LogManager object
     */
    public static LogManager getLogManager() {
        if (manager != null) {
            manager = new LogManager();
        }
        return manager;
    }

    /**
     * 
     */
    void checkPermission() {
        // success
    }
}
