/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/11/13 15:24:30
 */
public class VisibilityTest extends StyleTester {

    @Test
    public void visibility() {
        ValidatableStyle parsed = style(() -> {
            visibility.collapse();
        });
        assert parsed.property("visibility", "collapse");

        parsed = style(() -> {
            visibility.hidden();
        });
        assert parsed.property("visibility", "hidden");

        parsed = style(() -> {
            visibility.visible();
        });
        assert parsed.property("visibility", "visible");
    }
}
