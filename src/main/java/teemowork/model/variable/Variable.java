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

import java.util.List;

import teemowork.model.Status;
import teemowork.model.StatusCalculator;

/**
 * @version 2013/03/03 9:37:52
 */
public interface Variable {

    /**
     * Get the status property of this {@link VariableHolder}.
     * 
     * @return The status property.
     */
    Status getStatus();

    /**
     * Get the resolver property of this {@link VariableHolder}.
     * 
     * @return The resolver property.
     */
    VariableResolver getResolver();

    /**
     * Get the amplifiers property of this {@link VariableHolder}.
     * 
     * @return The amplifiers property.
     */
    List<VariableHolder> getAmplifiers();

    /**
     * <p>
     * Get the conditional property of this {@link VariableHolder}.
     * </p>
     * 
     * @return
     */
    boolean isConditional();

    /**
     * <p>
     * Calculate value by using the specified calculator.
     * </p>
     * 
     * @param level A level.
     * @param calculator A status calculator.
     * @return A calculated value.
     */
    double calculate(int level, StatusCalculator calculator);

}