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

import jsx.style.Style;
import jsx.style.value.Color;

/**
 * @version 2013/04/06 0:04:01
 */
class SelectStyle2 extends FormUIStyle2 {

    // @Priority(10)
    static Style SelectForm = () -> {
        baseInputForm();
        padding.right(IconSize.add(FormHorizontalPadding));
    };

    static Style SelectItemList = () -> {
        box.width(100, percent).maxHeight(SingleLineFormHeight.multiply(6));

        background.color(Color.White);
        border.solid().width(BorderWidth).color(BorderColor);
    };

    static Style SelectItem = () -> {
        display.block();
        padding.vertical(FormVerticalPadding).horizontal(FormHorizontalPadding);
        overflow.hidden();
        cursor.pointer();

        hover(() -> {
            background.color(SelectColor.grayscale());
        });
    };

    static Style SelectedItem = () -> {
        background.color(SelectColor);
    };

    // @Priority(10)
    static Style SelectArrow = () -> {
        position.absolute().top(0, px).right(0, px);
    };
}
