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
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.Style;
import jsx.ui.piece.AbstractMarkedBox.Styles;

/**
 * @version 2016/09/15 0:14:26
 */
abstract class AbstractMarkedBox<T extends AbstractMarkedBox<T, V>, V> extends LowLevelWidget<Styles, T> {

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
    private final Supplier<Boolean> isMarked;

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
        box(WidgetRoot, $.Root, userStyle.getValue(), If(isMarked.get(), $.Checked), () -> {
            html("input", $.Input, attr("type", type), attr("name", name), attr("id", id));
            html("label", $.Label, attr("for", id), contents(label));
            svg("svg", $.SVG, attr("viewBox", "0 0 14 14"), () -> {
                virtualizeMark();
            });
        });
    }

    /**
     * <p>
     * Vritualize the mark of this button.
     * </p>
     */
    protected abstract void virtualizeMark();

    /**
     * @version 2015/10/12 11:17:56
     */
    protected static class Styles extends PieceStyle {

        /** The mark size. */
        static Numeric markSize = new Numeric(14, Unit.px);

        static Color base = Color.Black.lighten(25);

        Style Checked = () -> {
        };

        Style Root = () -> {
            display.inlineBlock();
            position.relative();
            text.unselectable();
            cursor.pointer();
        };

        Style Input = () -> {
            display.none(); // hide default UI
        };

        Style Label = () -> {
            display.block();
            padding.left(markSize.add(8));
            cursor.pointer();
        };

        Style SVG = () -> {
            box.size(markSize);
            position.centerVertically().left(0, px);
            pointerEvents.none();
        };

        /** The box style. */
        Style RadioBox = () -> {
            fill.color(Color.White);
            stroke.color(Styles.base).width(2, px);
        };

        /** The mark style. */
        Style RadioMark = () -> {
            fill.color(Styles.base.lighten(5)).opacity(0);

            transit().duration(500, ms).whenIn(Checked, () -> {
                fill.opacity(1);
            });
        };

        /** The box style. */
        Style CheckBox = () -> {
            fill.color(Color.White);
            stroke.color(Styles.base).width(2, px).linecap.square().miterLimit(1);
        };

        /** The mark style. */
        Style CheckMark = () -> {
            fill.none();
            stroke.color(Styles.base).width(2, px).linecap.square().miterLimit(1).opacity(0);

            transit().duration(500, ms).whenIn(Checked, () -> {
                stroke.opacity(1);
            });
            transit().duration(100, ms).whenParentHover(Root, () -> {
                stroke.opacity(0.5);
            });
        };
    }
}
