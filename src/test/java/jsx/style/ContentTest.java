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
 * @version 2014/11/13 14:23:53
 */
public class ContentTest extends StyleTester {

    @Test
    public void rgb() {
        ValidatableStyle parsed = style(() -> {
            content.text("test");
        });
        assert parsed.property("content", "'test'");

        parsed = style(() -> {
            content.attr("href");
        });
        assert parsed.property("content", "attr(href)");
    }
}
