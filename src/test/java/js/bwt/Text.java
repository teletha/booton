/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import js.dom.Element;

/**
 * @version 2013/02/03 14:57:09
 */
public class Text extends Widget<String> {

    /** The actual element. */
    private Element element;

    public Text text(String text) {
        bind(text);

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(String value) {
        element.text(value);
    }

}
