/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static booton.translator.web.WebSupport.*;

import java.util.Collection;

import js.ui.Application;
import js.ui.Header;
import js.ui.Header.Menu;
import js.ui.ImageGrid;
import teemowork.model.Champion;
import booton.css.CSS;
import booton.css.FontFamily;
import booton.css.Value;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/11 14:23:57
 */
public class Teemowork extends Application {

    /** The champion viewer. */
    private ImageGrid champions = new ImageGrid<Champion>() {

        @Override
        protected Collection<Champion> sources() {
            return Champion.getAll();
        }

        @Override
        protected String name(Champion source) {
            return source.name;
        }

        @Override
        protected String uri(Champion source) {
            return "src/main/resources/teemowork/icon/" + source.getSystemName() + ".png";
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    protected void jsmain() {
        // create navigation
        // body.append("<div class='navbar'><div class='navbar-inner'><a class='brand' href='#'>Title</a> <ul class='nav'><li class='active'><a href='#''>Home</a></li><li><a href='#''>Link</a></li> <li><a href='#''>Link</a></li> </ul></div></div>");

        $("body").css("padding", "150px");

        jQuery root = $("body");

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "test.html");
        nav.add("Patch", "#");

        Menu sub = nav.add("Data", "#");
        sub.add("Champion", "#");
        sub.add("Item", "#");
        sub.add("Mastery", "#");
        sub.add("Rune", "#");

        nav.add("Builder", "#");
        nav.add("About", "#");
        nav.add("Contact", "#");

        for (Champion champion : Champion.getAll()) {
            String uri = "src/main/resources/teemowork/icon/" + champion.getSystemName() + ".png";

            root.child(MyCSS.class).css("background-image", "url(" + uri + ")").child("span").text(champion.name);
        }
    }

    /**
     * @version 2012/12/10 16:59:19
     */
    private static class MyCSS extends CSS<MyCSS> {

        private FontFamily Yanone = new FontFamily("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

        {
            display.inlineBlock();
            box.size(70, px);
            outline.none();
            background.color.transparent().noRepeat().top().left().contain();
            position.relative();

            cover();

            while (rule("span")) {
                font.weight.bold().size(18, px).family(Yanone);
                lineHeight.size(20, px);
                padding.size(5, px);
                text.align.center().shadow(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
                background.color(255, 255, 255, 0.6);
                border.radius(5, px);
                pointerEvents.none();
                position.bottom(100, px);
                box.opacity(0).shadow(1, px, 1, px, 2, px, rgba(0, 0, 0, 0.1));
                transition.property.all().duration(0.2, s).timing.easeInOut().delay(0.15, s);

                bubble(100, 4, 10);
            }

            while (rule(":hover span")) {
                box.opacity(0.9);
                position.bottom(70, px);
            }
        }

        /**
         * Apply screen cover.
         */
        private void cover() {
            Value width = box.width();
            Value height = box.height();

            while (rule("::after")) {
                content.text("");
                display.block();
                position.absolute();
                box.width(width.size, width.unit).height(height.size, height.unit).opacity(0.15);
                background.color.white();
            }

            while (rule(":hover::after")) {
                box.opacity(0);
            }
        }
    }

}
