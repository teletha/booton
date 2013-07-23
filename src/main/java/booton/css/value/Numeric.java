/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.value;

import static booton.css.Unit.*;
import static booton.css.Vendor.*;

import java.util.EnumSet;

import booton.css.CSSValue;
import booton.css.Unit;
import booton.css.Vendor;

/**
 * @version 2013/07/23 19:32:10
 */
public class Numeric extends CSSValue {

    /** The zero value. */
    public static final Numeric Zero = new Numeric(0, Unit.px);

    /** The size. */
    public final double size;

    /** The unit. */
    protected final Unit unit;

    /** The expression. */
    protected final String expression;

    /**
     * <p>
     * {@link Numeric} value for zero.
     * </p>
     */
    public Numeric() {
        this(0, px);
    }

    /**
     * <p>
     * {@link Numeric} value.
     * </p>
     * 
     * @param size A numeric size.
     * @param unit A unit.
     */
    public Numeric(double size, Unit unit) {
        this.size = size;
        this.unit = unit == null ? px : unit;
        this.expression = value();
    }

    /**
     * <p>
     * {@link Numeric} value for string expression.
     * </p>
     * 
     * @param expression A string expression.
     */
    protected Numeric(String expression) {
        this.size = 0;
        this.unit = null;
        this.expression = expression;
    }

    /**
     * <p>
     * Addition.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric add(double value) {
        return new Numeric(size + value, unit);
    }

    /**
     * <p>
     * Addition.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric add(Numeric value) {
        if (unit != null && unit == value.unit) {
            return new Numeric(size + value.size, unit);
        } else {
            return new Numeric(expression + " + " + value.expression);
        }
    }

    /**
     * <p>
     * Subtraction.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric subtract(double value) {
        return new Numeric(size - value, unit);
    }

    /**
     * <p>
     * Subtraction.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric subtract(Numeric value) {
        if (unit != null && unit == value.unit) {
            return new Numeric(size - value.size, unit);
        } else {
            return new Numeric(expression + " - " + value.expression);
        }
    }

    /**
     * <p>
     * Multiply.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric multiply(double value) {
        return new Numeric(size * value, unit);
    }

    /**
     * <p>
     * Multiply.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric multiply(Numeric value) {
        if (unit != null && unit == value.unit) {
            return new Numeric(size * value.size, unit);
        } else {
            return new Numeric(expression + " * " + value.expression);
        }
    }

    /**
     * <p>
     * Division.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric divide(double value) {
        return new Numeric(size / value, unit);
    }

    /**
     * <p>
     * Division.
     * </p>
     * 
     * @param value
     * @return
     */
    public Numeric divide(Numeric value) {
        if (unit != null && unit == value.unit) {
            return new Numeric(size / value.size, unit);
        } else {
            return new Numeric(expression + " / " + value.expression);
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public Numeric opposite() {
        return multiply(new Numeric(-1, unit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Numeric) {
            Numeric other = (Numeric) obj;

            return size == other.size && unit == other.unit;
        }

        if (obj instanceof String) {
            return toString().equals(obj);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EnumSet<Vendor> vendors() {
        if (unit == null) {
            return EnumSet.of(Standard, Webkit);
        } else {
            return NoVendors;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String valueFor(Vendor vendor) {
        switch (vendor) {
        case Webkit:
            return vendor.prefix + value();

        default:
            return value();
        }
    }

    /**
     * <p>
     * Helper method to stringize this value.
     * </p>
     * 
     * @return A string expression.
     */
    private String value() {
        if (unit == null) {
            return "calc(" + expression + ")";
        }

        int integer = (int) size;

        if (size == 0) {
            return "0";
        } else if (integer == size) {
            return String.valueOf(integer) + unit;
        } else {
            return String.valueOf(size) + unit;
        }
    }
}
