/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.Global.*;
import js.util.jQuery;
import booton.css.CSS;

/**
 * @version 2013/03/22 14:53:36
 */
public class Image {

    /** SVG namespace uri. */
    private static final String SVG = "http://www.w3.org/2000/svg";

    /** XLink namespace uri. */
    private static final String XLINK = "http://www.w3.org/1999/xlink";

    /** The root element. */
    private final jQuery svg;

    /** The image element. */
    private final jQuery image;

    /** The filter element. */
    private final jQuery filters;

    /**
     * 
     */
    public Image(jQuery parent, Class<? extends CSS> className) {
        image = $(document.createElementNS(SVG, "image")).attr("width", "100%").attr("height", "100%");
        filters = $(document.createElementNS(SVG, "filter"));
        filters.attr("id", "filter" + hashCode());

        svg = $(document.createElementNS(SVG, "svg"));
        svg.append(filters);
        svg.append(image);
        svg.attr("class", className.toString());

        parent.append(svg);
    }

    /**
     * <p>
     * Set image pixel size.
     * </p>
     * 
     * @param width
     * @param height
     * @return
     */
    public Image size(int width, int height) {
        image.attr("width", width).attr("height", height);
        svg.attr("width", width).attr("height", height);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * Set image source.
     * </p>
     * 
     * @param src
     * @return
     */
    public Image src(String src) {
        image.get(0).setAttributeNS(XLINK, "xlink:href", src);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * Apply grayscale filter.
     * </p>
     * 
     * @param amount A amount of grayscale. (0 ~ 1)
     * @return
     */
    public Image grayscale(double amount) {
        return applyFilter($(document.createElementNS(SVG, "feColorMatrix")).attr("type", "matrix")
                .attr("values", amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 0 0 0 1 0"));
    }

    /**
     * <p>
     * Helper method to apply filter.
     * </p>
     * 
     * @param filter
     * @return
     */
    private Image applyFilter(jQuery filter) {
        // remove filter
        filters.empty();

        // add filter
        filters.append(filter);

        // apply filter
        image.attr("filter", "url('#filter" + hashCode() + "')");

        // Chainable API
        return this;
    }

    /**
     * <p>
     * Clear all applied filters.
     * </p>
     * 
     * @return
     */
    public Image clearFilter() {
        // remove filter
        filters.empty();

        // unapply filter
        image.removeAttr("filter");

        // Chainable API
        return this;
    }
}
