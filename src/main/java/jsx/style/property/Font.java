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

import jsx.style.value.Color;

/**
 * @version 2014/10/21 13:40:43
 */
public class Font extends Colorable<Font> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Font color(Color color) {
        value("color", color.toString());

        return this;
    }
}
