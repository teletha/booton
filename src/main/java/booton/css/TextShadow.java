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

import java.util.ArrayList;
import java.util.List;

import kiss.I;
import booton.util.RGB;

/**
 * @version 2012/12/12 12:03:34
 */
public class TextShadow extends CSSProperty<TextShadow> {

    /** The shadows. */
    private final List<String> values = new ArrayList();

    /**
     * <p>
     * The text-shadow CSS property adds shadows to text. It accepts a comma-separated list of
     * shadows to be applied to the text and text-decorations of the element.
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param rgb
     * @return
     */
    public TextShadow add(double offsetX, Unit unitX, double offsetY, Unit unitY, int blurRadius, Unit unitRadius, RGB rgb) {
        values.add(compute(offsetX, unitX) + " " + compute(offsetY, unitY) + " " + compute(blurRadius, unitRadius) + " " + rgb);

        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property(name, I.join(values, ","));
    }
}
