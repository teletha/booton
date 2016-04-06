/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.flux;

/**
 * @version 2015/10/03 0:19:01
 */
public interface Location<T> {

    /**
     * <p>
     * Compute location name.
     * </p>
     * 
     * @return A location name.
     */
    default String name() {
        return "AT" + hashCode();
    }

    /**
     * <p>
     * Compute location name.
     * </p>
     * 
     * @return A location name.
     */
    default String[] names() {
        return new String[] {name()};
    }
}
