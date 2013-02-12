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
 * @version 2013/02/13 1:35:47
 */
public class SkillAmplifier {

    /** The amplifier type. */
    public final Status status;

    /** The base value of amplifier rate. */
    public final double base;

    /** The diff value of amplifier rate. */
    public final double diff;

    /**
     * @param status
     * @param base
     * @param diff
     */
    public SkillAmplifier(Status status, double base, double diff) {
        this.status = status;
        this.base = base;
        this.diff = diff;
    }

    public double compute(double value) {
        return value + base + diff;
    }
}
