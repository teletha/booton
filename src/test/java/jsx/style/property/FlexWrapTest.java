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
 * @version 2014/11/15 10:30:57
 */
public class FlexWrapTest extends StyleTester {

    @Test
    public void noWrap() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().wrap.disable();
        });

        assert style.property("flex-wrap", "nowrap");
        assert style.property("-webkit-flex-wrap", "nowrap");
    }

    @Test
    public void wrap() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().wrap.enable();
        });
        assert style.property("flex-wrap", "wrap");
        assert style.property("-webkit-flex-wrap", "wrap");
    }

    @Test
    public void wrapReverse() throws Exception {
        ValidatableStyle style = style(() -> {
            display.flex().wrap.reverse();
        });

        assert style.property("flex-wrap", "wrap-reverse");
        assert style.property("-webkit-flex-wrap", "wrap-reverse");
    }
}
