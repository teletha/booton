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
 * @version 2013/08/03 2:18:38
 */
class OperandEnclose extends Operand {

    /** The value operand. */
    private final Operand value;

    /**
     * @param value
     */
    OperandEnclose(Operand value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand invert() {
        value.invert();

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "(" + value + ")";
    }
}
