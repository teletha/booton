/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import teemowork.model.Skill;
import teemowork.model.StatusCalculator;

/**
 * @version 2013/02/12 10:33:59
 */
public abstract class VariableResolver {

    /**
     * <p>
     * Compute value by skill level.
     * </p>
     * 
     * @param level A target skill level to compute.
     * @return A computed value.
     */
    public abstract double compute(int level);

    /**
     * <p>
     * Retrieve the size of associated variable.
     * </p>
     * 
     * @return
     */
    public abstract int estimateSize();

    /**
     * <p>
     * Check whether this variable relies on skill level or not.
     * </p>
     * 
     * @return
     */
    public boolean isSkillLevelBased() {
        return true;
    }

    /**
     * <p>
     * Compute skill level.
     * </p>
     * 
     * @return
     */
    public int convertLevel(StatusCalculator calculator) {
        return 0;
    }

    /**
     * @version 2013/02/12 13:10:53
     */
    private static abstract class PerLevel extends VariableResolver {

        /** The level pattern. */
        private final int[] levels;

        /** The values. */
        private final double base;

        /** The values. */
        private final double diff;

        /**
         * @param levels
         * @param base
         * @param diff
         */
        private PerLevel(int[] levels, double base, double diff) {
            this.levels = levels;
            this.base = base;
            this.diff = diff;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return levels.length;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return base + diff * (skillLevel - 1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            int level = calculator.getLevel();

            for (int i = 0; i < levels.length; i++) {
                if (level < levels[i]) {
                    return i;
                }
            }
            return levels.length;
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per6Level extends PerLevel {

        /**
         * @param values
         */
        public Per6Level(double base, double diff) {
            super(new int[] {1, 7, 13}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per6LevelForVi extends PerLevel {

        /**
         * @param values
         */
        public Per6LevelForVi(double base, double diff) {
            super(new int[] {1, 7, 12}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per6LevelForZed extends PerLevel {

        /**
         * @param values
         */
        public Per6LevelForZed(double base, double diff) {
            super(new int[] {1, 7, 17}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per5Level extends PerLevel {

        /**
         * @param values
         */
        public Per5Level(double base, double diff) {
            super(new int[] {1, 6, 11, 16}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per5LevelForHeimer extends PerLevel {

        /**
         * @param values
         */
        public Per5LevelForHeimer(double base, double diff) {
            super(new int[] {1, 6, 11, 15}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per4Level extends PerLevel {

        /**
         * @param values
         */
        public Per4Level(double base, double diff) {
            super(new int[] {1, 5, 8, 12, 15}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per4LevelForTrundle extends PerLevel {

        /**
         * @param values
         */
        public Per4LevelForTrundle(double base, double diff) {
            super(new int[] {1, 5, 9, 12, 15}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per3Level extends PerLevel {

        /**
         * @param values
         */
        public Per3Level(double base, double diff) {
            super(new int[] {1, 4, 7, 10, 13, 16}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per3LevelForKarma extends PerLevel {

        /**
         * @param values
         */
        public Per3LevelForKarma(double base, double diff) {
            super(new int[] {1, 3, 6, 9, 12, 15}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per3LevelAdditional extends PerLevel {

        /**
         * @param values
         */
        public Per3LevelAdditional(double base, double diff) {
            super(new int[] {1, 3, 6, 9, 12, 15, 18}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per1Level extends VariableResolver {

        /** The values. */
        private final double[] values;

        /**
         * @param values
         */
        public Per1Level(double[] values) {
            this.values = values;
        }

        /**
         * @param values
         */
        public Per1Level(double base, double diff) {
            double[] values = new double[18];

            for (int i = 0; i < values.length; i++) {
                values[i] = base + diff * i;
            }
            this.values = values;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return 18;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return values[skillLevel - 1];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }
    }

    /**
     * @version 2013/02/14 18:22:02
     */
    public static class Fixed extends VariableResolver {

        /** The fixed values. */
        private final double[] values;

        /**
         * @param values
         */
        public Fixed(double[] values) {
            this.values = values;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return values[skillLevel - 1];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return values.length;
        }
    }

    /**
     * @version 2013/02/15 13:05:53
     */
    public static class Diff extends VariableResolver {

        /** The base value of amplifier rate. */
        private final double base;

        /** The diff value of amplifier rate. */
        private final double diff;

        /** The variable size. */
        private final int size;

        /**
         * @param base
         * @param diff
         * @param size
         */
        public Diff(double base, double diff, int size) {
            this.base = base;
            this.diff = diff;
            this.size = size;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return base + diff * (skillLevel - 1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return base == 0 ? 0 : diff == 0 ? 1 : size;
        }
    }

    /**
     * @version 2013/03/28 23:27:41
     */
    public static class Refer extends Diff {

        /** The referenced skill. */
        private final Skill reference;

        /**
         * @param reference
         * @param base
         * @param diff
         */
        public Refer(Skill reference, double base, double diff) {
            super(base, diff, reference.getMaxLevel());

            this.reference = reference;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            return calculator.getLevel(reference);
        }
    }
}