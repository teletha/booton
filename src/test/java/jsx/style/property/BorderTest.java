/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.StyleTester;

import org.junit.Test;

/**
 * @version 2014/11/13 14:19:33
 */
public class BorderTest extends StyleTester {

    @Test
    public void singleSide() {
        ValidatableStyle parsed = style(() -> {
            border.top.width(1, px).solid().color(rgb(0, 0, 0));
        });
        assert parsed.property("border-top-width", "1px");
        assert parsed.property("border-top-style", "solid");
        assert parsed.property("border-top-color", "rgb(0,0,0)");

        parsed = style(() -> {
            border.bottom.width(1, px).doubles();
        });
        assert parsed.property("border-bottom-width", "1px");
        assert parsed.property("border-bottom-style", "double");

        parsed = style(() -> {
            border.left.width(1, px).dashed();
        });
        assert parsed.property("border-left-width", "1px");
        assert parsed.property("border-left-style", "dashed");

        parsed = style(() -> {
            border.right.width(1, px).groove();
        });
        assert parsed.property("border-right-width", "1px");
        assert parsed.property("border-right-style", "groove");
    }

    @Test
    public void all() {
        ValidatableStyle parsed = style(() -> {
            border.width(2, px);
        });
        assert parsed.property("border-top-width", "2px");
        assert parsed.property("border-bottom-width", "2px");
        assert parsed.property("border-right-width", "2px");
        assert parsed.property("border-left-width", "2px");
    }

    @Test
    public void radius() {
        ValidatableStyle parsed = style(() -> {
            border.top.radius(1, px);
        });
        assert parsed.property("border-top-right-radius", "1px");
        assert parsed.property("border-top-left-radius", "1px");
    }
}
