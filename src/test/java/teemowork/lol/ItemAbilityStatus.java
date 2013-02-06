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
public class ItemAbilityStatus {

    /** The unique flag. */
    private boolean unique;

    /** The aura flag. */
    private boolean aura;

    /** The ability description. */
    private String description;

    /** The value store. */
    private final NativeArray<Double> values;

    /**
     * <p>
     * Create new item ability.
     * </p>
     * 
     * @param name
     * @param unique
     * @param previous
     */
    ItemAbilityStatus(ItemAbilityStatus previous) {
        if (previous != null) {
            unique = previous.unique;
            aura = previous.aura;
            description = previous.description;
            values = previous.values;
        } else {
            unique = false;
            aura = false;
            description = "";
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
    public ItemAbilityStatus set(Status status, double value) {
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
    public ItemAbilityStatus set(Status status, double base, double per) {
        values.set(status.ordinal(), base);
        values.set(Status.valueOf(status.name() + "PerLv").ordinal(), per);

        return this;
    }

    /**
     * <p>
     * Make as aura.
     * </p>
     * 
     * @param range
     * @return
     */
    public ItemAbilityStatus aura(double range) {
        this.aura = true;
        this.unique = true;
        set(Range, range);

        return this;
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isAura() {
        return aura;
    }

    /**
     * <p>
     * Make as unique.
     * </p>
     * 
     * @return
     */
    public ItemAbilityStatus unique() {
        this.unique = true;

        return this;
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * <p>
     * Describe this ability.
     * </p>
     * 
     * @param text
     * @return
     */
    public ItemAbilityStatus description(String text) {
        this.description = text;

        return this;
    }

    /**
     * <p>
     * Retrieve description.
     * </p>
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }
}
