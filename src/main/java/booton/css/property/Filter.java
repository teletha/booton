/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import booton.css.CSSProperty;
import booton.css.CSSWriter;

/**
 * <p>
 * The CSS filter property provides for effects like blurring or color shifting on an element’s
 * rendering before the element is displayed. Filters are commonly used to adjust the rendering of
 * an image, a background, or a border.
 * </p>
 * <p>
 * Included in the CSS standard are several functions that achieve predefined effects. You can also
 * reference a filter specified in SVG with a URL to an SVG filter element.
 * </p>
 * 
 * @version 2013/03/14 1:19:52
 */
public class Filter extends CSSProperty<Filter> {

    private double grayscale;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property("filter", writeSVGFilterGrayscale(grayscale));
        writer.property("-webkit-filter", "grayscale(" + grayscale + "%)");
    }

    /**
     * <p>
     * Converts the input image to grayscale. The value of ‘amount’ defines the proportion of the
     * conversion. A value of 100% is completely grayscale. A value of 0% leaves the input
     * unchanged. Values between 0% and 100% are linear multipliers on the effect. If the ‘amount’
     * parameter is missing, a value of 100% is used.
     * </p>
     * 
     * @param amount
     * @return
     */
    public Filter grayscale(double amount) {
        grayscale = amount;

        return chain();
    }

    /**
     * <p>
     * Write SVG filter.
     * </p>
     * 
     * @return
     */
    private String writeSVGFilterGrayscale(double amount) {
        amount = amount / 100;

        StringBuilder builder = new StringBuilder();
        builder.append("url(\"data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg'><filter id='grayscale'><feColorMatrix type='matrix' values='");
        builder.append(amount)
                .append(" ")
                .append(amount)
                .append(" ")
                .append(amount)
                .append(" 0 0 ")
                .append(amount)
                .append(" ")
                .append(amount)
                .append(" ")
                .append(amount)
                .append(" 0 0 ")
                .append(amount)
                .append(" ")
                .append(amount)
                .append(" ")
                .append(amount)
                .append(" 0 0 0 0 0 1 0");
        builder.append("'/></filter></svg>#grayscale\");");

        return builder.toString();
    }
}
