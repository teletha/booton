/*
 * Copyright (C) 2012 Nameless Production Committee
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
import booton.css.Unit;
import booton.css.value.Value;

/**
 * @version 2012/12/16 16:15:46
 */
public class Line extends CSSProperty<Line> {

    /** The line-height property. */
    private String height;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property("line-height", height);
    }

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(double size) {
        height = String.valueOf(size);

        return chain();
    }

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(Value size) {
        height = size.toString();

        return chain();
    }

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(double size, Unit unit) {
        height = new Value(size, unit).toString();

        return chain();
    }
}
