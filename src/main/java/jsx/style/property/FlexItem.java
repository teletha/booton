/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import static jsx.style.Vendor.*;

import jsx.style.PropertyDefinition;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2014/10/29 11:01:22
 */
public class FlexItem extends PropertyDefinition<FlexItem> {

    /**
     * <p>
     * The align-self CSS property aligns flex items of the current flex line overriding the
     * align-items value. If any of the flex item's cross-axis margin is set to auto, then
     * align-self is ignored.
     * </p>
     */
    public final AlignSelf alignSelf = new AlignSelf();

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

    /**
     * @version 2013/07/22 11:33:09
     */
    public class AlignSelf extends PropertyDefinition<FlexItem> {

        /**
         * 
         */
        private AlignSelf() {
            super("align-self", FlexItem.this, Webkit);
        }

        /**
         * <p>
         * The cross-start margin edge of the flex item is flushed with the cross-start edge of the
         * line.
         * </p>
         * 
         * @return
         */
        public FlexItem start() {
            return value("flex-start");
        }

        /**
         * <p>
         * The cross-end margin edge of the flex item is flushed with the cross-end edge of the
         * line.
         * </p>
         * 
         * @return
         */
        public FlexItem end() {
            return value("flex-end");
        }

        /**
         * <p>
         * The flex item's margin box is centered within the line on the cross-axis. If the
         * cross-size of the item is larger than the flex container, it will overflow equally in
         * both directions.
         * </p>
         * 
         * @return
         */
        public FlexItem center() {
            return value("center");
        }

        /**
         * <p>
         * All flex items are aligned such that their baselines align. The item with the largest
         * distance between its cross-start margin edge and its baseline is flushed with the
         * cross-start edge of the line.
         * </p>
         * 
         * @return
         */
        public FlexItem baseline() {
            return value("baseline");
        }

        /**
         * <p>
         * Flex items are stretched such as the cross-size of the item's margin box is the same as
         * the line while respecting width and height constraints.
         * </p>
         * 
         * @return
         */
        public FlexItem stretch() {
            return value("stretch");
        }
    }
}
