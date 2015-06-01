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

/**
 * @version 2015/06/01 11:00:47
 */
public interface EnumStyle<E extends Enum> extends ValueStyle<E> {

    /**
     * <p>
     * Retrieve the specific {@link Style} of the specified state.
     * </p>
     * 
     * @param state A binary state.
     * @return A specific {@link Style}.
     */
    @Override
    default Style of(E state) {
        return () -> {
            declare(state);
        };
    }
}
