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
import booton.translator.JavascriptNativeMethod;
import booton.translator.Translator;

/**
 * @version 2013/05/22 23:31:12
 */
public class NativeWebSocket {

    /** The URL as resolved by the constructor. This is always an absolute URL. */
    public final String url;

    /**
     * <p>
     * The WebSocket object provides the API for creating and managing a WebSocket connection to a
     * server, as well as for sending and receiving data on the connection.
     * </p>
     * 
     * @param url The URL as resolved by the constructor. This is always an absolute URL.
     */
    public NativeWebSocket(String url, Listener listener) {
        this.url = url;
    }

    /**
     * <p>
     * Transmits data to the server over the WebSocket connection.
     * </p>
     * 
     * @param message
     */
    public native void send(String message);

    /**
     * <p>
     * Closes the WebSocket connection or connection attempt, if any. If the connection is already
     * CLOSED, this method does nothing.
     * </p>
     */
    public native void close();

    /**
     * @version 2013/05/22 23:33:41
     */
    public static interface Listener extends JavascriptNative {

        /**
         * <p>
         * An event listener to be called when the WebSocket connection's readyState changes to
         * OPEN; this indicates that the connection is ready to send and receive data. The event is
         * a simple one with the name "open".
         * </p>
         */
        @JavascriptNativeMethod
        void open();

        /**
         * <p>
         * An event listener to be called when the WebSocket connection's readyState changes to
         * CLOSED. The listener receives a CloseEvent named "close".
         * </p>
         */
        @JavascriptNativeMethod
        void close();

        /**
         * <p>
         * An event listener to be called when an error occurs. This is a simple event named
         * "error".
         * </p>
         */
        @JavascriptNativeMethod
        void error();

        /**
         * <p>
         * An event listener to be called when a message is received from the server. The listener
         * receives a MessageEvent named "message".
         * </p>
         * 
         * @param message
         */
        @JavascriptNativeMethod
        void message(String message);
    }

    /**
     * @version 2013/05/22 23:35:36
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeWebSocket> {

        /**
         * <p>
         * The WebSocket object provides the API for creating and managing a WebSocket connection to
         * a server, as well as for sending and receiving data on the connection.
         * </p>
         * 
         * @param url The URL as resolved by the constructor. This is always an absolute URL.
         */
        public String NativeWebSocket(String url, Listener listener) {
            return "WebSocket.connect(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Transmits data to the server over the WebSocket connection.
         * </p>
         * 
         * @param message
         */
        public String send(String message) {
            return that + ".send(" + param(0) + ")";
        }

        /**
         * <p>
         * Closes the WebSocket connection or connection attempt, if any. If the connection is
         * already CLOSED, this method does nothing.
         * </p>
         */
        public String close() {
            return that + ".close()";
        }
    }
}
