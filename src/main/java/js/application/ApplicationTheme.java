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

import booton.util.Color;
import booton.util.Font;

/**
 * @version 2012/12/15 22:06:17
 */
public class ApplicationTheme {

    private Font baseFontFamily;

    private Color baseBackgroundColor;

    private Color baseFontColor;

    /**
     * Get the baseFontFamily property of this {@link ApplicationTheme}.
     * 
     * @return The baseFontFamily property.
     */
    public Font getBaseFontFamily() {
        return baseFontFamily;
    }

    /**
     * Set the baseFontFamily property of this {@link ApplicationTheme}.
     * 
     * @param baseFontFamily The baseFontFamily value to set.
     */
    public void setBaseFontFamily(Font baseFontFamily) {
        this.baseFontFamily = baseFontFamily;
    }

    /**
     * Get the baseBackgroundColor property of this {@link ApplicationTheme}.
     * 
     * @return The baseBackgroundColor property.
     */
    public Color getBaseBackgroundColor() {
        return baseBackgroundColor;
    }

    /**
     * Set the baseBackgroundColor property of this {@link ApplicationTheme}.
     * 
     * @param baseBackgroundColor The baseBackgroundColor value to set.
     */
    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        this.baseBackgroundColor = baseBackgroundColor;
    }

    /**
     * Get the baseFontColor property of this {@link ApplicationTheme}.
     * 
     * @return The baseFontColor property.
     */
    public Color getBaseFontColor() {
        return baseFontColor;
    }

    /**
     * Set the baseFontColor property of this {@link ApplicationTheme}.
     * 
     * @param baseFontColor The baseFontColor value to set.
     */
    public void setBaseFontColor(Color baseFontColor) {
        this.baseFontColor = baseFontColor;
    }
}
