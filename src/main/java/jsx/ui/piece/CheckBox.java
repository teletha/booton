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

import static jsx.style.StyleDescriptor.*;
import static jsx.ui.StructureDescriptor.*;

import javafx.beans.property.SetProperty;

import js.dom.UIEvent;
import jsx.style.value.Numeric;
import jsx.ui.Style;

/**
 * @version 2015/10/12 11:29:39
 */
public class CheckBox<V> extends MarkedButton<CheckBox<V>, V> {

    /** The radius. */
    private static final Numeric Radius = new Numeric(0.25, em);

    /** The mark style. */
    private static final Style CheckMark = () -> {
        fill.none();
        stroke.color("#FFF").width(2, px).linecap.square().miterLimit(10);
    };

    /** The selection manager. */
    private final SetProperty<V> selection;

    /**
     * <p>
     * Create Checkbox.
     * </p>
     * 
     * @param selection
     * @param value
     * @param label
     */
    CheckBox(SetProperty selection, V value, String label) {
        super("checkbox", selection, value, label);

        this.selection = selection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeMark() {
        svg("polyline", CheckMark, attr("points", "4,7 6,9 10,5"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Numeric radius() {
        return Radius;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isMarked() {
        return selection.contains(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void change(UIEvent event) {
        if (!selection.add(value)) {
            selection.remove(value);
        }
    }
}
