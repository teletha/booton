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

import static java.util.concurrent.TimeUnit.*;
import static js.dom.UIAction.*;

import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends LowLevelElement<Input> {

    /** The input value. */
    public final StringProperty value;

    /**
     * <p>
     * Create {@link Input} form field with empty value.
     * </p>
     */
    public Input() {
        this(new SimpleStringProperty(""));
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public Input(StringProperty value) {
        this.value = value;

        publish().observe(KeyUp, Paste, Cut).debounce(50, MILLISECONDS).map(e -> e.target.val()).diff().to(value::set);
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
    protected void virtualize(VirtualStructure $) {
        $.e("input", hashCode()).〡ª("type", "text").〡ª("value", value.get()).with(publish());
    }
}
