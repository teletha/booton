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
 * @version 2012/12/11 20:20:12
 */
public final class Display extends CSSValue {

    /**
     * Hide constructor.
     */
    Display(CSS css) {
        super(css);
    }

    /** The element generates a block element box. */
    public void block() {
        value = "block";
    }

    /**
     * The element generates one or more inline element boxes.
     */
    public void inline() {
        value = "inline";
    }

    /**
     * The element generates a block element box that will be flowed with surrounding content as if
     * it were a single inline box (behaving much like a replaced element would)
     */
    public void inline_block() {
        value = "inline-block";
    }

    /**
     * The element generates a block box for the content and a separate list-item inline box.
     */
    public void list_item() {
        value = "list-item";
    }

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
    public void run_in() {
        value = "run-in";
    }

    /**
     * The element behaves like a block element and lay out its content according to the grid model.
     */
    public void grid() {
        value = "grid";
    }

    /**
     * The element behaves like an inline element and lay out its content according to the grid
     * model.
     */
    public void inline_grid() {
        value = "inline-grid";
    }

    /**
     * The element behaves like a block element and lays out its content according to the flexbox
     * model.
     */
    public void flex() {
        value = "flex";
    }

    /**
     * The element behaves like an inline element and lays out its content according to the flexbox
     * model.
     */
    public void inline_flex() {
        value = "inline-flex";
    }

    /**
     * Behaves like the table HTML element. It defines a block-level box.
     */
    public void table() {
        value = "table";
    }

    /**
     * The inline-table value does not have a direct mapping in HTML. It behaves like a table HTML
     * element, but as an inline box, rather than a block-level box. Inside the table box is a
     * block-level context.
     */
    public void inline_table() {
        value = "inline-table";
    }

    /**
     * Behaves like the caption HTML element.
     */
    public void table_caption() {
        value = "table-caption";
    }

    /**
     * Behaves like the tr HTML element.
     */
    public void table_row() {
        value = "table-row";
    }

    /**
     * Behaves like the td HTML element.
     */
    public void table_cell() {
        value = "table-cell";
    }

    /**
     * These elements behave like the corresponding col HTML elements.
     */
    public void table_column() {
        value = "table-column";
    }

    /**
     * These elements behave like the corresponding colgroup HTML elements.
     */
    public void table_column_group() {
        value = "table-column-group";
    }

    /**
     * These elements behave like the corresponding thead HTML elements.
     */
    public void table_header_group() {
        value = "table-header-group";
    }

    /**
     * These elements behave like the corresponding tfoot HTML elements.
     */
    public void table_footer_group() {
        value = "table-footer-group";
    }

    /**
     * These elements behave like the corresponding tbody HTML elements.
     */
    public void table_row_group() {
        value = "table-row-group";
    }

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
    public void none() {
        value = "none";
    }
}
