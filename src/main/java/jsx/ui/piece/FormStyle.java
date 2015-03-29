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
import jsx.style.StyleRuleDescriptor;
import jsx.style.value.Color;

/**
 * @version 2015/03/22 16:46:20
 */
public class FormStyle extends StyleRuleDescriptor {

    static Style CheckBoxRoot = () -> {
        position.relative();
    };

    static Style CheckBoxSVG = () -> {
        box.size(13, px);
    };

    static Style CheckBox = () -> {
        stroke.linecap.round().linejoin.round().color(Color.Black).miterLimit(1);
        fill.none();
    };

    static Style CheckBoxLine = () -> {
        fill.none();
        stroke.color(20, 20, 20).width(2, px).linecap.round().linejoin.round()
                .dashArray(113.137, 113.137)
                .dashOffset(0);

        transit().duration(0.2, s).easeInOut().whenHover(() -> {
            stroke.dashOffset(113);
        });
    };
}
