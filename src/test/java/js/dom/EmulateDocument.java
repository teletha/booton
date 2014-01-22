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

import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2013/07/12 20:39:00
 */
@Manageable(lifestyle = Singleton.class)
public class EmulateDocument extends Document {

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
        return null;
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
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node lastChild() {
        return null;
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
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void textContent(String textContent) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node appendChild(Node newNode) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node removeChild(Node childNode) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node insertBefore(Node newNode, Node referenceNode) {
        return null;
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
