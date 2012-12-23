/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

/**
 * @version 2012/12/23 11:00:10
 */
class OperandString extends Operand {

    /** The actual string expression of this operand. */
    final String expression;

    /**
     * Create String operand.
     */
    OperandString(String expression) {
        this.expression = expression;
    }

    /**
     * @see booton.translator.Operand#toString()
     */
    @Override
    public String toString() {
        return "\"" + expression + "\"";
    }
}
