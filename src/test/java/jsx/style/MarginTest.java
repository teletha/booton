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

import jsx.style.value.Numeric;

import org.junit.Test;

/**
 * @version 2014/10/28 15:25:05
 */
public class MarginTest extends StyleDeclarationTestBase {

    @Test
    public void each() {
        ValidatableStyleRule parsed = parse(MyStyle.each).rule();
        assert parsed.property("margin-top", "10em");
        assert parsed.property("margin-bottom", "20px");
        assert parsed.property("margin-left", "30%");
        assert parsed.property("margin-right", "10ex");
    }

    @Test
    public void auto() {
        ValidatableStyleRule parsed = parse(MyStyle.auto).rule();
        assert parsed.property("margin-left", "auto");
        assert parsed.property("margin-right", "auto");
    }

    @Test
    public void shorthand() {
        ValidatableStyleRule parsed = parse(MyStyle.horizontal).rule();
        assert parsed.property("margin-left", "1em");
        assert parsed.property("margin-right", "1em");

        parsed = parse(MyStyle.vertical).rule();
        assert parsed.property("margin-top", "1em");
        assert parsed.property("margin-bottom", "1em");

        parsed = parse(MyStyle.size).rule();
        assert parsed.property("margin-left", "1em");
        assert parsed.property("margin-right", "1em");
        assert parsed.property("margin-top", "1em");
        assert parsed.property("margin-bottom", "1em");
    }

    /**
     * @version 2014/10/28 15:33:34
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style each = () -> {
            margin.top(10, em);
            margin.bottom(20, px);
            margin.left(30, percent);
            margin.right(new Numeric(10, ex));
        };

        private static Style auto = () -> {
            margin.auto();
        };

        private static Style horizontal = () -> {
            margin.horizontal(1, em);
        };

        private static Style vertical = () -> {
            margin.vertical(1, em);
        };

        private static Style size = () -> {
            margin.size(1, em);
        };
    }
}
