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

/**
 * @version 2013/04/01 14:10:29
 */
public class Path extends SVGElement {

    /**
     * 
     */
    Path() {
        super("path");
    }

    public Path strokeLineJoin(String type) {
        element.set("stroke-linejoin", type);

        return this;
    }

    public Path strokeWidth(int width) {
        element.set("stroke-width", width);

        return this;
    }

    public Path fill(String color) {
        element.set("fill", color);

        return this;
    }

    public Path stroke(String color) {
        element.set("stroke", color);

        return this;
    }

    public Path line(String path) {
        element.set("d", path);
        // element.set("transform", "matrix(1,0,0,1,4,4)");

        return this;
    }
}
