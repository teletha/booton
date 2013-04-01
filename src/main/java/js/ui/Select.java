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
import js.dom.Element.Event;
import js.dom.Element.Listener;
import js.ui.FormUIStyle.SelectArrow;
import js.ui.FormUIStyle.SelectForm;
import js.ui.FormUIStyle.SelectItemList;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select extends FormUI<Select> {

    private ModelProvider provider;

    private Element items;

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select() {
        form.add(SelectForm.class).set("type", "input").set("disabled", "");

        Element e = root.child(SelectArrow.class);
        e.addEventListener("click", new Listener() {

            @Override
            public void handleEvent(Event event) {

            }
        });
    }

    public void model(ModelProvider provider) {
        this.provider = provider;
    }

    private Element getItemListElement() {
        if (items == null) {
            items = root.child(SelectItemList.class);
        }
        return items;
    }
}
