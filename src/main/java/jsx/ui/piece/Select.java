/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.scene.control.SingleSelectionModel;

import jsx.style.Style;
import jsx.ui.StructureDSL;
import jsx.ui.User;
import jsx.ui.Widget;
import jsx.ui.piece.Select.Styles;

/**
 * @version 2016/10/20 11:00:29
 */
public class Select<M> extends Widget<Styles> {

    /** The selectable values. */
    private final ListProperty<M> values;

    /** The selection model. */
    private final Property<M> selection;

    /**
     * <p>
     * Create select UI.
     * </p>
     * 
     * @param values The values.
     * @param selection A selected value.
     */
    Select(ListProperty<M> values, Property<M> selection) {
        this.values = values;
        this.selection = selection;

        when(User.Change).at($.Select).sideEffect(updateView).to(e -> selection.setValue(values.get(Integer.valueOf(e.value()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        new StructureDSL() {
            {
                html("select", $.Select, contents(values, (index, value) -> {
                    html("option", attr("value", index), If(selection.getValue().equals(value), attr("selected")), () -> {
                        text(value);
                    });
                }));
            }
        };
    }

    /**
     * @version 2015/03/06 14:04:02
     */
    static class SingleSelectionProperty<M> extends SingleSelectionModel<M> {

        /** The item list. */
        private final List<M> items = new ArrayList();

        /**
         * @param initialSelection
         */
        SingleSelectionProperty(Enum initialSelection) {
            for (Enum constant : initialSelection.getClass().getEnumConstants()) {
                items.add((M) constant);
            }
            select((M) initialSelection);
        }

        /**
         * @param selections
         */
        SingleSelectionProperty(Class<? extends Enum> selections) {
            for (Enum constant : selections.getEnumConstants()) {
                items.add((M) constant);
            }
        }

        /**
         * @param selections
         */
        SingleSelectionProperty(List<M> selections) {
            items.addAll(selections);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getItemCount() {
            return items.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected M getModelItem(int index) {
            return items.get(index);
        }
    }

    /**
     * @version 2016/10/20 11:00:16
     */
    static class Styles extends PieceStyle {

        Style Select = SingleLineFormBase.with(() -> {
            cursor.pointer();
        });
    }
}
