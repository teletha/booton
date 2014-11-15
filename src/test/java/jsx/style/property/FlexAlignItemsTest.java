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
 * @version 2014/11/15 10:16:03
 */
public class FlexAlignItemsTest extends StyleTester {

    @Test
    public void start() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().alignItems.start();
        });

        assert style.property("align-items", "flex-start");
        assert style.property("-webkit-align-items", "flex-start");
    }

    @Test
    public void end() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().alignItems.end();
        });

        assert style.property("align-items", "flex-end");
        assert style.property("-webkit-align-items", "flex-end");
    }

    @Test
    public void center() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().alignItems.center();
        });

        assert style.property("align-items", "center");
        assert style.property("-webkit-align-items", "center");
    }

    @Test
    public void baseline() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().alignItems.baseline();
        });

        assert style.property("align-items", "baseline");
        assert style.property("-webkit-align-items", "baseline");
    }

    @Test
    public void stretch() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().alignItems.stretch();
        });

        assert style.property("align-items", "stretch");
        assert style.property("-webkit-align-items", "stretch");
    }
}
