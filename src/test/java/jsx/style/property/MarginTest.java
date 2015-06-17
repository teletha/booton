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
 * @version 2014/11/13 14:28:51
 */
public class MarginTest extends StyleTester {

    @Test
    public void each() {
        ValidatableStyle parsed = style(() -> {
            margin.top(10, em);
            margin.bottom(20, px);
            margin.left(30, percent);
            margin.right(new Numeric(10, ex));
        });
        assert parsed.property("margin-top", "10em");
        assert parsed.property("margin-bottom", "20px");
        assert parsed.property("margin-left", "30%");
        assert parsed.property("margin-right", "10ex");
    }

    @Test
    public void auto() {
        ValidatableStyle parsed = style(() -> {
            margin.auto();
        });
        assert parsed.property("margin-left", "auto");
        assert parsed.property("margin-right", "auto");
    }

    @Test
    public void shorthand() {
        ValidatableStyle parsed = style(() -> {
            margin.horizontal(1, em);
        });
        assert parsed.property("margin-left", "1em");
        assert parsed.property("margin-right", "1em");

        parsed = style(() -> {
            margin.vertical(1, em);
        });
        assert parsed.property("margin-top", "1em");
        assert parsed.property("margin-bottom", "1em");

        parsed = style(() -> {
            margin.size(1, em);
        });
        assert parsed.property("margin-left", "1em");
        assert parsed.property("margin-right", "1em");
        assert parsed.property("margin-top", "1em");
        assert parsed.property("margin-bottom", "1em");
    }

    @Test
    public void calc() {
        Numeric one = new Numeric(1, em);
        Numeric two = new Numeric(2, px);

        ValidatableStyle parsed = style(() -> {
            margin.size(one.add(two));
        });
        assert parsed.property("margin-left", "calc(1em + 2px)", "-webkit-calc(1em + 2px)");
        assert parsed.property("margin-right", "calc(1em + 2px)", "-webkit-calc(1em + 2px)");
        assert parsed.property("margin-top", "calc(1em + 2px)", "-webkit-calc(1em + 2px)");
        assert parsed.property("margin-bottom", "calc(1em + 2px)", "-webkit-calc(1em + 2px)");
    }
}
