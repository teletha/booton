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
import jsx.bwt.UI;
import booton.css.CSS;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * @version 2013/07/04 20:41:55
 */
@JavascriptAPIProvider
public abstract class Node<T extends Node<T>> extends EventTarget<T> implements JavascriptNative {

    /**
     * <p>
     * Create child element.
     * </p>
     * 
     * @param name A element name.
     * @return A created child element.
     */
    public Element child(String name) {
        return appendChild(document.createElement(name));
    }

    /**
     * <p>
     * Create a child element with the specified class.
     * </p>
     * 
     * @param className A class name of the new child element.
     * @return A created child element.
     */
    public Element child(Class<? extends CSS> className) {
        return child("span", className);
    }

    /**
     * <p>
     * Create a child element with the specified class.
     * </p>
     * 
     * @param className A class name of the new child element.
     * @return A created child element.
     */
    public Element child(String name, Class<? extends CSS> className) {
        return child(name).add(className);
    }

    /**
     * <p>
     * Create child user interface.
     * </p>
     * 
     * @param ui A child ui.
     * @return Chainable API.
     */
    public <U extends UI> U child(U ui) {
        appendChild(ui.root);

        return ui;
    }

    /**
     * <p>
     * Indicates whether a node is a descendant of a given node.
     * </p>
     * 
     * @param node The node that's being compared.
     * @return A result.
     */
    @JavascriptNativePropertyAccessor
    public abstract boolean contains(Node node);

    /**
     * <p>
     * The ownerDocument property returns the top-level document object for this node.
     * </p>
     * 
     * @return A top-level document.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Document ownerDocument();

    /**
     * <p>
     * Returns the parent of the specified node in the DOM tree.
     * </p>
     * 
     * @return The parent of the current node. The parent of an element is an Element node, a
     *         Document node, or a DocumentFragment node.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Node parentNode();

    /**
     * <p>
     * Return the first direct child node of an element, or null if this element has no child nodes.
     * </p>
     * 
     * @return The first direct child node of an element, or null if this element has no child
     *         nodes.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Node firstChild();

    /**
     * <p>
     * Return the last direct child node of an element, or null if this element has no child nodes.
     * </p>
     * 
     * @return The last direct child node of an element, or null if this element has no child nodes.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Node lastChild();

    /**
     * <p>
     * Returns the node immediately preceding the specified one in its parent's childNodes list,
     * null if the specified node is the first in that list.
     * </p>
     * 
     * @return The node immediately preceding the specified one in its parent's childNodes list,
     *         null if the specified node is the first in that list.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Node previousSibling();

    /**
     * <p>
     * Returns the node immediately following the specified one in its parent's childNodes list, or
     * null if the specified node is the last node in that list.
     * </p>
     * 
     * @return The node immediately following the specified one in its parent's childNodes list, or
     *         null if the specified node is the last node in that list.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Node nextSibling();

    /**
     * Get the textContent property of this {@link Node}.
     * 
     * @return The textContent property.
     */
    @JavascriptNativePropertyAccessor
    protected abstract String textContent();

    /**
     * Set the textContent property of this {@link Node}.
     * 
     * @param textContent The textContent value to set.
     */
    @JavascriptNativePropertyAccessor
    protected abstract void textContent(String textContent);

    /**
     * <p>
     * Adds a node to the end of the list of children of a specified parent node. If the node
     * already exists it is removed from current parent node, then added to new parent node.
     * </p>
     * 
     * @param newNode The node to append.
     * @return The node being appended, that is newElement.
     */
    @JavascriptNativeProperty
    protected abstract <N extends Node> N appendChild(N newNode);

    /**
     * <p>
     * Adds a node to the end of the list of children of a specified parent node. If the node
     * already exists it is removed from current parent node, then added to new parent node.
     * </p>
     * 
     * @param childNode The node to be removed.
     * @return The node being removed, that is child node.
     */
    @JavascriptNativeProperty
    protected abstract <N extends Node> N removeChild(N childNode);

    /**
     * <p>
     * Inserts the specified node before a reference element as a child of the current node.
     * </p>
     * 
     * @param newNode The node to insert.
     * @param referenceNode The node before which newNode is inserted.
     * @return The node being inserted, that is newNode.
     */
    @JavascriptNativeProperty
    protected abstract Node insertBefore(Node newNode, Node referenceNode);
}
