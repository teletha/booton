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

    /** The event listeners. */
    Publishable publishable;

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

        if (publishable != null) {
            dom.delegateTo(publishable);
        }

        return dom;
    }

    /**
     * Helper method to create attribute. For the sake of speed, this method does no checking for
     * name conflicts or well-formedness: such checks are the responsibility of the application.
     * 
     * @param name An attribute name.
     * @param value An attribute value;
     */
    int attribute(String name, String value) {
        this.attributes.names.push(name);
        this.attributes.values.push(value);

        return attributes.values.length() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return serialize(1, this);
    }

    private String serialize(int indent, VirtualElement e) {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(e.name);

        if (e.items.length() != 0) {
            builder.append(">");
        }

        for (int i = 0; i < e.items.length(); i++) {
            builder.append("\r\n").append(indent(indent));

            VirtualNode item = e.items.get(i);

            if (item instanceof VirtualElement) {
                builder.append(serialize(indent + 1, (VirtualElement) item));
            } else {
                builder.append(item);
            }
        }

        if (e.items.length() != 0) {
            builder.append("\r\n").append(indent(indent - 1)).append("</").append(e.name).append(">");
        } else {
            builder.append("/>");
        }

        return builder.toString();
    }

    private String indent(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append("  ");
        }

        return builder.toString();
    }
}
