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

import java.util.ArrayList;
import java.util.List;

import kiss.I;

/**
 * @version 2012/12/13 16:20:21
 */
public class CSSWriter {

    private static final String[] prefixies = {"-webkit-", "-ms-", "-o-", "-moz-", ""};

    private static final String[] specials = {"linear-gradient"};

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
    public void propertyWithPrefix(String name, Object value) {
        if (value != null) {
            for (String prefix : prefixies) {
                property(prefix + name, value.toString());
            }
        }
    }

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param name
     * @param calcurated
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
     * @param calcurated
     */
    public void property(String name, List values) {
        List<String> list = new ArrayList();

        for (Object value : values) {
            if (value != null) {
                list.add(value.toString());
            }
        }
        property(name, I.join(list, ","));
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
            if (!isSpecialValue(value)) {
                builder.append(name).append(":").append(value).append("; ");
            } else if (name.charAt(0) == '-') {
                int index = name.indexOf('-', 1);
                String prefix = name.substring(0, index + 1);

                builder.append(name).append(":").append(prefix + value).append("; ");
            } else {
                for (String prefix : prefixies) {
                    builder.append(name).append(":").append(prefix + value).append("; ");
                }
            }
        }
    }

    /**
     * <p>
     * Check special property value.
     * </p>
     * 
     * @param value
     * @return
     */
    private boolean isSpecialValue(String value) {
        for (String special : specials) {
            if (value.startsWith(special)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}
