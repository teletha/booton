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
     * @param hint A hint for size.
     * @return
     */
    public abstract int estimateSize(int hint);

    /**
     * <p>
     * Enumerate all values for this variable.
     * </p>
     * 
     * @return A list of all computed values.
     */
    public double[] enumerate(int hint) {
        double[] values = new double[estimateSize(hint)];

        for (int i = 0; i < values.length; i++) {
            values[i] = compute(i + 1);
        }
        return values;
    }

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
     * Convert chnapion level to skill level.
     * </p>
     * 
     * @return
     */
    public int convertLevel(int level) {
        return level;
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
        public int estimateSize(int hint) {
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
        public int convertLevel(int level) {
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
    public static class Per2Level extends PerLevel {

        /**
         * @param values
         */
        public Per2Level(double base, double diff) {
            super(new int[] {1, 3, 6, 9, 12, 15, 18}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per1Level extends VariableResolver {

        /** The values. */
        private final int[] values;

        /**
         * @param values
         */
        public Per1Level(int[] values) {
            this.values = values;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize(int hint) {
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
        public int estimateSize(int hint) {
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

        /**
         * @param base
         * @param diff
         */
        public Diff(double base, double diff) {
            this.base = base;
            this.diff = diff;
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
        public int estimateSize(int hint) {
            return base == 0 ? 0 : diff == 0 ? 1 : hint;
        }
    }
}