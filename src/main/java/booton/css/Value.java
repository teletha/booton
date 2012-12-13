/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/13 15:12:37
 */
public class Value {

    /** The size. */
    public final double size;

    /** The unit. */
    public final Unit unit;

    /**
     * @param size
     * @param unit
     */
    public Value(double size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        int i = (int) size;

        if (size == 0) {
            return "0";
        } else if (i == size) {
            return String.valueOf(i).concat(unit.toString());
        } else {
            return String.valueOf(size).concat(unit.toString());
        }
    }
}
