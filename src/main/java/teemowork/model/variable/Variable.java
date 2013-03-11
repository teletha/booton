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
import java.util.Set;

import js.util.ArrayList;
import js.util.HashSet;
import teemowork.model.Status;
import teemowork.model.StatusCalculator;

/**
 * @version 2013/03/11 18:38:36
 */
public class Variable {

    /** The variable type. */
    private Status status;

    /** The value enumerator. */
    private VariableResolver resolver;

    /** The condtional variable flag. */
    private boolean conditional = false;

    /** The amplifiers for this amplifier rate. */
    private List<Variable> amplifiers = new ArrayList();

    /**
     * Without ID.
     */
    public Variable() {
    }

    /**
     * @param status
     * @param resolver
     */
    public Variable(Status status, VariableResolver resolver) {
        this.status = status;
        this.resolver = resolver;
    }

    /**
     * @param status
     * @param resolver
     */
    public Variable(Status status, VariableResolver resolver, Variable amplifier) {
        this.status = status;
        this.resolver = resolver;

        if (amplifier != null) {
            amplifiers.add(amplifier);
        }
    }

    /**
     * Get the status property of this {@link Variable}.
     * 
     * @return The status property.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status property of this {@link Variable}.
     * 
     * @param status The status value to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the resolver property of this {@link Variable}.
     * 
     * @return The resolver property.
     */
    public VariableResolver getResolver() {
        return resolver;
    }

    /**
     * Set the resolver property of this {@link Variable}.
     * 
     * @param resolver The resolver value to set.
     */
    public void setResolver(VariableResolver resolver) {
        this.resolver = resolver;
    }

    /**
     * <p>
     * Get the conditional property of this {@link Variable}.
     * </p>
     * 
     * @return
     */
    public boolean isConditional() {
        return conditional;
    }

    /**
     * <p>
     * Set the conditional property of this {@link Variable}.
     * </p>
     */
    public void setConditional() {
        this.conditional = true;
    }

    private Set set = new HashSet();

    /**
     * <p>
     * Calculate value by using the specified calculator.
     * </p>
     * 
     * @param level A level.
     * @param calculator A status calculator.
     * @return A calculated value.
     */
    public double calculate(int level, StatusCalculator calculator) {
        if (!set.add(calculator)) {
            return 0;
        }

        double value = resolver.compute(level);

        for (Variable amplifier : amplifiers) {
            value += amplifier.calculate(level, calculator) * calculator.calculate(amplifier.getStatus());
        }

        if (status == CD || status == CDRAwareTime) {
            value = value * (1 - calculator.calculate(CDR) / 100);
        }

        set.remove(calculator);
        return value;
    }

    /**
     * Get the amplifiers property of this {@link Variable}.
     * 
     * @return The amplifiers property.
     */
    public List<Variable> getAmplifiers() {
        return amplifiers;
    }

    public void add(Variable amplifier) {
        if (amplifier != null) {
            amplifiers.add(amplifier);
        }
    }
}
