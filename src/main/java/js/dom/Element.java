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
import js.lang.Function;

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
     * Registers a single event listener on a single target. The event target may be a single
     * element in a document, the document itself, a window, or an XMLHttpRequest.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs. This must be an object implementing the EventListener interface, or simply
     *            a JavaScript function.
     */
    public native void addEventListener(String type, Listener listener);

    /**
     * <p>
     * Registers a single event listener on a single target. The event target may be a single
     * element in a document, the document itself, a window, or an XMLHttpRequest.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs. This must be an object implementing the EventListener interface, or simply
     *            a JavaScript function.
     * @param useCapture If true, useCapture indicates that the user wishes to initiate capture.
     *            After initiating capture, all events of the specified type will be dispatched to
     *            the registered listener before being dispatched to any EventTarget beneath it in
     *            the DOM tree. Events which are bubbling upward through the tree will not trigger a
     *            listener designated to use capture. See DOM Level 3 Events for a detailed
     *            explanation. Note that this parameter is not optional in all browser versions. If
     *            not specified, useCapture is false.
     */
    public native void addEventListener(String type, Listener listener, boolean useCapture);

    /**
     * <p>
     * Allows the removal of event listeners from the event target.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener parameter indicates the EventListener function to be removed.
     */
    public native void removeEventListener(String type, Listener listener);

    /**
     * <p>
     * Allows the removal of event listeners from the event target.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener parameter indicates the EventListener function to be removed.
     * @param useCapture Specifies whether the EventListener being removed was registered as a
     *            capturing listener or not. If a listener was registered twice, one with capture
     *            and one without, each must be removed separately. Removal of a capturing listener
     *            does not affect a non-capturing version of the same listener, and vice versa.
     */
    public native void removeEventListener(String type, Listener listener, boolean useCapture);

    /**
     * <p>
     * Dispatches an event into the event system. The event is subject to the same capturing and
     * bubbling behavior as directly dispatched events.
     * </p>
     * 
     * @param event
     */
    public native void dispatchEvent(Event event);

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
     * Add child element.
     * </p>
     * 
     * @param elementName A child element name.
     * @return A created element.
     */
    public Element append(Elementable child) {
        appendChild(child.getElement());

        // API definition
        return this;
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

    /**
     * <p>
     * Clear all children nodes.
     * </p>
     * 
     * @return Chainable API.
     */
    public Element empty() {
        while (lastChild != null) {
            removeChild(lastChild);
        }

        // API definition
        return this;
    }

    /**
     * @version 2012/12/02 23:08:01
     */
    public static interface Listener extends Function {

        /**
         * <p>
         * Handle registered event.
         * </p>
         * 
         * @param event
         * @return
         */
        void handleEvent(Event event);
    }

    /**
     * @version 2012/12/02 23:06:56
     */
    public static class Event implements JavascriptNative {

        /** The DOM element that initiated the event. */
        public Element target;

        /** The current DOM element within the event bubbling phase. */
        public Element currentTarget;

        /** The other DOM element involved in the event, if any. */
        public Element relatedTarget;

        /** The element where the currently-called jQuery event handler was attached. */
        public Element delegateTarget;

        /** The namespace specified when the event was triggered. */
        public String namespace;

        /** The mouse position relative to the left edge of the document. */
        public int pageX;

        /** The mouse position relative to the top edge of the document. */
        public int pageY;

        /**
         * The difference in milliseconds between the time the browser created the event and January
         * 1, 1970.
         */
        public long timeStamp;

        /** Describes the nature of the event. */
        public String type;

        /**
         * For key or mouse events, this property indicates the specific key or button that was
         * pressed.
         */
        public int which;

        /**
         * <p>
         * Returns whether event.preventDefault() was ever called on this event object.
         * </p>
         * 
         * @return
         */
        public native boolean isDefaultPrevented();

        /**
         * <p>
         * Returns whether event.stopImmediatePropagation() was ever called on this event object.
         * </p>
         * 
         * @return
         */
        public native boolean isImmediatePropagationStopped();

        /**
         * <p>
         * Returns whether event.stopPropagation() was ever called on this event object.
         * </p>
         * 
         * @return
         */
        public native boolean isPropagationStopped();

        /**
         * <p>
         * If this method is called, the default action of the event will not be triggered.
         * </p>
         */
        public native void preventDefault();

        /**
         * <p>
         * Prevents the event from bubbling up the DOM tree, preventing any parent handlers from
         * being notified of the event.
         * </p>
         */
        public native void stopPropagation();

        /**
         * <p>
         * Keeps the rest of the handlers from being executed and prevents the event from bubbling
         * up the DOM tree.
         * </p>
         */
        public native void stopImmediatePropagation();
    }
}
