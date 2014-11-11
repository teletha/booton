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
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import kiss.I;

/**
 * @version 2014/11/11 9:47:11
 */
public class StyleRule {

    /** The list of declared rules. */
    private static final List<StyleRule> enables = new ArrayList();

    /** The selector. */
    public final String selector;

    /** The property holder. */
    public final Map<String, String> holder = new HashMap();

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     */
    StyleRule(String selector) {
        this.selector = selector;
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
        return Objects.equals(holder.get(name), value);
    }

    /**
     * <p>
     * Declare the specified property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of whitespace-separated property values.
     */
    public void property(String name, Object... values) {
        property(EnumSet.of(Standard), " ", name, values);
    }

    /**
     * <p>
     * Declare the specified property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of whitespace-separated property values.
     * @param vendors A list of {@link Vendor} prefix if needed.
     */
    public void property(String name, List values, Vendor... vendors) {
        property(EnumSet.of(Standard, vendors), " ", name, values.toArray());
    }

    /**
     * <p>
     * Declare the specified property.
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
                    holder.put(vendor + name, value);
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