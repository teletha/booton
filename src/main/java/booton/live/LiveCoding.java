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

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import js.lang.builtin.Console;
import js.net.NativeWebSocket;
import js.net.NativeWebSocket.Listener;

/**
 * @version 2013/07/26 15:27:23
 */
public class LiveCoding implements UncaughtExceptionHandler, Listener {

    /** The status of server connection. */
    private boolean open = false;

    /** The cached error. */
    private List<Throwable> throwables = new ArrayList();

    /** The connection. */
    private NativeWebSocket socket;

    /**
     * 
     */
    public void jsmain() {
        Thread.setDefaultUncaughtExceptionHandler(this);

        socket = new NativeWebSocket("ws://localhost:10021/live" + window.location.pathname, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (open) {
            sendError(throwable);
        } else {
            this.throwables.add(throwable);
        }
    }

    /**
     * <p>
     * Send error to server.
     * </p>
     * 
     * @param throwable
     */
    private void sendError(Throwable throwable) {
        StringBuilder builder = new StringBuilder();
        builder.append(throwable.getClass().getName()).append("\r\n");
        builder.append(throwable.getMessage()).append("\r\n");

        for (StackTraceElement element : throwable.getStackTrace()) {
            builder.append(element.getMethodName())
                    .append(" ")
                    .append(element.getFileName())
                    .append(" ")
                    .append(element.getLineNumber())
                    .append("\r\n");
        }
        socket.send(builder.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void open() {
        open = true;

        if (!throwables.isEmpty()) {
            for (Throwable throwable : throwables) {
                sendError(throwable);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void message(String src) {
        if (src.endsWith("css")) {
            $("link[href^='" + src + "']").attr("href", src + "?" + new Date().getTime());
        } else {
            window.location.reload(false);
        }

        // clean up console message
        Console.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error() {
    }
}
