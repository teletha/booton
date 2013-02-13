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

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/02/13 1:35:47
 */
public class SkillAmplifier {

    /** The amplifier type. */
    private Status status;

    /** The value enumerator. */
    private SkillVariableResolver resolver;

    /** The amplifiers for this amplifier rate. */
    public final List<SkillAmplifier> amplifiers = new ArrayList();

    /**
     * Get the status property of this {@link SkillAmplifier}.
     * 
     * @return The status property.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status property of this {@link SkillAmplifier}.
     * 
     * @param status The status value to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the resolver property of this {@link SkillAmplifier}.
     * 
     * @return The resolver property.
     */
    public SkillVariableResolver getResolver() {
        return resolver;
    }

    /**
     * Set the resolver property of this {@link SkillAmplifier}.
     * 
     * @param resolver The resolver value to set.
     */
    public void setResolver(SkillVariableResolver resolver) {
        this.resolver = resolver;
    }
}
