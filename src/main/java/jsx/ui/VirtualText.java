/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static js.lang.Global.*;
import js.dom.Text;

/**
 * @version 2014/09/04 23:22:51
 */
class VirtualText extends VirtualNode<Text> {

    /** The text content. */
    final String text;

    /**
     * <p>
     * Create text contents.
     * </p>
     * 
     * @param text
     */
    VirtualText(int id, String text) {
        super(id);

        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Text materialize() {
        return dom = document.createTextNode(text);
    }
}
