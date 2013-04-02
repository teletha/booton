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

import static js.lang.Global.*;
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

        root.child(SelectArrow.class).click(new Listener() {

            @Override
            public void handler(Event event) {
                getItemListElement().slideToggle(200);
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

                items.child(SelectItem.class).attr("index", i).text(provider.name(model));
            }

            items.click(new Listener() {

                @Override
                public void handler(Event event) {
                    jQuery element = $(event.target);
                    Object model = provider.item(Integer.parseInt(element.attr("index")));
                    form.val(provider.name(model));

                    getItemListElement().slideToggle();
                }
            });
        }

        return items;
    }

    /**
     * @version 2013/04/02 15:13:17
     */
    public static interface Provider<M> {

        int size();

        int itemHeight();

        /**
         * <p>
         * Create list item view.
         * </p>
         * 
         * @param item
         * @param model
         */
        void buildItemView(jQuery item, M model);
    }
}
