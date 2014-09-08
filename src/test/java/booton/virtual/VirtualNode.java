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

import js.dom.Node;

/**
 * @version 2014/09/04 23:21:40
 */
public abstract class VirtualNode<N extends Node> {

    public N dom;

    /** The node identifier. */
    public final int id;

    /**
     * 
     */
    protected VirtualNode(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Create actual DOM {@link Node}.
     * </p>
     * 
     * @return A created node.
     */
    public abstract Node createNode();
}
