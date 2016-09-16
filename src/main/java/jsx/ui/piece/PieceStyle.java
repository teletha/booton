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

import jsx.style.StyleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;
import jsx.ui.Style;

/**
 * @version 2015/09/29 2:55:11
 */
public class PieceStyle extends StyleDescriptor {

    // ===========================================
    // Form Related Style
    // ===========================================
    protected final Numeric FormFontSize = new Numeric(14, px);

    // ===========================================
    // Border Related Style
    // ===========================================
    protected final Numeric BorderWidth = new Numeric(1, px);

    protected final Numeric BorderRadius = new Numeric(3, px);

    /** The border color. */
    protected final Color BorderColor = new Color(0, 0, 80);

    /** The focused border color. */
    protected final Color BorderColorFocused = new Color(206, 79, 62, 0.8);

    protected final Color BorderInsetShadow = new Color(0, 0, 0, 0.1);

    /** The general single line form width. */
    protected final Numeric SingleLineFormWidth = new Numeric(185, px);

    /** The general single line form height. */
    protected final Numeric SingleLineFormHeight = new Numeric(28, px);

    /** The general form padding. */
    protected final Numeric FormVerticalPadding = new Numeric(4, px);

    /** The general form padding. */
    protected final Numeric FormHorizontalPadding = new Numeric(6, px);

    protected final Color SelectColor = new Color(206, 79, 62, 0.8);

    /** The focused border style. */
    private final Shadow insideShadow = shadow().inset().offset(-1, 1, px).blurRadius(1, px).color(BorderInsetShadow);

    /** The focused border style. */
    private final Shadow outsideShadow = shadow().offset(0, 0, px).blurRadius(8, px).color(BorderColorFocused.opacify(-0.2));

    /**
     * <p>
     * Helper {@link Style} to apply style for the focused border style.
     * </p>
     */
    protected final Style FocusedBorder = () -> {
        border.color(BorderColorFocused).width(BorderWidth).solid();
        display.shadow(insideShadow, outsideShadow);
    };

    /** Abstract base style of form element. */
    Style FormBase = () -> {
        // Required property for single line form.
        display.height(SingleLineFormHeight);

        // Required property for single line form.
        text.verticalAlign.middle();

        // Required property for single line form.
        outline.none();

        // Customizable properties.
        display.inlineBlock();
        padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
    };

    /** Abstract base style of form element. */
    Style BorderedFormBase = FormBase.with(() -> {
        display.width(SingleLineFormWidth);
        border.solid().width(BorderWidth).color(BorderColor).radius(BorderRadius);

        focus(FocusedBorder);
    });

    /** Abstract base style of form element. */
    Style SingleLineFormBase = BorderedFormBase.with(() -> {
        display.width(SingleLineFormWidth);
    });

    Style SpriteBackground = () -> {
        background.image(BackgroundImage.none().cover().borderBox().noRepeat());
        display.block();
    };
}
