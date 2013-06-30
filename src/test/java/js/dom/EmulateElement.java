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
import java.util.List;

import org.xml.sax.helpers.AttributesImpl;

/**
 * @version 2013/06/30 12:21:46
 */
public class EmulateElement extends Element {

    /** The attribute holder. */
    private final AttributesImpl attributes = new AttributesImpl();

    /** The child nodes. */
    private final List childNodes = new ArrayList();

    /**
     * 
     */
    public EmulateElement() {
        this.children = new EmulateHTMLCollection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getAttribute(String name) {
        return attributes.getValue(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttribute(String name, String value) {
        attributes.addAttribute("", name, name, "", value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttributeNS(String namespace, String name, String value) {
        name = String.valueOf(name);

        attributes.addAttribute(namespace, name, name, "", value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeAttribute(String name) {
        attributes.removeAttribute(attributes.getIndex(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node appedChild(Object child) {
        if (child != null) {
            childNodes().add(child);
        }
        return null;
    }

    /**
     * <p>
     * Helper method to {@link EmulateHTMLCollection} for child elements.
     * </p>
     * 
     * @return
     */
    private EmulateHTMLCollection childNodes() {
        return (EmulateHTMLCollection) children;
    }
}
