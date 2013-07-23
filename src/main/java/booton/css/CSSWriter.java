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
 * @version 2013/07/23 17:14:15
 */
public class CSSWriter {

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
     * @param values
     */
    public void property(String name, List values) {
        property(name, values.toArray());
    }

    /**
     * <p>
     * Write property with separator.
     * </p>
     * 
     * @param name
     * @param values
     */
    public void propertyWithSeparator(String name, List values) {
        propertyWithSeparator(name, values.toArray());
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
        property(" ", name, values);
    }

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param name
     * @param calcurated
     */
    public void propertyWithSeparator(String name, Object... values) {
        property(",", name, values);
    }

    /**
     * <p>
     * Write property.
     * </p>
     * 
     * @param separator
     * @param name
     * @param values
     */
    private void property(String separator, String name, Object... values) {
        if (name != null && name.length() != 0 && values != null) {
            List<List<String>> container = new ArrayList();

            boolean has = false;

            root: for (Vendor vendor : Vendor.values()) {
                List<String> list = new ArrayList();

                for (Object value : values) {
                    if (value != null) {
                        if (value instanceof VendorPrefixValue) {
                            has = true;

                            String vendered = ((VendorPrefixValue) value).toString(vendor);

                            if (vendered == null) {
                                continue root;
                            } else {
                                list.add(vendered);
                            }
                        } else if (value instanceof Double) {
                            Double d = (Double) value;

                            if (d.intValue() == d.doubleValue()) {
                                list.add(String.valueOf(d.intValue()));
                            } else {
                                list.add(d.toString());
                            }
                        } else {
                            String decoded = value.toString();

                            if (decoded != null && decoded.length() != 0) {
                                list.add(decoded);
                            }
                        }
                    }
                }
                container.add(list);

                if (!has) {
                    break;
                }
            }

            for (List<String> text : container) {
                String value = I.join(text, separator);

                if (value.length() != 0) {
                    indent().write(name, ":", value, ";");
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}
