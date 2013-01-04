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

import booton.translator.Translator;

/**
 * @version 2012/12/14 13:11:07
 */
public class WebSupportTranslator extends Translator<WebSupport> {

    /** The root object. */
    public String window = "window";

    /** The root document. */
    public String document = "document";

    /** The root document. */
    public String history = "history";

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
     * @param object
     * @return
     */
    public String $(Window object) {
        return "$(" + param(0) + ")";
    }
}
