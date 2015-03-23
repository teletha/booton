/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.lang.NativeString;

/**
 * @version 2015/03/23 11:41:17
 */
public class SVG extends VirtualElement {

    /**
     * @param id
     * @param name
     */
    private SVG(int id, String name) {
        super(id, "s:svg");
    }

    public Root svg() {
        return new Root();
    }

    protected Path path() {
        return new Path();
    }

    /**
     * @version 2015/03/23 11:44:25
     */
    public class Root {

    }

    /**
     * @version 2015/03/23 11:44:44
     */
    public class Path {

        /** The value builder. */
        private NativeString builder = new NativeString();

        /**
         * <p>
         * Set the start position to draw.
         * </p>
         * 
         * @param x A horizontal position.
         * @param y A vertical position.
         * @return Chainable API.
         */
        protected Path start(int x, int y) {
            builder = builder.concat(" M ").concat(x).concat(" ").concat(y);

            return this;
        }

        /**
         * <p>
         * Draw line to the specified position.
         * </p>
         * 
         * @param x A horizontal position.
         * @param y A vertical position.
         * @return Chainable API.
         */
        protected Path line(int x, int y) {
            builder = builder.concat(" L ").concat(x).concat(" ").concat(y);

            return this;
        }

        /**
         * <p>
         * Draw horizontal line to the specified position.
         * </p>
         * 
         * @param x A horizontal position.
         * @return Chainable API.
         */
        protected Path hline(int x) {
            builder = builder.concat(" H ").concat(x);

            return this;
        }

        /**
         * <p>
         * Draw vertical line to the specified position.
         * </p>
         * 
         * @param y A vertical position.
         * @return Chainable API.
         */
        protected Path vline(int y) {
            builder = builder.concat(" V ").concat(y);

            return this;
        }

        /**
         * <p>
         * Close the current path.
         * </p>
         * 
         * @return Chainable API.
         */
        protected Path end() {
            builder = builder.concat(" Z");

            return this;
        }

        /**
         * <p>
         * Draw cubic Bézier curve to the path. It requires three points. The first two points are
         * control points and the third one is the end point. The starting point is the last point
         * in the current path, which can be changed using moveTo() before creating the Bézier
         * curve.
         * </p>
         * 
         * @param cp1x The x axis of the coordinate for the first control point.
         * @param cp1y The y axis of the coordinate for first control point.
         * @param cp2x The x axis of the coordinate for the second control point.
         * @param cp2y The y axis of the coordinate for the second control point.
         * @param x The x axis of the coordinate for the end point.
         * @param y The y axis of the coordinate for the end point.
         * @return Chainable API.
         */
        protected Path bezierCurveTo(int cp1x, int cp1y, int cp2x, int cp2y, int x, int y) {
            builder = builder.concat(" C ")
                    .concat(cp1x)
                    .concat(" ")
                    .concat(cp1y)
                    .concat(" ")
                    .concat(cp2x)
                    .concat(" ")
                    .concat(cp2y)
                    .concat(" ")
                    .concat(x)
                    .concat(" ")
                    .concat(x);

            return this;
        }
    }
}
