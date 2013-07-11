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

import js.util.Color;

/**
 * @version 2012/12/11 22:52:28
 */
public class BorderValue extends CSSProperty<BorderValue> implements Colorable<BorderValue> {

    /** The border color. */
    public final ColorValue<BorderValue> color = new ColorValue(name + "-color", this);

    /** The line width. */
    private Value width;

    /** The line style. */
    private String style;

    /** The radius size. */
    private Value topLeft;

    /** The radius size. */
    private Value topRight;

    /** The radius size. */
    private Value bottomLeft;

    /** The radius size. */
    private Value bottomRight;

    /**
     * @param css
     */
    protected BorderValue(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        super.write(writer);

        writer.property(name + "-style", style);
        writer.property(name + "-width", width);
        writer.property("border-top-left-radius", topLeft);
        writer.property("border-top-right-radius", topRight);
        writer.property("border-bottom-left-radius", bottomLeft);
        writer.property("border-bottom-right-radius", bottomRight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderValue color(int red, int green, int blue) {
        return color.color(red, green, blue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderValue color(int red, int green, int blue, double alpha) {
        return color.color(red, green, blue, alpha);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BorderValue color(Color color) {
        return this.color.color(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color color() {
        return color.color;
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
    public BorderValue radius(double size, Unit unit) {
        return radius(size, unit, size, unit, size, unit, size, unit);
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
    public BorderValue radius(Value value) {
        return radius(value.size, value.unit);
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
    public BorderValue radius(double first, Unit firstUnit, double second, Unit secondUnit, double third, Unit thirdUnit, double fourth, Unit fourthUnit) {
        switch (name) {
        case "border-top":
            topLeft = new Value(first, firstUnit);
            topRight = new Value(second, secondUnit);
            break;

        case "border-right":
            topRight = new Value(second, secondUnit);
            bottomRight = new Value(third, thirdUnit);
            break;

        case "border-bottom":
            bottomRight = new Value(third, thirdUnit);
            bottomLeft = new Value(fourth, fourthUnit);
            break;

        case "border-left":
            topLeft = new Value(first, firstUnit);
            bottomLeft = new Value(fourth, fourthUnit);
            break;

        default:
            topLeft = new Value(first, firstUnit);
            topRight = new Value(second, secondUnit);
            bottomRight = new Value(third, thirdUnit);
            bottomLeft = new Value(fourth, fourthUnit);
            break;
        }
        return chain();
    }

    /**
     * <p>
     * Current width property.
     * </p>
     * 
     * @return A current value.
     */
    public Value width() {
        return width == null ? Value.Zero : width;
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
    public BorderValue width(Value value) {
        width = value;

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
    public BorderValue width(double size, Unit unit) {
        width = new Value(size, unit);

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
    public BorderValue none() {
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
    public BorderValue hidden() {
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
    public BorderValue dotted() {
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
    public BorderValue dashed() {
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
    public BorderValue solid() {
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
    public BorderValue doubles() {
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
    public BorderValue groove() {
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
    public BorderValue ridge() {
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
    public BorderValue inset() {
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
    public BorderValue outset() {
        style = "outset";

        return chain();
    }
}
