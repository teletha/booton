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

/**
 * @version 2014/10/21 16:19:34
 */
public final class Display extends PropertyDefinition<Display> {

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
}
