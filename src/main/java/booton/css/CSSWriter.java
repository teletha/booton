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
import booton.BootonConfiguration;

/**
 * @version 2013/07/21 15:10:33
 */
public class CSSWriter {

    private static final String[] specials = {"linear-gradient"};

    /** The optimization flag. */
    private final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The actual builder. */
    private final StringBuilder builder = new StringBuilder();

    /**
     * <p>
     * Write comment for debug.
     * </p>
     * 
     * @param comment A comment.
     * @return Chainable API.
     */
    public CSSWriter comment(Object comment) {
        if (!config.optimization) {
            builder.append("/* ").append(comment).append(" */");
            line();
        }
        return this;
    }

    /**
     * <p>
     * Formt line for debug.
     * </p>
     * 
     * @return Chainable API.
     */
    public CSSWriter line() {
        if (!config.optimization) {
            builder.append("\r\n");
        }
        return this;
    }

    /**
     * <p>
     * Formt indent for debug.
     * </p>
     * 
     * @return Chainable API.
     */
    public CSSWriter indent() {
        if (!config.optimization) {
            builder.append("  ");
        }
        return this;
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
     * Write property with the specified vendor.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @param vendor A vendor type.
     */
    public void property(String name, Object value, Vendor vendor) {
        propertyWithPrefix(name, value, vendor);
        property(name, value);
    }

    /**
     * <p>
     * Write property with the specified vendor.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @param vendor A vendor type.
     */
    public void property(String name, Object value, Vendor vendor1, Vendor vendor2) {
        propertyWithPrefix(name, value, vendor1);
        propertyWithPrefix(name, value, vendor2);
        property(name, value);
    }

    /**
     * <p>
     * Helper method to write vender prefixed property.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @param vendor A vendor type.
     */
    private void propertyWithPrefix(String name, Object value, Vendor vendor) {
        if (vendor != null) {
            property(vendor.prefix + name, value);
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
                indent().write(name, ":", value, ";");
            } else if (name.charAt(0) == '-') {
                int index = name.indexOf('-', 1);
                String prefix = name.substring(0, index + 1);

                indent().write(name, ":", prefix + value, ";");
            } else {
                for (Vendor vendor : Vendor.values()) {
                    indent().write(name, ":", vendor.prefix + value, ";");
                }
            }
        }
    }

    /**
     * <p>
     * Helper method to write css.
     * </p>
     * 
     * @param params
     * @return Chainable API.
     */
    public CSSWriter write(String... params) {
        for (String param : params) {
            if (param != null) {
                if (!config.optimization) {
                    switch (param) {
                    case "{":
                        builder.append(" ");
                        break;
                    }
                }

                builder.append(param);

                if (!config.optimization) {
                    switch (param) {
                    case ":":
                        builder.append(" ");
                        break;

                    case ";":
                    case "{":
                        line();
                        break;

                    case "}":
                        line().line();
                        break;
                    }
                }
            }
        }
        return this;
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
