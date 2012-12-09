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

import java.util.Set;

import js.util.HashSet;

/**
 * @version 2012/12/06 23:20:54
 */
public class Teemowork {

    public static void jsmain() {
        // System.out.println(Patch.Latest.findItem(Item.HauntingGuise));

        Set<String> set = new HashSet();
        set.add("test");

        System.out.println(set.contains("test"));
        System.out.println(set.contains("test1"));
        System.out.println(set.size());

        set.add("asdasd");
        set.add("test");

        for (String string : set) {
            System.out.println(string);
        }
        System.out.println(set);
    }
}
