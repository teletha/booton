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

/**
 * @version 2014/11/13 15:56:01
 */
public class DisplayTest extends StyleTester {

    @Test
    public void block() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.block();
        });
        assert style.property("display", "block");
    }

    @Test
    public void inline() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.inline();
        });
        assert style.property("display", "inline");
    }

    @Test
    public void inlineBlock() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.inlineBlock();
        });
        assert style.property("display", "inline-block");
    }

    @Test
    public void flex() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.flex();
        });
        assert style.property("display", "flex", "-webkit-flex");
    }

    @Test
    public void inlineFlex() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.inlineFlex();
        });
        assert style.property("display", "inline-flex", "-webkit-inline-flex");
    }
}
