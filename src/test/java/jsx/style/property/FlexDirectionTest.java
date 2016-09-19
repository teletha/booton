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
 * @version 2014/11/15 10:25:04
 */
public class FlexDirectionTest extends StyleTester {

    @Test
    public void row() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.flex().direction.row();
        });

        assert style.property("flex-direction", "row");
        assert style.property("-webkit-flex-direction", "row");
    }

    @Test
    public void rowReverse() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.flex().direction.rowReverse();
        });

        assert style.property("flex-direction", "row-reverse");
        assert style.property("-webkit-flex-direction", "row-reverse");
    }

    @Test
    public void colmun() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.flex().direction.column();
        });

        assert style.property("flex-direction", "column");
        assert style.property("-webkit-flex-direction", "column");
    }

    @Test
    public void colmunReverse() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.flex().direction.columnReverse();
        });

        assert style.property("flex-direction", "column-reverse");
        assert style.property("-webkit-flex-direction", "column-reverse");
    }
}
