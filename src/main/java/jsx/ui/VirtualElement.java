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
import jsx.style.Style;

/**
 * @version 2014/10/07 12:49:29
 */
class VirtualElement extends VirtualFragment<Element> {

    /** The node name. */
    final String name;

    /** The attributes. */
    final VirtualKVS<String, String> attributes = new VirtualKVS();

    /** The class attributes. */
    final NativeArray<Style> classList = new NativeArray();

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

        // assign attributes
        for (int i = 0; i < attributes.names.length(); i++) {
            dom.prop(attributes.names.get(i), attributes.values.get(i));
        }

        // assign classes
        for (int i = 0; i < classList.length(); i++) {
            dom.add(classList.get(i));
        }

        // assign event listeners
        dom.delegateTo(events);

        // API definition
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
    public void dispose() {
        super.dispose();

        events = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return format(this, 1);
    }

    /**
     * <p>
     * Create human-readable element structure.
     * </p>
     * 
     * @param element A target element to format.
     * @param indentSize A size of indent.
     * @return A string expression of human-readable element structure.
     */
    private String format(VirtualElement element, int indentSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(element.name);

        for (int i = 0; i < attributes.names.length(); i++) {
            builder.append(" ")
                    .append(attributes.names.get(i))
                    .append("=\"")
                    .append(attributes.values.get(i))
                    .append("\"");
        }

        boolean hasChild = element.items.length() != 0;

        if (hasChild) {
            builder.append(">");
        }

        for (int i = 0; i < element.items.length(); i++) {
            builder.append("\r\n").append(indent(indentSize));

            VirtualNode item = element.items.get(i);

            if (item instanceof VirtualElement) {
                builder.append(format((VirtualElement) item, indentSize + 1));
            } else {
                builder.append(item);
            }
        }

        if (hasChild) {
            builder.append("\r\n").append(indent(indentSize - 1)).append("</").append(element.name).append(">");
        } else {
            builder.append("/>");
        }
        return builder.toString();
    }

    /**
     * <p>
     * Compute indent expression.
     * </p>
     * 
     * @param size A size of indent.
     * @return A space expression for indent.
     */
    private String indent(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }
}
