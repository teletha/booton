/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.web;

import booton.translator.JavascriptNative;

/**
 * @version 2013/01/07 12:52:18
 */
public class WebSocket implements JavascriptNative {

    /** The URL as resolved by the constructor. This is always an absolute URL. Read only. */
    public final String url;

    /**
     * <p>
     * Create WebSocket.
     * </p>
     * 
     * @param url
     */
    public WebSocket(String url) {
        this.url = url;
    }

    /**
     * <p>
     * Transmits data to the server over the WebSocket connection.
     * </p>
     * 
     * @param message A text string to send to the server.
     */
    public native void send(String message);
}
