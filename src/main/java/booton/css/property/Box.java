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

import java.util.ArrayList;
import java.util.List;

import js.util.Color;
import kiss.I;
import booton.css.CSSProperty;
import booton.css.CSSWriter;
import booton.css.Unit;
import booton.css.Value;

/**
 * @version 2012/12/13 17:54:06
 */
public class Box extends CSSProperty<Box> {

    /**
     * <p>
     * The box-sizing CSS property is used to alter the default CSS box model used to calculate
     * widths and heights of elements. It is possible to use this property to emulate the behavior
     * of browsers that do not correctly support the CSS box model specification.
     * </p>
     */
    public final Sizing sizing = new Sizing();

    /**
     * <p>
     * The float CSS property specifies that an element should be taken from the normal flow and
     * placed along the left or right side of its container, where text and inline elements will
     * wrap around it. A floating element is one where the computed value of float is not none.
     * </p>
     */
    public final Float floating = new Float();

    /** The box width. */
    private Value width;

    /** The box min-width. */
    private Value minWidth;

    /** The box max-width. */
    private Value maxWidth;

    /** The box height. */
    private Value height;

    /** The box min-width. */
    private Value minHeight;

    /** The box max-width. */
    private Value maxHeight;

    /** The z-index. */
    private int index;

    /** The opacity. */
    private double alpha = -1;

    /** The shadows. */
    private final List<ShadowValue> shadows = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        super.write(writer);

        writer.property("width", width);
        writer.property("height", height);
        if (0 != index) writer.property("z-index", index);
        if (0 <= alpha && alpha <= 1) writer.property("opacity", alpha);
        writer.property("max-width", maxWidth);
        writer.property("min-width", minWidth);
        writer.property("max-height", maxHeight);
        writer.property("min-height", minHeight);
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
        return size(new Value(size, unit));
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
    public Box size(Value value) {
        width(value);
        height(value);

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
        return width == null ? minWidth == null ? Value.Zero : minWidth : width;
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
    public Box width(Value value) {
        width = value;

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
        return minWidth(new Value(size, unit));
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
    public Box minWidth(Value value) {
        minWidth = value;

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
        return maxWidth(new Value(size, unit));
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
    public Box maxWidth(Value value) {
        maxWidth = value;

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
    public Box height(Value value) {
        height = value;

        return chain();
    }

    /**
     * <p>
     * The min-height CSS property is used to set the minimum height of a given element. It prevents
     * the used value of the height property from becoming smaller than the value specified for
     * min-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box minHeight(double size, Unit unit) {
        return minHeight(new Value(size, unit));
    }

    /**
     * <p>
     * The min-height CSS property is used to set the minimum height of a given element. It prevents
     * the used value of the height property from becoming smaller than the value specified for
     * min-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box minHeight(Value value) {
        minHeight = value;

        return chain();
    }

    /**
     * <p>
     * The max-height CSS property is used to set the maximum height of a given element. It prevents
     * the used value of the height property from becoming larger than the value specified for
     * max-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box maxHeight(double size, Unit unit) {
        return maxHeight(new Value(size, unit));
    }

    /**
     * <p>
     * The max-height CSS property is used to set the maximum height of a given element. It prevents
     * the used value of the height property from becoming larger than the value specified for
     * max-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Box maxHeight(Value value) {
        maxHeight = value;

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
        ShadowValue shadow = new ShadowValue();
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
        ShadowValue shadow = new ShadowValue();
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
        ShadowValue shadow = new ShadowValue();
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
        ShadowValue shadow = new ShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.blur = new Value(blur, unitBlur);
        shadow.inset = true;
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
     * @param spread
     * @param unitSpread
     * @return
     */
    public Box shadow(double offsetX, Unit unitX, double offsetY, Unit unitY, double blur, Unit unitBlur, double spread, Unit unitSpread, Color color) {
        ShadowValue shadow = new ShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.blur = new Value(blur, unitBlur);
        shadow.spread = new Value(spread, unitSpread);
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
     * @param spread
     * @param unitSpread
     * @return
     */
    public Box shadowInset(double offsetX, Unit unitX, double offsetY, Unit unitY, double blur, Unit unitBlur, double spread, Unit unitSpread, Color color) {
        ShadowValue shadow = new ShadowValue();
        shadow.offsetX = new Value(offsetX, unitX);
        shadow.offsetY = new Value(offsetY, unitY);
        shadow.blur = new Value(blur, unitBlur);
        shadow.spread = new Value(spread, unitSpread);
        shadow.inset = true;
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * @version 2012/12/13 18:00:31
     */
    public class Sizing extends CSSProperty<Box> {

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

    /**
     * @version 2013/06/13 16:18:05
     */
    public class Float extends CSSProperty<Box> {

        /**
         * Hide.
         */
        private Float() {
            super("float", Box.this);
        }

        /**
         * <p>
         * Is a keyword indicating that the element must float on the left side of its containing
         * block.
         * </p>
         * 
         * @return Chainable API.
         */
        public Box left() {
            return chain("left");

        }

        /**
         * <p>
         * Is a keyword indicating that the element must float on the right side of its containing
         * block.
         * </p>
         * 
         * @return Chainable API.
         */
        public Box right() {
            return chain("right");
        }

        /**
         * <p>
         * Is a keyword indicating that the element must not float.
         * </p>
         * 
         * @return Chainable API.
         */
        public Box none() {
            return chain("none");
        }
    }

}
