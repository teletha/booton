/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;
import js.lang.NativeCSSStyleSheetList;
import jsx.ui.Style;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Document} for web platform.
 * </p>
 * 
 * @version 2015/12/28 21:49:00
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "Document")
public abstract class Document extends Node implements JavascriptNative {

    /**
     * <p>
     * The Element that is the content area element of the document.
     * </p>
     * 
     * @return
     */
    public Element contentElement() {
        return getElementById("Content");
    }

    /**
     * <p>
     * The Element that is the header area element of the document.
     * </p>
     * 
     * @return
     */
    public Element headerElement() {
        return getElementById("Header");
    }

    /**
     * <p>
     * The Element that is the fotter area element of the document.
     * </p>
     * 
     * @return
     */
    public Element footerElement() {
        return getElementById("Footer");
    }

    /**
     * <p>
     * The Element that is the root element of the document (for example, the <html> element for
     * HTML documents).
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native Element documentElement();

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
     * Creates a new Text node.
     * </p>
     * 
     * @param text A string containing the data to be put in the text node.
     * @return A text node.
     */
    public native Text createTextNode(String text);

    /**
     * {@inheritDoc}
     */
    public native Element createElement(String name);

    /**
     * {@inheritDoc}
     */
    public native Element createElementNS(String namespaceURI, String qualifiedName);

    /**
     * {@inheritDoc}
     */
    public native SVGElement createSVGElement(String name);

    /**
     * <p>
     * Creates an event of the type specified. The returned object should be first initialized and
     * can then be passed to element.dispatchEvent.
     * </p>
     * 
     * @param type A string that represents the type of event to be created. Possible event types
     *            include "UIEvents", "MouseEvents", "MutationEvents", and "HTMLEvents".
     * @return The created Event object.
     */
    public native UIEvent createEvent(String type);

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
    public native NodeList<Element> getElementsByClassName(Style className);

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
    public native NodeList<Element> getElementsByTagName(String tagName);

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
    public native Element getElementById(String id);

    /**
     * <p>
     * Returns {@link NativeCSSStyleSheetList} for stylesheets explicitly linked into or embedded in
     * a document.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native NativeCSSStyleSheetList styleSheets();
}
