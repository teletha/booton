/*
 * Copyright (C) 2013 Nameless Production Committee
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
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2013/12/29 0:44:51
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "Window")
public abstract class Window extends EventTarget<Window>implements JavascriptNative {

    /**
     * <p>
     * Returns a Location object, which contains information about the URL of the document and
     * provides methods for changing that URL. You can also assign to this property to load another
     * URL.
     * </p>
     */
    @JavascriptNativeProperty
    public Location location;

    /**
     * <p>
     * Returns a user locale.
     * </p>
     */
    @JavascriptNativeProperty
    public String language;

    /**
     * <p>
     * Gives the final used values of all the CSS properties of an element.
     * </p>
     * 
     * @param element A target element to compute styles.
     * @return A computed style rule.
     */
    public native CSSStyleDeclaration getComputedStyle(Element element);
}
