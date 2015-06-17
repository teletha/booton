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

import jsx.style.StyleTester;
import jsx.style.value.Numeric;

import org.junit.Test;

/**
 * @version 2014/11/13 14:36:39
 */
public class PaddingTest extends StyleTester {

    @Test
    public void each() {
        ValidatableStyle parsed = style(() -> {
            padding.top(10, em);
            padding.bottom(20, px);
            padding.left(30, percent);
            padding.right(new Numeric(10, ex));
        });
        assert parsed.property("padding-top", "10em");
        assert parsed.property("padding-bottom", "20px");
        assert parsed.property("padding-left", "30%");
        assert parsed.property("padding-right", "10ex");
    }

    @Test
    public void auto() {
        ValidatableStyle parsed = style(() -> {
            padding.auto();
        });
        assert parsed.property("padding-left", "auto");
        assert parsed.property("padding-right", "auto");
    }

    @Test
    public void shorthand() {
        ValidatableStyle parsed = style(() -> {
            padding.horizontal(1, em);
        });
        assert parsed.property("padding-left", "1em");
        assert parsed.property("padding-right", "1em");

        parsed = style(() -> {
            padding.vertical(1, em);
        });
        assert parsed.property("padding-top", "1em");
        assert parsed.property("padding-bottom", "1em");

        parsed = style(() -> {
            padding.size(1, em);
        });
        assert parsed.property("padding-left", "1em");
        assert parsed.property("padding-right", "1em");
        assert parsed.property("padding-top", "1em");
        assert parsed.property("padding-bottom", "1em");
    }
}
