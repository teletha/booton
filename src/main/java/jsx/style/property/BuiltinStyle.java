/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import static jsx.style.value.Color.*;
import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2014/10/28 18:20:08
 */
class BuiltinStyle extends StyleRuleDescriptor {

    /**
     * Make text unselectable.
     */
    static final Style unselectable = () -> {
        cursor.defaults();

        selection(() -> {
            background.color(Transparent);
        });
    };
}