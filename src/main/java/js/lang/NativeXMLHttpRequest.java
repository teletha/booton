/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.Translator;
import js.dom.EventTarget;

/**
 * @version 2015/10/20 21:42:15
 */
public class NativeXMLHttpRequest extends EventTarget {

    // /**
    // * <p>
    // * Returns a EventHandler that is called whenever the readyState attribute changes. The
    // callback
    // * is called from the user interface thread. Warning: This should not be used with synchronous
    // * requests and must not be used from native code.
    // * </p>
    // */
    // public NativeFunction onReadyStateChange;

    // /** Is an enumerated value that defines the response type. It can have the following values:
    // */
    // public String responseType;

    /**
     * 
     */
    public NativeXMLHttpRequest() {
        super();
    }

    /**
     * 
     */
    public void withCredentials() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Sets the value of an HTTP request header. You must call setRequestHeader()after open(), but
     * before send(). If this method is called several times with the same header, the values are
     * merged into one single request header.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public void setRequestHeader(String name, String value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Initializes a request. This method is to be used from JavaScript code; to initialize a
     * request from native code, use openRequest() instead.
     * </p>
     */
    public void open(String method, String url) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Sends the request. If the request is asynchronous (which is the default), this method returns
     * as soon as the request is sent. If the request is synchronous, this method doesn't return
     * until the response has arrived.
     * </p>
     */
    public void send() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Aborts the request if it has already been sent.
     * </p>
     */
    public void abort() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Returns a DOMString that contains the response to the request as text, or null if the request
     * was unsuccessful or has not yet been sent.
     * </p>
     * 
     * @return
     */
    public String responseText() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2015/10/20 21:45:18
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeXMLHttpRequest> {

        /**
         * 
         */
        public String NativeXMLHttpRequest() {
            return "new XMLHttpRequest()";
        }

        /**
         * 
         */
        public String withCredentials() {
            return that + ".withCredentials=true";
        }

        /**
         * <p>
         * Sets the value of an HTTP request header. You must call setRequestHeader()after open(),
         * but before send(). If this method is called several times with the same header, the
         * values are merged into one single request header.
         * </p>
         * 
         * @param name
         * @param value
         * @return
         */
        public String setRequestHeader(String name, String value) {
            return that + ".setRequestHeader(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Initializes a request. This method is to be used from JavaScript code; to initialize a
         * request from native code, use openRequest() instead.
         * </p>
         */
        public String open(String method, String url) {
            return that + ".open(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Sends the request. If the request is asynchronous (which is the default), this method
         * returns as soon as the request is sent. If the request is synchronous, this method
         * doesn't return until the response has arrived.
         * </p>
         */
        public String send() {
            return that + ".send()";
        }

        /**
         * <p>
         * Aborts the request if it has already been sent.
         * </p>
         */
        public String abort() {
            return that + ".abort()";
        }

        /**
         * <p>
         * Returns a DOMString that contains the response to the request as text, or null if the
         * request was unsuccessful or has not yet been sent.
         * </p>
         * 
         * @return
         */
        public String responseText() {
            return that + ".responseText";
        }

        /**
         * <p>
         * Registers the specified listener on the EventTarget it's called on.
         * </p>
         * 
         * @param type A string representing the event type to listen for.
         * @param listener The object that receives a notification when an event of the specified
         *            type occurs.
         */
        public String addEventListener(String type, NativeFunction listener) {
            return that + ".addEventListener(" + param(0) + "," + param(1) + ")";
        }
    }
}
