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
 * @version 2014/11/13 15:24:30
 */
public class VisibilityTest extends StyleTester {

    @Test
    public void visibility() {
        ValidatableStyle parsed = writeStyle(() -> {
            visibility.collapse();
        });
        assert parsed.property("visibility", "collapse");

        parsed = writeStyle(() -> {
            visibility.hidden();
        });
        assert parsed.property("visibility", "hidden");

        parsed = writeStyle(() -> {
            visibility.visible();
        });
        assert parsed.property("visibility", "visible");
    }
}
