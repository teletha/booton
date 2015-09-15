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

import static jsx.ui.VirtualStructure.Declarables.*;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure;

/**
 * @version 2015/09/15 15:35:18
 */
public class Button extends LowLevelWidget<Button> {

    /** The label text. */
    public StringExpression label;

    /**
     * @param name
     */
    Button() {
    }

    /**
     * @param string
     * @return
     */
    public Button label(StringExpression text) {
        this.label = text;

        return this;
    }

    /**
     * @param texts
     * @return
     */
    public Button label(Object... texts) {
        StringExpression label = new SimpleStringProperty("");

        for (Object text : texts) {
            label = label.concat(text);
        }
        return label(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        element("button", rootStyle.getValue(), () -> {
            con(label.get());
        });
    }
}
