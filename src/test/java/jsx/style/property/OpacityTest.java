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
 * @version 2014/11/15 10:32:10
 */
public class OpacityTest extends StyleTester {

    @Test
    public void point() throws Exception {
        ValidatableStyle style = style(() -> {
            box.opacity(0.5);
        });

        assert style.property("opacity", "0.5");
    }

    @Test
    public void one() throws Exception {
        ValidatableStyle style = style(() -> {
            box.opacity(1);
        });

        assert style.property("opacity", "1");
    }

    @Test
    public void zero() throws Exception {
        ValidatableStyle style = style(() -> {
            box.opacity(0);
        });

        assert style.property("opacity", "0");
    }
}
