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
public class PaddingTest extends StyleDeclarationTestBase {

    @Test
    public void each() {
        ValidatableStyleRule parsed = parse(MyStyle.each).rule();
        assert parsed.property("padding-top", "10em");
        assert parsed.property("padding-bottom", "20px");
        assert parsed.property("padding-left", "30%");
        assert parsed.property("padding-right", "10ex");
    }

    @Test
    public void auto() {
        ValidatableStyleRule parsed = parse(MyStyle.auto).rule();
        assert parsed.property("padding-left", "auto");
        assert parsed.property("padding-right", "auto");
    }

    @Test
    public void shorthand() {
        ValidatableStyleRule parsed = parse(MyStyle.horizontal).rule();
        assert parsed.property("padding-left", "1em");
        assert parsed.property("padding-right", "1em");

        parsed = parse(MyStyle.vertical).rule();
        assert parsed.property("padding-top", "1em");
        assert parsed.property("padding-bottom", "1em");

        parsed = parse(MyStyle.size).rule();
        assert parsed.property("padding-left", "1em");
        assert parsed.property("padding-right", "1em");
        assert parsed.property("padding-top", "1em");
        assert parsed.property("padding-bottom", "1em");
    }

    /**
     * @version 2014/10/28 15:33:28
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass each = () -> {
            padding.top(10, em);
            padding.bottom(20, px);
            padding.left(30, percent);
            padding.right(new Numeric(10, ex));
        };

        private static StyleClass auto = () -> {
            padding.auto();
        };

        private static StyleClass horizontal = () -> {
            padding.horizontal(1, em);
        };

        private static StyleClass vertical = () -> {
            padding.vertical(1, em);
        };

        private static StyleClass size = () -> {
            padding.size(1, em);
        };
    }
}
