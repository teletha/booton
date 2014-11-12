/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;

/**
 * @version 2013/06/09 18:48:17
 */
public class PopupViewStyle2 extends StyleRuleDescriptor {

    public static Style Show = () -> {
        box.opacity(1);
    };

    public static Style Root = () -> {

        int IconSize = 40;

        int Width = 280;

        int BorderWidth = 2;

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 1);
        display.block();
        position.absolute().bottom(IconSize - 15, px).left(IconSize / 2 - Width / 2, px);
        box.width(Width, px).zIndex(100).shadow(shadow().blurRadius(7, px).color(color));
        background.image(BackgroundImage.of(linear(color.opacify(-0.25), color)));
        border.radius(5, px).solid().width(BorderWidth, px).color(borderColor);
        padding.size(10, px);
        font.color(hsl(0, 99, 97)).size.smaller();
        // transition.property.all().duration(0.15, s).timing.easeInOut().delay(0.2, s);
        pointerEvents.none();

        // createBottomBubble(6);
    };

    public static Style Bottom = () -> {

        Numeric IconSize = new Numeric(40, px);

        Numeric Width = new Numeric(300, px);

        Numeric BorderWidth = new Numeric(2, px);

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 1);

        display.block();
        position.absolute();
        box.zIndex(100).shadow(shadow().blurRadius(7, px).color(color)).opacity(0);
        background.image(BackgroundImage.of(linear(color.opacify(-0.15), color)));
        border.radius(5, px).solid().width(BorderWidth).color(borderColor);
        padding.size(10, px);
        font.color(hsl(0, 99, 97));
        pointerEvents.none();

        createTopBubble(6, BorderWidth, borderColor, Color.Transparent);
    };
}
