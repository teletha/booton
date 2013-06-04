/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import js.lang.NativeArray;
import teemowork.model.variable.Variable;

/**
 * @version 2013/01/29 1:55:25
 */
public class ItemDescriptor extends Descriptor<ItemDescriptor> {

    /** The value store. */
    private NativeArray<Double> values;

    /** The variable store. */
    private NativeArray<Variable> variables;

    /** The item build. */
    Item[] build;

    public Map<String, List> passives;

    /**
     * @param name
     */
    ItemDescriptor(Item item, ItemDescriptor previous) {
        super(item, previous);

        if (previous != null) {
            values = previous.values.copy();
            variables = previous.variables;
            build = previous.build;
            passives = previous.passives;
        } else {
            values = new NativeArray();
            variables = new NativeArray();
            build = new Item[0];
            passives = new HashMap();
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
    ItemDescriptor set(Status status, double value) {
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
    ItemDescriptor cost(double base) {
        set(Cost, base);

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
    ItemDescriptor build(Item... items) {
        this.build = items;

        return this;
    }
}
