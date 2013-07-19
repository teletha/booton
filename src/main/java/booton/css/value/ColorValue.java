/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.value;

import booton.css.CSSProperty;
import booton.css.CSSWriter;
import js.util.Color;

/**
 * @version 2013/07/20 4:49:22
 */
public class ColorValue<T extends CSSProperty> extends CSSProperty<T> implements Colorable<T> {

    /** The current color value. */
    protected Color color;

    /**
     * 
     */
    public ColorValue(String name, T context) {
        super(name, context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property(name, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T color(int red, int green, int blue) {
        color = Color.rgb(red, green, blue);

        // Chainable API
        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T color(int red, int green, int blue, double alpha) {
        color = Color.rgba(red, green, blue, alpha);

        // Chainable API
        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T color(Color color) {
        this.color = color;

        // Chainable API
        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color color() {
        return color;
    }

    /** The color keyword. */
    public T transparent() {
        color = Color.Transparent;

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T aqua() {
        color = Color.rgb(0, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T black() {
        color = Color.rgb(0, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T blue() {
        color = Color.rgb(0, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T fuchsia() {
        color = Color.rgb(255, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T gray() {
        color = Color.rgb(128, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T green() {
        color = Color.rgb(0, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T lime() {
        color = Color.rgb(0, 255, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T maroon() {
        color = Color.rgb(128, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T navy() {
        color = Color.rgb(0, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T olive() {
        color = Color.rgb(128, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T orange() {
        color = Color.rgb(255, 165, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T purple() {
        color = Color.rgb(128, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T red() {
        color = Color.rgb(255, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T silver() {
        color = Color.rgb(192, 192, 192);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T teal() {
        color = Color.rgb(0, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T white() {
        color = Color.rgb(255, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T yellow() {
        color = Color.rgb(255, 255, 0);

        // Chainable API
        return chain();
    }
}
