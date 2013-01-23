/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.improvement;

/**
 * @version 2013/01/21 20:19:06
 */
public interface AttackSpeedPerLv extends Improvement {

    /**
     * <p>
     * Compute attack speed improvement value.
     * </p>
     * 
     * @return An attack speed increase value per level.
     */
    double getASPerLv();
}