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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 2013/01/29 1:55:25
 */
public class ItemDescriptor extends Descriptor<ItemDescriptor> {

    /** The value store. */
    private double[] values = new double[Status.values().length];

    /** The item build. */
    private Item[] build = new Item[0];

    /** The ability list. */
    private List<Ability> abilities = new ArrayList();

    /** The item status. */
    private boolean deprecated = false;

    /**
     * @param name
     */
    ItemDescriptor(Item item, ItemDescriptor previous, Version version) {
        super(item, previous, version);

        if (previous != null) {
            values = Arrays.copyOf(previous.values, previous.values.length);
            build = previous.build;
            abilities = new ArrayList(previous.abilities);
        }
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return A result.
     */
    public double get(Status status) {
        return values[status.ordinal()];
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    ItemDescriptor set(Status status, double value) {
        values[status.ordinal()] = value;

        return this;
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor health(double value) {
        return set(Health, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor healthRegen(double value) {
        return set(Hreg, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor mana(double value) {
        return set(Mana, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor manaRegen(double value) {
        return set(Mreg, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor attackDamage(double value) {
        return set(AD, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor abilityPower(double value) {
        return set(AP, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor armor(double value) {
        return set(AR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor magicRegist(double value) {
        return set(MR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor attackSpeed(double value) {
        return set(ASRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor movementSpeed(double value) {
        return set(MSRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor cooldownReduction(double value) {
        return set(CDR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor spellVamp(double value) {
        return set(SV, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor lifeSteal(double value) {
        return set(LS, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor critical(double value) {
        return set(Critical, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor goldGeneration(double value) {
        return set(GoldPer10Sec, value);
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    ItemDescriptor cost(double base) {
        set(Cost, base);

        return this;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    ItemDescriptor price(double buy, double sell) {
        set(Cost, buy);

        return this;
    }

    /**
     * <p>
     * Get build items.
     * </p>
     * 
     * @return items.
     */
    public Item[] getBuild() {
        return build;
    }

    /**
     * <p>
     * Set build items.
     * </p>
     * 
     * @param items
     * @return
     */
    ItemDescriptor build(Item... items) {
        this.build = items;

        return this;
    }

    /**
     * <p>
     * Get special abilities.
     * </p>
     * 
     * @return Abilities.
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * <p>
     * Set special abilities.
     * </p>
     * 
     * @param Ability list.
     */
    ItemDescriptor add(Ability... abilities) {
        for (Ability ability : abilities) {
            this.abilities.add(ability);
        }
        return this;
    }

    /**
     * <p>
     * Make this item deprecated.
     * </p>
     * 
     * @return
     */
    ItemDescriptor deprecated() {
        this.deprecated = true;

        return this;
    }

    /**
     * <p>
     * Check whether this item is deprecated or not.
     * </p>
     * 
     * @return A result.
     */
    public boolean isDeprecated() {
        return deprecated;
    }

    ItemDescriptor add(String name, Consumer<AbilityDescriptor> descriptor) {
        Ability ability = new Ability(name, descriptor);
        this.abilities.add(ability);

        descriptor.accept(ability.update(version));

        return this;
    }

    /**
     * <p>
     * Make this item deprecated.
     * </p>
     * 
     * @return
     */
    ItemDescriptor add(Consumer<AbilityDescriptor> descriptor) {
        Ability ability = new Ability(descriptor);
        this.abilities.add(ability);

        descriptor.accept(ability.update(version));

        return this;
    }

    /**
     * <p>
     * Make this item deprecated.
     * </p>
     * 
     * @return
     */
    ItemDescriptor add(Consumer<AbilityDescriptor> descriptor1, Consumer<AbilityDescriptor> descriptor2) {
        Ability ability1 = new Ability(descriptor1);
        Ability ability2 = new Ability(descriptor2);
        this.abilities.add(ability1);
        this.abilities.add(ability2);

        descriptor1.accept(ability1.update(version));
        descriptor2.accept(ability2.update(version));

        return this;
    }

    ItemDescriptor clear() {
        abilities.clear();

        return this;
    }

    ItemDescriptor remove(Ability ability) {
        abilities.remove(ability);

        return this;
    }
}
