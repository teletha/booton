/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import static booton.css.Vendor.*;

import java.util.Arrays;

import booton.css.CSSProperty;
import booton.css.CSSWriter;
import booton.css.Unit;
import booton.css.value.Numeric;

/**
 * @version 2014/09/04 10:16:48
 */
public class FlexItem extends CSSProperty<FlexItem> {

    /** The basis size. */
    private Numeric basis;

    /** The grow factor. */
    private int grow;

    /** The shrink factor. */
    private int shrink = 1;

    /** The order. */
    private int order;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property("flex-basis", Arrays.asList(basis), Webkit);
        if (grow != 0) writer.property("flex-grow", Arrays.asList(grow), Webkit);
        if (shrink != 1) writer.property("flex-shrink", Arrays.asList(shrink), Webkit);
        if (order != 0) writer.property("order", Arrays.asList(order), Webkit);
    }

    /**
     * <p>
     * The CSS flex-grow property specifies the flex grow factor of a flex item.
     * </p>
     * 
     * @param ratio Negative values are invalid.
     * @return
     */
    public FlexItem basis(int size, Unit unit) {
        basis = new Numeric(size, unit);

        return chain();
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
        grow = factor;

        return chain();
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
        shrink = factor;

        return chain();
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
        this.order = order;

        return chain();
    }
}
