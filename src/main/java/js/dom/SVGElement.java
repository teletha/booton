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

/**
 * @version 2013/04/01 13:55:43
 */
public abstract class SVGElement implements Elementable {

    /** SVG namespace uri. */
    private static final String SVG = "http://www.w3.org/2000/svg";

    /** XLink namespace uri. */
    private static final String XLINK = "http://www.w3.org/1999/xlink";

    /** The root element. */
    protected final Element element;

    /**
     * @param svg
     */
    public SVGElement(String name) {
        this.element = document.createElementNS(SVG, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element getElement() {
        return element;
    }
}
