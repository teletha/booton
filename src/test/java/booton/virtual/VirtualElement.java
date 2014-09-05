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

import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import js.dom.Element;
import js.dom.Node;
import js.util.HashMap;

/**
 * @version 2014/09/04 23:22:40
 */
public class VirtualElement extends VirtualNode {

    /** The node name. */
    public final String name;

    /** The attributes. */
    public final Map<String, String> attributes;

    /** The children node. */
    public final List<VirtualNode> children;

    /**
     * @param tagName
     */
    public VirtualElement(String tagName) {
        this(tagName, new HashMap(), new ArrayList());
    }

    /**
     * @param string
     */
    public VirtualElement(String name, Map properties, List<VirtualNode> children) {
        this.name = name;
        this.attributes = properties;
        this.children = children;
    }

    /**
     * @param prev
     */
    public VirtualElement(VirtualElement copy) {
        this.name = copy.name;
        this.attributes = new HashMap(copy.attributes);
        this.children = new ArrayList(copy.children);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node createNode() {
        Element element = document.createElement(name);

        for (Entry<String, String> attribute : attributes.entrySet()) {
            element.attr(attribute.getKey(), attribute.getValue());
        }

        for (VirtualNode child : children) {
            element.append(child.createNode());
        }
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VirtualElement) {
            VirtualElement element = (VirtualElement) obj;

            return name.equals(element.name);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
