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

import js.util.Color;
import booton.css.CSS;
import booton.css.Snippet;

/**
 * @version 2013/06/09 18:48:17
 */
public class PopupViewStyle {

    public class Root extends CSS {

        int IconSize = 40;

        int Width = 280;

        int BorderWidth = 2;

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 1);

        {
            display.block();
            position.absolute().bottom(IconSize - 15, px).left(IconSize / 2 - Width / 2, px);
            box.width(Width, px).zIndex(100).shadow(0, px, 0, px, 7, px, color);
            background.image(linear(color.opacify(-0.25), color));
            border.radius(5, px).solid().width(BorderWidth, px).color(borderColor);
            padding.size(10, px);
            font.color(hsl(0, 99, 97)).size.smaller();
            transition.property.all().duration(0.15, s).timing.easeInOut().delay(0.2, s);
            pointerEvents.none();

            Snippet.createBottomBubble(6);
        }
    }
}
