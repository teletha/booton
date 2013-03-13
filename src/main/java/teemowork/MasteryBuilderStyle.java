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

/**
 * @version 2013/03/13 15:05:12
 */
class MasteryBuilderStyle {

    int IconSize = 48;

    int Gap = IconSize / 3;

    int Corner = 4;

    class Offence extends CSS {

        {

        }
    }

    class Hierarchy extends CSS {

        {
            display.block();
            margin.vertical(Gap, px);
        }
    }

    class EmptyIcon extends CSS {

        {
            visibility.hidden();
        }
    }

    class MasteryIcon extends CSS {

        {
            display.inlineBlock();
            box.size(IconSize, px);
            border.color(hsl(110, 77, 40)).radius(Corner, px).width(1, px);
            margin.horizontal(Gap / 3, px);
            background.contain();
            position.relative();
        }
    }

    class Level extends CSS {

        {
            display.block();
            box.width(100, percent);
            position.bottom(0, px).right(0, px).absolute();
            padding.right(5, px);
            border.radius(0, px, 0, px, Corner, px, Corner, px);
            background.color(hsla(0, 0, 0, 0.4));
            font.color(hsl(0, 93, 99)).size(11, px);
            text.outline(1).align.right();

        }
    }

    class Value extends CSS {

        {

        }
    }

    class Separator extends CSS {

        {
            margin.horizontal(2, px);
        }
    }
}
