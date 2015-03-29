/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static js.dom.UIAction.*;
import static jsx.ui.piece.FormStyle.*;

import javafx.beans.property.BooleanProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure;

/**
 * @version 2014/10/04 10:26:04
 */
public class CheckBox extends LowLevelWidget<CheckBox> {

    /** The check status. */
    public final BooleanProperty check;

    /**
     * 
     */
    public CheckBox(BooleanProperty property) {
        this.check = property;

        listen(Click).to(e -> {
            System.out.println("click");
            check.set(!check.get());

        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.svg().style(CheckBoxSVG).viewBox(0, 0, 30, 30).$(() -> {
            〡.rect().style(CheckBox).size(28.4, 28.4).position(0.9, 0.9);
            if (check.get()) 〡.polyline().style(CheckBoxLine).points(23.5, 7.1, 11.9, 23.4, 6.2, 17.6);
            // .moveTo(16.667, 62.167)
            // .relatively()
            // .curveTo(3.109, 5.55, 7.217, 10.591, 10.926, 15.75)
            // .curveTo(2.614, 3.636, 5.149, 7.519, 8.161, 10.853)
            // .curveTo(-0.046, -0.051, 1.959, 2.414, 2.692, 2.343)
            // .curveTo(0.895, -0.088, 6.958, -8.511, 6.014, -7.3)
            // .curveTo(5.997, -7.695, 11.68, -15.463, 16.931, -23.696)
            // .curveTo(6.393, -10.025, 12.235, -20.373, 18.104, -30.707)
            // .absolutely()
            // .curveTo(82.004, 24.988, 84.802, 20.601, 87, 16);
        });
        〡.e("input", 0).〡(() -> {
            〡.attr.〡("type", "checkbox");
            〡.attr.〡("checked", check.get() ? "checked" : "");
        });
    }
}
