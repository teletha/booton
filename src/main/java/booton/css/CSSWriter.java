/*
 * Copyright (C) 2013 Nameless Production Committee
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
 * @version 2013/06/08 13:29:18
 */
public class CSSWriter {

    private static final String[] specials = {"linear-gradient"};

    /** The actual builder. */
    private final StringBuilder builder = new StringBuilder();

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param property
     */
    public void property(VendorPrefixCSSProperty property) {
        for (String[] values : property.values()) {
            property(values[0], values[1]);
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
            for (VendorPrefix vendor : VendorPrefix.values()) {
                property(vendor.prefix + name, value.toString());
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
                for (VendorPrefix vendor : VendorPrefix.values()) {
                    builder.append(name).append(":").append(vendor.prefix + value).append("; ");
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
