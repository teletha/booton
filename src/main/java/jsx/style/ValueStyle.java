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

import jsx.ui.Locatable;
import jsx.ui.StructureDescriptor.Style;
import kiss.I;

/**
 * @version 2015/09/20 10:13:35
 */
public interface ValueStyle<V> extends Locatable<V> {

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
        return cache.computeIfAbsent(I.pair(this, value), key -> new ValuedStyle(value, this, () -> style(value)));
    }
}
