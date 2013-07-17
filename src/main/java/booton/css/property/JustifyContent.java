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
public class JustifyContent extends CSSProperty<JustifyContent> {

    /**
     * @param name
     */
    public JustifyContent() {
        super("justify-content");
    }

    /**
     * <p>
     * The flex items are packed starting from the main-start. Margins of the first flex item is
     * flushed with the main-start edge of the line and each following flex item is flushed with the
     * preceding.
     * </p>
     * 
     * @return
     */
    public JustifyContent start() {
        return chain(nameWithPrefix("flex-start").ie("flex-pack", "start"));
    }

    /**
     * <p>
     * The flex items are packed starting from the main-end. The margin edge of the last flex item
     * is flushed with the main-end edge of the line and each preceding flex item is flushed with
     * the following.
     * </p>
     * 
     * @return
     */
    public JustifyContent end() {
        return chain(nameWithPrefix("flex-end").ie("flex-pack", "end"));
    }

    /**
     * <p>
     * The flex items are packed toward the center of the line. The flex items are flushed with each
     * other and aligned in the center of the line. Space between the main-start edge of the line
     * and first item and between main-end and the last item of the line is the same.
     * </p>
     * 
     * @return
     */
    public JustifyContent center() {
        return chain(nameWithPrefix("center").ie("flex-pack", "center"));
    }

    /**
     * <p>
     * Flex items are evenly distributed along the line. The spacing is done such as the space
     * between two adjacent items is the same. Main-start edge and main-end edge are flushed with
     * respectively first and last flex item edges.
     * </p>
     * 
     * @return
     */
    public JustifyContent spaceBetween() {
        return chain(nameWithPrefix("space-between").ie("flex-pack", "justify"));
    }

    /**
     * <p>
     * Flex items are evenly distributed so that the space between two adjacent items is the same.
     * The empty space before the first and after the last items equals half of the space between
     * two adjacent items.
     * </p>
     * 
     * @return
     */
    public JustifyContent spaceAround() {
        return chain(nameWithPrefix("space-around").ie("flex-pack", "justify"));
    }
}
