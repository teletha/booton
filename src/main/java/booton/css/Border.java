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
public class Border extends Color<Border> {

    /** The line width. */
    private String width;

    /** The line style. */
    private String style;

    /** The line radius. */
    private Value radius;

    /**
     * @param css
     */
    protected Border(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property(name, width, style, color == null ? "transparent" : color.toString()) + property("border-radius", radius);
    }

    /**
     * <p>
     * The border-radius CSS property allows Web authors to define how rounded border corners are.
     * The curve of each corner is defined using one or two radii, defining its shape: circle or
     * ellipse.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Border radius(double size, Unit unit) {
        radius = new Value(size, unit);

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
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

        return chain();
    }
}
