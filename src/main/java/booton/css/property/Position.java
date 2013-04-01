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
import booton.css.Value;

/**
 * @version 2012/12/12 10:12:14
 */
public class Position extends CSSProperty<Position> {

    /** The position. */
    private Value top;

    /** The position. */
    private Value bottom;

    /** The position. */
    private Value left;

    /** The position. */
    private Value right;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        super.write(writer);

        writer.property("top", top);
        writer.property("bottom", bottom);
        writer.property("left", left);
        writer.property("right", right);
    }

    /**
     * <p>
     * Helper method to test position property.
     * </p>
     * 
     * @return A result.
     */
    public boolean isRelative() {
        return "relative".equals(value);
    }

    /**
     * <p>
     * Lay out all elements as though the element were not positioned, and then adjust the element's
     * position, without changing layout (and thus leaving a gap for the element where it would have
     * been had it not been positioned). The effect of position:relative on table-*-group,
     * table-row, table-column, table-cell, and table-caption elements is undefined.
     * </p>
     * 
     * @return
     */
    public Position relative() {
        return chain("relative");
    }

    /**
     * <p>
     * Helper method to test position property.
     * </p>
     * 
     * @return A result.
     */
    public boolean isAbsolute() {
        return "absolute".equals(value);
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * its closest positioned ancestor or to the containing block. Absolutely positioned boxes can
     * have margins, they do not collapse with any other margins.
     * </p>
     * 
     * @return
     */
    public Position absolute() {
        return chain("absolute");
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * the screen's viewport and doesn't move when scrolled. When printing, position it at that
     * fixed position on every page.
     * </p>
     * 
     * @return
     */
    public Position fixed() {
        return chain("fixed");
    }

    /**
     * <p>
     * The left CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the left margin edge of the element and the left edge of its
     * containing block.
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position left(Value value) {
        left = value;

        return chain();
    }

    /**
     * <p>
     * The left CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the left margin edge of the element and the left edge of its
     * containing block.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position left(double size, Unit unit) {
        left = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The right CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the right margin edge of the element and the right edge of its
     * containing block.
     * </p>
     * <p>
     * The right property has no effect on non-positioned elements.
     * </p>
     * <p>
     * When both the right CSS property and the left CSS property are defined, the position of the
     * element is overspecified. In that case, the left value has precedence when the container is
     * left-to-right (that is that the right computed value is set to -left), and the right value
     * has precedence when the container is right-to-left (that is that the left computed value is
     * set to -right).
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position right(Value value) {
        right = value;

        return chain();
    }

    /**
     * <p>
     * The right CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the right margin edge of the element and the right edge of its
     * containing block.
     * </p>
     * <p>
     * The right property has no effect on non-positioned elements.
     * </p>
     * <p>
     * When both the right CSS property and the left CSS property are defined, the position of the
     * element is overspecified. In that case, the left value has precedence when the container is
     * left-to-right (that is that the right computed value is set to -left), and the right value
     * has precedence when the container is right-to-left (that is that the left computed value is
     * set to -right).
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position right(double size, Unit unit) {
        right = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The top CSS property specifies part of the position of positioned elements. It has no effect
     * on non-positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the top margin edge of the element and the top edge of its
     * containing block.
     * </p>
     * <p>
     * For relatively positioned elements (those with position: relative), it specifies the amount
     * the element is moved below its normal position.
     * </p>
     * <p>
     * When both top and bottom are specified, the element position is over-constrained and the top
     * property has precedence: the computed value of bottom is set to -top, while its specified
     * value is ignored.
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position top(Value value) {
        top = value;

        return chain();
    }

    /**
     * <p>
     * The top CSS property specifies part of the position of positioned elements. It has no effect
     * on non-positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the top margin edge of the element and the top edge of its
     * containing block.
     * </p>
     * <p>
     * For relatively positioned elements (those with position: relative), it specifies the amount
     * the element is moved below its normal position.
     * </p>
     * <p>
     * When both top and bottom are specified, the element position is over-constrained and the top
     * property has precedence: the computed value of bottom is set to -top, while its specified
     * value is ignored.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position top(double size, Unit unit) {
        top = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The bottom CSS property participates in specifying the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements, that is those with position: absolute or position: fixed,
     * it specifies the distance between the bottom margin edge of the element and the bottom edge
     * of its containing block.
     * </p>
     * <p>
     * For relatively positioned elements, that is those with position: relative, it specifies the
     * distance the element is moved above its normal position.
     * </p>
     * <p>
     * However, the top property overrides the bottom property, so if top is not auto, the computed
     * value of bottom is the negative of the computed value of top.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position bottom(double size, Unit unit) {
        return bottom(new Value(size, unit));
    }

    /**
     * <p>
     * The bottom CSS property participates in specifying the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements, that is those with position: absolute or position: fixed,
     * it specifies the distance between the bottom margin edge of the element and the bottom edge
     * of its containing block.
     * </p>
     * <p>
     * For relatively positioned elements, that is those with position: relative, it specifies the
     * distance the element is moved above its normal position.
     * </p>
     * <p>
     * However, the top property overrides the bottom property, so if top is not auto, the computed
     * value of bottom is the negative of the computed value of top.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position bottom(Value value) {
        bottom = value;

        return chain();
    }
}
