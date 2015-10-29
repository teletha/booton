/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import kiss.Events;

/**
 * @version 2015/10/04 14:39:49
 */
public interface Locator {

    /**
     * <p>
     * Locate the specified point in {@link Widget}.
     * </p>
     * 
     * @param locatable A locator object with the bound context type.
     * @return A user intent {@link Events}.
     */
    <T> Events<T> at(Location<T> locatable);

    /**
     * <p>
     * Locate the specified point in {@link Widget}.
     * </p>
     * 
     * @param locatable A locator object.
     * @param type A context type.
     * @return A user intent {@link Events}.
     */
    <T> Events<T> at(Location locatable, Class<T> type);

}