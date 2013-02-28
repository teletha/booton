/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.application;

import js.util.Color;

/**
 * @version 2012/12/15 22:06:17
 */
public class ApplicationTheme {

    /** The base color. */
    private Color baseColor;

    /** The main color. */
    private Color mainColor;

    /** The accent color. */
    private Color accentColor;

    /**
     * <p>
     * Set main color, base color and accent color.
     * </p>
     * 
     * @param mainColor Your main color.
     */
    protected void buildColor(Color mainColor) {
        if (mainColor != null) {
            this.mainColor = mainColor;
        }
    }
}
