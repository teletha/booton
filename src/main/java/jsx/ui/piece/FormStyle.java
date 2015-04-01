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
        box.size(16, px);
    };

    static Style CheckBox = () -> {
        stroke.linecap.round().linejoin.round().color(Color.Black).miterLimit(1).width(3, px);
        fill.none();
    };

    static Style CheckBoxLine = () -> {
        fill.none();
        stroke.color(80, 80, 80).width(6, px).linecap.round().linejoin.round().dashArray(120, 121).dashOffset(121);
        transit().duration(0.2, s).easeInOut().whenever();
    };

    static StatefulStyle<Binary> Mark = state -> {
        fill.none();
        stroke.color(80, 80, 80).width(6, px).linecap.round().linejoin.round().dashArray(120, 130);

        switch (state) {
        case True:
            stroke.dashOffset(0);
            break;

        case False:
            stroke.dashOffset(121);
            break;
        }
    };

    public static interface StatefulStyle<E extends Enum> {

        void declare(E state);
    }

    public static enum Binary {

        True, False;
    }

    public static enum Ternary {

        True, False, Undefined;
    }
}
