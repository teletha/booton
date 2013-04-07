/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import js.dom.Document;
import js.dom.Element;
import js.dom.History;
import js.dom.Location;
import js.dom.Window;
import js.net.WebSocket;
import js.util.jQuery;

import org.w3c.dom.DocumentFragment;

import booton.translator.Translator;

/***
 * <p>
 * Define global objects and static methods in Booton environment.
 * </p>
 * 
 * @version 2013/01/18 23:37:39
 */
public class Global {

    /** The booton root object. */
    public static NativeObject boot;

    /** The global object in web environment. */
    public static Window window;

    /** The root document in web environment. */
    public static Document document;

    /**
     * <p>
     * Returns a reference to the History object, which provides an interface for manipulating the
     * browser session history (pages visited in the tab or frame that the current page is loaded
     * in).
     * </p>
     */
    public static History history;

    /**
     * <p>
     * Returns a Location object, which contains information about the URL of the document and
     * provides methods for changing that URL. You can also assign to this property to load another
     * URL.
     * </p>
     */
    public static Location location;

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return A empty {@link jQuery} instance.
     */
    public static native jQuery $();

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return
     */
    public static native jQuery $(String expression);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return
     */
    public static native jQuery $(Element element);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param document
     * @return
     */
    public static native jQuery $(Document document);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param document
     * @return
     */
    public static native jQuery $(DocumentFragment document);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param window
     * @return
     */
    public static native jQuery $(Window window);

    /**
     * <p>
     * Establish connection to the specified uri.
     * </p>
     * 
     * @param uri
     * @param connection
     */
    public static native void connect(String uri, WebSocket connection);

    /**
     * <p>
     * Calls a function or executes a code snippet after specified delay.
     * </p>
     * 
     * @param function A callable function.
     * @param delay A delay time.
     * @return A timeout id.
     */
    public static native long setTimeout(Runnable runnable, int delay);

    /**
     * <p>
     * Clears the delay set by setTimeout().
     * </p>
     * 
     * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
     */
    public static native void clearTimeout(long timeoutId);

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public static native Object[] getArgumentArray();

    /**
     * @version 2012/12/14 13:11:07
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Global> {

        /** The booton root object. */
        public String boot = "boot";

        /** The global object in web environment. */
        public String window = "window";

        /** The root document. */
        public String document = "document";

        /** The root document. */
        public String history = "history";

        /**
         * <p>
         * Returns a Location object, which contains information about the URL of the document and
         * provides methods for changing that URL. You can also assign to this property to load
         * another URL.
         * </p>
         */
        public String location = "location";

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return A empty {@link jQuery} instance.
         */
        public String $() {
            return "$()";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return
         */
        public String $(String expression) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return
         */
        public String $(Element element) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param object
         * @return
         */
        public String $(Document object) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param document
         * @return
         */
        public String $(DocumentFragment document) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide Raphael support.
         * </p>
         * 
         * @param parent
         * @param width
         * @param height
         * @return
         */
        public String $(Element parent, int width, int height) {
            return "Raphael(" + param(0) + "," + param(1) + "," + param(2) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param object
         * @return
         */
        public String $(Window object) {
            return "$(" + param(0) + ")";
        }

        public String connect(String param0, WebSocket param1) {
            return "WebSocket.connect(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Calls a function or executes a code snippet after specified delay.
         * </p>
         * 
         * @param function A callable function.
         * @param delay A delay time.
         * @return A timeout id.
         */
        public String setTimeout(Runnable runnable, int delay) {
            return "setTimeout(boot.functionalize(" + param(0) + ")," + param(1) + ")";
        }

        /**
         * <p>
         * Clears the delay set by setTimeout().
         * </p>
         * 
         * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
         */
        public String clearTimeout(long timeoutId) {
            return "clearTimeout(" + param(0) + ")";
        }

        /**
         * <p>
         * Clears the delay set by setTimeout().
         * </p>
         * 
         * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
         */
        public String getArgumentArray() {
            return "Array.prototype.slice.call(arguments)";
        }
    }
}
