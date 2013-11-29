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
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

/**
 * @version 2013/03/20 0:32:27
 */
public class SkillDescriptor extends Descriptor<SkillDescriptor> {

    /** The skill range. */
    private Variable range;

    /** The skill cost. */
    private Variable cost;

    /** The skill cooldown. */
    private Variable cooldown;

    /** The skill type. */
    private SkillType type = SkillType.Active;

    /**
     * @param name
     */
    SkillDescriptor(Skill skill, SkillDescriptor previous, Version version) {
        super(skill, previous, version);

        if (previous != null) {
            type = previous.type;
            cost = previous.cost;
            range = previous.range;
            cooldown = previous.cooldown;
        }
    }

    /**
     * <p>
     * Retrieve skill range.
     * </p>
     * 
     * @return
     */
    public Variable getCooldown() {
        return cooldown;
    }

    /**
     * <p>
     * Set cooldown time.
     * </p>
     * 
     * @param base A base time.
     * @param diff A diff time.
     */
    SkillDescriptor cd(double base) {
        return cd(base, 0);
    }

    /**
     * <p>
     * Set cooldown time.
     * </p>
     * 
     * @param base A base time.
     * @param diff A diff time.
     */
    SkillDescriptor cd(double base, double diff) {
        return cd(new Diff(base, diff, describable.getMaxLevel()));
    }

    /**
     * <p>
     * Set cooldown time.
     * </p>
     * 
     * @param base A base time.
     * @param diff A diff time.
     */
    SkillDescriptor cd(VariableResolver resolver) {
        cooldown = new Variable(CD, resolver);

        return this;
    }

    /**
     * <p>
     * Retrieve skill cost.
     * </p>
     * 
     * @return
     */
    public Variable getCost() {
        return cost;
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillDescriptor mana(double base) {
        return cost(Mana, base, 0);
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillDescriptor mana(double base, double diff) {
        return cost(Mana, base, diff);
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillDescriptor cost(Status type, double base, double diff) {
        return cost(type, new Diff(base, diff, describable.getMaxLevel()), null);
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillDescriptor cost(Status type, VariableResolver resolver, Variable amplifier) {
        cost = new Variable(type, resolver, amplifier);

        return this;
    }

    /**
     * <p>
     * Retrieve skill range.
     * </p>
     * 
     * @return
     */
    public Variable getRange() {
        return range;
    }

    /**
     * <p>
     * Set skill range.
     * </p>
     * 
     * @param range
     */
    SkillDescriptor range(double range) {
        return range(range, 0);
    }

    /**
     * <p>
     * Set skill range.
     * </p>
     * 
     * @param range
     */
    SkillDescriptor range(double base, double diff) {
        return range(new Diff(base, diff, describable.getMaxLevel()), null);
    }

    /**
     * <p>
     * Set skill range.
     * </p>
     * 
     * @param range
     */
    SkillDescriptor range(VariableResolver resolver, Variable amplifier) {
        range = new Variable(Range, resolver);
        range.add(amplifier);

        return this;
    }

    /**
     * <p>
     * Retrieve this skill type.
     * </p>
     * 
     * @return A result.
     */
    public SkillType getType() {
        return type;
    }

    /**
     * <p>
     * Set this skill is togglable.
     * </p>
     * 
     * @return
     */
    SkillDescriptor type(SkillType type) {
        this.type = type;

        return this;
    }
}
