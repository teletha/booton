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

import js.util.Color;
import booton.css.CSS;

/**
 * @version 2013/03/13 15:05:12
 */
class MasteryBuilderStyle {

    int TreeWidth = 240;

    int TreeHeight = 450;

    int TreePadding = 10;

    int MasterWidth = (TreeWidth - TreePadding * 2) / 4;

    int Gap = 5;

    int IconSize = MasterWidth - Gap * 2;

    int Corner = 5;

    Color AvailableColor = new Color(120, 90, 52);

    Color CompleteColor = AvailableColor.adjustHue(-70);

    class Offense extends CSS {

        {
            display.inlineBlock();
            box.width(TreeWidth, px).height(TreeHeight, px);
            padding.right(TreePadding - 3, px).left(TreePadding + 3, px).vertical(TreePadding, px);
            background.contain();
            background.image("src/main/resources/teemowork/mastery/s3/Offense.jpg");
            border.radius(Corner * 2, px, 0, px, 0, px, Corner * 2, px);
        }
    }

    class Defense extends CSS {

        {
            display.inlineBlock();
            box.width(TreeWidth, px).height(TreeHeight, px);
            padding.right(TreePadding, px).left(TreePadding, px).vertical(TreePadding, px);
            background.contain();
            background.image("src/main/resources/teemowork/mastery/s3/Defense.jpg");
        }
    }

    class Utility extends CSS {

        {
            display.inlineBlock();
            box.width(TreeWidth, px).height(TreeHeight, px);
            padding.right(TreePadding + 3, px).left(TreePadding - 3, px).vertical(TreePadding, px);
            background.contain();
            background.image("src/main/resources/teemowork/mastery/s3/Utility.jpg");
            border.radius(0, px, Corner * 2, px, Corner * 2, px, 0, px);
        }
    }

    class Hierarchy extends CSS {

        {
            display.block();
            margin.vertical(Gap * 3, px);
            text.unselectable();
        }
    }

    class EmptyIcon extends CSS {

        {
            visibility.hidden();
        }
    }

    class MasteryContainer extends CSS {

        {
            position.relative();
            display.inlineBlock();
        }
    }

    class MasteryIcon extends CSS {

        {
            display.inlineBlock();
            box.size(IconSize, px);
            border.color(AvailableColor).width(1, px).solid().radius(Corner, px);
            margin.horizontal(Gap, px);
            background.contain();
            position.relative();

            while (with(Available.class)) {
                cursor.pointer();
            }

            while (with(Completed.class)) {
                border.color(CompleteColor);
            }
        }
    }

    class Filter extends CSS {

        {
            display.block();
            position.absolute();
            box.size(100, percent);
            border.radius(Corner, px, Corner, px, Corner, px, Corner, px);
            background.color(hsla(0, 0, 0, 0.4));

            while (insideOf(Available.class)) {
                display.none();
            }
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
            font.color(AvailableColor).size(11, px);
            text.outline(1).align.right();

            while (insideOf(Unavailable.class)) {
                display.none();
            }

            while (insideOf(Completed.class)) {
                font.color(CompleteColor);
            }
        }
    }

    class Sum extends CSS {

        {
            font.color(hsl(0, 97, 97)).size(26, px);
            text.unselectable().shadow();
            padding.left(7, px);
        }
    }

    class Value extends CSS {

        {
            text.unselectable();
        }
    }

    class Separator extends CSS {

        {
            margin.horizontal(2, px);
            text.unselectable();
        }
    }

    class Available extends CSS {

        {

        }
    }

    class Unavailable extends CSS {

        {
            filter.grayscale(90);
            transition.property.all().timing.easeInOut().duration(1, s);
        }
    }

    class Completed extends CSS {

        {

        }
    }

    class Popup extends CSS {

        int Width = 220;

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 0.7);

        int BorderWidth = 2;

        {
            display.block();
            position.absolute().bottom(IconSize + 35, px).left(Gap - Width / 2 + IconSize / 2, px);
            box.width(Width, px).opacity(0).zIndex(100).shadow(0, px, 0, px, 7, px, hsla(0, 0, 0, 0.9));
            background.image(linear(color.lighten(10), color)).color(color);
            border.radius(Corner, px).solid().width(BorderWidth, px).color(borderColor);
            padding.size(10, px);
            visibility.hidden();
            font.color(hsl(0, 99, 97)).size.smaller();
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);
            pointerEvents.none();

            createBubble(12);
        }

        private void createBubble(int bubbleWidth) {
            booton.css.Value width = box.width();
            Color backgroundColor = background.color();

            booton.css.Value borderWidth = border.width();
            Color borderColor = border.color();

            if (borderWidth == null) {
                borderWidth = new booton.css.Value(0, px);
            }

            if (!position.isAbsolute() && !position.isRelative()) {
                position.relative();
            }

            // write bubble
            while (before()) {
                display.block();
                box.size(0, px);
                content.text("");
                position.absolute()
                        .bottom(borderWidth.multiply(-1).subtract(bubbleWidth * 2))
                        .left(width.divide(2).subtract(borderWidth).subtract(bubbleWidth));
                border.solid().color.transparent().width(bubbleWidth, px);
                borderTop.color(borderColor).width(bubbleWidth, px);
            }

            if (borderWidth.size != 0) {
                while (after()) {
                    display.block();
                    box.size(0, px);
                    content.text("");
                    position.absolute()
                            .bottom(borderWidth.subtract(bubbleWidth * 2))
                            .left(width.divide(2).subtract(borderWidth).subtract(bubbleWidth));
                    border.width(bubbleWidth, px).solid().color.transparent();
                    border.solid().color.transparent().width(bubbleWidth, px);
                    borderTop.color(backgroundColor).width(bubbleWidth, px);
                }
            }
        }
    }

    class PopupShow extends CSS {

        {
            box.opacity(1);
            visibility.visible();
            position.bottom(IconSize + 15, px);
        }
    }

    class Name extends CSS {

        {
            display.block();
            margin.bottom(0.7, em);
            font.weight.bolder();
        }
    }

    class Description extends CSS {

        {
            while (inBackOf(Unavailable.class)) {
                font.color(hsl(0, 70, 70));
            }
        }
    }

    class Current extends CSS {

        {

        }
    }

    class ComputedValue extends CSS {

        {

        }
    }
}
