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

import static booton.css.value.Color.*;
import booton.css.CSS;
import booton.css.Unit;
import booton.css.value.Value;

/**
 * @version 2013/02/26 23:49:51
 */
class ChampionDetailStyle {

    /** The skill icon size. */
    int SkillIconSize = 45;

    /** The level box height. */
    int LevelBoxHeight = 5;

    class Flex extends CSS {

        {
            border.width(1, px).color(Black).doubles();
        }
    }

    /**
     * @version 2013/06/06 23:31:54
     */
    class UpperInfo extends CSS {

        {
            require(Flex.class);

            display.flex();
            margin.bottom(1, em);
            alignItems.end();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class StatusLabel extends CSS {

        {
            font.size.smaller();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class SkillStatusValues extends CSS {

        {
            display.inlineBlock();
            margin.left(0.7, em);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class SkillStatusValue extends CSS {

        {
            display.inlineBlock();
            text.align.center();
            box.opacity(0.7);
            margin.horizontal(3, px);
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class SkillTable extends CSS {

        {
            display.tableCell();
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class SkillRow extends CSS {

        {
            display.block();
            margin.bottom(1, em);
        }
    }

    /**
     * @version 2013/02/06 18:51:27
     */
    class SkillIcon extends CSS {

        {
            display.block();
            box.size(SkillIconSize, px);
            background.contain().size(SkillIconSize, px).borderBox();
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class LevelBox extends CSS {

        {
            display.table();
            box.width(SkillIconSize, px).height(LevelBoxHeight, px);
            border.width(1, px).solid().color(Black);
            margin.top(2, px).bottom(5, px);
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class LevelMark extends CSS {

        {
            display.tableCell();
            box.width(SkillIconSize / 5, px).height(LevelBoxHeight, px);
            border.left.solid().color(Black).width(1, px);
            background.image(linear(rgba(240, 192, 28, 0.5), rgba(160, 123, 1, 0.5)));

            while (firstChild()) {
                border.none();
            }
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class LevelMark3 extends LevelMark {

        {
            box.width(SkillIconSize / 3, px);
        }
    }

    /**
     * @version 2013/02/09 23:26:39
     */
    class Assigned extends CSS {

        {
            background.image(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1)));
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class IconBox extends CSS {

        {
            display.tableCell();
            padding.right(SkillIconSize / 5, px);
            cursor.pointer();
        }
    }

    /**
     * @version 2013/02/02 11:27:13
     */
    class DescriptionBox extends CSS {

        {
            display.tableCell();
            text.verticalAlign.top();
            box.height(60, px);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Name extends CSS {

        {
            margin.right(0.5, em);
            font.weight.bold();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Text extends CSS {

        {
            display.block();
            margin.top(0.4, em);
            line.height(140, percent);
            font.size.smaller();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class ComputedValue extends CSS {

        {
            font.weight.bolder();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class NormalValue extends CSS {

        {
            text.align.center();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class ChampionLevelIndicator extends CSS {

        {
            cursor.help();
            border.bottom.dotted().width(1, px);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Separator extends CSS {

        {
            box.opacity(0.4);
            margin.horizontal(1, px);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Current extends CSS {

        {
            font.color(rgba(160, 123, 1, 1));
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Passive extends CSS {

        {
            margin.right(1, em);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Amplifier extends CSS {

        {
            font.color(25, 111, 136);

            while (inBackOf(NormalValue.class)) {
                margin.left(0.4, em);
            }

            while (inBackOf(Amplifier.class)) {
                margin.left(0.4, em);
            }
        }
    }

    /**
     * @version 2013/02/16 0:35:05
     */
    class Active extends CSS {

        {
            box.opacity(0.5);
        }
    }

    Value ChampionIconSize = new Value(70, Unit.px);

    /**
     * @version 2013/01/15 13:19:52
     */
    class ChampionIcon extends CSS {

        {
            display.block();
            box.size(ChampionIconSize);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            position.relative();
            cursor.pointer();
        }
    }

    /**
     * @version 2013/01/15 13:19:52
     */
    class Level extends CSS {

        {
            display.block();
            box.size(22, px);
            font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
            text.align.center().shadow(0, px, 0, px, 1, px, rgba(0, 0, 0, 1));
            position.absolute().bottom(4, px).right(4, px);
            userSelect.none();
            cursor.defaults();

            while (selection()) {
                background.color.transparent();
            }
        }
    }

    /**
     * @version 2013/02/11 0:02:30
     */
    class StatusViewBox extends CSS {

        {
            display.tableCell();
            box.width(13, em);
            text.verticalAlign.top();
        }
    }

    /**
     * @version 2013/01/21 16:33:33
     */
    class StatusBox extends CSS {

        {
            display.block();
            margin.bottom(4, px);
        }
    }

    /**
     * @version 2013/01/21 16:33:33
     */
    class StatusName extends CSS {

        {
            display.tableCell();
            box.width(5, em);
        }
    }

    /**
     * @version 2013/01/21 16:33:33
     */
    class StatusValue extends CSS {

        {
            display.tableCell();
            box.width(50, px);
        }
    }

    Value ItemIconSize = ChampionIconSize.divide(5).multiply(3);

    class ItemViewBox extends CSS {

        {
            display.flex();
            box.width(ItemIconSize.multiply(6));
            margin.left(137, px);
        }
    }

    class ItemIconBase extends CSS {

        {
            display.block();
            box.size(ItemIconSize);
            background.image("src/main/resources/teemowork/item/empty.png").cover();
            padding.size(3, px);
        }
    }

    class ItemIcon extends CSS {

        {
            display.block();
            box.size(100, percent);
        }
    }
}