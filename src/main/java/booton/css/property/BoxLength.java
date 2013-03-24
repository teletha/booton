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
import booton.css.Unit;
import booton.css.Value;

/**
 * @version 2013/03/24 2:06:03
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
    public void write(CSSWriter writer) {
        if (right.equals(left)) {
            if (top.equals(bottom)) {
                if (top.equals(right)) {
                    writer.property(name, top);
                } else {
                    writer.property(name, top, right);
                }
            } else {
                writer.property(name, top, right, bottom);
            }
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
        return top(new Value(size, unit));
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
    public BoxLength top(Value value) {
        top = value;

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
        return bottom(new Value(size, unit));
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
    public BoxLength bottom(Value value) {
        bottom = value;

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
        return left(new Value(size, unit));
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
    public BoxLength left(Value value) {
        left = value;

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
        return right(new Value(size, unit));
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
    public BoxLength right(Value value) {
        right = value;

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

    /**
     * @version 2012/12/16 17:22:30
     */
    private static class Auto extends Value {

        /**
         * Hide
         */
        private Auto() {
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
