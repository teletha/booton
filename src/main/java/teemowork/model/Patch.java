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

import booton.translator.js.JsArray;

/**
 * @version 2012/12/06 23:07:37
 */
public class Patch {

    /** The patch. */
    public static Patch P1510 = new Patch(1510, 2012, 11, 13, "End of Season 2", null);

    static {
        P1510.update(Item.HauntingGuise).mrpen(20);
    }

    /** The patch. */
    public static Patch P1520 = new Patch(1520, 2012, 12, 03, "Preseason 3", P1510);

    static {
        P1520.update(Item.ShardOfTrueIce);
        P1520.update(Item.LiandrysTorment);
        P1520.update(Item.HauntingGuise).mrpen(15);
    }

    /** The latest patch. */
    public static Patch latest = P1520;

    /** The update number. */
    public final int number;

    /** The update name. */
    public final String name;

    /** The previous {@link Patch}. */
    private final Patch previous;

    /** The item list. */
    private final JsArray<Item> items = new JsArray();

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
     * @param item
     */
    private Item update(Item item) {
        items.push(item);
        return item;
    }

    /**
     * @version 2012/12/06 23:17:43
     */
    private static class ItemUpdate {

    }

    /**
     * @return
     */
    public JsArray<Item> getItems() {
        return items;
    }
}
