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

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import booton.css.Unit;
import booton.util.Strings;

/**
 * @version 2014/10/21 13:47:52
 */
public class PropertyDefinition<T> {

    protected static EnumSet<Vendor> vendors = EnumSet.allOf(Vendor.class);

    /** The current processing property holder. */
    protected static StyleRule declarable;

    /** The property name. */
    private final String name;

    /** The context property. */
    private final T context;

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
        if (name == null) {
            name = Strings.hyphenate(getClass().getSimpleName());
        }

        if (context == null) {
            context = (T) this;
        }

        this.name = name;
        this.context = context;
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final T value(Object value) {
        return value(name, value);
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final T value(String name, Object value) {
        declarable.property(name, value);

        return context;
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final T value(String name, List list) {
        StringJoiner joiner = new StringJoiner(" ");

        for (Object item : list) {
            joiner.add(item.toString());
        }

        return value(name, joiner);
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
        return declarable.is(name, value);
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
    protected static final <T> String join(Iterable<T> items, Function<T, Object> conveter) {
        StringJoiner joiner = new StringJoiner(",");

        for (T item : items) {
            joiner.add(conveter.apply(item).toString());
        }
        return joiner.toString();
    }

    /**
     * Helper method to compute size.
     * 
     * @param size
     * @param unit
     * @return
     */
    protected static final String compute(double size, Unit unit) {
        int i = (int) size;

        if (size == 0) {
            return "0";
        } else if (i == size) {
            return String.valueOf(i).concat(unit.toString());
        } else {
            return String.valueOf(size).concat(unit.toString());
        }
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
