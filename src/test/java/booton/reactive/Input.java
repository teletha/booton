/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.Events;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends UI<Input> {

    /** The input value. */
    public final StringProperty value = new SimpleStringProperty("");

    /**
     * 
     */
    public String clear() {
        String current = value.get();

        // clear value

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
}
