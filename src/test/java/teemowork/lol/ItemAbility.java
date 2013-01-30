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

import static teemowork.lol.Status.*;
import static teemowork.lol.Version.*;

/**
 * @version 2013/01/29 1:55:25
 */
public enum ItemAbility {

    AbyssalAura,

    Legion("Legion"),

    Insight("Insight"),

    ManaCharge("Mana Charge");

    /** The ability name. */
    public final String name;

    /** The visible name. */
    public final boolean visible;

    /** The descriptor. */
    private final ItemAbilityDescriptor[] descriptors = new ItemAbilityDescriptor[Version.values().length];

    /**
     * Create new ability with invisible name.
     */
    private ItemAbility() {
        this(null);
    }

    /**
     * <p>
     * Create new ability.
     * </p>
     * 
     * @param name
     */
    private ItemAbility(String name) {
        this.visible = name != null;
        this.name = visible ? name : name();
    }

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ItemAbilityDescriptor getDescriptor(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ItemAbilityDescriptor descriptor = descriptors[i];

            if (descriptor != null) {
                return descriptor;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @param version A update version.
     * @return A descriptor.
     */
    private ItemAbilityDescriptor update(Version version) {
        ItemAbilityDescriptor descriptor = new ItemAbilityDescriptor(getDescriptor(version));

        descriptors[version.ordinal()] = descriptor;

        return descriptor;
    }

    static {
        AbyssalAura.update(P0000).set(MRReduction, 20).aura(700);
        Legion.update(P0000).set(AR, 10).set(MR, 15).set(Hreg, 10).aura(1200);
        Insight.update(P0000).description("最大マナの3%に等しいAPを得る");
    }
}
