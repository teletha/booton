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

        listen(Change).to(e -> check.set(!check.get()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.nbox.〡(CheckBoxRoot, () -> {
            〡.e("input", "type", "checkbox");
            〡.e("label").〡(() -> {
                〡.nbox.〡(null, "text");
            });
            〡.svg().style(CheckBoxSVG).viewBox(0, 0, 100, 100).$(() -> {
                〡.path().style(CheckBoxLine).start(10, 10).line(90, 90);
            });
        });
        〡.e("input", 0).〡(() -> {
            〡.attr.〡("type", "checkbox");
            〡.attr.〡("checked", check.get() ? "checked" : "");
        });
    }
}
