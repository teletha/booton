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

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @version 2013/08/11 15:10:23
 */
class OperandArray extends Operand {

    /** The operand which indicates the size of this array. */
    private final Operand size;

    /** The flag whether this array is primitive or not. */
    private final boolean isPrimitive;

    /** The array type. */
    private final Class type;

    /** The array dimmension depth. */
    private final int dimmension;

    /** The list of item operands. */
    private final ArrayList<Operand> items = new ArrayList();

    /**
     * <p>
     * Create Array operand.
     * </p>
     * 
     * @param size A initial size.
     * @param isPrimitive An array type.
     */
    OperandArray(Operand size, Class type, boolean isPrimitive) {
        this.size = size.disclose();
        this.type = type;
        this.isPrimitive = isPrimitive;

        int dimmension = 1;

        while (type.isArray()) {
            dimmension++;
            type = type.getComponentType();
        }
        this.dimmension = dimmension;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    InferredType infer() {
        return new InferredType(Array.class);
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
            for (int j = 0; j < i + 2 - items.size(); j++) {
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
        StringBuilder builder = new StringBuilder();

        if (items.size() == 0) {
            // normal
            builder.append("boot.initArray(").append(this.size).append(",");

            if (isPrimitive) {
                builder.append("0");
            } else {
                builder.append("null");
            }
            builder.append(")");
        } else {
            // syntax sugar
            builder.append("[");

            String undefined = isPrimitive ? "0" : "null";
            int requiredSize = Integer.valueOf(this.size.toString()).intValue();

            for (int i = 0; i < requiredSize; i++) {
                if (items.size() <= i) {
                    builder.append(undefined);
                } else {
                    Operand item = items.get(i);

                    if (item == null) {
                        builder.append(undefined);
                    } else {
                        builder.append(item);
                    }
                }

                if (i + 1 != requiredSize) {
                    builder.append(',');
                }
            }
            builder.append("]");
        }

        // API definition
        return "boot.array(" + builder + ",\"" + Javascript.computeSimpleClassName(type) + "\")";
    }
}
