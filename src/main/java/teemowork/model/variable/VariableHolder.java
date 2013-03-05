/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import static teemowork.model.Status.*;

import java.util.List;

import js.util.ArrayList;
import teemowork.model.Status;
import teemowork.model.StatusCalculator;

/**
 * @version 2013/02/13 1:35:47
 */
public class VariableHolder implements Variable {

    /** The variable identifier. */
    public final int id;

    /** The variable type. */
    private Status status;

    /** The value enumerator. */
    private VariableResolver resolver;

    /** The condtional variable flag. */
    private boolean conditional = false;

    /** The amplifiers for this amplifier rate. */
    private List<VariableHolder> amplifiers = new ArrayList();

    /**
     * Without ID.
     */
    public VariableHolder() {
        this(-1);
    }

    /**
     * With ID.
     * 
     * @param id A variable identifier.
     */
    public VariableHolder(int id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status property of this {@link VariableHolder}.
     * 
     * @param status The status value to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VariableResolver getResolver() {
        return resolver;
    }

    /**
     * Set the resolver property of this {@link VariableHolder}.
     * 
     * @param resolver The resolver value to set.
     */
    public void setResolver(VariableResolver resolver) {
        this.resolver = resolver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConditional() {
        return conditional;
    }

    /**
     * <p>
     * Set the conditional property of this {@link VariableHolder}.
     * </p>
     */
    public void setConditional() {
        this.conditional = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculate(int level, StatusCalculator calculator) {
        double value = resolver.compute(level);

        for (Variable amplifier : getAmplifiers()) {
            value += amplifier.calculate(level, calculator) * calculator.calculate(amplifier.getStatus());
        }

        if (status == CD || status == CDRAwareTime) {
            value = value * (1 - calculator.calculate(CDR) / 100);
        }
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<VariableHolder> getAmplifiers() {
        return amplifiers;
    }
}
