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

import java.util.ArrayList;
import java.util.List;

import booton.css.CSS;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/07/01 2:12:14
 */
@JavascriptAPIProvider
public abstract class Element extends Node implements JavascriptNative {

    /** The localName attribute must return the context object's local name. */
    @JavascriptNativeProperty
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
    @JavascriptNativeProperty
    public String tagName;

    /** The class name list. */
    @JavascriptNativeProperty
    public DOMTokenList classList;

    /**
     * <p>
     * Adds the specified class to this elements.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of this element.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS> className) {
        classList.add(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Adds the specified class(es) to this elements.
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
     * Insert content, specified by the parameter, after this element.
     * </p>
     * 
     * @param element A content to insert.
     * @return Chainable API.
     */
    public Element after(Element element) {
        Node parent = parentElement();

        if (parent != null) {
            parent.insertBefore(element, nextSibling());
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content to the end of this element.
     * </p>
     * 
     * @param contents DOM element to insert at the end of this element.
     * @return Chainable API.
     */
    public Element append(Element contents) {
        appedChild(contents);

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content to the end of this element.
     * </p>
     * 
     * @param contents DOM element to insert at the end of this element.
     * @return Chainable API.
     */
    public Element append(Object contents) {
        if (contents instanceof Element) {
            appedChild((Element) contents);
        } else {
            appedChild(String.valueOf(contents));
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the value of the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    public String attr(String name) {
        return getAttribute(String.valueOf(name));
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
    public Element attr(String name, Object value) {
        return attr(null, name, value);
    }

    /**
     * <p>
     * Set attribute with namespace for this element.
     * </p>
     * 
     * @param namespace The namespace uri of the attribute.
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    public Element attr(String namespace, String name, Object value) {
        setAttributeNS(namespace, name, String.valueOf(value));

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, before this element.
     * </p>
     * 
     * @param element A content to insert.
     * @return Chainable API.
     */
    public Element before(Element element) {
        Node parent = parentElement();

        if (parent != null) {
            parent.insertBefore(element, this);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the children of this element.
     * </p>
     * 
     * @return A list of child elements.
     */
    public List<Element> children() {
        List<Element> list = new ArrayList();
        Element element = firstElementChild();

        while (element != null) {
            list.add(element);

            element = element.nextElementSibling();
        }
        return list;
    }

    /**
     * <p>
     * Remove all child nodes of this element from the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public Element empty() {
        textContent("");

        // API definition
        return this;
    }

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    public Element next() {
        return nextElementSibling();
    }

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    public Element parent() {
        return parentElement();
    }

    /**
     * <p>
     * Insert content to the begining of this element.
     * </p>
     * 
     * @param contents DOM element to insert at the begining of this element.
     * @return Chainable API.
     */
    public Element prepend(Element contents) {
        insertBefore(contents, firstChild());

        // API definition
        return this;
    }

    /**
     * <p>
     * Returns the first preceding sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first preceding sibling that is an element, and null otherwise.
     */
    public Element prev() {
        return nextElementSibling();
    }

    /**
     * <p>
     * Remove this element from the DOM.
     * </p>
     * 
     * @param element
     * @return
     */
    public Element remove() {
        Element parent = parentElement();

        if (parent != null) {
            parent.removeChild(this);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove an attribute from this element.
     * </p>
     * 
     * @param attributeName An attribute to remove.
     * @return A chainable API.
     */
    public Element remove(String name) {
        removeAttribute(String.valueOf(name));

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a class from this element.
     * </p>
     * 
     * @param className A class name to be removed from the class attribute of this element.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS> className) {
        classList.remove(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a single class, multiple classes, or all classes from this element.
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
     * <p>
     * Get the combined text contents of this element, including its descendants.
     * </p>
     * 
     * @return A text contents.
     */
    public String text() {
        return textContent();
    }

    /**
     * <p>
     * Set the content of this element.
     * </p>
     * 
     * @param text A text to set.
     * @return Chainable API.
     */
    public Element text(Object text) {
        textContent(String.valueOf(text));

        // API definition
        return this;
    }

    /**
     * <p>
     * Returns the DOM node's parent Element, or null if the node either has no parent, or its
     * parent isn't a DOM Element.
     * </p>
     * 
     * @return The parent element.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element parentElement();

    /**
     * <p>
     * Returns the first child that is an element, and null otherwise.
     * </p>
     * 
     * @return The first child that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element firstElementChild();

    /**
     * <p>
     * Returns the last child that is an element, and null otherwise.
     * </p>
     * 
     * @return The last child that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element lastElementChild();

    /**
     * <p>
     * Returns the first preceding sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first preceding sibling that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element previousElementSibling();

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element nextElementSibling();

    /**
     * {@inheritDoc}
     */
    protected native String getAttribute(String name);

    /**
     * {@inheritDoc}
     */
    protected native void setAttribute(String name, String value);

    /**
     * {@inheritDoc}
     */
    protected native void setAttributeNS(String namespace, String name, String value);

    /**
     * {@inheritDoc}
     */
    protected native void removeAttribute(String name);

    /**
     * <p>
     * Returns the first element that is a descendent of the element on which it is invoked that
     * matches the specified group of selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    @JavascriptNativeProperty
    protected final native Element querySelector(String selector);

    /**
     * <p>
     * Returns a non-live NodeList of all elements descended from the element on which it is invoked
     * that match the specified group of CSS selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    @JavascriptNativeProperty
    protected final native NodeList<Element> querySelectorAll(String selector);

    /**
     * <p>
     * Returns true if the element would be selected by the specified selector; otherwise, returns
     * false.
     * </p>
     * 
     * @param selector A css selector.
     * @return A result.
     */
    @JavascriptNativeProperty
    protected final native boolean matchesSelector(String selector);

    /**
     * <p>
     * The scrollIntoView() method scrolls the element into view.
     * </p>
     */
    @JavascriptNativeProperty
    public final native void scrollIntoView();
}
