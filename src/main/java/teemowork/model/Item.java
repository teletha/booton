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
    public static final Item ShardOfTrueIce = new Item("Shard of True Ice");

    /** The item. */
    public static final Item LiandrysTorment = new Item("Liandry's Torment");

    /** The item. */
    public static final Item HauntingGuise = new Item("Haunting Guise");

    /** The name. */
    public final String name;

    /** The status. */
    public final JsArray<Status> history = new JsArray();

    public int ap;

    /**
     * @param name
     */
    private Item(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Set ability power.
     * </p>
     * 
     * @param value
     * @return
     */
    Item ap(int ap) {
        this.ap = ap;

        return this;
    }

    /**
     * <p>
     * Set magic resist penetration.
     * </p>
     * 
     * @param value
     * @return
     */
    Item mrpen(int value) {
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

    /**
     * @version 2012/12/07 1:42:06
     */
    private static class Status {

    }
}
