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
import kiss.Events;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        for (int i = 0, size = this.styles.size(); i < size; i++) {
            if (this.styles.value(i)) {
                this.styles.key(i).assignTo(styles, inlines);
            }
        }
    }

    public void toggle() {
        NativeArray<Boolean> values = styles.values();

        for (int i = 0, size = values.length(); i < size; i++) {
            values.set(i, !values.getAsBoolean(i));
        }
    }

    public StyleProperty withIf(Events<Boolean> condition, Style additional) {
        disposer = disposer.and(condition.to(v -> styles.set(additional, v)));

        return this;
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
