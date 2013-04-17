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

import js.ui.FormUIStyle.ButtonForm;
import js.util.jQuery.Listener;

/**
 * @version 2013/04/17 16:09:04
 */
public class Button extends FormUI<Button> {

    /** The current label text. */
    private String label;

    /**
     * @param label
     */
    public Button(String label, Listener action) {
        super("span");

        form.add(ButtonForm.class).text(label).click(action);

        this.label = label;
    }

    public void label(String label) {
        form.text(label);
    }
}
