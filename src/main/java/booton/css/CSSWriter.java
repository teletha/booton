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

import static booton.css.Vendor.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map.Entry;

import kiss.I;
import booton.BootonConfiguration;

/**
 * @version 2013/07/23 22:25:05
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
     * Write property.
     * </p>
     * 
     * @param name
     * @param values
     * @param vendors
     */
    public void property(String name, List values, Vendor... vendors) {
        property(EnumSet.of(Standard, vendors), " ", name, values.toArray());
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
        property(EnumSet.of(Standard), " ", name, values);
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
        property(EnumSet.of(Standard), ",", name, values);
    }

    /**
     * <p>
     * Helper method to write property.
     * </p>
     * 
     * @param prefixes A list of vendors for property name.
     * @param separator A value separator.
     * @param name A property name.
     * @param values A list of property values.
     */
    private void property(EnumSet<Vendor> prefixes, String separator, String name, Object... values) {
        if (name != null && name.length() != 0 && values != null) {
            EnumMap<Vendor, List<String>> properties = new EnumMap(Vendor.class);

            // calculate dependent vendors
            EnumSet<Vendor> vendors = EnumSet.copyOf(prefixes);

            for (Object value : values) {
                if (value instanceof CSSValue) {
                    vendors.addAll(((CSSValue) value).vendors());
                }
            }

            for (Vendor vendor : vendors) {
                List<String> text = new ArrayList();

                for (Object value : values) {
                    if (value != null) {
                        if (value instanceof CSSValue) {
                            String vendered = ((CSSValue) value).valueFor(vendor);

                            if (vendered != null && vendered.length() != 0) {
                                text.add(vendered);
                            }
                        } else if (value instanceof Number) {
                            Number number = (Number) value;

                            if (number.intValue() == number.doubleValue()) {
                                text.add(String.valueOf(number.intValue()));
                            } else {
                                text.add(number.toString());
                            }
                        } else {
                            String decoded = value.toString();

                            if (decoded != null && decoded.length() != 0) {
                                text.add(decoded);
                            }
                        }
                    }
                }
                properties.put(vendor, text);
            }

            for (Entry<Vendor, List<String>> property : properties.entrySet()) {
                String value = I.join(separator, property.getValue());

                if (value.length() != 0) {
                    Vendor vendor = property.getKey();

                    if (!prefixes.contains(vendor)) {
                        vendor = Standard;
                    }
                    indent().write(vendor + name, ":", value, ";");
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
