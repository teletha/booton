/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import static booton.css.Unit.*;
import js.util.Color;
import booton.css.CSS;
import booton.css.Value;

/**
 * @version 2013/03/28 1:34:10
 */
class FormUIStyle {

    // ===========================================
    // Border Related Style
    // ===========================================
    Value BorderWidth = new Value(1, px);

    Value BorderRadius = new Value(3, px);

    Color BorderColor = new Color(0, 0, 80);

    Color BorderInsetShadow = new Color(0, 0, 0, 0.1);

    Color BorderFocusColor = new Color(206, 79, 62, 0.8);

    Value FontSize = new Value(14, px);

    /** The general single line form height. */
    Value SingleLineFormHeight = new Value(20, px);

    /** The general form padding. */
    Value FormVerticalPadding = new Value(4, px);

    /** The general form padding. */
    Value FormHorizontalPadding = new Value(6, px);

    Color SelectColor = new Color(206, 79, 62, 0.8);

    class FormComponent extends CSS {

        {
            display.inlineBlock();
            position.relative();

            writeBorder();
        }

        /**
         * <p>
         * Helper method to write border.
         * </p>
         */
        protected final void writeBorder() {
            transition.property.all().duration(0.2, s).timing.linear();
            border.width(BorderWidth).solid().color(BorderColor);
            box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow);

            while (firstChild()) {
                borderLeft.radius(BorderRadius);
            }

            while (lastChild()) {
                borderRight.radius(BorderRadius);
            }

            while (onlyChild()) {
                border.radius(BorderRadius);
            }

            while (hover()) {
                box.shadowInset(0, px, 0, px, 6, px, BorderInsetShadow);
            }

            while (with(Focus.class)) {
                border.color(BorderFocusColor);
                box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow)
                        .shadow(0, px, 0, px, 8, px, BorderFocusColor.opacify(-0.2));
            }
            
            while (insideOf(FormComponent.class)) {
                border.none();
            }
        }
    }

    class Focus extends CSS {

        {

        }
    }

    /**
     * @version 2013/03/31 22:49:02
     */
    protected class BaseForm extends CSS {

        {
            // Required property for single line form.
            box.height(SingleLineFormHeight.add(FormVerticalPadding.multiply(2)));

            // Required property for single line form.
            text.verticalAlign.middle();

            // Required property for single line form.
            outline.none();

            // Customizable properties.
            display.inlineBlock();
            font.size(FontSize);
            padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);

            transition.property.all().duration(0.2, s).timing.linear();
        }

        /**
         * <p>
         * Helper method to write border.
         * </p>
         */
        protected final void writeBorder() {
            border.none();
            // border.width(BorderWidth).solid().color(BorderColor);
            // box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow);
            //
            // while (firstChild()) {
            // borderLeft.radius(BorderRadius);
            // }
            //
            // while (lastChild()) {
            // borderRight.radius(BorderRadius);
            // }
            //
            // while (onlyChild()) {
            // border.radius(BorderRadius);
            // }
            //
            // while (hover()) {
            // box.shadowInset(0, px, 0, px, 6, px, BorderInsetShadow);
            // }
            //
            // while (focus()) {
            // border.color(BorderFocusColor);
            // box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow)
            // .shadow(0, px, 0, px, 8, px, BorderFocusColor.opacify(-0.2));
            // }
        }

        /**
         * <p>
         * Helper method to write border.
         * </p>
         * 
         * @param color A border bolor.
         */
        protected final void writeBorder(Color color) {
            border.color(color);
            box.shadowInset(-1, px, 1, px, 1, px, BorderInsetShadow).shadow(0, px, 0, px, 8, px, color.opacify(-0.2));
        }
    }

    /**
     * @version 2013/04/17 16:29:48
     */
    class ButtonForm extends BaseForm {

        {
            createButton();
        }

        private void createButton() {
            Color front = new Color(0, 0, 33);
            Color back = new Color(0, 0, 87);

            // writeBorder();
            cursor.pointer();
            padding.horizontal(15, px);
            font.weight.bolder();
            background.color(back).image(linear(Color.White, Color.White.opacify(-1)));
            text.decoration.none().shadow(0, px, 1, px, Color.White.opacify(-0.1)).unselectable();

            transition.property("background-color").timing.easeOut().duration(0.2, s);

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

    class InputForm extends BaseForm {

        {
            writeBorder();
        }
    }

    class InvalidInputForm extends BaseForm {

        {

            while (focus()) {
                writeBorder(BorderFocusColor.adjustHue(-180));
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
}
