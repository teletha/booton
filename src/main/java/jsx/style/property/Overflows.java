/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

/**
 * @version 2014/10/29 12:49:59
 */
public class Overflows extends Overflow {

    /**
     * <p>
     * The overflow-x CSS property specifies whether to clip content, render a scroll bar or display
     * overflow content of a block-level element, when it overflows at the left and right edges.
     * </p>
     * <p>
     * Using the overflow property with a value different than visible, its default, will create a
     * new block formatting context. This is technically necessary as if a float would intersect
     * with the scrolling element it would force to rewrap the content of the scrollable element
     * around intruding floats. The rewrap would happen after each scroll step and would be lead to
     * a far too slow scrolling experience. Note that, by programmatically setting scrollTop to the
     * relevant HTML element, even when overflow has the hidden value an element may need to scroll.
     * </p>
     */
    public final Overflow<Overflows> x = new Overflow("overflow-x", this);

    /**
     * <p>
     * The overflow-x CSS property specifies whether to clip content, render a scroll bar or display
     * overflow content of a block-level element, when it overflows at the left and right edges.
     * </p>
     * <p>
     * Using the overflow property with a value different than visible, its default, will create a
     * new block formatting context. This is technically necessary as if a float would intersect
     * with the scrolling element it would force to rewrap the content of the scrollable element
     * around intruding floats. The rewrap would happen after each scroll step and would be lead to
     * a far too slow scrolling experience. Note that, by programmatically setting scrollTop to the
     * relevant HTML element, even when overflow has the hidden value an element may need to scroll.
     * </p>
     */
    public final Overflow<Overflows> y = new Overflow("overflow-y", this);

    /**
     * <p>
     * Create property.
     * </p>
     * 
     * @param name A property name.
     */
    public Overflows() {
        super("overflow");
    }
}
