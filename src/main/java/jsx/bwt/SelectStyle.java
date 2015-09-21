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

import jsx.style.value.Color;
import jsx.ui.StructureDescriptor.Style;

/**
 * @version 2014/11/11 21:54:51
 */
class SelectStyle extends FormUIStyle {

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

    static Style SelectArrow = () -> {
        position.absolute().top(0, px).right(0, px);
    };
}
