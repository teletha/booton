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

import static jsx.bwt.FormUIStyle.*;
import booton.css.CSS;
import booton.css.Priority;
import booton.css.value.Color;

/**
 * @version 2013/04/06 0:04:01
 */
class SelectStyle extends FormUIStyle {

    @Priority(10)
    class SelectForm extends InputForm {

        {
            padding.right(IconSize.add(FormHorizontalPadding));
        }
    }

    class SelectItemList extends CSS {

        {
            box.width(100, percent).maxHeight(SingleLineFormHeight.multiply(6));

            background.color(Color.White);
            border.solid().width(BorderWidth).color(BorderColor);
        }
    }

    class SelectItem extends CSS {

        {
            display.block();
            padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
            overflow.hidden();
            cursor.pointer();

            hover(() -> {
                background.color(SelectColor.grayscale());
            });
        }
    }

    class SelectedItem extends CSS {

        {
            background.color(SelectColor);
        }
    }

    @Priority(10)
    class SelectArrow extends CSS {

        {
            position.absolute().top(0, px).right(0, px);
        }
    }
}
