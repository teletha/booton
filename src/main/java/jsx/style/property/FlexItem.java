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

import jsx.style.PropertyDefinition;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2014/10/29 11:01:22
 */
public class FlexItem extends PropertyDefinition<FlexItem> {

    /**
     * <p>
     * The CSS flex-grow property specifies the flex grow factor of a flex item.
     * </p>
     * 
     * @param ratio Negative values are invalid.
     * @return
     */
    public FlexItem basis(int size, Unit unit) {
        Numeric numeric = new Numeric(size, unit);
        value("flex-basis", numeric);
        value("-webkit-flex-basis", numeric);

        return this;
    }

    /**
     * <p>
     * The CSS flex-grow property specifies the flex grow factor of a flex item.
     * </p>
     * 
     * @param ratio Negative values are invalid.
     * @return
     */
    public FlexItem grow(int factor) {
        value("flex-grow", factor);
        value("-webkit-flex-grow", factor);

        return this;
    }

    /**
     * <p>
     * The CSS flex-shrink property specifies the flex shrink factor of a flex item.
     * </p>
     * 
     * @param ratio Negative values are invalid.
     * @return
     */
    public FlexItem shrink(int factor) {
        value("flex-shrink", factor);
        value("-webkit-flex-shrink", factor);

        return this;
    }

    /**
     * <p>
     * The CSS order property specifies the order used to lay out flex items in their flex
     * container. Elements are laid out by ascending order of the order value. Elements with the
     * same order value are laid out in the order they appear in the source code.
     * </p>
     * 
     * @param order Represents the ordinal group the flex item has been assigned.
     * @return
     */
    public FlexItem order(int order) {
        value("order", order);
        value("-webkit-order", order);

        return this;
    }
}
