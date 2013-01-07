/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kiss.I;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

/**
 * @version 2013/01/04 15:44:31
 */
@SuppressWarnings("serial")
public class LiveCodingServlet extends WebSocketServlet {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        return new LiveCodingSocket();
    }

    /**
     * @version 2013/01/04 15:45:16
     */
    private static class LiveCodingSocket implements WebSocket.OnTextMessage {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onOpen(Connection connection) {
            System.out.println("open");
            try {
                connection.sendMessage("reply");
            } catch (IOException e) {
                throw I.quiet(e);
            }
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
