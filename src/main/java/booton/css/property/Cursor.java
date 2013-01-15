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

/**
 * @version 2013/01/15 22:59:43
 */
public class Cursor extends CSSProperty<Cursor> {

    /**
     * <p>
     * Default cursor, typically an arrow.
     * </p>
     * 
     * @return
     */
    public Cursor defaults() {
        return chain("default");
    }

    /**
     * <p>
     * No cursor is rendered
     * </p>
     * 
     * @return
     */
    public Cursor none() {
        return chain("none");
    }

    /**
     * <p>
     * A context menu is available under the cursor. In Gecko/Firefox not implemented on Windows,
     * bug 258960 WONTFIX.
     * </p>
     * 
     * @return
     */
    public Cursor contextMenu() {
        return chain("context-menu");
    }

    /**
     * <p>
     * Indicating help is available.
     * </p>
     * 
     * @return
     */
    public Cursor help() {
        return chain("help");
    }

    /**
     * <p>
     * E.g. used when hovering over links, typically a hand.
     * </p>
     * 
     * @return
     */
    public Cursor pointer() {
        return chain("pointer");
    }

    /**
     * <p>
     * The program is busy in the background but the user can still interact with the interface
     * (unlike for wait).
     * </p>
     * 
     * @return
     */
    public Cursor progress() {
        return chain("progress");
    }

    /**
     * <p>
     * The program is busy (sometimes an hourglass or a watch).
     * </p>
     * 
     * @return
     */
    public Cursor waiting() {
        return chain("wait");
    }

    /**
     * <p>
     * Indicating that cells can be selected.
     * </p>
     * 
     * @return
     */
    public Cursor cell() {
        return chain("cell");
    }

    /**
     * <p>
     * Cross cursor, often used to indicate selection in a bitmap.
     * </p>
     * 
     * @return
     */
    public Cursor cross() {
        return chain("cross");
    }

    /**
     * <p>
     * Indicating text can be selected, typically an I-beam.
     * </p>
     * 
     * @return
     */
    public Cursor text() {
        return chain("text");
    }

    /**
     * <p>
     * Indicating that vertical text can be selected, typically a sideways I-beam.
     * </p>
     * 
     * @return
     */
    public Cursor verticalText() {
        return chain("vertical-text");
    }

    /**
     * <p>
     * Indicating an alias or shortcut is to be created.
     * </p>
     * 
     * @return
     */
    public Cursor alias() {
        return chain("alias");
    }

    /**
     * <p>
     * Indicating that something can be copied.
     * </p>
     * 
     * @return
     */
    public Cursor copy() {
        return chain("copy");
    }

    /**
     * <p>
     * The hovered object may be moved.
     * </p>
     * 
     * @return
     */
    public Cursor move() {
        return chain("move");
    }

    /**
     * <p>
     * Cursor showing that a drop is not allowed at the current location.
     * </p>
     * 
     * @return
     */
    public Cursor noDrop() {
        return chain("no-drop");
    }

    /**
     * <p>
     * Cursor showing that something cannot be done.
     * </p>
     * 
     * @return
     */
    public Cursor notAllowed() {
        return chain("not-allowed");
    }

    /**
     * <p>
     * Cursor showing that something can be scrolled in any direction (panned).
     * </p>
     * 
     * @return
     */
    public Cursor allScroll() {
        return chain("all-scroll");
    }

    /**
     * <p>
     * The item/column can be resized horizontally. Often rendered as arrows pointing left and right
     * with a vertical bar separating.
     * </p>
     * 
     * @return
     */
    public Cursor colResize() {
        return chain("col-resize");
    }

    /**
     * <p>
     * The item/row can be resized vertically. Often rendered as arrows pointing up and down with a
     * horizontal bar separating them.
     * </p>
     * 
     * @return
     */
    public Cursor rowResize() {
        return chain("row-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor nResize() {
        return chain("n-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor eResize() {
        return chain("e-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor sResize() {
        return chain("s-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor wResize() {
        return chain("w-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor neResize() {
        return chain("ne-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor nwResize() {
        return chain("nw-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor seResize() {
        return chain("se-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor swResize() {
        return chain("sw-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor ewResize() {
        return chain("ew-resize");
    }

    /**
     * <p>
     * Some edge is to be moved. For example, the se-resize cursor is used when the movement starts
     * from the south-east corner of the box.
     * </p>
     * 
     * @return
     */
    public Cursor nwseResize() {
        return chain("nwse-resize");
    }

    /**
     * <p>
     * Indicates that something can be zoomed (magnified) in or out.
     * </p>
     * 
     * @return
     */
    public Cursor zoomIn() {
        return chain("zoom-in");
    }

    /**
     * <p>
     * Indicates that something can be zoomed (magnified) in or out.
     * </p>
     * 
     * @return
     */
    public Cursor zoomOut() {
        return chain("zoom-out");
    }
}
