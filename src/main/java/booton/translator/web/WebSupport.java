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


/**
 * @version 2012/12/14 13:11:16
 */
public class WebSupport {

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
}
