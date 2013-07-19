/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static booton.css.Unit.*;
import js.util.Color;
import booton.css.CSS;
import booton.css.value.Value;
import booton.util.Font;

/**
 * @version 2013/03/28 1:34:10
 */
class FormUIStyle {

    // ===========================================
    // Form Related Style
    // ===========================================
    Value FormFontSize = new Value(14, px);

    // ===========================================
    // Border Related Style
    // ===========================================
    Value BorderWidth = new Value(1, px);

    Value BorderRadius = new Value(3, px);

    Color BorderColor = new Color(0, 0, 80);

    Color BorderInsetShadow = new Color(0, 0, 0, 0.1);

    Color BorderFocusColor = new Color(206, 79, 62, 0.8);

    /** The general single line form width. */
    Value SingleLineFormWidth = new Value(185, px);

    /** The general single line form height. */
    Value SingleLineFormHeight = new Value(28, px);

    /** The general form padding. */
    Value FormVerticalPadding = new Value(4, px);

    /** The general form padding. */
    Value FormHorizontalPadding = new Value(6, px);

    Color SelectColor = new Color(206, 79, 62, 0.8);

    // ===========================================
    // Icon Related Style
    // ===========================================
    Font IconFont = new Font("icon.css");

    /** The general icon size. */
    Value IconSize = SingleLineFormHeight;

    /**
     * <p>
     * Root style of form component.
     * </p>
     * 
     * @version 2013/04/22 9:38:52
     */
    class FormRoot extends CSS {

        {
            display.inlineBlock();
            position.relative();
            font.size(FormFontSize);

            transition.property.all().duration(0.2, s).timing.linear();

            while (with(Focus.class)) {
                box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow)
                        .shadow(0, px, 0, px, 8, px, BorderFocusColor.opacify(-0.2));
            }

            while (insideOf(FormRoot.class)) {
                while (with(Focus.class)) {
                    box.shadow(0, px, 0, px, 0, px, Color.Transparent);
                }
            }
        }
    }

    /**
     * @version 2013/04/22 9:40:10
     */
    class Focus extends CSS {

        {
            // marker
        }
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    class AbstractForm extends CSS {

        {
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
         * Helper method to write border.
         * </p>
         * 
         * @param color A border bolor.
         */
        protected final void border(Color color) {
            border.color(color);
            box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow).shadow(0, px, 0, px, 8, px, color.opacify(-0.2));
        }
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    class AbstractBorderForm extends AbstractForm {

        {
            border.solid().width(BorderWidth).color(BorderColor).radius(BorderRadius);

            while (insideOf(Focus.class)) {
                border(BorderFocusColor);
            }
        }
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    class AbstractFirstBorderForm extends AbstractBorderForm {

        {
            borderRight.none();
            borderRight.radius(0, px);
        }
    }

    /**
     * <p>
     * Abstract base style of form element.
     * </p>
     * 
     * @version 2013/04/22 9:42:41
     */
    class AbstractLastBorderForm extends AbstractBorderForm {

        {
            borderLeft.none();
            borderLeft.radius(0, px);
        }
    }

    /**
     * @version 2013/04/17 16:29:48
     */
    class ButtonForm extends AbstractBorderForm {

        {
            Color front = new Color(0, 0, 33);
            Color back = new Color(0, 0, 87);

            // writeBorder();
            cursor.pointer();
            padding.horizontal(15, px);
            font.weight.bolder();
            background.color(back).image(linear(Color.White, Color.White.opacify(-1)));
            text.decoration.none().shadow(0, px, 1, px, Color.White.opacify(-0.1)).unselectable();

            // transition.property("background-color").timing.easeOut().duration(0.2, s);

            while (hover()) {
                background.color(back.lighten(6));
            }

            while (active()) {
                border.color(BorderColor.lighten(-20));
                background.color(back.lighten(4)).imageNone();
                box.shadowInset(0, px, 2, px, 4, px, Color.Black.opacify(-0.85))
                        .shadow(0, px, 1, px, 2, px, Color.Black.opacify(-0.95));
            }
        }
    }

    class InputForm extends AbstractBorderForm {

        {
            box.width(SingleLineFormWidth);
        }
    }

    class InvalidInputForm extends AbstractBorderForm {

        {

            while (focus()) {
                border(BorderFocusColor.adjustHue(-180));
                box.shadow(0, px, 0, px, 8, px, BorderFocusColor.adjustHue(-180).opacify(-0.2));
            }
        }
    }

    class Disable extends CSS {

        {
            while (after()) {
                display.block();
                box.size(100, percent);
                background.color(Color.Transparent);
                content.text(" ");
                position.absolute().top(0, px).left(0, px);
            }
        }
    }

    class Icons extends CSS {

        {
            padding.vertical(0, px).horizontal(8, px);
            line.height(IconSize);
            box.size(IconSize);

            while (after()) {
                font.color(BorderColor.lighten(-20)).family(IconFont);
                text.verticalAlign.middle();
                content.attr("icon");
            }

            while (hover()) {
                while (after()) {
                    font.color(BorderColor.lighten(-40));
                }
            }
        }
    }
}
