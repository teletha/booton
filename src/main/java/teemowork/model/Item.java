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
 * @version 2012/12/06 18:41:16
 */
public class Item {

    private static JsArray<Item> items = new JsArray();

    /** The item. */
    public static final Item ShardOfTrueIce = new Item("Shard of True Ice", 1700);

    static {
        // items.push(new Item("Shard of True Ice", 1700));
        // items.push(new Item("Liandry's Torment", 2900));
        // items.push(new Item("Mikael's Crucible", 2200));

    }

    /** The name. */
    public final String name;

    /** The total cost. */
    public final int coat;

    /** The ability power. */
    private int ap = 0;

    /**
     * @param name
     */
    private Item(String name, int cost) {
        this.name = name;
        this.coat = cost;
    }

    /**
     * <p>
     * Set ability power.
     * </p>
     * 
     * @param value
     * @return
     */
    private Item ap(int ap) {
        this.ap = ap;

        return this;
    }

    /**
     * <p>
     * Retrieve item by name.
     * </p>
     * 
     * @param name
     * @return
     */
    public static Item getByName(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * <p>
     * Retrieve all items.
     * </p>
     * 
     * @return
     */
    public static JsArray<Item> getAll() {
        return items;
    }
}
