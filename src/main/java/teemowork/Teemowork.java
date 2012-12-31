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

import js.Application;
import js.Page;
import js.application.Header;
import js.application.Header.Menu;
import js.ui.ImageGrid;
import teemowork.model.Champion;
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
        protected String getTitle(Champion source) {
            return source.name;
        }

        @Override
        protected String getImageURI(Champion source) {
            return source.getIcon();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void select(Champion source) {
            $("#Content").css("background-image", "url(" + source.getSplashArt() + ")")
                    .css("background-size", "contain")
                    .css("background-repeat", "no-repeat");
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<? extends Page> initialPage() {
        return ChampionSelect.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void jsmain() {
        System.out.println(history);

        $("body").css("padding", "0px 10%");

        jQuery root = $("#Content");

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

        champions.compose(root);
    }
}
