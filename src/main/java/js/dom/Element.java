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

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/03/31 21:09:35
 */
public abstract class Element extends js.dom.Node implements org.w3c.dom.Element, JavascriptNative {

    /** The class name list. */
    public DOMTokenList classList;

    /** The first direct child node of an element, or null if this element has no child nodes. */
    public Node firstChild;

    /** The last direct child node of an element, or null if this element has no child nodes. */
    public Node lastChild;

    /** The text contents. */
    public String textContent;

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getTagName();

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getAttribute(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setAttribute(String name, String value);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void removeAttribute(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Attr getAttributeNode(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Attr setAttributeNode(Attr newAttr);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Attr removeAttributeNode(Attr oldAttr);

    /**
     * {@inheritDoc}
     */
    @Override
    public native NodeList getElementsByTagName(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setAttributeNS(String namespaceURI, String qualifiedName, String value);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void removeAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Attr getAttributeNodeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Attr setAttributeNodeNS(Attr newAttr);

    /**
     * {@inheritDoc}
     */
    @Override
    public native NodeList getElementsByTagNameNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean hasAttribute(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean hasAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    @Override
    public native TypeInfo getSchemaTypeInfo();

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setIdAttribute(String name, boolean isId);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setIdAttributeNS(String namespaceURI, String localName, boolean isId);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setIdAttributeNode(Attr idAttr, boolean isId);

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
    public native void setAttribute(String name, boolean value);

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
    public native void setAttribute(String name, long value);

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
    public native void setAttribute(String name, float value);

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
    public native void setAttribute(String name, double value);

    /**
     * <p>
     * The scrollIntoView() method scrolls the element into view.
     * </p>
     */
    public native void scrollIntoView();
}
