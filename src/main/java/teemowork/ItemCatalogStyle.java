/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import booton.css.CSS;
import booton.util.Font;

/**
 * @version 2013/05/30 19:12:18
 */
class ItemCatalogStyle {

    private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

    /** The skill icon size. */
    private static final int IconSize = 45;

    /**
     * @version 2013/02/16 9:52:23
     */
    static class ItemPanel extends CSS {

        {
            display.table();
            margin.bottom(15, px);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class IconPanel extends CSS {

        {
            display.tableCell();
            padding.right(IconSize / 5, px);
            cursor.pointer();
        }
    }

    /**
     * @version 2013/02/16 9:52:23
     */
    static class DescriptionPanel extends CSS {

        {
            display.tableCell();
            text.verticalAlign.top();
            box.height(60, px);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Names extends CSS {

        {
            display.block();
            margin.bottom(0.4, em);
            font.family(Sans);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Name extends CSS {

        {
            margin.right(0.5, em);
            font.weight.bold();
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class TotalCost extends CSS {

        {
            margin.right(0.5, em);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Cost extends CSS {

        {

        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Value extends CSS {

        {
            display.block();
            margin.bottom(0.2, em);
            font.size.smaller().family(Sans);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Icon extends CSS {

        private int size = 44;

        {
            display.inlineBlock();
            box.size(size, px);
            background.contain().size(size + 2, px).horizontal(-1, px).vertical(-1, px);
            border.radius(5, px).color(50, 50, 50).width(1, px).solid();
            text.verticalAlign.middle();
        }
    }
}