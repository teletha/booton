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
 * @version 2013/02/06 13:53:39
 */
public class SkillVariable {

    /** The variable id. */
    final int id;

    /** The variable type. */
    private Status status;

    /** The base value. */
    private double base;

    /** The value of diff for each stack. */
    private double diff;

    /** The ratio type. */
    private Status ratioType;

    /** The ratio value. */
    private double ratio;

    /**
     * @param id
     */
    SkillVariable(int id) {
        this.id = id;
    }

    /**
     * Get the status property of this {@link SkillVariable}.
     * 
     * @return The status property.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status property of this {@link SkillVariable}.
     * 
     * @param status The status value to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the base property of this {@link SkillVariable}.
     * 
     * @return The base property.
     */
    public double getBase() {
        return base;
    }

    /**
     * Set the base property of this {@link SkillVariable}.
     * 
     * @param base The base value to set.
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Get the diff property of this {@link SkillVariable}.
     * 
     * @return The diff property.
     */
    public double getDiff() {
        return diff;
    }

    /**
     * Set the diff property of this {@link SkillVariable}.
     * 
     * @param diff The diff value to set.
     */
    public void setDiff(double diff) {
        this.diff = diff;
    }

    /**
     * Get the ratioType property of this {@link SkillVariable}.
     * 
     * @return The ratioType property.
     */
    public Status getRatioType() {
        return ratioType;
    }

    /**
     * Set the ratioType property of this {@link SkillVariable}.
     * 
     * @param ratioType The ratioType value to set.
     */
    public void setRatioType(Status ratioType) {
        this.ratioType = ratioType;
    }

    /**
     * Get the ratio property of this {@link SkillVariable}.
     * 
     * @return The ratio property.
     */
    public double getRatio() {
        return ratio;
    }

    /**
     * Set the ratio property of this {@link SkillVariable}.
     * 
     * @param ratio The ratio value to set.
     */
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return status.name;
    }
}
