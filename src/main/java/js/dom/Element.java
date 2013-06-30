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

import org.w3c.dom.Node;

import booton.css.CSS;
import booton.translator.JavascriptNative;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/07/01 2:12:14
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

    /** Returns the child elements. */
    public HTMLCollection children;

    /** Returns the first preceding sibling that is an element, and null otherwise. */
    public Element previousElementSibling;

    /** Returns the first following sibling that is an element, and null otherwise. */
    public Element nextElementSibling;

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
     * Insert content, specified by the parameter, to the end of this element.
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
     * Insert content, specified by the parameter, to the end of this element.
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
    protected abstract void setAttributeNS(String namespace, String name, String value);

    /**
     * {@inheritDoc}
     */
    protected abstract void removeAttribute(String name);

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
     * <p>
     * The scrollIntoView() method scrolls the element into view.
     * </p>
     */
    public native void scrollIntoView();
}
