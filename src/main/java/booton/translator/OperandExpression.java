/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

/**
 * @version 2013/09/28 8:48:19
 */
class OperandExpression extends Operand {

    /** The actual string expression of this operand. */
    private Object expression;

    /** The inferred type. */
    private final InferredType type;

    /**
     * 
     */
    OperandExpression(Object expression) {
        this(expression, Object.class);
    }

    /**
     * 
     */
    OperandExpression(Object expression, Class type) {
        this(expression, new InferredType(type));
    }

    /**
     * 
     */
    OperandExpression(Object expression, InferredType type) {
        this.expression = expression;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    InferredType infer() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand invert() {
        if (expression != null) {
            if (expression instanceof Operand) {
                ((Operand) expression).invert();
            } else {
                String value = expression.toString();

                if (!value.contains("=")) {
                    if (value.charAt(0) == '(') {
                        expression = "!".concat(value);
                    } else if (value.charAt(0) == '!') {
                        expression = value.substring(1);
                    }
                }
            }
        }

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand disclose() {
        if (expression != null) {
            if (expression instanceof Operand) {
                ((Operand) expression).disclose();
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand cast(Class type) {
        if (type == char.class && this.type.type() == Number.class) {
            return new OperandExpression("String.fromCharCode(" + this + ")", type);
        }
        return super.cast(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return expression == null ? null : expression.toString();
    }
}
