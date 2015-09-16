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

import static js.dom.UIAction.*;
import static jsx.ui.VirtualStructure.Declarables.*;
import static jsx.ui.piece.FormStyle.*;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure;

/**
 * @version 2014/10/04 10:26:04
 */
public class CheckBox extends LowLevelWidget<CheckBox> {

    /** The check status. */
    public final BooleanProperty check;

    /** The associated label. */
    public final StringProperty label;

    /**
     * <p>
     * Create Checkbox.
     * </p>
     * 
     * @param value
     * @param label
     */
    public CheckBox(BooleanProperty value, StringProperty label) {
        if (value == null) value = new SimpleBooleanProperty();
        if (label == null) label = new SimpleStringProperty();

        this.check = value;
        this.label = label;

        on(Click).to(e -> check.set(!check.get()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        element("s:svg", CheckBoxSVG, viewBox(0, 0, 100, 100), () -> {
            element("s:rect", CheckBox, size(90, 90), position(5, 5));
            element("s:path", CheckMark.of(check), d().moveTo(16.667, 62.167)
                    .relatively()
                    .curveTo(3.109, 5.55, 7.217, 10.591, 10.926, 15.75)
                    .curveTo(2.614, 3.636, 5.149, 7.519, 8.161, 10.853)
                    .curveTo(-0.046, -0.051, 1.959, 2.414, 2.692, 2.343)
                    .curveTo(0.895, -0.088, 6.958, -8.511, 6.014, -7.3)
                    .curveTo(5.997, -7.695, 11.68, -15.463, 16.931, -23.696)
                    .curveTo(6.393, -10.025, 12.235, -20.373, 18.104, -30.707)
                    .absolutely()
                    .curveTo(82.004, 24.988, 84.802, 20.601, 87, 16));
        });
    }
}
