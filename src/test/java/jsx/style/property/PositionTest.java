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

import org.junit.Test;

/**
 * @version 2014/11/13 14:41:06
 */
public class PositionTest extends StyleTester {

    @Test
    public void relative() {
        ValidatableStyle parsed = style(() -> {
            position.relative();

            assert position.isRelative() == true;
            assert position.isAbsolute() == false;
        });
        assert parsed.property("position", "relative");
    }

    @Test
    public void absolute() {
        ValidatableStyle parsed = style(() -> {
            position.absolute();

            assert position.isRelative() == false;
            assert position.isAbsolute() == true;
        });
        assert parsed.property("position", "absolute");
    }

    @Test
    public void fixed() {
        ValidatableStyle parsed = style(() -> {
            position.fixed();

            assert position.isRelative() == false;
            assert position.isAbsolute() == false;
        });
        assert parsed.property("position", "fixed");
    }

    @Test
    public void position() {
        ValidatableStyle parsed = style(() -> {
            position.top(1, px).right(2, px).bottom(3, px).left(4, px);
        });
        assert parsed.property("top", "1px");
        assert parsed.property("right", "2px");
        assert parsed.property("bottom", "3px");
        assert parsed.property("left", "4px");
    }
}
