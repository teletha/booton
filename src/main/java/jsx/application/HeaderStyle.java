/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import teemowork.TeemoworkTheme;
import booton.css.CSS;
import booton.css.value.Color;

class HeaderStyle {

    /** The background color. */
    Color LightBack = new Color(0, 0, 27);

    /** The background color. */
    Color DarkBack = LightBack.lighten(-20);

    /** The minimum menu width. */
    int MenuWidth = 120;

    /** The menu radius. */
    int Radius = 3;

    class TopMenuGroup extends CSS {

        {
            margin.vertical(30, px);
            box.shadow(0, px, 1, px, 1, px, hsla(0, 0, 0, 0.15));
            border.width(1, px).solid().color(DarkBack).radius(6, px);
            background.image(linear(LightBack, DarkBack));
        }

    }

    class TopMenu extends CSS {

        {
            position.relative();
            display.inlineBlock();
            borderRight.width(1, px).solid().color(DarkBack);
            box.minWidth(MenuWidth, px).zIndex(1);
            text.align.center();
        }
    }

    class MenuLink extends CSS {

        {
            display.block();
            padding.vertical(12, px).horizontal(20, px);
            font.color(153, 153, 153).weight.bold().size(12, px).family(TeemoworkTheme.Header);
            text.decoration.none().shadow();

            while (hover()) {
                font.color(Color.Whity);
            }
        }
    }

    class SubMenuGroup extends CSS {

        {
            listStyle.none();
            margin.top(20, px);
            padding.size(0, px);
            visibility.hidden();
            position.absolute().top(42, px).left(0, px);
            background.color(68, 68, 68).image(linear(LightBack, DarkBack));
            box.width(MenuWidth, px).shadow(0, px, -1, px, 0, px, rgba(255, 255, 255, 0.3)).opacity(0);
            border.radius(Radius, px);
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(80, ms);

            while (parentHover()) {
                box.opacity(1);
                visibility.visible();
                margin.size(0, px);
            }
        }
    }

    class SubMenu extends CSS {

        {
            display.block();
            border.width(0, px);
            borderBottom.width(1, px).solid().color(81, 81, 81);

            while (hover()) {
                background.color(1, 134, 186).image(linear(rgba(4, 172, 236, 1), rgba(1, 134, 186, 1)));

                while (firstChild()) {
                    border.radius(Radius, px, Radius, px, 0, px, 0, px);
                }

                while (lastChild()) {
                    border.radius(0, px, 0, px, Radius, px, Radius, px);
                }
            }
        }
    }
}