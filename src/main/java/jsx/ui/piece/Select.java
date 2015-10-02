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
import static jsx.ui.piece.SlidableViewStyle.*;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.scene.control.SingleSelectionModel;

import jsx.ui.Style;
import jsx.ui.Widget;

/**
 * @version 2015/03/06 13:51:48
 */
public class Select<M> extends Widget {

    /** The selectable values. */
    public final ListProperty<M> values;

    /** The selection model. */
    public final SingleSelectionModel<M> selection;

    /** The current slide state. */
    public final StyleProperty shown = new StyleProperty(Shown);

    private final Input input = UI.input();

    private final Button button = UI.button().label("↓").click(shown::toggle);

    /**
     * @param values
     */
    Select(ListProperty<M> values) {
        this.values = values;
        this.selection = new SingleSelectionProperty(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        box($.Root, () -> {
            element("select", $.Select, contents(values, value -> {
                element("option", () -> {
                    text(value);
                });
            }));
            element(SVG, "svg", $.SVGRoot, size(16, 16), position(0, 0), viewBox(0, 0, 16, 16), () -> {
                element(SVG, "g", () -> {
                    element(SVG, "polygon", $.Mark, attr("points", "0.9,5.5 3.1,3.4 8,8.3 12.9,3.4 15.1,5.5 8,12.6"));
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
     * @version 2015/09/30 23:58:56
     */
    private static class $ extends PieceStyle {

        static Style Root = () -> {
            display.inlineBlock();
            position.relative();
        };

        static Style Select = InputBase.with(() -> {
            cursor.pointer();
        });

        static Style SVGRoot = () -> {
            position.centerVertically().right(FormHorizontalPadding);
            box.size(16, px);
            pointerEvents.none();
        };

        static Style Mark = () -> {
            fill.color(BorderColor);

            ancestorHover(Root, () -> {
                fill.color(BorderColorFocused);
            });
        };
    }
}
