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

import static booton.css.Vendor.*;
import booton.css.CSSProperty;
import booton.css.CSSWriter;

/**
 * @version 2013/07/21 23:26:23
 */
public class FlexDirection extends CSSProperty<FlexDirection> {

    /** The safari property. */
    private String orient;

    /**
     * @param name
     */
    public FlexDirection() {
        super("flex-direction");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        super.write(writer);

        writer.property("-webkit-box-orient", orient);
    }

    /**
     * <p>
     * Initial value. Child elements are displayed in the same order that they are declared in the
     * source document, from left to right.
     * </p>
     * 
     * @return
     */
    public FlexDirection row() {
        orient = "horizontal";

        return chain(prefixName("row").safari("box-direction", "normal").omit(Mozilla));
    }

    /**
     * <p>
     * Child elements are displayed in the reverse order that they are declared in the source
     * document, from right to left.
     * </p>
     * 
     * @return
     */
    public FlexDirection rowReverse() {
        orient = "horizontal";

        return chain(prefixName("row-reverse").safari("box-direction", "reverse").omit(Mozilla));
    }

    /**
     * <p>
     * Child elements are displayed in the same order that they are declared in the source document,
     * from top to bottom.
     * </p>
     * 
     * @return
     */
    public FlexDirection column() {
        orient = "vertical";

        return chain(prefixName("column").safari("box-direction", "normal").omit(Mozilla));
    }

    /**
     * <p>
     * Child elements are displayed in the reverse order that they are declared in the source
     * document, from bottom to top.
     * </p>
     * 
     * @return
     */
    public FlexDirection columnReverse() {
        orient = "vertical";

        return chain(prefixName("column-reverse").safari("box-direction", "reverse").omit(Mozilla));
    }
}
