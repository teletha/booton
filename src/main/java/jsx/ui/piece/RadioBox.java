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

import static jsx.ui.StructureDescriptor.*;

import javafx.beans.property.Property;

import js.dom.UIEvent;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2015/10/12 11:29:35
 */
public class RadioBox<V> extends MarkedButton<RadioBox<V>, V> {

    /** The radius. */
    private static final Numeric Radius = new Numeric(50, Unit.percent);

    /** The selection manager. */
    private final Property<V> selection;

    /**
     * <p>
     * Create RadioBox.
     * </p>
     * 
     * @param selection
     * @param value
     * @param label
     */
    RadioBox(Property<V> selection, V value, String label) {
        super("radio", selection, value, label);

        this.selection = selection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeMark() {
        svg("circle", attr("fill", "#FFF"), attr("cx", $.markSize.size / 2), attr("cy", $.markSize.size / 2), attr("r", 3));
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
        return selection.getValue() == value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void change(UIEvent event) {
        selection.setValue(value);
    }
}
