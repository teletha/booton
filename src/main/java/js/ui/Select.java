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

import js.ui.FormUIStyle.SelectArrow;
import js.ui.FormUIStyle.SelectForm;
import js.ui.FormUIStyle.SelectItem;
import js.ui.FormUIStyle.SelectItemList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select extends FormUI<Select> {

    private ModelProvider provider;

    private jQuery items;

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select() {
        form.addClass(SelectForm.class).attr("type", "input").attr("placeholder", "Mastery Set Name");

        jQuery e = root.child(SelectArrow.class);
        e.click(new Listener() {

            @Override
            public void handler(Event event) {
                getItemListElement();
            }
        });
    }

    public void model(ModelProvider provider) {
        this.provider = provider;
    }

    private jQuery getItemListElement() {
        if (items == null) {
            items = root.child(SelectItemList.class);

            for (int i = 0; i < provider.size(); i++) {
                Object model = provider.item(i);

                items.child(SelectItem.class).text(provider.name(model));
            }

            items.click(new Listener() {

                @Override
                public void handler(Event event) {
                    System.out.println(event.target);
                }
            });
        }
        return items;
    }
}
