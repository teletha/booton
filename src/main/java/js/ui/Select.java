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
import js.ui.SelectStyle.SelectArrow;
import js.ui.SelectStyle.SelectForm;
import js.ui.SelectStyle.SelectItem;
import js.ui.SelectStyle.SelectItemList;
import js.ui.model.Selectable;
import js.ui.model.SelectableListener;
import js.ui.view.ScrollableListView;
import js.ui.view.ScrollableListView.ItemRenderer;
import js.ui.view.SlidableView;
import js.ui.view.SlidableView.OpenEvent;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select<M> extends FormUI<Select> {

    /** The associated model. */
    public final Selectable<M> model;

    /** The option list. */
    public final SlidableView options;

    /** The associated view. */
    protected final ScrollableListView view;

    /** The view-model binder. */
    private final Binder binder = new Binder();

    /**
     * <p>
     * Create select form.
     * </p>
     */
    public Select(M... model) {
        this(new Selectable(model));
    }

    /**
     * <p>
     * Create select form.
     * </p>
     */
    public Select(Selectable<M> model) {
        this.model = model;
        this.model.register(binder);

        form.addClass(SelectForm.class).attr("type", "input").attr("placeholder", "Mastery Set Name");

        view = new ScrollableListView(10, 28).provide(binder);
        view.root.addClass(SelectItemList.class).click(new Listener() {

            @Override
            public void handler(Event event) {
                Select.this.model.setSelectionIndex(Integer.parseInt($(event.target).attr("index")));
            }
        });

        options = root.child(new SlidableView(view, root.child(SelectArrow.class)));
        options.register(binder);

        eventBus.register(this);
    }

    private EventBus eventBus = new EventBus();

    @Subscriber
    private void listen(OpenEvent event) {
        System.out.println("open");
        System.out.println(OpenEvent.class);
        System.out.println(event);
    }

    /**
     * @version 2013/04/05 10:06:20
     */
    private class Binder implements ItemRenderer, SelectableListener<M>, SlidableView.Listener {

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
        public void renderItem(int itemIndex, jQuery element) {
            element.addClass(SelectItem.class).attr("index", itemIndex).text(model.get(itemIndex));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void select(int index, M item) {
            form.val(item.toString());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void deselect(int index, M item) {
            form.val("");
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
        public void remove(int index, M item) {
            view.provide(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void open() {
            System.out.println("open");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void close() {
            System.out.println("close");
        }
    }
}
