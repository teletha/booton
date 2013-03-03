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

import java.util.List;

/**
 * @version 2013/03/03 11:57:14
 */
public class VariableDelegator implements Variable {

    /** The identifier of the actual variable. */
    private int id;

    /** The actual variable. */
    private Variable variable;

    /**
     * {@inheritDoc}
     */
    public Status getStatus() {
        return variable.getStatus();
    }

    /**
     * {@inheritDoc}
     */
    public VariableResolver getResolver() {
        return variable.getResolver();
    }

    /**
     * {@inheritDoc}
     */
    public List<VariableHolder> getAmplifiers() {
        return variable.getAmplifiers();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isConditional() {
        return variable.isConditional();
    }

    /**
     * {@inheritDoc}
     */
    public double calculate(int level, StatusCalculator calculator) {
        return variable.calculate(level, calculator);
    }
}
