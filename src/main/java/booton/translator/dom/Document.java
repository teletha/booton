/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.dom;

import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Document} for web platform.
 * </p>
 * 
 * @version 2012/12/14 12:42:38
 */
public abstract class Document implements org.w3c.dom.Document, JavascriptNative {

    /**
     * <p>
     * Returns the first element within the document (using depth-first pre-order traversal of the
     * document's nodes) that matches the specified group of selectors.
     * </p>
     * 
     * @param query
     * @return
     */
    public native Element querySelector(String query);

    /**
     * <p>
     * Returns a list of the elements within the document (using depth-first pre-order traversal of
     * the document's nodes) that match the specified group of selectors. The object returned is a
     * NodeList.
     * </p>
     * 
     * @param query
     * @return
     */
    public native Element[] querySelectorAll(String query);

    /**
     * {@inheritDoc}
     */
    public native Element createElement(String name);
}
