/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.Style;
import jsx.style.StyleDescriptor;
import jsx.style.value.Color;

/**
 * @version 2015/05/24 18:00:10
 */
class BuiltinStyle extends StyleDescriptor {

    /**
     * Make text unselectable.
     */
    static final Style unselectable = () -> {
        cursor.defaults();

        selection(() -> {
            background.color(Color.Transparent);
        });
    };

    /**
     * Make box centering.
     */
    static final Style centering = () -> {
        position.bottom(50, percent).right(50, percent);
        transform.translate(50, percent);
    };
}
