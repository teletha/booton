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

import jsx.style.ValueStyle;
import kiss.Events;

/**
 * @version 2015/09/26 13:29:26
 */
public interface Locator {

    /**
     * <p>
     * Locate the specified point.
     * </p>
     * 
     * @param locator
     * @return
     */
    <T> Events<T> at(ValueStyle<T> locatable);

    <T> Events<T> at(Locatable<T> locatable);

    <T> Events<T> at(Locatable locator, Class<T> type);
}