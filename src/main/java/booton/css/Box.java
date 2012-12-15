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

    /** The box width. */
    private Value width;

    /** The box height. */
    private Value height;

    /** The z-index. */
    private int index;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property("width", width) + property("height", height) + sizing.toString() + property("z-index", index);
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
}
