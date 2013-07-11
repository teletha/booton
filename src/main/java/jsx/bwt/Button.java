/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import jsx.bwt.FormUIStyle.ButtonForm;
import jsx.bwt.FormUIStyle.Icons;
import jsx.jQuery.Listener;

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

    /**
     * @param label
     */
    public Button(Icon icon, Listener action) {
        this("", action);

        form.add(Icons.class).attr("icon", icon.code);
    }

    /**
     * @param label
     */
    public Button(Icon icon, Object subscriber) {
        this("", subscriber);

        form.add(Icons.class).attr("icon", icon.code);
    }

    /**
     * @param label
     */
    public Button(String label, Object subscriber) {
        super("span");

        form.add(ButtonForm.class).text(label).bind(subscriber);

        this.label = label;
    }

    public void label(String label) {
        form.text(label);
    }
}
