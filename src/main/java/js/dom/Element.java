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

import booton.css.CSS;
import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/03/31 21:09:35
 */
public abstract class Element extends js.dom.Node implements JavascriptNative {

    /** The localName attribute must return the context object's local name. */
    public String localName;

    /**
     * <p>
     * The tagName attribute must run these steps:
     * </p>
     * <ol>
     * <li>If context object's namespace prefix is not null, let qualified name be its namespace
     * prefix, followed by a ":" (U+003A), followed by its local name. Otherwise, let qualified name
     * be its local name.</li>
     * <li>If the context object is in the HTML namespace and its node document is an HTML document,
     * let qualified name be converted to ASCII uppercase.</li>
     * <li>Return qualified name.</li>
     * </ol>
     */
    public String tagName;

    /** The class name list. */
    public DOMTokenList classList;

    /** The first direct child node of an element, or null if this element has no child nodes. */
    public Node firstChild;

    /** The last direct child node of an element, or null if this element has no child nodes. */
    public Node lastChild;

    /** The text contents. */
    public String textContent;

    /**
     * <p>
     * Adds the specified class to each of the set of matched elements.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of each matched element.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS> className) {
        classList.add(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classes A list of class names to assign.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            add(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, to the end of each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents DOM element to insert at the end of each element in the set of matched
     *            elements.
     * @return Chainable API.
     */
    public Element append(Element contents) {
        appedChild(contents);

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the value of an attribute for the first element in the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    public String attr(String name) {
        return getAttribute(name);
    }

    /**
     * <p>
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return A chainable API.
     */
    public Element attr(String name, Object value) {
        setAttribute(name, value.toString());

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove an attribute from each element in the set of matched elements.
     * </p>
     * 
     * @param attributeName An attribute to remove.
     * @return A chainable API.
     */
    public Element remove(String name) {
        removeAttribute(name);

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a class from each element in the set of matched elements.
     * </p>
     * 
     * @param className A class name to be removed from the class attribute of each matched element.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS> className) {
        classList.remove(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a single class, multiple classes, or all classes from each element in the set of
     * matched elements.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            remove(clazz);
        }

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    protected abstract String getAttribute(String name);

    /**
     * {@inheritDoc}
     */
    protected abstract void setAttribute(String name, String value);

    /**
     * {@inheritDoc}
     */
    protected abstract void removeAttribute(String name);

    /**
     * {@inheritDoc}
     */
    public native NodeList getElementsByTagName(String name);

    /**
     * {@inheritDoc}
     */
    public native String getAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    public native void setAttributeNS(String namespaceURI, String qualifiedName, String value);

    /**
     * {@inheritDoc}
     */
    public native void removeAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    public native Attr getAttributeNodeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    public native Attr setAttributeNodeNS(Attr newAttr);

    /**
     * {@inheritDoc}
     */
    public native NodeList getElementsByTagNameNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    public native boolean hasAttribute(String name);

    /**
     * {@inheritDoc}
     */
    public native boolean hasAttributeNS(String namespaceURI, String localName);

    /**
     * {@inheritDoc}
     */
    public native TypeInfo getSchemaTypeInfo();

    /**
     * {@inheritDoc}
     */
    public native void setIdAttribute(String name, boolean isId);

    /**
     * {@inheritDoc}
     */
    public native void setIdAttributeNS(String namespaceURI, String localName, boolean isId);

    /**
     * {@inheritDoc}
     */
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
