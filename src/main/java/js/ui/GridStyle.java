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
 * @version 2013/04/02 15:57:15
 */
class GridStyle {

    class RootArea extends CSS {

        {
            display.block();
            box.width(100, px);
            border.solid().width(1, px).color.black();
        }
    }

    class ViewabletemView extends CSS {

        {
            display.block();
            box.width(100, percent).height(100, percent);
            position.relative();
            overflowY.auto();
        }
    }

    class ScrollableItemView extends CSS {

        {
            display.block();
            box.width(100, percent).height(100, percent);
            position.relative();
            overflowY.auto();
        }
    }

    class ScrollableItemViewSpacer extends CSS {

        {
            display.block();
        }
    }

    class ItemColumnView extends CSS {

        {
            display.block();
            border.color.black().solid().width(1, px);
        }
    }
}
