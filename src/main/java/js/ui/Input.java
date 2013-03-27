/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import js.ui.InputStyle.InputForm;
import js.util.jQuery;

/**
 * @version 2013/03/28 1:31:15
 */
public class Input extends UI {

    /** The input element. */
    private final jQuery input;

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Input() {
        input = root.child("input").addClass(InputForm.class).attr("type", "text");
    }

    /**
     * <p>
     * Set placeholder text.
     * </p>
     * 
     * @param text
     * @return
     */
    public Input placeholder(String text) {
        input.attr("placeholder", text);

        // Chainable API
        return this;
    }
}
