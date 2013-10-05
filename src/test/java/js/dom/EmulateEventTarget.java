/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import jsx.bwt.UIEvent;
import kiss.Table;

/**
 * @version 2013/10/05 10:07:28
 */
public class EmulateEventTarget extends EventTarget {

    /** The listener table. */
    private Table<String, EventListener> listeners = new Table();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addEventListener(String type, EventListener listener) {
        if (type != null && listener != null) {
            listeners.push(type, listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeEventListener(String type, EventListener listener) {
        if (type != null && listener != null) {
            listeners.pull(type, listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void dispatchEvent(UIEvent event) {
        if (event != null) {
            for (EventListener listener : listeners.get(event.type)) {
                listener.handleEvent(event);
            }
        }
    }
}
