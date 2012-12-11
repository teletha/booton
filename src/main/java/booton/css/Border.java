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
 * @version 2012/12/11 22:52:28
 */
public class Border extends CSSColor<Border> {

    /** The property name. */
    private String name;

    /** The line width. */
    private String width;

    /** The line color. */
    private String color;

    /** The line style. */
    private String style;

    /**
     * @param css
     */
    protected Border(CSS css, String name) {
        super(css);

        this.name = name;
    }

    /**
     * <p>
     * The xxx-width CSS property sets the width of the border of a box.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Border width(double size, Unit unit) {
        width = compute(size, unit);

        return this;
    }

    /**
     * <p>
     * Like for the hidden keyword, displays no border. In that case, except if a background image
     * is set, the calculated values of border-width will be 0, even if specified otherwise through
     * the property. In case of table cell and border collapsing, the none value has the lowest
     * priority: it means that if any other conflicting border is set, it will be displayed.
     * </p>
     * 
     * @return
     */
    public Border none() {
        style = "none";

        return this;
    }

    /**
     * <p>
     * Like for the none keyword, displays no border. In that case, except if a background image is
     * set, the calculated values of border-width will be 0, even if specified otherwise through the
     * property. In case of table cell and border collapsing, the hidden value has the highest
     * priority: it means that if any other conflicting border is set, it won't be displayed.
     * </p>
     * 
     * @return
     */
    public Border hidden() {
        style = "hidden";

        return this;
    }

    /**
     * <p>
     * Displays a series of rounded dots. The spacing of the dots are not defined by the
     * specification and are implementation-specific. The radius of the dots is half the calculated
     * border-width.
     * </p>
     * 
     * @return
     */
    public Border dotted() {
        style = "dotted";

        return this;
    }

    /**
     * <p>
     * Displays a series of short square-ended dashes or line segments. The exact size and length of
     * the segments are not defined by the specification and are implementation-specific.
     * </p>
     * 
     * @return
     */
    public Border dashed() {
        style = "dashed";

        return this;
    }

    /**
     * <p>
     * Displays a single, straight, solid line.
     * </p>
     * 
     * @return
     */
    public Border solid() {
        style = "solid";

        return this;
    }

    /**
     * <p>
     * Displays two straight lines that add up to the pixel amount defined as border-width .
     * </p>
     * 
     * @return
     */
    public Border doubles() {
        style = "double";

        return this;
    }

    /**
     * <p>
     * Displays a border leading to a carved effect. It is the opposite of ridge.
     * </p>
     * 
     * @return
     */
    public Border groove() {
        style = "groove";

        return this;
    }

    /**
     * <p>
     * Displays a border with a 3D effect, like if it is coming out of the page. It is the opposite
     * of groove.
     * </p>
     * 
     * @return
     */
    public Border ridge() {
        style = "ridge";

        return this;
    }

    /**
     * <p>
     * Displays a border that makes the box appear embedded. It is the opposite of outset. When
     * applied to a table cell with border-collapse set to collapsed, this value behaves like
     * groove.
     * </p>
     * 
     * @return
     */
    public Border inset() {
        style = "inset";

        return this;
    }

    /**
     * <p>
     * Displays a border that makes the box appear in 3D, embossed. It is the opposite of inset.
     * When applied to a table cell with border-collapse set to collapsed, this value behaves like
     * ridge.
     * </p>
     * 
     * @return
     */
    public Border outset() {
        style = "outset";

        return this;
    }
}
