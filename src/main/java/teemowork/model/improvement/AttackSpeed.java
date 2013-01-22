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
 * @version 2013/01/21 20:17:29
 */
public interface AttackSpeed extends Improvement {

    /**
     * <p>
     * Compute attack spped improvement value.
     * </p>
     * 
     * @return A base attack speed.
     */
    double getASBase();
}
