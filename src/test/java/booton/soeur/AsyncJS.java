/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import antibug.Async;
import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2014/01/10 16:30:58
 */
class AsyncJS extends Translator<Async> {

    /**
     * <p>
     * Use thread pool.
     * </p>
     * 
     * @return
     */
    public String use() {
        return "new " + Javascript.computeClassName(ScheduledThreadPoolExecutor.class) + "(0)";
    }

    /**
     * <p>
     * Wait script execution.
     * </p>
     * 
     * @param millseconds
     */
    public String wait(int millseconds) {
        return "Async" + ".wait(" + param(0) + ")";
    }

    /**
     * <p>
     * Await all background job's execution.
     * </p>
     * 
     * @param timeout
     */
    public String awaitTasks() {
        return "Async" + ".awaitTasks()";
    }
}
