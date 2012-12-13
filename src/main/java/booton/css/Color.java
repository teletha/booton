/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use (T) this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import booton.util.RGB;

/**
 * @version 2012/12/11 23:43:07
 */
public class Color<T extends CSSProperty> extends CSSProperty<T> {

    /** The current color value. */
    protected RGB color;

    /**
     * 
     */
    public Color() {
    }

    /**
     * 
     */
    public Color(String name) {
        super(name);
    }

    /**
     * 
     */
    public Color(String name, T context) {
        super(name, context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property(name, color == null ? "transparent" : color.toString());
    }

    /**
     * <p>
     * The format of an RGB value in the functional notation is 'rgb(' followed by a comma-separated
     * list of three numerical values (either three integer values or three percentage values)
     * followed by ')'. The integer value 255 corresponds to 100%, and to F or FF in the hexadecimal
     * notation: rgb(255,255,255) = rgb(100%,100%,100%) = #FFF. White space characters are allowed
     * around the numerical values.
     * </p>
     * 
     * @param red
     * @param green
     * @param blue
     */
    private final RGB color(int red, int green, int blue) {
        return new RGB(red, green, blue);
    }

    /** The color keyword. */
    public final T transparent() {
        color = null;

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The format of an RGB value in the functional notation is 'rgb(' followed by a comma-separated
     * list of three numerical values (either three integer values or three percentage values)
     * followed by ')'. The integer value 255 corresponds to 100%, and to F or FF in the hexadecimal
     * notation: rgb(255,255,255) = rgb(100%,100%,100%) = #FFF. White space characters are allowed
     * around the numerical values.
     * </p>
     * 
     * @param red
     * @param green
     * @param blue
     */
    public final T rgb(int red, int green, int blue) {
        color = color(red, green, blue);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The format of an RGB value in the functional notation is 'rgb(' followed by a comma-separated
     * list of three numerical values (either three integer values or three percentage values)
     * followed by ')'. The integer value 255 corresponds to 100%, and to F or FF in the hexadecimal
     * notation: rgb(255,255,255) = rgb(100%,100%,100%) = #FFF. White space characters are allowed
     * around the numerical values.
     * </p>
     * 
     * @param red
     * @param green
     * @param blue
     */
    public final T rgba(int red, int green, int blue, double alpha) {
        color = new RGB(red, green, blue, alpha);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The format of an RGB value in the functional notation is 'rgb(' followed by a comma-separated
     * list of three numerical values (either three integer values or three percentage values)
     * followed by ')'. The integer value 255 corresponds to 100%, and to F or FF in the hexadecimal
     * notation: rgb(255,255,255) = rgb(100%,100%,100%) = #FFF. White space characters are allowed
     * around the numerical values.
     * </p>
     * 
     * @param value
     * @return
     */
    public final T hex(String value) {
        color = new RGB(value);

        return chain();
    }

    /** The color keyword. */
    public final T aqua() {
        color = color(0, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T black() {
        color = color(0, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T blue() {
        color = color(0, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T fuchsia() {
        color = color(255, 0, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T gray() {
        color = color(128, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T green() {
        color = color(0, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T lime() {
        color = color(0, 255, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T maroon() {
        color = color(128, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T navy() {
        color = color(0, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T olive() {
        color = color(128, 128, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T orange() {
        color = color(255, 165, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T purple() {
        color = color(128, 0, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T red() {
        color = color(255, 0, 0);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T silver() {
        color = color(192, 192, 192);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T teal() {
        color = color(0, 128, 128);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T white() {
        color = color(255, 255, 255);

        // Chainable API
        return chain();
    }

    /** The color keyword. */
    public final T yellow() {
        color = color(255, 255, 0);

        // Chainable API
        return chain();
    }

}
