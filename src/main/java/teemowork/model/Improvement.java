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
public class Improvement<T extends Improvement<T>> implements Improvable {

    /** The history version. */
    private final Patch patch;

    /** The history chain. */
    private final Improvement previous;

    /** The base status. */
    private int cost;

    /** The initial status. */
    private double health;

    /** The per level status. */
    private double healthPerLevel;

    /** The initial status. */
    private double hreg;

    /** The per level status. */
    private double hregPerLv;

    /** The initial status. */
    private double mana;

    /** The per level status. */
    private double manaPerLv;

    /** The initial status. */
    private double mreg;

    /** The per level status. */
    private double mregPerLv;

    /** The initial status. */
    private double ad;

    /** The per level status. */
    private double adPerLv;

    /** The initial status. */
    private double as;

    /** The per level status. */
    private double asPerLv;

    /** The initial status. */
    private double ar;

    /** The per level status. */
    private double arPerLv;

    /** The initial status. */
    private double mr;

    /** The per level status. */
    private double mrPerLv;

    /** The initial status. */
    private int range;

    /** The per level status. */
    private int rangePerLv;

    /** The initial status. */
    private double ms;

    /** The initial status. */
    private double msRatio;

    /** The initial status. */
    private int energy;

    /** The initial status. */
    private int ereg;

    /** The initial status. */
    private double ap;

    /** The per level status. */
    private double apPerLv;

    /** The initial status. */
    private double cdr;

    /** The per level status. */
    private double cdrPerLv;

    /** The initial status. */
    private double sv;

    /** The per level status. */
    private double svPerLv;

    /** The initial status. */
    private double ls;

    /** The per level status. */
    private double lsPerLv;

    /** The initial status. */
    private double arpen;

    /** The per level status. */
    private double arpenRatio;

    /** The initial status. */
    private double mrpen;

    /** The per level status. */
    private double mrpenRatio;

    /** The initial status. */
    private double critical;

    /** The per level status. */
    private double criticalPerLv;

    /**
     * @param patch
     * @param previous
     */
    protected Improvement(Patch patch, Improvement previous) {
        this.patch = patch;
        this.previous = previous;
    }

    /**
     * {@inheritDoc}
     */
    public double get(Status status, Patch patch) {
        if (this.patch.number > patch.number) {
            return previous.get(status, patch);
        }

        double value;

        switch (status) {
        case AD:
            value = ad;
            break;

        case ADPerLv:
            value = adPerLv;
            break;

        case AS:
            value = as;
            break;

        case ASPerLv:
            value = asPerLv;
            break;

        case Health:
            value = health;
            break;

        case HealthPerLv:
            value = healthPerLevel;
            break;

        case Hreg:
            value = hreg;
            break;

        case HregPerLv:
            value = hregPerLv;
            break;

        case AP:
            value = ap;
            break;

        case APPerLv:
            value = apPerLv;
            break;

        case AR:
            value = ar;
            break;

        case ARPerLv:
            value = arPerLv;
            break;

        case ARPen:
            value = arpen;
            break;

        case ARPenRatio:
            value = arpenRatio;
            break;

        case CDR:
            value = cdr;
            break;

        case CDRPerLv:
            value = cdrPerLv;
            break;

        case Critical:
            value = critical;
            break;

        case CriticalPerLv:
            value = criticalPerLv;
            break;

        case LS:
            value = ls;
            break;

        case LSPerLv:
            value = lsPerLv;
            break;

        case MR:
            value = mr;
            break;

        case MRPerLv:
            value = mrPerLv;
            break;

        case MRPen:
            value = mrpen;
            break;

        case MRPenRatio:
            value = mrpenRatio;
            break;

        case MS:
            value = ms;
            break;

        case MSRatio:
            value = msRatio;
            break;

        case Mana:
            value = mana;
            break;

        case ManaPerLv:
            value = manaPerLv;
            break;

        case Mreg:
            value = mreg;
            break;

        case MregPerLv:
            value = mregPerLv;
            break;

        case SV:
            value = sv;
            break;

        case SVPerLv:
            value = svPerLv;
            break;

        case Range:
            value = range;
            break;

        case RangePerLv:
            value = rangePerLv;
            break;

        case Energy:
            value = energy;
            break;

        case Ereg:
            value = ereg;
            break;

        default:
            value = 0;
            break;
        }

        if (value == 0 && previous != null) {
            return previous.get(status, patch);
        }
        return value;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T cost(int base) {
        this.cost = base;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T health(double base) {
        return health(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T health(double initial, double per) {
        this.health = initial;
        this.healthPerLevel = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T hreg(double base) {
        return hreg(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T hreg(double initial, double per) {
        this.hreg = initial;
        this.hregPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T mana(double base) {
        return mana(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mana(double initial, double per) {
        this.mana = initial;
        this.manaPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T mreg(int base) {
        return mreg(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mreg(double initial, double per) {
        this.mreg = initial;
        this.mregPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T ad(int base) {
        return ad(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T ad(double initial, double per) {
        this.ad = initial;
        this.adPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T as(int base) {
        return as(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T as(double initial, double per) {
        this.as = initial;
        this.asPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T ar(int base) {
        return ar(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T ar(double initial, double per) {
        this.ar = initial;
        this.arPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T mr(int base) {
        return mr(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param initial The initial value to set.
     * @param per The per level value to set.
     */
    T mr(double initial, double per) {
        this.mr = initial;
        this.mrPerLv = per;

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
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T ms(double base) {
        return ms(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param ratio The per level value to set.
     */
    T ms(double base, double ratio) {
        this.ms = base;
        this.msRatio = ratio;

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

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T ap(double base) {
        return ap(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param per The per level value to set.
     */
    T ap(double base, double per) {
        this.ap = base;
        this.apPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T cdr(double base) {
        return cdr(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param per The per level value to set.
     */
    T cdr(double base, double per) {
        this.cdr = base;
        this.cdrPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T sv(double base) {
        return sv(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param per The per level value to set.
     */
    T sv(double base, double per) {
        this.sv = base;
        this.svPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T critical(double base) {
        return critical(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param per The per level value to set.
     */
    T critical(double base, double per) {
        this.critical = base;
        this.criticalPerLv = per;

        return (T) this;
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     */
    T ls(double base) {
        return ls(base, 0);
    }

    /**
     * Set the improvement entry of this object.
     * 
     * @param base The base value to set.
     * @param per The per level value to set.
     */
    T ls(double base, double per) {
        this.ls = base;
        this.lsPerLv = per;

        return (T) this;
    }

    T build(Item... items) {
        return (T) this;
    }
}
