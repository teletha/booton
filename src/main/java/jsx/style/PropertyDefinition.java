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
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import booton.util.Strings;
import js.lang.NativeArray;

/**
 * @version 2014/11/13 15:49:09
 */
public class PropertyDefinition<T> {

    /** The current processing property holder. */
    protected static StyleRule properties;

    /** The property name. */
    private final String name;

    /** The context property. */
    private final T context;

    private final EnumSet<Vendor> vendors;

    /**
     * <p>
     * Property definition.
     * </p>
     */
    protected PropertyDefinition() {
        this(null, null);
    }

    /**
     * <p>
     * Property definition.
     * </p>
     */
    protected PropertyDefinition(String name) {
        this(name, null);
    }

    /**
     * <p>
     * Property definition.
     * </p>
     */
    protected PropertyDefinition(String name, T context) {
        this(name, context, Standard);
    }

    /**
     * <p>
     * Property definition.
     * </p>
     */
    protected PropertyDefinition(String name, T context, Vendor... vendors) {
        if (name == null) {
            name = Strings.hyphenate(getClass().getSimpleName());
        }

        if (context == null) {
            context = (T) this;
        }

        this.name = name;
        this.context = context;
        this.vendors = EnumSet.of(Standard, vendors);
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @return Chainable API.
     */
    protected final T value(Object value) {
        return value(name, value);
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @return Chainable API.
     */
    protected final T value(EnumSet<Vendor> vendors, Object value) {
        return value(vendors, name, Arrays.asList(value), " ", 0);
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @return Chainable API.
     */
    protected final T value(String name, int... values) {
        List<String> list = new ArrayList();

        for (int i = 0; i < values.length; i++) {
            list.add(String.valueOf(values[i]));
        }
        return value(name, list, ",");
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @return Chainable API.
     */
    protected final T value(String name, long... values) {
        List<String> list = new ArrayList();

        for (int i = 0; i < values.length; i++) {
            list.add(String.valueOf(values[i]));
        }
        return value(name, list, ",");
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @return Chainable API.
     */
    protected final T value(String name, float... values) {
        List<String> list = new ArrayList();

        for (int i = 0; i < values.length; i++) {
            list.add(String.valueOf(values[i]));
        }
        return value(name, list, ",");
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @return Chainable API.
     */
    protected final T value(String name, double... values) {
        List<String> list = new ArrayList();

        for (int i = 0; i < values.length; i++) {
            list.add(String.valueOf(values[i]));
        }
        return value(name, list, ",");
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param value A property value.
     * @return Chainable API.
     */
    protected final T value(String name, Object value) {
        return value(name, Arrays.asList(value));
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @return Chainable API.
     */
    protected final T value(String name, List values) {
        return value(name, values, " ");
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @param separator A value separator.
     * @return Chainable API.
     */
    protected final T value(String name, List values, String separator) {
        return value(name, values, separator, 0);
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param name A property name.
     * @param values A list of property values.
     * @param separator A value separator.
     * @param writeMode A value write mechanism.
     * @return Chainable API.
     */
    protected final T value(String name, List values, String separator, int writeMode) {
        return value(EnumSet.noneOf(Vendor.class), name, values, separator, writeMode);
    }

    /**
     * <p>
     * Set property.
     * </p>
     * 
     * @param vendors A list of {@link Vendor} for the specified property name.
     * @param name A property name.
     * @param values A list of property values.
     * @param separator A value separator.
     * @param writeMode A value write mechanism.
     * @return Chainable API.
     */
    protected final T value(EnumSet<Vendor> vendors, String name, List values, String separator, int writeMode) {
        vendors.addAll(this.vendors);

        properties.property(name, values, separator, writeMode, vendors);

        return context;
    }

    /**
     * <p>
     * Check the current value.
     * </p>
     * 
     * @param value A property value you want.
     * @return A result.
     */
    protected final boolean is(String value) {
        return properties.is(name, value);
    }

    /**
     * <p>
     * Join all values.
     * </p>
     * 
     * @param images
     * @param index
     * @return
     */
    protected static final <T> String join(T[] items, Function<T, Object> conveter) {
        StringJoiner joiner = new StringJoiner(",");

        for (T item : items) {
            joiner.add(conveter.apply(item).toString());
        }
        return joiner.toString();
    }

    /**
     * <p>
     * Join all values.
     * </p>
     * 
     * @param images
     * @param index
     * @return
     */
    protected static final <T> String join(NativeArray<T> items, Function<T, Object> conveter) {
        StringJoiner joiner = new StringJoiner(",");

        for (int i = 0; i < items.length(); i++) {
            joiner.add(conveter.apply(items.get(i)).toString());
        }
        return joiner.toString();
    }

    /**
     * <p>
     * Join all values.
     * </p>
     * 
     * @param images
     * @param index
     * @return
     */
    protected static final <T> String join(Iterable<T> items, Function<T, Object> conveter) {
        StringJoiner joiner = new StringJoiner(",");

        for (T item : items) {
            joiner.add(conveter.apply(item).toString());
        }
        return joiner.toString();
    }

    /**
     * <p>
     * Create sub rule.
     * </p>
     * 
     * @param template A selector template.
     * @param sub A sub style descriptor.
     */
    protected static final StyleRule createSubRule(String template, Style sub) {
        return StyleRule.create(template, sub);
    }

    /**
     * @version 2014/10/21 15:02:11
     */
    protected static class PrefixAwareProperty {

        /** The name holder. */
        private final EnumMap<Vendor, String> names = new EnumMap(Vendor.class);

        /** The value holder. */
        private final EnumMap<Vendor, String> values = new EnumMap(Vendor.class);

        /** The prefix flag. */
        private boolean namePrefix;

        /** The prefix flag. */
        private boolean valuePrefix;

        /**
         * <p>
         * Set standard property name and value.
         * </p>
         * 
         * @param name
         * @param value
         */
        protected PrefixAwareProperty(String name, String value, boolean namePrefix, boolean valuePrefix) {
            this.namePrefix = namePrefix;
            this.valuePrefix = valuePrefix;

            set(Standard, name, value);
            ie(value);
            moz(value);
            safari(value);
            webkit(value);
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param value
         * @return
         */
        public PrefixAwareProperty ie(String value) {
            return ie(names.get(Standard), value);
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param name
         * @param value
         * @return
         */
        public PrefixAwareProperty ie(String name, String value) {
            set(IE, name, value);

            return this;
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param value
         * @return
         */
        public PrefixAwareProperty moz(String value) {
            return moz(names.get(Standard), value);
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param name
         * @param value
         * @return
         */
        public PrefixAwareProperty moz(String name, String value) {
            set(Mozilla, name, value);

            return this;
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param value
         * @return
         */
        public PrefixAwareProperty safari(String value) {
            return safari(names.get(Standard), value);
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param name
         * @param value
         * @return
         */
        public PrefixAwareProperty safari(String name, String value) {
            set(Safari, name, value);

            return this;
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param value
         * @return
         */
        public PrefixAwareProperty webkit(String value) {
            return webkit(names.get(Standard), value);
        }

        /**
         * <p>
         * Set property name and value.
         * </p>
         * 
         * @param name
         * @param value
         * @return
         */
        public PrefixAwareProperty webkit(String name, String value) {
            set(Webkit, name, value);

            return this;
        }

        /**
         * <p>
         * Omit the specified vendor's properties.
         * </p>
         * 
         * @param vendors
         * @return
         */
        public PrefixAwareProperty omit(Vendor... vendors) {
            for (Vendor vendor : vendors) {
                names.remove(vendor);
                values.remove(vendor);
            }

            return this;
        }

        /**
         * <p>
         * Helper method to construct property name and value pair.
         * </p>
         * 
         * @param vendor
         * @param name
         * @param value
         */
        private void set(Vendor vendor, String name, String value) {
            name = namePrefix ? vendor + name : name;
            value = valuePrefix ? vendor + value : value;

            names.put(vendor, name);
            values.put(vendor, value);
        }

        /**
         * <p>
         * Compact webkit and safari property.
         * </p>
         */
        private void compactWebkit() {
            String webkit = names.get(Webkit) + values.get(Webkit);
            String safari = names.get(Safari) + values.get(Safari);

            if (webkit.equals(safari)) {
                // remove safari property
                omit(Safari);
            }
        }
    }
}
