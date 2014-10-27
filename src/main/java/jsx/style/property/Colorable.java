/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;
import booton.css.value.Color;

/**
 * @version 2013/07/23 12:40:12
 */
public abstract class Colorable<T extends Colorable> extends PropertyDefinition<T> {

    /** The stored color. */
    protected Color color;

    /**
     * 
     */
    protected Colorable() {
        super();
    }

    /**
     * @param name
     * @param context
     */
    protected Colorable(String name, T context) {
        super(name, context);
    }

    /**
     * <p>
     * Retrieve the configured color.
     * </p>
     */
    public Color color() {
        return color;
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
     * @param color
     * @return Chainable API.
     */
    public T color(Color color) {
        declarable.property("color", color.toString());

        return (T) this;
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
     * @return Chainable API.
     */
    public T color(int red, int green, int blue) {
        return color(Color.rgb(red, green, blue));
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
     * @return Chainable API.
     */
    public T color(int red, int green, int blue, double alpha) {
        return color(Color.rgba(red, green, blue, alpha));
    }
}
