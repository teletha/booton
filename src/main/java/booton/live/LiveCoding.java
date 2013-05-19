/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import static js.lang.Global.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

import js.lang.Function;
import js.lang.NativeFunction;
import js.lang.builtin.Console;
import js.net.WebSocket;

/**
 * @version 2013/01/08 13:33:11
 */
public class LiveCoding extends WebSocket implements UncaughtExceptionHandler {

    /**
     * 
     */
    public void jsmain() {
        Thread.setDefaultUncaughtExceptionHandler(this);

        connect("ws://localhost:10021/live" + window.location.pathname, this);

        System.setOut(new LiveConsole());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("expection in live");
        System.out.println(throwable.getStackTrace());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void open() {
        System.out.println("open");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void message(MessageEvent event) {
        String src = event.data;

        if (src.endsWith("css")) {
            $("link[href^='" + src + "']").attr("href", src + "?" + new Date().getTime());
        } else {
            window.location.reload(false);
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @param className
     * @param methodName
     * @param function
     * @return
     */
    Function debug(final String className, final String methodName, final NativeFunction function) {
        return new Function() {

            void apply() {
                System.out.println("start " + className + "#" + methodName);
                function.apply(this, getArgumentArray());
                System.out.println("end");
            }
        };
    }

    /**
     * @version 2013/05/17 1:13:00
     */
    private static class LiveConsole extends PrintStream {

        /**
         * @param out
         */
        public LiveConsole() {
            super((OutputStream) null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void println(String x) {
            super.println(x);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void println(Object x) {
            super.println(x);
            Console.log("@@@");
        }
    }
}
