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

/**
 * @version 2012/12/06 23:07:37
 */
public class Patch {

    public static Patch P1520 = new Patch(1510, 2012, 11, 13, "Preseason 3");

    static {
        P1520.update(Item.ShardOfTrueIce);
    }

    /** The update number. */
    public final int number;

    /** The update name. */
    public final String name;

    /**
     * Create patch information.
     */
    public Patch(int number, int year, int month, int day, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * <p>
     * Update item.
     * </p>
     * 
     * @param item
     */
    public Item update(Item item) {
        return null;
    }

    /**
     * @version 2012/12/06 23:17:43
     */
    private static class ItemUpdate {

    }
}
