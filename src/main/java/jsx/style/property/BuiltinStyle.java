/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.StyleDSL;
import jsx.style.value.Color;
import jsx.ui.Style;

/**
 * @version 2016/09/18 11:46:20
 */
class BuiltinStyle extends StyleDSL {

    /**
     * Make text unselectable.
     */
    Style unselectable = () -> {
        cursor.defaults();

        selection(() -> {
            background.color(Color.Transparent);
        });
    };
}
