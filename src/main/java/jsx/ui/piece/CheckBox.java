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

import javafx.beans.property.Property;
import javafx.beans.property.SetProperty;

import jsx.style.value.Numeric;
import jsx.ui.Style;

/**
 * @version 2015/10/24 3:13:35
 */
public class CheckBox<V> extends MarkedButton<CheckBox<V>, V> {

    /** The radius. */
    private static final Numeric Radius = new Numeric(0.25, em);

    /** The mark style. */
    private static final Style CheckMark = () -> {
        fill.none();
        stroke.color("#FFF").width(2, px).linecap.square().miterLimit(10);
    };

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
        super("checkbox", selection, value, label, () -> selection.contains(value), event -> {
            if (!selection.add(value)) {
                selection.remove(value);
            }
        });
    }

    /**
     * <p>
     * Create Checkbox.
     * </p>
     * 
     * @param selection
     * @param value
     * @param label
     */
    CheckBox(Property<Boolean> selection, V value, String label) {
        super("checkbox", selection, value, label, selection::getValue, event -> selection.setValue(!selection.getValue()));
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
}
