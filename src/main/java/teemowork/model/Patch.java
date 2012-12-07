/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 2012/12/06 23:07:37
 */
public class Patch {

    /** The patch. */
    public static Patch P0000 = new Patch(1510, 2012, 11, 13, "Initial", null);

    static {
        P0000.update(Item.RubyCrystal).cost(475).health(180);
        P0000.update(Item.HauntingGuise).health(200).ap(25);
    }

    /** The patch. */
    public static Patch P1520 = new Patch(1520, 2012, 12, 03, "Preseason 3", P0000);

    static {
        P1520.update(Item.ShardOfTrueIce);
        P1520.update(Item.LiandrysTorment);
        P1520.update(Item.HauntingGuise);
    }

    /** The latest patch. */
    public static Patch Latest = P1520;

    /** The update number. */
    public final int number;

    /** The update name. */
    public final String name;

    /** The previous {@link Patch}. */
    private final Patch previous;

    /** The item list. */
    private final Map<String, Item> items = new HashMap();

    /**
     * Create patch information.
     */
    public Patch(int number, int year, int month, int day, String name, Patch previous) {
        this.number = number;
        this.name = name;
        this.previous = previous;
    }

    /**
     * <p>
     * Update item.
     * </p>
     * 
     * @param name
     */
    private Item update(String name) {
        Item item = findItem(name);

        if (item == null) {
            item = new Item(name);
        } else {
            item = item.copy();
        }

        items.put(name, item);

        return item;
    }

    /**
     * <p>
     * Helper method to find item by name.
     * </p>
     * 
     * @param name
     * @return
     */
    public Item findItem(String name) {
        Patch patch = this;

        while (patch != null) {
            Item item = patch.items.get(name);

            if (item != null) {
                return item;
            }
            patch = patch.previous;
        }
        return null;
    }
}
