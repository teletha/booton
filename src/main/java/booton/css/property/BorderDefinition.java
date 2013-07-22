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
import booton.css.Unit;
import booton.css.value.Color;
import booton.css.value.Value;

/**
 * @version 2013/07/22 16:56:21
 */
public abstract class BorderDefinition<T extends BorderDefinition> extends CSSProperty<T> {

    /**
     * <p>
     * Set the radius of this border.
     * </p>
     * 
     * @param size A radius to set.
     * @return Chainable API.
     */
    public abstract T radius(Value size);

    /**
     * <p>
     * Set the radius of this border.
     * </p>
     * 
     * @param size A radius to set.
     * @param unit A width unit to set.
     * @return Chainable API.
     */
    public final T radius(double size, Unit unit) {
        return radius(new Value(size, unit));
    }

    /**
     * <p>
     * Return the widht of this border.
     * </p>
     * 
     * @return A border width.
     */
    public abstract Value width();

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @return Chainable API.
     */
    public abstract T width(Value size);

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @param unit A width unit to set.
     * @return Chainable API.
     */
    public final T width(double size, Unit unit) {
        return width(new Value(size, unit));
    }

    /**
     * <p>
     * Return the color of this border.
     * </p>
     * 
     * @return A border color.
     */
    public abstract Color color();

    /**
     * <p>
     * Set the color of this border.
     * </p>
     * 
     * @param color A color to set.
     * @return Chainable API.
     */
    public abstract T color(Color color);

    /**
     * <p>
     * Return the style of this border.
     * </p>
     * 
     * @return A border style.
     */
    public abstract BorderStyle style();

    /**
     * <p>
     * Set the style of this border.
     * </p>
     * 
     * @param style A style to set.
     * @return Chainable API.
     */
    protected abstract T style(BorderStyle style);

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
    public final T none() {
        return style(BorderStyle.None);
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
    public final T hidden() {
        return style(BorderStyle.Hidden);
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
    public final T dotted() {
        return style(BorderStyle.Dotted);
    }

    /**
     * <p>
     * Displays a series of short square-ended dashes or line segments. The exact size and length of
     * the segments are not defined by the specification and are implementation-specific.
     * </p>
     * 
     * @return Chainable API.
     */
    public final T dashed() {
        return style(BorderStyle.Dashed);
    }

    /**
     * <p>
     * Displays a single, straight, solid line.
     * </p>
     * 
     * @return Chainable API.
     */
    public final T solid() {
        return style(BorderStyle.Solid);
    }

    /**
     * <p>
     * Displays two straight lines that add up to the pixel amount defined as border-width .
     * </p>
     * 
     * @return Chainable API.
     */
    public final T doubles() {
        return style(BorderStyle.Doubles);
    }

    /**
     * <p>
     * Displays a border leading to a carved effect. It is the opposite of ridge.
     * </p>
     * 
     * @return Chainable API.
     */
    public final T groove() {
        return style(BorderStyle.Groove);
    }

    /**
     * <p>
     * Displays a border with a 3D effect, like if it is coming out of the page. It is the opposite
     * of groove.
     * </p>
     * 
     * @return Chainable API.
     */
    public final T ridge() {
        return style(BorderStyle.Ridge);
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
    public final T inset() {
        return style(BorderStyle.Inset);
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
    public final T outset() {
        return style(BorderStyle.Outset);
    }
}