/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 2013/06/30 12:21:46
 */
public class EmulateElement extends Element {

    /** The attribute holder. */
    private final Map<String, String> attributes = new HashMap();

    /** The child nodes holder. */
    private final List<Node> children = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getAttribute(String name) {
        return attributes.get(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttribute(String name, String value) {
        attributes.put(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeAttribute(String name) {
        attributes.remove(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node appedChild(Node child) {
        if (child != null) {
            children.add(child);
        }
        return null;
    }
}
