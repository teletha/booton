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

import java.util.Map;
import java.util.Map.Entry;

import js.util.HashMap;

/**
 * @version 2012/12/06 23:20:54
 */
public class Teemowork {

    public static void jsmain() {
        // System.out.println(Patch.Latest.findItem(Item.HauntingGuise));

        Map<String, String> map = new HashMap();
        map.put("1", "test1");
        map.put("2", "test2");

        System.out.println(map.size());

        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        map.put("1", "override");

        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
