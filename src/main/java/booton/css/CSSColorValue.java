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

import booton.util.Color;

/**
 * @version 2012/12/16 12:49:00
 */
public class CSSColorValue<T extends CSSProperty> extends CSSProperty<T> implements Colorable<T> {

    /** The current color value. */
    protected Color color;

    /**
     * 
     */
    public CSSColorValue(String name, T context) {
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
        color = new Color(red, green, blue);

        // Chainable API
        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T color(int red, int green, int blue, double alpha) {
        color = new Color(red, green, blue, alpha);

        // Chainable API
        return chain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T color(String hex) {
        color = new Color(hex);

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

    /** The color keyword. */
    public T transparent() {
        color = null;

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T aqua() {
        color = new Color(0, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T black() {
        color = new Color(0, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T blue() {
        color = new Color(0, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T fuchsia() {
        color = new Color(255, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T gray() {
        color = new Color(128, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T green() {
        color = new Color(0, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T lime() {
        color = new Color(0, 255, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T maroon() {
        color = new Color(128, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T navy() {
        color = new Color(0, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T olive() {
        color = new Color(128, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T orange() {
        color = new Color(255, 165, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T purple() {
        color = new Color(128, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T red() {
        color = new Color(255, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T silver() {
        color = new Color(192, 192, 192);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T teal() {
        color = new Color(0, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T white() {
        color = new Color(255, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public T yellow() {
        color = new Color(255, 255, 0);

        // Chainable API
        return chain();
    }

}
