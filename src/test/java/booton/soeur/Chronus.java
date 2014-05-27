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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import kiss.I;
import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.Function;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import net.sourceforge.htmlunit.corejs.javascript.Scriptable;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSFunction;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSStaticFunction;
import antibug.internal.Awaitable;
import booton.translator.Translator;

/**
 * <p>
 * {@link antibug.Chronus} implemetation in Javascript runtime which uses {@link Awaitable}
 * functionality.
 * </p>
 * 
 * @version 2014/05/27 11:18:49
 */
@SuppressWarnings("serial")
public class Chronus extends ScriptableObject {

    /** The task scheduler. */
    private static final ScheduledExecutorService scheduler = Awaitable.wrap(Executors.newSingleThreadScheduledExecutor());

    /** The task manager. */
    private static final Map<Integer, ScheduledFuture> tasks = new ConcurrentHashMap();

    /**
     * 
     */
    public Chronus() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getClassName() {
        return "Chronus";
    }

    @JSStaticFunction
    public static int setTimeout(Function function, int delay) {
        FunctionTask task = new FunctionTask(function);
        tasks.put(task.id, scheduler.schedule(task, delay, TimeUnit.MILLISECONDS));

        return task.id;
    }

    @JSStaticFunction
    public static void clearTimeout(int id) {
        ScheduledFuture task = tasks.remove(id);

        if (task != null) {
            task.cancel(true);
        }
    }

    /**
     * <p>
     * Wait script execution.
     * </p>
     * 
     * @param millseconds
     */
    @JSFunction
    public void freeze(int millseconds) {
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
    @JSFunction
    public void await() {
        Awaitable.await();
    }

    /**
     * @version 2014/01/10 20:17:18
     */
    private static class FunctionTask implements Runnable {

        /** The id counter. */
        private static int conter = 0;

        /** The actual task. */
        private final Function function;

        /** The task id. */
        private final int id;

        /**
         * @param function
         */
        private FunctionTask(Function function) {
            this.function = function;
            this.id = conter++;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            try {
                function.call(Context.enter(), ScriptTester.html.getScriptObject(), (Scriptable) ScriptTester.html.getEnclosingWindow()
                        .getScriptObject(), new Object[0]);
            } catch (JavaScriptException e) {
                // ignore
            } finally {
                Context.exit();
                tasks.remove(id);
            }
        }
    }

    /**
     * @version 2014/03/06 15:02:09
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<antibug.Chronus> {

        public String Chronus(Class[] classes) {
            return "new Chronus()";
        }

        public String freeze(int time) {
            return that + ".freeze(" + param(0) + ")";
        }

        public String await() {
            return that + ".await()";
        }
    }
}