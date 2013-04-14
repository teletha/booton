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

import js.ui.FormUIStyle.FormComponent;
import js.util.jQuery;

/**
 * @version 2013/03/31 17:40:08
 */
public class FormUI<T extends FormUI> extends UI {

    /** The actual form element. */
    public final jQuery form;

    /**
     * 
     */
    public FormUI() {
        this("input");
    }

    /**
     * 
     */
    public FormUI(String elementName) {
        root.add(FormComponent.class);

        form = root.child(elementName);
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T disable() {
        form.attr("disabled", "");

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
        form.removeAttr("disabled");

        return (T) this;
    }

    /**
     * <p>
     * Focus this form.
     * </p>
     */
    public void focus() {

    }
}
