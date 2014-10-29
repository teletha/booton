/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.value.Color;
import jsx.style.value.Numeric;

/**
 * @version 2014/10/29 10:00:44
 */
class BorderList extends Border {

    /** The descriptor set. */
    private Border[] descriptors;

    /**
     * 
     */
    BorderList() {
    }

    /**
     * <p>
     * Create descriptor set.
     * </p>
     * 
     * @param descriptors
     */
    final BorderList use(Border... descriptors) {
        this.descriptors = descriptors;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border radius(Numeric size) {
        for (Border descriptor : descriptors) {
            descriptor.radius(size);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border width(Numeric size) {
        for (Border descriptor : descriptors) {
            descriptor.width(size);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border color(Color color) {
        for (Border descriptor : descriptors) {
            descriptor.color(color);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Border style(String style) {
        for (Border descriptor : descriptors) {
            descriptor.style(style);
        }
        return this;
    }
}