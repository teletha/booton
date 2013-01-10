/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.web;

import org.w3c.dom.DocumentFragment;

import booton.translator.Translator;

/**
 * @version 2012/12/14 13:11:16
 */
public class WebSupport {

    /** The global object in web environment. */
    public static Window window;

    /** The root document. */
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
     * Establish connection to the specified uri.
     * </p>
     * 
     * @param uri
     * @param connection
     */
    public static native void connect(String uri, WebSocket connection);

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
     * @version 2012/12/14 13:11:07
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<WebSupport> {

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
    }
}
