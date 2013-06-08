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

import booton.css.CSSProperty;
import booton.css.CSSWriter;
import booton.css.VendorPrefixCSSProperty;

/**
 * @version 2013/06/08 2:22:03
 */
public class AlignItems extends CSSProperty<AlignItems> {

    /** The actual value. */
    private VendorPrefixCSSProperty property;

    /**
     * @param name
     */
    public AlignItems() {
        super("align-items");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property(property);
    }

    /**
     * <p>
     * The cross-start margin edge of the flex item is flushed with the cross-start edge of the
     * line.
     * </p>
     * 
     * @return
     */
    public AlignItems start() {
        property = standard("flex-start").ie("box-align", "start");

        return chain();
    }

    /**
     * <p>
     * The cross-end margin edge of the flex item is flushed with the cross-end edge of the line.
     * </p>
     * 
     * @return
     */
    public AlignItems end() {
        property = standard("flex-end").ie("box-align", "end");

        return chain();
    }

    /**
     * <p>
     * The flex item's margin box is centered within the line on the cross-axis. If the cross-size
     * of the item is larger than the flex container, it will overflow equally in both directions.
     * </p>
     * 
     * @return
     */
    public AlignItems center() {
        return chain("center");
    }

    /**
     * <p>
     * All flex items are aligned such that their baselines align. The item with the largest
     * distance between its cross-start margin edge and its baseline is flushed with the cross-start
     * edge of the line.
     * </p>
     * 
     * @return
     */
    public AlignItems baseline() {
        return chain("baseline");
    }

    /**
     * <p>
     * Flex items are stretched such as the cross-size of the item's margin box is the same as the
     * line while respecting width and height constraints.
     * </p>
     * 
     * @return
     */
    public AlignItems stretch() {
        return chain("stretch");
    }
}
