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

import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2012/12/14 12:41:54
 */
public abstract class Element implements org.w3c.dom.Element, JavascriptNative {

    /**
     * <p>
     * Returns the first element that is a descendent of the element on which it is invoked that
     * matches the specified group of selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    public native Element querySelector(String selector);

    /**
     * <p>
     * Returns a non-live NodeList of all elements descended from the element on which it is invoked
     * that match the specified group of CSS selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    public native Element[] querySelectorAll(String selector);
}
