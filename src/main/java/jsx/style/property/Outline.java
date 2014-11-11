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

import jsx.style.value.Color;
import jsx.style.value.Numeric;
import booton.css.Unit;

/**
 * @version 2014/11/11 21:45:28
 */
public class Outline extends Colorable<Outline> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Outline color(Color color) {
        return value("outline-color", color);
    }

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @return Chainable API.
     */
    public Outline width(Numeric size) {
        return value("outline-width", size);
    }

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @param unit A width unit to set.
     * @return Chainable API.
     */
    public final Outline width(double size, Unit unit) {
        return width(new Numeric(size, unit));
    }

    /**
     * <p>
     * Set the style of this border.
     * </p>
     * 
     * @param style A style to set.
     * @return Chainable API.
     */
    protected Outline style(String style) {
        return value("outline-style", style);
    }

    /**
     * <p>
     * Like for the hidden keyword, displays no border. In that case, except if a background image
     * is set, the calculated values of border-width will be 0, even if specified otherwise through
     * the property. In case of table cell and border collapsing, the none value has the lowest
     * priority: it means that if any other conflicting border is set, it will be displayed.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline none() {
        return style("none");
    }

    /**
     * <p>
     * Like for the none keyword, displays no border. In that case, except if a background image is
     * set, the calculated values of border-width will be 0, even if specified otherwise through the
     * property. In case of table cell and border collapsing, the hidden value has the highest
     * priority: it means that if any other conflicting border is set, it won't be displayed.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline hidden() {
        return style("hidden");
    }

    /**
     * <p>
     * Displays a series of rounded dots. The spacing of the dots are not defined by the
     * specification and are implementation-specific. The radius of the dots is half the calculated
     * border-width.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline dotted() {
        return style("dotted");
    }

    /**
     * <p>
     * Displays a series of short square-ended dashes or line segments. The exact size and length of
     * the segments are not defined by the specification and are implementation-specific.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline dashed() {
        return style("dashed");
    }

    /**
     * <p>
     * Displays a single, straight, solid line.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline solid() {
        return style("solid");
    }

    /**
     * <p>
     * Displays two straight lines that add up to the pixel amount defined as border-width .
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline doubles() {
        return style("double");
    }

    /**
     * <p>
     * Displays a border leading to a carved effect. It is the opposite of ridge.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline groove() {
        return style("groove");
    }

    /**
     * <p>
     * Displays a border with a 3D effect, like if it is coming out of the page. It is the opposite
     * of groove.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline ridge() {
        return style("ridge");
    }

    /**
     * <p>
     * Displays a border that makes the box appear embedded. It is the opposite of outset. When
     * applied to a table cell with border-collapse set to collapsed, this value behaves like
     * groove.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline inset() {
        return style("inset");
    }

    /**
     * <p>
     * Displays a border that makes the box appear in 3D, embossed. It is the opposite of inset.
     * When applied to a table cell with border-collapse set to collapsed, this value behaves like
     * ridge.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Outline outset() {
        return style("outset");
    }
}
