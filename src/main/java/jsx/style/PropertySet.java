/*
 * Copyright (C) 2015 Nameless Production Committee
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
import java.util.List;
import java.util.Map.Entry;

import jsx.collection.DualList;
import kiss.I;

/**
 * @version 2014/11/13 15:49:15
 */
public class PropertySet {

    /** The list of rules. */
    public static final List<PropertySet> rules = new ArrayList();

    /** The selector. */
    public final String selector;

    /** The property list. */
    public final DualList<String, String> properties;

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     */
    public PropertySet() {
        this("");
    }

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     */
    PropertySet(String selector) {
        this.selector = selector;
        this.properties = new DualList();
    }

    /**
     * <p>
     * Define style rule.
     * </p>
     *
     * @param name An actual selector.
     */
    PropertySet(DualList<String, String> properties) {
        this.selector = "";
        this.properties = properties;
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
        return properties.contains(name, value);
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

                    String resolvedName = vendor + name;

                    if (override) {
                        this.properties.set(resolvedName, value);
                    } else {
                        this.properties.add(resolvedName, value);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Create {@link PropertySet} from the specified object. (e.g. {@link Style}, {@link RuntimeStyle}
     * )
     * </p>
     * 
     * @param object A style description.
     * @return A create new {@link PropertySet}.
     */
    public static PropertySet create(String template, Style style) {
        // store parent rule
        PropertySet parent = PropertyDefinition.declarable;

        // compute selector
        String selector;

        if (parent == null) {
            selector = "." + StyleId.of(style);
        } else {
            // check pseudo element
            String pseudo;
            int index = parent.selector.indexOf("::");

            if (index == -1) {
                selector = parent.selector;
                pseudo = "";
            } else {
                selector = parent.selector.substring(0, index);
                pseudo = parent.selector.substring(index);
            }
            selector = template.replace("$", selector) + pseudo;
        }

        // create child rule
        PropertySet child = new PropertySet(selector);

        // swap context rule and execute it
        PropertyDefinition.declarable = child;
        style.declare();
        PropertyDefinition.declarable = parent;

        // assign rule
        rules.add(child);

        return child;
    }
}
