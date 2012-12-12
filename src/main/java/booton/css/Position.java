/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/12 10:12:14
 */
public class Position extends AbstractInheritable<Position> {

    /**
     * <p>
     * Lay out all elements as though the element were not positioned, and then adjust the element's
     * position, without changing layout (and thus leaving a gap for the element where it would have
     * been had it not been positioned). The effect of position:relative on table-*-group,
     * table-row, table-column, table-cell, and table-caption elements is undefined.
     * </p>
     * 
     * @return
     */
    public Position relative() {
        return chain("relative");
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * its closest positioned ancestor or to the containing block. Absolutely positioned boxes can
     * have margins, they do not collapse with any other margins.
     * </p>
     * 
     * @return
     */
    public Position absolute() {
        return chain("absolute");
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * the screen's viewport and doesn't move when scrolled. When printing, position it at that
     * fixed position on every page.
     * </p>
     * 
     * @return
     */
    public Position fixed() {
        return chain("fixed");
    }
}
