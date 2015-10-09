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

import java.util.function.Consumer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.StringProperty;

import js.lang.NativeBoolean;
import jsx.style.ValueStyle;
import jsx.style.value.AnimationFrames;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.Style;

/**
 * @version 2015/10/09 15:09:12
 */
abstract class MarkedButton<T extends MarkedButton<T>> extends LowLevelWidget<T> {

    /** The mark size. */
    protected static final Numeric markSize = new Numeric(14, Unit.px);

    /** The button type. */
    private final String type;

    /** The group name. */
    private final String name;

    /** The check status. */
    public final ReadOnlyBooleanProperty check;

    /** The associated label. */
    public final StringProperty label;

    /** The checkbox id. */
    private final String id;

    /**
     * <p>
     * Create Checkbox.
     * </p>
     * 
     * @param value
     * @param label
     */
    protected MarkedButton(String type, String name, BooleanProperty value, StringProperty label) {
        this.type = type;
        this.name = name;
        this.check = value;
        this.label = label;
        this.id = "Mark" + check.hashCode();

        // when(Click).at($.Root).to(e -> {
        // // e.preventDefault();
        //
        // check.set(!check.get());
        // });

        when(Change).at($.Root).to(v -> {
            NativeBoolean state = (NativeBoolean) v.target.property("checked");
            System.out.println("Value changed " + state);
            value.set(state.booleanValue());
        });
    }

    public T change(Consumer<Boolean> value) {
        check.addListener((object, oldValue, newValue) -> {
            value.accept(newValue);
        });
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void virtualize() {
        box(Root, $.Root, rootStyle.getValue(), If(check, $.Checked), () -> {
            html("input", $.CheckBox, attr("type", type), attr("name", name), attr("id", id));
            html("label", $.Label.of(radius()), attr("for", id), contents(label.get()));
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
     * @version 2015/10/06 13:56:37
     */
    protected static class $ extends PieceStyle {

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

        static ValueStyle<Numeric> Label = radius -> {
            padding.left(markSize.add(labelGap));
            cursor.pointer();

            after(() -> {
                content.text("");
                display.block();
                position.centerVertically().left(0, px);

                border.width(markLineWidth).solid().color(markColor).radius(radius);
                box.size(markSize).shadow(shadow().blurRadius(0, px).offset(1, 1, px).inset().color(Color.rgba(0, 0, 0, 0.08)));

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
