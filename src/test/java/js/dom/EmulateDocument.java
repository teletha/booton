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

/**
 * @version 2013/07/12 20:39:00
 */
public class EmulateDocument extends Document {

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
    public Event createEvent(String type) {
        if (type.equals("UIEvent")) {
            return new EmulateEvent();
        }
        return super.createEvent(type);
    }

    /**
     * @version 2013/10/20 10:10:21
     */
    private static class EmulateEvent extends Event {

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
