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

import static jsx.style.ValuedStyle.*;

import java.util.HashMap;

import jsx.ui.Style;
import jsx.ui.flux.Location;

/**
 * @version 2015/09/29 10:21:36
 */
public interface ValueStyle<V> extends Location<V> {

    /**
     * <p>
     * Declare styles for the specified value.
     * </p>
     */
    void style(V value);

    /**
     * <p>
     * Retrieve the refined {@link Style} of the specified value.
     * </p>
     * 
     * @param value A conditional value.
     * @return A refined {@link Style}.
     */
    default Style of(V value) {
        return cache.computeIfAbsent(this, style -> new HashMap()).computeIfAbsent(value, key -> new ValuedStyle(this, key));
    }
}
