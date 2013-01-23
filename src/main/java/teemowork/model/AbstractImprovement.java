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

/**
 * @version 2013/01/24 1:19:42
 */
public abstract class AbstractImprovement<T extends AbstractImprovement<T>> {

    /** The initial status. */
    private int health;

    /** The per level status. */
    private int healthPerLevel;

    /** The initial status. */
    private double hreg;

    /** The per level status. */
    private double hregPerLvel;

    /** The initial status. */
    private int mana;

    /** The per level status. */
    private double manaPerLvel;

    /** The initial status. */
    private double mreg;

    /** The per level status. */
    private double mregPerLvel;

    /** The initial status. */
    private double ad;

    /** The per level status. */
    private double adPerLvel;

    /** The initial status. */
    private double as;

    /** The per level status. */
    private double asPerLvel;

    /** The initial status. */
    private double ar;

    /** The per level status. */
    private double arPerLvel;

    /** The initial status. */
    private double mr;

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
     * <p>
     * Calcurate value.
     * </p>
     * 
     * @param entry
     * @return
     */
    public double calcurate(ImprovementEntry entry) {
        switch (entry) {
        case AD:
            return ad;

        case ADPerLv:
            return adPerLvel;

        case AS:
            return as;

        case ASPerLv:
            return asPerLvel;

        case Health:
            return health;

        case HealthPerLv:
            return healthPerLevel;

        case Hreg:
            return hreg;

        case HregPerLv:
            return hregPerLvel;
        case AP:
            return ap;

        case APPerLv:
            return ap;

        case AR:
            return ap;

        case ARPen:
            return ap;

        case ARPenPercentage:
            return ap;

        case ARPerLv:
            return ap;

        case CDR:
            return ap;

        case CDRPerLv:
            return ap;

        case Critical:
            return ap;

        case CriticalPerLv:
            return ap;

        case LS:
            return ap;

        case LSPerLv:
            return ap;

        case MR:
            return ap;

        case MRPen:
            return ap;

        case MRPenPercentage:
            return ap;

        case MRPerLv:
            return ap;

        case MS:
            return ap;

        case MSPercentage:
            return ap;

        case Mana:
            return ap;

        case ManaPerLv:
            return ap;

        case Mreg:
            return ap;

        case MregPerLv:
            return ap;

        case SV:
            return ap;

        case SVPerLv:
            return ap;

        }
        return 0;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T health(int initial, int per) {
        this.health = initial;
        this.healthPerLevel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T hreg(double initial, double per) {
        this.hreg = initial;
        this.hregPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mana(int initial, double per) {
        this.mana = initial;
        this.manaPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mreg(double initial, double per) {
        this.mreg = initial;
        this.mregPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T ad(double initial, double per) {
        this.ad = initial;
        this.adPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T as(double initial, double per) {
        this.as = initial;
        this.asPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T ar(double initial, double per) {
        this.ar = initial;
        this.arPerLvel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mr(double initial, double per) {
        this.mr = initial;
        this.mrPerLvel = per;

        return (T) this;
    }

    /**
     * Set the range property of this object.
     * 
     * @param range The range value to set.
     */
    T range(int range) {
        this.range = range;

        return (T) this;
    }

    /**
     * Set the ms property of this object.
     * 
     * @param ms The ms value to set.
     */
    T ms(int ms) {
        this.ms = ms;

        return (T) this;
    }

    /**
     * Set the energy property of this object.
     * 
     * @param energy The energy value to set.
     */
    T energy(int energy) {
        this.energy = energy;

        return (T) this;
    }

    /**
     * Set the ereg property of this object.
     * 
     * @param ereg The ereg value to set.
     */
    T ereg(int ereg) {
        this.ereg = ereg;

        return (T) this;
    }
}
