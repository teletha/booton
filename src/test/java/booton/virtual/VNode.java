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

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @version 2014/08/28 22:42:38
 */
public class VNode {

    /** The element name. */
    public final String tagName;

    /** The properties. */
    public final Map properties;

    /** The children node. */
    public final List children;

    public VNode(String tagName) {
        this(tagName, Collections.EMPTY_MAP, Collections.EMPTY_LIST, "", "");
    }

    /**
     * @param string
     */
    public VNode(String tagName, Map properties, List children, String key, String namespace) {
        this.tagName = tagName;
        this.properties = properties;
        this.children = children;
    }

}
