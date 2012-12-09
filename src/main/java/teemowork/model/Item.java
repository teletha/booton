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

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2012/12/07 10:00:23
 */
public class Item {

    private static List<Item> items = new ArrayList();

    /** The item name. */
    public static final String RubyCrystal = "Ruby Crystal";

    /** The item. */
    public static final String ShardOfTrueIce = "Shard of True Ice";

    /** The item. */
    public static final String LiandrysTorment = "Liandry's Torment";

    /** The item. */
    public static final String HauntingGuise = "Haunting Guise";

    /** The name. */
    public final String name;

    /** Item status. */
    private int cost;

    /** Item status. */
    private int ad;

    /** Item status. */
    private int as;

    /** Item status. */
    private int critical;

    /** Item status. */
    private int arpen;

    /** Item status. */
    private int arpenRatio;

    /** Item status. */
    private int ls;

    /** Item status. */
    private int ap;

    /** Item status. */
    private int mrpen;

    /** Item status. */
    private int mrpenRatio;

    /** Item status. */
    private int cdr;

    /** Item status. */
    private int sv;

    /** Item status. */
    private int health;

    /** Item status. */
    private int hreg;

    /** Item status. */
    private int mreg;

    /** Item status. */
    private int ar;

    /** Item status. */
    private int mr;

    /** Item status. */
    private int ms;

    /** Item status. */
    private int msRatio;

