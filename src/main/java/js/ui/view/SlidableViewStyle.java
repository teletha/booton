/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.view;

import booton.css.CSS;

/**
 * @version 2013/04/04 16:18:54
 */
class SlidableViewStyle {

    class ViewableArea extends CSS {

        {
            overflowY.hidden();
            visibility.hidden();
            box.width(100, percent).zIndex(1);
            position.absolute().top(100, percent).left(0, px);
        }
    }

    class Slider extends CSS {

        {
            display.block();
            transform.translateY(-100, percent);
            transition.property.all().timing.easeInOut().duration(200, ms);

            while (insideOf(Shown.class)) {
                transform.translateY(-1, px);
            }
        }
    }

    class Shown extends CSS {

        {
            visibility.visible();
        }
    }
}
