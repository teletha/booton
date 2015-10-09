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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2015/10/06 13:48:53
 */
public class RadioBox extends MarkedButton<RadioBox> {

    /** The radius. */
    private static final Numeric Radius = new Numeric(50, Unit.percent);

    /**
     * @param value
     * @param label
     */
    RadioBox(RadioGroup group, BooleanProperty value, StringProperty label) {
        super("radio", "Radio" + group.hashCode(), value, label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeMark() {
        svg("circle", attr("fill", "#FFF"), attr("cx", markSize.size / 2), attr("cy", markSize.size / 2), attr("r", 3));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Numeric radius() {
        return Radius;
    }
}
