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

import java.util.HashMap;
import java.util.Map;

import jsx.ui.Style;

/**
 * @version 2015/09/20 10:13:46
 */
class ValuedStyle<T> implements Style {

    /** The cache repository. */
    static final Map<Object, Style> cache = new HashMap();

    private final T value;

    private final ValueStyle base;

    final Style style;

    /**
     * @param value
     * @param style
     */
    ValuedStyle(T value, ValueStyle base, Style style) {
        this.value = value;
        this.base = base;
        this.style = style;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void style() {
        style.style();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object locator() {
        return base;
    }
}
