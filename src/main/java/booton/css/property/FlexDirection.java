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
public class FlexDirection extends CSSProperty<FlexDirection> {

    /**
     * @param name
     */
    public FlexDirection() {
        super("flex-direction");
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
        return chain(prefixName("row"));
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
        return chain(prefixName("row-reverse"));
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
        return chain(prefixName("column"));
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
        return chain(prefixName("column-reverse"));
    }
}
