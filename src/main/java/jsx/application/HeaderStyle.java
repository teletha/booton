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

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;

class HeaderStyle extends StyleRuleDescriptor {

    /** The background color. */
    private static final Color LightBack = new Color(0, 0, 27);

    /** The background color. */
    private static final Color DarkBack = LightBack.lighten(-20);

    /** The minimum menu width. */
    private static final int MenuWidth = 120;

    /** The menu radius. */
    private static final int Radius = 3;

    static Style TopMenuGroup = () -> {
        margin.vertical(30, px);
        box.shadow(shadow().offset(0, 1, px).blurRadius(1, px).color(hsla(0, 0, 0, 0.15)));
        border.width(1, px).solid().color(DarkBack).radius(6, px);
        background.image(BackgroundImage.of(linear(LightBack, DarkBack)));
    };

    static Style TopMenu = () -> {
        position.relative();
        display.inlineBlock();
        border.right.width(1, px).solid().color(DarkBack);
        box.minWidth(MenuWidth, px).zIndex(1);
        text.align.center();
    };

    static Style MenuLink = () -> {
        display.block();
        padding.vertical(12, px).horizontal(20, px);
        font.color(153, 153, 153).weight.bold().size(14, px);
        text.decoration.none().shadow();

        hover(() -> {
            font.color(Color.Whity);
        });
    };

    static Style SubMenuGroup = () -> {
        listStyle.none();
        margin.top(20, px);
        padding.size(0, px);
        visibility.hidden();
        position.absolute().top(42, px).left(0, px);
        background.color(rgb(68, 68, 68)).image(BackgroundImage.of(linear(LightBack, DarkBack)));
        box.width(MenuWidth, px).shadow(shadow().offset(0, -1, px).color(rgba(255, 255, 255, 0.3))).opacity(0);
        border.radius(Radius, px);

        transit().duration(0.2, s).delay(80, ms).easeInOut().whenParentHover(() -> {
            box.opacity(1);
            visibility.visible();
            margin.size(0, px);
        });
    };

    static Style SubMenu = () -> {
        display.block();
        border.bottom.width(1, px).solid().color(rgb(81, 81, 81));

        hover(() -> {
            background
                    .color(rgb(1, 134, 186))
                    .image(BackgroundImage.of(linear(rgba(4, 172, 236, 1), rgba(1, 134, 186, 1))));

            firstChild(() -> {
                border.top.radius(Radius, px);
            });

            lastChild(() -> {
                border.bottom.radius(Radius, px);
            });
        });
    };
}