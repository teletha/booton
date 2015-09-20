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
import java.util.Optional;

import js.lang.NativeArray;
import jsx.collection.DualList;
import kiss.I;

/**
 * <p>
 * This class is CSSStyleRule which represents a single CSS style rule.
 * </p>
 * 
 * @version 2015/09/06 10:58:56
 */
public class StyleRule {

    /** The list of rules. */
    public static final List<StyleRule> holders = new ArrayList();

    /** The selector. */
    public final String selector;

    /** The property list. */
    public final DualList<String, String> properties;

    /** The sub rules. */
    public final NativeArray<StyleRule> children = new NativeArray();

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     */
    public StyleRule() {
        this("");
    }

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param name An actual selector.
     */
    StyleRule(String selector) {
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
    StyleRule(DualList<String, String> properties) {
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
    boolean is(String name, String value) {
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
    void property(String name, List values, String separator, int writeMode, EnumSet<Vendor> prefixes) {
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

                    switch (writeMode) {
                    case 0: // addition
                        this.properties.add(resolvedName, value);
                        break;

                    case 1: // override
                        this.properties.set(resolvedName, value);
                        break;

                    case 2: // append
                        Optional<String> current = this.properties.get(resolvedName);

                        if (current.isPresent()) {
                            this.properties.set(resolvedName, current.get() + separator + value);
                        } else {
                            this.properties.add(resolvedName, value);
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(selector);
        builder.append("{");
        for (int i = 0, size = properties.size(); i < size; i++) {
            builder.append(properties.key(i)).append(":").append(properties.value(i)).append(";");
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * <p>
     * Create {@link StyleRule} from the specified object. (e.g. {@link Style}, {@link RuntimeStyle}
     * )
     * </p>
     * 
     * @param object A style description.
     * @return A create new {@link StyleRule}.
     */
    public static StyleRule create(String template, Style style) {
        // store parent rule
        StyleRule parent = PropertyDefinition.properties;

        // compute selector
        String selector;

        if (parent == null) {
            selector = "." + StyleName.of(style);
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
        StyleRule child = new StyleRule(selector);

        // swap context rule and execute it
        PropertyDefinition.properties = child;
        style.style();
        PropertyDefinition.properties = parent;

        if (parent != null) {
            parent.children.push(child);
        }

        // assign rule
        holders.add(child);

        return child;
    }
}
