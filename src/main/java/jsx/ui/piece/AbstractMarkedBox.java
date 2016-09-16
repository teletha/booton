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

import static js.dom.User.*;
import static jsx.ui.StructureDescriptor.*;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.beans.property.Property;

import js.dom.UIEvent;
import jsx.style.BinaryStyle;
import jsx.style.value.Color;
import jsx.style.value.Font;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.Style;
import jsx.ui.piece.AbstractMarkedBox.Styles;

/**
 * @version 2016/09/15 0:14:26
 */
public abstract class AbstractMarkedBox<T extends AbstractMarkedBox<T, V>, V> extends LowLevelWidget<Styles, T> {

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

        when(Change).at($.Root).to(update(changeListener::accept));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void virtualize() {
        box(WidgetRoot, $.Root, userStyle.getValue(), If(isMarked, $.Checked), () -> {
            html("input", $.Input, attr("type", type), attr("name", name), attr("id", id));
            html("label", $.Label, attr("for", id), contents(label));
        });
    }

    /**
     * <p>
     * Vritualize the mark of this button.
     * </p>
     */
    protected abstract void virtualizeMark();

    /**
     * @version 2016/09/15 9:27:11
     */
    public static class Styles extends PieceStyle {

        /** The mark size. */
        public static Numeric markSize = new Numeric(14, Unit.px);

        Style Checked = () -> {
        };

        Style Root = () -> {
            display.inlineBlock();
            position.relative();
            text.unselectable();
            cursor.pointer();
        };

        Style Input = () -> {
            box.opacity(0).zIndex(1);
            position.absolute();
            margin.top(4, px).left(-20, px);
            padding.size(0, px);
        };

        Style Label = () -> {
            display.block();
            padding.left(markSize.add(8));
            cursor.pointer();

            before(() -> {
                content.text("");
                display.inlineBlock();
                position.absolute().left(0, px);
                box.size(16, px);
                border.solid().width(1, px).color("#ccc").radius(3, px);

                transit().duration(300, ms).whenSiblingChecked(() -> {
                    background.color("#337ab7");
                    border.color("#337ab7");
                });
            });

            after(() -> {
                display.inlineBlock();
                position.absolute().left(0, px).top(0, px);
                box.size(16, px).opacity(0);
                padding.left(3, px).top(2, px);
                font.family(Font.Awesome).monospace().size(10, px).color("#fff");
                content.text("\\f00c");

                transit().duration(300, ms).whenSiblingChecked(() -> {
                    box.opacity(1);
                });
            });
        };

        Style SVG = () -> {
            box.size(markSize);
            position.centerVertically().left(0, px);
            pointerEvents.none();
        };

        /** The box style. */
        public Style RadioBox = () -> {
            fill.color(Color.White);
            stroke.color(BorderColor).width(BorderWidth);
        };

        /** The mark style. */
        public Style RadioMark = () -> {
            fill.color(BorderColor.lighten(5)).opacity(0);

            transit().duration(300, ms).whenIn(Checked, () -> {
                fill.opacity(1);
            });
        };

        /** The box style. */
        public Style CheckBox = () -> {
            fill.color(Color.White);
            stroke.color(BorderColor.lighten(-20)).width(BorderWidth).linecap.square().miterLimit(1);
        };

        /** The mark style. */
        public BinaryStyle CheckMark = on -> {
            fill.none();
            stroke.color(BorderColor.lighten(-10)).width(2, px).linecap.square().miterLimit(1).opacity(0);
            transit().duration(300, ms).whenever();

            if (on) {
                stroke.opacity(1);
            }
        };
    }
}
