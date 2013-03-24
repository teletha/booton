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

import static booton.css.Unit.*;
import js.util.Color;
import booton.css.CSS;
import booton.css.Value;
import booton.util.Font;

/**
 * @version 2013/03/24 10:50:33
 */
class ImageGridStyle {

    Font Yanone = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

    Value ImageSize = new Value(70, px);

    class Container extends CSS {

        {
            position.relative();
        }
    }

    class IconImage extends CSS {

        {
            display.inlineBlock();
            box.size(ImageSize);
            cursor.pointer();
            background.top().left().contain();
            position.relative();
            transition.property.all().duration(0.2, s).timing.easeInOut();

            while (after()) {
                content.text("");
                display.block();
                position.absolute();
                box.width(100, percent).height(100, percent);
                background.color(hsla(0, 100, 100, 0.2));

                while (parentHover()) {
                    visibility.hidden();
                }
            }
        }
    }

    class Title extends CSS {

        Value boxWidth = ImageSize.add(40);

        Color color = new Color(0, 98, 97, 1);

        {
            font.weight.bold().size(18, px).family(Yanone);
            text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
            line.height(20, px);
            padding.size(5, px);
            background.image(linear(color.opacify(-0.4), color));
            position.absolute().left(50, percent).bottom(ImageSize.add(20));
            margin.left(boxWidth.divide(-2));
            box.minWidth(boxWidth).zIndex(1).opacity(0);
            border.width(4, px).solid().color(color.lighten(-100)).radius(5, px);
            visibility.hidden();
            pointerEvents.none();
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(100, ms);

            createBottomBubble(6);

            while (siblingHover()) {
                box.opacity(1);
                position.bottom(ImageSize);
                visibility.visible();
            }
        }
    }

    class Unselected extends CSS {

        {
            box.opacity(0);
            margin.right(-70, px);
        }
    }

    class Input extends CSS {

        {
            display.block();
            box.height(20, px).width(200, px).shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075));
            padding.vertical(4, px).horizontal(6, px);
            margin.bottom(10, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();
            border.radius(4, px).width(1, px).solid().color(204, 204, 204);
            background.color(255, 255, 255);
            transition.property.all().duration(0.2, s).timing.linear();

            while (focus()) {
                border.color(82, 168, 236, 0.8f);
                outline.none();
                box.shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075))
                        .shadow(0, px, 0, px, 8, px, rgba(82, 168, 236, 0.6));
            }
        }
    }
}