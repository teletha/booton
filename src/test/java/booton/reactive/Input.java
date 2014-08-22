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

import kiss.Event;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends Piece {

    public Event<String> value;

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

    /**
     * Configure requirement.
     * 
     * @return
     */
    protected Input require() {
        return this;
    }
}
