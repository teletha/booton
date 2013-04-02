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
import js.ui.ScrollableList.ItemProvider;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select extends FormUI<Select> {

    private ModelProvider provider;

    private ScrollableList items;

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
                items.root.slideToggle(200);
            }
        });

        items = new ScrollableList(16, form.height()).provide(new ItemProvider<String>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public int countItem() {
                return 200;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String item(int index) {
                return String.valueOf(index);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void render(int index, jQuery element, String model) {
                element.addClass(SelectItem.class).attr("index", index).text(model);
            }
        });
        items.root.addClass(SelectItemList.class).click(new Listener() {

            @Override
            public void handler(Event event) {
                jQuery element = $(event.target);
                form.val(element.text());

                items.root.slideToggle(200);
            }
        });

        root.append(items);
    }

    public void model(ModelProvider provider) {
        this.provider = provider;
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
