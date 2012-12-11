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

import java.net.URI;
import java.net.URISyntaxException;

import kiss.I;

/**
 * @version 2012/12/11 20:25:56
 */
abstract class CSSValue {

    /** The current rule container. */
    protected final CSS css;

    /** The current value. */
    protected String value;

    /**
     * @param css
     */
    protected CSSValue(CSS css) {
        this.css = css;
    }

    /**
     * Helper method to compute size.
     * 
     * @param size
     * @param unit
     * @return
     */
    protected final String compute(double size, Unit unit) {
        int i = (int) size;

        if (size == 0) {
            return "0";
        } else if (i == size) {
            return String.valueOf(i).concat(unit.toString());
        } else {
            return String.valueOf(size).concat(unit.toString());
        }
    }

    /**
     * <p>
     * URI values (Uniform Resource Identifiers, see [RFC3986], which includes URLs, URNs, etc) in
     * this specification are denoted by <uri>. The functional notation used to designate URIs in
     * property values is "url()".
     * </p>
     * 
     * @param url
     * @return
     */
    protected final URI url(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw I.quiet(e);
        }
    }
}
