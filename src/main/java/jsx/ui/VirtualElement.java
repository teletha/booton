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

import static js.lang.Global.*;
import js.dom.Element;
import js.lang.NativeArray;
import jsx.event.Publishable;
import booton.css.CSS;

/**
 * @version 2014/09/04 23:22:40
 */
class VirtualElement extends VirtualFragment<Element> {

    /** The node name. */
    final String name;

    /** The attributes. */
    final VirtualKVS<String, String> attributes = new VirtualKVS();

    /** The class attributes. */
    final NativeArray<Class<? extends CSS>> classList = new NativeArray();

    Publishable<?> events;

    /**
     * @param string
     */
    VirtualElement(int id, String name) {
        super(id);

        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element materializeRoot() {
        dom = document.createElement(name);

        for (int i = 0; i < attributes.names.length(); i++) {
            dom.attr(attributes.names.get(i), attributes.values.get(i));
        }

        for (int i = 0; i < classList.length(); i++) {
            dom.add(classList.get(i));
        }

        if (events != null) {
            dom.delegateTo(events);
        }

        return dom;
    }
}
