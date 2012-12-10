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

import static teemowork.model.Item.*;

import java.util.Map;

import js.util.HashMap;

/**
 * @version 2012/12/06 23:07:37
 */
public class Patch {

    /** The patch. */
    public static Patch P0000 = new Patch(1510, 2012, 11, 13, "Initial", null);

    static {
        P0000.updateItem(RubyCrystal).cost(475).health(180);
        P0000.updateItem(HauntingGuise).health(200).ap(25);
    }

    /** The patch. */
    public static Patch P1520 = new Patch(1520, 2012, 12, 03, "Preseason 3", P0000);

    static {
        P1520.updateItem(ShardOfTrueIce);
        P1520.updateItem(LiandrysTorment);
        P1520.updateItem(HauntingGuise);
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
    private Patch(int number, int year, int month, int day, String name, Patch previous) {
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
    private Item updateItem(String name) {
        Item item = new Item(name, this);
        items.put(name, item);

        return item;
    }
}
