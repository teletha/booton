/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.Status.*;
import js.lang.NativeArray;

/**
 * @version 2013/01/29 1:55:25
 */
public class ItemDescriptor {

    /** The value store. */
    private NativeArray<Double> values;

    /** The item build. */
    private Item[] build;

    /** The abilities. */
    public ItemAbility[] abilities;

    /**
     * @param name
     */
    ItemDescriptor(ItemDescriptor previous) {
        if (previous != null) {
            values = previous.values.copy();
            build = previous.build;
            abilities = previous.abilities;
        } else {
            values = new NativeArray();
            build = new Item[0];
            abilities = new ItemAbility[0];
        }
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return A result.
     */
    public double get(Status status) {
        Double value = values.get(status.ordinal());

        return value == null ? 0 : value;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    public ItemDescriptor set(Status status, double value) {
        values.set(status.ordinal(), value);

        return this;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    public ItemDescriptor set(Status status, double base, double per) {
        if (status == Cost) {
            values.set(status.ordinal(), base);
            values.set(Sell.ordinal(), per);
        } else {
            values.set(status.ordinal(), base);
            values.set(Status.valueOf(status.name() + "PerLv").ordinal(), per);
        }

        return this;
    }

    /**
     * <p>
     * Set build items.
     * </p>
     * 
     * @param items
     * @return
     */
    public ItemDescriptor build(Item... items) {
        this.build = items;

        return this;
    }

    /**
     * <p>
     * Add item abilities.
     * </p>
     * 
     * @param abilities
     * @return
     */
    public ItemDescriptor ability(ItemAbility... abilities) {
        this.abilities = abilities;

        return this;
    }
}
