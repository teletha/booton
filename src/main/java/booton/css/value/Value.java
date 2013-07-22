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

import booton.css.Unit;

/**
 * @version 2013/07/20 4:48:50
 */
public class Value {

    /** The zero value. */
    public static final Value Zero = new Value(0, Unit.px);

    /** The size. */
    public final double size;

    /** The unit. */
    public final Unit unit;

    /** The expression. */
    private String expression;

    /**
     * Zero size.
     */
    public Value() {
        this.size = 0;
        this.unit = Unit.px;
    }

    /**
     * @param size
     * @param unit
     */
    public Value(double size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    /**
     * @param expression
     */
    private Value(String expression) {
        this.expression = expression;
        this.size = 0;
        this.unit = null;
    }

    /**
     * <p>
     * Addition.
     * </p>
     * 
     * @param value
     * @return
     */
    public Value add(double value) {
        return new Value(size + value, unit);
    }

    /**
     * <p>
     * Addition.
     * </p>
     * 
     * @param value
     * @return
     */
    public Value add(Value value) {
        if (unit != null && unit == value.unit) {
            return new Value(size + value.size, unit);
        } else {
            return new Value(toExpression() + " + " + value.toExpression());
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
    public Value subtract(double value) {
        return new Value(size - value, unit);
    }

    /**
     * <p>
     * Subtraction.
     * </p>
     * 
     * @param value
     * @return
     */
    public Value subtract(Value value) {
        if (unit != null && unit == value.unit) {
            return new Value(size - value.size, unit);
        } else {
            return new Value(toExpression() + " - " + value.toExpression());
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
    public Value multiply(double value) {
        return new Value(size * value, unit);
    }

    /**
     * <p>
     * Multiply.
     * </p>
     * 
     * @param value
     * @return
     */
    public Value multiply(Value value) {
        if (unit != null && unit == value.unit) {
            return new Value(size * value.size, unit);
        } else {
            return new Value(toExpression() + " * " + value.toExpression());
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
    public Value divide(double value) {
        return new Value(size / value, unit);
    }

    /**
     * <p>
     * Division.
     * </p>
     * 
     * @param value
     * @return
     */
    public Value divide(Value value) {
        if (unit != null && unit == value.unit) {
            return new Value(size / value.size, unit);
        } else {
            return new Value(toExpression() + " / " + value.toExpression());
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public Value opposite() {
        return multiply(new Value(-1, unit));
    }

    /**
     * @return
     */
    private String toExpression() {
        if (expression == null) {
            return toString();
        } else {
            return expression;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (unit == null) {
            return "calc(" + expression + ")";
        }

        int i = (int) size;

        if (size == 0) {
            return "0";
        } else if (i == size) {
            return String.valueOf(i).concat(unit.toString());
        } else {
            return String.valueOf(size).concat(unit.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Value) {
            Value other = (Value) obj;

            return size == other.size && unit == other.unit;
        }

        if (obj instanceof String) {
            return toString().equals(obj);
        }
        return false;
    }
}
