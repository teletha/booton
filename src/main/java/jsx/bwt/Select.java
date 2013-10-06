/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import js.dom.Element;
import js.dom.EventListener;
import jsx.bwt.FormUIStyle.Focus;
import jsx.bwt.SelectStyle.SelectArrow;
import jsx.bwt.SelectStyle.SelectForm;
import jsx.bwt.SelectStyle.SelectItem;
import jsx.bwt.SelectStyle.SelectItemList;
import jsx.bwt.SelectStyle.SelectedItem;
import jsx.bwt.view.ScrollableListView;
import jsx.bwt.view.ScrollableListView.ItemRenderer;
import jsx.bwt.view.SlidableView;
import jsx.model.SelectableModel;
import jsx.model.SelectableModel.Add;
import jsx.model.SelectableModel.Deselect;
import jsx.model.SelectableModel.Remove;

/**
 * @version 2013/07/29 2:00:34
 */
public class Select<M> extends FormUI<Select> {

    /** The associated model. */
    public final SelectableModel<M> model;

    /** The option list. */
    public final SlidableView options;

    /** The associated view. */
    protected final ScrollableListView view;

    /** The view-model binder. */
    private final Binder binder = new Binder();

    /** The select button. */
    private final Button arrow;

    /**
     * <p>
     * Create select form.
     * </p>
     */
    public Select(M... model) {
        this(new SelectableModel(model));
    }

    /**
     * <p>
     * Create select form.
     * </p>
     */
    public Select(SelectableModel<M> selectable) {
        model = selectable;
        model.register(binder);

        form.add(SelectForm.class).attr("type", "input").attr("placeholder", "Mastery Set Name");

        view = new ScrollableListView(10, 28).provide(binder);
        view.root.add(SelectItemList.class).bind(binder);

        arrow = root.child(new Button(Icon.BottomArrow, new EventListener() {

            @Override
            public void handleEvent(UIEvent event) {
                options.toggle();
            }
        }));
        arrow.root.add(SelectArrow.class);

        options = root.child(new SlidableView(view));
        // options.bind(binder);

        if (model.size() == 0) {
            disable();
        }
    }

    @Listen(type = UIAction.Key_Up)
    private void selectPrevious() {
        model.selectPrevious();
    }

    @Listen(type = UIAction.Key_Down)
    private void selectNext() {
        model.selectNext();
    }

    @Listen(type = UIAction.Focus)
    private void startInput() {
        root.add(Focus.class);
    }

    @Listen(type = UIAction.Blur)
    private void endInput() {
        root.remove(Focus.class);
    }

    /**
     * @version 2013/07/31 1:26:46
     */
    private class Binder implements ItemRenderer {

        @Listen(type = UIAction.Click)
        private void selectItem(UIEvent event) {
            model.setSelectionIndex(Integer.parseInt(event.target.attr("index")));
        }

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
        public void renderItem(int itemIndex, Element element) {
            element.add(SelectItem.class).attr("index", itemIndex).text(model.get(itemIndex));

            if (itemIndex == model.getSelectionIndex()) {
                element.add(SelectedItem.class);
            } else {
                element.remove(SelectedItem.class);
            }
        }

        @Subscribe(jsx.model.SelectableModel.Select.class)
        public void select(jsx.model.SelectableModel.Select select) {
            System.out.println("select");
            form.val(select.item.toString());

            view.render(select.index);
        }

        @Subscribe(Deselect.class)
        public void deselect(Deselect event) {
            view.render(event.index);
        }

        @Subscribe(Add.class)
        public void add(Add event) {
            view.provide(this);
            view.render(event.index);

            enable();
        }

        @Subscribe(Remove.class)
        public void remove(Remove event) {
            view.provide(this);

            if (model.size() == 0) {
                disable();
            }
        }
    }
}
