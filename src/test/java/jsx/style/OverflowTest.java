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
 * @version 2014/10/29 12:52:17
 */
public class OverflowTest extends StyleDeclarationTestBase {

    @Test
    public void main() {
        ValidatableStyleRule parsed = parse(MyStyle.both).rule();
        assert parsed.property("overflow", "hidden");

        parsed = parse(MyStyle.each).rule();
        assert parsed.property("overflow-x", "scroll");
        assert parsed.property("overflow-y", "auto");
    }

    /**
     * @version 2014/10/29 10:59:51
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style both = () -> {
            overflow.hidden();
        };

        private static Style each = () -> {
            overflow.x.scroll();
            overflow.y.auto();
        };
    }
}
