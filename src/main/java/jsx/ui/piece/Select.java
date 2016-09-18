/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static jsx.ui.StructureDescriptor.*;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.scene.control.SingleSelectionModel;

import js.dom.User;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.piece.Select.Styles;

/**
 * @version 2015/10/20 16:02:38
 */
public class Select<M> extends Widget<Styles> {

    /** The selectable values. */
    private final ListProperty<M> values;

    /** The selection model. */
    private final Property<M> selection;

    /**
     * @param selection
     * @param values
     */
    Select(Property<M> selection, ListProperty<M> values) {
        this.values = values;
        this.selection = selection;

        when(User.Change).at($.Select).to(update(e -> selection.setValue(values.get(Integer.valueOf(e.value())))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        box($.Root, () -> {
            html("select", $.Select, contents(values.size(), i -> {
                M value = values.get(i);

                html("option", attr("value", i), If(selection.getValue().equals(value), attr("selected", "selected")), () -> {
                    text(value);
                });
            }));
            svg("svg", $.SVGRoot, size(16, 16), position(0, 0), viewBox(0, 0, 16, 16), () -> {
                svg("g", () -> {
                    svg("polygon", $.Mark, attr("points", "0.9,5.5 3.1,3.4 8,8.3 12.9,3.4 15.1,5.5 8,12.6"));
                });
            });
        });
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
     * @version 2015/10/05 8:14:05
     */
    static class Styles extends PieceStyle {

        Style Root = () -> {
            display.inlineBlock();
            position.relative();
        };

        Style Select = SingleLineFormBase.with(() -> {
            cursor.pointer();
        });

        Style SVGRoot = () -> {
            position.centerVertically().right(FormHorizontalPadding);
            display.size(16, px);
            pointerEvents.none();
        };

        Style Mark = () -> {
            fill.color(BorderColor);

            ancestor().with(Root).hover(() -> {
                fill.color(BorderColorFocused);
            });
        };
    }
}
