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
 * @version 2014/11/13 14:25:26
 */
public class FlexboxTest extends StyleTester {

    @Test
    public void flex() {
        ValidatableStyle parsed = style(() -> {
            display.flex().direction.row().alignContent.center();
        });
        assert parsed.property("display", "flex");
        assert parsed.property("flex-direction", "row");
        assert parsed.property("align-content", "center");
    }

    @Test
    public void item() {
        ValidatableStyle parsed = style(() -> {
            flexItem.grow(2).shrink(2);
        });
        assert parsed.property("flex-grow", "2");
        assert parsed.property("flex-shrink", "2");
        assert parsed.property("-webkit-flex-grow", "2");
        assert parsed.property("-webkit-flex-shrink", "2");
    }
}
