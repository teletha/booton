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

import js.util.Color;
import booton.css.CSS;
import booton.css.Snippet;
import booton.css.Snippet.Icon;

/**
 * @version 2013/04/06 0:04:01
 */
class SelectStyle extends FormUIStyle {

    class SelectForm extends BaseForm {

        {
            writeBorder();
        }
    }

    class SelectArrow extends BaseForm {

        {
            writeBorder();
            borderLeft.none();

            Snippet.write(Icon.BottomArrow);
            cursor.pointer();

        }
    }

    class SelectItemList extends CSS {

        {
            // position.absolute().top(100, percent).left(0, px);
            // transform.translateY(BorderWidth.opposite());
            // box.maxHeight(SingleLineFormHeight.multiply(6)).width(100, percent).zIndex(1);
            // font.size(FontSize);
            // overflowY.scroll();
            // // display.none();
            box.width(100, percent).maxHeight(SingleLineFormHeight.multiply(6));

            background.color(Color.White);
            border.solid().width(BorderWidth).color(BorderColor);
        }
    }

    class SelectItemListShown extends CSS {

        {

        }
    }

    class SelectItem extends CSS {

        {
            display.block();
            padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
            overflow.hidden();
            cursor.pointer();

            while (hover()) {
                background.color(SelectColor);
            }
        }
    }
}
