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
 * @version 2014/10/28 16:24:43
 */
public class VisibilityTest extends StyleDeclarationTestBase {

    @Test
    public void visibility() {
        ValidatableStyleRule parsed = parse(MyStyle.collapse).rule();
        assert parsed.property("visibility", "collapse");

        parsed = parse(MyStyle.hidden).rule();
        assert parsed.property("visibility", "hidden");

        parsed = parse(MyStyle.visible).rule();
        assert parsed.property("visibility", "visible");
    }

    /**
     * @version 2014/10/28 16:24:49
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass collapse = () -> {
            visibility.collapse();
        };

        private static StyleClass hidden = () -> {
            visibility.hidden();
        };

        private static StyleClass visible = () -> {
            visibility.visible();
        };
    }
}
