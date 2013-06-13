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
            display.flex();
            margin.bottom(25, px);
            box.maxWidth(600, px);
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Icons extends CSS {

        {
            display.flex();
            flexDirection.column();
        }
    }

    /**
     * @version 2013/02/16 10:00:01
     */
    static class Icon extends CSS {

        {
            display.block();
            margin.bottom(IconSize / 5, px);
            cursor.pointer();
            box.size(44, px);
            border.radius(5, px).color(50, 50, 50).width(1, px).solid();
        }
    }

    /**
     * @version 2013/02/16 9:52:23
     */
    static class DescriptionPanel extends CSS {

        {
            display.flex();
            text.verticalAlign.top();
            flexDirection.column();
            margin.left(IconSize / 5, px);
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
     * @version 2013/06/04 23:24:52
     */
    static class AbilityArea extends CSS {

        {
            display.block();
            font.size.smaller();
        }
    }

    /**
     * @version 2013/06/04 23:24:52
     */
    static class Unique extends CSS {

        {
            font.color(205, 146, 0).weight.bolder();
            padding.right(0.5, em);
        }
    }

    /**
     * @version 2013/06/13 13:57:38
     */
    static class Materials extends CSS {

        {
            display.blockLine();
            box.width(IconSize, px);
        }
    }

    /**
     * @version 2013/06/13 13:57:38
     */
    static class Material extends CSS {

        {
            display.block();
            cursor.pointer();
            box.size(22, px);
            border.radius(3, px).color(50, 50, 50).width(1, px).solid();
        }
    }
}