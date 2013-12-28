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

import java.util.ArrayList;

/**
 * @version 2013/09/01 20:23:18
 */
class OperandArray extends Operand {

    /** The operand which indicates the size of this array. */
    private final Operand size;

    /** The array type. */
    private final Class type;

    /** The list of item operands. */
    private final ArrayList<Operand> items = new ArrayList();

    /**
     * <p>
     * Create Array operand.
     * </p>
     * 
     * @param size A initial size.
     * @param type A array type.
     */
    OperandArray(Operand size, Class type) {
        this.size = size.disclose();
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    InferredType infer() {
        return new InferredType(type);
    }

    /**
     * <p>
     * Set the value operand to the index operand. This method is used only for syntax sugar of
     * array initialization. So we can compute the actual index value safely.
     * </p>
     * 
     * @param index A index of array. We can compute actual value safely.
     * @param value A value of array.
     */
    void set(Operand index, Operand value) {
        int i = Integer.valueOf(index.toString()).intValue();

        if (items.size() <= i) {
            for (int j = 0; j < i + 2; j++) {
                items.add(null);
            }
        }
        items.set(i, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        Class component = type.getComponentType();
        String undefined = component.isPrimitive() ? component == boolean.class ? "false" : "0" : "null";

        ScriptWriter writer = new ScriptWriter();
        writer.append("boot.array(").string(Javascript.computeSimpleClassName(component)).append(",");

        if (items.size() == 0) {
            // new array with the specified size
            writer.append(size, ",", undefined);
        } else {
            // new array by syntax sugar
            writer.append("[");

            int length = Integer.valueOf(size.toString()).intValue();

            for (int i = 0; i < length; i++) {
                if (items.size() <= i) {
                    writer.append(undefined);
                } else {
                    Operand item = items.get(i);

                    if (item == null) {
                        writer.append(undefined);
                    } else {
                        writer.append(item);
                    }
                }

                if (i + 1 != length) {
                    writer.append(",");
                }
            }
            writer.append("]");
        }
        writer.append(")");

        // API definition
        return writer.toString();
    }
}
