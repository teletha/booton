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
import booton.css.Snippet;
import booton.css.Unit;
import booton.css.Value;

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

    int IconBorderSize = 1;

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

    class RankPane extends CSS {

        {
            display.block();
            margin.vertical(Gap * 2.8, px);
            text.unselectable();
        }
    }

    class MasteryPane extends CSS {

        {
            display.inlineBlock();
            box.size(IconSize, px);
            margin.horizontal(Gap, px);
            position.relative();
            cursor.pointer();

            while (with(Unavailable.class)) {
                cursor.defaults();
            }
        }
    }

    class EmptyPane extends CSS {

        {
            visibility.hidden();
        }
    }

    class IconImage extends CSS {

        {
            box.size(IconSize, px);
            border.color(AvailableColor).width(IconBorderSize, px).solid().radius(Corner, px);

            while (insideOf(Unavailable.class)) {
                border.color(AvailableColor.grayscale());
            }

            while (insideOf(Completed.class)) {
                border.color(CompleteColor);
            }
        }
    }

    class LevelPane extends CSS {

        {
            display.block();
            box.width(IconSize - IconBorderSize * 2, px);
            position.bottom(IconBorderSize, px).left(IconBorderSize, px).absolute();
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

    class SumPoint extends CSS {

        {
            font.color(hsl(0, 97, 97)).size(26, px);
            text.unselectable().shadow();
            padding.left(7, px);
        }
    }

    class LevelValue extends CSS {

        {
            text.unselectable();
        }
    }

    class LevelSeparator extends CSS {

        {
            margin.horizontal(2, px);
            text.unselectable();
        }
    }

    class Unavailable extends CSS {

        {

        }
    }

    class Completed extends CSS {

        {

        }
    }

    class PopupPane extends CSS {

        int Width = 220;

        int BorderWidth = 2;

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 1);

        {
            display.block();
            position.absolute().bottom(IconSize + 35, px).left(IconSize / 2 - Width / 2, px);
            box.width(Width, px).opacity(0).zIndex(100).shadow(0, px, 0, px, 7, px, color);
            background.image(linear(color.opacify(-0.25), color));
            border.radius(Corner, px).solid().width(BorderWidth, px).color(borderColor);
            padding.size(10, px);
            visibility.hidden();
            font.color(hsl(0, 99, 97)).size.smaller();
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);
            pointerEvents.none();

            Snippet.createBottomBubble(6);

            while (insideOf(Unavailable.class)) {
                font.color(AvailableColor.grayscale());
            }

            while (siblingHover()) {
                box.opacity(1);
                visibility.visible();
                position.bottom(IconSize + 12, px);
            }
        }
    }

    class MasteryName extends CSS {

        {
            display.block();
            margin.bottom(0.7, em);
            font.size(16, px).weight.bolder().color(hsl(60, 100, 85)).family(TeemoworkTheme.Title);
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

    class Information extends CSS {

        {
            display.block();
            margin.bottom(10, px);
        }
    }

    class ResetButton extends CSS {

        {
            createButton();
        }

        private void createButton() {
            Color front = new Color(0, 0, 33);
            Color back = new Color(0, 0, 87);

            display.inlineBlock();
            margin.size(0, px);
            padding.vertical(4, px).horizontal(15, px);
            cursor.pointer();
            border.solid().width(1, px).color(hsl(0, 0, 73)).radius(3, px);
            overflow.visible();
            font.weight.bolder().color(front);
            text.decoration.none().shadow(0, px, 1, px, Color.White.opacify(-0.1)).unselectable();
            background.color(back).image(linear(Color.White, Color.White.opacify(-1)));
            box.shadow(0, px, 1, px, hsla(0, 0, 0, 0.3))
                    .shadow(0, px, 2, px, 2, px, -1, px, hsla(0, 0, 0, 0.5))
                    .shadowInset(0, px, 1, px, 0, px, Color.White.opacify(-0.7));

            transition.property("background-color").timing.easeOut().duration(0.2, s);

            while (hover()) {
                background.color(back.lighten(6));
            }

            while (active()) {
                background.color(back.lighten(4)).imageNone();
                position.relative().top(1, px);
                box.shadowInset(0, px, 1, px, 1, px, Color.Black.opacify(-0.7));
            }
        }
    }

    class Available extends CSS {

        {

        }
    }

    Value BorderWidth = new Value(1, Unit.px);

    Value BorderRadius = new Value(4, Unit.px);

    Color BorderColor = new Color(0, 0, 80);

    class Input extends CSS {

        {
            display.inlineBlock();
            box.height(20, px).width(200, px).shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075));
            padding.vertical(4, px).horizontal(6, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();

            border.width(1, px).solid().color(204, 204, 204);
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
