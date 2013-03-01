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

import static js.lang.Global.*;
import js.application.Application;
import js.application.Header;
import js.application.Header.Menu;
import teemowork.TeemoworkTheme.Content;
import teemowork.TeemoworkTheme.HTML;

/**
 * @version 2012/12/11 14:23:57
 */
public class Teemowork extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public void jsmain() {
        $("html").addClass(HTML.class);
        $("#Content").addClass(Content.class);

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "");
        nav.add("Patch", "#");

        Menu sub = nav.add("Champion", "#");
        sub.add("Compare", "#ChampionComparing");
        sub.add("Item", "#ItemCatalog");
        sub.add("Mastery", "#");
        sub.add("Rune", "#");

        nav.add("Builder", "#");
        nav.add("About", "#");
        nav.add("Contact", "#");
    }
}
