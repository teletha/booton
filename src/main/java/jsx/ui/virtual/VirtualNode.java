/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import js.dom.Node;

/**
 * @version 2014/09/04 23:21:40
 */
public abstract class VirtualNode<D extends Node> implements Materializer<D> {

    /** The real DOM node. */
    public D dom;

    /** The node identifier. */
    public final int id;

    /**
     * 
     */
    protected VirtualNode(int id) {
        this.id = id;
    }
}
