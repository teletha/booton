/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import org.junit.Test;

/**
 * @version 2014/11/13 14:27:27
 */
public class HoverTest extends StyleTester {

    @Test
    public void hover() {
        ValidatableStyle parsed = style(() -> {
            font.color(255, 0, 0);

            hover(() -> {
                font.color(0, 255, 0);
            });
        });
        assert parsed.property("color", "rgb(255,0,0)");

        ValidatableStyle hover = parsed.sub("hover");
        assert hover.property("color", "rgb(0,255,0)");
    }

    @Test
    public void after() {
        ValidatableStyle parsed = style(() -> {
            font.color(255, 255, 0);

            after(() -> {
                font.color(0, 255, 0);

                hover(() -> {
                    font.color(0, 0, 0);
                });
            });
        });
        assert parsed.property("color", "rgb(255,255,0)");

        ValidatableStyle after = parsed.sub("after");
        assert after.property("color", "rgb(0,255,0)");

        ValidatableStyle afterHover = parsed.sub("hover::after");
        assert afterHover.property("color", "rgb(0,0,0)");
    }
}
