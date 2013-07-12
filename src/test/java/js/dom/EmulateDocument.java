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
}
