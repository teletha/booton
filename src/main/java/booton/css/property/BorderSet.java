/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import java.util.ArrayList;
import java.util.List;

import booton.css.value.Color;
import booton.css.value.Value;

/**
 * @version 2013/07/22 16:16:51
 */
class BorderSet extends BorderDefinition {

    /** The descriptor set. */
    private final List<BorderDefinition> descriptors = new ArrayList();

    /**
     * <p>
     * Create descriptor set.
     * </p>
     * 
     * @param descriptors
     */
    protected final BorderSet add(BorderDefinition... descriptors) {
        for (BorderDefinition descriptor : descriptors) {
            this.descriptors.add(descriptor);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderDefinition radius(Value size) {
        for (BorderDefinition descriptor : descriptors) {
            descriptor.radius(size);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Value width() {
        return descriptors.get(0).width();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderDefinition width(Value size) {
        for (BorderDefinition descriptor : descriptors) {
            descriptor.width(size);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color color() {
        return descriptors.get(0).color();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderDefinition color(Color color) {
        for (BorderDefinition descriptor : descriptors) {
            descriptor.color(color);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderStyle style() {
        return descriptors.get(0).style();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BorderDefinition style(BorderStyle style) {
        for (BorderDefinition descriptor : descriptors) {
            descriptor.style(style);
        }
        return this;
    }
}