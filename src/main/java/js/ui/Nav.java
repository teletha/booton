/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import booton.css.CSS;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/15 9:58:38
 */
public class Nav extends NavItem {

    /**
     * @param root
     */
    public Nav(jQuery root) {
        super(root);

        this.container.addClass(Style.class);
    }

    /**
     * @version 2012/12/14 23:51:44
     */
    private static class Style extends CSS {

        {
            box.width(960, px);
            margin.vertical(60, px).auto();
            border.width(1, px).solid().color("#222").radius(6, px);
            boxShadow.offset(0, px, 1, px).blurRadius(1, px).color("#777");
            background.color("#111").image(linear("#444", "#111"));

            while (rule("li")) {
                display.inlineBlock();
                borderRight.width(1, px).solid().color("#222");
                boxShadow.offset(1, px, 0, px).blurRadius(0, px).color("#444");
                position.relative();
                box.width(120, px).zIndex(1);
                textAlign.center();
            }

            while (rule("a")) {
                display.inlineBlock();
                padding.vertical(12, px).horizontal(30, px);
                font.color("#999").weight.bold().size(12, px).family("Arial");
                textShadow.add(0, px, 1, px, 0, px, rgba(0, 0, 0, 1));
                text.decoration.none();
            }

            while (rule("li:hover > a")) {
                font.color("#fafafa");
            }

            while (rule("ul")) {
                margin.top(20, px);
                opacity.alpha(0);
                visibility.hidden();
                position.absolute().top(44, px).left(0, px);
                background.color("#444").image(linear("#444", "#111"));
                boxShadow.offset(0, px, -1, px).blurRadius(0, px).rgba(255, 255, 255, 0.3);
                border.radius(3, px);
                transition.property.all().duration(0.2, s).timing.easeInOut().delay(80, ms);
            }

            while (rule("li:hover > ul")) {
                opacity.alpha(1);
                visibility.visible();
                margin.size(0, px);
            }

            while (rule("ul ul")) {
                position.top(0, px).left(120, px);
                margin.left(20, px).top(0, px);
                boxShadow.offset(-1, px, 0, px).blurRadius(0, px).rgba(255, 255, 255, 0.3);
            }

            while (rule("ul li")) {
                display.block();
                border.width(0, px);
                borderBottom.width(1, px).solid().color("#515151");
            }

            while (rule("ul a")) {
                padding.size(10, px);
                box.width(120, px);
                display.block();
            }

            while (rule("ul a:hover")) {
                background.color("#0186ba").image(linear("#04acec", "#0186ba"));
            }
        }
    }
}
