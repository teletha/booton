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
 * @version 2014/10/28 18:02:01
 */
public class TextTest extends StyleDeclarationTestBase {

    @Test
    public void indent() {
        ValidatableStyleRule parsed = parse(MyStyle.indent).rule();
        assert parsed.property("text-indent", "3em");
    }

    @Test
    public void align() {
        ValidatableStyleRule parsed = parse(MyStyle.align).rule();
        assert parsed.property("text-align", "center");
        assert parsed.property("vertical-align", "bottom");
    }

    @Test
    public void decoration() {
        ValidatableStyleRule parsed = parse(MyStyle.decoration).rule();
        assert parsed.property("text-decoration", "underline");
    }

    @Test
    public void overflow() {
        ValidatableStyleRule parsed = parse(MyStyle.overflow).rule();
        assert parsed.property("text-overflow", "ellipsis");
    }

    @Test
    public void unselectable() {
        ValidatableStyleRule parsed = parse(MyStyle.unselectable).rule();
        assert parsed.property("user-select", "none");
        assert parsed.property("-moz-user-select", "none");
        assert parsed.property("-ms-user-select", "none");
        assert parsed.property("-webkit-user-select", "none");
        assert parsed.property("cursor", "default");

        ValidatableStyleRule selection = parsed.sub("selection");
        assert selection.property("background-color", "transparent");
    }

    @Test
    public void shadow() {
        ValidatableStyleRule parsed = parse(MyStyle.shadow).rule();
        assert parsed.property("text-shadow", "2px 2px 1px hsl(100,100%,100%)");
    }

    @Test
    public void shadows() {
        ValidatableStyleRule parsed = parse(MyStyle.shadows).rule();
        assert parsed.property("text-shadow", "2px 2px,1px 1px");
    }

    /**
     * @version 2014/10/28 18:01:53
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass indent = () -> {
            text.indent(3, em);
        };

        private static StyleClass align = () -> {
            text.align.center().verticalAlign.bottom();
        };

        private static StyleClass decoration = () -> {
            text.decoration.underline();
        };

        private static StyleClass overflow = () -> {
            text.overflow.ellipsis();
        };

        private static StyleClass unselectable = () -> {
            text.unselectable();
        };

        private static StyleClass shadow = () -> {
            text.shadow(shadow().offset(2, 2, px).blurRadius(1, px).color(hsl(100, 100, 100)));
        };

        private static StyleClass shadows = () -> {
            text.shadow(shadow().offset(2, 2, px), shadow().offset(1, 1, px));
        };
    }
}
