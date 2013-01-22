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

import teemowork.model.improvement.AttackSpeed;

/**
 * @version 2012/12/11 11:50:04
 */
public class ChampionStatus implements AttackSpeed {

    /** The history version. */
    private final Patch patch;

    /** The history chain. */
    private final ChampionStatus previous;

    /** The initial status. */
    private int healthInitial;

    /** The per level status. */
    private int healthPerLevel;

    /** The initial status. */
    private double hregInitial;

    /** The per level status. */
    private double hregPerLvel;

    /** The initial status. */
    private int manaInitial;

    /** The per level status. */
    private double manaPerLvel;

    /** The initial status. */
    private double mregInitial;

    /** The per level status. */
    private double mregPerLvel;

    /** The initial status. */
    private double adInitial;

    /** The per level status. */
    private double adPerLvel;

    /** The initial status. */
    private double asInitial;

    /** The per level status. */
    private double asPerLvel;

    /** The initial status. */
    private double arInitial;

    /** The per level status. */
    private double arPerLvel;

    /** The initial status. */
    private double mrInitial;

    /** The per level status. */
    private double mrPerLvel;

    /** The initial status. */
    private int range;

    /** The initial status. */
    private int ms;

    /** The initial status. */
    private int energy;

    /** The initial status. */
    private int ereg;

    /**
     * @param patch
     */
    ChampionStatus(Patch patch, ChampionStatus previous) {
        this.patch = patch;
        this.previous = previous;

        // copy status
        if (previous != null) {
            this.healthInitial = previous.healthInitial;
            this.healthPerLevel = previous.healthPerLevel;
        }
    }

    /**
     * Get the healthInitial property of this {@link ChampionStatus}.
     * 
     * @return The healthInitial property.
     */
    public int healthInitial() {
        return healthInitial;
    }

    /**
     * Get the healthPerLevel property of this {@link ChampionStatus}.
     * 
     * @return The healthPerLevel property.
     */
    public int healthPerLevel() {
        return healthPerLevel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus health(int initial, int per) {
        this.healthInitial = initial;
        this.healthPerLevel = per;

        return this;
    }

    /**
     * Get the hregInitial property of this {@link ChampionStatus}.
     * 
     * @return The hregInitial property.
     */
    public double getHregInitial() {
        return hregInitial;
    }

    /**
     * Get the hregPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The hregPerLvel property.
     */
    public double getHregPerLvel() {
        return hregPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus hreg(double initial, double per) {
        this.hregInitial = initial;
        this.hregPerLvel = per;

        return this;
    }

    /**
     * Get the manaInitial property of this {@link ChampionStatus}.
     * 
     * @return The manaInitial property.
     */
    public int getManaInitial() {
        return manaInitial;
    }

    /**
     * Get the manaPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The manaPerLvel property.
     */
    public double getManaPerLvel() {
        return manaPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus mana(int initial, double per) {
        this.manaInitial = initial;
        this.manaPerLvel = per;

        return this;
    }

    /**
     * Get the mregInitial property of this {@link ChampionStatus}.
     * 
     * @return The mregInitial property.
     */
    public double getMregInitial() {
        return mregInitial;
    }

    /**
     * Get the mregPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The mregPerLvel property.
     */
    public double getMregPerLvel() {
        return mregPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus mreg(double initial, double per) {
        this.mregInitial = initial;
        this.mregPerLvel = per;

        return this;
    }

    /**
     * Get the adInitial property of this {@link ChampionStatus}.
     * 
     * @return The adInitial property.
     */
    public double getAdInitial() {
        return adInitial;
    }

    /**
     * Get the adPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The adPerLvel property.
     */
    public double getAdPerLvel() {
        return adPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus ad(double initial, double per) {
        this.adInitial = initial;
        this.adPerLvel = per;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getASBase() {
        return asInitial;
    }

    /**
     * Get the asInitial property of this {@link ChampionStatus}.
     * 
     * @return The asInitial property.
     */
    public double getAsBase() {
        return asInitial;
    }

    /**
     * Get the asPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The asPerLvel property.
     */
    public double getAsPerLvel() {
        return asPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus as(double initial, double per) {
        this.asInitial = initial;
        this.asPerLvel = per;

        return this;
    }

    /**
     * Get the arInitial property of this {@link ChampionStatus}.
     * 
     * @return The arInitial property.
     */
    public double getArInitial() {
        return arInitial;
    }

    /**
     * Get the arPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The arPerLvel property.
     */
    public double getArPerLvel() {
        return arPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus ar(double initial, double per) {
        this.arInitial = initial;
        this.arPerLvel = per;

        return this;
    }

    /**
     * Get the mrInitial property of this {@link ChampionStatus}.
     * 
     * @return The mrInitial property.
     */
    public double getMrInitial() {
        return mrInitial;
    }

    /**
     * Get the mrPerLvel property of this {@link ChampionStatus}.
     * 
     * @return The mrPerLvel property.
     */
    public double getMrPerLvel() {
        return mrPerLvel;
    }

    /**
     * Set the Champion status of this {@link ChampionStatus}.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    ChampionStatus mr(double initial, double per) {
        this.mrInitial = initial;
        this.mrPerLvel = per;

        return this;
    }

    /**
     * Get the range property of this {@link ChampionStatus}.
     * 
     * @return The range property.
     */
    public int getRange() {
        return range;
    }

    /**
     * Set the range property of this {@link ChampionStatus}.
     * 
     * @param range The range value to set.
     */
    ChampionStatus range(int range) {
        this.range = range;

        return this;
    }

    /**
     * Get the ms property of this {@link ChampionStatus}.
     * 
     * @return The ms property.
     */
    public int getMs() {
        return ms;
    }

    /**
     * Set the ms property of this {@link ChampionStatus}.
     * 
     * @param ms The ms value to set.
     */
    ChampionStatus ms(int ms) {
        this.ms = ms;

        return this;
    }

    /**
     * Get the energy property of this {@link ChampionStatus}.
     * 
     * @return The energy property.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Set the energy property of this {@link ChampionStatus}.
     * 
     * @param energy The energy value to set.
     */
    ChampionStatus energy(int energy) {
        this.energy = energy;

        return this;
    }

    /**
     * Get the ereg property of this {@link ChampionStatus}.
     * 
     * @return The ereg property.
     */
    public int getEreg() {
        return ereg;
    }

    /**
     * Set the ereg property of this {@link ChampionStatus}.
     * 
     * @param ereg The ereg value to set.
     */
    ChampionStatus ereg(int ereg) {
        this.ereg = ereg;

        return this;
    }

    /**
     * <p>
     * Calcurate status.
     * </p>
     * 
     * @param level
     * @return
     */
    public double getHealth(int level) {
        return healthInitial + healthPerLevel * level;
    }

    /**
     * <p>
     * Calcurate status.
     * </p>
     * 
     * @param level
     * @return
     */
    public double getMana(int level) {
        return manaInitial + manaPerLvel * level;
    }
}
