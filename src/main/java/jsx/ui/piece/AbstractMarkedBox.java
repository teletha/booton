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

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.beans.property.Property;

import js.dom.UIEvent;
import jsx.style.Style;
import jsx.style.value.Color;
import jsx.style.value.Font;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.StructureDSL;
import jsx.ui.User;
import jsx.ui.piece.AbstractMarkedBox.Styles;

/**
 * @version 2016/09/17 9:17:06
 */
class AbstractMarkedBox<W extends AbstractMarkedBox<W, V>, V> extends LowLevelWidget<Styles, W> {

    /** The button type. */
    private final String type;

    /** The group name. */
    private final String name;

    /** The associated value. */
    protected final V value;

    /** The associated label. */
    public final String label;

    /** The checkbox id. */
    private final String id;

    /** The selection manager. */
    protected final Supplier<Boolean> isMarked;

    /**
     * <p>
     * Create a marked button.
     * </p>
     * 
     * @param type A button type for HTML.
     * @param values The selected values for the value group.
     * @param value An associated value.
     * @param label An label name.
     * @param isMarked An initial state.
     * @param changeListener A change event listener.
     */
    protected AbstractMarkedBox(String type, Property values, V value, String label, Supplier<Boolean> isMarked, Consumer<UIEvent> changeListener) {
        super(value);

        Objects.nonNull(values);
        Objects.nonNull(value);

        this.type = type;
        this.name = "Group" + values.hashCode();
        this.value = value;
        this.label = label;
        this.id = "Mark" + hashCode();
        this.isMarked = isMarked;

        when(User.Change).at($.Root).sideEffect(updateView).to(changeListener::accept);
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends StructureDSL {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            box(WidgetRoot, $.Root, userStyle, () -> {
                html("input", $.Input, attr("type", type), attr("name", name), attr("id", id), If(isMarked, attr("checked")));
                html("label", $.Label, attr("for", id), contents(label));
            });
        }
    }

    /**
     * @version 2016/09/15 9:27:11
     */
    static class Styles extends PieceStyle {

        Numeric boxSize = new Numeric(14, Unit.px);

        Style Root = () -> {
            display.inlineBlock();
            position.relative();
            text.unselectable();
            cursor.pointer();
        };

        Style Input = () -> {
            display.none();

        };

        Style Label = () -> {
            display.block();
            padding.left(boxSize.add(8));
            cursor.pointer();

            // write outline box
            before(() -> {
                content.text("");
                display.inlineBlock().size(boxSize);
                position.absolute().left(0, em).top(0, em);
                border.solid().width(BorderWidth).color(BorderColor);

                prev().attr("type").is("checkbox", () -> {
                    border.radius(BorderRadius);
                });

                prev().attr("type").is("radio", () -> {
                    border.radius(boxSize.divide(2));
                });

                transit().duration(300, ms).when().prev().checked(() -> {
                    background.color("#337ab7");
                    border.color("#337ab7");
                });
            });

            // write check mark
            after(() -> {
                content.text("\\f00c");
                display.inlineBlock().size(boxSize).opacity(0);
                position.absolute().left(0, px).top(0, px);
                padding.top(2, px).left(2, px);
                font.family(Font.Awesome).size(10, px).color(Color.White);

                transit().duration(300, ms).when().prev().checked(() -> {
                    display.opacity(1);
                });
            });
        };
    }
}
