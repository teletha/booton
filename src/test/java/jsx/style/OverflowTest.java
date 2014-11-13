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
 * @version 2014/11/13 14:35:29
 */
public class OverflowTest extends StyleTester {

    @Test
    public void main() {
        ValidatableStyle parsed = style(() -> {
            overflow.hidden();
        });
        assert parsed.property("overflow", "hidden");

        parsed = style(() -> {
            overflow.x.scroll();
            overflow.y.auto();
        });
        assert parsed.property("overflow-x", "scroll");
        assert parsed.property("overflow-y", "auto");
    }
}
