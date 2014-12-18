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

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2014/09/12 11:00:18
 */
class VirtualStructureStyle extends StyleRuleDescriptor {

    static Style NBOX = () -> {
    };

    static Style HBOX = () -> {
        display.flex();
    };

    static Style VBOX = () -> {
        display.flex().direction.column();
    };

    static Style SBOX = () -> {
        position.relative();

        children(() -> {
            position.absolute();
        });
    };
}
