/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static booton.css.Unit.*;
import static booton.css.value.Color.*;
import booton.css.CSS;
import booton.css.Priority;
import booton.css.Snippet;
import booton.css.value.Color;
import booton.css.value.Numeric;

/**
 * @version 2013/03/24 10:50:33
 */
class ImageGridStyle {

    Color backColor = new Color(0, 10, 10);

    Numeric ImageSize = new Numeric(70, px);

    class Root extends CSS {

        {
            display.block();
            margin.auto();
            line.height(0);
            box.width(ImageSize.multiply(10).add(2));
        }
    }

    class ImageSet extends CSS {

        {
            display.inlineBlock();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        }
    }

    class Container extends CSS {

        {
            position.relative();
            display.block();
            box.floating.left();
        }
    }

    class IconImage extends CSS {

        {
            display.block();
            box.size(ImageSize);
            border.bottom.solid().width(2, px).color(backColor);
            border.right.solid().width(2, px).color(backColor);
            cursor.pointer();
            transition.property.all().duration(0.2, s).timing.easeInOut();

            after(() -> {
                content.text("");
                display.block();
                position.absolute();
                box.width(100, percent).height(100, percent);
                background.color(hsla(0, 100, 100, 0.2));
            });

            while (hover()) {
                after(() -> {
                    visibility.hidden();
                });
            }
        }
    }

    class Title extends CSS {

        Numeric boxWidth = ImageSize.add(40);

        Color color = new Color(0, 98, 97, 1);

        {
            font.weight.bold().size(18, px);
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

            Snippet.createBottomBubble(7);

            while (siblingHover()) {
                box.opacity(1);
                position.bottom(ImageSize);
                visibility.visible();
            }
        }
    }

    @Priority(100)
    class Unselected extends CSS {

        {
            box.opacity(0);
            margin.right(-70, px);
        }
    }

    class InputStyle extends CSS {

        {
            display.block();
            box.height(20, px).width(200, px).shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075));
            padding.vertical(4, px).horizontal(6, px);
            margin.bottom(10, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();
            border.radius(4, px).width(1, px).solid().color(rgb(204, 204, 204));
            background.color(White);
            transition.property.all().duration(0.2, s).timing.linear();

            while (focus()) {
                border.color(rgba(82, 168, 236, 0.8));
                outline.none();
                box.shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075))
                        .shadow(0, px, 0, px, 8, px, rgba(82, 168, 236, 0.6));
            }
        }
    }
}