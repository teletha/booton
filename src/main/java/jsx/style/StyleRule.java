/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import static jsx.style.Vendor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map.Entry;

import kiss.I;
import kiss.Table;

/**
 * @version 2014/11/13 15:49:15
 */
public class StyleRule {

    /** The list of declared rules. */
    private static final List<StyleRule> enables = new ArrayList();

    /** The selector. */
    public final String selector;

    /** The parent style sheet. */
    public final StyleSheet sheet;

    /** The property holder. */
    public final Table<String, String> holder = new Table();

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     * @param sheet A parent style sheet.
     */
    StyleRule(String selector, StyleSheet sheet) {
        this.selector = selector;
        this.sheet = sheet;
    }

    /**
     * <p>
     * Check the current value.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value you want.
     * @return
     */
    public boolean is(String name, String value) {
        List<String> values = holder.get(name);

        if (values.size() == 0) {
            return false;
        }
        return values.contains(value);
    }

    /**
     * <p>
     * Declare the specified property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @param separator A value separator.
     * @param override A flag for property override.
     * @param prefixes A list of vendors for property name.
     */
    void property(String name, List values, String separator, boolean override, EnumSet<Vendor> prefixes) {
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

                    if (override) {
                        holder.put(vendor + name, Arrays.asList(value));
                    } else {
                        holder.push(vendor + name, value);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Enable this rule.
     * </p>
     */
    public void enable() {
        if (!enables.contains(this)) {
            enables.add(this);
        }
    }

    /**
     * <p>
     * Disable this rule.
     * </p>
     */
    public void disable() {
        if (enables.contains(this)) {
            enables.remove(this);
        }
    }
}