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

import kiss.I;

import org.w3c.dom.Document;

import booton.translator.Translatable;

/**
 * @version 2012/11/29 9:56:55
 */
@Translatable
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
    public static JQuery $(String expression) {
        return I.make(JQuery.class);
    }
}
