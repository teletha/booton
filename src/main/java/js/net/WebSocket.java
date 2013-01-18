/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.net;

import booton.translator.JavascriptNative;

/**
 * @version 2013/01/07 12:52:18
 */
public abstract class WebSocket {

    /**
     * <p>
     * Transmits data to the server over the WebSocket connection.
     * </p>
     * 
     * @param message A text string to send to the server.
     */
    public native void send(String message);

    /**
     * <p>
     * An event listener to be called when the WebSocket connection's readyState changes to OPEN;
     * this indicates that the connection is ready to send and receive data. The event is a simple
     * one with the name "open".
     * </p>
     */
    protected native void open();

    /**
     * <p>
     * An event listener to be called when the WebSocket connection's readyState changes to CLOSED.
     * The listener receives a CloseEvent named "close".
     * </p>
     */
    protected native void close();

    /**
     * <p>
     * An event listener to be called when an error occurs. This is a simple event named "error".
     * </p>
     */
    protected native void error();

    /**
     * <p>
     * An event listener to be called when a message is received from the server. The listener
     * receives a MessageEvent named "message".
     * </p>
     * 
     * @param event
     */
    protected native void message(MessageEvent event);

    /**
     * <p>
     * A MessageEvent is sent to clients using WebSockets when data is received from the server.
     * This is delivered to the listener indicated by the WebSocket object's onmessage attribute.
     * </p>
     * 
     * @version 2013/01/07 23:58:20
     */
    public static class MessageEvent implements JavascriptNative {

        /** The data from the server. */
        public String data;
    }
}
