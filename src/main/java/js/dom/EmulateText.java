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

import kiss.I;

/**
 * @version 2013/07/01 21:30:14
 */
class EmulateText extends Text implements EmulateNodable {

    /** The text. */
    private String text;

    /** The parent element. */
    private EmulateElement parent;

    /**
     * @param contents
     */
    public EmulateText(Object contents) {
        this.text = String.valueOf(contents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParent(EmulateElement parent) {
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Node node) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Document ownerDocument() {
        return I.make(EmulateDocument.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node parentNode() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <T extends Node> T appendChild(T newNode) {
        throw new EmulateDOMError();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node removeChild(Node childNode) {
        throw new EmulateDOMError();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node insertBefore(Node newNode, Node referenceNode) {
        throw new EmulateDOMError();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node firstChild() {
        // API definition
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node lastChild() {
        // API definition
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node previousSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) - 1;
        return index < 0 ? null : parent.nodes.getNode(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node nextSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) + 1;
        return parent.nodes.size() <= index ? null : parent.nodes.getNode(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String textContent() {
        return text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void textContent(String textContent) {
        text = String.valueOf(textContent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return text;
    }
}
