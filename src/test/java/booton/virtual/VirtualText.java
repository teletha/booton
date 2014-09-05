/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import static js.lang.Global.*;
import js.dom.Node;

/**
 * @version 2014/09/04 23:22:51
 */
public class VirtualText extends VirtualNode {

    /** The text content. */
    public final String text;

    /**
     * <p>
     * Create text contents.
     * </p>
     * 
     * @param text
     */
    public VirtualText(String text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node createNode() {
        return document.createTextNode(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VirtualText) {
            VirtualText node = (VirtualText) obj;

            return text.equals(node.text);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
