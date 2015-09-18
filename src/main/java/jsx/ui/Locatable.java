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
    default Object locator() {
        return this;
    }

    // /**
    // * <p>
    // * Test whether the specified {@link Locatable} matches this {@link Locatable} or not.
    // * </p>
    // *
    // * @param locatable
    // * @return
    // */
    // boolean matche(Locatable locatable);
}
