/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;
import jsx.style.value.Unit;

/**
 * @version 2014/10/28 22:02:51
 */
public class Box extends PropertyDefinition<Box> {

    /**
     * <p>
     * The box-sizing CSS property is used to alter the default CSS box model used to calculate
     * widths and heights of elements. It is possible to use this property to emulate the behavior
     * of browsers that do not correctly support the CSS box model specification.
     * </p>
     */
    public final Sizing sizing = new Sizing();

    // Float is the root of EVIL.
    //
    // /**
    // * <p>
    // * The float CSS property specifies that an element should be taken from the normal flow and
    // * placed along the left or right side of its container, where text and inline elements will
    // * wrap around it. A floating element is one where the computed value of float is not none.
    // * </p>
    // */
    // public final Float floating = new Float();

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
        return size(new Numeric(size, unit));
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
    public Box size(Numeric value) {
        width(value);
        height(value);

        return this;
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
        return width(new Numeric(size, unit));
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
    public Box width(Numeric value) {
        return value("width", value);
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
        return minWidth(new Numeric(size, unit));
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
    public Box minWidth(Numeric value) {
        return value("min-width", value);
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
        return maxWidth(new Numeric(size, unit));
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
    public Box maxWidth(Numeric value) {
        return value("max-width", value);
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
        return height(new Numeric(size, unit));
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
    public Box height(Numeric value) {
        return value("height", value);
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
        return minHeight(new Numeric(size, unit));
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
    public Box minHeight(Numeric value) {
        return value("min-height", value);
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
        return maxHeight(new Numeric(size, unit));
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
    public Box maxHeight(Numeric value) {
        return value("max-height", value);
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
        return value("z-index", value);
    }

    /**
     * <p>
     * The opacity CSS property specifies the transparency of an element, that is, the degree to
     * which the background behind the element is overlaid. Using this property with a value
     * different than 1 places the element in a new stacking context.
     * </p>
     */
    public Box opacity(double alpha) {
        return value("opacity", alpha);
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
     * @return
     */
    public Box shadow(Shadow... shadows) {
        value("box-shadow", join(shadows, v -> v.toString()));

        return this;
    }

    /**
     * @version 2014/10/28 22:03:41
     */
    public class Sizing extends PropertyDefinition<Box> {

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
            return value("content-box");
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
            return value("border-box");
        }
    }

    // Float is the root of EVIL.
    // /**
    // * @version 2014/10/28 22:03:37
    // */
    // public class Float extends PropertyDefinition<Box> {
    //
    // /**
    // * Hide.
    // */
    // private Float() {
    // super("float", Box.this);
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must float on the left side of its containing
    // * block.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box left() {
    // return value("left");
    //
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must float on the right side of its containing
    // * block.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box right() {
    // return value("right");
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must not float.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box none() {
    // return value("none");
    // }
    // }
}
