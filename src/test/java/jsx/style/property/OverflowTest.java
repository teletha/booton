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
 * @version 2014/11/15 10:43:44
 */
public class OverflowTest extends StyleTester {

    @Test
    public void normal() throws Exception {
        ValidatableStyle style = style(() -> {
            overflow.hidden();
        });
        assert style.property("overflow", "hidden");
    }

    @Test
    public void x() throws Exception {
        ValidatableStyle style = style(() -> {
            overflow.x.scroll();
        });

        assert style.property("overflow-x", "scroll");
    }

    @Test
    public void y() throws Exception {
        ValidatableStyle style = style(() -> {
            overflow.y.visible();
        });

        assert style.property("overflow-y", "visible");
    }

    @Test
    public void xy() throws Exception {
        ValidatableStyle style = style(() -> {
            overflow.x.auto().y.hidden();
        });

        assert style.property("overflow-x", "auto");
        assert style.property("overflow-y", "hidden");
    }
}