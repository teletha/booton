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
 * @version 2014/10/28 18:02:01
 */
public class TextTest extends StyleTester {

    @Test
    public void indent() {
        ValidatableStyle parsed = style(() -> {
            text.indent(3, em);
        });
        assert parsed.property("text-indent", "3em");
    }

    @Test
    public void align() {
        ValidatableStyle parsed = style(() -> {
            text.align.center().verticalAlign.bottom();
        });
        assert parsed.property("text-align", "center");
        assert parsed.property("vertical-align", "bottom");
    }

    @Test
    public void decoration() {
        ValidatableStyle parsed = style(() -> {
            text.decoration.underline();
        });
        assert parsed.property("text-decoration", "underline");
    }

    @Test
    public void overflow() {
        ValidatableStyle parsed = style(() -> {
            text.overflow.ellipsis();
        });
        assert parsed.property("text-overflow", "ellipsis");
    }

    @Test
    public void unselectable() {
        ValidatableStyle parsed = style(() -> {
            text.unselectable();
        });
        assert parsed.property("user-select", "none");
        assert parsed.property("-moz-user-select", "none");
        assert parsed.property("-ms-user-select", "none");
        assert parsed.property("-webkit-user-select", "none");
        assert parsed.property("cursor", "default");

        ValidatableStyle selection = parsed.sub("selection");
        assert selection.property("background-color", "transparent");
    }

    @Test
    public void shadowSingle() {
        ValidatableStyle parsed = style(() -> {
            text.shadow(shadow().offset(2, 2, px).blurRadius(1, px).color(hsl(100, 100, 100)));
        });
        assert parsed.property("text-shadow", "2px 2px 1px hsl(100,100%,100%)");
    }

    @Test
    public void shadowMultiple() {
        ValidatableStyle parsed = style(() -> {
            text.shadow(shadow().offset(2, 2, px), shadow().offset(1, 1, px));
        });
        assert parsed.property("text-shadow", "2px 2px,1px 1px");
    }
}
