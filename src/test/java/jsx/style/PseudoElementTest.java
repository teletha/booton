/*
 * Copyright (C) 2016 Nameless Production Committee
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
 * @version 2014/11/15 12:59:49
 */
public class PseudoElementTest extends StyleTester {

    @Test
    public void before() {
        ValidatableStyle parsed = writeStyle(() -> {
            font.color(255, 255, 0);

            before(() -> {
                font.color(0, 255, 0);

                hover(() -> {
                    font.color(0, 0, 0);
                });
            });
        });
        assert parsed.property("color", "rgb(255,255,0)");

        ValidatableStyle before = parsed.sub("before");
        assert before.property("color", "rgb(0,255,0)");

        ValidatableStyle beforeHover = parsed.sub("hover::before");
        assert beforeHover.property("color", "rgb(0,0,0)");
    }

    @Test
    public void after() {
        ValidatableStyle parsed = writeStyle(() -> {
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

    @Test
    public void text() {
        ValidatableStyle style = writeStyle(() -> {
            firstLetter(() -> {
                display.inline();
            });

            firstLine(() -> {
                display.inline();
            });
        });

        assert style.sub("first-letter").property("display", "inline");
        assert style.sub("first-line").property("display", "inline");
    }

    @Test
    public void selection() {
        ValidatableStyle style = writeStyle(() -> {
            selection(() -> {
                display.inline();
            });
        });
        assert style.sub("-moz-selection").property("display", "inline");
    }

}
