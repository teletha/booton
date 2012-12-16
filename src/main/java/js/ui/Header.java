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

import static booton.translator.web.WebSupport.*;
import booton.css.CSS;
import booton.css.FontFamily;
import booton.translator.web.jQuery;
import booton.util.Color;

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
        container = $("#Header").addClass(Style.class);
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
        jQuery item = container.child("li");
        item.child("a").attr("href", uri).text(label);

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
            this.container = root.child("ul");
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
            jQuery item = container.child("li");
            item.child("a").attr("href", uri).text(label);

            return new Menu(item);
        }
    }

    /**
     * @version 2012/12/14 23:51:44
     */
    public static class Style extends CSS<Style> {

        /** The header font. */
        private final FontFamily family = new FontFamily("http://fonts.googleapis.com/css?family=Orbitron");

        {
            int Header = 120;

            box.width(960, px).shadow(0, px, 1, px, 1, px, color("#777"));
            margin.vertical(60, px).auto();
            border.width(1, px).solid().color("#222").radius(6, px);
            background.color(background()).image(linear("#444", background().hex));

            while (rule("li")) {
                display.inlineBlock();
                borderRight.width(1, px).solid().color("#222");
                position.relative();
                box.minWidth(Header, px).zIndex(1);
                text.align.center();
            }

            while (rule("a")) {
                display.inlineBlock();
                padding.vertical(12, px).horizontal(30, px);
                font.color("#999").weight.bold().size(12, px).family(family);
                text.decoration.none().shadow(0, px, 1, px, 0, px, rgba(0, 0, 0, 1));
            }

            while (rule("li:hover > a")) {
                font.color("#fafafa");
            }

            while (rule("ul")) {
                listStyle.none();
                margin.top(20, px);
                padding.size(0, px);
                visibility.hidden();
                position.absolute().top(44, px).left(0, px);
                background.color("#444").image(linear("#444", "#111"));
                box.shadow(0, px, -1, px, 0, px, rgba(255, 255, 255, 0.3)).opacity(0);
                border.radius(3, px);
                transition.property.all().duration(0.2, s).timing.easeInOut().delay(80, ms);
            }

            while (rule("li:hover > ul")) {
                box.opacity(1);
                visibility.visible();
                margin.size(0, px);
            }

            while (rule("ul ul")) {
                position.top(0, px).left(Header, px);
                margin.left(20, px).top(0, px);
                box.shadow(-1, px, 0, px, 0, px, rgba(255, 255, 255, 0.3));
            }

            while (rule("ul li")) {
                display.block();
                border.width(0, px);
                borderBottom.width(1, px).solid().color("#515151");
            }

            while (rule("ul a")) {
                padding.size(10, px);
                box.width(Header, px);
                display.block();
            }

            while (rule("ul a:hover")) {
                background.color("#0186ba").image(linear("#04acec", "#0186ba"));
            }
        }

        protected Color background() {
            return new Color("#111");
        }
    }
}
