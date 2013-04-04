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

import java.util.List;

import js.ui.FormUIStyle.SelectArrow;
import js.ui.FormUIStyle.SelectForm;
import js.ui.FormUIStyle.SelectItem;
import js.ui.FormUIStyle.SelectItemList;
import js.ui.model.SelectableModel;
import js.ui.view.ScrollableListView;
import js.ui.view.ScrollableListView.ItemProvider;
import js.ui.view.SlidableView;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select<M> extends FormUI<Select> {

    /** The item list. */
    private final Items items = new Items();

    /** The associated model. */
    private final SelectableModel<M> model = new SelectableModel();

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select() {
        form.addClass(SelectForm.class).attr("type", "input").attr("placeholder", "Mastery Set Name");
        jQuery arrow = root.child(SelectArrow.class);

        ScrollableListView list = new ScrollableListView(10, 28).provide(items);
        list.root.addClass(SelectItemList.class);
        list.root.click(new Listener() {

            @Override
            public void handler(Event event) {
                form.val($(event.target).attr("index"));
            }
        });

        SlidableView slide = new SlidableView(list);
        slide.register(arrow);

        root.append(slide);
    }

    /**
     * <p>
     * Set item models to select.
     * </p>
     * 
     * @param items
     * @return A chainable API.
     */
    public Select<M> model(M... items) {
        model.clear();

        for (M item : items) {
            model.add(item);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Return the current items.
     * </p>
     * 
     * @return
     */
    public List<M> model() {
        return model;
    }

    /**
     * @version 2013/04/04 20:05:56
     */
    private static class Items implements ItemProvider<String> {

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
    }
}
