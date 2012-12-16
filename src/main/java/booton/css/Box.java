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

import java.util.List;

import js.util.ArrayList;
import kiss.I;
import booton.util.Color;

/**
 * @version 2012/12/13 17:54:06
 */
public class Box extends AutomaticCSSProperty<Box> {

    /**
     * <p>
     * The box-sizing CSS property is used to alter the default CSS box model used to calculate
     * widths and heights of elements. It is possible to use this property to emulate the behavior
     * of browsers that do not correctly support the CSS box model specification.
     * </p>
     */
    public final Sizing sizing = new Sizing();

    /** The box width. */
    private Value width;

    /** The bos min-width. */
    private Value minWidth;

    /** The bos max-width. */
    private Value maxWidth;

    /** The box height. */
    private Value height;

    /** The z-index. */
    private int index;

    /** The opacity. */
    private double alpha = -1;

    /** The shadows. */
    private final List<CSSShadowValue> shadows = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        super.write(writer);

        writer.property("width", width);
        writer.property("height", height);
        writer.property("z-index", index);
        if (0 <= alpha && alpha <= 1) writer.property("opacity", alpha);
        writer.property("max-width", maxWidth);
        writer.property("min-width", minWidth);
        writer.property("box-shadow", I.join(shadows, ","));
    }

    /**
     * <p>
     * Setting width and height properties.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box size(double size, Unit unit) {
        width(size, unit);
        height(size, unit);

        return this;
    }

    /**
     * <p>
     * Current width property.
     * </p>
     * 
     * @return A current value.
     */
    public Value width() {
        return width;
    }

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @param size A box width.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Box width(double size, Unit unit) {
        width = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The min-width CSS property is used to set the minimum width of a given element. It prevents
     * the used value of the width property from becoming smaller than the value specified for
     * min-width.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box minWidth(double size, Unit unit) {
        minWidth = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The max-width CSS property is used to set the maximum width of a given element. It prevents
     * the used value of the width property from becoming larger than the value specified for
     * max-width.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box maxWidth(double size, Unit unit) {
        maxWidth = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * Current height property.
     * </p>
     * 
     * @return A current value.
     */
    public Value height() {
        return height;
    }

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     * 
     * @param size A box width.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Box height(double size, Unit unit) {
        height = new Value(size, unit);

        return chain();
    }

    /**
     * <p>
     * The z-index CSS property specifies the z-order of an element and its descendants. When
     * elements overlap, z-order determines which one covers the other. An element with a larger
     * z-index generally covers an element with a lower one.
     * </p>
     * 
     * @param value
     */
    public Box zIndex(int value) {
        index = value;

        return chain();
    }

    /**
     * <p>
     * The opacity CSS property specifies the transparency of an element, that is, the degree to
     * which the background behind the element is overlaid. Using this property with a value
     * different than 1 places the element in a new stacking context.
     * </p>
     */
    public Box opacity(double alpha) {
        this.alpha = alpha;

        return chain();
    }

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param color
     * @return
     */
    public Box shadow(double offsetX, Unit unitX, double offsetY, Unit unitY, Color color) {
        CSSShadowValue shadow = new CSSShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @return
     */
    public Box shadowInset(double offsetX, Unit unitX, double offsetY, Unit unitY, Color color) {
        CSSShadowValue shadow = new CSSShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param blur
     * @param unitBlur
     * @return
     */
    public Box shadow(double offsetX, Unit unitX, double offsetY, Unit unitY, double blur, Unit unitBlur, Color color) {
        CSSShadowValue shadow = new CSSShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.blur = new Value(blur, unitBlur);
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param blur
     * @param unitBlur
     * @return
     */
    public Box shadowInset(double offsetX, Unit unitX, double offsetY, Unit unitY, double blur, Unit unitBlur, Color color) {
        CSSShadowValue shadow = new CSSShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.blur = new Value(blur, unitBlur);
        shadow.inset = true;
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * @version 2012/12/13 18:00:31
     */
    public class Sizing extends AutomaticCSSProperty<Box> {

        /**
         * Hide.
         */
        private Sizing() {
            super("box-sizing", Box.this);
        }

        /**
         * <p>
         * This is the default style as specified by the CSS standard. The width and height
         * properties are measured including only the content, but not the border, margin, or
         * padding.
         * </p>
         * 
         * @return Chainable API.
         */
        public Box contentBox() {
            return chain("content-box");
        }

        /**
         * <p>
         * The width and height properties include the padding and border, but not the margin. This
         * is the box model used by Internet Explorer when the document is in Quirks mode.
         * </p>
         * 
         * @return Chainable API.
         */
        public Box borderBox() {
            return chain("border-box");
        }
    }
}
