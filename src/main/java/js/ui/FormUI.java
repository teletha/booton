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

import js.dom.Element;

/**
 * @version 2013/03/31 17:40:08
 */
public class FormUI<T extends FormUI> extends ElementBasedUI {

    /** The actual form element. */
    protected final Element form;

    /**
     * 
     */
    public FormUI() {
        this("input");
    }

    /**
     * 
     */
    public FormUI(String form) {
        this.form = root.child(form);
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T disable() {
        form.set("disabled", "");

        return (T) this;
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T enable() {
        form.remove("disabled");

        return (T) this;
    }
}
