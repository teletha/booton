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
import js.ui.model.Selectable;
import js.ui.model.SelectableListener;
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

    /** The associated model. */
    public final Selectable<M> model;

    /** The associated view. */
    private final ScrollableListView view;

    /** The view-model binder. */
    private final Binder binder = new Binder();

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select(Selectable<M> model) {
        this.model = model;
        this.model.listen(binder);

        form.addClass(SelectForm.class).attr("type", "input").attr("placeholder", "Mastery Set Name");

        view = new ScrollableListView(10, 28).provide(binder);
        view.root.addClass(SelectItemList.class).click(new Listener() {

            @Override
            public void handler(Event event) {
                form.val($(event.target).attr("index"));
            }
        });

        root.append(new SlidableView(view, root.child(SelectArrow.class)));
    }

    /**
     * @version 2013/04/05 10:06:20
     */
    private class Binder implements ItemProvider<M>, SelectableListener<M> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int countItem() {
            return model.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public M item(int index) {
            return model.get(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void render(int index, jQuery element, M model) {
            element.addClass(SelectItem.class).attr("index", index).text(model);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void select(int index, M item) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void deselect(int index, M item) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(int index, M item) {
            view.provide(this);
            view.render(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove(M item, int index) {
        }
    }
}
