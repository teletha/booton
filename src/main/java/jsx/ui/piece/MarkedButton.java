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

import static js.dom.UIAction.*;
import static jsx.ui.StructureDescriptor.*;

import java.util.Objects;

import javafx.beans.property.Property;

import js.dom.UIEvent;
import jsx.style.ValueStyle;
import jsx.style.value.AnimationFrames;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.Style;

/**
 * @version 2015/10/12 11:18:05
 */
abstract class MarkedButton<T extends MarkedButton<T, V>, V> extends LowLevelWidget<T> {

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

    /**
     * <p>
     * Create marked button.
     * </p>
     * 
     * @param type
     * @param name
     * @param value
     * @param label
     */
    protected MarkedButton(String type, Property group, V value, String label) {
        super(value);

        Objects.nonNull(group);
        Objects.nonNull(value);

        this.type = type;
        this.name = "Group" + group.hashCode();
        this.value = value;
        this.label = label;
        this.id = "Mark" + hashCode();

        when(Change).at($.Root).to(update(this::change));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void virtualize() {
        box(Root, $.Root, rootStyle.getValue(), If(isMarked(), $.Checked), () -> {
            html("input", $.CheckBox, attr("type", type), attr("name", name), attr("id", id));
            html("label", $.Label.of(radius()), attr("for", id), contents(label));
            svg("svg", $.SVG, () -> {
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
     * <p>
     * Calculate border radius.
     * </p>
     * 
     * @return
     */
    protected abstract Numeric radius();

    /**
     * <p>
     * Test whether this button is marked or not.
     * </p>
     * 
     * @return
     */
    protected abstract boolean isMarked();

    /**
     * <p>
     * Change the selection.
     * </p>
     */
    protected abstract void change(UIEvent event);

    /**
     * @version 2015/10/12 11:17:56
     */
    protected static class $ extends PieceStyle {

        /** The mark size. */
        static Numeric markSize = new Numeric(14, Unit.px);

        static Numeric labelGap = new Numeric(8, px);

        static Numeric markLineWidth = new Numeric(1, px);

        static Color markColor = Color.rgb("#CFD9DB");

        static Color markFocusColor = Color.rgb("#2C97DE");

        static AnimationFrames bounce = new AnimationFrames().frame(0, 100, () -> {
            transform.translateY(50, percent).scale(1);
        }).frame(50, () -> {
            transform.translateY(50, percent).scale(0.8);
        });

        static Style Checked = () -> {
        };

        static Style Root = () -> {
            display.inlineBlock();
            position.relative();
            text.unselectable();
            cursor.pointer();
        };

        static Style CheckBox = () -> {
            display.none(); // hide default UI
        };

        static ValueStyle<Numeric> Label = radiusSize -> {
            display.block();
            padding.left(markSize.add(labelGap));
            cursor.pointer();

            after(() -> {
                content.text("");
                display.block();
                position.centerVertically().left(0, px);

                border.width(markLineWidth).solid().color(markColor).radius(radiusSize);
                box.size(14, px).shadow(shadow().blurRadius(0, px).offset(1, 1, px).inset().color(Color.rgba(0, 0, 0, 0.08)));

                parentHover(FocusedBorder);
            });

            insideOf(Checked, () -> {
                after(() -> {
                    background.color(markFocusColor);
                    border.color(markFocusColor);
                    box.shadow(shadow().blurRadius(6, px).offset(0, 0, px).color(Color.rgba(44, 151, 222, 0.4)));

                    animation.duration(0.3, s).name(bounce);
                });
            });
        };

        static Style SVG = () -> {
            display.none();
            box.size(markSize);
            position.centerVertically().left(0, px);
            pointerEvents.none();

            insideOf(Checked, () -> {
                display.block();
                animation.duration(0.3, s).name(bounce);
            });
        };
    }
}
