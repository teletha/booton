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

import java.util.List;

import js.util.ArrayList;
import kiss.I;

/**
 * @version 2012/12/13 16:20:21
 */
public class CSSWriter {

    /** The actual builder. */
    private final StringBuilder builder = new StringBuilder();

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param name
     * @param value
     */
    public void property(String name, Object value) {
        if (value != null) {
            property(name, value.toString());
        }
    }

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param name
     * @param value
     */
    public void property(String name, Object... values) {
        List<String> list = new ArrayList();

        for (Object value : values) {
            if (value != null) {
                list.add(value.toString());
            }
        }
        property(name, I.join(list, " "));
    }

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param name
     * @param value
     */
    public void property(String name, String value) {
        if (name != null && name.length() != 0 && value != null && value.length() != 0) {
            builder.append(name).append(":").append(value).append("; ");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}
