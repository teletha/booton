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
import js.dom.CSSStyleDeclaration;
import js.dom.Element;
import js.lang.NativeArray;
import jsx.collection.DualList;
import jsx.style.Style;

/**
 * @version 2014/10/07 12:49:29
 */
class VirtualElement extends VirtualFragment<Element> {

    /** The node name. */
    final String name;

    /** The attributes. */
    final DualList<String, String> attributes = new DualList();

    /** The class attributes. */
    final NativeArray<Style> classList = new NativeArray();

    /** The The inline styles. */
    final DualList<String, String> inlines = new DualList();

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
        for (int i = 0; i < attributes.size(); i++) {
            dom.attr(attributes.key(i), attributes.value(i));
        }

        // assign classes
        for (int i = 0; i < classList.length(); i++) {
            classList.get(i).applyTo(dom);
        }

        // assign inline style
        int size = inlines.size();

        if (size != 0) {
            CSSStyleDeclaration style = dom.style();

            for (int i = 0; i < size; i++) {
                style.set(inlines.key(i), inlines.value(i));
            }
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
        this.attributes.add(name, value);

        return attributes.size() - 1;
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
    private static String format(VirtualElement element, int indentSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(element.name);

        for (int i = 0; i < element.attributes.size(); i++) {
            builder.append(" ")
                    .append(element.attributes.key(i))
                    .append("=\"")
                    .append(element.attributes.value(i))
                    .append("\"");
        }

        if (element.classList.length() != 0) {
            builder.append(" class=\"");

            for (int i = 0; i < element.classList.length(); i++) {
                builder.append(element.classList.get(i).intern()).append(" ");
            }
            builder.append("\"");
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
    private static String indent(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }
}
