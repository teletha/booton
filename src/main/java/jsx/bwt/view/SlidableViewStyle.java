/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import jsx.style.StyleDescriptor;
import jsx.ui.StructureDescriptor.Style;

/**
 * @version 2014/11/08 10:49:26
 */
class SlidableViewStyle extends StyleDescriptor {

    static Style ViewableArea = () -> {
        // In firefox, "overflow : hidden" will render dirty, so don't use it.
        overflow.y.hidden();

        // Hide viewable area to avoid blocking other background element.
        visibility.hidden();

        box.width(100, percent).zIndex(1);
        position.absolute().top(100, percent).left(0, px);
    };

    static Style Shown = () -> {
    };

    static Style Slider = () -> {
        display.block();
        transform.translateY(-100, percent);

        transit().duration(200, ms).easeInOut().whenIn(Shown, () -> {
            transform.translateY(-1, px);
            visibility.visible();
        });
    };
}
