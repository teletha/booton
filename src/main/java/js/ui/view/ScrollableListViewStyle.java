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
 * @version 2013/04/02 15:57:15
 */
class ScrollableListViewStyle {

    class ViewabletemView extends CSS {

        {
            display.block();
            position.relative();
            overflowY.auto();
            overflowX.hidden();
        }
    }

    class RenderableItemView extends CSS {

        {
            display.block();
            overflow.hidden();
        }
    }

    class Spacer extends CSS {

        {
            display.block();
        }
    }

    class ItemColumnView extends CSS {

        {
            display.block();
        }
    }
}
