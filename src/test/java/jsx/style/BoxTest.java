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
 * @version 2014/11/13 14:23:13
 */
public class BoxTest extends StyleTester {

    @Test
    public void width() {
        ValidatableStyle parsed = style(() -> {
            box.width(7, px).minWidth(5, px).maxWidth(10, px);
        });
        assert parsed.property("width", "7px");
        assert parsed.property("min-width", "5px");
        assert parsed.property("max-width", "10px");
    }

    @Test
    public void height() {
        ValidatableStyle parsed = style(() -> {
            box.height(7, px).minHeight(5, px).maxHeight(10, px);
        });
        assert parsed.property("height", "7px");
        assert parsed.property("min-height", "5px");
        assert parsed.property("max-height", "10px");
    }

    @Test
    public void size() {
        ValidatableStyle parsed = style(() -> {
            box.size(10, px);
        });
        assert parsed.property("width", "10px");
        assert parsed.property("height", "10px");
    }

    @Test
    public void opacity() {
        ValidatableStyle parsed = style(() -> {
            box.opacity(0.5);
        });
        assert parsed.property("opacity", "0.5");
    }

    @Test
    public void zIndex() {
        ValidatableStyle parsed = style(() -> {
            box.zIndex(2);
        });
        assert parsed.property("z-index", "2");
    }

    @Test
    public void shadowSingle() {
        ValidatableStyle parsed = style(() -> {
            box.shadow(shadow().offset(2, 2, px).blurRadius(1, px).color(hsl(100, 100, 100)));
        });
        assert parsed.property("box-shadow", "2px 2px 1px hsl(100,100%,100%)");
    }

    @Test
    public void shadowMultiple() {
        ValidatableStyle parsed = style(() -> {
            box.shadow(shadow().offset(2, 2, px), shadow().offset(1, 1, px));
        });
        assert parsed.property("box-shadow", "2px 2px,1px 1px");
    }
}
