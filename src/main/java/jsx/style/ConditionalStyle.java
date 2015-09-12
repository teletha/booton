/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import javafx.beans.value.ObservableBooleanValue;

import js.lang.NativeArray;
import jsx.collection.DualList;

/**
 * @version 2015/06/01 12:54:47
 */
class ConditionalStyle implements Style {

    /** The style declaration. */
    final Style style;

    /** The condition. */
    private final ObservableBooleanValue condition;

    /**
     * @param style
     * @param condition
     */
    ConditionalStyle(Style style, ObservableBooleanValue condition) {
        this.style = style;
        this.condition = condition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        style.declare();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String className() {
        return style.className();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        if (condition.get()) {
            style.assignTo(styles, inlines);
        }
    }
}
