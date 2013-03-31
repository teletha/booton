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

import static js.lang.Global.*;

import org.w3c.dom.DOMException;

import booton.css.CSS;
import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/03/31 21:09:35
 */
public abstract class Element implements org.w3c.dom.Element, JavascriptNative {

    /** The class name list. */
    public DOMTokenList classList;

    /** The text contents. */
    public String textContent;

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
     * Create child element with the specified element name.
     * </p>
     * 
     * @param elementName A child element name.
     * @return A created element.
     */
    public Element child(String elementName) {
        return child("http://www.w3.org/1999/xhtml", elementName);
    }

    /**
     * <p>
     * Create child element with the specified element name.
     * </p>
     * 
     * @param elementName A child element name.
     * @return A created element.
     */
    public Element child(String uri, String elementName) {
        Element child = document.createElementNS(uri, elementName);
        appendChild(child);

        return child;
    }

    /**
     * <p>
     * Create child element with the specified element name.
     * </p>
     * 
     * @param elementName A child element name.
     * @return A created element.
     */
    public Element child(Class<? extends CSS> className) {
        return child("span").add(className);
    }

    /**
     * <p>
     * Assign classes.
     * </p>
     * 
     * @param classes A list of class names to assign.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            classList.add(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove classes.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            classList.remove(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove classes.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public Element toggle(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            classList.toggle(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Check classes.
     * </p>
     * 
     * @param classes A list of class names to check.
     * @return A result.
     */
    public boolean has(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            if (!classList.contains(clazz)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Set text contents.
     * </p>
     * 
     * @param text A child text contents.
     * @return Chainable API.
     */
    public Element text(String text) {
        textContent = text;

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, String value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, boolean value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, int value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, long value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, float value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

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
     * @return Chainable API.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element set(String name, double value) {
        setAttribute(name, value);

        // API definition
        return this;
    }

    /**
     * Removes an attribute by name. If a default value for the removed attribute is defined in the
     * DTD, a new attribute immediately appears with the default value as well as the corresponding
     * namespace URI, local name, and prefix when applicable. The implementation may handle default
     * values from other schemas similarly but applications should use
     * <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date. <br>
     * If no attribute with this name is found, this method has no effect. <br>
     * To remove an attribute by local name and namespace URI, use the
     * <code>removeAttributeNS</code> method.
     * 
     * @param name The name of the attribute to remove.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public Element remove(String name) {
        removeAttribute(name);

        // API definition
        return this;
    }

    /**
     * <p>
     * Make this element content editable.
     * </p>
     * 
     * @param enable true or false.
     * @return Chainable API.
     */
    public Element contentEditable(boolean enable) {
        setAttribute("contentEditable", enable);

        // API definition
        return this;
    }
}
