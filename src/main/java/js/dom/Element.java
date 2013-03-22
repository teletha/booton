/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import org.w3c.dom.DOMException;

import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2012/12/14 12:41:54
 */
public abstract class Element implements org.w3c.dom.Element, JavascriptNative {

    /** The class name list. */
    public DOMTokenList classList;

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

    /**
     * Adds a new attribute. If an attribute with that name is already present in the element, its
     * value is changed to be that of the value parameter. This value is a simple string; it is not
     * parsed as it is being set. So any markup (such as syntax to be recognized as an entity
     * reference) is treated as literal text, and needs to be appropriately escaped by the
     * implementation when it is written out. In order to assign an attribute value that contains
     * entity references, the user must create an <code>Attr</code> node plus any <code>Text</code>
     * and <code>EntityReference</code> nodes, build the appropriate subtree, and use
     * <code>setAttributeNode</code> to assign it as the value of an attribute. <br>
     * To set an attribute with a qualified name and namespace URI, use the
     * <code>setAttributeNS</code> method.
     * 
     * @param name The name of the attribute to create or alter.
     * @param value Value to set.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public native void setAttribute(String name, int value);
}
