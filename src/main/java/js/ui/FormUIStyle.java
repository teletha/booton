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

    /** The general form padding. */
    Value FormHeight = new Value(2, em);

    /** The general form padding. */
    Value FormPadding = new Value(0.4, em);

    Value BorderWidth = new Value(1, px);

    Value BorderRadius = new Value(4, px);

    Color BorderColor = new Color(0, 0, 80);

    Color BorderInsetColor = new Color(0, 0, 0, 0.1);

    Color FocusColor = new Color(206, 79, 62, 0.8);

    /**
     * @version 2013/03/31 22:49:02
     */
    private class BaseForm extends CSS {

        {
            display.inlineBlock();
            padding.size(FormPadding);
            font.size(14, px).color(85, 85, 85);
            transition.property.all().duration(0.2, s).timing.linear();
            outline.none();
        }
    }

    class InputForm extends BaseForm {

        {
            box.width(200, px).shadowInset(0, px, 1, px, 1, px, BorderInsetColor);
            border.width(BorderWidth).solid().color(BorderColor);

            while (focus()) {
                border.color(FocusColor);

                box.shadowInset(0, px, 1, px, 1, px, BorderInsetColor)
                        .shadow(0, px, 0, px, 8, px, FocusColor.opacify(-0.2));
            }
        }
    }
}
