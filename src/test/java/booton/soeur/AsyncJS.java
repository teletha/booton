/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.soeur;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSStaticFunction;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJob;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJobManager;

/**
 * @version 2013/12/17 16:25:15
 */
@SuppressWarnings("serial")
public class AsyncJS extends ScriptableObject {

    /**
     * 
     */
    public AsyncJS() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getClassName() {
        return Async.name;
    }

    /**
     * <p>
     * Wait script execution.
     * </p>
     * 
     * @param millseconds
     */
    @JSStaticFunction
    public static void wait(int millseconds) {
        try {
            Thread.sleep(millseconds);
        } catch (InterruptedException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Await all background job's execution.
     * </p>
     * 
     * @param timeout
     */
    @JSStaticFunction
    public static void awaitTasks() {
        JavaScriptJobManager manager = ScriptTester.html.getEnclosingWindow().getJobManager();
        JavaScriptJob job = manager.getEarliestJob();

        while (job != null) {
            // execute background job
            job.run();

            // remove it
            manager.removeJob(job.getId());

            // search next job
            job = manager.getEarliestJob();
        }
    }
}