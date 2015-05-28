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

/**
 * @version 2015/05/27 18:12:21
 */
public class ContextualizableStyle<T> implements Style {

    private final T value;

    private final ValueStyle base;

    private final Style style;

    /**
     * @param value
     * @param style
     */
    public ContextualizableStyle(T value, ValueStyle base, Style style) {
        this.value = value;
        this.base = base;
        this.style = style;
    }

    public T get() {
        return value;
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

    public ValueStyle style() {
        return base;
    }
}
