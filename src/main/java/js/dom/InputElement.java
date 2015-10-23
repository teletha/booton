/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;

/**
 * @version 2015/10/23 23:05:28
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "HTMLInputElement")
public abstract class InputElement extends Element implements JavascriptNative {

    /**
     * <p>
     * Get the value of the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    @Override
    public String attr(String name) {
        if (name.equals("value")) {
            return String.valueOf(property("name"));
        } else {
            return super.attr(name);
        }
    }

    /**
     * <p>
     * Set attribute for this element.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    @Override
    public Element attr(String name, Object value) {
        if (name.equals("value")) {
            property(name, value);
        }
        return super.attr(name, value);
    }
}
