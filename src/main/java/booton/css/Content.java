/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/13 11:44:43
 */
public class Content extends CSSProperty<Content> {

    /**
     * <p>
     * Text content.
     * </p>
     * 
     * @param value
     * @return
     */
    public Content text(String value) {
        return chain("'" + value + "'");
    }

    /**
     * <p>
     * The pseudo-element is not generated.
     * </p>
     * 
     * @return
     */
    public Content none() {
        return chain("none");
    }

    /**
     * <p>
     * Returns the value of the element's attribute X as a string. If there is no attribute X, an
     * empty string is returned. The case-sensitivity of attribute names depends on the document
     * language.
     * </p>
     * 
     * @param name
     * @return
     */
    public Content attr(String name) {
        return chain("attr(" + name + ")");
    }

    /**
     * <p>
     * These values are replaced by the appropriate string from the quotes property.
     * </p>
     * 
     * @return
     */
    public Content openQuote() {
        return chain("open-quote");
    }

    /**
     * <p>
     * These values are replaced by the appropriate string from the quotes property.
     * </p>
     * 
     * @return
     */
    public Content closeQuote() {
        return chain("close-quote");
    }
}
