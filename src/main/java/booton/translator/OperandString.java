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
 * @version 2013/04/13 3:11:42
 */
class OperandString extends Operand {

    /** The actual string expression of this operand. */
    final String expression;

    /**
     * Create String operand.
     */
    OperandString(String expression) {
        this.expression = expression.replaceAll("\"", "\\\\\"").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand copy() {
        return new OperandString(expression);
    }

    /**
     * @see booton.translator.Operand#toString()
     */
    @Override
    public String toString() {
        return "\"" + expression + "\"";
    }
}
