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
 * @version 2012/12/11 16:23:56
 */
public enum Width {
    /**
     * The browser will calculate and select a width for the specified element.
     */
    Auto,

    /**
     * The intrinsic preferred width.
     */
    MaxContent,

    /**
     * The intrinsic minimum width.
     */
    MinContent,

    /**
     * <p>
     * The larger of:
     * </p>
     * <ul>
     * <li>the intrinsic minimum width</li>
     * <li>the smaller of the intrinsic preferred width and the available width</li>
     * </ul>
     */
    FitContent,

    /**
     * The containing block width minus horizontal margin, border and padding
     */
    Available;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Strings.hyphenate(name());
    }
}
