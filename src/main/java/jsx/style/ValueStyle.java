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
 * @version 2015/05/04 13:26:12
 */
public interface ValueStyle<V> {

    /**
     * <p>
     * Declare styles.
     * </p>
     */
    void declare(V value);

    /**
     * <p>
     * Retrieve the specific {@link Style} of the specified state.
     * </p>
     * 
     * @param value A value.
     * @return A specific {@link Style}.
     */
    default Style of(V value) {
        return new ContextualizableStyle(value, this, () -> declare(value));
    }
}
