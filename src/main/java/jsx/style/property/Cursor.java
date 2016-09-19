/*
 * Copyright (C) 2016 Nameless Production Committee
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
 * @version 2014/10/28 16:13:49
 */
public class Cursor extends PropertyDefinition<Cursor> {

    /**
     * <p>
     * Default cursor, typically an arrow.
     * </p>
     * 
     * @return
     */
    public Cursor defaults() {
        return value("default");
    }

    /**
     * <p>
     * No cursor is rendered
     * </p>
     * 
     * @return
     */
    public Cursor none() {
        return value("none");
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
        return value("context-menu");
    }

    /**
     * <p>
     * Indicating help is available.
     * </p>
     * 
     * @return
     */
    public Cursor help() {
        return value("help");
    }

    /**
     * <p>
     * E.g. used when hovering over links, typically a hand.
     * </p>
     * 
     * @return
     */
    public Cursor pointer() {
        return value("pointer");
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
        return value("progress");
    }

    /**
     * <p>
     * The program is busy (sometimes an hourglass or a watch).
     * </p>
     * 
     * @return
     */
    public Cursor waiting() {
        return value("wait");
    }

    /**
     * <p>
     * Indicating that cells can be selected.
     * </p>
     * 
     * @return
     */
    public Cursor cell() {
        return value("cell");
    }

    /**
     * <p>
     * Cross cursor, often used to indicate selection in a bitmap.
     * </p>
     * 
     * @return
     */
    public Cursor cross() {
        return value("cross");
    }

    /**
     * <p>
     * Indicating text can be selected, typically an I-beam.
     * </p>
     * 
     * @return
     */
    public Cursor text() {
        return value("text");
    }

    /**
     * <p>
     * Indicating that vertical text can be selected, typically a sideways I-beam.
     * </p>
     * 
     * @return
     */
    public Cursor verticalText() {
        return value("vertical-text");
    }

    /**
     * <p>
     * Indicating an alias or shortcut is to be created.
     * </p>
     * 
     * @return
     */
    public Cursor alias() {
        return value("alias");
    }

    /**
     * <p>
     * Indicating that something can be copied.
     * </p>
     * 
     * @return
     */
    public Cursor copy() {
        return value("copy");
    }

    /**
     * <p>
     * The hovered object may be moved.
     * </p>
     * 
     * @return
     */
    public Cursor move() {
        return value("move");
    }

    /**
     * <p>
     * Cursor showing that a drop is not allowed at the current location.
     * </p>
     * 
     * @return
     */
    public Cursor noDrop() {
        return value("no-drop");
    }

    /**
     * <p>
     * Cursor showing that something cannot be done.
     * </p>
     * 
     * @return
     */
    public Cursor notAllowed() {
        return value("not-allowed");
    }

    /**
     * <p>
     * Cursor showing that something can be scrolled in any direction (panned).
     * </p>
     * 
     * @return
     */
    public Cursor allScroll() {
        return value("all-scroll");
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
        return value("col-resize");
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
        return value("row-resize");
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
        return value("n-resize");
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
        return value("e-resize");
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
        return value("s-resize");
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
        return value("w-resize");
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
        return value("ne-resize");
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
        return value("nw-resize");
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
        return value("se-resize");
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
        return value("sw-resize");
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
        return value("ew-resize");
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
        return value("nwse-resize");
    }

    /**
     * <p>
     * Indicates that something can be zoomed (magnified) in or out.
     * </p>
     * 
     * @return
     */
    public Cursor zoomIn() {
        return value("zoom-in");
    }

    /**
     * <p>
     * Indicates that something can be zoomed (magnified) in or out.
     * </p>
     * 
     * @return
     */
    public Cursor zoomOut() {
        return value("zoom-out");
    }
}
