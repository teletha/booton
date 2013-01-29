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

import js.lang.NativeArray;

/**
 * @version 2013/01/29 1:55:25
 */
public class ItemAbility {

    /** The value store. */
    private NativeArray<Double> values;

    /**
     * @param name
     */
    ItemAbility(ItemAbility previous) {
        if (previous != null) {
            values = previous.values.copy();
        } else {
            values = new NativeArray();
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
    public ItemAbility set(Status status, double value) {
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
    public ItemAbility set(Status status, double base, double per) {
        values.set(status.ordinal(), base);
        values.set(Status.valueOf(status.name() + "PerLv").ordinal(), per);

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
    public ItemAbility build(Item... items) {

        return this;
    }
}
