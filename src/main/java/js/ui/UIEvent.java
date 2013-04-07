/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mitlicense.php
 */

package js.ui;

/**
 * @version 2013/04/05 15:06:48
 */
public enum UIEvent {

    /** The model event type. */
    Model_Select,

    /** The model event type. */
    Model_Deselect,

    /** The model event type. */
    Model_Add,

    /** The model event type. */
    Model_Remove,

    /** The ui event type. */
    Close,

    /** The ui event type. */
    Minimize,

    /** The ui event type. */
    Maximize,

    /** The ui event type. */
    Restore,

    /** The ui event type. */
    ShowList,

    /** The ui event type. */
    Activate,

    /** The ui event type. */
    Deactivate,

    /** The ui event type. */
    Dispose,

    /** The ui event type. */
    FocusIn,

    /** The ui event type. */
    FocusOut,

    /** The ui event type. */
    SetData,

    /** The ui event type. */
    EraseItem,

    /** The ui event type. */
    Resize,

    /** The ui event type. */
    MouseDown,

    /** The ui event type. */
    MouseUp,

    /** The ui event type. */
    MouseMove,

    /** The ui event type. */
    MouseDoubleClick,

    /** The ui event type. */
    MouseDragStart,

    /** The ui event type. */
    Selection,

    /** The ui event type. */
    None,

    /** The ui event type. */
    Click;

    /**
     * 
     */
    private UIEvent() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
