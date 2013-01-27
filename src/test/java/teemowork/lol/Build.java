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

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/01/27 1:45:58
 */
public class Build {

    /** The current champion. */
    private Champion champion;

    /** The current level. */
    private int level;

    /** The version to apply. */
    private Version version;

    /** The items. */
    private final List<Item> items = new ArrayList(6);

    /**
     * Get the version property of this {@link Build}.
     * 
     * @return The version property.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Set the version property of this {@link Build}.
     * 
     * @param version The version value to set.
     */
    public void setVersion(Version version) {
        this.version = version;
    }

    /**
     * <p>
     * Calcurate status value.
     * </p>
     * 
     * @param status
     * @return
     */
    public StatusValue get(Status status) {
        switch (status) {
        case MSRatio:
        case ARPen:
        case ARPenRatio:
        case MRPen:
        case MRPerLv:
        case Energy:
        case Ereg:
            return new StatusValue(0, 0, status.precision);

            // case AS:
            // double baseAS = champion.improvement.get(AS, patch);
            // double levelAS = champion.improvement.get(ASPerLv, patch) * (level - 1);
            // return new Computed(baseAS * (1 + levelAS / 100), baseAS * (1 + (levelAS +
            // sum(ASRatio)) / 100), status.precision);

        default:
            Status per = Status.valueOf(status.name() + "PerLv");
            Status ratio = Status.valueOf(status.name() + "Ratio");

            double base = base(status);
            double computed = (base + sum(status) + sum(per) * level) * (1 + sum(ratio) / 100);

            return new StatusValue(base, computed, status.precision);
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
            return 0;

        default:
            return 0;
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

            sum += item.get(status, version);
        }

        return sum;
    }

    private List<Ability> collectAbility() {
        List<Ability> abilities = new ArrayList();

        for (Item item : items) {
            for (Ability ability : item.getAbilities()) {
                System.out.println(abilities);
            }
        }

        return abilities;
    }

    /**
     * <p>
     * Set item to this build at the specified position..
     * </p>
     * 
     * @param index
     * @param item
     */
    public Build set(int index, Item item) {
        items.set(index, item);

        return this;
    }

    /**
     * @version 2013/01/25 13:42:02
     */
    public static class StatusValue {

        /** The champion base value. */
        public final double base;

        /** The computed value. */
        public final double calcurated;

        /** The increased value. */
        public final double increased;

        /**
         * @param base A base value.
         * @param calcurated A computed value.
         */
        private StatusValue(double base, double calcurated, int precision) {
            this.base = round(base, precision);
            this.calcurated = round(calcurated, precision);
            this.increased = round(calcurated - base, precision);
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
            return String.valueOf(calcurated);
        }

        /**
         * <p>
         * Retrieve base value as String expression.
         * </p>
         * 
         * @return A base value.
         */
        public String calcurated() {
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
