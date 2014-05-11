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

import java.util.EnumSet;

import booton.css.CSSProperty;
import booton.css.CSSWriter;
import booton.css.Unit;
import booton.css.Vendor;
import booton.css.value.Numeric;

/**
 * @version 2013/07/23 20:40:20
 */
public class BoxLength extends CSSProperty<BoxLength> {

    /** The top value. */
    private Numeric top = new Numeric();

    /** The right value. */
    private Numeric right = new Numeric();

    /** The bottom value. */
    private Numeric bottom = new Numeric();

    /** The left value. */
    private Numeric left = new Numeric();

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
     * The margin CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength size(Numeric value) {
        horizontal(value);
        vertical(value);

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
        return top(new Numeric(size, unit));
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
    public BoxLength top(Numeric value) {
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
        return bottom(new Numeric(size, unit));
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
    public BoxLength bottom(Numeric value) {
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
        return left(new Numeric(size, unit));
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
    public BoxLength left(Numeric value) {
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
        return right(new Numeric(size, unit));
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
    public BoxLength right(Numeric value) {
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
     * The margin-left and margin-right CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength horizontal(Numeric value) {
        left(value);
        right(value);

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
     * <p>
     * The margin-top and margin-bottom CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength vertical(Numeric value) {
        top(value);
        bottom(value);

        // Chainable API
        return chain();
    }

    /**
     * @version 2013/07/23 20:39:36
     */
    private static class Auto extends Numeric {

        /**
         * Hide
         */
        private Auto() {
            super("auto");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected EnumSet<Vendor> vendors() {
            return NoVendors;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String valueFor(Vendor vendor) {
            return expression;
        }
    }
}
