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

import java.util.List;

import teemowork.model.Item;
import teemowork.model.Patch;

/**
 * @version 2012/12/06 23:20:54
 */
public class Teemowork {

    public static void jsmain() {
        List<Item> items = Patch.Latest.getItems();

        System.out.println(items);
        System.out.println("Remove  " + items.remove(0));

        for (Item item : Patch.Latest.getItems()) {
            System.out.println(item);
        }
    }
}
