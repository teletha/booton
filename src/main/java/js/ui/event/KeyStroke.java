/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Event;

/**
 * @version 2013/04/07 15:46:18
 */
class KeyStroke {

    /** The typed key. */
    private final int key;

    /** The modifier key. */
    private final boolean alt;

    /** The modifier key. */
    private final boolean ctrl;

    /** The modifier key. */
    private final boolean shift;

    /**
     * 
     */
    KeyStroke(Event event) {
        this.key = event.keyCode;
        this.alt = (event.stateMask & SWT.ALT) != 0;
        this.ctrl = (event.stateMask & SWT.CTRL) != 0;
        this.shift = (event.stateMask & SWT.SHIFT) != 0;
    }

    /**
     * 
     */
    KeyStroke(VerifyEvent event) {
        this.key = event.keyCode;
        this.alt = (event.stateMask & SWT.ALT) != 0;
        this.ctrl = (event.stateMask & SWT.CTRL) != 0;
        this.shift = (event.stateMask & SWT.SHIFT) != 0;
    }

    /**
     * 
     */
    KeyStroke(TraverseEvent event) {
        this.key = event.keyCode;
        this.alt = (event.stateMask & SWT.ALT) != 0;
        this.ctrl = (event.stateMask & SWT.CTRL) != 0;
        this.shift = (event.stateMask & SWT.SHIFT) != 0;
    }

    /**
     * 
     */
    KeyStroke(ListenKey key) {
        this.key = key.value().code;
        this.alt = key.alt();
        this.ctrl = key.ctrl();
        this.shift = key.shift();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (alt ? 1231 : 1237);
        result = prime * result + (ctrl ? 1231 : 1237);
        result = prime * result + key;
        result = prime * result + (shift ? 1231 : 1237);
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        KeyStroke other = (KeyStroke) obj;
        if (alt != other.alt) return false;
        if (ctrl != other.ctrl) return false;
        if (key != other.key) return false;
        if (shift != other.shift) return false;
        return true;
    }
}
