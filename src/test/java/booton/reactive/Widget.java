/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.List;

import js.dom.Node;
import booton.virtual.Diff;
import booton.virtual.Patch;
import booton.virtual.VirtualElement;
import booton.virtual.VirtualNode;

/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Widget<V> {

    protected V context;

    /** The current associated virtual element. */
    private VirtualNode current;

    /**
     * <p>
     * Create virtual element.
     * </p>
     * 
     * @param $ Domain Specific Language for virtual element.
     */
    protected abstract void virtualize(VirtualStructure $);

    /**
     * 
     */
    final VirtualElement virtualize() {
        return null;
    }

    /**
     * @param node
     */
    public void materialize(Node node) {
        VirtualNode newly = virtualize();
        List<Patch> patches = Diff.diff(current, newly);

        if (!patches.isEmpty()) {

        }
    }
}
