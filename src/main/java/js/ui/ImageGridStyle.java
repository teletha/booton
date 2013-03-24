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

import js.util.Color;
import booton.css.CSS;
import booton.css.Value;
import booton.util.Font;

/**
 * @version 2013/03/24 10:50:33
 */
class ImageGridStyle {

    Font Yanone = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

    int ImageSize = 70;

    class Image extends CSS {

        {
            display.inlineBlock();
            box.size(ImageSize, px);
            outline.none();
            background.color.transparent().top().left().contain();
            position.relative();
            transition.property.all().duration(0.2, s).timing.easeInOut();

            cover();
        }

        /**
         * Apply screen cover.
         */
        private void cover() {
            Value width = box.width();
            Value height = box.height();

            while (after()) {
                content.text("");
                display.block();
                position.absolute();
                box.width(width).height(height).opacity(0.15);
                background.color.white();

                while (parentHover()) {
                    box.opacity(0);
                }
            }
        }
    }

    class Title extends CSS {

        {
            Value boxWidth = new Value(ImageSize + 30, px);
            Value borderWidth = new Value(4, px);
            Color color = new Color(0, 98, 97, 1);

            font.weight.bold().size(18, px).family(Yanone);
            line.height(20, px);
            padding.size(5, px);
            text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
            background.image(linear(color.opacify(-0.4), color)).color(color.opacify(-1));
            pointerEvents.none();
            box.opacity(0).shadow(1, px, 1, px, 2, px, rgba(0, 0, 0, 0.1)).width(boxWidth);
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);
            position.absolute().left(50, percent).bottom(boxWidth);
            margin.left(boxWidth.divide(-2));
            border.width(borderWidth).solid().color(5, 5, 5).radius(5, px);
            pointerEvents.none();

            createBubble(5);

            while (parentHover()) {
                box.opacity(1);
                position.bottom(ImageSize, px);
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