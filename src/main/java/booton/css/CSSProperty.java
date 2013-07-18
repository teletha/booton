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

import java.lang.reflect.Field;

import kiss.I;
import booton.util.Strings;

/**
 * @version 2013/06/08 13:29:25
 */
public class CSSProperty<T extends CSSProperty> {

    /** The current processing css rule. */
    protected CSS css;

    /** The flag. */
    boolean used = false;

    /** The property name. */
    protected final String name;

    /** The property value. */
    protected Object value;

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
        if (value instanceof PrefixAwareProperty) {
            writer.property((PrefixAwareProperty) value);
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
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        CSSWriter writer = new CSSWriter();
        write(writer);

        return writer.toString();
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
     * Write {@link PrefixAwareProperty}.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final PrefixAwareProperty valueWithPrefix(String value) {
        return new PrefixAwareProperty(name, value, false, true);
    }

    /**
     * <p>
     * Write {@link PrefixAwareProperty}.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final PrefixAwareProperty nameWithPrefix(String value) {
        return new PrefixAwareProperty(name, value, true, false);
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

}
