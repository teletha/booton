/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import js.lang.NativeFunction;

class EmulateEventTarget<T extends EmulateEventTarget<T>> extends EventTarget<T> {

    /** The listener table. */
    private Map<String, List<NativeFunction>> listeners = new HashMap();

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEventListener(String type, NativeFunction listener) {
        if (type != null && listener != null) {
            listeners.computeIfAbsent(type, k -> new ArrayList()).add(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEventListener(String type, NativeFunction listener) {
        if (type != null && listener != null) {
            listeners.computeIfAbsent(type, k -> new ArrayList()).remove(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void dispatchEvent(UIEvent event) {
        if (event != null) {
            for (NativeFunction listener : listeners.get(event.type)) {
                listener.apply(null, event);
            }
        }
    }
}
