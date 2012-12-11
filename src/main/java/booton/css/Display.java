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

import booton.util.Strings;

/**
 * @version 2012/12/11 15:54:13
 */
public enum Display {
    /** The element generates a block element box. */
    Block,

    /**
     * The element generates one or more inline element boxes.
     */
    Inline,

    /**
     * The element generates a block element box that will be flowed with surrounding content as if
     * it were a single inline box (behaving much like a replaced element would)
     */
    InlineBlock,

    /**
     * The element generates a block box for the content and a separate list-item inline box.
     */
    ListItem,

    /**
     * <p>
     * If the run-in box contains a block box, same as block.
     * </p>
     * <p>
     * If a block box follows the run-in box, the run-in box becomes the first inline box of the
     * block box.
     * </p>
     * <p>
     * If a inline box follows, the run-in box becomes a block box.
     * </p>
     */
    RunIn,

    /**
     * Behaves like the table HTML element. It defines a block-level box.
     */
    Table,

    /**
     * The inline-table value does not have a direct mapping in HTML. It behaves like a table HTML
     * element, but as an inline box, rather than a block-level box. Inside the table box is a
     * block-level context.
     */
    InlineTable,

    /**
     * The element behaves like a block element and lays out its content according to the flexbox
     * model.
     */
    Flex,

    /**
     * The element behaves like a block element and lay out its content according to the grid model.
     */
    Grid,

    /**
     * The element behaves like an inline element and lay out its content according to the grid
     * model.
     */
    InlineGrid,

    /**
     * The element behaves like an inline element and lays out its content according to the flexbox
     * model.
     */
    InlineFlex,

    /**
     * Behaves like the caption HTML element.
     */
    TableCaption,

    /**
     * Behaves like the tr HTML element.
     */
    TableRow,

    /**
     * Behaves like the td HTML element.
     */
    TableCell,

    /**
     * These elements behave like the corresponding col HTML elements.
     */
    TableColumn,

    /**
     * These elements behave like the corresponding colgroup HTML elements.
     */
    TableColumnGroup,

    /**
     * These elements behave like the corresponding thead HTML elements.
     */
    TableHeaderGroup,

    /**
     * These elements behave like the corresponding tfoot HTML elements.
     */
    TableFooterGroup,

    /**
     * These elements behave like the corresponding tbody HTML elements.
     */
    TableRowGroup,

    /**
     * <p>
     * Turns off the display of an element (it has no effect on layout); all child elements also
     * have their display turned off. The document is rendered as though the element did not exist.
     * </p>
     * <p>
     * To render an element box's dimensions, yet have its contents be invisible, see the visibility
     * property.
     * </p>
     */
    None;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Strings.hyphenate(name());
    }
}
