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

import static booton.css.Unit.*;

import org.junit.Test;

/**
 * @version 2014/10/27 10:07:57
 */
public class PositionTest extends StyleDeclarationTestBase {

    @Test
    public void relative() {
        ValidatableStyleRule parsed = parse(MyStyle.relative).rule();
        assert parsed.property("position", "relative");
    }

    @Test
    public void absolute() {
        ValidatableStyleRule parsed = parse(MyStyle.absolute).rule();
        assert parsed.property("position", "absolute");
    }

    @Test
    public void fixed() {
        ValidatableStyleRule parsed = parse(MyStyle.fixed).rule();
        assert parsed.property("position", "fixed");
    }

    @Test
    public void position() {
        ValidatableStyleRule parsed = parse(MyStyle.location).rule();
        assert parsed.property("top", "1px");
        assert parsed.property("right", "2px");
        assert parsed.property("bottom", "3px");
        assert parsed.property("left", "4px");
    }

    /**
     * @version 2014/10/21 13:43:25
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style relative = () -> {
            position.relative();

            assert position.isRelative() == true;
            assert position.isAbsolute() == false;
        };

        private static Style absolute = () -> {
            position.absolute();

            assert position.isRelative() == false;
            assert position.isAbsolute() == true;
        };

        private static Style fixed = () -> {
            position.fixed();

            assert position.isRelative() == false;
            assert position.isAbsolute() == false;
        };

        private static Style location = () -> {
            position.top(1, px).right(2, px).bottom(3, px).left(4, px);
        };
    }
}
