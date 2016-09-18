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
 * @version 2014/11/13 14:23:53
 */
public class ContentTest extends StyleTester {

    @Test
    public void rgb() {
        ValidatableStyle parsed = writeStyle(() -> {
            content.text("test");
        });
        assert parsed.property("content", "'test'");

        parsed = writeStyle(() -> {
            content.attr("href");
        });
        assert parsed.property("content", "attr(href)");
    }
}
