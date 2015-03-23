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

/**
 * @version 2015/03/22 16:46:20
 */
public class FormStyle extends StyleRuleDescriptor {

    static Style CheckBoxRoot = () -> {
        position.relative();
    };

    static Style CheckBoxSVG = () -> {
        position.absolute().top(50, percent).left(5, px);
        box.size(40, px);
    };

    static Style CheckBoxLine = () -> {
        fill.none();
        stroke.color(20, 20, 20).width(13, px).linecap.round().linejoin.round()
                .dashArray(113.137, 113.137)
                .dashOffset(0);

        transit().duration(0.2, s).easeInOut().whenHover(() -> {
            stroke.dashOffset(113);
        });
    };
}
