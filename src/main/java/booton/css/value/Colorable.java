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
import js.util.Color;

/**
 * @version 2013/07/20 4:49:14
 */
public interface Colorable<T extends CSSProperty> {

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
    public T color(int red, int green, int blue);

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
    public T color(int red, int green, int blue, double alpha);

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
     * @return
     */
    public T color(Color color);

    /**
     * <p>
     * Retrieve the configured color.
     * </p>
     */
    public Color color();
}
