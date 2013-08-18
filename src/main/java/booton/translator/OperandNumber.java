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
 * @version 2013/08/15 16:07:23
 */
class OperandNumber extends Operand {

    /** The actual value of this operand. */
    final Number value;

    /**
     * 
     */
    OperandNumber(Number value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    InferredType infer() {
        return new InferredType(Number.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Operand cast(Class type) {
        if (type == char.class) {
            return new OperandString(String.valueOf((char) value.intValue()));
        }
        return super.cast(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
