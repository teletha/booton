/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2015/03/23 16:59:38
 */
public class Stroke extends Colorable<Stroke> {

    /**
     * <p>
     * ‘stroke-linecap’ specifies the shape to be used at the end of open subpaths when they are
     * stroked. For further details see the path implementation notes.
     * </p>
     */
    public final LineCap linecap = new LineCap();

    /**
     * <p>
     * ‘stroke-linejoin’ specifies the shape to be used at the corners of paths or basic shapes when
     * they are stroked. For further details see the path implementation notes.
     * </p>
     */
    public final LineJoin linejoin = new LineJoin();

    public final Width width = new Width();

    /**
     * {@inheritDoc}
     */
    @Override
    public Stroke color(Color color) {
        value("stroke", color.toString());

        return this;
    }

    /**
     * @param width
     * @param unit
     * @return
     */
    public Stroke width(double width, Unit unit) {
        return width(new Numeric(width, unit));
    }

    /**
     * @param value
     * @return
     */
    public Stroke width(Numeric value) {
        return this.width.set(value);
    }

    /**
     * <p>
     * ‘stroke-dasharray’ controls the pattern of dashes and gaps used to stroke paths.
     * <dasharray> contains a list of comma and/or white space separated <length>s and <percentage>s
     * that specify the lengths of alternating dashes and gaps. If an odd number of values is
     * provided, then the list of values is repeated to yield an even number of values. Thus,
     * stroke-dasharray: 5,3,2 is equivalent to stroke-dasharray: 5,3,2,5,3,2.
     * </p>
     * 
     * @param sizes A list of comma and/or white space separated <length>s (which can have a unit
     *            identifier) and <percentage>s. A percentage represents a distance as a percentage
     *            of the current viewport (see Units). A negative value is an error (see Error
     *            processing). If the sum of the values is zero, then the stroke is rendered as if a
     *            value of none were specified. For further details see the path implementation
     *            notes.
     * @return Chainable API.
     */
    public Stroke dashArray(double... sizes) {
        return value("stroke-dasharray", sizes);
    }

    /**
     * <p>
     * ‘stroke-dashoffset’ specifies the distance into the dash pattern to start the dash.
     * </p>
     * 
     * @param offset
     * @return
     */
    public Stroke dashOffset(double offset) {
        return value("stroke-dashoffset", offset);
    }

    public Stroke miterLimit(int size) {
        return value("stroke-miterlimit", size);
    }

    /**
     * @version 2015/03/23 17:03:00
     */
    public class Width extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private Width() {
            super("stroke-width", Stroke.this);
        }

        /**
         * <p>
         * Set numerical value.
         * </p>
         * 
         * @param value
         * @return
         */
        private Stroke set(Numeric value) {
            return value(value.toString());
        }
    }

    /**
     * <p>
     * ‘stroke-linecap’ specifies the shape to be used at the end of open subpaths when they are
     * stroked. For further details see the path implementation notes.
     * </p>
     * 
     * @version 2015/03/23 17:08:30
     */
    public class LineCap extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private LineCap() {
            super("stroke-linecap", Stroke.this);
        }

        /**
         * <p>
         * Normal.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke butt() {
            return value("butt");
        }

        /**
         * <p>
         * Rounded corner.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke round() {
            return value("round");
        }

        /**
         * <p>
         * Append square area.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke square() {
            return value("square ");
        }
    }

    /**
     * <p>
     * ‘stroke-linejoin’ specifies the shape to be used at the corners of paths or basic shapes when
     * they are stroked. For further details see the path implementation notes.
     * </p>
     * 
     * @version 2015/03/23 17:08:30
     */
    public class LineJoin extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private LineJoin() {
            super("stroke-linejoin", Stroke.this);
        }

        /**
         * <p>
         * Normal.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke miter() {
            return value("miter");
        }

        /**
         * <p>
         * Rounded corner.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke round() {
            return value("round");
        }

        /**
         * <p>
         * Bevel.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke bevel() {
            return value("bevel  ");
        }
    }
}
