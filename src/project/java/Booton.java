/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
import javax.servlet.http.HttpServletRequest;

import kiss.I;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;
import org.eclipse.jetty.websocket.WebSocketServlet;

import bee.api.Command;
import bee.api.Task;

/**
 * @version 2012/12/29 12:06:39
 */
public class Booton extends Task {

    /** The server port number. */
    protected int port = 10021;

    @Command
    public void develop() {
        Server server = new Server();
        server.setHandler(new WebSocketHandler() {

            @Override
            public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
                return new Action();
            }
        });

        ResourceHandler handler = new ResourceHandler();
        handler.setResourceBase("F://Development/Teemowork");

        LocalServlet servlet = new LocalServlet();
        server.setHandler(handler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/01/04 15:44:31
     */
    private static class LocalServlet extends WebSocketServlet {

        /**
         * {@inheritDoc}
         */
        @Override
        public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
            return new LocalSocket();
        }
    }

    /**
     * @version 2013/01/04 15:45:16
     */
    private static class LocalSocket implements WebSocket.OnTextMessage {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onOpen(Connection connection) {
            System.out.println("open");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClose(int closeCode, String message) {
            System.out.println("close");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onMessage(String data) {
            System.out.println("message  " + data);
        }
    }
}
