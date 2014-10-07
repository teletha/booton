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

import javafx.beans.property.BooleanProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;

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

        event().observe(Change).to(e -> check.set(!check.get()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String virtualizeName() {
        return "input";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(ContainerDescriptor descriptor) {
        descriptor.〡ª("type", "checkbox").〡ª("checked", check.get() ? "checked" : "");
    }
}
