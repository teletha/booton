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

import js.dom.Element;
import booton.virtual.VirtualElement;
import booton.virtual.VirtualNode;
import booton.virtual.VirtualStructure;

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
     * @param box Domain Specific Language for virtual element.
     */
    protected abstract void virtualize(VirtualStructure box);

    /**
     * 
     */
    final VirtualElement virtualize() {
        VirtualStructure box = new VirtualStructure();
        virtualize(box);
        return box.getRoot();
    }

    /**
     * @param element
     */
    public void materialize(Element element) {

    }
}
