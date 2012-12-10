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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @version 2012/12/06 14:22:06
 */
public class WebSupport {

    /** The root document. */
    public static Document document;

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
