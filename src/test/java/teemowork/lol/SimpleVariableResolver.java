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
 * @version 2013/02/14 1:27:31
 */
public class SimpleVariableResolver extends SkillVariableResolver {

    /** The base value of amplifier rate. */
    private final double base;

    /** The diff value of amplifier rate. */
    private final double diff;

    /**
     * @param base
     * @param diff
     */
    public SimpleVariableResolver(double base, double diff) {
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
    public int computeSize(int hint) {
        return diff == 0 ? 1 : hint;
    }
}