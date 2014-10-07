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

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;

/**
 * @version 2014/08/21 17:09:43
 */
public class Button extends LowLevelWidget<Button> {

    /** The label text. */
    public StringExpression label;

    /**
     * @param name
     */
    public Button() {
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
    protected String virtualizeName() {
        return "button";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(ContainerDescriptor descriptor) {
        descriptor.〡(label.get());
    }
}