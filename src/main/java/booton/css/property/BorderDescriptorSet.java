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
class BorderDescriptorSet extends BorderDescriptor {

    /** The descriptor set. */
    private final List<BorderDescriptor> descriptors = new ArrayList();

    /**
     * <p>
     * Create descriptor set.
     * </p>
     * 
     * @param descriptors
     */
    protected final BorderDescriptorSet add(BorderDescriptor... descriptors) {
        for (BorderDescriptor descriptor : descriptors) {
            this.descriptors.add(descriptor);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Value width() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderDescriptor width(Value value) {
        for (BorderDescriptor descriptor : descriptors) {
            descriptor.width(value);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color color() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderDescriptor color(Color color) {
        for (BorderDescriptor descriptor : descriptors) {
            descriptor.color(color);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderStyle style() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BorderDescriptor style(BorderStyle style) {
        for (BorderDescriptor descriptor : descriptors) {
            descriptor.style(style);
        }
        return this;
    }
}