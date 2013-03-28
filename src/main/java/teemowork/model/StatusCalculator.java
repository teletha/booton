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
 * @version 2013/03/28 23:45:28
 */
public interface StatusCalculator {

    /**
     * <p>
     * Calculate status value.
     * </p>
     * 
     * @param status A target status to calculate.
     * @return A calculated value.
     */
    double calculate(Status status);

    /**
     * Get the level of this entity.
     * 
     * @return The level property.
     */
    public int getLevel();

    /**
     * <p>
     * Retrieve skill level.
     * </p>
     * 
     * @param skill A target skill.
     * @return A skill level.
     */
    public int getLevel(Skill skill);
}
