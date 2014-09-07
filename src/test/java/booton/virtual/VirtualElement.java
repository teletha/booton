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

    /** The associated key. */
    public final Object key;

    /** The attributes. */
    public final Map<String, String> attributes;

    /** The children node. */
    public final VirtualNodeList children;

    /**
     * 
     */
    public VirtualElement() {
        this("");
    }

    /**
     * @param tagName
     */
    public VirtualElement(String tagName) {
        this(tagName, new HashMap());
    }

    /**
     * @param string
     */
    public VirtualElement(String name, Map properties, VirtualNode... children) {
        this(name, null, properties, children);
    }

    /**
     * @param string
     */
    public VirtualElement(String name, Object key, Map properties, VirtualNode... children) {
        super(name, key);

        this.name = name;
        this.key = key;
        this.attributes = properties;
        this.children = new VirtualNodeList(children);
    }

    /**
     * @param prev
     */
    public VirtualElement(VirtualElement copy) {
        this.name = copy.name;
        this.key = copy.key;
        this.attributes = new HashMap(copy.attributes);
        this.children = copy.children;
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

        for (VirtualNode child : children.items) {
            element.append(child.createNode());
        }
        return element;
    }
}
