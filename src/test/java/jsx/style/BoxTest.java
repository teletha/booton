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
public class BoxTest extends StyleDeclarationTestBase {

    @Test
    public void width() {
        ValidatableStyleRule parsed = parse(MyStyle.width).rule();
        assert parsed.property("width", "7px");
        assert parsed.property("min-width", "5px");
        assert parsed.property("max-width", "10px");
    }

    @Test
    public void height() {
        ValidatableStyleRule parsed = parse(MyStyle.height).rule();
        assert parsed.property("height", "7px");
        assert parsed.property("min-height", "5px");
        assert parsed.property("max-height", "10px");
    }

    @Test
    public void size() {
        ValidatableStyleRule parsed = parse(MyStyle.size).rule();
        assert parsed.property("width", "10px");
        assert parsed.property("height", "10px");
    }

    @Test
    public void opacity() {
        ValidatableStyleRule parsed = parse(MyStyle.opacity).rule();
        assert parsed.property("opacity", "0.5");
    }

    @Test
    public void zIndex() {
        ValidatableStyleRule parsed = parse(MyStyle.zIndex).rule();
        assert parsed.property("z-index", "2");
    }

    @Test
    public void shadow() {
        ValidatableStyleRule parsed = parse(MyStyle.shadow).rule();
        assert parsed.property("box-shadow", "2px 2px 1px hsl(100,100%,100%)");
    }

    @Test
    public void shadows() {
        ValidatableStyleRule parsed = parse(MyStyle.shadows).rule();
        assert parsed.property("box-shadow", "2px 2px,1px 1px");
    }

    /**
     * @version 2014/10/28 18:01:53
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass width = () -> {
            box.width(7, px).minWidth(5, px).maxWidth(10, px);
        };

        private static StyleClass height = () -> {
            box.height(7, px).minHeight(5, px).maxHeight(10, px);
        };

        private static StyleClass size = () -> {
            box.size(10, px);
        };

        private static StyleClass opacity = () -> {
            box.opacity(0.5);
        };

        private static StyleClass zIndex = () -> {
            box.zIndex(2);
        };

        private static StyleClass shadow = () -> {
            box.shadow(shadow().offset(2, 2, px).blurRadius(1, px).color(hsl(100, 100, 100)));
        };

        private static StyleClass shadows = () -> {
            box.shadow(shadow().offset(2, 2, px), shadow().offset(1, 1, px));
        };
    }
}
