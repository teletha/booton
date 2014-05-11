/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import booton.css.CSS;

/**
 * @version 2013/04/05 11:40:35
 */
class ScrollableListViewStyle {

    class ViewabletemView extends CSS {

        {
            display.block();
            position.relative();
            overflow.y.auto();
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
