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

import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.UIAction;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends LowLevelWidget<Input> {

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
    public Input placeholder(String string) {
        return this;
    }

    /**
     * Configure placeholder string.
     * 
     * @param string
     */
    public Input placeholder(Supplier<String> string) {
        return this;
    }

    public Input placeholder(StringExpression value) {
        return this;
    }

    /**
     * Configure requirement.
     * 
     * @return
     */
    public Input require() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected VirtualElement virtualize() {
        VirtualElement element = new VirtualElement(0, "input");
        System.out.println("virtulize input " + value.get());
        element.atrribute("value", value.get());

        publish().observe(UIAction.Change).to(event -> value.set(event.target.val()));
        element.events = publish();

        return element;
    }
}
