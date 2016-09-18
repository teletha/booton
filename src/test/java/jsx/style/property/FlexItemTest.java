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

import org.junit.Test;

import jsx.style.StyleTester;

/**
 * @version 2014/11/15 10:26:53
 */
public class FlexItemTest extends StyleTester {

    @Test
    public void grow() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            flexItem.grow(2);
        });

        assert style.property("flex-grow", "2");
        assert style.property("-webkit-flex-grow", "2");
    }

    @Test
    public void shrink() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            flexItem.shrink(2);
        });

        assert style.property("flex-shrink", "2");
        assert style.property("-webkit-flex-shrink", "2");
    }

    @Test
    public void order() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            flexItem.order(2);
        });

        assert style.property("order", "2");
        assert style.property("-webkit-order", "2");
    }
}
