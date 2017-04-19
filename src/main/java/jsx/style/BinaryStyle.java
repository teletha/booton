/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import javafx.beans.property.Property;

import kiss.Variable;

/**
 * @version 2017/04/19 11:12:11
 */
public interface BinaryStyle extends ValueStyle<Boolean> {

    /**
     * <p>
     * Retrieve the specific {@link Style} of the specified state.
     * </p>
     * 
     * @param state A binary state.
     * @return A specific {@link Style}.
     */
    default Style of(Property state) {
        return of(state == null ? false : Boolean.valueOf(String.valueOf(state.getValue())));
    }

    /**
     * <p>
     * Retrieve the specific {@link Style} of the specified state.
     * </p>
     * 
     * @param state A binary state.
     * @return A specific {@link Style}.
     */
    default Style of(Variable<Boolean> state) {
        return of(state == null ? false : state.get());
    }

    /**
     * <p>
     * Retrieve the specific {@link Style} of the specified state.
     * </p>
     * 
     * @param state A binary state.
     * @return A specific {@link Style}.
     */
    default Style of(boolean state) {
        return of(Boolean.valueOf(state));
    }
}
