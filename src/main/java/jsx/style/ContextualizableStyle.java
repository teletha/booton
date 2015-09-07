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
import jsx.ui.WidgetLog;

/**
 * @version 2015/05/27 18:12:21
 */
public class ContextualizableStyle<T> implements Style {

    private final ValueStyle base;

    private final Style style;

    /**
     * @param value
     * @param style
     */
    public ContextualizableStyle(T value, ValueStyle base, Style style) {
        this.base = base;
        this.style = style;
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
        return base;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        WidgetLog.InlineStyleWithContext.start();
        StyleRule style = new StyleRule(inlines);

        // swap context rule and execute it
        PropertyDefinition.properties = style;
        declare();
        PropertyDefinition.properties = null;
        WidgetLog.InlineStyleWithContext.stop();
    }
}
