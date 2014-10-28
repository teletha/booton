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

/**
 * @version 2014/10/28 16:22:27
 */
public class Visibility extends PropertyDefinition<Visibility> {

    /**
     * <p>
     * Default value, the box is visible.
     * </p>
     * 
     * @return
     */
    public Visibility visible() {
        return value("visible");
    }

    /**
     * <p>
     * The box is invisible (fully transparent, nothing is drawn), but still affects layout.
     * Descendants of the element will be visible if they have visibility:visible (this doesn't work
     * in IE up to version 7).
     * </p>
     * 
     * @return
     */
    public Visibility hidden() {
        return value("hidden");
    }

    /**
     * <p>
     * For table rows, columns, column groups, and row groups the row(s) or column(s) are hidden and
     * the space they would have occupied is (as if display: none were applied to the column/row of
     * the table). However, the size of other rows and columns is still calculated as though the
     * cells in the collapsed row(s) or column(s) are present. This was designed for fast removal of
     * a row/column from a table without having to recalculate widths and heights for every portion
     * of the table. For XUL elements, the computed size of the element is always zero, regardless
     * of other styles that would normally affect the size, although margins still take effect. For
     * other elements, collapse is treated the same as hidden.
     * </p>
     * 
     * @return
     */
    public Visibility collapse() {
        return value("collapse");
    }
}
