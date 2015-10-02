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

/**
 * @version 2015/09/16 9:10:52
 */
public interface Locatable<T> {

    /**
     * <p>
     * Retrieve the location identifier.
     * </p>
     * 
     * @return A location identifier.
     */
    default Locatable locator() {
        return this;
    }
}
