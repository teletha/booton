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

import js.lang.NativeArray;

/**
 * @version 2013/01/27 12:31:12
 */
public class Ability {

    /** The ability name. */
    public final String name;

    /** The aura flag. */
    public final boolean isAura;

    /** The status history. */
    private History history;

    /**
     * @param name
     * @param isAura
     */
    public Ability(String name, boolean isAura) {
        this.name = name;
        this.isAura = isAura;
    }

    /**
     * <p>
     * Calcurate status value at the specified version.
     * </p>
     * 
     * @param status A target status to calcurate.
     * @param version A target version.
     * @return A calcurated value.
     */
    public double get(Status status, Version version) {
        return history.get(status, version);
    }

    /**
     * <p>
     * Set status value at the specified version.
     * </p>
     * 
     * @param status
     * @param value
     * @param version A target version.
     * @return
     */
    public Ability set(Status status, double value) {
        history.set(status, value);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * Set patch version.
     * </p>
     * 
     * @param version
     * @return
     */
    public Ability set(Version version) {
        this.history = new History(version, history);

        return this;
    }

    /**
     * @version 2013/01/27 15:05:02
     */
    private static class History {

        /** The current version info. */
        private final Version version;

        /** The previous. */
        private final History previous;

        /** The status values. */
        private final NativeArray<Double> values = new NativeArray();

        /**
         * @param version
         * @param previous
         */
        private History(Version version, History previous) {
            this.version = version;
            this.previous = previous;
        }

        /**
         * <p>
         * Calcurate status value at this version.
         * </p>
         * 
         * @param status
         * @param version
         * @return
         */
        private double get(Status status, Version version) {
            if (0 < this.version.compareTo(version)) {
                return previous == null ? 0 : previous.get(status, version);
            }

            Double value = values.get(status.ordinal());

            if (value == null) {
                return previous == null ? 0 : previous.get(status, version);
            }
            return value;
        }

        /**
         * <p>
         * Set status value at this version.
         * </p>
         * 
         * @param status
         * @param value
         */
        private void set(Status status, double value) {
            values.set(status.ordinal(), value);
        }
    }
}
