/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.dynamic;

import jsx.style.StyleDescriptor;
import jsx.style.value.Color;

/**
 * @version 2015/05/03 13:36:15
 */
public class OrnamentDefinition extends StyleDescriptor {

    public void form() {
        display.block();
        font.color(Color.WhiteGray);
    }

    public void create() {
    }
}
