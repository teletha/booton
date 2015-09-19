/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import jsx.style.Style;
import jsx.style.StyleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Font;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;

/**
 * @version 2014/11/11 21:54:39
 */
class FormUIStyle extends StyleDescriptor {

    // ===========================================
    // Form Related Style
    // ===========================================
    protected static final Numeric FormFontSize = new Numeric(14, px);

    // ===========================================
    // Border Related Style
    // ===========================================
    protected static final Numeric BorderWidth = new Numeric(1, px);

    protected static final Numeric BorderRadius = new Numeric(3, px);

    protected static final Color BorderColor = new Color(0, 0, 80);

    protected static final Color BorderInsetShadow = new Color(0, 0, 0, 0.1);

    protected static final Color BorderFocusColor = new Color(206, 79, 62, 0.8);

    /** The general single line form width. */
    protected static final Numeric SingleLineFormWidth = new Numeric(185, px);

    /** The general single line form height. */
    protected static final Numeric SingleLineFormHeight = new Numeric(28, px);

    /** The general form padding. */
    protected static final Numeric FormVerticalPadding = new Numeric(4, px);

    /** The general form padding. */
    protected static final Numeric FormHorizontalPadding = new Numeric(6, px);

    protected static final Color SelectColor = new Color(206, 79, 62, 0.8);

    // ===========================================
    // Icon Related Style
    // ===========================================
    protected static final Font IconFont = new Font("icon.css");

    /** The general icon size. */
    protected static final Numeric IconSize = SingleLineFormHeight;

    protected static final Shadow in = shadow().offset(0, 2, px).blurRadius(4, px).inset().color(Color.Black.opacify(-0.85));

    protected static final Shadow out = shadow().offset(0, 1, px).blurRadius(2, px).color(Color.Black.opacify(-0.95));

    /**
     * @version 2013/04/22 9:40:10
     */
    static Style Focus = () -> {
        // marker
    };

    /**
     * <p>
     * Root style of form component.
     * </p>
     * 
     * @version 2013/04/22 9:38:52
     */
    static Style FormRoot = () -> {
        display.inlineBlock();
        position.relative();
        font.size(FormFontSize);

        transit().duration(0.2, s).linear().whenWith(Focus, () -> {
            box.shadow(in, out);
        });

        // insideOf(FormRoot.class, () -> {
        // with(Focus.class, () -> {
        // box.shadow(0, px, 0, px, 0, px, Color.Transparent);
        // });
        // });
    };

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    private static final void baseForm() {
        // Required property for single line form.
        box.height(SingleLineFormHeight);

        // Required property for single line form.
        text.verticalAlign.middle();

        // Required property for single line form.
        outline.none();

        // Customizable properties.
        display.inlineBlock();
        padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    private static final void baseBorderedForm() {
        baseForm();
        border.solid().width(BorderWidth).color(BorderColor).radius(BorderRadius);

        insideOf(Focus, () -> {
            border(BorderFocusColor);
        });
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    protected static final void baseInputForm() {
        baseBorderedForm();
        box.width(SingleLineFormWidth);
    }

    /**
     * <p>
     * Helper method to write border.
     * </p>
     * 
     * @param color A border bolor.
     */
    protected static final void border(Color color) {
        Shadow in = shadow().inset().offset(-1, 1, px).blurRadius(1, px).color(BorderInsetShadow);
        Shadow out = shadow().offset(0, 0, px).blurRadius(8, px).color(color.opacify(-0.2));

        border.color(color);
        box.shadow(in, out);
    }

    static Style ButtonForm = () -> {
        baseBorderedForm();

        Color front = new Color(0, 0, 33);
        Color back = new Color(0, 0, 87);

        // writeBorder();
        cursor.pointer();
        padding.horizontal(15, px);
        font.weight.bolder();
        background.color(back).image(BackgroundImage.of(linear(Color.White, Color.White.opacify(-1))));
        text.decoration.none().shadow(shadow().offset(0, 1, px).color(Color.White.opacify(-0.1))).unselectable();

        // transition.property("background-color").timing.easeOut().duration(0.2, s);

        hover(() -> {
            background.color(back.lighten(6));
        });

        active(() -> {

            border.color(BorderColor.lighten(-20));
            background.color(back.lighten(4)).none();
            box.shadow(in, out);
        });
    };

    static Style InputForm = () -> {
        baseInputForm();
    };

    static Style InvalidInputForm = () -> {
        Shadow shadow = shadow().offset(0, 0, px).blurRadius(8, px).color(BorderFocusColor.adjustHue(-180).opacify(-0.2));

        focus(() -> {
            border(BorderFocusColor.adjustHue(-180));
            box.shadow(shadow);
        });
    };

    static Style Disable = () -> {
        after(() -> {
            display.block();
            box.size(100, percent);
            background.color(Color.Transparent);
            content.text(" ");
            position.absolute().top(0, px).left(0, px);
        });
    };

    static Style Icons = () -> {
        padding.vertical(0, px).horizontal(8, px);
        line.height(IconSize);
        box.size(IconSize);

        after(() -> {
            font.color(BorderColor.lighten(-20));
            text.verticalAlign.middle();
            content.attr("icon");
        });

        hover(() -> {
            after(() -> {
                font.color(BorderColor.lighten(-40));
            });
        });
    };
}
