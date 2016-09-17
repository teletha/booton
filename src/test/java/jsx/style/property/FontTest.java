/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import org.junit.Test;

import jsx.style.StyleTester;
import jsx.style.value.Font;

/**
 * @version 2014/11/13 14:26:07
 */
public class FontTest extends StyleTester {

    @Test
    public void rgb() {
        ValidatableStyle parsed = style(() -> {
            font.color(255, 0, 0);
        });
        assert parsed.property("color", "rgb(255,0,0)");
    }

    @Test
    public void family() {
        ValidatableStyle parsed = style(() -> {
            font.family("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600", Font.Serif);
        });
        assert parsed.property("font-family", "\"Source Sans Pro\",serif");
    }
}
