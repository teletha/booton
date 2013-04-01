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

import booton.css.CSS;

/**
 * @version 2013/04/01 14:12:07
 */
public class SVG extends SVGElement {

    /**
     * 
     */
    public SVG(Class<? extends CSS> className) {
        super("svg");

        element.add(className);
    }

    public Path path() {
        Path path = new Path();
        element.append(path);

        return path;
    }
}
