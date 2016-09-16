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
 * @version 2014/10/21 16:19:34
 */
public final class Display extends PropertyDefinition<Display> {

    /**
     * <p>
     * The box-sizing CSS property is used to alter the default CSS box model used to calculate
     * widths and heights of elements. It is possible to use this property to emulate the behavior
     * of browsers that do not correctly support the CSS box model specification.
     * </p>
     */
    public final Sizing sizing = new Sizing();

    /**
     * The element generates a block element box.
     */
    public Display block() {
        return value("block");
    }

    /**
     * The element generates one or more inline element boxes.
     */
    public Display inline() {
        return value("inline");
    }

    /**
     * The element generates a block element box that will be flowed with surrounding content as if
     * it were a single inline box (behaving much like a replaced element would)
     */
    public Display inlineBlock() {
        return value("inline-block");
    }

    /**
     * The element generates a block box for the content and a separate list-item inline box.
     */
    public Display listItem() {
        return value("list-item");
    }

    // /**
    // * <p>
    // * If the run-in box contains a block box, same as block.
    // * </p>
    // * <p>
    // * If a block box follows the run-in box, the run-in box becomes the first inline box of the
    // * block box.
    // * </p>
    // * <p>
    // * If a inline box follows, the run-in box becomes a block box.
    // * </p>
    // */
    // public Display runIn() {
    // return value("run-in");
    // }
    //
    // /**
    // * The element behaves like a block element and lay out its content according to the grid
    // model.
    // */
    // public Display grid() {
    // return value("grid");
    // }
    //
    // /**
    // * The element behaves like an inline element and lay out its content according to the grid
    // * model.
    // */
    // public Display inlineGrid() {
    // return value("inline-grid");
    // }

    /**
     * The element behaves like a block element and lays out its content according to the flexbox
     * model.
     */
    public Flex flex() {
        value("flex");
        value("-webkit-flex");

        return new Flex();
    }

    /**
     * The element behaves like an inline element and lays out its content according to the flexbox
     * model.
     */
    public Flex inlineFlex() {
        value("inline-flex");
        value("-webkit-inline-flex");

        return new Flex();
    }

    // /**
    // * Behaves like the table HTML element. It defines a block-level box.
    // */
    // public Display table() {
    // return value("table");
    // }
    //
    // /**
    // * The inline-table value does not have a direct mapping in HTML. It behaves like a table HTML
    // * element, but as an inline box, rather than a block-level box. Inside the table box is a
    // * block-level context.
    // */
    // public Display inlineTable() {
    // return value("inline-table");
    // }
    //
    // /**
    // * Behaves like the caption HTML element.
    // */
    // public Display tableCaption() {
    // return value("table-caption");
    // }
    //
    // /**
    // * Behaves like the tr HTML element.
    // */
    // public Display tableRow() {
    // return value("table-row");
    // }
    //
    // /**
    // * Behaves like the td HTML element.
    // */
    // public Display tableCell() {
    // return value("table-cell");
    // }
    //
    // /**
    // * These elements behave like the corresponding col HTML elements.
    // */
    // public Display tableColumn() {
    // return value("table-column");
    // }
    //
    // /**
    // * These elements behave like the corresponding colgroup HTML elements.
    // */
    // public Display tableColumnGroup() {
    // return value("table-column-group");
    // }
    //
    // /**
    // * These elements behave like the corresponding thead HTML elements.
    // */
    // public Display tableHeaderGroup() {
    // return value("table-header-group");
    // }
    //
    // /**
    // * These elements behave like the corresponding tfoot HTML elements.
    // */
    // public Display tableFooterGroup() {
    // return value("table-footer-group");
    // }
    //
    // /**
    // * These elements behave like the corresponding tbody HTML elements.
    // */
    // public Display tableRowGroup() {
    // return value("table-row-group");
    // }

    /**
     * <p>
     * Turns off the display of an element (it has no effect on layout)); all child elements also
     * have their display turned off. The document is rendered as though the element did not exist.
     * </p>
     * <p>
     * To render an element box's dimensions, yet have its contents be invisible, see the visibility
     * property.
     * </p>
     */
    public Display none() {
        return value("none");
    }

    /**
     * <p>
     * Alias for <code>display.flex()</code>.
     * </p>
     * <p>
     * The element behaves like a block element and lays out its content according to the horizontal
     * flexbox model.
     * </p>
     */
    public Flex horizontalBox() {
        return flex();
    }

    /**
     * <p>
     * Alias for <code>display.flex().direction.column()</code>.
     * </p>
     * <p>
     * The element behaves like a block element and lays out its content according to the vertical
     * flexbox model.
     * </p>
     */
    public Flex verticalBox() {
        return flex().direction.column();
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
    public Display size(double size, Unit unit) {
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
    public Display size(Numeric value) {
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
    public Display width(double size, Unit unit) {
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
    public Display width(Numeric value) {
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
    public Display minWidth(double size, Unit unit) {
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
    public Display minWidth(Numeric value) {
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
    public Display maxWidth(double size, Unit unit) {
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
    public Display maxWidth(Numeric value) {
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
    public Display height(double size, Unit unit) {
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
    public Display height(Numeric value) {
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
    public Display minHeight(double size, Unit unit) {
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
    public Display minHeight(Numeric value) {
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
    public Display maxHeight(double size, Unit unit) {
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
    public Display maxHeight(Numeric value) {
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
    public Display zIndex(int value) {
        return value("z-index", value);
    }

    /**
     * <p>
     * The opacity CSS property specifies the transparency of an element, that is, the degree to
     * which the background behind the element is overlaid. Using this property with a value
     * different than 1 places the element in a new stacking context.
     * </p>
     */
    public Display opacity(double alpha) {
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
    public Display shadow(Shadow... shadows) {
        return value("box-shadow", join(shadows, v -> v.toString()));
    }

    /**
     * @version 2016/09/17 0:01:38
     */
    public class Sizing extends PropertyDefinition<Display> {

        /**
         * Hide.
         */
        private Sizing() {
            super("box-sizing", Display.this);
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
        public Display contentBox() {
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
        public Display borderBox() {
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
