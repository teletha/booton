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

import static js.lang.Global.*;
import js.dom.Element;
import js.lang.NativeArray;
import booton.css.CSS;

/**
 * @version 2014/09/04 23:22:40
 */
public class VirtualElement extends VirtualNode<Element> {

    /** The node name. */
    public final String name;

    /** The attributes. */
    public final VirtualKVS attributes = new VirtualKVS();

    /** The class attributes. */
    public final NativeArray<Class<? extends CSS>> classList = new NativeArray();

    /** The children node. */
    public final VirtualNodeList children = new VirtualNodeList();

    /**
     * @param string
     */
    public VirtualElement(int id, String name) {
        super(id);

        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element materialize() {
        real = document.createElement(name);

        for (int i = 0; i < attributes.names.length(); i++) {
            real.attr(attributes.names.get(i), attributes.values.get(i));
        }

        for (int i = 0; i < classList.length(); i++) {
            real.add(classList.get(i));
        }

        for (int i = 0; i < children.items.length(); i++) {
            real.append(children.items.get(i).materialize());
        }
        return real;
    }
}
