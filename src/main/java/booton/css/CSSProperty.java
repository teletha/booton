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

import java.lang.reflect.Field;
import java.util.EnumMap;

import kiss.I;
import booton.util.Strings;

/**
 * @version 2014/10/20 16:18:05
 */
public class CSSProperty<T extends CSSProperty> {

    /** The current processing css rule. */
    protected CSS css;

    /** The flag. */
    boolean used = false;

    /** The property name. */
    protected final String name;

    /** The property value. */
    private Object value;

    /** The API context. */
    private T context;

    /**
     * Create with default name.
     */
    protected CSSProperty() {
        this(null);
    }

    /**
     * Create with name.
     * 
     * @param name
     */
    protected CSSProperty(String name) {
        this(name, null);
    }

    /**
     * Create with name.
     * 
     * @param name
     * @param context
     */
    protected CSSProperty(String name, T context) {
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
     * Write properties automatically.
     * </p>
     * 
     * @param writer
     */
    protected void write(CSSWriter writer) {
        if (value instanceof Property) {
            Property property = (Property) value;
            property.compactWebkit();

            for (Vendor vendor : Vendor.values()) {
                String name = property.names.get(vendor);

                if (name != null) {
                    writer.property(name, property.values.get(vendor));
                }
            }
        } else {
            writer.property(name, value);
        }

        try {
            for (Field field : getClass().getDeclaredFields()) {
                if (field.isSynthetic()) {
                    continue; // ignore compiler generated fields
                }

                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                Object value = field.get(this);

                if (value instanceof CSSProperty) {
                    ((CSSProperty) value).write(writer);
                }
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @return
     */
    protected final T chain() {
        this.context.used = true;

        return context;
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @return
     */
    protected final T chain(Object value) {
        this.value = value;
        this.context.used = true;

        return context;
    }

    /**
     * <p>
     * Write {@link Property}.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final Property prefixValue(String value) {
        return new Property(name, value, false, true);
    }

    /**
     * <p>
     * Write {@link Property}.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final Property prefixName(String value) {
        return new Property(name, value, true, false);
    }

    /**
     * Helper method to compute size.
     * 
     * @param size
     * @param unit
     * @return
     */
    protected final String compute(double size, Unit unit) {
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
     * <p>
     * URI values (Uniform Resource Identifiers, see [RFC3986], which includes URLs, URNs, etc) in
     * this specification are denoted by <uri>. The functional notation used to designate URIs in
     * property values is "url()".
     * </p>
     * 
     * @param url
     * @return
     */
    protected final String url(String url) {
        return "url(\"" + url + "\")";
    }

    /**
     * <p>
     * Test value.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final boolean match(Object value) {
        if (this.value == null) {
            return value == null;
        }
        return this.value.equals(value);
    }

    /**
     * @version 2013/07/20 4:33:40
     */
    protected static class Property {

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
        protected Property(String name, String value, boolean namePrefix, boolean valuePrefix) {
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
        public Property ie(String value) {
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
        public Property ie(String name, String value) {
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
        public Property moz(String value) {
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
        public Property moz(String name, String value) {
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
        public Property safari(String value) {
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
        public Property safari(String name, String value) {
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
        public Property webkit(String value) {
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
        public Property webkit(String name, String value) {
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
        public Property omit(Vendor... vendors) {
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
