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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import js.dom.Node;
import js.util.HashMap;

/**
 * @version 2014/08/28 22:42:38
 */
public class VNode {

    /** The element name. */
    public final String tagName;

    /** The attributes. */
    public final Map attributes;

    /** The children node. */
    public final List<VNode> children;

    /**
     * @param tagName
     */
    public VNode(String tagName) {
        this(tagName, Collections.EMPTY_MAP, Collections.EMPTY_LIST, "", "");
    }

    /**
     * @param string
     */
    public VNode(String tagName, Map properties, List<VNode> children, String key, String namespace) {
        this.tagName = tagName;
        this.attributes = properties;
        this.children = children;
    }

    /**
     * @param prev
     */
    public VNode(VNode copy) {
        this.tagName = copy.tagName;
        this.attributes = new HashMap(copy.attributes);
        this.children = new ArrayList(copy.children);
    }

    /**
     * @return
     */
    public Node createNode() {
        return null;
    }
}
