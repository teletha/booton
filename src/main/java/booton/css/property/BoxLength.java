/*
 * Copyright (C) 2012 Nameless Production Committee
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
import booton.css.Unit;
import booton.css.Value;

/**
 * @version 2012/12/12 10:21:21
 */
public class BoxLength extends CSSProperty<BoxLength> {

    /** The top value. */
    private Value top = new Value();

    /** The right value. */
    private Value right = new Value();

    /** The bottom value. */
    private Value bottom = new Value();

    /** The left value. */
    private Value left = new Value();

    /**
     * @param name
     */
    public BoxLength(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        if (top.equals(right) && top.equals(bottom) && top.equals(left)) {
            writer.property(name, top);
        } else if (top.equals(bottom) && right.equals(left)) {
            writer.property(name, top, right);
        } else if (right.equals(left)) {
            writer.property(name, top, right, bottom);
        } else {
            writer.property(name, top, right, bottom, left);
        }
    }

    /**
     * <p>
     * The margin CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength size(double size, Unit unit) {
        horizontal(size, unit);
        vertical(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public BoxLength auto() {
        right = left = new Auto();

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-top CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength top(double size, Unit unit) {
        top = new Value(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-bottom CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength bottom(double size, Unit unit) {
        bottom = new Value(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-left CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength left(double size, Unit unit) {
        left = new Value(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-right CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength right(double size, Unit unit) {
        right = new Value(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-left and margin-right CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength horizontal(double size, Unit unit) {
        left(size, unit);
        right(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The margin-top and margin-bottom CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength vertical(double size, Unit unit) {
        top(size, unit);
        bottom(size, unit);

        // Chainable API
        return chain();
    }

    private static class Auto extends Value {

        /**
         * @param size
         * @param unit
         */
        public Auto() {
            super(0, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "auto";
        }
    }
}
