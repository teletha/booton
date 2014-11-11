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
 * @version 2014/10/29 10:13:51
 */
public class BorderTest extends StyleDeclarationTestBase {

    @Test
    public void singleSide() {
        ValidatableStyleRule parsed = parse(MyStyle.top).rule();
        assert parsed.property("border-top-width", "1px");
        assert parsed.property("border-top-style", "solid");
        assert parsed.property("border-top-color", "rgb(0,0,0)");

        parsed = parse(MyStyle.bottom).rule();
        assert parsed.property("border-bottom-width", "1px");
        assert parsed.property("border-bottom-style", "double");

        parsed = parse(MyStyle.left).rule();
        assert parsed.property("border-left-width", "1px");
        assert parsed.property("border-left-style", "dashed");

        parsed = parse(MyStyle.right).rule();
        assert parsed.property("border-right-width", "1px");
        assert parsed.property("border-right-style", "groove");
    }

    @Test
    public void all() {
        ValidatableStyleRule parsed = parse(MyStyle.all).rule();
        assert parsed.property("border-top-width", "2px");
        assert parsed.property("border-bottom-width", "2px");
        assert parsed.property("border-right-width", "2px");
        assert parsed.property("border-left-width", "2px");
    }

    @Test
    public void radius() {
        ValidatableStyleRule parsed = parse(MyStyle.radius).rule();
        assert parsed.property("border-top-right-radius", "1px");
        assert parsed.property("border-top-left-radius", "1px");
    }

    /**
     * @version 2014/10/29 10:35:21
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style top = () -> {
            border.top.width(1, px).solid().color(rgb(0, 0, 0));
        };

        private static Style bottom = () -> {
            border.bottom.width(1, px).doubles();
        };

        private static Style left = () -> {
            border.left.width(1, px).dashed();
        };

        private static Style right = () -> {
            border.right.width(1, px).groove();
        };

        private static Style all = () -> {
            border.width(2, px);
        };

        private static Style radius = () -> {
            border.top.radius(1, px);
        };
    }
}
