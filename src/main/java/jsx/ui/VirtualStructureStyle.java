/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import jsx.style.StyleClass;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2014/09/12 11:00:18
 */
class VirtualStructureStyle extends StyleRuleDescriptor {

    static StyleClass HBOX = () -> {
        display.flex();
    };

    static StyleClass VBOX = () -> {
        display.flex().direction.column();
    };

    static StyleClass SBOX = () -> {
        position.relative();

        children(() -> {
            position.absolute();
        });
    };
}
