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

import java.util.List;

import js.bind.Notifiable;
import js.util.ArrayList;
import teemowork.model.improvement.Improvement;

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
        return status.healthInitial() + status.healthPerLevel() * level;
    }

    /**
     * <p>
     * Compute current mana.
     * </p>
     * 
     * @return
     */
    public double getMana() {
        return status.getManaInitial() + status.getManaPerLvel() * level;
    }

    /**
     * <p>
     * Compute current ad.
     * </p>
     * 
     * @return
     */
    public double getAd() {
        return status.getAdInitial() + status.getAdPerLvel() * level;
    }

    /**
     * <p>
     * Compute current as.
     * </p>
     * 
     * @return
     */
    public double getAS() {
        return status.getAsBase() + status.getAsPerLvel() * level;
    }

    /**
     * <p>
     * Compute current as.
     * </p>
     * 
     * @return
     */
    public double getASPerLv() {
        return status.getAdPerLvel();
    }

    /**
     * <p>
     * Compute sum of the specified improvements.
     * </p>
     * 
     * @param improvementType A target type.
     * @return A sum value.
     */
    private <T extends Improvement> double sum(Class<T> improvementType) {
        double sum = 0;

        for (T item : collect(improvementType)) {

        }
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
    private <T> List<T> collect(Class<T> improvementType) {
        List<T> items = new ArrayList();

        if (improvementType.isAssignableFrom(champion.getClass())) {
            items.add((T) champion);
        }
        return items;
    }
}
