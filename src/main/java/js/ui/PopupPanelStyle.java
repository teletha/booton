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

import booton.css.CSS;

/**
 * @version 2013/04/04 16:18:54
 */
class PopupPanelStyle {

    class PopupView extends CSS {

        {
            display.inlineBlock();
            box.width(100, percent);
            overflow.hidden();
        }
    }

    class SliderView extends CSS {

        {
            transform.translateY(-100, percent);
            transition.property.all().timing.easeInOut().duration(200, ms);
        }
    }

    class SliderShown extends CSS {

        {
            transform.translateY(0, px);
        }
    }
}
