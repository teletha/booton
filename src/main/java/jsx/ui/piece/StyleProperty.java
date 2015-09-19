/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import js.lang.NativeArray;
import jsx.collection.DualList;
import jsx.style.Style;
import kiss.Disposable;

/**
 * @version 2015/03/06 15:31:03
 */
public class StyleProperty implements Style, Disposable {

    /** The managed style list. */
    private DualList<Style, Boolean> styles = new DualList();

    /** The disposer. */
    private Disposable disposer = Disposable.Φ;

    /**
     * @param shown
     */
    public StyleProperty(Style style) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        // do nothing
    }

    public void toggle() {
        NativeArray<Boolean> values = styles.values();

        for (int i = 0, size = values.length(); i < size; i++) {
            values.set(i, !values.getAsBoolean(i));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        styles.clear();
        disposer.dispose();
    }
}
