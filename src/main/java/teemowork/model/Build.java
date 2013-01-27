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

import java.util.List;

import js.bind.Notifiable;
import js.util.ArrayList;

/**
 * @version 2013/01/25 14:31:39
 */
public class Build extends Notifiable {

    /** The selected champion. */
    public final Champion champion;

    /** The version. */
    private Patch patch = Patch.Latest;

    /** The level. */
    private int level = 1;

    /** The item list. */
    private List<Item> items = new ArrayList();

    /** The skill order. */
    private int[] skills = new int[18];

    /** The mastery. */
    private MasterySet mastery;

    /** The rune list. */
    private List<Rune> marks = new ArrayList();

    /** The rune list. */
    private List<Rune> glyphs = new ArrayList();

    /** The rune list. */
    private List<Rune> seals = new ArrayList();

    /** The rune list. */
    private List<Rune> quintessences = new ArrayList();

    /**
     * @param champion
     */
    public Build(Champion champion) {
        this.champion = champion;

        items.add(Item.ZekesHerald);
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
     * Get the patch property of this {@link Build}.
     * 
     * @return The patch property.
     */
    public Patch getPatch() {
        return patch;
    }

    /**
     * Set the patch property of this {@link Build}.
     * 
     * @param patch The patch value to set.
     */
    public void setPatch(Patch patch) {
        if (patch != null) {
            this.patch = patch;

            fire();
        }
    }

    /**
     * <p>
     * Compute build status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    public Computed get(Status status) {
        switch (status) {
        case MSRatio:
        case ARPen:
        case ARPenRatio:
        case MRPen:
        case MRPerLv:
        case Energy:
        case Ereg:
            return new Computed(0, 0, status.precision);

        case AS:
            double baseAS = champion.improvement.get(AS, patch);
            double levelAS = champion.improvement.get(ASPerLv, patch) * (level - 1);
            return new Computed(baseAS * (1 + levelAS / 100), baseAS * (1 + (levelAS + sum(ASRatio)) / 100), status.precision);

        default:
            Status per = Status.valueOf(status.name() + "PerLv");
            Status ratio = Status.valueOf(status.name() + "Ratio");

            double base = base(status);
            double computed = (base + sum(status) + sum(per) * level) * (1 + sum(ratio) / 100);

            return new Computed(base, computed, status.precision);
        }
    }

    /**
     * <p>
     * Compute champion base status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    private double base(Status status) {
        switch (status) {
        case MS:
        case MSRatio:
        case ARPen:
        case ARPenRatio:
        case MRPen:
        case MRPenRatio:
        case Energy:
        case Ereg:
            return champion.improvement.get(status, patch);

        default:
            Status per = Status.valueOf(status.name() + "PerLv");
            return champion.improvement.get(status, patch) + champion.improvement.get(per, patch) * level;
        }
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

        for (Item item : items) {
            sum += item.improvement.get(status, patch);
        }

        for (Rune rune : marks) {
            sum += rune.improvement.get(status, patch);
        }

        for (Rune rune : seals) {
            sum += rune.improvement.get(status, patch);
        }

        for (Rune rune : glyphs) {
            sum += rune.improvement.get(status, patch);
        }

        for (Rune rune : quintessences) {
            sum += rune.improvement.get(status, patch);
        }

        return sum;
    }

    /**
     * @version 2013/01/25 13:42:02
     */
    public static class Computed {

        /** The champion base value. */
        public final double base;

        /** The computed value. */
        public final double value;

        /** The increased value. */
        public final double increased;

        /**
         * @param base A base value.
         * @param value A computed value.
         */
        private Computed(double base, double value, int precision) {
            this.base = round(base, precision);
            this.value = round(value, precision);
            this.increased = round(value - base, precision);
        }

        /**
         * <p>
         * Round decimel.
         * </p>
         * 
         * @param value
         * @param precision
         * @return
         */
        private double round(double value, int precision) {
            int round = 1;

            for (int i = 0; i < precision; i++) {
                round *= 10;
            }

            value *= round;
            value = Math.round(value);
            return value / round;
        }

        /**
         * <p>
         * Retrieve computed value as String expression.
         * </p>
         * 
         * @return A computed value.
         */
        public String value() {
            return String.valueOf(value);
        }

        /**
         * <p>
         * Retrieve base value as String expression.
         * </p>
         * 
         * @return A base value.
         */
        public String base() {
            return String.valueOf(base);
        }

        /**
         * <p>
         * Retrieve increased value as String expression.
         * </p>
         * 
         * @return A increased value.
         */
        public String increased() {
            return String.valueOf(increased);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value();
        }
    }
}
