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

/**
 * @version 2013/01/29 1:55:25
 */
public class AbilityDescriptor extends Descriptor<AbilityDescriptor> {

    /** The unique flag. */
    private boolean unique;

    /** The aura flag. */
    private boolean aura;

    /** The ability description. */
    private String description;

    /**
     * <p>
     * Create new item ability.
     * </p>
     * 
     * @param name
     * @param unique
     * @param previous
     */
    AbilityDescriptor(Ability ability, AbilityDescriptor previous, Version version) {
        super(ability, previous, version);

        if (previous != null) {
            unique = previous.unique;
            aura = previous.aura;
            description = previous.description;
        } else {
            unique = true;
            aura = false;
            description = "";
        }
    }

    /**
     * <p>
     * Make as aura.
     * </p>
     * 
     * @param range
     * @return
     */
    AbilityDescriptor aura(String text) {
        this.aura = true;
        this.unique = true;

        return passive(text);
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isAura() {
        return aura;
    }

    /**
     * <p>
     * Make as unique.
     * </p>
     * 
     * @return
     */
    AbilityDescriptor ununique() {
        this.unique = false;

        return this;
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * <p>
     * Describe this ability.
     * </p>
     * 
     * @param text
     * @return
     */
    public AbilityDescriptor description(String text) {
        this.description = text;

        return this;
    }

    /**
     * <p>
     * Retrieve description.
     * </p>
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

}
