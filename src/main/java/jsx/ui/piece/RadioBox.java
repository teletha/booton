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

/**
 * @version 2015/10/24 3:13:45
 */
public class RadioBox<V> extends AbstractMarkedBox<RadioBox<V>, V> {

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
        super("radio", selection, value, label, () -> selection.getValue() == value, event -> selection.setValue(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeMark() {
        svg("circle", $.RadioBox, attr("cx", Styles.markSize.size / 2), attr("cy", Styles.markSize.size / 2), attr("r", 6));
        svg("circle", $.RadioMark, attr("cx", Styles.markSize.size / 2), attr("cy", Styles.markSize.size / 2), attr("r", 3));
    }
}
