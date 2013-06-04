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
import static teemowork.model.Version.*;

/**
 * @version 2013/01/29 1:55:25
 */
public class Ability extends Describable<AbilityDescriptor> {

    /** The ability. */
    public static final Ability AbyssalAura = new Ability("AbyssalAura");

    /** The ability. */
    public static final Ability Legion = new Ability("Legion", true);

    /** The ability. */
    public static final Ability Insight = new Ability("Insight", true);

    /** The ability. */
    public static final Ability ManaCharge = new Ability("Mana Charge", true);

    /** The ability name. */
    public final String name;

    /** The visible name. */
    public final boolean visible;

    /**
     * Create new ability with invisible name.
     */
    Ability(String name) {
        this(name, false);
    }

    /**
     * <p>
     * Create new ability.
     * </p>
     * 
     * @param name
     */
    Ability(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbilityDescriptor createDescriptor(AbilityDescriptor previous) {
        return new AbilityDescriptor(this, previous);
    }

    static {
        AbyssalAura.update(P0000).set(MRReduction, 20).aura(700);
        Legion.update(P0000).set(AR, 10).set(MR, 15).set(Hreg, 10).aura(1200);
        Insight.update(P0000).description("最大マナの3%に等しいAPを得る");
    }
}
