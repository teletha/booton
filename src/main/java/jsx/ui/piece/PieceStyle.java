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

import jsx.style.Style;
import jsx.style.StyleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Font;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;

/**
 * @version 2014/11/18 15:21:09
 */
public class PieceStyle extends StyleDescriptor {

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

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    static Style FormBase = () -> {
        // Required property for single line form.
        box.height(SingleLineFormHeight);

        // Required property for single line form.
        text.verticalAlign.middle();

        // Required property for single line form.
        outline.none();

        // Customizable properties.
        display.inlineBlock();
        padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
    };

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    static Style BorderedFormBase = () -> {
        FormBase.style();
        border.solid().width(BorderWidth).color(BorderColor).radius(BorderRadius);

        focus(() -> {
            border(BorderFocusColor);
        });
    };

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    static Style InputBase = () -> {
        BorderedFormBase.style();
        box.width(SingleLineFormWidth);
    };

    static Style InputForm = () -> {
        InputBase.style();
    };

    static Style SpriteBackground = () -> {
        background.image(BackgroundImage.none().cover().borderBox().noRepeat());
        display.block();
    };
}
