/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mitlicense.php
 */

package jsx.bwt;

/**
 * @version 2013/04/07 19:37:45
 */
public enum UIAction {

    /** The ui event type. */
    Close,

    /** The ui event type. */
    Minimize,

    /** The ui event type. */
    Maximize,

    /** The ui event type. */
    Activate,

    /** The ui event type. */
    Deactivate,

    /** The ui event type. */
    Focus,

    /** The ui event type. */
    Blur,

    /** The ui event type. */
    Resize,

    /** The ui event type. */
    Click,

    /** The ui event type. */
    Scroll,

    /** The ui event type. */
    KeyDown,

    /** The ui event type. */
    KeyUp,

    /** The ui event type. */
    KeyPress,

    /** The ui event type. */
    MouseDown,

    /** The ui event type. */
    MouseUp,

    /** The ui event type. */
    MouseMove,

    /** The ui event type. */
    MouseDoubleClick,

    /** The ui event type. */
    MouseEnter,

    /** The ui event type. */
    MouseLeave,

    /** The ui event type. */
    Selection;

    /** The key code. */
    public final int code;

    /** The event type name. */
    public final String name;

    /**
     * 
     */
    private UIAction() {
        this(-1);
    }

    /**
     * <p>
     * Native key.
     * </p>
     * 
     * @param code
     */
    private UIAction(int code) {
        this.code = code;
        this.name = code == -1 ? name().toLowerCase() : "keydown";
    }
}
