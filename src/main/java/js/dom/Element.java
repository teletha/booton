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

import static js.dom.ElementStyle.*;
import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.List;

import js.lang.NativeObject;
import jsx.style.Style;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/07/30 19:05:51
 */
@JavascriptAPIProvider
public abstract class Element extends Node<Element> implements JavascriptNative {

    /**
     * <p>
     * Adds the specified class to this elements.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of this element.
     * @return Chainable API.
     */
    public Element add(Style className) {
        classList().add(className.intern());

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
    public Element add(Style... classes) {
        for (Style clazz : classes) {
            add(clazz);
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
        return getAttribute(name);
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
        setAttribute(name, value.toString());

        return this;
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
     * Get the value of a style property for this element.
     * </p>
     * 
     * @param property A CSS property.
     * @return
     */
    public String css(String property) {
        return window.getComputedStyle(this).get(property);
    }

    /**
     * <p>
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param name A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public Element css(String name, Object value) {
        style().set(name, String.valueOf(value));

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove all child nodes of this element from the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public Element empty() {
        for (Element child : getElementsByClassName(EventListenable)) {
            child.unsubscribe();
        }

        textContent("");

        // API definition
        return this;
    }

    /**
     * <p>
     * Determine whether any of this element is assigned the given class.
     * </p>
     * 
     * @param className The class name to search for.
     * @return A result
     */
    public boolean has(Style className) {
        return classList().contains(className.intern());
    }

    /**
     * <p>
     * Determine whether any of this element is assigned the given class.
     * </p>
     * 
     * @param classes A list of class names to check.
     * @return A result.
     */
    public boolean has(Style... classes) {
        for (Style clazz : classes) {
            if (!has(clazz)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Create child {@link Image} element.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of each matched element.
     * @return A created image.
     */
    public Image image(Style className) {
        return new Image(this, className);
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
     * Get the current coordinates of this element, relative to the owner document.
     * </p>
     */
    public ClientRect position() {
        return getBoundingClientRect();
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
     * Get property for this element.
     * </p>
     * 
     * @param name An property name.
     * @return A chainable API.
     */
    public String prop(String name) {
        return String.valueOf(((NativeObject) (Object) this).getProperty(name));
    }

    /**
     * <p>
     * Set property for this element.
     * </p>
     * 
     * @param name An property name.
     * @param value An property value.
     * @return A chainable API.
     */
    public Element prop(String name, Object value) {
        ((NativeObject) (Object) this).setProperty(name, value);

        return this;
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
        for (Element child : getElementsByClassName(EventListenable)) {
            child.unsubscribe();
        }
        unsubscribe();

        // parent node exist surely
        Node parent = parent();

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
        removeAttribute(name);

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
    public Element remove(Style className) {
        classList().remove(className.intern());

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
    public Element remove(Style... classes) {
        for (Style clazz : classes) {
            remove(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Add or remove class from this element, depending on either the class's presence or the value
     * of the switch argument.
     * </p>
     * 
     * @param className A class name to be toggled for this element.
     * @return Chainable API.
     */
    public Element toggle(Style className) {
        classList().toggle(className.intern());

        // API definition
        return this;
    }

    /**
     * <p>
     * Add or remove one or more classes from this element, depending on either the class's presence
     * or the value of the switch argument.
     * </p>
     * 
     * @param classes A list of class names to add or remove.
     * @return Chainable API.
     */
    public Element toggle(Style... classes) {
        for (Style clazz : classes) {
            classList().toggle(clazz.intern());
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the current value of this element.
     * </p>
     * <p>
     * The .val() method is primarily used to get the values of form elements such as input, select
     * and textarea. In the case of <select multiple="multiple"> elements, the .val() method returns
     * an array containing each selected option; if no option is selected, it returns null.
     * </p>
     * 
     * @return
     */
    public String val() {
        return value();
    }

    /**
     * <p>
     * Set the value of this element.
     * </p>
     * <p>
     * The .val() method is primarily used to get the values of form elements such as input, select
     * and textarea. In the case of <select multiple="multiple"> elements, the .val() method returns
     * an array containing each selected option; if no option is selected, it returns null.
     * </p>
     * 
     * @param value A string of text or an array of strings corresponding to the value of each
     *            matched element to set as selected/checked.
     * @return Chainable API.
     */
    public Element val(Object value) {
        value(value.toString());

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void startListening(Object type) {
        super.startListening(type);

        if (type == Object.class) {
            add(EventListenable);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void stopListening(Object type) {
        super.stopListening(type);

        if (type == Object.class) {
            remove(EventListenable);
        }
    }

    /**
     * <p>
     * A collection of all attribute nodes registered to the specified node.
     * </p>
     */
    @JavascriptNativePropertyAccessor
    protected abstract Attributes attributes();

    /**
     * <p>
     * A reference to the object which is the closest (nearest in the containment hierarchy)
     * positioned containing element. If the element is non-positioned, the nearest table cell or
     * root element (html in standards compliant mode; body in quirks rendering mode) is the
     * offsetParent. offsetParent returns null when the element has style.display set to "none". The
     * offsetParent is useful because offsetTop and offsetLeft are relative to its padding edge.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected native Element offsetParent();

    /**
     * <p>
     * Returns an object that represents the element's style attribute.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected native CSSStyleDeclaration style();

    @JavascriptNativePropertyAccessor
    protected abstract String value();

    @JavascriptNativePropertyAccessor
    protected abstract void value(String value);

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
    @JavascriptNativePropertyAccessor
    protected abstract String tagName();

    /**
     * <p>
     * Returns a token list of the class attribute of the element.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor()
    protected abstract DOMTokenList classList();

    /**
     * <p>
     * Returns the DOM node's parent Element, or null if the node either has no parent, or its
     * parent isn't a DOM Element.
     * </p>
     * 
     * @return The parent element.
     */
    @JavascriptNativePropertyAccessor("children")
    protected abstract HTMLCollection childElements();

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
     * <p>
     * Indicates whether a node is a descendant of a given node.
     * </p>
     * 
     * @param target The node that's being compared against.
     * @return Return true if target is a descendant of this element, or element itself. Otherwise
     *         false.
     */
    protected native boolean contains(Element target);

    /**
     * <p>
     * Returns the string value of the attribute with the specified name. If the named attribute
     * does not exist, the value returned will either be null.
     * </p>
     * 
     * @param name The name of the attribute to look for.
     * @return The string value of the specified attribute. If the attribute doesn't exist, the
     *         result is null.
     */
    protected native String getAttribute(String name);

    /**
     * <p>
     * Returns the string value of the attribute with the specified namespace and name. If the named
     * attribute does not exist, the value returned will either be null.
     * </p>
     * 
     * @param namespaces The namespace in which to look for the specified attribute.
     * @param name The name of the attribute to look for.
     * @return The string value of the specified attribute. If the attribute doesn't exist, the
     *         result is null.
     */
    protected native String getAttributeNS(String namespaces, String name);

    /**
     * <p>
     * Adds a new attribute or changes the value of an attribute with the given name.
     * </p>
     * 
     * @param name A string identifying the attribute to be set.
     * @param value The desired string value of the new attribute.
     */
    protected native void setAttribute(String name, String value);

    /**
     * <p>
     * Adds a new attribute or changes the value of an attribute with the given namespace and name.
     * </p>
     * 
     * @param namespace A string specifying the namespace of the attribute.
     * @param name A string identifying the attribute to be set.
     * @param value The desired string value of the new attribute.
     */
    protected native void setAttributeNS(String namespace, String name, String value);

    /**
     * <p>
     * Removes the specified attribute from an element.
     * </p>
     * 
     * @param name A string that names the attribute to be removed from the current node.
     */
    protected native void removeAttribute(String name);

    /**
     * <p>
     * Removes the specified attribute from an element.
     * </p>
     * 
     * @param namespace A string that contains the namespace of the attribute.
     * @param name A string that names the attribute to be removed from the current node.
     */
    protected native void removeAttributeNS(String namespace, String name);

    /**
     * <p>
     * Returns a boolean value indicating whether the current element has the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute.
     * @return A result.
     */
    protected native boolean hasAttribute(String name);

    /**
     * <p>
     * Returns a boolean value indicating whether the current element has the specified attribute.
     * </p>
     * 
     * @param namespace A string specifying the namespace of the attribute.
     * @param name The name of the attribute.
     * @return A result.
     */
    protected native boolean hasAttributeNS(String namespace, String name);

    /**
     * <p>
     * Returns a text rectangle object that encloses a group of text rectangles.
     * </p>
     * 
     * @return
     */
    protected native ClientRect getBoundingClientRect();

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
    @JavascriptNativeProperty
    public native NodeList<Element> querySelectorAll(String selector);

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
    public native boolean matches(String selector);

    /**
     * <p>
     * Returns a set of elements which have all the given class names. When called on the document
     * object, the complete document is searched, including the root node. You may also call
     * getElementsByClassName on any element; it will return only elements which are descendants of
     * the specified root element with the given class names.
     * </p>
     * 
     * @param className A class name.
     * @return A HTMLCollection of found elements.
     */
    @JavascriptNativeProperty
    public abstract NodeList<Element> getElementsByClassName(Style className);

    /**
     * <p>
     * Returns a HTMLCollection of elements with the given tag name. The complete document is
     * searched, including the root node. The returned HTMLCollection is live, meaning that it
     * updates itself automatically to stay in sync with the DOM tree without having to call
     * document.getElementsByTagName again.
     * </p>
     * 
     * @param tagName A string representing the name of the elements. The special string "*"
     *            represents all elements.
     * @return A live HTMLCollection (but see the note below) of found elements in the order they
     *         appear in the tree.
     */
    @JavascriptNativeProperty
    public final native NodeList<Element> getElementsByTagName(String tagName);

    /**
     * <p>
     * Returns a reference to the element by its ID.
     * </p>
     * 
     * @param id A case-sensitive string representing the unique ID of the element being sought.
     * @return A reference to an Element object, or null if an element with the specified ID is not
     *         in the document.
     */
    @JavascriptNativeProperty
    public final native Element getElementById(String id);

    /**
     * <p>
     * The scrollIntoView() method scrolls the element into view.
     * </p>
     */
    @JavascriptNativeProperty
    public final native void scrollIntoView();
}
