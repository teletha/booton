/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import js.lang.NativeArray;
import jsx.collection.DualList;

/**
 * @version 2015/08/20 12:39:20
 */
public class ContextualizedStyle implements Style {

    private final Style style;

    public final Object context;

    /**
     * @param style
     * @param context
     */
    ContextualizedStyle(Style style, Object context) {
        this.style = style;
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        style.declare();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object locator() {
        return style;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        style.assignTo(styles, inlines);
    }
}
