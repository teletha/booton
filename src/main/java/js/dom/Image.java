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
    private final Element svg;

    /** The image element. */
    private final Element image;

    /** The filter element. */
    private final Element filters;

    /**
     * 
     */
    public Image(jQuery parent, Class<? extends CSS> className) {
        image = document.createElementNS(SVG, "image").set("width", "100%").set("height", "100%");
        filters = document.createElementNS(SVG, "filter");
        filters.set("id", "filter" + hashCode());

        svg = document.createElementNS(SVG, "svg");
        svg.appendChild(filters);
        svg.appendChild(image);
        svg.set("class", className.toString());

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
        image.set("width", width).set("height", height);
        svg.set("width", width).set("height", height);

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
        image.setAttributeNS(XLINK, "xlink:href", src);

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
        return applyFilter(document.createElementNS(SVG, "feColorMatrix").set("type", "matrix")
                .set("values", amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 0 0 0 1 0"));
    }

    /**
     * <p>
     * Apply saturate filter.
     * </p>
     * 
     * @param amount An amount of saturation. (0 ~ 1)
     * @return
     */
    public Image saturate(double amount) {
        return applyFilter(document.createElementNS(SVG, "feColorMatrix").set("type", "saturate").set("values", amount));
    }

    /**
     * <p>
     * Helper method to apply filter.
     * </p>
     * 
     * @param filter
     * @return
     */
    private Image applyFilter(Element filter) {
        // remove filter
        filters.empty();

        // add filter
        filters.appendChild(filter);

        // apply filter
        image.set("filter", "url('#filter" + hashCode() + "')");

        // Chainable API
        return this;
    }

    /**
     * <p>
     * Clip image.
     * </p>
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public Image clip(int x, int y, int width, int height) {
        // apply clip
        image.set("x", "-" + x)
                .set("y", "-" + y)
                .set("width", x + width)
                .set("height", y + height)
                .set("preserveAspectRatio", "xMinYMin slice");

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
        image.remove("filter");

        // Chainable API
        return this;
    }
}
