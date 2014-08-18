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
import kiss.Manageable;
import kiss.Singleton;

import org.w3c.dom.DOMException;

/**
 * @version 2013/07/12 20:39:00
 */
@Manageable(lifestyle = Singleton.class)
class EmulateDocument extends Document {

    /** The root element. */
    private final EmulateElement root = new EmulateElement("html");

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Node node) {
        return root.contains(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Document ownerDocument() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node parentNode() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node firstChild() {
        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node lastChild() {
        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node previousSibling() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node nextSibling() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String textContent() {
        return root.textContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void textContent(String textContent) {
        throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "Document cannot be inserted at the specified point in the hierarchy.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node appendChild(Node newNode) {
        throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "Document cannot be inserted at the specified point in the hierarchy.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node removeChild(Node childNode) {
        throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "Document cannot be inserted at the specified point in the hierarchy.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node insertBefore(Node newNode, Node referenceNode) {
        throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "Document cannot be inserted at the specified point in the hierarchy.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element documentElement() {
        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element querySelector(String selector) {
        return super.querySelector(selector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeList<Element> querySelectorAll(String selector) {
        return new JavaNonLiveNodeList(I.xml(new JavaDocument(this)).find(selector));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(String selector) {
        return super.matches(selector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Text createTextNode(String text) {
        return new EmulateText(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element createElement(String name) {
        return new EmulateElement(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UIEvent createEvent(String type) {
        if (type.equals("UIEvent")) {
            return new EmulateEvent();
        }
        return super.createEvent(type);
    }

    /**
     * @version 2013/10/20 10:10:21
     */
    private static class EmulateEvent extends UIEvent {

        private boolean bubbles;

        private boolean cancelabe;

        /**
         * {@inheritDoc}
         */
        @Override
        public void initEvent(String type, boolean bubbles, boolean cancelable) {
            this.type = type;
            this.bubbles = bubbles;
            this.cancelabe = cancelable;
        }
    }
}
