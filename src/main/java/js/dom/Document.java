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

import org.w3c.dom.DocumentFragment;

import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Document} for web platform.
 * </p>
 * 
 * @version 2013/03/23 14:13:30
 */
public abstract class Document implements JavascriptNative {

    /**
     * <p>
     * Return a new DocumentFragment node with its node document set to the context object.
     * </p>
     * 
     * @return
     */
    public native DocumentFragment createDocumentFragment();

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

    /**
     * {@inheritDoc}
     */
    public native Element createElementNS(String namespaceURI, String qualifiedName);
}
