/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import static jsx.style.value.Unit.*;
import static jsx.style.value.Vendor.*;

import java.util.EnumSet;

import jsx.style.CSSValue;

/**
 * @version 2014/10/28 15:23:14
 */
public class Numeric extends CSSValue {

    /** The zero value. */
    public static final Numeric Zero = new Numeric(0, px);

    /** The numerical value. */
    public static final Numeric Top = new Numeric(0, percent);

    /** The numerical value. */
    public static final Numeric Left = Top;

    /** The numerical value. */
    public static final Numeric Center = new Numeric(50, percent);

    /** The numerical value. */
    public static final Numeric Bottom = new Numeric(100, percent);

    /** The numerical value. */
    public static final Numeric Right = Bottom;

    /** The size. */
    public final double size;

    /** The unit. */
    public final Unit unit;

    /** The expression. */
    protected final String expression;

    /** The flag. */
    private final boolean calculated;

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
     * {@link Numeric} value as number.
     * </p>
     * 
     * @param value A numeric size.
     */
    public Numeric(double size) {
        this(size, null);
    }

    /**
     * <p>
     * {@link Numeric} value.
     * </p>
     * 
     * @param value A numeric size.
     * @param unit A unit.
     */
    public Numeric(double value, Unit unit) {
        if (unit == deg) {
            value = range(0, value, 360);
        }

        this.size = value;
        this.unit = unit;
        this.expression = value();
        this.calculated = false;
    }

    /**
     * Helper method to check range.
     * 
     * @param min
     * @param value
     * @param max
     * @return
     */
    private static double range(double min, double value, double max) {
        return value < min ? value + max : max < value ? value - max : value;
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
        this.calculated = true;
    }

    /**
     * <p>
     * Copy {@link Numeric} value.
     * </p>
     * 
     * @param numeric A valut to copy..
     */
    protected Numeric(Numeric numeric) {
        this.size = numeric.size;
        this.unit = numeric.unit;
        this.expression = numeric.expression;
        this.calculated = numeric.calculated;
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
        if (unit == value.unit) {
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
        if (unit == value.unit) {
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
        if (unit == value.unit) {
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
        if (unit == value.unit) {
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
        if (calculated) {
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
        if (!calculated) {
            vendor = Standard;
        }
        return vendor + value();
    }

    /**
     * <p>
     * Helper method to stringize this value.
     * </p>
     * 
     * @return A string expression.
     */
    private String value() {
        if (calculated) {
            return "calc(" + expression + ")";
        }

        int integer = (int) size;

        if (size == 0) {
            return "0";
        } else if (integer == size) {
            return String.valueOf(integer) + (unit == null ? "" : unit);
        } else {
            return String.valueOf(size) + (unit == null ? "" : unit);
        }
    }
}
