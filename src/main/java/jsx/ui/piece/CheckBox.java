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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.style.StyleDescriptor;
import jsx.style.value.AnimationFrames;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.LowLevelWidget;
import jsx.ui.Style;

/**
 * @version 2015/10/06 13:48:53
 */
public class CheckBox extends LowLevelWidget<CheckBox> {

    /** The checkbox size. */
    private static final Numeric checkSize = new Numeric(14, Unit.px);

    /** The check status. */
    public final BooleanProperty check;

    /** The associated label. */
    public final StringProperty label;

    /**
     * <p>
     * Create Checkbox.
     * </p>
     * 
     * @param value
     * @param label
     */
    public CheckBox(BooleanProperty value, StringProperty label) {
        if (value == null) value = new SimpleBooleanProperty();
        if (label == null) label = new SimpleStringProperty();

        this.check = value;
        this.label = label;

        when(Click).at($.Root).to(update(e -> check.set(!check.get())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        String id = "checkbox" + hashCode();

        box(Root, $.Root, rootStyle.getValue(), () -> {
            element("input", $.CheckBox, attr("type", "checkbox"), attr("id", id));
            element("label", $.Label, attr("for", id), contents(label.get()));
            element(SVG, "svg", $.SVG, () -> {
                element(SVG, "circle", attr("fill", "#FFF"), attr("cx", checkSize.size / 2), attr("cy", checkSize.size / 2), attr("r", 3));
            });
        });
    }

    /**
     * @version 2015/10/06 13:56:37
     */
    private static class $ extends StyleDescriptor {

        static Numeric labelGap = new Numeric(8, px);

        static Numeric checkBorderWidth = new Numeric(1, px);

        static Color checkColor = Color.rgb("#CFD9DB");

        static Color checkColorFocus = Color.rgb("#2C97DE");

        static AnimationFrames bounce = new AnimationFrames().frame(0, 100, () -> {
            transform.translateY(50, percent).scale(1);
        }).frame(50, () -> {
            transform.translateY(50, percent).scale(0.8);
        });

        static Style Root = () -> {
            display.inlineBlock();
            position.relative();
            text.unselectable();
        };

        static Style CheckBox = () -> {
            display.none(); // hide default UI
        };

        static Style Label = () -> {
            padding.left(checkSize.add(labelGap));
            cursor.pointer();

            after(() -> {
                content.text("");
                display.block();
                position.centerVertically().left(0, px);

                border.width(checkBorderWidth).solid().color(checkColor).radius(50, percent);
                box.size(checkSize).shadow(shadow().blurRadius(0, px).offset(1, 1, px).inset().color(Color.rgba(0, 0, 0, 0.08)));
            });

            adjacentChecked(() -> {
                after(() -> {
                    background.color(checkColorFocus);
                    border.color(checkColorFocus);
                    box.shadow(shadow().blurRadius(6, px).offset(0, 0, px).color(Color.rgba(44, 151, 222, 0.4)));

                    animation.duration(0.3, s).name(bounce);
                });
            });
        };

        static Style SVG = () -> {
            display.none();
            box.size(checkSize);
            position.centerVertically().left(0, px);

            siblingChecked(() -> {
                display.block();
                animation.duration(0.3, s).name(bounce);
            });
        };
    }
}
