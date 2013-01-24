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

import static java.lang.Math.*;
import static teemowork.model.Status.*;

import java.util.List;

import js.bind.Notifiable;
import js.util.ArrayList;

/**
 * @version 2013/01/16 9:18:22
 */
public class Build extends Notifiable {

    /** The selected champion. */
    public final Champion champion;

    /** The current champion status. */
    private final ChampionStatus status;

    /** The level. */
    private int level = 1;

    /** The item list. */
    private Item[] items = new Item[6];

    /** The skill order. */
    private int[] skills = new int[18];

    /** The mastery. */
    private MasterySet mastery;

    /** The rune. */
    private RuneSet rune;

    /**
     * @param champion
     */
    public Build(Champion champion) {
        this.champion = champion;
        this.status = champion.status;
    }

    /**
     * Get the level property of this {@link Build}.
     * 
     * @return The level property.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the level property of this {@link Build}.
     * 
     * @param level The level value to set.
     */
    public void setLevel(int level) {
        if (0 < level && level < 19) {
            this.level = level;

            fire();
        }
    }

    /**
     * <p>
     * Compute current health.
     * </p>
     * 
     * @return
     */
    public double getHealth() {
        return round(base(Health, HealthPerLv) + getHealthIncreased());
    }

    /**
     * <p>
     * Calcurate increased health.
     * </p>
     * 
     * @return A result.
     */
    public double getHealthIncreased() {
        return round(sum(Health) + sum(HealthPerLv));
    }

    /**
     * <p>
     * Compute current mana.
     * </p>
     * 
     * @return
     */
    public double getMana() {
        return round(base(Mana, ManaPerLv) + getManaIncreased());
    }

    /**
     * <p>
     * Calcurate increased mana.
     * </p>
     * 
     * @return A result.
     */
    public double getManaIncreased() {
        return round(sum(Mana) + sum(ManaPerLv));
    }

    /**
     * <p>
     * Compute current ad.
     * </p>
     * 
     * @return
     */
    public double getAd() {
        return round(base(AD, ADPerLv) + getAdIncreased());
    }

    /**
     * <p>
     * Calcurate increased attack damage.
     * </p>
     * 
     * @return A result.
     */
    public double getAdIncreased() {
        return round(sum(AD) + sum(ADPerLv));
    }

    /**
     * <p>
     * Compute current as.
     * </p>
     * 
     * @return
     */
    public double getAS() {
        return round4(status.get(AS) * (1 + (status.get(ASPerLv) * (level - 1) + getASIncreased()) / 100));
    }

    /**
     * <p>
     * Calcurate increased attack speed.
     * </p>
     * 
     * @return A result.
     */
    public double getASIncreased() {
        return sum(AS) + sum(ASPerLv) * level;
    }

    /**
     * <p>
     * Compute current movemnet speed.
     * </p>
     * 
     * @return
     */
    public double getMS() {
        return round(base(MS) + getMSIncreased());
    }

    /**
     * <p>
     * Calcurate increased movement speed.
     * </p>
     * 
     * @return A result.
     */
    public double getMSIncreased() {
        return round(sum(MS) + sum(MSRatio));
    }

    /**
     * <p>
     * Round decimel.
     * </p>
     * 
     * @param value
     * @return
     */
    private double round4(double value) {
        value *= 1000;
        value = Math.round(value);
        return value / 1000;
    }

    /**
     * <p>
     * Calcurate champion base status.
     * </p>
     * 
     * @param status
     * @return
     */
    private double base(Status base) {
        return this.status.get(base);
    }

    /**
     * <p>
     * Calcurate champion base status.
     * </p>
     * 
     * @param status
     * @return
     */
    private double base(Status base, Status per) {
        return this.status.get(base) + this.status.get(per) * level;
    }

    /**
     * <p>
     * Compute sum of the specified improvements.
     * </p>
     * 
     * @param improvementType A target type.
     * @return A sum value.
     */
    private double sum(Status status) {
        double sum = 0;

        return sum;
    }

    /**
     * <p>
     * Collect improvements.
     * </p>
     * 
     * @param type
     * @return
     */
    private <T> List<T> collect() {
        List<T> items = new ArrayList();

        // if (improvementType.isAssignableFrom(status.getClass())) {
        // items.add((T) status);
        // }
        return items;
    }
}
