/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.style;

import js.dom.Element;
import jsx.style.Style;
import jsx.style.StyleName;

/**
 * @version 2014/12/13 15:06:41
 */
public class CompiledStyle implements RuntimeStyle {

    /** The style name. */
    private final String name;

    /**
     * @param name
     */
    CompiledStyle(Style style) {
        this.name = StyleName.name(style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply(Element dom) {
        // dom add class name
    }
}
