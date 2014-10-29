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
 * @version 2014/10/29 10:59:54
 */
public class ContentTest extends StyleDeclarationTestBase {

    @Test
    public void rgb() {
        ValidatableStyleRule parsed = parse(MyStyle.text).rule();
        assert parsed.property("content", "'test'");

        parsed = parse(MyStyle.attr).rule();
        assert parsed.property("content", "attr(href)");
    }

    /**
     * @version 2014/10/29 10:59:51
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style text = () -> {
            content.text("test");
        };

        private static Style attr = () -> {
            content.attr("href");
        };
    }
}
