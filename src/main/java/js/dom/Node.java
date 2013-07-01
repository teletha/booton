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

import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * @version 2013/07/01 21:31:06
 */
public abstract class Node implements JavascriptNative {

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
    protected abstract <T> T appedChild(T newNode);

    /**
     * <p>
     * Inserts the specified node before a reference element as a child of the current node.
     * </p>
     * 
     * @param newNode The node to insert.
     * @param referenceNode The node before which newNode is inserted.
     * @return The node being inserted, that is newNode.
     */
    protected abstract <T> T insertBefore(T newNode, Object referenceNode);
}
