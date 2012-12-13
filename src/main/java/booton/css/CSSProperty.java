/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import java.net.URI;
import java.net.URISyntaxException;

import kiss.I;
import booton.util.Strings;

/**
 * @version 2012/12/12 14:00:09
 */
public abstract class CSSProperty<T extends CSSProperty> {

    /** The flag. */
    boolean used = false;

    /** The property name. */
    protected final String name;

    /** The property value. */
    private String value;

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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property(name, value);
    }

    /**
     * <p>
     * Write css property.
     * </p>
     * 
     * @param name
     * @param value
     */
    protected final String property(String name, Object value) {
        if (value != null) {
            return property(name, value.toString());
        }
        return "";
    }

    /**
     * <p>
     * Write this property.
     * </p>
     * 
     * @param writer
     */
    protected void write(CSSWriter writer) {

    }

    /**
     * <p>
     * Write css property.
     * </p>
     * 
     * @param name
     * @param value
     */
    protected final String property(String name, String value) {
        if (name != null && name.length() != 0 && value != null && value.length() != 0) {
            return name + ":" + value + ";";
        }
        return "";
    }

    /**
     * <p>
     * Write css property.
     * </p>
     * 
     * @param name
     * @param value
     */
    protected final String property(String name, String... values) {
        StringBuilder out = new StringBuilder();

        if (name != null && name.length() != 0) {
            out.append(name).append(':');

            for (String value : values) {
                if (value != null && value.length() != 0) {
                    if (out.charAt(out.length() - 1) != ':') {
                        out.append(' ');
                    }
                    out.append(value);
                }
            }
            out.append(';');
        }

        return out.toString();
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @return
     */
    protected final T chain() {
        return chain(null);
    }

    /**
     * <p>
     * Make chainable API.
     * </p>
     * 
     * @return
     */
    protected final T chain(String value) {
        this.value = value;
        this.context.used = true;

        return context;
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
    protected final URI url(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw I.quiet(e);
        }
    }

}
