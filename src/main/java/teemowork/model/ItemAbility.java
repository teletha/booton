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
public class ItemAbility {

    /** The ability. */
    public static final ItemAbility AbyssalAura = new ItemAbility("AbyssalAura");

    /** The ability. */
    public static final ItemAbility Legion = new ItemAbility("Legion", true);

    /** The ability. */
    public static final ItemAbility Insight = new ItemAbility("Insight", true);

    /** The ability. */
    public static final ItemAbility ManaCharge = new ItemAbility("Mana Charge", true);

    /** The ability name. */
    public final String name;

    /** The visible name. */
    public final boolean visible;

    /** The descriptor. */
    private final ItemAbilityStatus[] versions = new ItemAbilityStatus[Version.values().length];

    /**
     * Create new ability with invisible name.
     */
    ItemAbility(String name) {
        this(name, false);
    }

    /**
     * <p>
     * Create new ability.
     * </p>
     * 
     * @param name
     */
    ItemAbility(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
    }

    /**
     * <p>
     * Retrieve a status at the specified version.
     * </p>
     */
    public ItemAbilityStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ItemAbilityStatus status = versions[i];

            if (status != null) {
                return status;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update status.
     * </p>
     * 
     * @param version A update version.
     * @return A descriptor.
     */
    ItemAbilityStatus update(Version version) {
        ItemAbilityStatus status = new ItemAbilityStatus(getStatus(version));

        versions[version.ordinal()] = status;

        return status;
    }

    static {
        AbyssalAura.update(P0000).set(MRReduction, 20).aura(700);
        Legion.update(P0000).set(AR, 10).set(MR, 15).set(Hreg, 10).aura(1200);
        Insight.update(P0000).description("最大マナの3%に等しいAPを得る");
    }
}
