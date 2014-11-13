/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import jsx.style.StyleTester;

import org.junit.Test;

/**
 * @version 2014/11/13 15:53:30
 */
public class ColorTest extends StyleTester {

    @Test
    public void white() throws Exception {
        ValidatableStyle style = style(() -> {
            font.color(255, 255, 255);
        });
        assert style.property("color", "white");
    }

    @Test
    public void black() throws Exception {
        ValidatableStyle style = style(() -> {
            font.color(0, 0, 0);
        });
        assert style.property("color", "black");
    }

    @Test
    public void hsl() throws Exception {
        ValidatableStyle style = style(() -> {
            font.color(255, 0, 0);
        });
        assert style.property("color", "hsl(0,100%,50%)");
    }

    @Test
    public void hsla() throws Exception {
        ValidatableStyle style = style(() -> {
            font.color(255, 255, 255, 0.9);
        });
        assert style.property("color", "hsla(0,0%,100%,0.9)");
    }

    @Test
    public void zeroAlpha() throws Exception {
        ValidatableStyle style = style(() -> {
            font.color(255, 255, 255, 0);
        });
        assert style.property("color", "hsla(0,0%,100%,0)");
    }
}
