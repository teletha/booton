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

import jsx.style.value.Color;

/**
 * @version 2015/03/23 16:59:38
 */
public class Fill extends Colorable<Fill> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Fill color(Color color) {
        value("fill", color.toString());

        return this;
    }

    public Fill none() {
        value("fill", "none");

        return this;
    }
}