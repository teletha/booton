/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.layout;

/**
 * @version 2014/09/10 16:10:45
 */
public class Length {

    public final Var min;

    public final Var max;

    /**
     * @param min
     * @param max
     */
    private Length(Var min, Var max) {
        this.min = min;
        this.max = max;
    }

    public static Length of(Var value) {
        return of(value, value);
    }

    public static Length of(Var min, Var max) {
        return new Length(min, max);
    }
}
