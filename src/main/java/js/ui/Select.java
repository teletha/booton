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

import js.ui.FormUIStyle.InputForm;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select extends FormUI<Select> {

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select() {
        form.add(InputForm.class).set("type", "input").set("readonly", "true").set("value", "aaa");
    }
}
