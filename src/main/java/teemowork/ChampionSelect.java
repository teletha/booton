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

import js.Page;
import js.application.Header;
import js.application.Header.Menu;
import js.ui.ImageGrid;
import teemowork.model.Champion;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/26 13:06:59
 */
public class ChampionSelect extends Page {

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
            return "src/main/resources/teemowork/icon/" + source.getSystemName() + ".png";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void select(Champion source) {
        }
    };

    /**
     * @param pattern
     */
    public ChampionSelect() {
        super("chmpion-select");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void render(jQuery root) {
        $("body").css("padding", "0px 10%");

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
