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
public class PointerEventsTest extends StyleDeclarationTestBase {

    @Test
    public void none() {
        ValidatableStyleRule parsed = parse(MyStyle.none).rule();
        assert parsed.property("pointer-events", "none");
    }

    /**
     * @version 2014/10/29 10:59:51
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass none = () -> {
            pointerEvents.none();
        };
    }
}
