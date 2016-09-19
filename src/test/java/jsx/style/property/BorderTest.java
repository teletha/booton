/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import org.junit.Test;

import jsx.style.StyleTester;
import jsx.style.value.Color;

/**
 * @version 2015/09/09 14:39:13
 */
public class BorderTest extends StyleTester {

    @Test
    public void top() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.top.solid().color(Color.Black).width(1, px);
        });
        assert parsed.property("border-top", "solid black 1px");
    }

    @Test
    public void bottom() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.bottom.width(1, px).doubles();
        });
        assert parsed.property("border-bottom", "1px double");
    }

    @Test
    public void left() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.left.width(1, px).dashed();
        });
        assert parsed.property("border-left", "1px dashed");
    }

    @Test
    public void right() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.right.groove().width(1, px);
        });
        assert parsed.property("border-right", "groove 1px");
    }

    @Test
    public void all() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.color(Color.White).solid().width(1, px);
        });
        assert parsed.property("border", "white solid 1px");
    }

    @Test
    public void allWidth() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.width(2, px);
        });
        assert parsed.property("border", "2px");
    }

    @Test
    public void allStyle() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.solid();
        });
        assert parsed.property("border", "solid");
    }

    @Test
    public void allColor() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.color(Color.White);
        });
        assert parsed.property("border", "white");
    }

    @Test
    public void vertical() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.vertical.width(1, em).inset();
        });
        assert parsed.property("border-top", "1em inset");
        assert parsed.property("border-bottom", "1em inset");
    }

    @Test
    public void horizontal() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.horizontal.width(1, ex).outset();
        });
        assert parsed.property("border-right", "1ex outset");
        assert parsed.property("border-left", "1ex outset");
    }

    @Test
    public void radius() {
        ValidatableStyle parsed = writeStyle(() -> {
            border.top.radius(1, px);
        });
        assert parsed.property("border-top-right-radius", "1px");
    }
}
