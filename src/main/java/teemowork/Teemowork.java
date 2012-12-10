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

import teemowork.model.Item;
import teemowork.model.Patch;
import booton.CSS;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/06 23:20:54
 */
public class Teemowork {

    public static void jsmain() {
        System.out.println(Patch.Latest);
        final Collection<Item> items = Item.getAll();

        for (Item item : items) {
            jQuery root = $("<p>").appendTo("body");
            root.text(item.name + "  " + item.cost());
            System.out.println(MyCSS.class);
            root.css(MyCSS.class);
        }
    }

    /**
     * @version 2012/12/10 16:59:19
     */
    private static class MyCSS extends CSS {

        {
            color(red);
        }
    }
}
