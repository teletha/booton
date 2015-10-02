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

import jsx.ui.Locatable;
import jsx.ui.Style;

/**
 * <p>
 * {@link Style} with the context value.
 * </p>
 * 
 * @version 2015/09/29 10:16:23
 */
class ValuedStyle<V> implements Style {

    /** The cache repository. */
    static final Map<Object, Style> cache = new HashMap();

    /** The original {@link ValueStyle}. */
    private final ValueStyle<V> base;

    /** The context value. */
    private final V value;

    /**
     * <p>
     * Create {@link Style} with the context value.
     * </p>
     * 
     * @param base A original style.
     * @param value A context value.
     */
    ValuedStyle(ValueStyle<V> base, V value) {
        this.value = value;
        this.base = base;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void style() {
        base.style(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Locatable locator() {
        return base;
    }
}
