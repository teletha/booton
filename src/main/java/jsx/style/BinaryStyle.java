/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import javafx.beans.property.BooleanProperty;

/**
 * @version 2015/05/04 13:33:36
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
    default Style of(BooleanProperty state) {
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
        return () -> {
            declare(state);
        };
    }
}
