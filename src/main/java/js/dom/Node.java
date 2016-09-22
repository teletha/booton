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

import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.List;

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;
import jsx.style.Style;

/**
 * @version 2013/07/04 20:41:55
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "Node")
public abstract class Node<T extends Node<T>> extends EventTarget<T>implements JavascriptNative {

    /**
     * <p>
     * Insert content to the end of this element.
     * </p>
     * 
     * @param content DOM element to insert at the end of this element.
     * @return Chainable API.
     */
    public T append(Object content) {
        if (content != null) {
            appendChild(nodify(content));
        }

        // API definition
        return (T) this;
    }

    /**
     * <p>
     * Insert this element to the end of the target element.
     * </p>
     * 
     * @param target This element will be inserted at the end of the element specified by this
     *            parameter.
     * @return Chainable API.
     */
    public T appendTo(Node target) {
        if (target != null) {
            target.append(this);
        }

        // API definition
        return (T) this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, after this element.
     * </p>
     * 
     * @param content A content to insert.
     * @return Chainable API.
     */
    public T after(Object content) {
        if (content != null) {
            Node parent = parentNode();

            if (parent != null) {
                parent.insertBefore(nodify(content), nextSibling());
            }
        }

        // API definition
        return (T) this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, before this element.
     * </p>
     * 
     * @param content A content to insert.
     * @return Chainable API.
     */
    public T before(Object content) {
        if (content != null) {
            Node parent = parentNode();

            if (parent != null) {
                parent.insertBefore(nodify(content), this);
            }
        }

        // API definition
        return (T) this;
    }

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
    public Element child(Style className) {
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
    public Element child(String name, Style className) {
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
    public <U extends Elemental> U child(U ui) {
        appendChild(ui.getElement());

        return ui;
    }

    /**
     * <p>
     * Get the children of this node.
     * </p>
     * 
     * @return A list of child nodes.
     */
    public List<Node> childNodes() {
        List<Node> list = new ArrayList();
        Node node = firstChild();

        while (node != null) {
            list.add(node);

            node = node.nextSibling();
        }
        return list;
    }

    /**
     * <p>
     * Insert content to the begining of this element.
     * </p>
     * 
     * @param content DOM element to insert at the begining of this element.
     * @return Chainable API.
     */
    public T prepend(Object content) {
        if (content != null) {
            insertBefore(nodify(content), firstChild());
        }

        // API definition
        return (T) this;
    }

    /**
     * <p>
     * Replaces one child node of the specified element with another.
     * </p>
     * 
     * @param oldChild The existing child to be replaced.
     * @param newChild The new node to replace oldChild. If it already exists in the DOM, it is
     *            first removed. @return The replaced node. This is the same node as oldChild.
     * @return Chainable API.
     */
    public T replace(Node oldChild, Node newChild) {
        replaceChild(newChild, oldChild);
        return (T) this;
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
    public T text(Object text) {
        textContent(String.valueOf(text));

        // API definition
        return (T) this;
    }

    /**
     * <p>
     * Create {@link Node}.
     * </p>
     * 
     * @param content A content like {@link Element}, {@link String}.
     * @return
     */
    protected Node nodify(Object content) {
        if (content instanceof Node) {
            return (Node) content;
        } else if (content instanceof Elemental) {
            return ((Elemental) content).getElement();
        } else {
            return document.createTextNode(content.toString());
        }
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
    public abstract <N extends Node> N removeChild(N childNode);

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
    public abstract Node insertBefore(Node newNode, Node referenceNode);

    /**
     * <p>
     * Replaces one child node of the specified element with another.
     * </p>
     * 
     * @param newChild The new node to replace oldChild. If it already exists in the DOM, it is
     *            first removed.
     * @param oldChild The existing child to be replaced.
     * @return The replaced node. This is the same node as oldChild.
     */
    @JavascriptNativeProperty
    protected abstract Node replaceChild(Node newChild, Node oldChild);
}
