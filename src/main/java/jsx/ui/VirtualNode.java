/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.dom.Node;
import kiss.Disposable;

/**
 * <p>
 * {@link VirtualNode} is a snapshot of the {@link Widget} state which includes its tree structure.
 * </p>
 * 
 * @version 2014/09/04 23:21:40
 */
abstract class VirtualNode<N extends Node> implements Disposable {

    /**
     * <p>
     * The real DOM node.
     * </p>
     * <p>
     * To tell the truth, we DON'T want Virtual DOM to have Real DOM. However, if virtual DOM don't
     * have it, a patch will scan or search the position of Real DOM by any index or ID information
     * at every time to apply a diff patch. Its cost is slightly expensive than this way.
     * </p>
     * <p>
     * Only the latest Virtual DOM has the Real DOM, and other Virtual DOM discards its reference
     * immediately.
     * </p>
     */
    public N dom;

    /** The node identifier. */
    public final int id;

    /**
     * 
     */
    VirtualNode(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Create actual DOM {@link Node}.
     * </p>
     * 
     * @return A created node.
     */
    abstract N materialize();

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        dom = null;
    }
}
