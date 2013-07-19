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

/**
 * @version 2013/06/08 2:22:03
 */
public class AlignItems extends CSSProperty<AlignItems> {

    /**
     * @param name
     */
    public AlignItems() {
        super("align-items");
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
        return chain(prefixName("flex-start").ie("flex-align", "start"));
    }

    /**
     * <p>
     * The cross-end margin edge of the flex item is flushed with the cross-end edge of the line.
     * </p>
     * 
     * @return
     */
    public AlignItems end() {
        return chain(prefixName("flex-end").ie("flex-align", "end"));
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
        return chain(prefixName("center").ie("flex-align", "center"));
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
        return chain(prefixName("baseline").ie("flex-align", "baseline"));
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
        return chain(prefixName("stretch").ie("flex-align", "stretch"));
    }
}