    /**
     * @param name
     */
    Item(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Update this item.
     * </p>
     * 
     * @param patch
     */
    Item copy() {
        Item item = new Item(name);
        item.cost = cost;
        item.ad = ad;
        item.as = as;
        item.critical = critical;
        item.arpen = arpen;
        item.arpenRatio = arpenRatio;
        item.ls = ls;
        item.ap = ap;
        item.mrpen = mrpen;
        item.mrpenRatio = mrpenRatio;
        item.cdr = cdr;
        item.sv = sv;
        item.health = health;
        item.hreg = hreg;
        item.mreg = mreg;
        item.ar = ar;
        item.mr = mr;
        item.ms = ms;
        item.msRatio = msRatio;

        return item;
    }

    /**
     * Get the cost property of this {@link Item}.
     * 
     * @return The cost property.
     */
    public int cost() {
        return cost;
    }

    /**
     * Set the cost property of this {@link Item}.
     * 
     * @param cost The cost value to set.
     */
    Item cost(int cost) {
        this.cost = cost;

        // Chainable API
        return this;
    }

    /**
     * Get the ad property of this {@link Item}.
     * 
     * @return The ad property.
     */
    public int ad() {
        return ad;
    }

    /**
     * Set the ad property of this {@link Item}.
     * 
     * @param ad The ad value to set.
     */
    Item ad(int ad) {
        this.ad = ad;

        // Chainable API
        return this;
    }

    /**
     * Get the as property of this {@link Item}.
     * 
     * @return The as property.
     */
    public int as() {
        return as;
    }

    /**
     * Set the as property of this {@link Item}.
     * 
     * @param as The as value to set.
     */
    Item as(int as) {
        this.as = as;

        // Chainable API
        return this;
    }

    /**
     * Get the critical property of this {@link Item}.
     * 
     * @return The critical property.
     */
    public int critical() {
        return critical;
    }

    /**
     * Set the critical property of this {@link Item}.
     * 
     * @param critical The critical value to set.
     */
    Item critical(int critical) {
        this.critical = critical;

        // Chainable API
        return this;
    }

    /**
     * Get the arpen property of this {@link Item}.
     * 
     * @return The arpen property.
     */
    public int arpen() {
        return arpen;
    }

    /**
     * Set the arpen property of this {@link Item}.
     * 
     * @param arpen The arpen value to set.
     */
    Item arpen(int arpen) {
        this.arpen = arpen;

        // Chainable API
        return this;
    }

    /**
     * Get the arpenRatio property of this {@link Item}.
     * 
     * @return The arpenRatio property.
     */
    public int arpenRatio() {
        return arpenRatio;
    }

    /**
     * Set the arpenRatio property of this {@link Item}.
     * 
     * @param arpenRatio The arpenRatio value to set.
     */
    Item arpenRatio(int arpenRatio) {
        this.arpenRatio = arpenRatio;

        // Chainable API
        return this;
    }

    /**
     * Get the ls property of this {@link Item}.
     * 
     * @return The ls property.
     */
    public int ls() {
        return ls;
    }

    /**
     * Set the ls property of this {@link Item}.
     * 
     * @param ls The ls value to set.
     */
    Item ls(int ls) {
        this.ls = ls;

        // Chainable API
        return this;
    }

    /**
     * Get the ap property of this {@link Item}.
     * 
     * @return The ap property.
     */
    public int ap() {
        return ap;
    }

    /**
     * Set the ap property of this {@link Item}.
     * 
     * @param ap The ap value to set.
     */
    Item ap(int ap) {
        this.ap = ap;

        // Chainable API
        return this;
    }

    /**
     * Get the mrpen property of this {@link Item}.
     * 
     * @return The mrpen property.
     */
    public int mrpen() {
        return mrpen;
    }

    /**
     * Set the mrpen property of this {@link Item}.
     * 
     * @param mrpen The mrpen value to set.
     */
    Item mrpen(int mrpen) {
        this.mrpen = mrpen;

        // Chainable API
        return this;
    }

    /**
     * Get the mrpenRatio property of this {@link Item}.
     * 
     * @return The mrpenRatio property.
     */
    public int mrpenRatio() {
        return mrpenRatio;
    }

    /**
     * Set the mrpenRatio property of this {@link Item}.
     * 
     * @param mrpenRatio The mrpenRatio value to set.
     */
    Item mrpenRatio(int mrpenRatio) {
        this.mrpenRatio = mrpenRatio;

        // Chainable API
        return this;
    }

    /**
     * Get the cdr property of this {@link Item}.
     * 
     * @return The cdr property.
     */
    public int cdr() {
        return cdr;
    }

    /**
     * Set the cdr property of this {@link Item}.
     * 
     * @param cdr The cdr value to set.
     */
    Item cdr(int cdr) {
        this.cdr = cdr;

        // Chainable API
        return this;
    }

    /**
     * Get the sv property of this {@link Item}.
     * 
     * @return The sv property.
     */
    public int sv() {
        return sv;
    }

    /**
     * Set the sv property of this {@link Item}.
     * 
     * @param sv The sv value to set.
     */
    Item sv(int sv) {
        this.sv = sv;

        // Chainable API
        return this;
    }

    /**
     * Get the health property of this {@link Item}.
     * 
     * @return The health property.
     */
    public int health() {
        return health;
    }

    /**
     * Set the health property of this {@link Item}.
     * 
     * @param health The health value to set.
     */
    Item health(int health) {
        this.health = health;

        // Chainable API
        return this;
    }

    /**
     * Get the hreg property of this {@link Item}.
     * 
     * @return The hreg property.
     */
    public int hreg() {
        return hreg;
    }

    /**
     * Set the hreg property of this {@link Item}.
     * 
     * @param hreg The hreg value to set.
     */
    Item hreg(int hreg) {
        this.hreg = hreg;

        // Chainable API
        return this;
    }

    /**
     * Get the mreg property of this {@link Item}.
     * 
     * @return The mreg property.
     */
    public int mreg() {
        return mreg;
    }

    /**
     * Set the mreg property of this {@link Item}.
     * 
     * @param mreg The mreg value to set.
     */
    Item mreg(int mreg) {
        this.mreg = mreg;

        // Chainable API
        return this;
    }

    /**
     * Get the ar property of this {@link Item}.
     * 
     * @return The ar property.
     */
    public int ar() {
        return ar;
    }

    /**
     * Set the ar property of this {@link Item}.
     * 
     * @param ar The ar value to set.
     */
    Item ar(int ar) {
        this.ar = ar;

        // Chainable API
        return this;
    }

    /**
     * Get the mr property of this {@link Item}.
     * 
     * @return The mr property.
     */
    public int mr() {
        return mr;
    }

    /**
     * Set the mr property of this {@link Item}.
     * 
     * @param mr The mr value to set.
     */
    Item mr(int mr) {
        this.mr = mr;

        // Chainable API
        return this;
    }

    /**
     * Get the ms property of this {@link Item}.
     * 
     * @return The ms property.
     */
    public int ms() {
        return ms;
    }

    /**
     * Set the ms property of this {@link Item}.
     * 
     * @param ms The ms value to set.
     */
    Item ms(int ms) {
        this.ms = ms;

        // Chainable API
        return this;
    }

    /**
     * Get the msRatio property of this {@link Item}.
     * 
     * @return The msRatio property.
     */
    public int msRatio() {
        return msRatio;
    }

    /**
     * Set the msRatio property of this {@link Item}.
     * 
     * @param msRatio The msRatio value to set.
     */
    Item msRatio(int msRatio) {
        this.msRatio = msRatio;

        // Chainable API
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
    public static List<Item> getAll() {
        return items;
    }
}
