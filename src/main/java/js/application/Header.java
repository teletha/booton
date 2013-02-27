/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.application;

import static js.lang.Global.*;
import js.util.jQuery;
import booton.css.CSS;
import booton.util.Font;

/**
 * @version 2012/12/15 9:58:38
 */
public class Header {

    /** The application header. */
    private final jQuery container;

    /**
     * @param root
     */
    public Header() {
        container = $("#Header").addClass(TopMenuGroup.class);
    }

    /**
     * <p>
     * Add navigation menu.
     * </p>
     * 
     * @param label
     * @param uri
     */
    public Menu add(String label, String uri) {
        jQuery item = container.child("li").addClass(TopMenu.class);
        item.child("a").addClass(MenuLink.class).attr("href", uri).text(label);

        return new Menu(item);
    }

    /**
     * @version 2012/12/15 9:59:53
     */
    public class Menu {

        /** The container element. */
        private final jQuery container;

        /**
     * 
     */
        private Menu(jQuery root) {
            this.container = root.child("ul").addClass(SubMenuGroup.class);
        }

        /**
         * <p>
         * Add navigation menu.
         * </p>
         * 
         * @param label
         * @param uri
         */
        public Menu add(String label, String uri) {
            jQuery item = container.child("li").addClass(SubMenu.class);
            item.child("a").addClass(MenuLink.class).attr("href", uri).text(label);

            return new Menu(item);
        }
    }

    /**
     * @version 2012/12/14 23:51:44
     */
    public static class TopMenuGroup extends CSS {

        {
            box.width(960, px).shadow(0, px, 1, px, 1, px, rgba(119, 119, 119, 1));
            margin.vertical(60, px).auto();
            border.width(1, px).solid().color(34, 34, 34).radius(6, px);
            background.color(17, 17, 17).image(linear(rgba(68, 68, 68, 1), rgba(17, 17, 17, 1)));
        }

    }

    /**
     * @version 2012/12/25 12:27:53
     */
    private static class TopMenu extends CSS {

        /** The menu width. */
        private static int Width = 120;

        {
            display.inlineBlock();
            borderRight.width(1, px).solid().color(34, 34, 34);
            position.relative();
            box.minWidth(TopMenu.Width, px).zIndex(1);
            text.align.center();
            padding.size(0, px);

        }
    }

    /**
     * @version 2012/12/25 12:29:48
     */
    private static class MenuLink extends CSS {

        /** The header font. */
        private final Font family = new Font("http://fonts.googleapis.com/css?family=Orbitron");

        {
            display.block();
            padding.vertical(12, px).horizontal(20, px);
            font.color(153, 153, 153).weight.bold().size(12, px).family(family);
            text.decoration.none().shadow(0, px, 1, px, 0, px, rgba(0, 0, 0, 1)).align.center();

            while (hover()) {
                font.color(250, 250, 250);
            }
        }
    }

    /**
     * @version 2012/12/25 12:37:56
     */
    private static class SubMenuGroup extends CSS {

        /** The menu radius. */
        private static int Radius = 3;

        {
            listStyle.none();
            margin.top(20, px);
            padding.size(0, px);
            visibility.hidden();
            position.absolute().top(42, px).left(0, px);
            background.color(68, 68, 68).image(linear(rgba(68, 68, 68, 1), rgba(17, 17, 17, 1)));
            box.width(TopMenu.Width, px).shadow(0, px, -1, px, 0, px, rgba(255, 255, 255, 0.3f)).opacity(0);
            border.radius(Radius, px);
            transition.property.all().duration(0.2, s).timing.easeInOut().delay(80, ms);

            while (parentHover()) {
                box.opacity(1);
                visibility.visible();
                margin.size(0, px);
            }
        }
    }

    /**
     * @version 2012/12/24 23:38:50
     */
    private static class SubMenu extends CSS {

        {
            display.block();
            border.width(0, px);
            borderBottom.width(1, px).solid().color(81, 81, 81);

            while (hover()) {
                background.color(1, 134, 186).image(linear(rgba(4, 172, 236, 1), rgba(1, 134, 186, 1)));

                while (firstChild()) {
                    border.radius(SubMenuGroup.Radius, px, SubMenuGroup.Radius, px, 0, px, 0, px);
                }

                while (lastChild()) {
                    border.radius(0, px, 0, px, SubMenuGroup.Radius, px, SubMenuGroup.Radius, px);
                }
            }
        }
    }
}
