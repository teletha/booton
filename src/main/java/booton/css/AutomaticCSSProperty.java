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

import java.lang.reflect.Field;

import kiss.I;

/**
 * @version 2012/12/16 11:24:02
 */
public class AutomaticCSSProperty<T extends CSSProperty> extends CSSProperty<T> {

    /**
     * 
     */
    public AutomaticCSSProperty() {
    }

    /**
     * @param name
     * @param context
     */
    public AutomaticCSSProperty(String name, T context) {
        super(name, context);
    }

    /**
     * @param name
     */
    public AutomaticCSSProperty(String name) {
        super(name);
    }

    /**
     * <p>
     * Write properties automatically.
     * </p>
     * 
     * @param writer
     */
    protected void write(CSSWriter writer) {
        writer.property(name, value);

        try {
            for (Field field : getClass().getDeclaredFields()) {
                if (field.isSynthetic()) {
                    continue; // ignore compiler generated fields
                }

                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                Object value = field.get(this);

                if (value == null) {
                    continue;
                } else if (value instanceof AutomaticCSSProperty) {
                    ((AutomaticCSSProperty) value).write(writer);
                } else {
                    // writer.property(Strings.hyphenate(field.getName()), value);
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
    public String toString() {
        CSSWriter writer = new CSSWriter();
        write(writer);

        return writer.toString();
    }
}
