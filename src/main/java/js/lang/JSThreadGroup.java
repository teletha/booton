/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.lang.Thread.UncaughtExceptionHandler;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/28 23:00:34
 */
@JavaAPIProvider(ThreadGroup.class)
class JSThreadGroup implements UncaughtExceptionHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public void uncaughtException(Thread thread, Throwable error) {
        Thread.UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();

        if (handler != null) {
            handler.uncaughtException(thread, error);
        } else {
            error.printStackTrace(System.err);
        }
    }
}
