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

import kiss.Event;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends Piece {

    public final StringProperty value = new SimpleStringProperty();

    /**
     * @return
     */
    public String value() {
        return null;
    }

    /**
     * 
     */
    public String clear() {
        String current = value();

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

    protected Input placeholder(Event<String> value) {
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
