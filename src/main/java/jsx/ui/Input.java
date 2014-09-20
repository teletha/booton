/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.Element;
import js.dom.UIAction;
import kiss.Events;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends LowLevelUI<Input> {

    /** The input value. */
    public final StringProperty value;

    public Input() {
        this(new SimpleStringProperty(""));
    }

    public Input(StringProperty value) {
        this.value = value;
    }

    /**
     * 
     */
    public String clear() {
        String current = value.get();

        // clear value
        value.setValue("");

        // API definition
        return current;
    }

    /**
     * Configure placeholder string.
     * 
     * @param string
     */
    protected Input placeholder(String string) {
        return this;
    }

    protected Input placeholder(Events<String> value) {
        return this;
    }

    /**
     * Configure requirement.
     * 
     * @return
     */
    protected Input require() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected VirtualElement virtualize() {
        return new VirtualElement(0, "input");
    }

    /**
     * {@inheritDoc}
     */
    public void materialize(Element element) {
        System.out.println("materialized");
        element.observe(UIAction.Click).to(e -> {
            System.out.println("CLICLED " + e);
        });
    }
}
