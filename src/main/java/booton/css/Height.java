/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import booton.util.Strings;

/**
 * @version 2012/12/11 16:28:33
 */
public enum Height {
    /**
     * The browser will calculate and select a height for the specified element.
     */
    Auto;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Strings.hyphenate(name());
    }
}
